package com.community.app.module.bean;



import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class AppStatisticsClick implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "AppStatisticsClick";

	private java.lang.Integer statiId;
	private java.lang.Integer userId;
	private java.lang.Integer type;
	private java.lang.String typeName;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.Integer id;

	public java.lang.Integer getId() {
		return id;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public AppStatisticsClick(){
	}

	public AppStatisticsClick(
		java.lang.Integer statiId
	){
		this.statiId = statiId;
	}

	public void setStatiId(java.lang.Integer value) {
		this.statiId = value;
	}
	
	public java.lang.Integer getStatiId() {
		return this.statiId;
	}
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
	
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	public void setType(java.lang.Integer value) {
		this.type = value;
	}
	
	public java.lang.Integer getType() {
		return this.type;
	}
	public void setTypeName(java.lang.String value) {
		this.typeName = value;
	}
	
	public java.lang.String getTypeName() {
		return this.typeName;
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
			.append("StatiId",getStatiId())
			.append("UserId",getUserId())
			.append("Type",getType())
			.append("TypeName",getTypeName())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getStatiId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AppStatisticsClick == false) return false;
		if(this == obj) return true;
		AppStatisticsClick other = (AppStatisticsClick)obj;
		return new EqualsBuilder()
			.append(getStatiId(),other.getStatiId())
			.isEquals();
	}
}

