package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class BusinessHelpReplay implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessHelpReplay";

	private java.lang.Integer commentId;
	private java.lang.Integer helpId;
	private java.lang.Integer commentorId;
	private java.lang.String commentorName;
	private java.lang.String comment;
	private java.sql.Timestamp commentTime;
	private java.lang.Integer replyId;
	private java.lang.String replyName;

	public BusinessHelpReplay(){
	}

	public BusinessHelpReplay(
		java.lang.Integer commentId
	){
		this.commentId = commentId;
	}

	public void setCommentId(java.lang.Integer value) {
		this.commentId = value;
	}
	
	public java.lang.Integer getCommentId() {
		return this.commentId;
	}
	public void setHelpId(java.lang.Integer value) {
		this.helpId = value;
	}
	
	public java.lang.Integer getHelpId() {
		return this.helpId;
	}
	public void setCommentorId(java.lang.Integer value) {
		this.commentorId = value;
	}
	
	public java.lang.Integer getCommentorId() {
		return this.commentorId;
	}
	public void setCommentorName(java.lang.String value) {
		this.commentorName = value;
	}
	
	public java.lang.String getCommentorName() {
		return this.commentorName;
	}
	public void setComment(java.lang.String value) {
		this.comment = value;
	}
	
	public java.lang.String getComment() {
		return this.comment;
	}
	public void setCommentTime(java.sql.Timestamp value) {
		this.commentTime = value;
	}
	
	public java.sql.Timestamp getCommentTime() {
		return this.commentTime;
	}
	public void setReplyId(java.lang.Integer value) {
		this.replyId = value;
	}
	
	public java.lang.Integer getReplyId() {
		return this.replyId;
	}
	public void setReplyName(java.lang.String value) {
		this.replyName = value;
	}
	
	public java.lang.String getReplyName() {
		return this.replyName;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("CommentId",getCommentId())
			.append("HelpId",getHelpId())
			.append("CommentorId",getCommentorId())
			.append("CommentorName",getCommentorName())
			.append("Comment",getComment())
			.append("CommentTime",getCommentTime())
			.append("ReplyId",getReplyId())
			.append("ReplyName",getReplyName())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCommentId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessHelpReplay == false) return false;
		if(this == obj) return true;
		BusinessHelpReplay other = (BusinessHelpReplay)obj;
		return new EqualsBuilder()
			.append(getCommentId(),other.getCommentId())
			.isEquals();
	}
}

