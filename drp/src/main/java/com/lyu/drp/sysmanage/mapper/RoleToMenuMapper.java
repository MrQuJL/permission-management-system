package com.lyu.drp.sysmanage.mapper;

import com.lyu.drp.sysmanage.entity.RoleToMenu;

/**
 * 类名称: 角色-菜单对应表mapper接口
 * 类描述: 封装了对角色-菜单对应表的一些操作
 * 全限定性类名: com.lyu.drp.sysmanage.mapper.RoleToMenuMapper
 * @author 曲健磊
 * @date 2018年2月5日 下午2:06:05
 * @version V1.0
 */
public interface RoleToMenuMapper {
	
	/**
	 * 新增角色-菜单对应表的一条记录
	 * @param 
	 * @return
	 */
	int saveRoleToMenu(RoleToMenu roleToMenu);
	
	/**
	 * 根据角色id，删除角色-菜单对应表的一条记录
	 * @param 
	 * @return
	 */
	int deleteRoleToMenu(Long roleId);
	
}
