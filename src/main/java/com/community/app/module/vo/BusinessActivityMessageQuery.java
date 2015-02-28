package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessActivityMessage;

public class BusinessActivityMessageQuery extends BaseBean {
	

	private java.lang.Integer messageId;
	private java.lang.Integer actId;
	private java.lang.String content;
	private java.lang.Integer publisherId;
	private java.lang.String publisherName;
	private java.sql.Timestamp publishTime;
	private java.lang.Integer isPush;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public BusinessActivityMessageQuery(BusinessActivityMessage businessActivityMessage) {
		this.messageId = businessActivityMessage.getMessageId();
		this.actId = businessActivityMessage.getActId();
		this.content = businessActivityMessage.getContent();
		this.publisherId = businessActivityMessage.getPublisherId();
		this.publisherName = businessActivityMessage.getPublisherName();
		this.publishTime = businessActivityMessage.getPublishTime();
		this.isPush = businessActivityMessage.getIsPush();
		this.createTime = businessActivityMessage.getCreateTime();
		this.editTime = businessActivityMessage.getEditTime();
		this.editor = businessActivityMessage.getEditor();
	}
	
	public BusinessActivityMessageQuery() {
		
	}	
	
	public java.lang.Integer getMessageId() {
		return this.messageId;
	}
	
	public void setMessageId(java.lang.Integer value) {
		this.messageId = value;
	}
		
	public java.lang.Integer getActId() {
		return this.actId;
	}
	
	public void setActId(java.lang.Integer value) {
		this.actId = value;
	}
		
	public java.lang.String getContent() {
		return this.content;
	}
	
	public void setContent(java.lang.String value) {
		this.content = value;
	}
		
	public java.lang.Integer getPublisherId() {
		return this.publisherId;
	}
	
	public void setPublisherId(java.lang.Integer value) {
		this.publisherId = value;
	}
		
	public java.lang.String getPublisherName() {
		return this.publisherName;
	}
	
	public void setPublisherName(java.lang.String value) {
		this.publisherName = value;
	}
		
	public java.sql.Timestamp getPublishTime() {
		return this.publishTime;
	}
	
	public void setPublishTime(java.sql.Timestamp value) {
		this.publishTime = value;
	}
		
	public java.lang.Integer getIsPush() {
		return this.isPush;
	}
	
	public void setIsPush(java.lang.Integer value) {
		this.isPush = value;
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

