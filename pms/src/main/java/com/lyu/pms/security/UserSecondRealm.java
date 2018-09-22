package com.lyu.pms.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 类描述：用于测试Realm
 * 全限定性类名: com.lyu.pms.security.UserSecondRealm
 * @author 曲健磊
 * @date 2018年9月22日下午1:31:23
 * @version V1.0
 */
public class UserSecondRealm extends AuthorizingRealm {

	/**
	 * 用户认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		
		// 从传入的token获取身份信息和凭证信息
		String openid = upToken.getUsername(); // 后期替换为openid
		char[] password = upToken.getPassword();
		
		System.out.println("========Begin Realm=========");
		System.out.println("用户openid:" + openid);
		System.out.println("密码:" + new String(password));
		System.out.println("=========End Realm==========");
		
		
		// 模拟根据得到的username去数据库中查询这个用户是否存在
		String dbOpenid = "ofklsjkodjasfjsdklfj"; // 数据库中的数据
		
		if (dbOpenid.equals(openid)) { // 身份信息认证通过,进行凭证信息匹配
			SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(openid, password, this.getName());
			return simpleAuthenticationInfo;
		}
		
		return null;
	}

	/**
	 * 用户授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 获取到的身份信息是从doGetAuthenticationInfo()方法的返回值得来
		String openid = (String) principals.getPrimaryPrincipal();
		
		// 1.根据openid查询该用户所拥有的角色
		
		// 2.查询该用户所拥有的每一个角色所能够操作的菜单权限
		List<String> permissions = new ArrayList<String>();
		permissions.add("user:add");
		permissions.add("user:delete");
		permissions.add("user:update");
		
		// 将得到的权限信息放入SimpleAuthorizationInfo对象保存
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		for (String permission : permissions) {
			simpleAuthorizationInfo.addStringPermission(permission);
		}
		
		return simpleAuthorizationInfo;
	}
}
