package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class BusinessFamilyMember implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessFamilyMember";

	private java.lang.Integer memberId;
	private java.lang.Integer familyId;
	private java.lang.String identityTag;
	private Integer state;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.Integer userId;
	private java.lang.String tel;
	private java.lang.String name;
	private java.lang.Integer founderId;

	public java.lang.Integer getFounderId() {
		return founderId;
	}

	public void setFounderId(java.lang.Integer founderId) {
		this.founderId = founderId;
	}

	public java.lang.String getTel() {
		return tel;
	}

	public void setTel(java.lang.String tel) {
		this.tel = tel;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.Integer getUserId() {
		return userId;
	}

	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	public BusinessFamilyMember(){
	}

	public BusinessFamilyMember(
		java.lang.Integer memberId
	){
		this.memberId = memberId;
	}

	public void setMemberId(java.lang.Integer value) {
		this.memberId = value;
	}
	
	public java.lang.Integer getMemberId() {
		return this.memberId;
	}
	public void setFamilyId(java.lang.Integer value) {
		this.familyId = value;
	}
	
	public java.lang.Integer getFamilyId() {
		return this.familyId;
	}
	public void setIdentityTag(java.lang.String value) {
		this.identityTag = value;
	}
	
	public java.lang.String getIdentityTag() {
		return this.identityTag;
	}
	public void setState(Integer value) {
		this.state = value;
	}
	
	public Integer getState() {
		return this.state;
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
			.append("MemberId",getMemberId())
			.append("FamilyId",getFamilyId())
			.append("IdentityTag",getIdentityTag())
			.append("State",getState())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getMemberId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessFamilyMember == false) return false;
		if(this == obj) return true;
		BusinessFamilyMember other = (BusinessFamilyMember)obj;
		return new EqualsBuilder()
			.append(getMemberId(),other.getMemberId())
			.isEquals();
	}
}

