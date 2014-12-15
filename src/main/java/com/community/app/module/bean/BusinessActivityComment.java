package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessActivityComment implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessActivityComment";

	private java.lang.Integer commentId;
	private java.lang.Integer actId;
	private java.lang.Integer commentorId;
	private java.lang.String commentor;
	private java.lang.String content;
	private java.sql.Timestamp commentTime;
	private java.lang.Integer replyId;
	private java.lang.String nickname;
	private java.lang.String portrait;
	private java.lang.String replyName;
	private String buNickname;
	private String avatar;
	
	private Integer commentorState;
	private Integer replyState;
	
	public Integer getReplyState() {
		return replyState;
	}

	public String getBuNickname() {
		return buNickname;
	}

	public void setBuNickname(String buNickname) {
		this.buNickname = buNickname;
	}

	public void setReplyState(Integer replyState) {
		this.replyState = replyState;
	}

	public Integer getCommentorState() {
		return commentorState;
	}

	public void setCommentorState(Integer commentorState) {
		this.commentorState = commentorState;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public java.lang.Integer getCommentorId() {
		return commentorId;
	}

	public void setCommentorId(java.lang.Integer commentorId) {
		this.commentorId = commentorId;
	}

	public java.lang.String getReplyName() {
		return replyName == null?"":replyName;
	}

	public void setReplyName(java.lang.String replyName) {
		this.replyName = replyName;
	}

	public java.lang.String getNickname() {
		return nickname;
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

	public BusinessActivityComment(){
	}

	public BusinessActivityComment(
		java.lang.Integer commentId
	){
		this.commentId = commentId;
	}

	public void setCommentId(java.lang.Integer value) {
		this.commentId = value;
	}
	
	public java.lang.Integer getCommentId() {
		return this.commentId;
	}
	public void setActId(java.lang.Integer value) {
		this.actId = value;
	}
	
	public java.lang.Integer getActId() {
		return this.actId;
	}
	public void setCommentor(java.lang.String value) {
		this.commentor = value;
	}
	
	public java.lang.String getCommentor() {
		return this.commentor == null?"":this.commentor;
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

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("CommentId",getCommentId())
			.append("ActId",getActId())
			.append("Commentor",getCommentor())
			.append("Content",getContent())
			.append("CommentTime",getCommentTime())
			.append("ReplyId",getReplyId())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCommentId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessActivityComment == false) return false;
		if(this == obj) return true;
		BusinessActivityComment other = (BusinessActivityComment)obj;
		return new EqualsBuilder()
			.append(getCommentId(),other.getCommentId())
			.isEquals();
	}
}

