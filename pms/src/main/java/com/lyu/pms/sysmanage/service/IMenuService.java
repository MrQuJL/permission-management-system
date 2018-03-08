package com.lyu.pms.sysmanage.service;

import java.util.List;

import com.lyu.pms.sysmanage.dto.MenuDto;
import com.lyu.pms.sysmanage.entity.Menu;

/**
 * 类名称: 菜单服务类接口
 * 类描述: 用于操作菜单的服务类
 * 全限定性类名: com.lyu.pms.sysmanage.service.IMenuService
 * @author 曲健磊
 * @date 2018年1月23日 下午1:10:25
 * @version V1.0
 */
public interface IMenuService {

	/**
	 * 通过菜单id获取菜单的详细信息
	 * @param menuId 菜单id
	 * @return id为menuId的菜单的详细信息
	 */
	MenuDto getMenuDetailById(Long menuId);
	
	/**
	 * 根据用户的id获取用户所能够操作的菜单列表
	 * @param userId 用户的id
	 * @return id为userId的用户所能够操作的菜单列表
	 */
	List<Menu> getMenuListByUserId(Long userId);
	
	/**
	 * 获取所有的菜单列表
	 * @return 所有的菜单列表
	 */
	List<Menu> getAllMenuList();
	
	/**
	 * 判断id为isSubMenuId的菜单是否是id为menuId的子菜单或者它自己
	 * @param menuId 当前菜单
	 * @param isSubMenuId 菜单id
	 * @return true则说明isSubMenuId是menuId的子菜单
	 */
	boolean checkIsChildOrSelf(Long menuId, Long isSubMenuId);
	
	/**
	 * 根据父级菜单的id查询出所有的子孙菜单
	 * @param parentMenuId 父级菜单
	 * @param childMenuList	父级菜单id为parentMenuId的子孙菜单集合
	 * @return null
	 */
	void getAllChildsMenuByPId(List<Menu> childMenuList, Long parentMenuId);
	
	/**
	 * 添加菜单
	 * @param menu 待添加的菜单
	 * @return true则添加菜单成功，false则失败
	 */
	boolean saveMenu(Menu menu);
	
	/**
	 * 修改菜单
	 * @param menu 待修改的菜单
	 * @return true则修改菜单成功，false则失败
	 */
	boolean updateMenu(Menu menu);
	
	/**
	 * 判断当前菜单是否有子菜单
	 * @param menuId 菜单id
	 * @return true表示有子菜单，false表示没有子菜单
	 */
	boolean hasSubMenu(Long menuId);
	
	/**
	 * 删除指定id的菜单(逻辑删除，修改标识位)
	 * @param menuId 待删除的菜单id
	 * @return true则删除菜单成功，false则失败
	 */
	boolean delMenu(Long menuId);
	
}
