package com.lyu.pms.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lyu.pms.sysmanage.entity.Log;
import com.lyu.pms.sysmanage.service.ILogService;

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
	@AfterReturning(value="execution(* com.lyu.pms.sysmanage.service.impl.*.save*(..))", returning="result")
	public void addAfterAdvice(JoinPoint joinPoint, Object result) {
		String operatorMethod = joinPoint.getSignature().getName();
		Log log = new Log();
		log.setType("操作日志");
		log.setTitle(operatorMethod);
		logService.insertLog(log);
	}
	
	/**
	 * 记录删除方法的切面
	 * @param 
	 * @return
	 */
	@AfterReturning(value="execution(* com.lyu.pms.sysmanage.service.impl.*.del*(..))", returning="result")
	public void delAfterAdvice(JoinPoint joinPoint, Object result) {
		String operatorMethod = joinPoint.getSignature().getName();
		Log log = new Log();
		log.setType("操作日志");
		log.setTitle(operatorMethod);
		logService.insertLog(log);
	}
	
	/**
	 * 记录修改方法的切面
	 * @param 
	 * @return
	 */
	@AfterReturning(value="execution(* com.lyu.pms.sysmanage.service.impl.*.update*(..))", returning="result")
	public void updateAfterAdvice(JoinPoint joinPoint, Object result) {
		String operatorMethod = joinPoint.getSignature().getName();
		Log log = new Log();
		log.setType("操作日志");
		log.setTitle(operatorMethod);
		logService.insertLog(log);
	}
}
