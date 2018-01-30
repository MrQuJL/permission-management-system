package com.lyu.drp.sysmanage.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyu.drp.sysmanage.dto.MenuDto;
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
	
	@Autowired
	private MenuMapper menuMapper;

	@Override
	public MenuDto getMenuDetailById(Long menuId) {
		return menuMapper.getMenuDetailById(menuId);
	}
	
	@Override
	public List<Menu> getMenuListByUserId(Long userId) {
		return menuMapper.getMenuListByUserId(userId);
	}

	@Override
	public List<Menu> getAllMenuList() {
		return menuMapper.getAllMenuList();
	}
	
	@Override
	public boolean checkIsChildOrSelf(Long menuId, Long isSubMenuId) {
		
		if (isSubMenuId == menuId) {
			return true;
		}
		
		// 查询出menuId的所有子孙菜单
		List<Menu> childMenuList = null;
		getAllChildsMenuByPId(childMenuList, menuId);
		for (Menu menu : childMenuList) {
			if (menu.getId() == isSubMenuId) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 根据父级菜单的id查询出所有的子孙菜单
	 * @param 	parentMenuId	父级菜单
	 * @param 	childMenuList	子孙菜单集合
	 * @return
	 */
	public void getAllChildsMenuByPId(List<Menu> childMenuList, Long parentMenuId) {
		List<Menu> tempMenuList = menuMapper.getChildsMenuByPId(parentMenuId);
		childMenuList.addAll(tempMenuList);
		for (Menu menu : tempMenuList) {
			getAllChildsMenuByPId(childMenuList, menu.getId());
		}
	}

	@Override
	public boolean saveMenu(Menu menu) {
		boolean flag = false;
		// 设置update_by和update_date
		menu.setUpdateBy(UserUtils.getCurrentUserId().toString());
		menu.setUpdateDate(new Date());
		
		int rows = menuMapper.saveMenu(menu);
		if (rows > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean updateMenu(Menu menu) {
		boolean flag = false;
		// 设置update_by和update_date
		menu.setUpdateBy(UserUtils.getCurrentUserId().toString());
		menu.setUpdateDate(new Date());
		
		int rows = menuMapper.updateMenu(menu);
		if (rows > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean hasSubMenu(Long menuId) {
		boolean flag = true;
		int count = menuMapper.countSubMenuByPId(menuId);
		if (count == 0) { // 列表数为0表示没有子菜单
			flag = false;
		}
		return flag;
	}
	
	@Override
	public boolean delMenu(Long menuId) {
		boolean flag = false;
		int rows = menuMapper.delMenu(menuId);
		if (rows > 0) {
			flag = true;
		}
		return flag;
	}

}
