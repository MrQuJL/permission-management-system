package com.lyu.drp.util;

import java.sql.Timestamp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lyu.drp.sysmanage.entity.Log;
import com.lyu.drp.sysmanage.service.ILogService;

@Component
@Aspect
public class LogAspectJUtils {
	
	@Autowired
	private ILogService logService;
	
	/**
	 * 记录添加方法的切面
	 * @param 
	 * @return
	 */
	@AfterReturning(value="execution(* com.lyu.drp.sysmanage.service.impl.*.save*(..))", returning="result")
	public void addAfterAdvice(JoinPoint joinPoint, Object result) {
		String operatorMethod = joinPoint.getSignature().getName();
		Log log = new Log();
		log.setType("操作日志");
		log.setTitle(operatorMethod);
		
		boolean flag = logService.insertLog(log);
		
		System.out.println(flag ? "成功" : "失败");
		
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
		String operatorMethod = joinPoint.getSignature().getName();
		
		System.out.println("用户-" + userName + "-在" + currentTime + "通过" + operatorMethod + "-修改xx");
		
	}
	
}
