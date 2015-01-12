package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class BusinessShopOrder implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessShopOrder";

	private java.lang.Integer orderId;
	private java.lang.String orderNo;
	private java.lang.Integer userId;
	private java.lang.String nickName;
	private java.lang.Integer estateId;
	private java.lang.Double orderAmount;
	private java.lang.Integer shopId;
	private java.sql.Timestamp orderTime;

	public BusinessShopOrder(){
	}

	public BusinessShopOrder(
		java.lang.Integer orderId
	){
		this.orderId = orderId;
	}

	public void setOrderId(java.lang.Integer value) {
		this.orderId = value;
	}
	
	public java.lang.Integer getOrderId() {
		return this.orderId;
	}
	public void setOrderNo(java.lang.String value) {
		this.orderNo = value;
	}
	
	public java.lang.String getOrderNo() {
		return this.orderNo;
	}
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
	
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	public void setNickName(java.lang.String value) {
		this.nickName = value;
	}
	
	public java.lang.String getNickName() {
		return this.nickName;
	}
	public void setEstateId(java.lang.Integer value) {
		this.estateId = value;
	}
	
	public java.lang.Integer getEstateId() {
		return this.estateId;
	}
	public void setOrderAmount(java.lang.Double value) {
		this.orderAmount = value;
	}
	
	public java.lang.Double getOrderAmount() {
		return this.orderAmount;
	}
	public void setShopId(java.lang.Integer value) {
		this.shopId = value;
	}
	
	public java.lang.Integer getShopId() {
		return this.shopId;
	}
	public void setOrderTime(java.sql.Timestamp value) {
		this.orderTime = value;
	}
	
	public java.sql.Timestamp getOrderTime() {
		return this.orderTime;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("OrderId",getOrderId())
			.append("OrderNo",getOrderNo())
			.append("UserId",getUserId())
			.append("NickName",getNickName())
			.append("EstateId",getEstateId())
			.append("OrderAmount",getOrderAmount())
			.append("ShopId",getShopId())
			.append("OrderTime",getOrderTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getOrderId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessShopOrder == false) return false;
		if(this == obj) return true;
		BusinessShopOrder other = (BusinessShopOrder)obj;
		return new EqualsBuilder()
			.append(getOrderId(),other.getOrderId())
			.isEquals();
	}
}

