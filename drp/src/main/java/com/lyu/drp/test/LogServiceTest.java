package com.lyu.drp.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lyu.drp.sysmanage.entity.Log;
import com.lyu.drp.sysmanage.service.ILogService;

/**
 * 类名称: LogService测试类
 * 类描述: 用于测试LogService
 * 全限定性类名: com.lyu.drp.test.LogServiceTest
 * @author 曲健磊
 * @date 2018年2月11日 下午11:33:54
 * @version V1.0
 */
public class LogServiceTest {
	private ApplicationContext ac = null;
	private ILogService logService = null;
	
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		logService = (ILogService) ac.getBean("logService");
	}
	
	// 新增日志
	@Test
	public void testSaveLog() {
		Log log = new Log();
		log.setCreateBy("张三");
		log.setTitle("删除");
		log.setType("操作日志");
		log.setDeptId(12L);
		log.setCreateDate("2017-10-10");
		
		boolean flag = logService.insertLog(log);
		
		if (flag) {
			System.out.println("添加菜单成功");
		} else {
			System.out.println("添加菜单失败!");
		}
	}
	
	
}
