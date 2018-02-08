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

import com.lyu.drp.sysmanage.dto.DeptDto;
import com.lyu.drp.sysmanage.entity.Dept;
import com.lyu.drp.sysmanage.entity.RoleToDept;
import com.lyu.drp.sysmanage.mapper.DeptMapper;
import com.lyu.drp.sysmanage.mapper.RoleMapper;
import com.lyu.drp.sysmanage.mapper.RoleToDeptMapper;
import com.lyu.drp.sysmanage.service.IDeptService;
import com.lyu.drp.util.UserUtils;

/**
 * 类名称: 部门服务接口实现类
 * 类描述: 对部门服务接口的一个具体实现
 * 全限定性类名: com.lyu.drp.sysmanage.service.impl.DeptService
 * @author 曲健磊
 * @date 2018年2月2日 上午10:26:32
 * @version V1.0
 */
@Service("deptService")
public class DeptService implements IDeptService {
	@Autowired
	private DeptMapper deptMapper;
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private RoleToDeptMapper roleToDeptMapper;
	
	@Autowired
	private EhCacheManager cacheManager;
	
	@Override
	public DeptDto getDeptDetailById(Long deptId) {
		return deptMapper.getDeptDetailById(deptId);
	}
	
	@Override
	public List<Dept> getAllDeptList() {
		return deptMapper.getAllDeptList();
	}
	
	@Override
	public List<Dept> getDeptListByUId(Long userId) {
		// 1.先获取当前用户所拥有的角色ids
		List<Long> roleIds = this.roleMapper.getRoleIdsByUId(userId);
		List<Dept> deptList = new ArrayList<Dept>();
		// 2.再根据角色获取这些角色所拥有的部门
		for (Long roleId : roleIds) {
			deptList.addAll(deptMapper.getDeptListByRoleId(roleId));
		}
		// 去除重复的元素
		Set<Dept> uniqueDeptSet = new HashSet<Dept>(deptList); 
		deptList.clear();
		deptList.addAll(uniqueDeptSet);
		
		return deptList;
	}
	
	@Override
	public List<Long> getAllSubDeptIds(Long parentId) {
		List<Long> subDeptList = new ArrayList<Long>();
		
		List<Long> tempList = deptMapper.getAllSubDeptIds(parentId);
		
		subDeptList.addAll(tempList);
		
		for (int i = 0; i < tempList.size(); i++) {
			List<Long> temp = getAllSubDeptIds(tempList.get(i));
			subDeptList.addAll(temp);
		}
		
		return subDeptList;
	}
	
	@Override
	public boolean hasSubDept(Long parentId) {
		boolean flag = true;
		int count = deptMapper.countSubDeptByPId(parentId); 
		if (count == 0) {
			flag = false;
		}
		return flag;
	}
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public boolean saveDept(Dept dept) {
		boolean flag = false;
		dept.setUpdateBy(UserUtils.getCurrentUserId().toString());
		dept.setUpdateDate(new Date());
		
		int rows = deptMapper.saveDept(dept);
		if (rows > 0) {
			flag = true;
		}
		
		// 添加完菜单后还要再相应的角色-菜单对应表中为当前用户以及系统管理员添加一条记录
		List<Long> roleIds = this.roleMapper.getRoleIdsByUId(UserUtils.getCurrentUserId());
		for (Long roleId : roleIds) {
			RoleToDept roleToDept = new RoleToDept();
			roleToDept.setRoleId(roleId);
			roleToDept.setDeptId(dept.getId());
			this.roleToDeptMapper.saveRoleToDept(roleToDept);
		}
		if (!roleIds.contains(1L)) {
			RoleToDept roleToDept = new RoleToDept();
			roleToDept.setRoleId(1L);
			roleToDept.setDeptId(dept.getId());
			this.roleToDeptMapper.saveRoleToDept(roleToDept);
		}
		
		// 修改了信息都要清空shiro的缓存
		cacheManager.getCacheManager().removalAll();
		return flag;
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public boolean updateDept(Dept dept) {
		boolean flag = false;
		dept.setUpdateBy(UserUtils.getCurrentUserId().toString());
		dept.setUpdateDate(new Date());
		
		int rows = deptMapper.updateDept(dept);
		if (rows > 0) {
			flag = true;
		}
		// 修改了信息都要清空shiro的缓存
		cacheManager.getCacheManager().removalAll();
		return flag;
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public boolean delDept(Long deptId) {
		boolean flag = false;
		int count = deptMapper.delDept(deptId);
		if (count > 0) {
			flag = true;
		}
		// 修改了信息都要清空shiro的缓存
		cacheManager.getCacheManager().removalAll();
		return flag;
	}

}
