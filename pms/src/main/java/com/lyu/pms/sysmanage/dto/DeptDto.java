package com.lyu.pms.sysmanage.dto;

import java.io.Serializable;

import com.lyu.pms.sysmanage.entity.Dept;

/**
 * 类名称: 部门业务类
 * 类描述: 传输与部门相关的一些信息，父部门名称
 * 全限定性类名: com.lyu.pms.sysmanage.dto.DeptDto
 * @author 曲健磊
 * @date 2018年1月31日 上午10:03:43
 * @version V1.0
 */
public class DeptDto extends Dept implements Serializable {
	
	private static final long serialVersionUID = 4282362845767317022L;
	
	private String parentName;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
}
