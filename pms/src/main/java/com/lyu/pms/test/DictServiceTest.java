package com.lyu.pms.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageInfo;
import com.lyu.pms.common.dto.PageParam;
import com.lyu.pms.sysmanage.entity.Dict;
import com.lyu.pms.sysmanage.service.IDictService;

/**
 * 类名称: 字典管理测试类
 * 类描述: 测试字典的管理
 * 全限定性类名: com.lyu.pms.test.DictServiceTest
 * @author 曲健磊
 * @date 2018年1月19日 下午8:28:22
 * @version V1.0
 */
public class DictServiceTest {
	private ApplicationContext ac = null;
	private IDictService dictService = null;
	
	// 在所有测试用例执行之前初始化spring的IOC容器
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		dictService = (IDictService) ac.getBean("dictService");
	}
	
	// 查询字典列表
	@Test
	public void testGetDictListPage() {
		
		PageInfo<Dict> pageInfo =  dictService.getDictListPage(null, new PageParam()); 
		
		System.out.println(pageInfo.getList().size());
	}
	
	// 查询所有的字典类型
	@Test
	public void testGetDictTypeList() {
		
		List<String> dictTypeList = dictService.getDictTypeList();
		
		System.out.println(dictTypeList.size());
	}
	
	// 查询指定id的字典
	@Test
	public void testGetDictById() {
		
		Dict dict = dictService.getDictById(1L);
		
		System.out.println(dict);
	}
	
	// 测试删除字典(逻辑删除)
	@Test
	public void testDelDictById() {
		int rows = dictService.delDictById(101L);
		
		if (rows > 0) {
			System.out.println("逻辑删除表数据成功");
		} else {
			System.out.println("逻辑删除表数据失败");
		}
	}
}
