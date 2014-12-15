package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessFeedbackReply;
import com.community.app.module.vo.BaseBean;

public class BusinessFeedbackReplyQuery extends BaseBean {
	

	private Integer commentId;
	private Integer feedbackId;
	private Integer replyId;
	private Integer commentorId;
	private String commentorName;
	private String commentorAvatar;
	private String comment;
	private java.sql.Timestamp commentTime;

	public BusinessFeedbackReplyQuery(BusinessFeedbackReply businessFeedbackReply) {
		this.commentId = businessFeedbackReply.getCommentId();
		this.feedbackId = businessFeedbackReply.getFeedbackId();
		this.replyId = businessFeedbackReply.getReplyId();
		this.commentorId = businessFeedbackReply.getCommentorId();
		this.commentorName = businessFeedbackReply.getCommentorName();
		this.commentorAvatar = businessFeedbackReply.getCommentorAvatar();
		this.comment = businessFeedbackReply.getComment();
		this.commentTime = businessFeedbackReply.getCommentTime();
	}
	
	public BusinessFeedbackReplyQuery() {
		
	}	
	
	public Integer getCommentId() {
		return this.commentId;
	}
	
	public void setCommentId(Integer value) {
		this.commentId = value;
	}
		
	public Integer getFeedbackId() {
		return this.feedbackId;
	}
	
	public void setFeedbackId(Integer value) {
		this.feedbackId = value;
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

