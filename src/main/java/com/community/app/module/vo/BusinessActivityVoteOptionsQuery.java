package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessActivityVoteOptions;

public class BusinessActivityVoteOptionsQuery extends BaseBean {
	

	private java.lang.Integer optionsId;
	private java.lang.Integer actId;
	private java.lang.String content;
	private java.lang.String image;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public BusinessActivityVoteOptionsQuery(BusinessActivityVoteOptions businessActivityVoteOptions) {
		this.optionsId = businessActivityVoteOptions.getOptionsId();
		this.actId = businessActivityVoteOptions.getActId();
		this.content = businessActivityVoteOptions.getContent();
		this.image = businessActivityVoteOptions.getImage();
		this.createTime = businessActivityVoteOptions.getCreateTime();
		this.editTime = businessActivityVoteOptions.getEditTime();
		this.editor = businessActivityVoteOptions.getEditor();
	}
	
	public BusinessActivityVoteOptionsQuery() {
		
	}	
	
	public java.lang.Integer getOptionsId() {
		return this.optionsId;
	}
	
	public void setOptionsId(java.lang.Integer value) {
		this.optionsId = value;
	}
		
	public java.lang.Integer getActId() {
		return this.actId;
	}
	
	public void setActId(java.lang.Integer value) {
		this.actId = value;
	}
		
	public java.lang.String getContent() {
		return this.content;
	}
	
	public void setContent(java.lang.String value) {
		this.content = value;
	}
		
	public java.lang.String getImage() {
		return this.image;
	}
	
	public void setImage(java.lang.String value) {
		this.image = value;
	}
		
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
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

