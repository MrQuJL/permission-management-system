package com.lyu.drp.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lyu.drp.sysmanage.entity.Dept;
import com.lyu.drp.sysmanage.service.IDeptService;

/**
 * 类名称: DeptService测试类
 * 类描述:用于测试DeptService
 * 全限定性类名: com.lyu.drp.test.DeptServiceTest
 * @author 曲健磊
 * @date 2018年1月30日 下午4:45:44
 * @version V1.0
 */
public class DeptServiceTest {
	
	private Logger log = Logger.getLogger(DeptServiceTest.class);
	
	private ApplicationContext ac = null;
	
	private IDeptService deptService = null;
	
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		deptService = (IDeptService) ac.getBean("deptService");
	}
	
	// 查询部门列表
	@Test
	public void testGetAllDeptList() {
		List<Dept> deptList = deptService.getAllDeptList();
		
		for (Dept dept : deptList) {
			log.info(dept.toString());
		}
		log.info("部门总数：" + deptList.size());
		
	}
	
}
