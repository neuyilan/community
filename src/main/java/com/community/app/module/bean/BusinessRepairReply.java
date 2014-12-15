package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessRepairReply implements java.io.Serializable {

	// 别名
	public static final String TABLE_ALIAS = "BusinessRepairReply";

	private Integer commentId;
	private Integer repairId;
	private Integer replyId;
	private Integer commentorId;
	private String commentorName;
	private String commentorAvatar;
	private String comment;
	private java.sql.Timestamp commentTime;

	public BusinessRepairReply() {
	}

	public BusinessRepairReply(Integer commentId) {
		this.commentId = commentId;
	}

	public void setCommentId(Integer value) {
		this.commentId = value;
	}

	public Integer getCommentId() {
		return this.commentId;
	}

	public void setRepairId(Integer value) {
		this.repairId = value;
	}

	public Integer getRepairId() {
		return this.repairId;
	}

	public void setReplyId(Integer value) {
		this.replyId = value;
	}

	public Integer getReplyId() {
		return this.replyId;
	}

	public void setCommentorId(Integer value) {
		this.commentorId = value;
	}

	public Integer getCommentorId() {
		return this.commentorId;
	}

	public void setCommentorName(String value) {
		this.commentorName = value;
	}

	public String getCommentorName() {
		return this.commentorName;
	}

	public void setCommentorAvatar(String value) {
		this.commentorAvatar = value;
	}

	public String getCommentorAvatar() {
		return this.commentorAvatar;
	}

	public void setComment(String value) {
		this.comment = value;
	}

	public String getComment() {
		return this.comment;
	}

	public void setCommentTime(java.sql.Timestamp value) {
		this.commentTime = value;
	}

	public java.sql.Timestamp getCommentTime() {
		return this.commentTime;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("CommentId", getCommentId())
				.append("RepairId", getRepairId())
				.append("ReplyId", getReplyId())
				.append("CommentorId", getCommentorId())
				.append("CommentorName", getCommentorName())
				.append("CommentorAvatar", getCommentorAvatar())
				.append("Comment", getComment())
				.append("CommentTime", getCommentTime()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getCommentId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof BusinessRepairReply == false)
			return false;
		if (this == obj)
			return true;
		BusinessRepairReply other = (BusinessRepairReply) obj;
		return new EqualsBuilder().append(getCommentId(), other.getCommentId())
				.isEquals();
	}
}
