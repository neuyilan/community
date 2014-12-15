package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class BusinessActivityVoteOptions implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessActivityVoteOptions";

	private java.lang.Integer optionsId;
	private java.lang.Integer actId;
	private java.lang.String content;
	private java.lang.String image;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.Integer count;
	private java.lang.String percentage;

	

	public java.lang.String getPercentage() {
		return percentage;
	}

	public void setPercentage(java.lang.String percentage) {
		this.percentage = percentage;
	}

	public java.lang.Integer getCount() {
		return count;
	}

	public void setCount(java.lang.Integer count) {
		this.count = count;
	}

	public BusinessActivityVoteOptions(){
	}

	public BusinessActivityVoteOptions(
		java.lang.Integer optionsId
	){
		this.optionsId = optionsId;
	}

	public void setOptionsId(java.lang.Integer value) {
		this.optionsId = value;
	}
	
	public java.lang.Integer getOptionsId() {
		return this.optionsId;
	}
	public void setActId(java.lang.Integer value) {
		this.actId = value;
	}
	
	public java.lang.Integer getActId() {
		return this.actId;
	}
	public void setContent(java.lang.String value) {
		this.content = value;
	}
	
	public java.lang.String getContent() {
		return this.content;
	}
	public void setImage(java.lang.String value) {
		this.image = value;
	}
	
	public java.lang.String getImage() {
		return this.image;
	}
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
	
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
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
			.append("OptionsId",getOptionsId())
			.append("ActId",getActId())
			.append("Content",getContent())
			.append("Image",getImage())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getOptionsId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessActivityVoteOptions == false) return false;
		if(this == obj) return true;
		BusinessActivityVoteOptions other = (BusinessActivityVoteOptions)obj;
		return new EqualsBuilder()
			.append(getOptionsId(),other.getOptionsId())
			.isEquals();
	}
}

