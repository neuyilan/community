package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessChinmedichenacareComment;

public class BusinessChinmedichenacareCommentQuery extends BaseBean {
	
	private java.lang.Integer commentId;
	private java.lang.Integer cmhcId;
	private java.lang.Integer repliedId;
	private java.lang.String repliedName;
	private java.lang.Integer commentorId;
	private java.lang.String commentorName;
	private java.lang.String commentorAvatar;
	private java.lang.String comment;
	private java.sql.Timestamp commentTime;
	private java.lang.Integer commentorState;
	private java.lang.Integer repliedState;
	private java.lang.Integer ID;
	private java.lang.Integer userId;
	private java.lang.Integer replyId;
	private java.lang.String replyName;
	private java.lang.String content;
	private java.lang.String keyWord;

	public java.lang.String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(java.lang.String keyWord) {
		this.keyWord = keyWord;
	}

	public java.lang.String getContent() {
		return content;
	}

	public void setContent(java.lang.String content) {
		this.content = content;
	}

	public java.lang.Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(java.lang.Integer replyId) {
		this.replyId = replyId;
	}

	public java.lang.String getReplyName() {
		return replyName;
	}

	public void setReplyName(java.lang.String replyName) {
		this.replyName = replyName;
	}

	public java.lang.Integer getUserId() {
		return userId;
	}

	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	public BusinessChinmedichenacareCommentQuery(BusinessChinmedichenacareComment businessChinmedichenacareComment) {
		this.commentId = businessChinmedichenacareComment.getCommentId();
		this.cmhcId = businessChinmedichenacareComment.getCmhcId();
		this.repliedId = businessChinmedichenacareComment.getRepliedId();
		this.repliedName = businessChinmedichenacareComment.getRepliedName();
		this.commentorId = businessChinmedichenacareComment.getCommentorId();
		this.commentorName = businessChinmedichenacareComment.getCommentorName();
		this.commentorAvatar = businessChinmedichenacareComment.getCommentorAvatar();
		this.comment = businessChinmedichenacareComment.getComment();
		this.commentTime = businessChinmedichenacareComment.getCommentTime();
		this.commentorState = businessChinmedichenacareComment.getCommentorState();
		this.repliedState = businessChinmedichenacareComment.getRepliedState();
	}
	
	public java.lang.Integer getID() {
		return ID;
	}

	public void setID(java.lang.Integer iD) {
		ID = iD;
	}

	public BusinessChinmedichenacareCommentQuery() {
		
	}	
	
	public java.lang.Integer getCommentId() {
		return this.commentId;
	}
	
	public void setCommentId(java.lang.Integer value) {
		this.commentId = value;
	}
		
	public java.lang.Integer getCmhcId() {
		return this.cmhcId;
	}
	
	public void setCmhcId(java.lang.Integer value) {
		this.cmhcId = value;
	}
		
	public java.lang.Integer getRepliedId() {
		return this.repliedId;
	}
	
	public void setRepliedId(java.lang.Integer value) {
		this.repliedId = value;
	}
		
	public java.lang.String getRepliedName() {
		return this.repliedName;
	}
	
	public void setRepliedName(java.lang.String value) {
		this.repliedName = value;
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
		
	public java.lang.String getCommentorAvatar() {
		return this.commentorAvatar;
	}
	
	public void setCommentorAvatar(java.lang.String value) {
		this.commentorAvatar = value;
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
		
	public java.lang.Integer getCommentorState() {
		return this.commentorState;
	}
	
	public void setCommentorState(java.lang.Integer value) {
		this.commentorState = value;
	}
		
	public java.lang.Integer getRepliedState() {
		return this.repliedState;
	}
	
	public void setRepliedState(java.lang.Integer value) {
		this.repliedState = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

