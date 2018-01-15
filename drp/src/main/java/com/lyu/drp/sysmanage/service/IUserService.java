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
	
}
