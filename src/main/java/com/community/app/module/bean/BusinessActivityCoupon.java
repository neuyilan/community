package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessActivityCoupon implements java.io.Serializable {

	// 别名
	public static final String TABLE_ALIAS = "BusinessActivityCoupon";

	private java.lang.Integer couponId;
	private java.lang.Integer actId;
	private java.lang.String couponCode;
	private java.lang.Integer userId;
	private Integer state;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public BusinessActivityCoupon() {
	}

	public BusinessActivityCoupon(java.lang.Integer couponId) {
		this.couponId = couponId;
	}

	public void setCouponId(java.lang.Integer value) {
		this.couponId = value;
	}

	public java.lang.Integer getCouponId() {
		return this.couponId;
	}

	public void setActId(java.lang.Integer value) {
		this.actId = value;
	}

	public java.lang.Integer getActId() {
		return this.actId;
	}

	public void setCouponCode(java.lang.String value) {
		this.couponCode = value;
	}

	public java.lang.String getCouponCode() {
		return this.couponCode;
	}

	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}

	public java.lang.Integer getUserId() {
		return this.userId;
	}

	public void setState(Integer value) {
		this.state = value;
	}

	public Integer getState() {
		return this.state;
	}

	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}

	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setEditTime(java.sql.Timestamp value) {
		this.editTime = value;
	}

	public java.sql.Timestamp getEditTime() {
		return this.editTime;
	}

	public void setEditor(java.lang.String value) {
		this.editor = value;
	}

	public java.lang.String getEditor() {
		return this.editor;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("CouponId", getCouponId()).append("ActId", getActId())
				.append("CouponCode", getCouponCode())
				.append("UserId", getUserId()).append("State", getState())
				.append("CreateTime", getCreateTime())
				.append("EditTime", getEditTime())
				.append("Editor", getEditor()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getCouponId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof BusinessActivityCoupon == false)
			return false;
		if (this == obj)
			return true;
		BusinessActivityCoupon other = (BusinessActivityCoupon) obj;
		return new EqualsBuilder().append(getCouponId(), other.getCouponId())
				.isEquals();
	}
}