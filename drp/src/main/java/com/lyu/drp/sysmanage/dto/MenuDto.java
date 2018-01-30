package com.lyu.drp.sysmanage.dto;

import java.io.Serializable;

import com.lyu.drp.sysmanage.entity.Menu;

/**
 * 类名称: 菜单数据传输对象
 * 类描述: 用于传输用菜单及所关联的部门公司信息
 * 全限定性类名: com.lyu.drp.sysmanage.dto.MenuDto
 * @author 曲健磊
 * @date 2018年1月28日 下午9:01:41
 * @version V1.0
 */
public class MenuDto extends Menu implements Serializable {
	
	private static final long serialVersionUID = 4282362845767317022L;
	
	private String parentName;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	@Override
	public String toString() {
		return "MenuDto [parentName=" + parentName + ", getId()=" + getId() + ", getParentId()=" + getParentId()
				+ ", getName()=" + getName() + ", getSort()=" + getSort() + ", getHref()=" + getHref()
				+ ", getTarget()=" + getTarget() + ", getIcon()=" + getIcon() + ", getIsShow()=" + getIsShow()
				+ ", getPermission()=" + getPermission() + ", getUpdateBy()=" + getUpdateBy() + ", getUpdateDate()="
				+ getUpdateDate() + ", getRemarks()=" + getRemarks() + ", getDelFlag()=" + getDelFlag()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
	
}
