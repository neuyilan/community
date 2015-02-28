package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessAnnoVisit implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessAnnoVisit";

	private java.lang.Integer visitId;
	private java.lang.Integer annoId;
	private java.lang.Integer userId;
	private java.lang.String userName;
	private java.sql.Timestamp viewTime;
	private java.lang.String userAddress;

	public BusinessAnnoVisit(){
	}

	public BusinessAnnoVisit(
		java.lang.Integer visitId
	){
		this.visitId = visitId;
	}

	public void setVisitId(java.lang.Integer value) {
		this.visitId = value;
	}
	
	public java.lang.Integer getVisitId() {
		return this.visitId;
	}
	public void setAnnoId(java.lang.Integer value) {
		this.annoId = value;
	}
	
	public java.lang.Integer getAnnoId() {
		return this.annoId;
	}
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
	
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	public void setUserName(java.lang.String value) {
		this.userName = value;
	}
	
	public java.lang.String getUserName() {
		return this.userName;
	}
	public void setViewTime(java.sql.Timestamp value) {
		this.viewTime = value;
	}
	
	public java.sql.Timestamp getViewTime() {
		return this.viewTime;
	}
	public void setUserAddress(java.lang.String value) {
		this.userAddress = value;
	}
	
	public java.lang.String getUserAddress() {
		return this.userAddress;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("VisitId",getVisitId())
			.append("AnnoId",getAnnoId())
			.append("UserId",getUserId())
			.append("UserName",getUserName())
			.append("ViewTime",getViewTime())
			.append("UserAddress",getUserAddress())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getVisitId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessAnnoVisit == false) return false;
		if(this == obj) return true;
		BusinessAnnoVisit other = (BusinessAnnoVisit)obj;
		return new EqualsBuilder()
			.append(getVisitId(),other.getVisitId())
			.isEquals();
	}
}

