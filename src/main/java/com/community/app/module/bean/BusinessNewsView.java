package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessNewsView implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessNewsView";

	private java.lang.Integer viewId;
	private java.lang.Integer newsId;
	private java.lang.Integer viewerId;
	private java.sql.Timestamp viewTime;
	private java.lang.String viewerCom;

	public BusinessNewsView(){
	}

	public BusinessNewsView(
		java.lang.Integer viewId
	){
		this.viewId = viewId;
	}

	public void setViewId(java.lang.Integer value) {
		this.viewId = value;
	}
	
	public java.lang.Integer getViewId() {
		return this.viewId;
	}
	public void setNewsId(java.lang.Integer value) {
		this.newsId = value;
	}
	
	public java.lang.Integer getNewsId() {
		return this.newsId;
	}
	public void setViewerId(java.lang.Integer value) {
		this.viewerId = value;
	}
	
	public java.lang.Integer getViewerId() {
		return this.viewerId;
	}
	public void setViewTime(java.sql.Timestamp value) {
		this.viewTime = value;
	}
	
	public java.sql.Timestamp getViewTime() {
		return this.viewTime;
	}
	public void setViewerCom(java.lang.String value) {
		this.viewerCom = value;
	}
	
	public java.lang.String getViewerCom() {
		return this.viewerCom == null?"":this.viewerCom;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("ViewId",getViewId())
			.append("NewsId",getNewsId())
			.append("ViewerId",getViewerId())
			.append("ViewTime",getViewTime())
			.append("ViewerCom",getViewerCom())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getViewId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessNewsView == false) return false;
		if(this == obj) return true;
		BusinessNewsView other = (BusinessNewsView)obj;
		return new EqualsBuilder()
			.append(getViewId(),other.getViewId())
			.isEquals();
	}
}