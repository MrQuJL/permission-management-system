package com.lyu.pms.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lyu.pms.sysmanage.entity.Log;
import com.lyu.pms.sysmanage.service.ILogService;

/**
 * 类名称：日志工具类
 * 类描述：以aop方式记录日志
 * 全限定性类名: com.lyu.pms.util.LogAspectJUtils
 * @author 曲健磊
 * @date 2018年3月10日下午4:50:27
 * @version V1.0
 */
@Component
@Aspect
public class LogAspectJUtils {
	
	@Autowired
	private ILogService logService;
	
	/**
	 * 记录添加方法的切面
	 * @param joinPoint 切入点，可以获取被切入方法的名称
	 * @param result 被切入方法的返回值
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
	 * @param joinPoint 切入点，可以获取被切入方法的名称
	 * @param result 被切入方法的返回值
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
	 * @param joinPoint 切入点，可以获取被切入方法的名称
	 * @param result 被切入方法的返回值
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
