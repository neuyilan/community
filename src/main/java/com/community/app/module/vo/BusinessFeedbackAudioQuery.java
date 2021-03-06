package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessFeedbackAudio;

public class BusinessFeedbackAudioQuery extends BaseBean {
	

	private java.lang.Integer audioId;
	private java.lang.Integer feedbackId;
	private java.lang.String picUrl;
	private java.lang.Integer size;
	private java.lang.Integer time;
	private java.lang.String format;
	private java.sql.Timestamp createTime2;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public BusinessFeedbackAudioQuery(BusinessFeedbackAudio businessFeedbackAudio) {
		this.audioId = businessFeedbackAudio.getAudioId();
		this.feedbackId = businessFeedbackAudio.getFeedbackId();
		this.picUrl = businessFeedbackAudio.getPicUrl();
		this.size = businessFeedbackAudio.getSize();
		this.time = businessFeedbackAudio.getTime();
		this.format = businessFeedbackAudio.getFormat();
		this.createTime2 = businessFeedbackAudio.getCreateTime2();
		this.editTime = businessFeedbackAudio.getEditTime();
		this.editor = businessFeedbackAudio.getEditor();
	}
	
	public BusinessFeedbackAudioQuery() {
		
	}	
	
	public java.lang.Integer getAudioId() {
		return this.audioId;
	}
	
	public void setAudioId(java.lang.Integer value) {
		this.audioId = value;
	}
		
	public java.lang.Integer getFeedbackId() {
		return this.feedbackId;
	}
	
	public void setFeedbackId(java.lang.Integer value) {
		this.feedbackId = value;
	}
		
	public java.lang.String getPicUrl() {
		return this.picUrl;
	}
	
	public void setPicUrl(java.lang.String value) {
		this.picUrl = value;
	}
		
	public java.lang.Integer getSize() {
		return this.size;
	}
	
	public void setSize(java.lang.Integer value) {
		this.size = value;
	}
		
	public java.lang.Integer getTime() {
		return this.time;
	}
	
	public void setTime(java.lang.Integer value) {
		this.time = value;
	}
		
	public java.lang.String getFormat() {
		return this.format;
	}
	
	public void setFormat(java.lang.String value) {
		this.format = value;
	}
		
	public java.sql.Timestamp getCreateTime2() {
		return this.createTime2;
	}
	
	public void setCreateTime2(java.sql.Timestamp value) {
		this.createTime2 = value;
	}
		
	public java.sql.Timestamp getEditTime() {
		return this.editTime;
	}
	
	public void setEditTime(java.sql.Timestamp value) {
		this.editTime = value;
	}
		
	public java.lang.String getEditor() {
		return this.editor;
	}
	
	public void setEditor(java.lang.String value) {
		this.editor = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

