package com.lyu.drp.sysmanage.service.impl;

import java.sql.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyu.drp.sysmanage.entity.Menu;
import com.lyu.drp.sysmanage.mapper.MenuMapper;
import com.lyu.drp.sysmanage.service.IMenuService;
import com.lyu.drp.util.UserUtils;

/**
 * 类名称: menuService实现类
 * 类描述: 实现了menuService的一些接口
 * 全限定性类名: com.lyu.drp.sysmanage.service.impl.MenuService
 * @author 曲健磊
 * @date 2018年1月23日 下午1:11:52
 * @version V1.0
 */
@Service("menuService")
public class MenuService implements IMenuService {
	
	private Logger log = Logger.getLogger(MenuService.class);
	
	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public List<Menu> getMenuListByUser(Long userId) {
		return menuMapper.getMenuListByUserId(userId);
	}

	@Override
	public List<Menu> getAllMenuList() {
		return menuMapper.getAllMenuList();
	}

	@Override
	public boolean saveMenu(Menu menu) {
		boolean flag = false;
		// 设置update_by和update_date
		menu.setUpdateBy(UserUtils.getCurrentUserId().toString());
		menu.setUpdateDate(new Date(System.currentTimeMillis()));
		
		int rows = menuMapper.saveMenu(menu);
		if (rows > 0) {
			flag = true;
		}
		return flag;
	}
	
}
