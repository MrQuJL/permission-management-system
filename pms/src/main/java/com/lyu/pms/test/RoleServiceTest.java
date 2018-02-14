package com.lyu.pms.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lyu.pms.sysmanage.entity.Area;
import com.lyu.pms.sysmanage.entity.Dept;
import com.lyu.pms.sysmanage.entity.Menu;
import com.lyu.pms.sysmanage.entity.Role;
import com.lyu.pms.sysmanage.service.IRoleService;

/**
 * 类名称: RoleService测试类
 * 类描述: RoleService测试类
 * 全限定性类名: com.lyu.pms.test.RoleServiceTest
 * @author 曲健磊
 * @date 2018年2月4日 下午8:16:14
 * @version V1.0
 */
public class RoleServiceTest {
	private ApplicationContext ac = null;
	
	private IRoleService roleService = null;
	
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		roleService = (IRoleService) ac.getBean("roleService");
	}
	
	// 查询部门列表
	@Test
	public void testGetAllRoleList() {
		Role role = roleService.getRoleById(1L);
		
		System.out.println("\nmenuList:");
		for (Menu menu : role.getMenuList()) {
			System.out.print(menu.getId() + ",");
		}
		
		System.out.println("\ndeptList:");
		for (Dept dept : role.getDeptList()) {
			System.out.print(dept.getId() + ",");
		}
		
		System.out.println("\nareaList:");
		for (Area area : role.getAreaList()) {
			System.out.print(area.getId() + ",");
		}
		
	}
}
