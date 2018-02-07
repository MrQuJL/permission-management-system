package com.lyu.drp.sysmanage.mapper;

import java.util.List;

import com.lyu.drp.sysmanage.entity.UserToRole;

/**
 * 类名称: 用户-角色对应表mapper接口
 * 类描述: 封装了对用户-角色对应表的一些操作
 * 全限定性类名: com.lyu.drp.sysmanage.mapper.UserToRoleMapper
 * @author 曲健磊
 * @date 2018年2月7日 上午11:24:22
 * @version V1.0
 */
public interface UserToRoleMapper {
	
	/**
	 * 新增用户-角色对应表的一条记录
	 * @param 
	 * @return
	 */
	int saveUserToRole(UserToRole userToRole);
	
	/**
	 * 根据用户id，删除用户-角色对应表的一条记录
	 * @param 
	 * @return
	 */
	int deleteUserToRole(Long userId);
	
	/**
	 * 通过用户id查询他的角色列表 
	 * @param 
	 * @return
	 */
	List<UserToRole> listRoleByUId(Long userId);
	
	/**
	 * 向用户-角色对应表中添加数据
	 * @param 
	 * @return
	 */
	int addUserToRole(UserToRole userToRole);
	
	/**
	 * 根据用户的id删除对应的角色
	 * @param 
	 * @return
	 */
	int delRoleByUId(Long userId);
	
}
