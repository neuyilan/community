package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessNewsSupport implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessNewsSupport";

	private java.lang.Integer newsId;
	private java.lang.Integer userId;
	private java.sql.Timestamp createTime;

	public BusinessNewsSupport(){
	}

	public BusinessNewsSupport(
		java.lang.Integer newsId,
		java.lang.Integer userId
	){
		this.newsId = newsId;
		this.userId = userId;
	}

	public void setNewsId(java.lang.Integer value) {
		this.newsId = value;
	}
	
	public java.lang.Integer getNewsId() {
		return this.newsId;
	}
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
	
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
	
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessNewsSupport == false) return false;
		if(this == obj) return true;
		return new EqualsBuilder()
			.isEquals();
	}
}