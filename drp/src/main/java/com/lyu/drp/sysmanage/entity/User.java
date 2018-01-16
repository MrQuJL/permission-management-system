package com.lyu.drp.sysmanage.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 类名称: 用户对象bean
 * 类描述: 用于存储用户的数据
 * 全限定性类名: com.lyu.drp.sysmanage.entity.User
 * @author 曲健磊
 * @date 2018年1月15日 下午11:31:23
 * @version V1.0
 */
public class User implements Serializable {
	private static final long serialVersionUID = 7372493617787195608L;
	
	private Long id;
	private Long companyId;
	private Long officeId;
	private String loginName;
	private String	password;	 
	private String	no;
	private String name;
	private String	email;
	private String	phone;
	private String	mobile;
	private String	loginIp;
	private Timestamp	loginDate;
	private String	loginFlag;
	private String	createBy;
	private Timestamp createDate;
	private String	updateBy;
	private Timestamp updateDate;
	private String remarks;
 
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getCompanyId() {
		return companyId;
	}
	
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	
	public Long getOfficeId() {
		return officeId;
	}
	
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}
	
	public String getLoginName() {
		return loginName;
	}
	
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNo() {
		return no;
	}
	
	public void setNo(String no) {
		this.no = no;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getLoginIp() {
		return loginIp;
	}
	
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	
	public Timestamp getLoginDate() {
		return loginDate;
	}
	
	public void setLoginDate(Timestamp loginDate) {
		this.loginDate = loginDate;
	}
	
	public String getLoginFlag() {
		return loginFlag;
	}
	
	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}
	
	public String getCreateBy() {
		return createBy;
	}
	
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	
	public String getUpdateBy() {
		return updateBy;
	}
	
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
	public Timestamp getUpdateDate() {
		return updateDate;
	}
	
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
	
	public String getRemarks() {
		return remarks;
	}
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public Timestamp getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	
}
