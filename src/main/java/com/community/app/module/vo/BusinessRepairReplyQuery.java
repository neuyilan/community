package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessRepairReply;

public class BusinessRepairReplyQuery extends BaseBean {
	

	private Integer commentId;
	private Integer repairId;
	private Integer replyId;
	private Integer commentorId;
	private String commentorName;
	private String commentorAvatar;
	private String comment;
	private java.sql.Timestamp commentTime;

	public BusinessRepairReplyQuery(BusinessRepairReply businessRepairReply) {
		this.commentId = businessRepairReply.getCommentId();
		this.repairId = businessRepairReply.getRepairId();
		this.replyId = businessRepairReply.getReplyId();
		this.commentorId = businessRepairReply.getCommentorId();
		this.commentorName = businessRepairReply.getCommentorName();
		this.commentorAvatar = businessRepairReply.getCommentorAvatar();
		this.comment = businessRepairReply.getComment();
		this.commentTime = businessRepairReply.getCommentTime();
	}
	
	public BusinessRepairReplyQuery() {
		
	}	
	
	public Integer getCommentId() {
		return this.commentId;
	}
	
	public void setCommentId(Integer value) {
		this.commentId = value;
	}
		
	public Integer getRepairId() {
		return this.repairId;
	}
	
	public void setRepairId(Integer value) {
		this.repairId = value;
	}
		
	public Integer getReplyId() {
		return this.replyId;
	}
	
	public void setReplyId(Integer value) {
		this.replyId = value;
	}
		
	public Integer getCommentorId() {
		return this.commentorId;
	}
	
	public void setCommentorId(Integer value) {
		this.commentorId = value;
	}
		
	public String getCommentorName() {
		return this.commentorName;
	}
	
	public void setCommentorName(String value) {
		this.commentorName = value;
	}
		
	public String getCommentorAvatar() {
		return this.commentorAvatar;
	}
	
	public void setCommentorAvatar(String value) {
		this.commentorAvatar = value;
	}
		
	public String getComment() {
		return this.comment;
	}
	
	public void setComment(String value) {
		this.comment = value;
	}
		
	public java.sql.Timestamp getCommentTime() {
		return this.commentTime;
	}
	
	public void setCommentTime(java.sql.Timestamp value) {
		this.commentTime = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

