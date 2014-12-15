package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class BusinessChinmedichenacareSupport implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessChinmedichenacareSupport";

	private java.lang.Integer cmchId;
	private java.lang.Integer userId;
	private java.sql.Timestamp createTime;

	public BusinessChinmedichenacareSupport(){
	}

	public BusinessChinmedichenacareSupport(
		java.lang.Integer cmchId,
		java.lang.Integer userId
	){
		this.cmchId = cmchId;
		this.userId = userId;
	}

	public void setCmchId(java.lang.Integer value) {
		this.cmchId = value;
	}
	
	public java.lang.Integer getCmchId() {
		return this.cmchId;
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
		if(obj instanceof BusinessChinmedichenacareSupport == false) return false;
		if(this == obj) return true;
		BusinessChinmedichenacareSupport other = (BusinessChinmedichenacareSupport)obj;
		return new EqualsBuilder()
			.isEquals();
	}
}

