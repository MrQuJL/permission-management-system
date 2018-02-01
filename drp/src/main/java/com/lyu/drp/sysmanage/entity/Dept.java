package com.lyu.drp.sysmanage.entity;

import java.io.Serializable;
import java.util.Date;

import com.lyu.drp.sysmanage.dto.TreeDto;

/**
 * 类名称: 部门类
 * 类描述: 封装部门表的相关数据
 * 全限定性类名: com.lyu.drp.sysmanage.entity.Dept
 * @author 曲健磊
 * @date 2018年1月30日 下午4:06:31
 * @version V1.0
 */
public class Dept extends TreeDto implements Serializable {
	
	private static final long serialVersionUID = 3150198761755032726L;

    private Long sort;

    private String code;

    private String address;

    private String master;

    private String phone;

    private String fax;

    private String email;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String delFlag;

	public Long getSort() {
		return sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	
}
