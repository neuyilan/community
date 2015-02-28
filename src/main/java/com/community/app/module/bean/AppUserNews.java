package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class AppUserNews implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "AppUserNews";

	private java.lang.Integer newsId;
	private java.lang.String newTitle;
	private java.lang.Integer userId;
	private java.lang.Integer type;
	private java.lang.String content;
	private java.lang.Integer id;
	private java.sql.Timestamp createTime;
	private java.lang.String lastMessage;
	private java.lang.String lastMessageName;

	public AppUserNews(){
	}

	public AppUserNews(
		java.lang.Integer newsId
	){
		this.newsId = newsId;
	}

	public void setNewsId(java.lang.Integer value) {
		this.newsId = value;
	}
	
	public java.lang.Integer getNewsId() {
		return this.newsId;
	}
	public void setNewTitle(java.lang.String value) {
		this.newTitle = value;
	}
	
	public java.lang.String getNewTitle() {
		return this.newTitle;
	}
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
	
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	public void setType(java.lang.Integer value) {
		this.type = value;
	}
	
	public java.lang.Integer getType() {
		return this.type;
	}
	public void setContent(java.lang.String value) {
		this.content = value;
	}
	
	public java.lang.String getContent() {
		return this.content;
	}
	public void setId(java.lang.Integer value) {
		this.id = value;
	}
	
	public java.lang.Integer getId() {
		return this.id;
	}
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
	
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	public void setLastMessage(java.lang.String value) {
		this.lastMessage = value;
	}
	
	public java.lang.String getLastMessage() {
		return this.lastMessage;
	}
	public void setLastMessageName(java.lang.String value) {
		this.lastMessageName = value;
	}
	
	public java.lang.String getLastMessageName() {
		return this.lastMessageName;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("NewsId",getNewsId())
			.append("NewTitle",getNewTitle())
			.append("UserId",getUserId())
			.append("Type",getType())
			.append("Content",getContent())
			.append("Id",getId())
			.append("CreateTime",getCreateTime())
			.append("LastMessage",getLastMessage())
			.append("LastMessageName",getLastMessageName())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getNewsId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AppUserNews == false) return false;
		if(this == obj) return true;
		AppUserNews other = (AppUserNews)obj;
		return new EqualsBuilder()
			.append(getNewsId(),other.getNewsId())
			.isEquals();
	}
}

