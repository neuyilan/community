package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessProductComment;
import com.community.app.module.vo.BaseBean;

public class BusinessProductCommentQuery extends BaseBean {
	
	private java.lang.Integer commentId;
	private java.lang.Integer productId;
	private java.lang.Integer commentorId;
	private java.lang.String commentor;
	private java.lang.String avatar;
	private java.lang.String content;
	private java.sql.Timestamp commentTime;
	private java.lang.Integer replyId;
	private java.lang.String replyName;
	private java.lang.Integer ID;
	private java.lang.Integer userId;
	private java.lang.Integer commentorState;		// 0-居民,1-官方
	private java.lang.Integer replyState;		// 0-居民,1-官方
	private java.lang.String keyWord;
	private java.lang.Integer publisherId;
	private java.lang.Integer replyType;
	
	public java.lang.Integer getReplyType() {
		return replyType;
	}

	public void setReplyType(java.lang.Integer replyType) {
		this.replyType = replyType;
	}

	public java.lang.Integer getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(java.lang.Integer publisherId) {
		this.publisherId = publisherId;
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

	public BusinessProductCommentQuery(BusinessProductComment businessProductComment) {
		this.commentId = businessProductComment.getCommentId();
		this.productId = businessProductComment.getProductId();
		this.commentorId = businessProductComment.getCommentorId();
		this.commentor = businessProductComment.getCommentor();
		this.content = businessProductComment.getContent();
		this.commentTime = businessProductComment.getCommentTime();
		this.replyId = businessProductComment.getReplyId();
		this.replyName = businessProductComment.getReplyName();
		this.commentorState = businessProductComment.getCommentorState();
		this.replyState = businessProductComment.getReplyState();
	}
	
	public BusinessProductCommentQuery() {
		
	}	
	
	public java.lang.Integer getCommentId() {
		return this.commentId;
	}
	
	public void setCommentId(java.lang.Integer value) {
		this.commentId = value;
	}
		
	public java.lang.Integer getProductId() {
		return this.productId;
	}
	
	public void setProductId(java.lang.Integer value) {
		this.productId = value;
	}
		
	public java.lang.Integer getCommentorId() {
		return this.commentorId;
	}
	
	public void setCommentorId(java.lang.Integer value) {
		this.commentorId = value;
	}
		
	public java.lang.String getCommentor() {
		return this.commentor;
	}
	
	public void setCommentor(java.lang.String value) {
		this.commentor = value;
	}
		
	public java.lang.String getAvatar() {
		return this.avatar;
	}
	
	public void setAvatar(java.lang.String value) {
		this.avatar = value;
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
}