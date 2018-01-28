package com.lyu.drp.sysmanage.service;

import java.util.List;

import com.lyu.drp.sysmanage.dto.MenuDto;
import com.lyu.drp.sysmanage.entity.Menu;

/**
 * 类名称: 菜单服务类接口
 * 类描述: 用于操作菜单的服务类
 * 全限定性类名: com.lyu.drp.sysmanage.service.IMenuService
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
	public MenuDto getMenuDetailById(Long menuId);
	
	/**
	 * 根据用户的id获取用户所能够操作的用户列表
	 * @param userId 用户的id
	 * @return 
	 */
	public List<Menu> getMenuListByUser(Long userId);
	
	/**
	 * 获取所有的字典列表 
	 * @param 
	 * @return
	 */
	public List<Menu> getAllMenuList();
	
	/**
	 * 添加菜单
	 * @param 
	 * @return
	 */
	public boolean saveMenu(Menu menu);
	
	/**
	 * 修改菜单
	 * @param 
	 * @return
	 */
	public boolean updateMenu(Menu menu);
	
	/**
	 * 删除指定id的菜单(逻辑删除，修改标识位)
	 * @param 
	 * @return
	 */
	public boolean delMenu(Long menuId);
	
}
