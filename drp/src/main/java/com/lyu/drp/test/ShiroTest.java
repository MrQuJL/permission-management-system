package com.lyu.drp.test;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * 类名称: shiro测试类
 * 类描述: 关于shiro的用户认证和用户授权测试
 * 全限定性类名: com.lyu.drp.test.ShiroTest
 * @author 曲健磊
 * @date 2018年1月24日 上午10:48:05
 * @version V1.0
 */
public class ShiroTest {
	
	private Logger log = Logger.getLogger(ShiroTest.class);
	
	@Test
	public void testLogin() {
		// 1.构造SecurityManager的运行环境
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		// 2.1创建SecurityManager对象
		// 2.2将SecurityManager对象设置到运行环境
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		// 3.初始化主体的身份信息和凭证信息（相当于web的登录，获取用户名和密码）
		// 3.1创建一个subject主体实例
		Subject subject = SecurityUtils.getSubject();
		// 3.2创建一个身份令牌(token)，记录用户的身份信息和凭证信息（用户名和密码）
		UsernamePasswordToken token = new UsernamePasswordToken("admin", "123456");
		// 4.登录
		try {
			// subject.login最终是由SecurityManager通过Authenticator调用realm来完成身份认证
			subject.login(token);
		} catch(AuthenticationException ex) {
			ex.printStackTrace();
		}
		boolean flag = false;
		
		// 是否通过认证
		flag = subject.isAuthenticated();
		log.info("用户认证状态：" + flag);
		
		// 退出--清session
		subject.logout();
		
		// 是否认证通过
		flag = subject.isAuthenticated();
		log.info("logout后用户认证状态：" + flag);
		
	}
	
	@Test
	public void testLoginByUserRealm() {
		// 1.构造SecurityManager的运行环境
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
		// 2.1创建SecurityManager对象
		// 2.2将SecurityManager对象设置到运行环境
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		// 3.初始化主体的身份信息和凭证信息（相当于web的登录，获取用户名和密码）
		// 3.1创建一个subject主体实例
		Subject subject = SecurityUtils.getSubject();
		// 3.2创建一个身份令牌(token)，记录用户的身份信息和凭证信息（用户名和密码）
		UsernamePasswordToken token = new UsernamePasswordToken("admin", "123456");
		// 4.登录
		try {
			// subject.login最终是由SecurityManager通过Authenticator
			// 根据shiro-realm.ini配置文件来调用自定义的realm来完成身份认证
			subject.login(token);
		} catch(AuthenticationException ex) {
			ex.printStackTrace();
		}
		boolean flag = false;
		
		// 是否通过认证
		flag = subject.isAuthenticated();
		log.info("用户认证状态：" + flag);
		
		// 退出--清session
		subject.logout();
		
		// 是否认证通过
		flag = subject.isAuthenticated();
		log.info("logout后用户认证状态：" + flag);
		
	}
	
}