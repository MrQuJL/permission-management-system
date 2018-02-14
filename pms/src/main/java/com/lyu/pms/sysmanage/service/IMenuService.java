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
	 * @param 
	 * @return
	 */
	MenuDto getMenuDetailById(Long menuId);
	
	/**
	 * 根据用户的id获取用户所能够操作的用户列表
	 * @param userId 用户的id
	 * @return 
	 */
	List<Menu> getMenuListByUserId(Long userId);
	
	/**
	 * 获取所有的字典列表 
	 * @param 
	 * @return
	 */
	List<Menu> getAllMenuList();
	
	/**
	 * 判断id为isSubMenuId的菜单是否是id为menuId的子菜单或者它自己
	 * @param 	menuId		当前菜单
	 * @param 	isSubMenuId	待确认的菜单
	 * @return
	 */
	boolean checkIsChildOrSelf(Long menuId, Long isSubMenuId);
	
	/**
	 * 根据父级菜单的id查询出所有的子孙菜单
	 * @param 	parentMenuId	父级菜单
	 * @param 	childMenuList	子孙菜单集合
	 * @return
	 */
	void getAllChildsMenuByPId(List<Menu> childMenuList, Long parentMenuId);
	
	/**
	 * 添加菜单
	 * @param 
	 * @return
	 */
	boolean saveMenu(Menu menu);
	
	/**
	 * 修改菜单
	 * @param 
	 * @return
	 */
	boolean updateMenu(Menu menu);
	
	/**
	 * 判断当前菜单是否有子菜单
	 * @param 
	 * @return true 表示有子菜单	false 表示没有子菜单
	 */
	boolean hasSubMenu(Long menuId);
	
	/**
	 * 删除指定id的菜单(逻辑删除，修改标识位)
	 * @param 
	 * @return
	 */
	boolean delMenu(Long menuId);
	
}
