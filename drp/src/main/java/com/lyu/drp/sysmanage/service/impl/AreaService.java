package com.lyu.drp.sysmanage.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lyu.drp.sysmanage.dto.AreaDto;
import com.lyu.drp.sysmanage.entity.Area;
import com.lyu.drp.sysmanage.entity.RoleToArea;
import com.lyu.drp.sysmanage.mapper.AreaMapper;
import com.lyu.drp.sysmanage.mapper.RoleMapper;
import com.lyu.drp.sysmanage.mapper.RoleToAreaMapper;
import com.lyu.drp.sysmanage.service.IAreaService;
import com.lyu.drp.util.UserUtils;

/**
 * 类名称: 区域服务接口的实现类
 * 类描述: 对区域服务接口的具体实现
 * 全限定性类名: com.lyu.drp.sysmanage.service.impl.AreaService
 * @author 曲健磊
 * @date 2018年2月2日 上午10:25:56
 * @version V1.0
 */
@Service("areaService")
public class AreaService implements IAreaService {
	@Autowired
	private AreaMapper areaMapper;
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private RoleToAreaMapper roleToAreaMapper;
	
	@Autowired
	private EhCacheManager cacheManager;
	
	@Override
	public AreaDto getAreaDetailById(Long id) {
		return areaMapper.getAreaDetailById(id);
	}
	
	@Override
	public List<Area> getAllAreaList() {
		return areaMapper.getAllAreaList();
	}

	@Override
	public List<Area> getAreaListByUId(Long userId) {
		List<Long> roleIds = roleMapper.getRoleIdsByUId(userId);
		List<Area> areaList = new ArrayList<Area>();
		for (Long roleId : roleIds) {
			areaList.addAll(this.areaMapper.getAreaListByRoleId(roleId));
		}
		Set<Area> uniqueAreaSet = new HashSet<Area>(areaList);
		areaList.clear();
		areaList.addAll(uniqueAreaSet);
		return areaList;
	}
	
	@Override
	public List<Area> getAllSubAreasByPId(Long pId) {
		List<Area> allSubList = new ArrayList<Area>();
		
		allSubList = this.areaMapper.getSubAreaByPId(pId);
		int size = allSubList.size();
		
		for (int i = 0; i < size; i++) {
			allSubList.addAll(this.areaMapper.getSubAreaByPId(allSubList.get(i).getId()));
		}
		
		return allSubList;
	}
	
	@Override
	public boolean hasSubArea(Long areaId) {
		boolean flag = false;
		
		int rows = areaMapper.countSubArea(areaId);
		
		if (rows > 0) {
			flag = true;
		}
		
		return flag;
	}
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public boolean saveArea(Area area) {
		boolean flag = false;
		
		if (area.getParentId() == null) { // 没有选择父部门则为顶级部门
			area.setParentId(0L);
		}
		if (area.getCode() == null) {
			area.setCode("");
		}
		if (area.getSort() == null) {
			area.setSort(0L);
		}
		if (area.getRemarks() == null) {
			area.setRemarks("");
		}
		
		area.setCreateBy(UserUtils.getCurrentUserId());
		area.setCreateDate(new Date());
		area.setUpdateBy(UserUtils.getCurrentUserId());
		area.setUpdateDate(new Date());
		
		int rows = areaMapper.saveArea(area);
		
		if (rows > 0) {
			flag = true;
		}
		
		// 添加完菜单后还要再相应的角色-菜单对应表中为当前用户以及系统管理员添加一条记录
		List<Long> roleIds = this.roleMapper.getRoleIdsByUId(UserUtils.getCurrentUserId());
		for (Long roleId : roleIds) {
			RoleToArea roleToArea = new RoleToArea();
			roleToArea.setRoleId(roleId);
			roleToArea.setAreaId(area.getId());
			this.roleToAreaMapper.saveRoleToArea(roleToArea);
		}
		if (!roleIds.contains(1L)) {
			RoleToArea roleToArea = new RoleToArea();
			roleToArea.setRoleId(1L);
			roleToArea.setAreaId(area.getId());
			this.roleToAreaMapper.saveRoleToArea(roleToArea);
		}
		
		// 修改了信息都要清空shiro的缓存
		cacheManager.getCacheManager().removalAll();
		return flag;
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public boolean updateArea(Area area) {
		boolean flag = false;
		
		if (area.getParentId() == null) { // 没有选择父部门则为顶级部门
			area.setParentId(0L);
		}
		
		area.setUpdateBy(UserUtils.getCurrentUserId());
		area.setUpdateDate(new Date());
		
		int rows = areaMapper.updateArea(area);
		
		if (rows > 0) {
			flag = true;
		}
		// 修改了信息都要清空shiro的缓存
		cacheManager.getCacheManager().removalAll();
		return flag;
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public boolean delArea(Long areaId) {
		boolean flag = false;
		
		// 删除映射表中的数据，先删除从表再删除主表
		this.roleToAreaMapper.deleteRoleToAreaByAId(areaId);		
		
		int rows = areaMapper.delArea(areaId);
		
		if (rows > 0) {
			flag = true;
		}
		// 修改了信息都要清空shiro的缓存
		cacheManager.getCacheManager().removalAll();
		return flag;
	}

}
