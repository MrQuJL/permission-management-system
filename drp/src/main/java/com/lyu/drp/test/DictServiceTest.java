package com.lyu.drp.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lyu.drp.sysmanage.entity.Dict;
import com.lyu.drp.sysmanage.service.IDictService;

/**
 * 类名称: 字典管理测试类
 * 类描述: 测试字典的管理
 * 全限定性类名: com.lyu.drp.test.DictServiceTest
 * @author 曲健磊
 * @date 2018年1月19日 下午8:28:22
 * @version V1.0
 */
public class DictServiceTest {
	private ApplicationContext ac = null;
	private IDictService dictService = null;
	
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		dictService = (IDictService) ac.getBean("dictService");
	}
	
	// 查询字典列表
	@Test
	public void testGetDictList() {
		
		List<Dict> dictList = dictService.getDictList("", ""); 
		
		System.out.println(dictList.size());
	}
	
}
