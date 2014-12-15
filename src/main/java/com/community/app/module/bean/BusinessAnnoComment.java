package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessAnnoComment implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessAnnoComment";

	private Integer commentId;
	private Integer annoId;
	private Integer repliedId;
	private String repliedName;
	private Integer commentorId;
	private String commentorName;
	private String commentorAvatar;
	private String comment;
	private java.sql.Timestamp commentTime;
	private String portrait;
	private String nickname;
	private Integer commentorState;
	private Integer repliedState;
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

	public Integer getCommentorState() {
		return commentorState;
	}

	public void setCommentorState(Integer commentorState) {
		this.commentorState = commentorState;
	}

	public Integer getRepliedState() {
		return repliedState;
	}

	public void setRepliedState(Integer repliedState) {
		this.repliedState = repliedState;
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

	public BusinessAnnoComment(){
	}

	public BusinessAnnoComment(
		Integer commentId
	){
		this.commentId = commentId;
	}

	public void setCommentId(Integer value) {
		this.commentId = value;
	}
	
	public Integer getCommentId() {
		return this.commentId;
	}
	public void setAnnoId(Integer value) {
		this.annoId = value;
	}
	
	public Integer getAnnoId() {
		return this.annoId;
	}
	public void setRepliedId(Integer value) {
		this.repliedId = value;
	}
	
	public Integer getRepliedId() {
		return this.repliedId;
	}
	public void setRepliedName(String value) {
		this.repliedName = value;
	}
	
	public String getRepliedName() {
		return this.repliedName == null?"":this.repliedName;
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
		return this.commentorName == null?"":this.commentorName;
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
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("CommentId",getCommentId())
			.append("AnnoId",getAnnoId())
			.append("RepliedId",getRepliedId())
			.append("RepliedName",getRepliedName())
			.append("CommentorId",getCommentorId())
			.append("CommentorName",getCommentorName())
			.append("CommentorAvatar",getCommentorAvatar())
			.append("Comment",getComment())
			.append("CommentTime",getCommentTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCommentId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessAnnoComment == false) return false;
		if(this == obj) return true;
		BusinessAnnoComment other = (BusinessAnnoComment)obj;
		return new EqualsBuilder()
			.append(getCommentId(),other.getCommentId())
			.isEquals();
	}
}

