package com.lyu.drp.sysmanage.action;

import com.alibaba.druid.util.StringUtils;

/**
 * 类名称: struts2登录业务控制类
 * 类描述: struts2登录业务控制类
 * 全限定性类名: com.lyu.drp.sysmanage.action.LoginAction
 * @author 曲健磊
 * @date 2018年1月12日 上午11:02:37
 * @version V1.0
 */
public class LoginAction {
	// 获取页面传过来的用户名
	private String username;
	// 获取页面传过来的密码
	private String password;
	// 登录出错的时候返回页面的提示信息
	private String loginErrorMsg;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginErrorMsg() {
		return loginErrorMsg;
	}
	
	public void setLoginErrorMsg(String loginErrorMsg) {
		this.loginErrorMsg = loginErrorMsg;
	}

	/**
	 * 进入登录页面
	 * @param 
	 * @return
	 */
	public String toLogin() {
		return "loginPage";
	}
	
	/**
	 * 进入首页
	 * @param 
	 * @return
	 */
	public String main() {
		return "mainPage";
	}
	
	/**
	 * 登录验证
	 * @param 
	 * @return
	 */
	public String login() {
		// 判断一下username和password是不是为空
		if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {
			if ("admin".equals(username) && "123456".equals(password)) {
				return "main";
			} else {
				loginErrorMsg = "用户名和密码不匹配";
				return "loginPage";
			}
		} else {
			loginErrorMsg = "用户名和密码不匹配";
			return "loginPage";
		}
	}
}
