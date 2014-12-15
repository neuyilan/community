package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class BusinessHealthydietSupport implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessHealthydietSupport";

	private java.lang.Integer healId;
	private java.lang.Integer userId;
	private java.sql.Timestamp createTime;

	public BusinessHealthydietSupport(){
	}

	public BusinessHealthydietSupport(
		java.lang.Integer healId,
		java.lang.Integer userId
	){
		this.healId = healId;
		this.userId = userId;
	}

	public void setHealId(java.lang.Integer value) {
		this.healId = value;
	}
	
	public java.lang.Integer getHealId() {
		return this.healId;
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
		if(obj instanceof BusinessHealthydietSupport == false) return false;
		if(this == obj) return true;
		BusinessHealthydietSupport other = (BusinessHealthydietSupport)obj;
		return new EqualsBuilder()
			.isEquals();
	}
}

