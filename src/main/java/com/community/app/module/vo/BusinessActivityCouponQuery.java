package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessActivityCoupon;

public class BusinessActivityCouponQuery extends BaseBean {
	

	private java.lang.Integer couponId;
	private java.lang.Integer actId;
	private java.lang.String couponCode;
	private java.lang.Integer userId;
	private Integer state;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public BusinessActivityCouponQuery(BusinessActivityCoupon businessActivityCoupon) {
		this.couponId = businessActivityCoupon.getCouponId();
		this.actId = businessActivityCoupon.getActId();
		this.couponCode = businessActivityCoupon.getCouponCode();
		this.userId = businessActivityCoupon.getUserId();
		this.state = businessActivityCoupon.getState();
		this.createTime = businessActivityCoupon.getCreateTime();
		this.editTime = businessActivityCoupon.getEditTime();
		this.editor = businessActivityCoupon.getEditor();
	}
	
	public BusinessActivityCouponQuery() {
		
	}	
	
	public java.lang.Integer getCouponId() {
		return this.couponId;
	}
	
	public void setCouponId(java.lang.Integer value) {
		this.couponId = value;
	}
		
	public java.lang.Integer getActId() {
		return this.actId;
	}
	
	public void setActId(java.lang.Integer value) {
		this.actId = value;
	}
		
	public java.lang.String getCouponCode() {
		return this.couponCode;
	}
	
	public void setCouponCode(java.lang.String value) {
		this.couponCode = value;
	}
		
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
		
	public Integer getState() {
		return this.state;
	}
	
	public void setState(Integer value) {
		this.state = value;
	}
		
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
		
	public java.sql.Timestamp getEditTime() {
		return this.editTime;
	}
	
	public void setEditTime(java.sql.Timestamp value) {
		this.editTime = value;
	}
		
	public java.lang.String getEditor() {
		return this.editor;
	}
	
	public void setEditor(java.lang.String value) {
		this.editor = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
}