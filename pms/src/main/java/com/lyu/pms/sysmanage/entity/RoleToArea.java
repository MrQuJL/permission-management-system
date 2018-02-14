package com.lyu.pms.sysmanage.entity;

import java.io.Serializable;

/**
 * 类名称: 角色-区域映射对象
 * 类描述: 存储角色和区域的映射对象
 * 全限定性类名: com.lyu.pms.sysmanage.entity.RoleToArea
 * @author 曲健磊
 * @date 2018年2月5日 下午1:59:19
 * @version V1.0
 */
public class RoleToArea implements Serializable {

	private static final long serialVersionUID = 267884671076293688L;
	
	private Long roleId;
	
	private Long areaId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

}
