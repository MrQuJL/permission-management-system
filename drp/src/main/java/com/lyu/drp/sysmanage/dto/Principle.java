package com.lyu.drp.sysmanage.dto;

import java.io.Serializable;
import java.util.List;

import com.lyu.drp.sysmanage.entity.Menu;

/**
 * 类名称: 身份信息
 * 类描述: 用于记录访问和的身份信息
 * 全限定性类名: com.lyu.drp.sysmanage.dto.Principle
 * @author 曲健磊
 * @date 2018年1月23日 上午10:07:22
 * @version V1.0
 */
public class Principle implements Serializable {
	
	private static final long serialVersionUID = -8011071300503310539L;
	
	private Long userId;
	
	private String loginName;
	
	private String userName;
	
	private List<Menu> menuList;
	
	public List<Menu> getMenuList() {
		return menuList;
	}
	
	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
