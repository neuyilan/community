package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessShopGoods;

public class BusinessShopGoodsQuery extends BaseBean {
	

	private java.lang.Integer goodsId;
	private java.lang.String goodsName;
	private java.lang.String goodsNo;
	private java.lang.Double goodsPrice;
	private java.lang.Integer goodsAmount;
	private java.lang.Double goodsAgio;
	private java.lang.Integer orderId;

	public BusinessShopGoodsQuery(BusinessShopGoods businessShopGoods) {
		this.goodsId = businessShopGoods.getGoodsId();
		this.goodsName = businessShopGoods.getGoodsName();
		this.goodsNo = businessShopGoods.getGoodsNO();
		this.goodsPrice = businessShopGoods.getGoodsPrice();
		this.goodsAmount = businessShopGoods.getGoodsAmount();
		this.goodsAgio = businessShopGoods.getGoodsAgio();
		this.orderId = businessShopGoods.getOrderId();
	}
	
	public BusinessShopGoodsQuery() {
		
	}	
	
	public java.lang.Integer getGoodsId() {
		return this.goodsId;
	}
	
	public void setGoodsId(java.lang.Integer value) {
		this.goodsId = value;
	}
		
	public java.lang.String getGoodsName() {
		return this.goodsName;
	}
	
	public void setGoodsName(java.lang.String value) {
		this.goodsName = value;
	}
		
	public java.lang.String getGoodsNo() {
		return this.goodsNo;
	}
	
	public void setGoodsNo(java.lang.String value) {
		this.goodsNo = value;
	}
		
	public java.lang.Double getGoodsPrice() {
		return this.goodsPrice;
	}
	
	public void setGoodsPrice(java.lang.Double value) {
		this.goodsPrice = value;
	}
		
	public java.lang.Integer getGoodsAmount() {
		return this.goodsAmount;
	}
	
	public void setGoodsAmount(java.lang.Integer value) {
		this.goodsAmount = value;
	}
		
	public java.lang.Double getGoodsAgio() {
		return this.goodsAgio;
	}
	
	public void setGoodsAgio(java.lang.Double value) {
		this.goodsAgio = value;
	}
		
	public java.lang.Integer getOrderId() {
		return this.orderId;
	}
	
	public void setOrderId(java.lang.Integer value) {
		this.orderId = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

