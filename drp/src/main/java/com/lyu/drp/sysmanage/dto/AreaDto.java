package com.lyu.drp.sysmanage.dto;

import com.lyu.drp.sysmanage.entity.Area;

/**
 * 类名称: area业务数据传输类
 * 类描述: 用于传输与area有关的数据
 * 全限定性类名: com.lyu.drp.sysmanage.dto.AreaDto
 * @author 曲健磊
 * @date 2018年2月2日 下午2:21:38
 * @version V1.0
 */
public class AreaDto extends Area {

	private static final long serialVersionUID = 3668963521201209405L;
	
	private String parentName;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
}
