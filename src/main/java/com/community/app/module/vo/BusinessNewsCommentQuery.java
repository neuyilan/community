package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessNewsComment;

public class BusinessNewsCommentQuery extends BaseBean {
	
	private java.lang.Integer commentId;
	private java.lang.Integer newsId;
	private java.lang.Integer commentorId;
	private java.lang.String commentorName;
	private java.lang.String content;
	private java.sql.Timestamp commentTime;
	private java.lang.Integer replyId;
	private java.lang.String replyName;
	private java.lang.Integer replyType;
	private java.lang.Integer ID;
	private java.lang.Integer userId;
	private java.lang.Integer commentorState;		// 0-居民,1-官方
	private java.lang.Integer replyState;		// 0-居民,1-官方
	private java.lang.String keyWord;
	private java.lang.String userName;
	
	public java.lang.Integer getReplyType() {
		return replyType;
	}

	public void setReplyType(java.lang.Integer replyTyep) {
		this.replyType = replyTyep;
	}

	public java.lang.String getUserName() {
		return userName;
	}

	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}

	public java.lang.String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(java.lang.String keyWord) {
		this.keyWord = keyWord;
	}

	public java.lang.Integer getUserId() {
		return userId;
	}

	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	public java.lang.Integer getID() {
		return ID;
	}

	public void setID(java.lang.Integer iD) {
		ID = iD;
	}

	public BusinessNewsCommentQuery(BusinessNewsComment businessNewsComment) {
		this.commentId = businessNewsComment.getCommentId();
		this.newsId = businessNewsComment.getNewsId();
		this.commentorId = businessNewsComment.getCommentorId();
		this.commentorName = businessNewsComment.getCommentorName();
		this.content = businessNewsComment.getContent();
		this.commentTime = businessNewsComment.getCommentTime();
		this.replyId = businessNewsComment.getReplyId();
		this.replyName = businessNewsComment.getReplyName();
		this.commentorState = businessNewsComment.getCommentorState();
		this.replyState = businessNewsComment.getReplyState();
	}
	
	public BusinessNewsCommentQuery() {
		
	}	
	
	public java.lang.Integer getCommentId() {
		return this.commentId;
	}
	
	public void setCommentId(java.lang.Integer value) {
		this.commentId = value;
	}
		
	public java.lang.Integer getNewsId() {
		return this.newsId;
	}
	
	public void setNewsId(java.lang.Integer value) {
		this.newsId = value;
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
		
	public java.lang.String getContent() {
		return this.content;
	}
	
	public void setContent(java.lang.String value) {
		this.content = value;
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
	
	public java.lang.Integer getCommentorState() {
		return commentorState;
	}

	public void setCommentorState(java.lang.Integer commentorState) {
		this.commentorState = commentorState;
	}

	public java.lang.Integer getReplyState() {
		return replyState;
	}

	public void setReplyState(java.lang.Integer replyState) {
		this.replyState = replyState;
	}
}