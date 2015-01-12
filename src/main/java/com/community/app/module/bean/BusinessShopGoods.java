package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class BusinessShopGoods implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessShopGoods";

	private java.lang.Integer goodsId;
	private java.lang.String goodsName;
	private java.lang.String goodsNO;
	private java.lang.Double goodsPrice;
	private java.lang.Integer goodsAmount;
	private java.lang.Double goodsAgio;
	private java.lang.Integer orderId;

	public BusinessShopGoods(){
	}

	public BusinessShopGoods(
		java.lang.Integer goodsId
	){
		this.goodsId = goodsId;
	}

	public void setGoodsId(java.lang.Integer value) {
		this.goodsId = value;
	}
	
	public java.lang.Integer getGoodsId() {
		return this.goodsId;
	}
	public void setGoodsName(java.lang.String value) {
		this.goodsName = value;
	}
	
	public java.lang.String getGoodsName() {
		return this.goodsName;
	}
//	public void setGoodsNo(java.lang.String value) {
//		this.goodsNo = value;
//	}
//	
//	public java.lang.String getGoodsNo() {
//		return this.goodsNo;
//	}

	public void setGoodsPrice(java.lang.Double value) {
		this.goodsPrice = value;
	}
	
	public java.lang.Double getGoodsPrice() {
		return this.goodsPrice;
	}
	public void setGoodsAmount(java.lang.Integer value) {
		this.goodsAmount = value;
	}
	
	public java.lang.Integer getGoodsAmount() {
		return this.goodsAmount;
	}
	public void setGoodsAgio(java.lang.Double value) {
		this.goodsAgio = value;
	}
	
	public java.lang.Double getGoodsAgio() {
		return this.goodsAgio;
	}
	public void setOrderId(java.lang.Integer value) {
		this.orderId = value;
	}
	
	public java.lang.Integer getOrderId() {
		return this.orderId;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("GoodsId",getGoodsId())
			.append("GoodsName",getGoodsName())
			.append("GoodsNo",getGoodsNO())
			.append("GoodsPrice",getGoodsPrice())
			.append("GoodsAmount",getGoodsAmount())
			.append("GoodsAgio",getGoodsAgio())
			.append("OrderId",getOrderId())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getGoodsId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessShopGoods == false) return false;
		if(this == obj) return true;
		BusinessShopGoods other = (BusinessShopGoods)obj;
		return new EqualsBuilder()
			.append(getGoodsId(),other.getGoodsId())
			.isEquals();
	}

	public java.lang.String getGoodsNO() {
		return goodsNO;
	}

	public void setGoodsNO(java.lang.String goodsNO) {
		this.goodsNO = goodsNO;
	}


}

