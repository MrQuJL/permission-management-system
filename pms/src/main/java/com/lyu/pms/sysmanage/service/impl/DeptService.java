package com.lyu.pms.sysmanage.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lyu.pms.sysmanage.dto.DeptDto;
import com.lyu.pms.sysmanage.entity.Dept;
import com.lyu.pms.sysmanage.entity.RoleToDept;
import com.lyu.pms.sysmanage.mapper.DeptMapper;
import com.lyu.pms.sysmanage.mapper.RoleMapper;
import com.lyu.pms.sysmanage.mapper.RoleToDeptMapper;
import com.lyu.pms.sysmanage.service.IDeptService;
import com.lyu.pms.util.UserUtils;

/**
 * 类名称: 部门服务接口实现类
 * 类描述: 对部门服务接口的一个具体实现
 * 全限定性类名: com.lyu.pms.sysmanage.service.impl.DeptService
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
		return flag;
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public boolean delDept(Long deptId) {
		boolean flag = false;
		
		// 删除映射表中的数据，先删除从表再删除主表
		this.roleToDeptMapper.deleteRoleToDeptByDId(deptId);
		
		int count = deptMapper.delDept(deptId);
		if (count > 0) {
			flag = true;
		}
		return flag;
	}

}
