package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessHelpType;
import com.community.app.module.vo.BaseBean;

public class BusinessHelpTypeQuery extends BaseBean {
	

	private java.lang.Integer typeId;
	private java.lang.String typeName;
	private java.lang.String typeImage;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public BusinessHelpTypeQuery(BusinessHelpType businessHelpType) {
		this.typeId = businessHelpType.getTypeId();
		this.typeName = businessHelpType.getTypeName();
		this.typeImage = businessHelpType.getTypeImage();
		this.createTime = businessHelpType.getCreateTime();
		this.editTime = businessHelpType.getEditTime();
		this.editor = businessHelpType.getEditor();
	}
	
	public BusinessHelpTypeQuery() {
		
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
		
	public java.lang.String getTypeImage() {
		return this.typeImage;
	}
	
	public void setTypeImage(java.lang.String value) {
		this.typeImage = value;
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

