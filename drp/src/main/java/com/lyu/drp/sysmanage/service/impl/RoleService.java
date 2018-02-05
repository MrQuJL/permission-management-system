package com.lyu.drp.sysmanage.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lyu.drp.sysmanage.entity.Role;
import com.lyu.drp.sysmanage.entity.RoleToArea;
import com.lyu.drp.sysmanage.entity.RoleToDept;
import com.lyu.drp.sysmanage.entity.RoleToMenu;
import com.lyu.drp.sysmanage.mapper.AreaMapper;
import com.lyu.drp.sysmanage.mapper.DeptMapper;
import com.lyu.drp.sysmanage.mapper.MenuMapper;
import com.lyu.drp.sysmanage.mapper.RoleMapper;
import com.lyu.drp.sysmanage.mapper.RoleToAreaMapper;
import com.lyu.drp.sysmanage.mapper.RoleToDeptMapper;
import com.lyu.drp.sysmanage.mapper.RoleToMenuMapper;
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
	
	// 一下三个mapper用于向角色-菜单，角色-部门，角色-区域表中插入数据
	@Autowired
	private RoleToMenuMapper roleToMenuMapper;
	
	@Autowired
	private RoleToDeptMapper roleToDeptMapper;
	
	@Autowired
	private RoleToAreaMapper roleToAreaMapper;
	
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
	public boolean saveRole(Role role, List<Long> menuIds, List<Long> deptIds,
		List<Long> areaIds) {
		boolean flag = false;
		if (role == null || menuIds == null || deptIds == null || areaIds == null) {
			return flag;
		}
		
		role.setUpdateBy(UserUtils.getCurrentUserId());
		role.setUpdateDate(new Date());
		
		// 添加角色信息
		int rows = roleMapper.saveRole(role);
		
		// 向角色-菜单表中插入记录
		if (menuIds.size() > 0) {
			for (Long menuId : menuIds) {
				RoleToMenu roleToMenu = new RoleToMenu();
				roleToMenu.setRoleId(role.getId());
				roleToMenu.setMenuId(menuId);
				roleToMenuMapper.saveRoleToMenu(roleToMenu);
			}
		}
		// 向角色-部门表中插入记录
		if (menuIds.size() > 0) {
			for (Long deptId : deptIds) {
				RoleToDept roleToDept = new RoleToDept();
				roleToDept.setRoleId(role.getId());
				roleToDept.setDeptId(deptId);
				roleToDeptMapper.saveRoleToDept(roleToDept);
			}
		}
		// 向角色-区域表中插入记录
		if (menuIds.size() > 0) {
			for (Long areaId : areaIds) {
				RoleToArea roleToArea = new RoleToArea();
				roleToArea.setRoleId(role.getId());
				roleToArea.setAreaId(areaId);
				roleToAreaMapper.saveRoleToArea(roleToArea);
			}
		}
		
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
