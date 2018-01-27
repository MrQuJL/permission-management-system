package com.lyu.drp.util;

import java.util.List;

import com.lyu.drp.sysmanage.entity.Menu;

/**
 * 类名称: 菜单工具类
 * 类描述: 封装了一些对菜单的操作
 * 全限定性类名: com.lyu.drp.util.MenuUtils
 * @author 曲健磊
 * @date 2018年1月27日 下午3:57:16
 * @version V1.0
 */
public class MenuUtils {
	
	/**
	 * 对菜单列表进行递归排序
	 * @param returnMenus	
	 * @param menuList		
	 * @param parentId		
	 */
	public static void sortMenuList(List<Menu> returnMenus, List<Menu> menuList,
		Long parentId) {
		
		// 轮询所有的菜单
		for (int i = 0; i < menuList.size(); i++) {
			Menu menu = menuList.get(i);
			// 找到第一级菜单
			if (menu.getParentId() != null && menu.getParentId().equals(parentId)) {
				returnMenus.add(menu);
				for (Menu child : menuList) {
					// 递归
					if (child.getParentId() != null && child.getParentId().equals(parentId)) {
						sortMenuList(returnMenus, menuList, menu.getId());
						break;
					}
				}
			}
		}
	}
}
