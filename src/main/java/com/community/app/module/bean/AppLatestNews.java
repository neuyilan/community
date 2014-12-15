package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class AppLatestNews implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "AppLatestNews";

	private java.lang.Integer newsId;
	private Integer typeId;
	private java.lang.Integer sourceId;
	private java.lang.Integer estateId;
	private java.lang.Integer userId;
	private Integer to;

	public AppLatestNews(){
	}

	public AppLatestNews(
		java.lang.Integer newsId
	){
		this.newsId = newsId;
	}

	public void setNewsId(java.lang.Integer value) {
		this.newsId = value;
	}
	
	public java.lang.Integer getNewsId() {
		return this.newsId;
	}
	public void setTypeId(Integer value) {
		this.typeId = value;
	}
	
	public Integer getTypeId() {
		return this.typeId;
	}
	public void setSourceId(java.lang.Integer value) {
		this.sourceId = value;
	}
	
	public java.lang.Integer getSourceId() {
		return this.sourceId;
	}
	public void setEstateId(java.lang.Integer value) {
		this.estateId = value;
	}
	
	public java.lang.Integer getEstateId() {
		return this.estateId;
	}
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
	
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	public void setTo(Integer value) {
		this.to = value;
	}
	
	public Integer getTo() {
		return this.to;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("NewsId",getNewsId())
			.append("TypeId",getTypeId())
			.append("SourceId",getSourceId())
			.append("EstateId",getEstateId())
			.append("UserId",getUserId())
			.append("To",getTo())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getNewsId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AppLatestNews == false) return false;
		if(this == obj) return true;
		AppLatestNews other = (AppLatestNews)obj;
		return new EqualsBuilder()
			.append(getNewsId(),other.getNewsId())
			.isEquals();
	}
}

