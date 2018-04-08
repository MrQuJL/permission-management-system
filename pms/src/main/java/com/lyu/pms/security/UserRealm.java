package com.lyu.pms.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.lyu.pms.sysmanage.dto.Principle;
import com.lyu.pms.sysmanage.entity.Menu;
import com.lyu.pms.sysmanage.entity.User;
import com.lyu.pms.sysmanage.service.IMenuService;
import com.lyu.pms.sysmanage.service.IUserService;
import com.lyu.pms.util.EncryptUtils;

/**
 * 类名称: 用户认证和用户授权的realm
 * 类描述: 用来进行用户认证和用户授权
 * 全限定性类名: com.lyu.pms.security.UserRealm
 * @author 曲健磊
 * @date 2018年1月24日 上午11:28:01
 * @version V1.0
 */
public class UserRealm extends AuthorizingRealm {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IMenuService menuService;
	
	private Logger log = Logger.getLogger(UserRealm.class);
	
	// 身份认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) 
		throws AuthenticationException {
		
		log.info("进入UserRealm的身份认证方法...");
		
		// 1.从传入的token获取身份信息(输入的userName)
		UsernamePasswordToken authcToken = (UsernamePasswordToken) token;
		
		// 2.根据得到的userName去数据库查询这个用户是否存在
		User user = this.userService.loginUser(authcToken.getUsername());
		
		Principle principle = new Principle(user.getUserId(), user.getLoginName(),
			user.getUserName());
		
		// 从密码中拿到盐
		byte[] salt = EncryptUtils.decodeHex(user.getPassword().substring(0, 16));
		
		// 3.如果传入的userName和数据 库查询出来的userName相同
		SimpleAuthenticationInfo simpleAuthenticationInfo = null;
		
		if (authcToken.getUsername().equals(user.getLoginName())) {
			// 身份信息确认以后，凭证信息的确认由SimpleAuthenticationInfo的父类
			// AuthenticationInfo进行验证
			simpleAuthenticationInfo = new SimpleAuthenticationInfo(principle, 
				user.getPassword().substring(16), ByteSource.Util.bytes(salt), this.getName());
		}
		
		return simpleAuthenticationInfo;
	}
	
	// 用户授权(被perms过滤器拦截的请求会进入该方法)
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		log.info("进入UserRealm的权限认证方法...");
		
		// 获取用户身份信息
		Principle principle = (Principle) principals.getPrimaryPrincipal();
		
		// 模拟根据得到的user对象里面的userName或userId去数据库查询这个用户存在哪些资源操作权限
		Set<String> permissions = new HashSet<String>();
		
		// 查询当前主体所拥有的权限信息
		List<Menu> menuList = menuService.getMenuListByUserId(principle.getUserId());
		if (menuList != null && menuList.size() > 0) {
			for (Menu menu : menuList) {
				if (StringUtils.isNotEmpty(menu.getPermission())) {
					permissions.add(menu.getPermission());
				}
			}
		}
		
		// 把权限信息放入simpleAuthorizationInfo
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.setStringPermissions(permissions);
		
		return simpleAuthorizationInfo;
	}
	
}
