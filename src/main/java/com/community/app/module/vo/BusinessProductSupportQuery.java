package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessProductSupport;
import com.community.app.module.vo.BaseBean;

public class BusinessProductSupportQuery extends BaseBean {
	

	private java.lang.Integer productId;
	private java.lang.Integer userId;
	private java.sql.Timestamp createTime;

	public BusinessProductSupportQuery(BusinessProductSupport businessProductSupport) {
		this.productId = businessProductSupport.getProductId();
		this.userId = businessProductSupport.getUserId();
		this.createTime = businessProductSupport.getCreateTime();
	}
	
	public BusinessProductSupportQuery() {
		
	}	
	
	public java.lang.Integer getProductId() {
		return this.productId;
	}
	
	public void setProductId(java.lang.Integer value) {
		this.productId = value;
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

