package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessRepairType;
import com.community.app.module.vo.BaseBean;

public class BusinessRepairTypeQuery extends BaseBean {
	

	private java.lang.Integer typeId;
	private java.lang.String typeName;
	private java.lang.String typeDesc;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public BusinessRepairTypeQuery(BusinessRepairType businessRepairType) {
		this.typeId = businessRepairType.getTypeId();
		this.typeName = businessRepairType.getTypeName();
		this.typeDesc = businessRepairType.getTypeDesc();
		this.createTime = businessRepairType.getCreateTime();
		this.editTime = businessRepairType.getEditTime();
		this.editor = businessRepairType.getEditor();
	}
	
	public BusinessRepairTypeQuery() {
		
	}	
	
	public java.lang.Integer getTypeId() {
		return this.typeId;
	}
	
	public void setTypeId(java.lang.Integer value) {
		this.typeId = value;
	}
		
	public java.lang.String getTypeName() {
		return this.typeName;
	}
	
	public void setTypeName(java.lang.String value) {
		this.typeName = value;
	}
		
	public java.lang.String getTypeDesc() {
		return this.typeDesc;
	}
	
	public void setTypeDesc(java.lang.String value) {
		this.typeDesc = value;
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
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

