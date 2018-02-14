package com.lyu.pms.sysmanage.dto;

import java.io.Serializable;

/**
 * 类名称: 树节点
 * 类描述: 封装了树节点对象的一些属性
 * 全限定性类名: com.lyu.pms.sysmanage.dto.TreeDto
 * @author 曲健磊
 * @date 2018年2月1日 下午12:03:08
 * @version V1.0
 */
public class TreeDto implements Serializable {

	private static final long serialVersionUID = 3813985282151038854L;
	// 当前节点的id
	private Long id;
	// 当前节点的name
	private String name;
	// 当前节点的父id
	private Long parentId;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getParentId() {
		return parentId;
	}
	
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
}
