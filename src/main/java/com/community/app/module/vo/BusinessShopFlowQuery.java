package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessShopFlow;

public class BusinessShopFlowQuery extends BaseBean {
	

	private java.lang.Integer flowId;
	private java.lang.Integer userId;
	private java.lang.Integer shopId;
	private java.sql.Timestamp clickTime;

	public BusinessShopFlowQuery(BusinessShopFlow businessShopFlow) {
		this.flowId = businessShopFlow.getFlowId();
		this.userId = businessShopFlow.getUserId();
		this.shopId = businessShopFlow.getShopId();
		this.clickTime = businessShopFlow.getClickTime();
	}
	
	public BusinessShopFlowQuery() {
		
	}	
	
	public java.lang.Integer getFlowId() {
		return this.flowId;
	}
	
	public void setFlowId(java.lang.Integer value) {
		this.flowId = value;
	}
		
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
		
	public java.lang.Integer getShopId() {
		return this.shopId;
	}
	
	public void setShopId(java.lang.Integer value) {
		this.shopId = value;
	}
		
	public java.sql.Timestamp getClickTime() {
		return this.clickTime;
	}
	
	public void setClickTime(java.sql.Timestamp value) {
		this.clickTime = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

