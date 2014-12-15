package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessFeedbackComment;
import com.community.app.module.vo.BaseBean;

public class BusinessFeedbackCommentQuery extends BaseBean {
	

	private java.lang.Integer commentId;
	private java.lang.Integer feedbackId;
	private java.lang.Integer replyId;
	private java.lang.Integer commentorId;
	private java.lang.String commentorName;
	private java.lang.String commentorAvatar;
	private java.lang.String comment;
	private java.sql.Timestamp commentTime;
	private java.lang.Integer contentType;
	private java.lang.Integer videoSize;
	private java.lang.Integer videoTime;
	private java.lang.String videoFormat;
	private java.lang.Integer ID;
	private java.lang.Integer userId;
	private java.lang.Integer fbState;
	private java.lang.Integer fberId;
	private java.lang.Integer fbType;

	public java.lang.Integer getFberId() {
		return fberId;
	}

	public void setFberId(java.lang.Integer fberId) {
		this.fberId = fberId;
	}

	public java.lang.Integer getFbType() {
		return fbType;
	}

	public void setFbType(java.lang.Integer fbType) {
		this.fbType = fbType;
	}

	public java.lang.Integer getFbState() {
		return fbState;
	}

	public void setFbState(java.lang.Integer fbState) {
		this.fbState = fbState;
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

	public BusinessFeedbackCommentQuery(BusinessFeedbackComment businessFeedbackComment) {
		this.commentId = businessFeedbackComment.getCommentId();
		this.feedbackId = businessFeedbackComment.getFeedbackId();
		this.replyId = businessFeedbackComment.getReplyId();
		this.commentorId = businessFeedbackComment.getCommentorId();
		this.commentorName = businessFeedbackComment.getCommentorName();
		this.commentorAvatar = businessFeedbackComment.getCommentorAvatar();
		this.comment = businessFeedbackComment.getComment();
		this.commentTime = businessFeedbackComment.getCommentTime();
		this.contentType = businessFeedbackComment.getContentType();
		this.videoSize = businessFeedbackComment.getVideoSize();
		this.videoTime = businessFeedbackComment.getVideoTime();
		this.videoFormat = businessFeedbackComment.getVideoFormat();
	}
	
	public BusinessFeedbackCommentQuery() {
		
	}	
	
	public java.lang.Integer getCommentId() {
		return this.commentId;
	}
	
	public void setCommentId(java.lang.Integer value) {
		this.commentId = value;
	}
		
	public java.lang.Integer getFeedbackId() {
		return this.feedbackId;
	}
	
	public void setFeedbackId(java.lang.Integer value) {
		this.feedbackId = value;
	}
		
	public java.lang.Integer getReplyId() {
		return this.replyId;
	}
	
	public void setReplyId(java.lang.Integer value) {
		this.replyId = value;
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

