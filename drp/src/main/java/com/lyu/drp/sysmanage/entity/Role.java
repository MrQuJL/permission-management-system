package com.lyu.drp.sysmanage.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 类名称: 角色对象
 * 类描述: 用于存储角色的数据
 * 全限定性类名: com.lyu.drp.sysmanage.entity.Role
 * @author 曲健磊
 * @date 2018年1月18日 上午11:13:11
 * @version V1.0
 */
public class Role implements Serializable {
	private static final long serialVersionUID = 7372493617787195608L;
	
	private Integer id;
    private Integer officeId;
    private String name;
    private String dataScope;
    private String isSys;
    private String useable;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    private String remarks;
    private String delFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDataScope() {
        return dataScope;
    }

    public void setDataScope(String dataScope) {
        this.dataScope = dataScope == null ? null : dataScope.trim();
    }

    public String getIsSys() {
        return isSys;
    }

    public void setIsSys(String isSys) {
        this.isSys = isSys == null ? null : isSys.trim();
    }

    public String getUseable() {
        return useable;
    }

    public void setUseable(String useable) {
        this.useable = useable == null ? null : useable.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
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
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
	
}
