package com.community.app.module.vo;



import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.AppStatisticsClick;

public class AppStatisticsClickQuery extends BaseBean {
	

	private java.lang.Integer statiId;
	private java.lang.Integer userId;
	private java.lang.Integer type;
	private java.lang.String typeName;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public AppStatisticsClickQuery(AppStatisticsClick appStatisticsClick) {
		this.statiId = appStatisticsClick.getStatiId();
		this.userId = appStatisticsClick.getUserId();
		this.type = appStatisticsClick.getType();
		this.typeName = appStatisticsClick.getTypeName();
		this.createTime = appStatisticsClick.getCreateTime();
		this.editTime = appStatisticsClick.getEditTime();
		this.editor = appStatisticsClick.getEditor();
	}
	
	public AppStatisticsClickQuery() {
		
	}	
	
	public java.lang.Integer getStatiId() {
		return this.statiId;
	}
	
	public void setStatiId(java.lang.Integer value) {
		this.statiId = value;
	}
		
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
		
	public java.lang.Integer getType() {
		return this.type;
	}
	
	public void setType(java.lang.Integer value) {
		this.type = value;
	}
		
	public java.lang.String getTypeName() {
		return this.typeName;
	}
	
	public void setTypeName(java.lang.String value) {
		this.typeName = value;
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

