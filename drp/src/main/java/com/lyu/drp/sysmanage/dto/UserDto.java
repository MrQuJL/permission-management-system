package com.lyu.drp.sysmanage.dto;

import java.io.Serializable;

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
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
