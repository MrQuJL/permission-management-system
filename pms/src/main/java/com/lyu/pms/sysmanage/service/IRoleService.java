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
	 * @param 
	 * @return
	 */
	List<Role> getAllRoleList();
	
	/**
	 * 根据角色id获取角色信息，包括所拥有的菜单，部门，区域
	 * @param 
	 * @return
	 */
	Role getRoleById(Long roleId);
	
	/**
	 * 添加角色
	 * @param 
	 * @return
	 */
	boolean saveRole(Role role, List<Long> menuIds, List<Long> deptIds,
		List<Long> areaIds);
	
	/**
	 * 修改角色
	 * @param 
	 * @return
	 */
	boolean updateRole(Role role, List<Long> menuIds, List<Long> deptIds,
		List<Long> areaIds);
	
	/**
	 * 删除角色
	 * @param 
	 * @return
	 */
	boolean delRole(Long roleId);
	
}