package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessHelpAudio;
import com.community.app.module.vo.BaseBean;

public class BusinessHelpAudioQuery extends BaseBean {
	

	private java.lang.Integer audioId;
	private java.lang.Integer helpId;
	private java.lang.String picUrl;
	private java.lang.Integer size;
	private java.lang.Integer time;
	private java.lang.String format;
	private java.sql.Timestamp createTime2;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public BusinessHelpAudioQuery(BusinessHelpAudio businessHelpAudio) {
		this.audioId = businessHelpAudio.getAudioId();
		this.helpId = businessHelpAudio.getHelpId();
		this.picUrl = businessHelpAudio.getPicUrl();
		this.size = businessHelpAudio.getSize();
		this.time = businessHelpAudio.getTime();
		this.format = businessHelpAudio.getFormat();
		this.createTime2 = businessHelpAudio.getCreateTime2();
		this.editTime = businessHelpAudio.getEditTime();
		this.editor = businessHelpAudio.getEditor();
	}
	
	public BusinessHelpAudioQuery() {
		
	}	
	
	public java.lang.Integer getAudioId() {
		return this.audioId;
	}
	
	public void setAudioId(java.lang.Integer value) {
		this.audioId = value;
	}
		
	public java.lang.Integer getHelpId() {
		return this.helpId;
	}
	
	public void setHelpId(java.lang.Integer value) {
		this.helpId = value;
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

