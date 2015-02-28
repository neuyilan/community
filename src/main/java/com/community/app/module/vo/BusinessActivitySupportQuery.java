package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessActivitySupport;

public class BusinessActivitySupportQuery extends BaseBean {
	

	private java.lang.Integer actId;
	private java.lang.Integer userId;
	private java.sql.Timestamp createTime;
	private java.lang.Integer ID;

	public java.lang.Integer getID() {
		return ID;
	}

	public void setID(java.lang.Integer iD) {
		ID = iD;
	}

	public BusinessActivitySupportQuery(BusinessActivitySupport businessActivitySupport) {
		this.actId = businessActivitySupport.getActId();
		this.userId = businessActivitySupport.getUserId();
		this.createTime = businessActivitySupport.getCreateTime();
	}
	
	public BusinessActivitySupportQuery() {
		
	}	
	
	public java.lang.Integer getActId() {
		return this.actId;
	}
	
	public void setActId(java.lang.Integer value) {
		this.actId = value;
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

