package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessProductSupport implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessProductSupport";

	private java.lang.Integer productId;
	private java.lang.Integer userId;
	private java.sql.Timestamp createTime;

	public BusinessProductSupport(){
	}

	public BusinessProductSupport(
		java.lang.Integer productId,
		java.lang.Integer userId
	){
		this.productId = productId;
		this.userId = userId;
	}

	public void setProductId(java.lang.Integer value) {
		this.productId = value;
	}
	
	public java.lang.Integer getProductId() {
		return this.productId;
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
		if(obj instanceof BusinessProductSupport == false) return false;
		if(this == obj) return true;
		BusinessProductSupport other = (BusinessProductSupport)obj;
		return new EqualsBuilder()
			.isEquals();
	}
}

