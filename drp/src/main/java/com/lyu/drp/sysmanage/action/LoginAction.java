package com.lyu.drp.sysmanage.action;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;

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
	 * 退出系统
	 * @param 
	 * @return
	 */
	public String logout() {
//		Subject subject = SecurityUtils.getSubject();
//		subject.logout();
		
		System.out.println("进入logout的action");
		return "success";
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
//			User user = userService.loginUser(loginName, password);
			
			UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
			Subject subject = SecurityUtils.getSubject();
			try {
	            subject.login(token);
	        } catch (IncorrectCredentialsException ice) {
	            // 捕获密码错误异常
	        	loginErrorMsg = "密码不匹配";
				return "loginPage";
	        } catch (UnknownAccountException uae) {
	            // 捕获未知用户名异常
	        	loginErrorMsg = "未知的用户";
				return "loginPage";
	        } catch (ExcessiveAttemptsException eae) {
	            // 捕获错误登录过多的异常
	        	loginErrorMsg = "错误登录过多";
				return "loginPage";
	        } catch (AuthenticationException ex) {
	        	loginErrorMsg = "用户名和密码不匹配";
				return "loginPage";
	        }
			return "main";
		} else {
			loginErrorMsg = "用户名和密码不匹配";
			return "loginPage";
		}
	}
}
