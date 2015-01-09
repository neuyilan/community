package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessStationMessage implements java.io.Serializable {

	// 别名
	public static final String TABLE_ALIAS = "BusinessStationMessage";

	private java.lang.Integer commentId;
	private java.lang.Integer stationId;
	private java.lang.Integer commentorId;
	private java.lang.String commentorName;
	private java.lang.String content;
	private java.sql.Timestamp commentTime;
	private java.lang.Integer replyId;
	private java.lang.String replyName;
	private java.lang.Integer commentorState;
	private java.lang.Integer replyState;

	public BusinessStationMessage() {
	}

	public BusinessStationMessage(java.lang.Integer commentId) {
		this.commentId = commentId;
	}

	public void setCommentId(java.lang.Integer value) {
		this.commentId = value;
	}

	public java.lang.Integer getCommentId() {
		return this.commentId;
	}

	public void setStationId(java.lang.Integer value) {
		this.stationId = value;
	}

	public java.lang.Integer getStationId() {
		return this.stationId;
	}

	public void setCommentorId(java.lang.Integer value) {
		this.commentorId = value;
	}

	public java.lang.Integer getCommentorId() {
		return this.commentorId;
	}

	public void setCommentorName(java.lang.String value) {
		this.commentorName = value;
	}

	public java.lang.String getCommentorName() {
		return this.commentorName;
	}

	public void setContent(java.lang.String value) {
		this.content = value;
	}

	public java.lang.String getContent() {
		return this.content;
	}

	public void setCommentTime(java.sql.Timestamp value) {
		this.commentTime = value;
	}

	public java.sql.Timestamp getCommentTime() {
		return this.commentTime;
	}

	public void setReplyId(java.lang.Integer value) {
		this.replyId = value;
	}

	public java.lang.Integer getReplyId() {
		return this.replyId;
	}

	public void setReplyName(java.lang.String value) {
		this.replyName = value;
	}

	public java.lang.String getReplyName() {
		return this.replyName;
	}

	public void setCommentorState(java.lang.Integer value) {
		this.commentorState = value;
	}

	public java.lang.Integer getCommentorState() {
		return this.commentorState;
	}

	public void setReplyState(java.lang.Integer value) {
		this.replyState = value;
	}

	public java.lang.Integer getReplyState() {
		return this.replyState;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("CommentId", getCommentId())
				.append("StationId", getStationId())
				.append("CommentorId", getCommentorId())
				.append("CommentorName", getCommentorName())
				.append("Content", getContent())
				.append("CommentTime", getCommentTime())
				.append("ReplyId", getReplyId())
				.append("ReplyName", getReplyName())
				.append("CommentorState", getCommentorState())
				.append("ReplyState", getReplyState()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getCommentId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof BusinessStationMessage == false)
			return false;
		if (this == obj)
			return true;
		BusinessStationMessage other = (BusinessStationMessage) obj;
		return new EqualsBuilder().append(getCommentId(), other.getCommentId())
				.isEquals();
	}
}
