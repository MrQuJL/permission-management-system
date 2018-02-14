package com.lyu.pms.sysmanage.dto;

import java.util.Date;

import com.lyu.pms.sysmanage.entity.Log;

/**
 * 类名称: 日志业务传输对象
 * 类描述: 用于传输日志的一些相关信息
 * 全限定性类名: com.lyu.pms.sysmanage.dto.LogDto
 * @author 曲健磊
 * @date 2018年2月11日 下午9:32:46
 * @version V1.0
 */
public class LogDto extends Log {

	private static final long serialVersionUID = 1869191097419014537L;
	
	private String deptName;
	
	private Date beginDate;
	
	private Date endDate;
	
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
