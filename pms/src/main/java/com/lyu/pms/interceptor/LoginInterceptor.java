package com.lyu.pms.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 类名称: 登录验证拦截器
 * 类描述: 基于url拦截实现权限控制的身份认证拦截器
 * 全限定性类名: com.lyu.pms.interceptor.LoginInterceptor
 * @author 曲健磊
 * @date 2018年1月23日 上午10:18:42
 * @version V1.0
 */
public class LoginInterceptor extends AbstractInterceptor {
	
	private static final long serialVersionUID = 3392064468921025712L;
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		log.info("进入用户认证拦截器");
		// 1.判断是否是匿名访问的地址
		String returnCode = "";
		String uri = ServletActionContext.getRequest().getRequestURI();
		log.info("------------uri:" + uri);
		if (uri.contains("toLogin") || uri.contains("login")) {
			returnCode = invocation.invoke();
		} else {
			// 2.判断用户身份信息是否存在session中
			HttpSession session = ServletActionContext.getRequest().getSession();
			if (session.getAttribute("principle") != null) {
				returnCode = invocation.invoke();
			} else {
				returnCode = "loginPage";
			}
		}
		log.info("退出用户认证拦截器");
		return returnCode;
	}
}