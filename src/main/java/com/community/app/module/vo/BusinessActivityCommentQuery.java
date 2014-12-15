package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessActivityComment;
import com.community.app.module.vo.BaseBean;

public class BusinessActivityCommentQuery extends BaseBean {
	

	private java.lang.Integer commentId;
	private java.lang.Integer actId;
	private java.lang.String commentor;
	private java.lang.String content;
	private java.sql.Timestamp commentTime;
	private java.lang.Integer replyId;
	private java.lang.Integer ID;
	private java.lang.Integer userId;
	private java.lang.String ReplyName;
	private Integer commentorId;
	private Integer commentorState;
	private Integer replyState;
	private String keyWord;
	private java.lang.Integer replyType;
	
	public java.lang.Integer getReplyType() {
		return replyType;
	}

	public void setReplyType(java.lang.Integer replyType) {
		this.replyType = replyType;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public Integer getReplyState() {
		return replyState;
	}

	public void setReplyState(Integer replyState) {
		this.replyState = replyState;
	}

	public Integer getCommentorId() {
		return commentorId;
	}

	public void setCommentorId(Integer commentorId) {
		this.commentorId = commentorId;
	}

	public Integer getCommentorState() {
		return commentorState;
	}

	public void setCommentorState(Integer commentorState) {
		this.commentorState = commentorState;
	}

	public java.lang.String getReplyName() {
		return ReplyName;
	}

	public void setReplyName(java.lang.String replyName) {
		ReplyName = replyName;
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

	public BusinessActivityCommentQuery(BusinessActivityComment businessActivityComment) {
		this.commentId = businessActivityComment.getCommentId();
		this.actId = businessActivityComment.getActId();
		this.commentor = businessActivityComment.getCommentor();
		this.content = businessActivityComment.getContent();
		this.commentTime = businessActivityComment.getCommentTime();
		this.replyId = businessActivityComment.getReplyId();
		this.commentorId = businessActivityComment.getCommentorId();
		this.commentorState = businessActivityComment.getCommentorState();
		this.replyState = businessActivityComment.getReplyState();
	}
	
	public BusinessActivityCommentQuery() {
		
	}	
	
	public java.lang.Integer getCommentId() {
		return this.commentId;
	}
	
	public void setCommentId(java.lang.Integer value) {
		this.commentId = value;
	}
		
	public java.lang.Integer getActId() {
		return this.actId;
	}
	
	public void setActId(java.lang.Integer value) {
		this.actId = value;
	}
		
	public java.lang.String getCommentor() {
		return this.commentor;
	}
	
	public void setCommentor(java.lang.String value) {
		this.commentor = value;
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
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

