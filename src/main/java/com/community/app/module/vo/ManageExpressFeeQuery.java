package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.ManageExpressFee;

public class ManageExpressFeeQuery extends BaseBean {
	

	private java.lang.Integer feeId;
	private java.lang.Integer expressId;
	private java.lang.String title;
	private java.lang.String content;
	private java.sql.Timestamp createTime;
	private java.lang.Integer userId;

	public java.lang.Integer getUserId() {
		return userId;
	}

	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	public ManageExpressFeeQuery(ManageExpressFee manageExpressFee) {
		this.feeId = manageExpressFee.getFeeId();
		this.expressId = manageExpressFee.getExpressId();
		this.title = manageExpressFee.getTitle();
		this.content = manageExpressFee.getContent();
		this.createTime = manageExpressFee.getCreateTime();
	}
	
	public ManageExpressFeeQuery() {
		
	}	
	
	public java.lang.Integer getFeeId() {
		return this.feeId;
	}
	
	public void setFeeId(java.lang.Integer value) {
		this.feeId = value;
	}
		
	public java.lang.Integer getExpressId() {
		return this.expressId;
	}
	
	public void setExpressId(java.lang.Integer value) {
		this.expressId = value;
	}
		
	public java.lang.String getTitle() {
		return this.title;
	}
	
	public void setTitle(java.lang.String value) {
		this.title = value;
	}
		
	public java.lang.String getContent() {
		return this.content;
	}
	
	public void setContent(java.lang.String value) {
		this.content = value;
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

