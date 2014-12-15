package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessRepairComment;
import com.community.app.module.vo.BaseBean;

public class BusinessRepairCommentQuery extends BaseBean {
	
	private java.lang.Integer commentId;
	private java.lang.Integer repairId;
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
	private java.lang.Integer reporterId;
	private java.lang.Integer repairState;

	public java.lang.Integer getRepairState() {
		return repairState;
	}

	public void setRepairState(java.lang.Integer repairState) {
		this.repairState = repairState;
	}

	public java.lang.Integer getReporterId() {
		return reporterId;
	}

	public void setReporterId(java.lang.Integer reporterId) {
		this.reporterId = reporterId;
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

	public BusinessRepairCommentQuery(BusinessRepairComment businessRepairComment) {
		this.commentId = businessRepairComment.getCommentId();
		this.repairId = businessRepairComment.getRepairId();
		this.replyId = businessRepairComment.getReplyId();
		this.commentorId = businessRepairComment.getCommentorId();
		this.commentorName = businessRepairComment.getCommentorName();
		this.commentorAvatar = businessRepairComment.getCommentorAvatar();
		this.comment = businessRepairComment.getComment();
		this.commentTime = businessRepairComment.getCommentTime();
		this.contentType = businessRepairComment.getContentType();
		this.videoSize = businessRepairComment.getVideoSize();
		this.videoTime = businessRepairComment.getVideoTime();
		this.videoFormat = businessRepairComment.getVideoFormat();
	}
	
	public BusinessRepairCommentQuery() {
		
	}	
	
	public java.lang.Integer getCommentId() {
		return this.commentId;
	}
	
	public void setCommentId(java.lang.Integer value) {
		this.commentId = value;
	}
		
	public java.lang.Integer getRepairId() {
		return this.repairId;
	}
	
	public void setRepairId(java.lang.Integer value) {
		this.repairId = value;
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

