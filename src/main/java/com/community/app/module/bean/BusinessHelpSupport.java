package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessHelpSupport implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessHelpSupport";

	private java.lang.Integer helpId;
	private java.lang.Integer userId;
	private java.sql.Timestamp createTime;

	public BusinessHelpSupport(){
	}

	public BusinessHelpSupport(
		java.lang.Integer helpId,
		java.lang.Integer userId
	){
		this.helpId = helpId;
		this.userId = userId;
	}

	public void setHelpId(java.lang.Integer value) {
		this.helpId = value;
	}
	
	public java.lang.Integer getHelpId() {
		return this.helpId;
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
		if(obj instanceof BusinessHelpSupport == false) return false;
		if(this == obj) return true;
		BusinessHelpSupport other = (BusinessHelpSupport)obj;
		return new EqualsBuilder()
			.isEquals();
	}
}

