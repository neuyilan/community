package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessActivityType;

public class BusinessActivityTypeQuery extends BaseBean {
	

	private java.lang.Integer typeId;
	private java.lang.String typeName;
	private java.lang.String typeDesc;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public BusinessActivityTypeQuery(BusinessActivityType businessActivityType) {
		this.typeId = businessActivityType.getTypeId();
		this.typeName = businessActivityType.getTypeName();
		this.typeDesc = businessActivityType.getTypeDesc();
		this.createTime = businessActivityType.getCreateTime();
		this.editTime = businessActivityType.getEditTime();
		this.editor = businessActivityType.getEditor();
	}
	
	public BusinessActivityTypeQuery() {
		
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

