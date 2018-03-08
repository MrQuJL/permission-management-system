package com.lyu.pms.sysmanage.mapper;

import java.util.List;

import com.lyu.pms.sysmanage.dto.MenuDto;
import com.lyu.pms.sysmanage.entity.Menu;

/**
 * 类名称: 用于访问菜单的mapper接口
 * 类描述: 对菜单的一些增删改查
 * 全限定性类名: com.lyu.pms.sysmanage.mapper.MenuMapper
 * @author 曲健磊
 * @date 2018年1月23日 下午12:39:09
 * @version V1.0
 */
public interface MenuMapper {
	
	/**
	 * 通过菜单id获取菜单的详细信息
	 * @param menuId 要查询的菜单id
	 * @return 菜单的详细信息
	 */
	MenuDto getMenuDetailById(Long menuId);
	
	/**
	 * 根据用户的id获取用户所能够操作的菜单列表
	 * @param userId 用户的id
	 * @return 该用户所拥有的菜单列表
	 */
	List<Menu> getMenuListByUserId(Long userId);
	
	/**
	 * 获取所有的字典列表 
	 * @return 所有的菜单列表
	 */
	List<Menu> getAllMenuList();
	
	/**
	 * 通过角色id查询菜单列表
	 * @param roleId 角色id
	 * @return 该角色所拥有的菜单列表
	 */
	List<Menu> getMenuListByRoleId(Long roleId);
	
	/**
	 * 查询出当前菜单的所有子菜单
	 * @param	parentId 当前菜单 
	 * @return id为parentId的所有子菜单
	 */
	List<Menu> getChildsMenuByPId(Long parentId);
	
	/**
	 * 添加菜单
	 * @param menu 要添加的菜单
	 * @return 受影响的行数，1表示添加成功，否则失败
	 */
	int saveMenu(Menu menu);
	
	/**
	 * 修改菜单
	 * @param menu 要修改的菜单
	 * @return 受影响的行数，1表示修改成功，否则失败
	 */
	int updateMenu(Menu menu);
	
	/**
	 * 获取菜单id为menuId的所有子菜单的详细信息
	 * @param menuId 菜单id
	 * @return id为menuId的所有子菜单
	 */
	List<Menu> getSubMenuByPId(Long menuId);
	
	/**
	 * 获取当前菜单的所有子菜单的个数
	 * @param menuId 菜单id
	 * @return id为menuId的所有子菜单的个数
	 */
	int countSubMenuByPId(Long menuId);
	
	/**
	 * 删除指定id的菜单(逻辑删除，修改标识位)
	 * @param menuId 菜单id
	 * @return 受影响的行数，1表示删除成功，否则失败
	 */
	int delMenu(Long menuId);
	
}
