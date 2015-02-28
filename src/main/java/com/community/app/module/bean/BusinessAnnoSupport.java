package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessAnnoSupport implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessAnnoSupport";

	private java.lang.Integer annoId;
	private java.lang.Integer userId;
	private java.sql.Timestamp createTime;

	public BusinessAnnoSupport(){
	}

	public BusinessAnnoSupport(
		java.lang.Integer annoId,
		java.lang.Integer userId
	){
		this.annoId = annoId;
		this.userId = userId;
	}

	public void setAnnoId(java.lang.Integer value) {
		this.annoId = value;
	}
	
	public java.lang.Integer getAnnoId() {
		return this.annoId;
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
		if(obj instanceof BusinessAnnoSupport == false) return false;
		if(this == obj) return true;
		BusinessAnnoSupport other = (BusinessAnnoSupport)obj;
		return new EqualsBuilder()
			.isEquals();
	}
}

