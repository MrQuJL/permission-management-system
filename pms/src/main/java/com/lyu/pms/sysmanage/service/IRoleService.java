package com.lyu.pms.sysmanage.service;

import java.util.List;

import com.lyu.pms.sysmanage.entity.Role;

/**
 * 类名称: 角色服务类接口
 * 类描述: 封装了一些对角色的操作
 * 全限定性类名: com.lyu.pms.sysmanage.service.IRoleService
 * @author 曲健磊
 * @date 2018年2月4日 下午4:46:05
 * @version V1.0
 */
public interface IRoleService {
	
	/**
	 * 查询全部的角色列表
	 * @return 全部的角色列表
	 */
	List<Role> getAllRoleList();
	
	/**
	 * 根据角色id获取角色信息，包括所拥有的菜单，部门，区域
	 * @param roleId 角色id
	 * @return id为roleId的角色的详细信息
	 */
	Role getRoleById(Long roleId);
	
	/**
	 * 添加角色
	 * @param role 待添加的角色
	 * @param menuIds 该角色所能够操作的菜单
	 * @param deptIds 该角色所能够操作的部门
	 * @param areaIds 该角色所能够操作的区域
	 * @return true表示添加成功，false则失败
	 */
	boolean saveRole(Role role, List<Long> menuIds, List<Long> deptIds,
		List<Long> areaIds);
	
	/**
	 * 修改角色
	 * @param role 待修改的角色
	 * @param menuIds 该角色所能够操作的最新的菜单
	 * @param deptIds 该角色所能够操作的最新的部门
	 * @param areaIds 该角色所能够操作的最新的区域
	 * @return true表示修改成功，false则失败
	 */
	boolean updateRole(Role role, List<Long> menuIds, List<Long> deptIds,
		List<Long> areaIds);
	
	/**
	 * 删除角色
	 * @param roleId 待删除的角色id
	 * @return true表示删除成功，false则失败
	 */
	boolean delRole(Long roleId);
	
}
