package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessStationMessage;

public class BusinessStationMessageQuery extends BaseBean {

	private java.lang.Integer commentId;
	private java.lang.Integer stationId;
	private java.lang.Integer estateId;
	private java.lang.Integer commentorId;
	private java.lang.String commentorName;
	private java.lang.String content;
	private java.sql.Timestamp commentTime;
	private java.lang.Integer replyId;
	private java.lang.String replyName;
	private java.lang.Integer commentorState;
	private java.lang.Integer replyState;
	private java.lang.String timeScope;
	private java.lang.String startTime;
	private java.lang.String endTime;
	private java.lang.String keyWord;
	private Integer curUserId;		//当前用户ID
	private String curOrgType;		//当前部门类型

	public BusinessStationMessageQuery(BusinessStationMessage businessStationMessage) {
		this.commentId = businessStationMessage.getCommentId();
		this.stationId = businessStationMessage.getStationId();
		this.commentorId = businessStationMessage.getCommentorId();
		this.commentorName = businessStationMessage.getCommentorName();
		this.content = businessStationMessage.getContent();
		this.commentTime = businessStationMessage.getCommentTime();
		this.replyId = businessStationMessage.getReplyId();
		this.replyName = businessStationMessage.getReplyName();
		this.commentorState = businessStationMessage.getCommentorState();
		this.replyState = businessStationMessage.getReplyState();
		this.estateId = businessStationMessage.getEstateId();
	}

	public BusinessStationMessageQuery() {

	}

	public java.lang.Integer getEstateId() {
		return estateId;
	}

	public void setEstateId(java.lang.Integer estateId) {
		this.estateId = estateId;
	}

	public java.lang.String getTimeScope() {
		return timeScope;
	}

	public void setTimeScope(java.lang.String timeScope) {
		this.timeScope = timeScope;
	}

	public java.lang.String getStartTime() {
		return startTime;
	}

	public void setStartTime(java.lang.String startTime) {
		this.startTime = startTime;
	}

	public java.lang.String getEndTime() {
		return endTime;
	}

	public void setEndTime(java.lang.String endTime) {
		this.endTime = endTime;
	}

	public java.lang.String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(java.lang.String keyWord) {
		this.keyWord = keyWord;
	}

	public Integer getCurUserId() {
		return curUserId;
	}

	public void setCurUserId(Integer curUserId) {
		this.curUserId = curUserId;
	}

	public String getCurOrgType() {
		return curOrgType;
	}

	public void setCurOrgType(String curOrgType) {
		this.curOrgType = curOrgType;
	}

	public java.lang.Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(java.lang.Integer value) {
		this.commentId = value;
	}

	public java.lang.Integer getStationId() {
		return this.stationId;
	}

	public void setStationId(java.lang.Integer value) {
		this.stationId = value;
	}

	public java.lang.Integer getCommentorId() {
		return this.commentorId;
	}

	public void setCommentorId(java.lang.Integer value) {
		this.commentorId = value;
	}

	public java.lang.String getCommentorName() {
		return this.commentorName;
	}

	public void setCommentorName(java.lang.String value) {
		this.commentorName = value;
	}

	public java.lang.String getContent() {
		return this.content;
	}

	public void setContent(java.lang.String value) {
		this.content = value;
	}

	public java.sql.Timestamp getCommentTime() {
		return this.commentTime;
	}

	public void setCommentTime(java.sql.Timestamp value) {
		this.commentTime = value;
	}

	public java.lang.Integer getReplyId() {
		return this.replyId;
	}

	public void setReplyId(java.lang.Integer value) {
		this.replyId = value;
	}

	public java.lang.String getReplyName() {
		return this.replyName;
	}

	public void setReplyName(java.lang.String value) {
		this.replyName = value;
	}

	public java.lang.Integer getCommentorState() {
		return this.commentorState;
	}

	public void setCommentorState(java.lang.Integer value) {
		this.commentorState = value;
	}

	public java.lang.Integer getReplyState() {
		return this.replyState;
	}

	public void setReplyState(java.lang.Integer value) {
		this.replyState = value;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}