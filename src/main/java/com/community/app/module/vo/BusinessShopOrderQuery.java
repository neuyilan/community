package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessShopOrder;

public class BusinessShopOrderQuery extends BaseBean {
	

	private java.lang.Integer orderId;
	private java.lang.String orderNo;
	private java.lang.Integer userId;
	private java.lang.String nickName;
	private java.lang.Integer estateId;
	private java.lang.Double orderAmount;
	private java.lang.Integer shopId;
	private java.sql.Timestamp orderTime;

	public BusinessShopOrderQuery(BusinessShopOrder businessShopOrder) {
		this.orderId = businessShopOrder.getOrderId();
		this.orderNo = businessShopOrder.getOrderNo();
		this.userId = businessShopOrder.getUserId();
		this.nickName = businessShopOrder.getNickName();
		this.estateId = businessShopOrder.getEstateId();
		this.orderAmount = businessShopOrder.getOrderAmount();
		this.shopId = businessShopOrder.getShopId();
		this.orderTime = businessShopOrder.getOrderTime();
	}
	
	public BusinessShopOrderQuery() {
		
	}	
	
	public java.lang.Integer getOrderId() {
		return this.orderId;
	}
	
	public void setOrderId(java.lang.Integer value) {
		this.orderId = value;
	}
		
	public java.lang.String getOrderNo() {
		return this.orderNo;
	}
	
	public void setOrderNo(java.lang.String value) {
		this.orderNo = value;
	}
		
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
		
	public java.lang.String getNickName() {
		return this.nickName;
	}
	
	public void setNickName(java.lang.String value) {
		this.nickName = value;
	}
		
	public java.lang.Integer getEstateId() {
		return this.estateId;
	}
	
	public void setEstateId(java.lang.Integer value) {
		this.estateId = value;
	}
		
	public java.lang.Double getOrderAmount() {
		return this.orderAmount;
	}
	
	public void setOrderAmount(java.lang.Double value) {
		this.orderAmount = value;
	}
		
	public java.lang.Integer getShopId() {
		return this.shopId;
	}
	
	public void setShopId(java.lang.Integer value) {
		this.shopId = value;
	}
		
	public java.sql.Timestamp getOrderTime() {
		return this.orderTime;
	}
	
	public void setOrderTime(java.sql.Timestamp value) {
		this.orderTime = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

