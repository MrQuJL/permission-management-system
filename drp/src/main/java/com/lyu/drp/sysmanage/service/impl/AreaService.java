package com.lyu.drp.sysmanage.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyu.drp.sysmanage.dto.AreaDto;
import com.lyu.drp.sysmanage.entity.Area;
import com.lyu.drp.sysmanage.mapper.AreaMapper;
import com.lyu.drp.sysmanage.mapper.RoleMapper;
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
		
		return flag;
	}

	@Override
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
		
		return flag;
	}

	@Override
	public boolean delArea(Long areaId) {
		boolean flag = false;
		
		int rows = areaMapper.delArea(areaId);
		
		if (rows > 0) {
			flag = true;
		}
		
		return flag;
	}

}
