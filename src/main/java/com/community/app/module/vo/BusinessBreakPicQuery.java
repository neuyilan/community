package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessBreakPic;
import com.community.app.module.vo.BaseBean;

public class BusinessBreakPicQuery extends BaseBean {
	

	private java.lang.Integer picId;
	private java.lang.Integer breakId;
	private java.lang.String picUrl;
	private java.lang.Integer size;
	private java.lang.String widthHeight;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public BusinessBreakPicQuery(BusinessBreakPic businessBreakPic) {
		this.picId = businessBreakPic.getPicId();
		this.breakId = businessBreakPic.getBreakId();
		this.picUrl = businessBreakPic.getPicUrl();
		this.size = businessBreakPic.getSize();
		this.widthHeight = businessBreakPic.getWidthHeight();
		this.createTime = businessBreakPic.getCreateTime();
		this.editTime = businessBreakPic.getEditTime();
		this.editor = businessBreakPic.getEditor();
	}
	
	public BusinessBreakPicQuery() {
		
	}	
	
	public java.lang.Integer getPicId() {
		return this.picId;
	}
	
	public void setPicId(java.lang.Integer value) {
		this.picId = value;
	}
		
	public java.lang.Integer getBreakId() {
		return this.breakId;
	}
	
	public void setBreakId(java.lang.Integer value) {
		this.breakId = value;
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

