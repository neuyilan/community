package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessFamilyMember;

public class BusinessFamilyMemberQuery extends BaseBean {
	

	private java.lang.Integer memberId;
	private java.lang.Integer familyId;
	private java.lang.String identityTag;
	private Integer state;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.Integer type;
	private java.lang.Integer userId;
	private java.lang.Integer applyId;
	
	
	public java.lang.Integer getApplyId() {
		return applyId;
	}

	public void setApplyId(java.lang.Integer applyId) {
		this.applyId = applyId;
	}

	public java.lang.Integer getUserId() {
		return userId;
	}

	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	public java.lang.Integer getType() {
		return type;
	}

	public void setType(java.lang.Integer type) {
		this.type = type;
	}

	public BusinessFamilyMemberQuery(BusinessFamilyMember businessFamilyMember) {
		this.memberId = businessFamilyMember.getMemberId();
		this.familyId = businessFamilyMember.getFamilyId();
		this.identityTag = businessFamilyMember.getIdentityTag();
		this.state = businessFamilyMember.getState();
		this.createTime = businessFamilyMember.getCreateTime();
		this.editTime = businessFamilyMember.getEditTime();
		this.editor = businessFamilyMember.getEditor();
	}
	
	public BusinessFamilyMemberQuery() {
		
	}	
	
	public java.lang.Integer getMemberId() {
		return this.memberId;
	}
	
	public void setMemberId(java.lang.Integer value) {
		this.memberId = value;
	}
		
	public java.lang.Integer getFamilyId() {
		return this.familyId;
	}
	
	public void setFamilyId(java.lang.Integer value) {
		this.familyId = value;
	}
		
	public java.lang.String getIdentityTag() {
		return this.identityTag;
	}
	
	public void setIdentityTag(java.lang.String value) {
		this.identityTag = value;
	}
		
	public Integer getState() {
		return this.state;
	}
	
	public void setState(Integer value) {
		this.state = value;
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

