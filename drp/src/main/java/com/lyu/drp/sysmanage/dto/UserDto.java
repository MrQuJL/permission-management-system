package com.lyu.drp.sysmanage.dto;

import java.io.Serializable;
import java.util.List;

import com.lyu.drp.sysmanage.entity.Role;
import com.lyu.drp.sysmanage.entity.User;

/**
 * 类名称: 用户数据传输对象
 * 类描述: 用于传输用户以及所关联的部门公司信息
 * 全限定性类名: com.lyu.drp.sysmanage.dto.UserDto
 * @author 曲健磊
 * @date 2018年1月18日 上午11:03:03
 * @version V1.0
 */
public class UserDto extends User implements Serializable {

	private static final long serialVersionUID = 4282362845767317022L;
	
	private String companyName;
	private String officeName;
	private List<Role> roleList;
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getOfficeName() {
		return officeName;
	}
	
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	
	public List<Role> getRoleList() {
		return roleList;
	}
	
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
}
