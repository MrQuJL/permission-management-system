package com.lyu.drp.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lyu.drp.sysmanage.entity.Menu;
import com.lyu.drp.sysmanage.service.IMenuService;

/**
 * 类名称: MenuService测试类
 * 类描述: 用于测试MenuService
 * 全限定性类名: com.lyu.drp.test.MenuServiceTest
 * @author 曲健磊
 * @date 2018年1月23日 下午1:15:18
 * @version V1.0
 */
public class MenuServiceTest {
	private ApplicationContext ac = null;
	private IMenuService menuService = null;
	
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		menuService = (IMenuService) ac.getBean("menuService");
	}
	
	// 查询字典列表
	@Test
	public void testGetMenuListByUser() {
		List<Menu> menuList = menuService.getMenuListByUser(1L);
		
		for (Menu menu : menuList) {
			System.out.println(menu);
		}
		
	}
	
}
