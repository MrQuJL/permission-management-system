package com.lyu.drp.sysmanage.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 类名称: 角色实体类
 * 类描述: 封装了角色的一些信息
 * 全限定性类名: com.lyu.drp.sysmanage.entity.Role
 * @author 曲健磊
 * @date 2018年2月4日 下午3:35:14
 * @version V1.0
 */
public class Role implements Serializable {
	
	private static final long serialVersionUID = 7760855492800895240L;

	private Long id;

    private String name;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String delFlag;
    
    private List<Menu> menuList;
    
    private List<Dept> deptList;
    
    private List<Area> areaList;
    
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

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public List<Dept> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<Dept> deptList) {
		this.deptList = deptList;
	}

	public List<Area> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<Area> areaList) {
		this.areaList = areaList;
	}
	
}