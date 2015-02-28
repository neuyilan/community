package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessAnnoComment;

public class BusinessAnnoCommentQuery extends BaseBean {
	

	private Integer commentId;
	private Integer annoId;
	private Integer repliedId;
	private String repliedName;
	private Integer commentorId;
	private String commentorName;
	private String commentorAvatar;
	private String comment;
	private java.sql.Timestamp commentTime;
	private Integer ID; 
	private Integer userId;
	private Integer replyId;
	private String content;
	private String replyName;
	private Integer replyState;
	private java.lang.Integer replyType;
	

	public java.lang.Integer getReplyType() {
		return replyType;
	}

	public void setReplyType(java.lang.Integer replyType) {
		this.replyType = replyType;
	}

	public Integer getReplyState() {
		return replyState;
	}

	public void setReplyState(Integer replyState) {
		this.replyState = replyState;
	}

	private String keyWord;
	
	private Integer commentorState;
	private Integer repliedState;

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

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReplyName() {
		return replyName;
	}

	public void setReplyName(String replyName) {
		this.replyName = replyName;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public BusinessAnnoCommentQuery(BusinessAnnoComment businessAnnoComment) {
		this.commentId = businessAnnoComment.getCommentId();
		this.annoId = businessAnnoComment.getAnnoId();
		this.repliedId = businessAnnoComment.getRepliedId();
		this.repliedName = businessAnnoComment.getRepliedName();
		this.commentorId = businessAnnoComment.getCommentorId();
		this.commentorName = businessAnnoComment.getCommentorName();
		this.commentorAvatar = businessAnnoComment.getCommentorAvatar();
		this.comment = businessAnnoComment.getComment();
		this.commentTime = businessAnnoComment.getCommentTime();
	}
	
	public BusinessAnnoCommentQuery() {
		
	}	
	
	public Integer getCommentId() {
		return this.commentId;
	}
	
	public void setCommentId(Integer value) {
		this.commentId = value;
	}
		
	public Integer getAnnoId() {
		return this.annoId;
	}
	
	public void setAnnoId(Integer value) {
		this.annoId = value;
	}
		
	public Integer getRepliedId() {
		return this.repliedId;
	}
	
	public void setRepliedId(Integer value) {
		this.repliedId = value;
	}
		
	public String getRepliedName() {
		return this.repliedName;
	}
	
	public void setRepliedName(String value) {
		this.repliedName = value;
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

