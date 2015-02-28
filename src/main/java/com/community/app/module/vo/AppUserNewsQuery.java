package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.AppUserNews;

public class AppUserNewsQuery extends BaseBean {
	

	private java.lang.Integer newsId;
	private java.lang.String newTitle;
	private java.lang.Integer userId;
	private java.lang.Integer type;
	private java.lang.String content;
	private java.lang.Integer id;
	private java.sql.Timestamp createTime;
	private java.lang.String lastMessage;
	private java.lang.String lastMessageName;

	public AppUserNewsQuery(AppUserNews appUserNews) {
		this.newsId = appUserNews.getNewsId();
		this.newTitle = appUserNews.getNewTitle();
		this.userId = appUserNews.getUserId();
		this.type = appUserNews.getType();
		this.content = appUserNews.getContent();
		this.id = appUserNews.getId();
		this.createTime = appUserNews.getCreateTime();
		this.lastMessage = appUserNews.getLastMessage();
		this.lastMessageName = appUserNews.getLastMessageName();
	}
	
	public AppUserNewsQuery() {
		
	}	
	
	public java.lang.Integer getNewsId() {
		return this.newsId;
	}
	
	public void setNewsId(java.lang.Integer value) {
		this.newsId = value;
	}
		
	public java.lang.String getNewTitle() {
		return this.newTitle;
	}
	
	public void setNewTitle(java.lang.String value) {
		this.newTitle = value;
	}
		
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
		
	public java.lang.Integer getType() {
		return this.type;
	}
	
	public void setType(java.lang.Integer value) {
		this.type = value;
	}
		
	public java.lang.String getContent() {
		return this.content;
	}
	
	public void setContent(java.lang.String value) {
		this.content = value;
	}
		
	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setId(java.lang.Integer value) {
		this.id = value;
	}
		
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
		
	public java.lang.String getLastMessage() {
		return this.lastMessage;
	}
	
	public void setLastMessage(java.lang.String value) {
		this.lastMessage = value;
	}
		
	public java.lang.String getLastMessageName() {
		return this.lastMessageName;
	}
	
	public void setLastMessageName(java.lang.String value) {
		this.lastMessageName = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

