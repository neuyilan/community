package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessRepairType implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessRepairType";

	private java.lang.Integer typeId;
	private java.lang.String typeName;
	private java.lang.String typeDesc;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.Integer isTelSecret;

	
	public java.lang.Integer getIsTelSecret() {
		return isTelSecret;
	}

	public void setIsTelSecret(java.lang.Integer isTelSecret) {
		this.isTelSecret = isTelSecret;
	}

	public BusinessRepairType(){
	}

	public BusinessRepairType(
		java.lang.Integer typeId
	){
		this.typeId = typeId;
	}

	public void setTypeId(java.lang.Integer value) {
		this.typeId = value;
	}
	
	public java.lang.Integer getTypeId() {
		return this.typeId;
	}
	public void setTypeName(java.lang.String value) {
		this.typeName = value;
	}
	
	public java.lang.String getTypeName() {
		return this.typeName;
	}
	public void setTypeDesc(java.lang.String value) {
		this.typeDesc = value;
	}
	
	public java.lang.String getTypeDesc() {
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
	public void setEditor(java.lang.String value) {
		this.editor = value;
	}
	
	public java.lang.String getEditor() {
		return this.editor;
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
		if(obj instanceof BusinessRepairType == false) return false;
		if(this == obj) return true;
		BusinessRepairType other = (BusinessRepairType)obj;
		return new EqualsBuilder()
			.append(getTypeId(),other.getTypeId())
			.isEquals();
	}
}

