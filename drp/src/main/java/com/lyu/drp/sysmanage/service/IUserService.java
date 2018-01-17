package com.lyu.drp.sysmanage.service;

import com.lyu.drp.sysmanage.entity.User;

/**
 * 类名称: 用户业务处理接口 
 * 类描述: 
 * 全限定性类名: com.lyu.drp.sysmanage.service.IUserService
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
	public User loginUser(String loginName, String password);
	
	/**
	 * 根据用户id获取用户对象
	 * @param 
	 * @return
	 */
	public User getUserById(Long userId);
	
	/**
	 * 验证用户输入密码是否与数据库中的密码匹配
	 * @param plainPsd 输入的密码 
	 * @param encryptPsd 数据库中存储的密码
	 * @return
	 */
	public boolean validatePassword (String plainPsd, String encryptPsd);
	
	/**
	 * 更新指定id的用户的密码
	 * @param userId 用户的id
	 * @param newPassword 用户的新密码
	 * @return 修改成功与否
	 */
	public boolean updateUserPassword(Long userId, String newPassword);
	
}
