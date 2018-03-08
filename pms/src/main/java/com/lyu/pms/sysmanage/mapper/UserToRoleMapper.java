package com.lyu.pms.sysmanage.mapper;

import java.util.List;

import com.lyu.pms.sysmanage.entity.UserToRole;

/**
 * 类名称: 用户-角色对应表mapper接口
 * 类描述: 封装了对用户-角色对应表的一些操作
 * 全限定性类名: com.lyu.pms.sysmanage.mapper.UserToRoleMapper
 * @author 曲健磊
 * @date 2018年2月7日 上午11:24:22
 * @version V1.0
 */
public interface UserToRoleMapper {
	
	/**
	 * 新增用户-角色对应表的一条记录
	 * @param userToRole 用户角色映射对象
	 * @return 受影响的行数，1表示影响1行，0表示0行
	 */
	int saveUserToRole(UserToRole userToRole);
	
	/**
	 * 根据用户id，删除用户-角色对应表的记录
	 * @param userId 用户id
	 * @return 受影响的行数，1表示影响1行，0表示0行
	 */
	int deleteUserToRole(Long userId);
	
	/**
	 * 通过用户id查询他的角色列表 
	 * @param userId 用户id
	 * @return 该用户拥有的用户-角色映射列表
	 */
	List<UserToRole> listRoleByUId(Long userId);
	
	/**
	 * 向用户-角色对应表中添加数据
	 * @param userToRole 用户角色映射对象
	 * @return 受影响的行数，1表示影响1行，0表示0行
	 */
	int addUserToRole(UserToRole userToRole);
	
	/**
	 * 根据用户的id删除对应的角色
	 * @param userId 用户id
	 * @return 受影响的行数，1表示影响1行，0表示0行
	 */
	int delRoleByUId(Long userId);
	
}
