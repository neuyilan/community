package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessChinmedichenacareSupport;

public class BusinessChinmedichenacareSupportQuery extends BaseBean {
	

	private java.lang.Integer cmchId;
	private java.lang.Integer userId;
	private java.sql.Timestamp createTime;

	public BusinessChinmedichenacareSupportQuery(BusinessChinmedichenacareSupport businessChinmedichenacareSupport) {
		this.cmchId = businessChinmedichenacareSupport.getCmchId();
		this.userId = businessChinmedichenacareSupport.getUserId();
		this.createTime = businessChinmedichenacareSupport.getCreateTime();
	}
	
	public BusinessChinmedichenacareSupportQuery() {
		
	}	
	
	public java.lang.Integer getCmchId() {
		return this.cmchId;
	}
	
	public void setCmchId(java.lang.Integer value) {
		this.cmchId = value;
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

