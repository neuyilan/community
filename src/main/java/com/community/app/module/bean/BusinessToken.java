package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessToken implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessToken";

	private java.lang.Integer userId;
	private java.lang.String token;

	public BusinessToken(){
	}

	public BusinessToken(
		java.lang.Integer userId
	){
		this.userId = userId;
	}

	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
	
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	public void setToken(java.lang.String value) {
		this.token = value;
	}
	
	public java.lang.String getToken() {
		return this.token;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("UserId",getUserId())
			.append("Token",getToken())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getUserId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessToken == false) return false;
		if(this == obj) return true;
		BusinessToken other = (BusinessToken)obj;
		return new EqualsBuilder()
			.append(getUserId(),other.getUserId())
			.isEquals();
	}
}

