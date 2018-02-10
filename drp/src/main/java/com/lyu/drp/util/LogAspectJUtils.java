package com.lyu.drp.util;

import java.sql.Timestamp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspectJUtils {
	
	/**
	 * 记录添加方法的切面
	 * @param 
	 * @return
	 */
	@AfterReturning(value="execution(* com.lyu.drp.sysmanage.service.impl.*.add*(..))", returning="result")
	public void addAfterAdvice(JoinPoint joinPoint, Object result) {
		String userName = UserUtils.getCurrentUser().getUserName();
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
//		int operateType = 1;
		String operatorMethod = joinPoint.getSignature().getName();
		
		System.out.println("用户-" + userName + "-在" + currentTime + "通过" + operatorMethod + "-增加xx");
		
	}
	
	/**
	 * 记录删除方法的切面
	 * @param 
	 * @return
	 */
	@AfterReturning(value="execution(* com.lyu.drp.sysmanage.service.impl.*.del*(..))", returning="result")
	public void delAfterAdvice(JoinPoint joinPoint, Object result) {
		String userName = UserUtils.getCurrentUser().getUserName();
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
//		int operateType = 2;
		String operatorMethod = joinPoint.getSignature().getName();
		
		System.out.println("用户-" + userName + "-在" + currentTime + "通过" + operatorMethod + "-删除xx");
		
	}
	
	/**
	 * 记录修改方法的切面
	 * @param 
	 * @return
	 */
	@AfterReturning(value="execution(* com.lyu.drp.sysmanage.service.impl.*.update*(..))", returning="result")
	public void updateAfterAdvice(JoinPoint joinPoint, Object result) {
		String userName = UserUtils.getCurrentUser().getUserName();
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
//		int operateType = 3;
		String operatorMethod = joinPoint.getSignature().getName();
		
		System.out.println("用户-" + userName + "-在" + currentTime + "通过" + operatorMethod + "-修改xx");
		
	}
	
}
