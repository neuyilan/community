package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessBreakComment;

public class BusinessBreakCommentQuery extends BaseBean {
	
	private java.lang.Integer commentId;
	private java.lang.Integer breakId;
	private java.lang.Integer commentorId;
	private java.lang.String commentorName;
	private java.lang.String content;
	private java.sql.Timestamp commentTime;
	private java.lang.Integer contentType;
	private java.lang.Integer videoSize;
	private java.lang.Integer videoTime;
	private java.lang.String videoFormat;
	private java.lang.Integer brokeId;
	private java.lang.Integer userId;
	private java.lang.Integer to;
	private java.lang.Integer breakerId;

	public java.lang.Integer getBreakerId() {
		return breakerId;
	}

	public void setBreakerId(java.lang.Integer breakerId) {
		this.breakerId = breakerId;
	}

	public java.lang.Integer getTo() {
		return to;
	}

	public void setTo(java.lang.Integer to) {
		this.to = to;
	}

	public java.lang.Integer getUserId() {
		return userId;
	}

	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	public java.lang.Integer getBrokeId() {
		return brokeId;
	}

	public void setBrokeId(java.lang.Integer brokeId) {
		this.brokeId = brokeId;
	}

	public BusinessBreakCommentQuery(BusinessBreakComment businessBreakComment) {
		this.commentId = businessBreakComment.getCommentId();
		this.breakId = businessBreakComment.getBreakId();
		this.commentorId = businessBreakComment.getCommentorId();
		this.commentorName = businessBreakComment.getCommentorName();
		this.content = businessBreakComment.getContent();
		this.commentTime = businessBreakComment.getCommentTime();
		this.contentType = businessBreakComment.getContentType();
		this.videoSize = businessBreakComment.getVideoSize();
		this.videoTime = businessBreakComment.getVideoTime();
		this.videoFormat = businessBreakComment.getVideoFormat();
		this.to = businessBreakComment.getTo();
	}
	
	public BusinessBreakCommentQuery() {
		
	}	
	
	public java.lang.Integer getCommentId() {
		return this.commentId;
	}
	
	public void setCommentId(java.lang.Integer value) {
		this.commentId = value;
	}
		
	public java.lang.Integer getBreakId() {
		return this.breakId;
	}
	
	public void setBreakId(java.lang.Integer value) {
		this.breakId = value;
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
		
	public java.lang.Integer getContentType() {
		return this.contentType;
	}
	
	public void setContentType(java.lang.Integer value) {
		this.contentType = value;
	}
		
	public java.lang.Integer getVideoSize() {
		return this.videoSize;
	}
	
	public void setVideoSize(java.lang.Integer value) {
		this.videoSize = value;
	}
		
	public java.lang.Integer getVideoTime() {
		return this.videoTime;
	}
	
	public void setVideoTime(java.lang.Integer value) {
		this.videoTime = value;
	}
		
	public java.lang.String getVideoFormat() {
		return this.videoFormat;
	}
	
	public void setVideoFormat(java.lang.String value) {
		this.videoFormat = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
}