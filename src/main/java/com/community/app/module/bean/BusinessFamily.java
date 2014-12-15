package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class BusinessFamily implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessFamily";

	private java.lang.Integer familyId;
	private java.lang.String familyName;
	private java.lang.String avatar;
	private java.lang.String familyDesc;
	private java.lang.String dimensionCode;
	private java.lang.String verifyCode;
	private java.lang.Integer mount;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.Integer founderId;

	public BusinessFamily(){
	}

	public BusinessFamily(
		java.lang.Integer familyId
	){
		this.familyId = familyId;
	}

	public void setFamilyId(java.lang.Integer value) {
		this.familyId = value;
	}
	
	public java.lang.Integer getFamilyId() {
		return this.familyId;
	}
	public void setFamilyName(java.lang.String value) {
		this.familyName = value;
	}
	
	public java.lang.String getFamilyName() {
		return this.familyName;
	}
	public void setAvatar(java.lang.String value) {
		this.avatar = value;
	}
	
	public java.lang.String getAvatar() {
		return this.avatar;
	}
	public void setFamilyDesc(java.lang.String value) {
		this.familyDesc = value;
	}
	
	public java.lang.String getFamilyDesc() {
		return this.familyDesc;
	}
	public void setDimensionCode(java.lang.String value) {
		this.dimensionCode = value;
	}
	
	public java.lang.String getDimensionCode() {
		return this.dimensionCode;
	}
	public void setVerifyCode(java.lang.String value) {
		this.verifyCode = value;
	}
	
	public java.lang.String getVerifyCode() {
		return this.verifyCode;
	}
	public void setMount(java.lang.Integer value) {
		this.mount = value;
	}
	
	public java.lang.Integer getMount() {
		return this.mount;
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
			.append("FamilyId",getFamilyId())
			.append("FamilyName",getFamilyName())
			.append("Avatar",getAvatar())
			.append("FamilyDesc",getFamilyDesc())
			.append("DimensionCode",getDimensionCode())
			.append("VerifyCode",getVerifyCode())
			.append("Mount",getMount())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getFamilyId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessFamily == false) return false;
		if(this == obj) return true;
		BusinessFamily other = (BusinessFamily)obj;
		return new EqualsBuilder()
			.append(getFamilyId(),other.getFamilyId())
			.isEquals();
	}

	public java.lang.Integer getFounderId() {
		return founderId;
	}

	public void setFounderId(java.lang.Integer founderId) {
		this.founderId = founderId;
	}
	
}

