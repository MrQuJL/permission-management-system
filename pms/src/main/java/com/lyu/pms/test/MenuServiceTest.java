package com.lyu.pms.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lyu.pms.sysmanage.dto.MenuDto;
import com.lyu.pms.sysmanage.entity.Menu;
import com.lyu.pms.sysmanage.service.IMenuService;

/**
 * 类名称: MenuService测试类
 * 类描述: 用于测试MenuService
 * 全限定性类名: com.lyu.pms.test.MenuServiceTest
 * @author 曲健磊
 * @date 2018年1月23日 下午1:15:18
 * @version V1.0
 */
public class MenuServiceTest {
	
	private ApplicationContext ac = null;
	
	private IMenuService menuService = null;
	
	// 在所有测试用例执行之前初始化spring的IOC容器
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		menuService = (IMenuService) ac.getBean("menuService");
	}
	
	// 查询字典列表
	@Test
	public void testGetMenuListByUser() {
		List<Menu> menuList = menuService.getMenuListByUserId(1L);
		
		for (Menu menu : menuList) {
			System.out.println(menu);
		}
		
	}
	
	// 查询字典列表
	@Test
	public void testGetAllChildsMenuByPId() {
		List<Menu> menuList = new ArrayList<Menu>();
		menuService.getAllChildsMenuByPId(menuList , 3L);
		
		for (Menu menu : menuList) {
			System.out.println(menu.getId());
			System.out.println(menu.getName());
		}
		
	}
	
	// 新增菜单
	@Test
	public void testSaveMenu() {
		Menu menu = new Menu();
		menu.setParentId(1L);
		menu.setName("测试菜dfdf单");
		menu.setSort(152L);
		menu.setHref("e");
		menu.setTarget("e");
		menu.setIcon("icon-glass");
		menu.setIsShow("1");
		menu.setPermission("e");
		menu.setUpdateBy("1");
		menu.setUpdateDate(new Date(System.currentTimeMillis()));
		menu.setRemarks("test hello");
		
		boolean flag = menuService.saveMenu(menu);
		
		if (flag) {
			System.out.println("添加菜单成功");
		} else {
			System.out.println("添加菜单失败!");
		}
	}
	
	// 新增菜单
	@Test
	public void testUpdateMenu() {
		Menu menu = new Menu();
		menu.setId(35L);
		menu.setParentId(1L);
		menu.setName("测试菜单");
		menu.setSort(13L);
		menu.setHref("eee");
		menu.setTarget("eee");
		menu.setIcon("eee");
		menu.setIsShow("1");
		menu.setPermission("eee");
		menu.setUpdateBy("1");
		menu.setUpdateDate(new Date(System.currentTimeMillis()));
		menu.setRemarks("test hello");
		
		boolean flag = menuService.updateMenu(menu);
		
		if (flag) {
			System.out.println("修改菜单成功");
		} else {
			System.out.println("修改菜单失败!");
		}
	}
	
	// 新增菜单
	@Test
	public void testGetMenuById() {
		MenuDto menuDto = menuService.getMenuDetailById(1L);
		System.out.println(menuDto);
	}
	
	// 删除菜单
	@Test
	public void testCountMenuByPId() {
		boolean flag = menuService.hasSubMenu(10L);
		if (flag) {
			System.out.println("有子菜单");
		} else {
			System.out.println("没有子菜单");
		}
	}
	
	// 删除菜单
	@Test
	public void testDelMenu() {
		boolean flag = menuService.delMenu(35L);
		System.out.println(flag);
	}
	
}
