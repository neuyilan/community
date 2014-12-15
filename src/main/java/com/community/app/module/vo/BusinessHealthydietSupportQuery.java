package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessHealthydietSupport;
import com.community.app.module.vo.BaseBean;

public class BusinessHealthydietSupportQuery extends BaseBean {
	

	private java.lang.Integer healId;
	private java.lang.Integer userId;
	private java.sql.Timestamp createTime;

	public BusinessHealthydietSupportQuery(BusinessHealthydietSupport businessHealthydietSupport) {
		this.healId = businessHealthydietSupport.getHealId();
		this.userId = businessHealthydietSupport.getUserId();
		this.createTime = businessHealthydietSupport.getCreateTime();
	}
	
	public BusinessHealthydietSupportQuery() {
		
	}	
	
	public java.lang.Integer getHealId() {
		return this.healId;
	}
	
	public void setHealId(java.lang.Integer value) {
		this.healId = value;
	}
		
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
		
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

