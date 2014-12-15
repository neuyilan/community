package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessPetType;
import com.community.app.module.vo.BaseBean;

public class BusinessPetTypeQuery extends BaseBean {
	

	private java.lang.Integer typeId;
	private java.lang.String typeName;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editName;
	private java.lang.String editor;

	public BusinessPetTypeQuery(BusinessPetType businessPetType) {
		this.typeId = businessPetType.getTypeId();
		this.typeName = businessPetType.getTypeName();
		this.createTime = businessPetType.getCreateTime();
		this.editName = businessPetType.getEditTime();
		this.editor = businessPetType.getEditor();
	}
	
	public BusinessPetTypeQuery() {
		
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
		
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
		
	public java.sql.Timestamp getEditName() {
		return this.editName;
	}
	
	public void setEditName(java.sql.Timestamp value) {
		this.editName = value;
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

