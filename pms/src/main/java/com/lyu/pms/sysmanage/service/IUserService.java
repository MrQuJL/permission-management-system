package com.lyu.pms.sysmanage.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lyu.pms.common.dto.PageParam;
import com.lyu.pms.sysmanage.dto.UserDto;
import com.lyu.pms.sysmanage.entity.User;
import com.lyu.pms.sysmanage.entity.UserToRole;

/**
 * 类名称: 用户业务处理接口 
 * 类描述: 用于对用户的一些操作
 * 全限定性类名: com.lyu.pms.sysmanage.service.IUserService
 * @author 曲健磊
 * @date 2018年1月15日 下午11:28:49
 * @version V1.0
 */
public interface IUserService {
	
	/**
	 * 验证用户登录
	 * @param loginName 待验证用户的登录名称
	 * @return 登录名为loginName的用户的详细信息，如果没有则返回空
	 */
	User loginUser(String loginName);
	
	/**
	 * 获取id为userId的用户对象
	 * @param userId
	 * @return id为userId的用户对象
	 */
	User getUserById(Long userId);
	
	/**
	 * 根据用户id获取用户对象的详细信息，包括部门名称，角色集合
	 * @param userId 用户id
	 * @return id为userId的用户的详细信息
	 */
	UserDto getUserInfoById(Long userId);
	
	/**
	 * 修改用户的信息，包括用户的角色信息
	 * @param user 待修改的用户
	 * @param roleIds 用户新的角色列表
	 * @return true则修改成功，false则失败
	 */
	boolean saveUserInfo(User user, List<Long> roleIds);
	
	/**
     * 对密码进行加密 SHA-1
     * @param plainPassword 待加密的密码
     * @return 加密后的密码
     */
    String encyptPassword (String plainPassword);
	
	/**
	 * 验证用户输入密码是否与数据库中的密码匹配
	 * @param plainPsd 未加密的密码
	 * @param encryptPsd 加密后的密码
	 * @return plainPsd加密后如果与encryptPsd相同则返回true，否则返回false
	 */
	boolean validatePassword (String plainPsd, String encryptPsd);
	
	/**
	 * 修改用户的密码
	 * @param userId 用户的id
	 * @param newPassword 用户的新密码
	 * @return true则修改成功，false则修改失败
	 */
	boolean updateUserPassword(Long userId, String newPassword);
	
	/**
	 * 通过用户的已知信息(例：用户名称,部门名称...)分页查询用户列表
	 * @param userDto 已知的用户信息
	 * @param pageParam 分页对象，包括第几页，每页几条
	 * @return 经过分页的满足条件的用户列表
	 */
	PageInfo<UserDto> getUserListPageByUserDto(UserDto userDto, PageParam pageParam);
	
	/**
	 * 添加用户
	 * @param user 待添加的用户
	 * @param roleIds 用户所拥有的角色列表
	 * @return true则添加成功，否则添加失败
	 */
	boolean addUser(User user, List<Long> roleIds);
	
	/**
	 * 通过用户id查询该用户的角色列表 
	 * @param userId 用户id
	 * @return 该用户的角色列表
	 */
	List<UserToRole> listRoleByUId(Long userId);
	
	/**
	 * 删除id为userId的用户
	 * @param userId
	 * @return true则删除用户成功，false则失败
	 */
	boolean delUser(Long userId);
	
}
