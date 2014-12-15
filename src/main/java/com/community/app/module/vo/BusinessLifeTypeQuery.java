package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessLifeType;
import com.community.app.module.vo.BaseBean;

public class BusinessLifeTypeQuery extends BaseBean {
	

	private Integer typeId;
	private String typeName;
	private String typeDesc;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private String editor;

	public BusinessLifeTypeQuery(BusinessLifeType businessLifeType) {
		this.typeId = businessLifeType.getTypeId();
		this.typeName = businessLifeType.getTypeName();
		this.typeDesc = businessLifeType.getTypeDesc();
		this.createTime = businessLifeType.getCreateTime();
		this.editTime = businessLifeType.getEditTime();
		this.editor = businessLifeType.getEditor();
	}
	
	public BusinessLifeTypeQuery() {
		
	}	
	
	public Integer getTypeId() {
		return this.typeId;
	}
	
	public void setTypeId(Integer value) {
		this.typeId = value;
	}
		
	public String getTypeName() {
		return this.typeName;
	}
	
	public void setTypeName(String value) {
		this.typeName = value;
	}
		
	public String getTypeDesc() {
		return this.typeDesc;
	}
	
	public void setTypeDesc(String value) {
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
		
	public String getEditor() {
		return this.editor;
	}
	
	public void setEditor(String value) {
		this.editor = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

