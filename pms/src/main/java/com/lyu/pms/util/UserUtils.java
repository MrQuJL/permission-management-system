package com.lyu.pms.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.lyu.pms.sysmanage.dto.Principle;

/**
 * 类名称: 用户工具类
 * 类描述: 获取放在shiro里面的主体
 * 全限定性类名: com.lyu.pms.util.UserUtils
 * @author 曲健磊
 * @date 2018年1月27日 下午2:55:00
 * @version V1.0
 */
public class UserUtils {
	
	/**
	 * 从shiro的subject中取出身份信息
	 * @param 
	 * @return
	 */
	public static Principle getCurrentUser() {
		// 从shiro的session里面取出主体
		Subject subject = SecurityUtils.getSubject();
		// 从主体中取出身份信息
		return (Principle) subject.getPrincipal();
	}
	
	/**
	 * 从当前主体中取出当前的userId
	 * @param 
	 * @return
	 */
	public static Long getCurrentUserId() {
		return getCurrentUser().getUserId();
	}
	
}
