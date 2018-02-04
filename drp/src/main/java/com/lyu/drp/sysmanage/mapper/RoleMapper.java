package com.lyu.drp.sysmanage.mapper;

import java.util.List;

import com.lyu.drp.sysmanage.entity.Role;

/**
 * 类名称: 角色mapper
 * 类描述: 用于操作角色的数据
 * 全限定性类名: com.lyu.drp.sysmanage.mapper.RoleMapper
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
	public List<Role> getAllRoleList();
	
	
	/**
	 * 添加角色
	 * @param 
	 * @return
	 */
	public int saveRole(Role role);
	
	/**
	 * 修改角色
	 * @param 
	 * @return
	 */
	public int updateRole(Role role);
	
	/**
	 * 删除角色
	 * @param 
	 * @return
	 */
	public int delRole(Long roleId);
	
}
