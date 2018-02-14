package com.lyu.pms.sysmanage.entity;

import java.io.Serializable;

/**
 * 类名称: 用户-角色映射对象
 * 类描述: 存储用户和角色的对应关系
 * 全限定性类名: com.lyu.pms.sysmanage.entity.UserToRole
 * @author 曲健磊
 * @date 2018年2月7日 上午11:20:27
 * @version V1.0
 */
public class UserToRole implements Serializable {

	private static final long serialVersionUID = 267884671076293688L;
	
	private Long userId;
	
	private Long roleId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
