package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class AppPushLog implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "AppPushLog";

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

	public AppPushLog(){
	}

	public AppPushLog(
		java.lang.Integer logId
	){
		this.logId = logId;
	}

	public void setLogId(java.lang.Integer value) {
		this.logId = value;
	}
	
	public java.lang.Integer getLogId() {
		return this.logId;
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
	public void setBaiduId(java.lang.String value) {
		this.baiduId = value;
	}
	
	public java.lang.String getBaiduId() {
		return this.baiduId;
	}
	public void setChannelId(java.lang.String value) {
		this.channelId = value;
	}
	
	public java.lang.String getChannelId() {
		return this.channelId;
	}
	public void setTitle(java.lang.String value) {
		this.title = value;
	}
	
	public java.lang.String getTitle() {
		return this.title;
	}
	public void setDescription(java.lang.String value) {
		this.description = value;
	}
	
	public java.lang.String getDescription() {
		return this.description;
	}
	public void setSendTime(java.sql.Timestamp value) {
		this.sendTime = value;
	}
	
	public java.sql.Timestamp getSendTime() {
		return this.sendTime;
	}
	public void setSendState(java.lang.Integer value) {
		this.sendState = value;
	}
	
	public java.lang.Integer getSendState() {
		return this.sendState;
	}
	public void setSenderId(java.lang.Integer value) {
		this.senderId = value;
	}
	
	public java.lang.Integer getSenderId() {
		return this.senderId;
	}
	public void setSenderName(java.lang.String value) {
		this.senderName = value;
	}
	
	public java.lang.String getSenderName() {
		return this.senderName;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("LogId",getLogId())
			.append("UserId",getUserId())
			.append("UserName",getUserName())
			.append("BaiduId",getBaiduId())
			.append("ChannelId",getChannelId())
			.append("Title",getTitle())
			.append("Description",getDescription())
			.append("SendTime",getSendTime())
			.append("SendState",getSendState())
			.append("SenderId",getSenderId())
			.append("SenderName",getSenderName())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getLogId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AppPushLog == false) return false;
		if(this == obj) return true;
		AppPushLog other = (AppPushLog)obj;
		return new EqualsBuilder()
			.append(getLogId(),other.getLogId())
			.isEquals();
	}
}

