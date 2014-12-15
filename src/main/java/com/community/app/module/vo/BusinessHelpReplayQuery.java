package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessHelpReplay;
import com.community.app.module.vo.BaseBean;

public class BusinessHelpReplayQuery extends BaseBean {
	

	private java.lang.Integer commentId;
	private java.lang.Integer helpId;
	private java.lang.Integer commentorId;
	private java.lang.String commentorName;
	private java.lang.String comment;
	private java.sql.Timestamp commentTime;
	private java.lang.Integer replyId;
	private java.lang.String replyName;

	public BusinessHelpReplayQuery(BusinessHelpReplay businessHelpReplay) {
		this.commentId = businessHelpReplay.getCommentId();
		this.helpId = businessHelpReplay.getHelpId();
		this.commentorId = businessHelpReplay.getCommentorId();
		this.commentorName = businessHelpReplay.getCommentorName();
		this.comment = businessHelpReplay.getComment();
		this.commentTime = businessHelpReplay.getCommentTime();
		this.replyId = businessHelpReplay.getReplyId();
		this.replyName = businessHelpReplay.getReplyName();
	}
	
	public BusinessHelpReplayQuery() {
		
	}	
	
	public java.lang.Integer getCommentId() {
		return this.commentId;
	}
	
	public void setCommentId(java.lang.Integer value) {
		this.commentId = value;
	}
		
	public java.lang.Integer getHelpId() {
		return this.helpId;
	}
	
	public void setHelpId(java.lang.Integer value) {
		this.helpId = value;
	}
		
	public java.lang.Integer getCommentorId() {
		return this.commentorId;
	}
	
	public void setCommentorId(java.lang.Integer value) {
		this.commentorId = value;
	}
		
	public java.lang.String getCommentorName() {
		return this.commentorName;
	}
	
	public void setCommentorName(java.lang.String value) {
		this.commentorName = value;
	}
		
	public java.lang.String getComment() {
		return this.comment;
	}
	
	public void setComment(java.lang.String value) {
		this.comment = value;
	}
		
	public java.sql.Timestamp getCommentTime() {
		return this.commentTime;
	}
	
	public void setCommentTime(java.sql.Timestamp value) {
		this.commentTime = value;
	}
		
	public java.lang.Integer getReplyId() {
		return this.replyId;
	}
	
	public void setReplyId(java.lang.Integer value) {
		this.replyId = value;
	}
		
	public java.lang.String getReplyName() {
		return this.replyName;
	}
	
	public void setReplyName(java.lang.String value) {
		this.replyName = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

