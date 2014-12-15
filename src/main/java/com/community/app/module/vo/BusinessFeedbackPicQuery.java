package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessFeedbackPic;
import com.community.app.module.vo.BaseBean;

public class BusinessFeedbackPicQuery extends BaseBean {
	

	private java.lang.Integer picId;
	private java.lang.Integer feedbackId;
	private java.lang.String picUrl;
	private java.lang.Integer size;
	private java.lang.String widthHeight;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public BusinessFeedbackPicQuery(BusinessFeedbackPic businessFeedbackPic) {
		this.picId = businessFeedbackPic.getPicId();
		this.feedbackId = businessFeedbackPic.getFeedbackId();
		this.picUrl = businessFeedbackPic.getPicUrl();
		this.size = businessFeedbackPic.getSize();
		this.widthHeight = businessFeedbackPic.getWidthHeight();
		this.createTime = businessFeedbackPic.getCreateTime();
		this.editTime = businessFeedbackPic.getEditTime();
		this.editor = businessFeedbackPic.getEditor();
	}
	
	public BusinessFeedbackPicQuery() {
		
	}	
	
	public java.lang.Integer getPicId() {
		return this.picId;
	}
	
	public void setPicId(java.lang.Integer value) {
		this.picId = value;
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
		
	public java.lang.String getWidthHeight() {
		return this.widthHeight;
	}
	
	public void setWidthHeight(java.lang.String value) {
		this.widthHeight = value;
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

