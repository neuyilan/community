package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class BusinessShopFlow implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessShopFlow";

	private java.lang.Integer flowId;
	private java.lang.Integer userId;
	private java.lang.Integer shopId;
	private java.sql.Timestamp clickTime;

	public BusinessShopFlow(){
	}

	public BusinessShopFlow(
		java.lang.Integer flowId
	){
		this.flowId = flowId;
	}

	public void setFlowId(java.lang.Integer value) {
		this.flowId = value;
	}
	
	public java.lang.Integer getFlowId() {
		return this.flowId;
	}
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
	
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	public void setShopId(java.lang.Integer value) {
		this.shopId = value;
	}
	
	public java.lang.Integer getShopId() {
		return this.shopId;
	}
	public void setClickTime(java.sql.Timestamp value) {
		this.clickTime = value;
	}
	
	public java.sql.Timestamp getClickTime() {
		return this.clickTime;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("FlowId",getFlowId())
			.append("UserId",getUserId())
			.append("ShopId",getShopId())
			.append("ClickTime",getClickTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getFlowId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessShopFlow == false) return false;
		if(this == obj) return true;
		BusinessShopFlow other = (BusinessShopFlow)obj;
		return new EqualsBuilder()
			.append(getFlowId(),other.getFlowId())
			.isEquals();
	}
}

