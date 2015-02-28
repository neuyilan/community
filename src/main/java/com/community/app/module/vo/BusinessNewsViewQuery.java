package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessNewsView;

public class BusinessNewsViewQuery extends BaseBean {
	

	private java.lang.Integer viewId;
	private java.lang.Integer newsId;
	private java.lang.Integer viewerId;
	private java.sql.Timestamp viewTime;
	private java.lang.String viewerCom;

	public BusinessNewsViewQuery(BusinessNewsView businessNewsView) {
		this.viewId = businessNewsView.getViewId();
		this.newsId = businessNewsView.getNewsId();
		this.viewerId = businessNewsView.getViewerId();
		this.viewTime = businessNewsView.getViewTime();
		this.viewerCom = businessNewsView.getViewerCom();
	}
	
	public BusinessNewsViewQuery() {
		
	}	
	
	public java.lang.Integer getViewId() {
		return this.viewId;
	}
	
	public void setViewId(java.lang.Integer value) {
		this.viewId = value;
	}
		
	public java.lang.Integer getNewsId() {
		return this.newsId;
	}
	
	public void setNewsId(java.lang.Integer value) {
		this.newsId = value;
	}
		
	public java.lang.Integer getViewerId() {
		return this.viewerId;
	}
	
	public void setViewerId(java.lang.Integer value) {
		this.viewerId = value;
	}
		
	public java.sql.Timestamp getViewTime() {
		return this.viewTime;
	}
	
	public void setViewTime(java.sql.Timestamp value) {
		this.viewTime = value;
	}
		
	public java.lang.String getViewerCom() {
		return this.viewerCom;
	}
	
	public void setViewerCom(java.lang.String value) {
		this.viewerCom = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

