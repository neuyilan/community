package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessHelpAudio implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessHelpAudio";

	private java.lang.Integer audioId;
	private java.lang.Integer helpId;
	private java.lang.String picUrl;
	private java.lang.Integer size;
	private java.lang.Integer time;
	private java.lang.String format;
	private java.sql.Timestamp createTime2;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public BusinessHelpAudio(){
	}

	public BusinessHelpAudio(
		java.lang.Integer audioId
	){
		this.audioId = audioId;
	}

	public void setAudioId(java.lang.Integer value) {
		this.audioId = value;
	}
	
	public java.lang.Integer getAudioId() {
		return this.audioId;
	}
	public void setHelpId(java.lang.Integer value) {
		this.helpId = value;
	}
	
	public java.lang.Integer getHelpId() {
		return this.helpId;
	}
	public void setPicUrl(java.lang.String value) {
		this.picUrl = value;
	}
	
	public java.lang.String getPicUrl() {
		return this.picUrl;
	}
	public void setSize(java.lang.Integer value) {
		this.size = value;
	}
	
	public java.lang.Integer getSize() {
		return this.size;
	}
	public void setTime(java.lang.Integer value) {
		this.time = value;
	}
	
	public java.lang.Integer getTime() {
		return this.time;
	}
	public void setFormat(java.lang.String value) {
		this.format = value;
	}
	
	public java.lang.String getFormat() {
		return this.format;
	}
	public void setCreateTime2(java.sql.Timestamp value) {
		this.createTime2 = value;
	}
	
	public java.sql.Timestamp getCreateTime2() {
		return this.createTime2;
	}
	public void setEditTime(java.sql.Timestamp value) {
		this.editTime = value;
	}
	
	public java.sql.Timestamp getEditTime() {
		return this.editTime;
	}
	public void setEditor(java.lang.String value) {
		this.editor = value;
	}
	
	public java.lang.String getEditor() {
		return this.editor;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("AudioId",getAudioId())
			.append("HelpId",getHelpId())
			.append("PicUrl",getPicUrl())
			.append("Size",getSize())
			.append("Time",getTime())
			.append("Format",getFormat())
			.append("CreateTime2",getCreateTime2())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getAudioId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessHelpAudio == false) return false;
		if(this == obj) return true;
		BusinessHelpAudio other = (BusinessHelpAudio)obj;
		return new EqualsBuilder()
			.append(getAudioId(),other.getAudioId())
			.isEquals();
	}
}

