package com.lyu.drp.sysmanage.action;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.lyu.drp.sysmanage.dto.Principle;
import com.lyu.drp.sysmanage.entity.User;
import com.lyu.drp.sysmanage.service.IMenuService;
import com.lyu.drp.sysmanage.service.IUserService;

/**
 * 类名称: struts2登录业务控制类
 * 类描述: struts2登录业务控制类
 * 全限定性类名: com.lyu.drp.sysmanage.action.LoginAction
 * @author 曲健磊
 * @date 2018年1月12日 上午11:02:37
 * @version V1.0
 */
public class LoginAction {
	// 打印日志
	private Log logger = LogFactory.getLog(LoginAction.class);
	// 获取页面传过来的用户名
	private String loginName;
	// 获取页面传过来的密码
	private String password;
	// 登录出错的时候返回页面的提示信息
	private String loginErrorMsg;
	// 用户服务类,spring容器会自动注入
	private IUserService userService;
	// 菜单服务类，spring会自动注入
	private IMenuService menuService;
	
	public IMenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String getLoginName() {
		return loginName;
	}
	
	public void setLoginName(String loginName) {
		this.loginName = loginName;
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
		logger.info("loginName:" + loginName);
		logger.info("password:" + password);
		
		// 判断一下loginName和password是不是为空
		if (!StringUtils.isEmpty(loginName) && !StringUtils.isEmpty(password)) {
			User user = userService.loginUser(loginName, password);
			if (user != null) {
				// 认证成功把用户信息放入session中
				Principle principle = new Principle();
				principle.setUserId(user.getUserId());
				principle.setLoginName(user.getLoginName());
				principle.setUserName(user.getUserName());
				// 为了授权拦截器能够匹配用户所拥有的权限，在登录成功以后将该用户所能访问的菜单url放入身份信息中
				principle.setMenuList(menuService.getMenuListByUser(user.getUserId()));
				
				HttpSession session = ServletActionContext.getRequest().getSession();
				session.setAttribute("principle", principle);
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
