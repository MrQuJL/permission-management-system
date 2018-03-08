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
	 * @return 所有的角色列表
	 */
	List<Role> getAllRoleList();
	
	/**
	 * 根据角色id获取角色信息
	 * @param roleId 角色id
	 * @return id为roleId的角色的详细信息
	 */
	Role getRoleById(Long roleId);
	
	/**
	 * 通过用户id查询他所拥有的角色列表
	 * @param userId 用户id
	 * @return 该用户所拥有的角色id列表
	 */
	List<Long> getRoleIdsByUId(Long userId);
	
	/**
	 * 添加角色
	 * @param role 要添加的角色
	 * @return 受影响的记录数，1表示添加成功，否则失败
	 */
	int saveRole(Role role);
	
	/**
	 * 修改角色
	 * @param role 要修改的角色
	 * @return 受影响的记录数，1表示修改成功，否则失败
	 */
	int updateRole(Role role);
	
	/**
	 * 删除角色
	 * @param roleId 角色id
	 * @return 受影响的记录数，1表示删除成功，否则失败
	 */
	int delRole(Long roleId);
	
}
