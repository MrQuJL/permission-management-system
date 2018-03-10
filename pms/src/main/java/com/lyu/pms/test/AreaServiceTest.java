package com.lyu.pms.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lyu.pms.sysmanage.dto.AreaDto;
import com.lyu.pms.sysmanage.entity.Area;
import com.lyu.pms.sysmanage.service.IAreaService;

/**
 * 类名称: AreaService测试类
 * 类描述: 用于测试AreaService
 * 全限定性类名: com.lyu.pms.test.AreaServiceTest
 * @author 曲健磊
 * @date 2018年2月2日 上午10:29:05
 * @version V1.0
 */
public class AreaServiceTest {
	
	private Logger log = Logger.getLogger(AreaServiceTest.class);
	
	private ApplicationContext ac = null;
	
	private IAreaService areaService = null;
	
	// 在所有测试用例执行之前初始化spring的IOC容器
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		areaService = (IAreaService) ac.getBean("areaService");
	}
	
	// 查询部门列表
	@Test
	public void testGetAllAreaList() {
		List<Area> areaList = areaService.getAllAreaList();
		
		for (Area area : areaList) {
			log.info(area.toString());
		}
		
		log.info("区域总数：" + areaList.size());
	}
	
	// 查询部门列表
	@Test
	public void testGetAllSubAreasByPId() {
		List<Area> areaList = areaService.getAllSubAreasByPId(9L);
		System.out.println(areaList.size());
	}
	
	// 查询部门列表
	@Test
	public void testAddArea() {
		Area area = new Area();
		area.setParentId(1L);
		area.setName("小光");
		area.setCode("102");
		area.setSort(12L);
		area.setRemarks("这是测试数据");
		System.out.println(areaService.saveArea(area));
	}
	
	// 获取部门的详细信息
	@Test
	public void testGetAreaDetail() {
		AreaDto areaDto = areaService.getAreaDetailById(9L);
		System.out.println(areaDto);
	}
}
