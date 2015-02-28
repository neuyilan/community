package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessActivityMessagelog implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessActivityMessagelog";

	private java.lang.Integer recordId;
	private java.lang.Integer messageId;
	private java.lang.Integer userId;
	private java.sql.Timestamp pushTime;
	private java.lang.String userName;
	private java.lang.Integer pushState;

	public BusinessActivityMessagelog(){
	}

	public BusinessActivityMessagelog(
		java.lang.Integer recordId
	){
		this.recordId = recordId;
	}

	public void setRecordId(java.lang.Integer value) {
		this.recordId = value;
	}
	
	public java.lang.Integer getRecordId() {
		return this.recordId;
	}
	public void setMessageId(java.lang.Integer value) {
		this.messageId = value;
	}
	
	public java.lang.Integer getMessageId() {
		return this.messageId;
	}
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
	
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	public void setPushTime(java.sql.Timestamp value) {
		this.pushTime = value;
	}
	
	public java.sql.Timestamp getPushTime() {
		return this.pushTime;
	}
	public void setUserName(java.lang.String value) {
		this.userName = value;
	}
	
	public java.lang.String getUserName() {
		return this.userName;
	}
	public void setPushState(java.lang.Integer value) {
		this.pushState = value;
	}
	
	public java.lang.Integer getPushState() {
		return this.pushState;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("RecordId",getRecordId())
			.append("MessageId",getMessageId())
			.append("UserId",getUserId())
			.append("PushTime",getPushTime())
			.append("UserName",getUserName())
			.append("PushState",getPushState())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getRecordId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessActivityMessagelog == false) return false;
		if(this == obj) return true;
		BusinessActivityMessagelog other = (BusinessActivityMessagelog)obj;
		return new EqualsBuilder()
			.append(getRecordId(),other.getRecordId())
			.isEquals();
	}
}

