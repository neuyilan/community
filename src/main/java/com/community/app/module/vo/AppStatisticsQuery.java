package com.community.app.module.vo;



import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.AppStatistics;

public class AppStatisticsQuery extends BaseBean {
	

	private java.lang.Integer statiId;
	private java.lang.Integer type;
	private java.lang.String typeName;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public AppStatisticsQuery(AppStatistics appStatistics) {
		this.statiId = appStatistics.getStatiId();
		this.type = appStatistics.getType();
		this.typeName = appStatistics.getTypeName();
		this.createTime = appStatistics.getCreateTime();
		this.editTime = appStatistics.getEditTime();
		this.editor = appStatistics.getEditor();
	}
	
	public AppStatisticsQuery() {
		
	}	
	
	public java.lang.Integer getStatiId() {
		return this.statiId;
	}
	
	public void setStatiId(java.lang.Integer value) {
		this.statiId = value;
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

