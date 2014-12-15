package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessNewsSupport;
import com.community.app.module.vo.BaseBean;

public class BusinessNewsSupportQuery extends BaseBean {
	

	private java.lang.Integer newsId;
	private java.lang.Integer userId;
	private java.sql.Timestamp createTime;

	public BusinessNewsSupportQuery(BusinessNewsSupport businessNewsSupport) {
		this.newsId = businessNewsSupport.getNewsId();
		this.userId = businessNewsSupport.getUserId();
		this.createTime = businessNewsSupport.getCreateTime();
	}
	
	public BusinessNewsSupportQuery() {
		
	}	
	
	public java.lang.Integer getNewsId() {
		return this.newsId;
	}
	
	public void setNewsId(java.lang.Integer value) {
		this.newsId = value;
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

