package com.lyu.pms.sysmanage.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lyu.pms.sysmanage.dto.MenuDto;
import com.lyu.pms.sysmanage.entity.Menu;
import com.lyu.pms.sysmanage.entity.RoleToMenu;
import com.lyu.pms.sysmanage.mapper.MenuMapper;
import com.lyu.pms.sysmanage.mapper.RoleMapper;
import com.lyu.pms.sysmanage.mapper.RoleToMenuMapper;
import com.lyu.pms.sysmanage.service.IMenuService;
import com.lyu.pms.util.UserUtils;

/**
 * 类名称: menuService实现类
 * 类描述: 实现了menuService的一些接口
 * 全限定性类名: com.lyu.pms.sysmanage.service.impl.MenuService
 * @author 曲健磊
 * @date 2018年1月23日 下午1:11:52
 * @version V1.0
 */
@Service("menuService")
public class MenuService implements IMenuService {
	@Autowired
	private MenuMapper menuMapper;
	
	private List<Menu> childMenuList;

	@Autowired
	private EhCacheManager cacheManager;
	
	@Autowired
	private RoleToMenuMapper roleToMenuMapper;
	
	@Autowired
	private RoleMapper roleMapper;
	
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
		
		childMenuList = null;
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
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public boolean saveMenu(Menu menu) {
		boolean flag = false;
		// 设置update_by和update_date
		menu.setUpdateBy(UserUtils.getCurrentUserId().toString());
		menu.setUpdateDate(new Date());
		
		int rows = menuMapper.saveMenu(menu);
		if (rows > 0) {
			flag = true;
		}
		// 添加完菜单后还要再相应的角色-菜单对应表中为当前用户以及系统管理员添加一条记录
		List<Long> roleIds = this.roleMapper.getRoleIdsByUId(UserUtils.getCurrentUserId());
		for (Long roleId : roleIds) {
			RoleToMenu roleToMenu = new RoleToMenu();
			roleToMenu.setRoleId(roleId);
			roleToMenu.setMenuId(menu.getId());
			this.roleToMenuMapper.saveRoleToMenu(roleToMenu);
		}
		if (!roleIds.contains(1L)) {
			RoleToMenu roleToMenu = new RoleToMenu();
			roleToMenu.setRoleId(1L);
			roleToMenu.setMenuId(menu.getId());
			this.roleToMenuMapper.saveRoleToMenu(roleToMenu);
		}
		
		return flag;
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public boolean updateMenu(Menu menu) {
		boolean flag = false;
		// 设置update_by和update_date
		menu.setUpdateBy(UserUtils.getCurrentUserId().toString());
		menu.setUpdateDate(new Date());
		
		int rows = menuMapper.updateMenu(menu);
		if (rows > 0) {
			flag = true;
		}
		// 修改了信息都要清空shiro的缓存
		cacheManager.getCacheManager().removalAll();
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
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public boolean delMenu(Long menuId) {
		boolean flag = false;
		// 删除映射表中的数据，先删除从表再删除主表
		this.roleToMenuMapper.deleteRoleToMenuByMId(menuId);
		
		int rows = menuMapper.delMenu(menuId);
		if (rows > 0) {
			flag = true;
		}
		
		// 修改了信息都要清空shiro的缓存
		cacheManager.getCacheManager().removalAll();
		return flag;
	}

}
