package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessDepartment;
import com.community.app.module.vo.BaseBean;

public class BusinessDepartmentQuery extends BaseBean {
	

	private java.lang.Integer depId;
	private java.lang.String depName;
	private java.lang.String depDesc;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.String orgType;
	private java.lang.Integer orgId;
	private java.lang.String orgName;
	private Integer userId;

	public BusinessDepartmentQuery(BusinessDepartment businessDepartment) {
		this.depId = businessDepartment.getDepId();
		this.depName = businessDepartment.getDepName();
		this.depDesc = businessDepartment.getDepDesc();
		this.createTime = businessDepartment.getCreateTime();
		this.editTime = businessDepartment.getEditTime();
		this.editor = businessDepartment.getEditor();
		this.orgType = businessDepartment.getOrgType();
		this.orgId = businessDepartment.getOrgId();
		this.orgName = businessDepartment.getOrgName();
		this.userId = businessDepartment.getUserId();
	}
	
	public BusinessDepartmentQuery() {
		
	}	
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public java.lang.Integer getDepId() {
		return this.depId;
	}
	
	public void setDepId(java.lang.Integer value) {
		this.depId = value;
	}
		
	public java.lang.String getDepName() {
		return this.depName;
	}
	
	public void setDepName(java.lang.String value) {
		this.depName = value;
	}
		
	public java.lang.String getDepDesc() {
		return this.depDesc;
	}
	
	public void setDepDesc(java.lang.String value) {
		this.depDesc = value;
	}
		
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
		
	public java.sql.Timestamp getEditTime() {
		return this.editTime;
	}
	
	public void setEditTime(java.sql.Timestamp value) {
		this.editTime = value;
	}
		
	public java.lang.String getEditor() {
		return this.editor;
	}
	
	public void setEditor(java.lang.String value) {
		this.editor = value;
	}
		
	public java.lang.String getOrgType() {
		return this.orgType;
	}
	
	public void setOrgType(java.lang.String value) {
		this.orgType = value;
	}
		
	public java.lang.Integer getOrgId() {
		return this.orgId;
	}
	
	public void setOrgId(java.lang.Integer value) {
		this.orgId = value;
	}
		
	public java.lang.String getOrgName() {
		return this.orgName;
	}
	
	public void setOrgName(java.lang.String value) {
		this.orgName = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

