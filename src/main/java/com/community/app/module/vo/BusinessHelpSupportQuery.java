package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessHelpSupport;
import com.community.app.module.vo.BaseBean;

public class BusinessHelpSupportQuery extends BaseBean {
	

	private java.lang.Integer helpId;
	private java.lang.Integer userId;
	private java.sql.Timestamp createTime;

	public BusinessHelpSupportQuery(BusinessHelpSupport businessHelpSupport) {
		this.helpId = businessHelpSupport.getHelpId();
		this.userId = businessHelpSupport.getUserId();
		this.createTime = businessHelpSupport.getCreateTime();
	}
	
	public BusinessHelpSupportQuery() {
		
	}	
	
	public java.lang.Integer getHelpId() {
		return this.helpId;
	}
	
	public void setHelpId(java.lang.Integer value) {
		this.helpId = value;
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

