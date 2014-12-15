package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessProductComment implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessProductComment";

	private java.lang.Integer commentId;
	private java.lang.Integer productId;
	private java.lang.Integer commentorId;
	private java.lang.String commentor;
	private java.lang.String content;
	private java.sql.Timestamp commentTime;
	private java.lang.Integer replyId;
	private java.lang.String replyName;
	private java.lang.String nickname;
	private java.lang.String portrait;
	private java.lang.Integer commentorState;		// 0-居民,1-官方
	private java.lang.Integer replyState;		// 0-居民,1-官方
	private java.lang.String keyWord;
	private String buNickname;
	private String avatar;
	
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

	public java.lang.Integer getCommentorState() {
		return commentorState;
	}

	public void setCommentorState(java.lang.Integer commentorState) {
		this.commentorState = commentorState;
	}

	public java.lang.Integer getReplyState() {
		return replyState;
	}

	public void setReplyState(java.lang.Integer replyState) {
		this.replyState = replyState;
	}

	public java.lang.String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(java.lang.String keyWord) {
		this.keyWord = keyWord;
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

	public BusinessProductComment(){
	}

	public BusinessProductComment(
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
	public void setProductId(java.lang.Integer value) {
		this.productId = value;
	}
	
	public java.lang.Integer getProductId() {
		return this.productId;
	}
	public void setCommentorId(java.lang.Integer value) {
		this.commentorId = value;
	}
	
	public java.lang.Integer getCommentorId() {
		return this.commentorId;
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
	public void setReplyName(java.lang.String value) {
		this.replyName = value;
	}
	
	public java.lang.String getReplyName() {
		return this.replyName == null?"":this.replyName;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("CommentId",getCommentId())
			.append("ProductId",getProductId())
			.append("CommentorId",getCommentorId())
			.append("Commentor",getCommentor())
			.append("Content",getContent())
			.append("CommentTime",getCommentTime())
			.append("ReplyId",getReplyId())
			.append("ReplyName",getReplyName())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCommentId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessProductComment == false) return false;
		if(this == obj) return true;
		BusinessProductComment other = (BusinessProductComment)obj;
		return new EqualsBuilder()
			.append(getCommentId(),other.getCommentId())
			.isEquals();
	}
}