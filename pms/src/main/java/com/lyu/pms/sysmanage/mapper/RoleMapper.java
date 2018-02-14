package com.lyu.pms.sysmanage.mapper;

import java.util.List;

import com.lyu.pms.sysmanage.entity.Role;

/**
 * 类名称: 角色mapper
 * 类描述: 用于操作角色的数据
 * 全限定性类名: com.lyu.pms.sysmanage.mapper.RoleMapper
 * @author 曲健磊
 * @date 2018年2月4日 下午4:32:30
 * @version V1.0
 */
public interface RoleMapper {
	
	/**
	 * 查询全部的角色列表
	 * @param 
	 * @return
	 */
	List<Role> getAllRoleList();
	
	/**
	 * 根据角色id获取角色信息
	 * @param 
	 * @return
	 */
	Role getRoleById(Long roleId);
	
	/**
	 * 通过用户id查询他所拥有的角色列表（id）
	 * @param 
	 * @return
	 */
	List<Long> getRoleIdsByUId(Long userId);
	
	/**
	 * 添加角色
	 * @param 
	 * @return
	 */
	int saveRole(Role role);
	
	/**
	 * 修改角色
	 * @param 
	 * @return
	 */
	int updateRole(Role role);
	
	/**
	 * 删除角色
	 * @param 
	 * @return
	 */
	int delRole(Long roleId);
	
}
