package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessFamilyPet;
import com.community.app.module.vo.BaseBean;

public class BusinessFamilyPetQuery extends BaseBean {
	

	private java.lang.Integer petId;
	private java.lang.Integer typeId;
	private java.lang.Integer familyId;
	private java.lang.String typeName;
	private java.lang.String petName;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.String petIds;

	public java.lang.String getPetIds() {
		return petIds;
	}

	public void setPetIds(java.lang.String petIds) {
		this.petIds = petIds;
	}

	public BusinessFamilyPetQuery(BusinessFamilyPet businessFamilyPet) {
		this.petId = businessFamilyPet.getPetId();
		this.typeId = businessFamilyPet.getTypeId();
		this.familyId = businessFamilyPet.getFamilyId();
		this.typeName = businessFamilyPet.getTypeName();
		this.petName = businessFamilyPet.getPetName();
		this.createTime = businessFamilyPet.getCreateTime();
		this.editTime = businessFamilyPet.getEditTime();
		this.editor = businessFamilyPet.getEditor();
	}
	
	public BusinessFamilyPetQuery() {
		
	}	
	
	public java.lang.Integer getPetId() {
		return this.petId;
	}
	
	public void setPetId(java.lang.Integer value) {
		this.petId = value;
	}
		
	public java.lang.Integer getTypeId() {
		return this.typeId;
	}
	
	public void setTypeId(java.lang.Integer value) {
		this.typeId = value;
	}
		
	public java.lang.Integer getFamilyId() {
		return this.familyId;
	}
	
	public void setFamilyId(java.lang.Integer value) {
		this.familyId = value;
	}
		
	public java.lang.String getTypeName() {
		return this.typeName;
	}
	
	public void setTypeName(java.lang.String value) {
		this.typeName = value;
	}
		
	public java.lang.String getPetName() {
		return this.petName;
	}
	
	public void setPetName(java.lang.String value) {
		this.petName = value;
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

