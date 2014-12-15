package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class BusinessLifeType implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessLifeType";

	private Integer typeId;
	private String typeName;
	private String typeDesc;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private String editor;

	public BusinessLifeType(){
	}

	public BusinessLifeType(
		Integer typeId
	){
		this.typeId = typeId;
	}

	public void setTypeId(Integer value) {
		this.typeId = value;
	}
	
	public Integer getTypeId() {
		return this.typeId;
	}
	public void setTypeName(String value) {
		this.typeName = value;
	}
	
	public String getTypeName() {
		return this.typeName;
	}
	public void setTypeDesc(String value) {
		this.typeDesc = value;
	}
	
	public String getTypeDesc() {
		return this.typeDesc;
	}
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
	
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	public void setEditTime(java.sql.Timestamp value) {
		this.editTime = value;
	}
	
	public java.sql.Timestamp getEditTime() {
		return this.editTime;
	}
	public void setEditor(String value) {
		this.editor = value;
	}
	
	public String getEditor() {
		return this.editor;
	}
	
	private Set businessTypePropertys = new HashSet(0);
	public void setBusinessTypePropertys(Set businessTypeProperty){
		this.businessTypePropertys = businessTypeProperty;
	}
	
	public Set getBusinessTypePropertys() {
		return businessTypePropertys;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("TypeId",getTypeId())
			.append("TypeName",getTypeName())
			.append("TypeDesc",getTypeDesc())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getTypeId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessLifeType == false) return false;
		if(this == obj) return true;
		BusinessLifeType other = (BusinessLifeType)obj;
		return new EqualsBuilder()
			.append(getTypeId(),other.getTypeId())
			.isEquals();
	}
}

