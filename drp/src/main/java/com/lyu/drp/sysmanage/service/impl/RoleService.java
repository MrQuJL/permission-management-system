package com.lyu.drp.sysmanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lyu.drp.sysmanage.entity.Role;
import com.lyu.drp.sysmanage.mapper.RoleMapper;
import com.lyu.drp.sysmanage.service.IRoleService;

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
	
	@Override
	public List<Role> getAllRoleList() {
		return roleMapper.getAllRoleList();
	}

	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	@Override
	public Role getRoleById(Long roleId) {
		// 根据id获取角色信息，包括角色所拥有的菜单列表，部门列表，区域列表
		Role role = roleMapper.getRoleById(roleId);
		
		role.setMenuList(null);
		role.setDeptList(null);
		role.setAreaList(null);
		
		return role;
	}
	
	@Override
	public boolean saveRole(Role role) {
		// 返回主键
		roleMapper.saveRole(role);
		
		return false;
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
