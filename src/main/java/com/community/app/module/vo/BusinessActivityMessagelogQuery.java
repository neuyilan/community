package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessActivityMessagelog;
import com.community.app.module.vo.BaseBean;

public class BusinessActivityMessagelogQuery extends BaseBean {
	

	private java.lang.Integer recordId;
	private java.lang.Integer messageId;
	private java.lang.Integer userId;
	private java.sql.Timestamp pushTime;
	private java.lang.String userName;
	private java.lang.Integer pushState;

	public BusinessActivityMessagelogQuery(BusinessActivityMessagelog businessActivityMessagelog) {
		this.recordId = businessActivityMessagelog.getRecordId();
		this.messageId = businessActivityMessagelog.getMessageId();
		this.userId = businessActivityMessagelog.getUserId();
		this.pushTime = businessActivityMessagelog.getPushTime();
		this.userName = businessActivityMessagelog.getUserName();
		this.pushState = businessActivityMessagelog.getPushState();
	}
	
	public BusinessActivityMessagelogQuery() {
		
	}	
	
	public java.lang.Integer getRecordId() {
		return this.recordId;
	}
	
	public void setRecordId(java.lang.Integer value) {
		this.recordId = value;
	}
		
	public java.lang.Integer getMessageId() {
		return this.messageId;
	}
	
	public void setMessageId(java.lang.Integer value) {
		this.messageId = value;
	}
		
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
		
	public java.sql.Timestamp getPushTime() {
		return this.pushTime;
	}
	
	public void setPushTime(java.sql.Timestamp value) {
		this.pushTime = value;
	}
		
	public java.lang.String getUserName() {
		return this.userName;
	}
	
	public void setUserName(java.lang.String value) {
		this.userName = value;
	}
		
	public java.lang.Integer getPushState() {
		return this.pushState;
	}
	
	public void setPushState(java.lang.Integer value) {
		this.pushState = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

