package com.lyu.pms.interceptor;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.lyu.pms.sysmanage.dto.Principle;
import com.lyu.pms.sysmanage.entity.Menu;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 类名称: 用户权限拦截器
 * 类描述: 用于判断用户访问的资源是否在用户所拥有的权限列表
 * 全限定性类名: com.lyu.pms.interceptor.AuthorizationInterceptor
 * @author 曲健磊
 * @date 2018年1月23日 下午1:26:06
 * @version V1.0
 */
public class AuthorizationInterceptor extends AbstractInterceptor {
	
	private static final long serialVersionUID = 3392064468921025712L;
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		log.info("进入用户权限拦截器");
		
		// 1.获取访问的uri
		String uri = ServletActionContext.getRequest().getRequestURI().substring(4);
		String returnCode = "refusePage";
		if (uri.contains("toLogin") || uri.contains("login") || uri.contains("main")) {
			returnCode = invocation.invoke();
		} else {
			// 2.判断session中的身份信息是否为空是否为空
			HttpSession session = ServletActionContext.getRequest().getSession();
			Principle principle = (Principle) session.getAttribute("principle");
			
			log.info("uri:" + uri);
			boolean flag = false;
			if (principle != null) {
				List<Menu> menuList = principle.getMenuList();
				for (Menu menu : menuList) {
					String menuHref = menu.getHref();
					if (StringUtils.isNotEmpty(menuHref)) {
						if (uri.indexOf(menuHref) >= 0) {
							log.info("href:" + menu.getHref() + ",uri:" + uri);
							flag = true;
							break;
						}
					}
				}
				if (flag) { // 权限验证通过
					returnCode = invocation.invoke();
					log.info("权限验证通过");
				} else { // 无权访问
					log.info("权限验证未通过");
					returnCode = "refusePage";
				}
			}
			log.info("退出用户权限拦截器");
		}
		return returnCode;
	}
}
