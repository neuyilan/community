package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessAnnoSupport;
import com.community.app.module.vo.BaseBean;

public class BusinessAnnoSupportQuery extends BaseBean {
	

	private java.lang.Integer annoId;
	private java.lang.Integer userId;
	private java.sql.Timestamp createTime;

	public BusinessAnnoSupportQuery(BusinessAnnoSupport businessAnnoSupport) {
		this.annoId = businessAnnoSupport.getAnnoId();
		this.userId = businessAnnoSupport.getUserId();
		this.createTime = businessAnnoSupport.getCreateTime();
	}
	
	public BusinessAnnoSupportQuery() {
		
	}	
	
	public java.lang.Integer getAnnoId() {
		return this.annoId;
	}
	
	public void setAnnoId(java.lang.Integer value) {
		this.annoId = value;
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

