package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class BusinessHelpPic implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessHelpPic";

	private java.lang.Integer picId;
	private java.lang.Integer helpId;
	private java.lang.String picUrl;
	private java.lang.Integer size;
	private java.lang.String widthHeight;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public BusinessHelpPic(){
	}

	public BusinessHelpPic(
		java.lang.Integer picId
	){
		this.picId = picId;
	}

	public void setPicId(java.lang.Integer value) {
		this.picId = value;
	}
	
	public java.lang.Integer getPicId() {
		return this.picId;
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
	public void setWidthHeight(java.lang.String value) {
		this.widthHeight = value;
	}
	
	public java.lang.String getWidthHeight() {
		return this.widthHeight;
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
			.append("PicId",getPicId())
			.append("HelpId",getHelpId())
			.append("PicUrl",getPicUrl())
			.append("Size",getSize())
			.append("WidthHeight",getWidthHeight())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getPicId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessHelpPic == false) return false;
		if(this == obj) return true;
		BusinessHelpPic other = (BusinessHelpPic)obj;
		return new EqualsBuilder()
			.append(getPicId(),other.getPicId())
			.isEquals();
	}
}

