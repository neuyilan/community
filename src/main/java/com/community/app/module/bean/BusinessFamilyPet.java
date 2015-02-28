package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessFamilyPet implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessFamilyPet";

	private java.lang.Integer petId;
	private java.lang.Integer typeId;
	private java.lang.Integer familyId;
	private java.lang.String typeName;
	private java.lang.String petName;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public BusinessFamilyPet(){
	}

	public BusinessFamilyPet(
		java.lang.Integer petId
	){
		this.petId = petId;
	}

	public void setPetId(java.lang.Integer value) {
		this.petId = value;
	}
	
	public java.lang.Integer getPetId() {
		return this.petId;
	}
	public void setTypeId(java.lang.Integer value) {
		this.typeId = value;
	}
	
	public java.lang.Integer getTypeId() {
		return this.typeId;
	}
	public void setFamilyId(java.lang.Integer value) {
		this.familyId = value;
	}
	
	public java.lang.Integer getFamilyId() {
		return this.familyId;
	}
	public void setTypeName(java.lang.String value) {
		this.typeName = value;
	}
	
	public java.lang.String getTypeName() {
		return this.typeName;
	}
	public void setPetName(java.lang.String value) {
		this.petName = value;
	}
	
	public java.lang.String getPetName() {
		return this.petName;
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
			.append("PetId",getPetId())
			.append("TypeId",getTypeId())
			.append("FamilyId",getFamilyId())
			.append("TypeName",getTypeName())
			.append("PetName",getPetName())
			.append("CreateTime",getCreateTime())
			.append("EditName",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getPetId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessFamilyPet == false) return false;
		if(this == obj) return true;
		BusinessFamilyPet other = (BusinessFamilyPet)obj;
		return new EqualsBuilder()
			.append(getPetId(),other.getPetId())
			.isEquals();
	}
}

