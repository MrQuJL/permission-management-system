package com.lyu.drp.sysmanage.dto;

import java.util.Date;

import com.lyu.drp.sysmanage.entity.Log;

/**
 * 类名称: 日志业务传输对象
 * 类描述: 用于传输日志的一些相关信息
 * 全限定性类名: com.lyu.drp.sysmanage.dto.LogDto
 * @author 曲健磊
 * @date 2018年2月11日 下午9:32:46
 * @version V1.0
 */
public class LogDto extends Log {

	private static final long serialVersionUID = 1869191097419014537L;
	
	private String deptName;
	
	private Date startTime;
	
	private Date endTime;
	
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
}
