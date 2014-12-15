package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessHealthydietComment implements java.io.Serializable {

	// 别名
	public static final String TABLE_ALIAS = "BusinessHealthydietComment";

	private java.lang.Integer commentId;
	private java.lang.Integer healId;
	private java.lang.Integer repliedId;
	private java.lang.String repliedName;
	private java.lang.Integer commentorId;
	private java.lang.String commentorName;
	private java.lang.String commentorAvatar;
	private java.lang.String comment;
	private java.sql.Timestamp commentTime;
	private java.lang.Integer commentorState;
	private java.lang.Integer repliedState;
	private String buNickname;
	private String avatar;
	private String portrait;
	private String nickname;

	public String getBuNickname() {
		return buNickname;
	}

	public void setBuNickname(String buNickname) {
		this.buNickname = buNickname;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public BusinessHealthydietComment() {
	}

	public BusinessHealthydietComment(java.lang.Integer commentId) {
		this.commentId = commentId;
	}

	public void setCommentId(java.lang.Integer value) {
		this.commentId = value;
	}

	public java.lang.Integer getCommentId() {
		return this.commentId;
	}

	public void setHealId(java.lang.Integer value) {
		this.healId = value;
	}

	public java.lang.Integer getHealId() {
		return this.healId;
	}

	public void setRepliedId(java.lang.Integer value) {
		this.repliedId = value;
	}

	public java.lang.Integer getRepliedId() {
		return this.repliedId;
	}

	public void setRepliedName(java.lang.String value) {
		this.repliedName = value;
	}

	public java.lang.String getRepliedName() {
		return this.repliedName;
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

	public void setCommentorAvatar(java.lang.String value) {
		this.commentorAvatar = value;
	}

	public java.lang.String getCommentorAvatar() {
		return this.commentorAvatar;
	}

	public void setComment(java.lang.String value) {
		this.comment = value;
	}

	public java.lang.String getComment() {
		return this.comment;
	}

	public void setCommentTime(java.sql.Timestamp value) {
		this.commentTime = value;
	}

	public java.sql.Timestamp getCommentTime() {
		return this.commentTime;
	}

	public void setCommentorState(java.lang.Integer value) {
		this.commentorState = value;
	}

	public java.lang.Integer getCommentorState() {
		return this.commentorState;
	}

	public void setRepliedState(java.lang.Integer value) {
		this.repliedState = value;
	}

	public java.lang.Integer getRepliedState() {
		return this.repliedState;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("CommentId", getCommentId())
				.append("HealId", getHealId())
				.append("RepliedId", getRepliedId())
				.append("RepliedName", getRepliedName())
				.append("CommentorId", getCommentorId())
				.append("CommentorName", getCommentorName())
				.append("CommentorAvatar", getCommentorAvatar())
				.append("Comment", getComment())
				.append("CommentTime", getCommentTime())
				.append("CommentorState", getCommentorState())
				.append("RepliedState", getRepliedState()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getCommentId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof BusinessHealthydietComment == false)
			return false;
		if (this == obj)
			return true;
		BusinessHealthydietComment other = (BusinessHealthydietComment) obj;
		return new EqualsBuilder().append(getCommentId(), other.getCommentId()).isEquals();
	}
}