package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessFeedbackComment implements java.io.Serializable {

	// 别名
	public static final String TABLE_ALIAS = "BusinessFeedbackComment";

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
	private java.lang.String portrait;
	private java.lang.String nickname;
	private java.lang.String b_nickname;
	private java.lang.String b_portrait;
	private java.lang.Integer to;

	public java.lang.String getB_nickname() {
		return b_nickname  == null?"":b_nickname;
	}

	public void setB_nickname(java.lang.String b_nickname) {
		this.b_nickname = b_nickname;
	}

	public java.lang.String getB_portrait() {
		return b_portrait;
	}

	public void setB_portrait(java.lang.String b_portrait) {
		this.b_portrait = b_portrait;
	}

	public java.lang.Integer getTo() {
		return to;
	}

	public void setTo(java.lang.Integer to) {
		this.to = to;
	}

	public java.lang.String getNickname() {
		return nickname == null?"":nickname;
	}

	public void setNickname(java.lang.String nickname) {
		this.nickname = nickname;
	}

	public java.lang.String getPortrait() {
		return portrait;
	}

	public void setPortrait(java.lang.String portrait) {
		this.portrait = portrait;
	}

	public BusinessFeedbackComment() {
	}

	public BusinessFeedbackComment(java.lang.Integer commentId) {
		this.commentId = commentId;
	}

	public void setCommentId(java.lang.Integer value) {
		this.commentId = value;
	}

	public java.lang.Integer getCommentId() {
		return this.commentId;
	}

	public void setFeedbackId(java.lang.Integer value) {
		this.feedbackId = value;
	}

	public java.lang.Integer getFeedbackId() {
		return this.feedbackId;
	}

	public void setReplyId(java.lang.Integer value) {
		this.replyId = value;
	}

	public java.lang.Integer getReplyId() {
		return this.replyId;
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
		return this.commentorName == null?"":this.commentorName;
	}

	public void setCommentorAvatar(java.lang.String value) {
		this.commentorAvatar = value;
	}

	public java.lang.String getCommentorAvatar() {
		return this.commentorAvatar == null?"":this.commentorAvatar;
	}

	public void setComment(java.lang.String value) {
		this.comment = value;
	}

	public java.lang.String getComment() {
		return this.comment == null?"":this.comment;
	}

	public void setCommentTime(java.sql.Timestamp value) {
		this.commentTime = value;
	}

	public java.sql.Timestamp getCommentTime() {
		return this.commentTime;
	}

	public void setContentType(java.lang.Integer value) {
		this.contentType = value;
	}

	public java.lang.Integer getContentType() {
		return this.contentType;
	}

	public void setVideoSize(java.lang.Integer value) {
		this.videoSize = value;
	}

	public java.lang.Integer getVideoSize() {
		return this.videoSize;
	}

	public void setVideoTime(java.lang.Integer value) {
		this.videoTime = value;
	}

	public java.lang.Integer getVideoTime() {
		return this.videoTime;
	}

	public void setVideoFormat(java.lang.String value) {
		this.videoFormat = value;
	}

	public java.lang.String getVideoFormat() {
		return this.videoFormat == null?"":this.videoFormat;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("CommentId", getCommentId())
				.append("FeedbackId", getFeedbackId())
				.append("ReplyId", getReplyId())
				.append("CommentorId", getCommentorId())
				.append("CommentorName", getCommentorName())
				.append("CommentorAvatar", getCommentorAvatar())
				.append("Comment", getComment())
				.append("CommentTime", getCommentTime())
				.append("ContentType", getContentType())
				.append("VideoSize", getVideoSize())
				.append("VideoTime", getVideoTime())
				.append("VideoFormat", getVideoFormat()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getCommentId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof BusinessFeedbackComment == false)
			return false;
		if (this == obj)
			return true;
		BusinessFeedbackComment other = (BusinessFeedbackComment) obj;
		return new EqualsBuilder().append(getCommentId(), other.getCommentId())
				.isEquals();
	}
}