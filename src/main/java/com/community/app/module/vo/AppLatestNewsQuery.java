package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.vo.BaseBean;

public class AppLatestNewsQuery extends BaseBean {
	

	private java.lang.Integer newsId;
	private Integer typeId;
	private java.lang.Integer sourceId;
	private java.lang.Integer estateId;
	private java.lang.Integer userId;
	private Integer to;

	public AppLatestNewsQuery(AppLatestNews appLatestNews) {
		this.newsId = appLatestNews.getNewsId();
		this.typeId = appLatestNews.getTypeId();
		this.sourceId = appLatestNews.getSourceId();
		this.estateId = appLatestNews.getEstateId();
		this.userId = appLatestNews.getUserId();
		this.to = appLatestNews.getTo();
	}
	
	public AppLatestNewsQuery() {
		
	}	
	
	public java.lang.Integer getNewsId() {
		return this.newsId;
	}
	
	public void setNewsId(java.lang.Integer value) {
		this.newsId = value;
	}
		
	public Integer getTypeId() {
		return this.typeId;
	}
	
	public void setTypeId(Integer value) {
		this.typeId = value;
	}
		
	public java.lang.Integer getSourceId() {
		return this.sourceId;
	}
	
	public void setSourceId(java.lang.Integer value) {
		this.sourceId = value;
	}
		
	public java.lang.Integer getEstateId() {
		return this.estateId;
	}
	
	public void setEstateId(java.lang.Integer value) {
		this.estateId = value;
	}
		
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
		
	public Integer getTo() {
		return this.to;
	}
	
	public void setTo(Integer value) {
		this.to = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

