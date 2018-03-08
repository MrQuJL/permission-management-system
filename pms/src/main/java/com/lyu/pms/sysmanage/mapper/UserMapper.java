package com.lyu.pms.sysmanage.mapper;

import java.util.List;

import com.lyu.pms.sysmanage.dto.UserDto;
import com.lyu.pms.sysmanage.entity.User;

/**
 * 类名称: 用户数据映射
 * 类描述: 用于对用户的增删改查
 * 全限定性类名: com.lyu.pms.sysmanage.mapper.UserMapper
 * @author 曲健磊
 * @date 2018年1月15日 下午11:41:01
 * @version V1.0
 */
public interface UserMapper {
	
	/**
	 * 验证用户的登录
	 * @param loginName 登录名称和密码
	 * @return 用户存在则返回该用户
	 */
	User loginUser(String loginName);
	
	/**
	 * 根据用户id获取用户对象
	 * @param userId 用户id
	 * @return id为userId的用户信息
	 */
	User getUserById(Long userId);
	
	/**
	 * 根据用户id获取用户对象的详细信息，包括部门名称，角色集合
	 * @param userId 用户id
	 * @return id为userId的用户的详细信息
	 */
	UserDto getUserInfoById(Long userId);
	
	/**
	 * 更新指定id的用户的密码
	 * @param userId 用户的id
	 * @param newPassword 用户的新密码
	 * @return 修改成功与否
	 */
	int updateUserPassword(Long userId, String newPassword);
	
	/**
	 * 修改用户信息
	 * @param user 要修改的用户
	 * @return 受影响的行数1表示影响1行，0表示0行
	 */
	int saveUserInfo(User user);
	
	/**
	 * 通过用户的已知信息(用户名称,部门名称)查询用户列表
	 * @param userDto 已知的用户信息条件
	 * @return 符合条件的用户列表
	 */
	List<UserDto> getUserListByUserDto(UserDto userDto);
	
	/**
	 * 添加用户
	 * @param user 用户详细信息
	 * @return 受影响的行数1表示影响1行，0表示0行
	 */
	int addUser(User user);
	
	/**
	 * 删除用户
	 * @param userId 用户的id
	 * @return 受影响的行数1表示影响1行，0表示0行
	 */
	int delUser(Long userId);
}
