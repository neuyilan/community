package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.AppPushLog;
import com.community.app.module.vo.BaseBean;

public class AppPushLogQuery extends BaseBean {
	

	private java.lang.Integer logId;
	private java.lang.Integer userId;
	private java.lang.String userName;
	private java.lang.String baiduId;
	private java.lang.String channelId;
	private java.lang.String title;
	private java.lang.String description;
	private java.sql.Timestamp sendTime;
	private java.lang.Integer sendState;
	private java.lang.Integer senderId;
	private java.lang.String senderName;

	public AppPushLogQuery(AppPushLog appPushLog) {
		this.logId = appPushLog.getLogId();
		this.userId = appPushLog.getUserId();
		this.userName = appPushLog.getUserName();
		this.baiduId = appPushLog.getBaiduId();
		this.channelId = appPushLog.getChannelId();
		this.title = appPushLog.getTitle();
		this.description = appPushLog.getDescription();
		this.sendTime = appPushLog.getSendTime();
		this.sendState = appPushLog.getSendState();
		this.senderId = appPushLog.getSenderId();
		this.senderName = appPushLog.getSenderName();
	}
	
	public AppPushLogQuery() {
		
	}	
	
	public java.lang.Integer getLogId() {
		return this.logId;
	}
	
	public void setLogId(java.lang.Integer value) {
		this.logId = value;
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
		
	public java.lang.String getBaiduId() {
		return this.baiduId;
	}
	
	public void setBaiduId(java.lang.String value) {
		this.baiduId = value;
	}
		
	public java.lang.String getChannelId() {
		return this.channelId;
	}
	
	public void setChannelId(java.lang.String value) {
		this.channelId = value;
	}
		
	public java.lang.String getTitle() {
		return this.title;
	}
	
	public void setTitle(java.lang.String value) {
		this.title = value;
	}
		
	public java.lang.String getDescription() {
		return this.description;
	}
	
	public void setDescription(java.lang.String value) {
		this.description = value;
	}
		
	public java.sql.Timestamp getSendTime() {
		return this.sendTime;
	}
	
	public void setSendTime(java.sql.Timestamp value) {
		this.sendTime = value;
	}
		
	public java.lang.Integer getSendState() {
		return this.sendState;
	}
	
	public void setSendState(java.lang.Integer value) {
		this.sendState = value;
	}
		
	public java.lang.Integer getSenderId() {
		return this.senderId;
	}
	
	public void setSenderId(java.lang.Integer value) {
		this.senderId = value;
	}
		
	public java.lang.String getSenderName() {
		return this.senderName;
	}
	
	public void setSenderName(java.lang.String value) {
		this.senderName = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

