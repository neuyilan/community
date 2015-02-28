package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessActivityMessage implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessActivityMessage";

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

	public BusinessActivityMessage(){
	}

	public BusinessActivityMessage(
		java.lang.Integer messageId
	){
		this.messageId = messageId;
	}

	public void setMessageId(java.lang.Integer value) {
		this.messageId = value;
	}
	
	public java.lang.Integer getMessageId() {
		return this.messageId;
	}
	public void setActId(java.lang.Integer value) {
		this.actId = value;
	}
	
	public java.lang.Integer getActId() {
		return this.actId;
	}
	public void setContent(java.lang.String value) {
		this.content = value;
	}
	
	public java.lang.String getContent() {
		return this.content;
	}
	public void setPublisherId(java.lang.Integer value) {
		this.publisherId = value;
	}
	
	public java.lang.Integer getPublisherId() {
		return this.publisherId;
	}
	public void setPublisherName(java.lang.String value) {
		this.publisherName = value;
	}
	
	public java.lang.String getPublisherName() {
		return this.publisherName;
	}
	public void setPublishTime(java.sql.Timestamp value) {
		this.publishTime = value;
	}
	
	public java.sql.Timestamp getPublishTime() {
		return this.publishTime;
	}
	public void setIsPush(java.lang.Integer value) {
		this.isPush = value;
	}
	
	public java.lang.Integer getIsPush() {
		return this.isPush;
	}
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
	
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	public void setEditTime(java.sql.Timestamp value) {
		this.editTime = value;
	}
	
	public java.sql.Timestamp getEditTime() {
		return this.editTime;
	}
	public void setEditor(java.lang.String value) {
		this.editor = value;
	}
	
	public java.lang.String getEditor() {
		return this.editor;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("MessageId",getMessageId())
			.append("ActId",getActId())
			.append("Content",getContent())
			.append("PublisherId",getPublisherId())
			.append("PublisherName",getPublisherName())
			.append("PublishTime",getPublishTime())
			.append("IsPush",getIsPush())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getMessageId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessActivityMessage == false) return false;
		if(this == obj) return true;
		BusinessActivityMessage other = (BusinessActivityMessage)obj;
		return new EqualsBuilder()
			.append(getMessageId(),other.getMessageId())
			.isEquals();
	}
}

