package com.lyu.drp.sysmanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
