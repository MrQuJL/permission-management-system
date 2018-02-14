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
	 * @param 
	 * @return
	 */
	User loginUser(String loginName);
	
	/**
	 * 根据用户id获取用户对象
	 * @param 
	 * @return
	 */
	User getUserById(Long userId);
	
	/**
	 * 根据用户id获取用户对象的详细信息，包括部门名称，角色集合
	 * @param 
	 * @return
	 */
	UserDto getUserInfoById(Long userId);
	
	/**
	 * 保存用户修改的信息，包括用户的角色信息
	 * @param 
	 * @return
	 */
	boolean saveUserInfo(User user, List<Long> roleIds);
	
	/**
     * 对密码进行加密 SHA-1
     * @param plainPassword 明文密码
     * @return
     */
    String encyptPassword (String plainPassword);
	
	/**
	 * 验证用户输入密码是否与数据库中的密码匹配
	 * @param plainPsd 输入的密码 
	 * @param encryptPsd 数据库中存储的密码
	 * @return
	 */
	boolean validatePassword (String plainPsd, String encryptPsd);
	
	/**
	 * 更新指定id的用户的密码
	 * @param userId 用户的id
	 * @param newPassword 用户的新密码
	 * @return 修改成功与否
	 */
	boolean updateUserPassword(Long userId, String newPassword);
	
	/**
	 * 通过用户的已知信息(用户名称,部门名称)查询用户列表
	 * @param 
	 * @return
	 */
	PageInfo<UserDto> getUserListPageByUserDto(UserDto userDto, PageParam pageParam);
	
	/**
	 * 添加用户
	 * @param 
	 * @return
	 */
	boolean addUser(User user, List<Long> roleIds);
	
	/**
	 * 通过用户id查询他的角色列表 
	 * @param 
	 * @return
	 */
	List<UserToRole> listRoleByUId(Long userId);
	
	/**
	 * 根据删除用户
	 * @param 
	 * @return
	 */
	boolean delUser(Long userId);
	
}
