package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessActivitySupport implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessActivitySupport";

	private java.lang.Integer actId;
	private java.lang.Integer userId;
	private java.sql.Timestamp createTime;

	public BusinessActivitySupport(){
	}

	public BusinessActivitySupport(
		java.lang.Integer actId,
		java.lang.Integer userId
	){
		this.actId = actId;
		this.userId = userId;
	}

	public void setActId(java.lang.Integer value) {
		this.actId = value;
	}
	
	public java.lang.Integer getActId() {
		return this.actId;
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
		if(obj instanceof BusinessActivitySupport == false) return false;
		if(this == obj) return true;
		BusinessActivitySupport other = (BusinessActivitySupport)obj;
		return new EqualsBuilder()
			.isEquals();
	}
}

