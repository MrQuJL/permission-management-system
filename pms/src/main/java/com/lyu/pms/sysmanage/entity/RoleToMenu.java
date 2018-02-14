package com.lyu.pms.sysmanage.entity;

import java.io.Serializable;

/**
 * 类名称: 角色-菜单映射对象
 * 类描述: 存储角色和菜单的映射对象
 * 全限定性类名: com.lyu.pms.sysmanage.entity.RoleToMenu
 * @author 曲健磊
 * @date 2018年2月5日 下午1:56:46
 * @version V1.0
 */
public class RoleToMenu implements Serializable {

	private static final long serialVersionUID = 267884671076293688L;
	
	private Long roleId;
	
	private Long menuId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	
}
