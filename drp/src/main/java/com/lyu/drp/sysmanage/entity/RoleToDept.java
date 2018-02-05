package com.lyu.drp.sysmanage.entity;

import java.io.Serializable;

/**
 * 类名称: 角色-部门映射对象
 * 类描述: 存储角色和部门的映射对象
 * 全限定性类名: com.lyu.drp.sysmanage.entity.RoleToDept
 * @author 曲健磊
 * @date 2018年2月5日 下午1:58:16
 * @version V1.0
 */
public class RoleToDept implements Serializable {

	private static final long serialVersionUID = 267884671076293688L;
	
	private Long roleId;
	
	private Long deptId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

}
