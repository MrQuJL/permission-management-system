package com.lyu.pms.test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * 类描述：再次测试shiro
 * 全限定性类名: com.lyu.pms.test.ShiroSecondTest
 * @author 曲健磊
 * @date 2018年9月22日下午12:46:25
 * @version V1.0
 */
public class ShiroSecondTest {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 每一个openid所对应的一个"伪密码"
	 */
	public static final String OPEN_PWD = "JIZHANGYL";
	
	/**
	 * 测试通过shiro默认的realm进行登录认证
	 */
	@Test
	public void testLogin() {
		// 构造SecurityManager的运行时环境
		// 1.初始化工厂
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		
		// 2.创建SecurityManager对象
		SecurityManager securityManager = factory.getInstance();
		
		// 3.将SecurityManager对象设置到运行环境
		SecurityUtils.setSecurityManager(securityManager);;
		
		// 初始化主体的身份信息和凭证信息(相当于web的登良路，获取用户名和密码)
		
		// 1.创建一个subject主体
		Subject subject = SecurityUtils.getSubject();
		
		// 2.创建一个身份令牌(token),记录用户的身份信息和凭证信息(用户名和密码)
		UsernamePasswordToken token = new UsernamePasswordToken("admin", "123456");
		
		// 3.进行身份认证
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			// IncorrectCredentialsException 不正确的凭证信息(密码错误)
			// UnknownAccountException 未知的用户(用户名不存在,openid不存在)
			e.printStackTrace();
		}
		
		// 主体是否已经被认证过
		System.out.println("主体是否已经被认证过:" + subject.isAuthenticated());
		
		// 主体退出登录
		subject.logout();
		
		// 主体是否已经被认证过
		System.out.println("主体是否已经被认证过:" + subject.isAuthenticated());
	}
	
	/**
	 * 测试通过自定义realm进行登录认证
	 */
	@Test
	public void testLoginByUserSecondRealm() {
		// 初始化包含自定义realm的SecurityManager运行时环境
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
		
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		
		// 1.创建主体,设置主体的身份信息
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("ofklsjkodjasfjsdklfj", OPEN_PWD);
		
		try {
			// ===========>调用SecurityManager.login()==========>进自定义realm===>doGetAuthenticationInfo进行认证
			subject.login(token);
		} catch (UnknownAccountException e) {
			System.err.println(sdf.format(new Date()) + " openid不存在,认证不通过");
		} catch (IncorrectCredentialsException e) {
			System.err.println(sdf.format(new Date()) + " 密码错误,不作处理");
		}
		
		System.out.println("用户是否认证通过:" + subject.isAuthenticated());
		
		subject.logout();
		
		System.out.println("退出后,用户是否认证通过:" + subject.isAuthenticated());
	}
	
	/**
	 * 测试通过shiro默认的realm进行用户授权
	 */
	@Test
	public void testAuthorization() {
		// 构造SecurityManager的运行时环境
		// 1.初始化工厂
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-permission.ini");
		
		// 2.创建SecurityManager对象
		SecurityManager securityManager = factory.getInstance();
		
		// 3.将SecurityManager对象设置到运行环境
		SecurityUtils.setSecurityManager(securityManager);;
		
		// 初始化主体的身份信息和凭证信息(相当于web的登良路，获取用户名和密码)
		
		// 1.创建一个subject主体
		Subject subject = SecurityUtils.getSubject();
		
		// 2.创建一个身份令牌(token),记录用户的身份信息和凭证信息(用户名和密码)
		UsernamePasswordToken token = new UsernamePasswordToken("admin", "123");
		
		// 3.进行身份认证
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			// IncorrectCredentialsException 不正确的凭证信息(密码错误)
			// UnknownAccountException 未知的用户(用户名不存在,openid不存在)
			e.printStackTrace();
		}
		
		// 主体是否已经被认证过
		System.out.println("主体是否已经被认证过:" + subject.isAuthenticated());
		
		// 基于角色的判断
		System.out.println("用户是否拥有role1角色:" + subject.hasRole("role1"));
		
		System.out.println("用户是否拥有role1,role2角色:");
		boolean[] flags = subject.hasRoles(Arrays.asList("role1", "role3"));
		for (boolean flag : flags) {
			System.out.println(flag);
		}
		
		System.out.println("==============基于资源权限的判断=============");
		
		System.out.println("用户是否拥有user:add权限:" + subject.isPermitted("user:add"));
		
		System.out.println("用户是否拥有user:add,user:update,user:delete权限:");
		boolean permflags1 = subject.isPermittedAll("user:add", "user:update", "user:delete");
		System.out.println(permflags1);
		System.out.println("用户是否拥有user:view权限:" + subject.isPermitted("user:view"));
	}
	
	/**
	 * 测试通过自定义realm进行用户授权
	 */
	@Test
	public void testAuthorizationByUserRealm() {
		// 构造SecurityManager的运行时环境
		// 1.初始化工厂
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
		
		// 2.创建SecurityManager对象
		SecurityManager securityManager = factory.getInstance();
		
		// 3.将SecurityManager对象设置到运行环境
		SecurityUtils.setSecurityManager(securityManager);;
		
		// 初始化主体的身份信息和凭证信息(相当于web的登良路，获取用户名和密码)
		
		// 1.创建一个subject主体
		Subject subject = SecurityUtils.getSubject();
		
		// 2.创建一个身份令牌(token),记录用户的身份信息和凭证信息(用户名和密码)
		UsernamePasswordToken token = new UsernamePasswordToken("ofklsjkodjasfjsdklfj", OPEN_PWD);
		
		// 3.进行身份认证
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			// IncorrectCredentialsException 不正确的凭证信息(密码错误)
			// UnknownAccountException 未知的用户(用户名不存在,openid不存在)
			e.printStackTrace();
		}
		
		// 主体是否已经被认证过
		System.out.println("主体是否已经被认证过:" + subject.isAuthenticated());
		
		// 基于角色的判断
		System.out.println("用户是否拥有role1角色:" + subject.hasRole("role1"));
		
		System.out.println("用户是否拥有role1,role2角色:");
		boolean[] flags = subject.hasRoles(Arrays.asList("role1", "role3"));
		for (boolean flag : flags) {
			System.out.println(flag);
		}
		
		System.out.println("==============基于资源权限的判断=============");
		
		System.out.println("用户是否拥有user:add权限:" + subject.isPermitted("user:add"));
		
		System.out.println("用户是否拥有user:add,user:update,user:delete权限:");
		boolean permflags1 = subject.isPermittedAll("user:add", "user:update", "user:delete");
		System.out.println(permflags1);
		System.out.println("用户是否拥有user:view权限:" + subject.isPermitted("user:view"));
	}
}
