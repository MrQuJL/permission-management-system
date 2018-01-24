package com.lyu.drp.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.lyu.drp.sysmanage.entity.User;

/**
 * 类名称: 用户认证和用户授权的realm
 * 类描述: 用来进行用户认证和用户授权
 * 全限定性类名: com.lyu.drp.security.UserRealm
 * @author 曲健磊
 * @date 2018年1月24日 上午11:28:01
 * @version V1.0
 */
public class UserRealm extends AuthorizingRealm {

	// 用户授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	// 身份认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 1.从传入的token获取身份信息(输入的userName)
		String userName = (String) token.getPrincipal();
		
		// 2.模拟根据得到的userName去数据库查询这个用户是否存在
		User user = new User();
		user.setLoginName("admin");
		user.setPassword("123456");
		
		// 3.如果传入的userName和数据 库查询出来的userName相同
		SimpleAuthenticationInfo simpleAuthenticationInfo = null;
		
		if (userName.equals(user.getLoginName())) {
			// 身份信息确认以后，凭证信息的确认由SimpleAuthenticationInfo的父类
			// AuthenticationInfo进行验证
			simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getLoginName(), 
				user.getPassword(), this.getName());
		}
		
		return simpleAuthenticationInfo;
	}

}
