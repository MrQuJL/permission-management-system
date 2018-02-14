package com.lyu.pms.sysmanage.entity;

import java.io.Serializable;

/**
 * 类名称: 日志实体类
 * 类描述: 用于存储日志的信息
 * 全限定性类名: com.lyu.pms.sysmanage.entity.Log
 * @author 曲健磊
 * @date 2018年2月11日 下午9:20:47
 * @version V1.0
 */
public class Log implements Serializable {

	private static final long serialVersionUID = -1111993073222969373L;
	
	private Long id;
	
	private Long deptId;
	
	private String type;
	
	private String title;
	
	private String createBy;
	
	private String createDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
}