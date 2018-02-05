package com.lyu.drp.sysmanage.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lyu.drp.sysmanage.entity.Role;
import com.lyu.drp.sysmanage.mapper.AreaMapper;
import com.lyu.drp.sysmanage.mapper.DeptMapper;
import com.lyu.drp.sysmanage.mapper.MenuMapper;
import com.lyu.drp.sysmanage.mapper.RoleMapper;
import com.lyu.drp.sysmanage.service.IRoleService;
import com.lyu.drp.util.UserUtils;

/**
 * 类名称: 角色服务实现类
 * 类描述: 对IRoleService的一个实现
 * 全限定性类名: com.lyu.drp.sysmanage.service.impl.RoleService
 * @author 曲健磊
 * @date 2018年2月4日 下午4:48:40
 * @version V1.0
 */
@Service("roleService")
public class RoleService implements IRoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private MenuMapper menuMapper;
	
	@Autowired
	private DeptMapper deptMapper;
	
	@Autowired
	private AreaMapper areaMapper;
	
	@Override
	public List<Role> getAllRoleList() {
		return roleMapper.getAllRoleList();
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public Role getRoleById(Long roleId) {
		
		Role role = roleMapper.getRoleById(roleId);
		
		// 根据id获取角色信息，包括角色所拥有的菜单列表，部门列表，区域列表
		role.setMenuList(menuMapper.getMenuListByRoleId(roleId));
		role.setDeptList(deptMapper.getDeptListByRoleId(roleId));
		role.setAreaList(areaMapper.getAreaListByRoleId(roleId));
		
		return role;
	}
	
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public boolean saveRole(Role role, List<Integer> menuIds, List<Integer> deptIds,
		List<Integer> areaIds) {
		boolean flag = false;
		
		role.setUpdateBy(UserUtils.getCurrentUserId());
		role.setUpdateDate(new Date());
		
		// 添加角色信息
		int rows = roleMapper.saveRole(role);
		
		System.out.println("添加记录成功后返回的主键：" + role.getId());
		
		// 向角色-菜单表中插入记录
		
		// 向角色-部门表中插入记录
		
		// 向角色-区域表中插入记录
		
		if (rows > 0) {
			flag = true;
		}
		
		return flag;
	}

	@Override
	public boolean updateRole(Role role) {
		
		roleMapper.updateRole(role);
		
		return false;
	}

	@Override
	public boolean delRole(Long roleId) {
		
		roleMapper.delRole(roleId);
		
		return false;
	}

}
