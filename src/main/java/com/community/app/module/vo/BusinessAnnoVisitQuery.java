package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessAnnoVisit;

public class BusinessAnnoVisitQuery extends BaseBean {
	

	private java.lang.Integer visitId;
	private java.lang.Integer annoId;
	private java.lang.Integer userId;
	private java.lang.String userName;
	private java.sql.Timestamp viewTime;
	private java.lang.String userAddress;

	public BusinessAnnoVisitQuery(BusinessAnnoVisit businessAnnoVisit) {
		this.visitId = businessAnnoVisit.getVisitId();
		this.annoId = businessAnnoVisit.getAnnoId();
		this.userId = businessAnnoVisit.getUserId();
		this.userName = businessAnnoVisit.getUserName();
		this.viewTime = businessAnnoVisit.getViewTime();
		this.userAddress = businessAnnoVisit.getUserAddress();
	}
	
	public BusinessAnnoVisitQuery() {
		
	}	
	
	public java.lang.Integer getVisitId() {
		return this.visitId;
	}
	
	public void setVisitId(java.lang.Integer value) {
		this.visitId = value;
	}
		
	public java.lang.Integer getAnnoId() {
		return this.annoId;
	}
	
	public void setAnnoId(java.lang.Integer value) {
		this.annoId = value;
	}
		
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
		
	public java.lang.String getUserName() {
		return this.userName;
	}
	
	public void setUserName(java.lang.String value) {
		this.userName = value;
	}
		
	public java.sql.Timestamp getViewTime() {
		return this.viewTime;
	}
	
	public void setViewTime(java.sql.Timestamp value) {
		this.viewTime = value;
	}
		
	public java.lang.String getUserAddress() {
		return this.userAddress;
	}
	
	public void setUserAddress(java.lang.String value) {
		this.userAddress = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

