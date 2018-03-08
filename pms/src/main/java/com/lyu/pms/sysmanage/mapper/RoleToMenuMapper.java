package com.lyu.pms.sysmanage.mapper;

import com.lyu.pms.sysmanage.entity.RoleToMenu;

/**
 * 类名称: 角色-菜单对应表mapper接口
 * 类描述: 封装了对角色-菜单对应表的一些操作
 * 全限定性类名: com.lyu.pms.sysmanage.mapper.RoleToMenuMapper
 * @author 曲健磊
 * @date 2018年2月5日 下午2:06:05
 * @version V1.0
 */
public interface RoleToMenuMapper {
	
	/**
	 * 新增角色-菜单对应表的一条记录
	 * @param roleToMenu 角色菜单对应对象
	 * @return 受影响的行数，1表示影响一行，0表示影响0行，以此类推
	 */
	int saveRoleToMenu(RoleToMenu roleToMenu);
	
	/**
	 * 根据角色id，删除角色-菜单对应表的记录
	 * @param roleId 角色id
	 * @return 受影响的行数，1表示影响一行，0表示影响0行，以此类推
	 */
	int deleteRoleToMenu(Long roleId);
	
	/**
	 * 根据菜单id，删除角色-菜单对应表的记录
	 * @param 菜单id
	 * @return 受影响的行数，1表示影响一行，0表示影响0行，以此类推
	 */
	int deleteRoleToMenuByMId(Long menuId);
	
}
