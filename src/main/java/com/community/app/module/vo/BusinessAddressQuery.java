package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessAddress;

public class BusinessAddressQuery extends BaseBean {

	private java.lang.Integer addrId;
	private java.lang.String contacts;
	private java.lang.String mobile;
	private java.lang.String address;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;

	public BusinessAddressQuery(BusinessAddress businessAddress) {
		this.addrId = businessAddress.getAddrId();
		this.contacts = businessAddress.getContacts();
		this.mobile = businessAddress.getMobile();
		this.address = businessAddress.getAddress();
		this.createTime = businessAddress.getCreateTime();
		this.editTime = businessAddress.getEditTime();
	}

	public BusinessAddressQuery() {

	}

	public java.lang.Integer getAddrId() {
		return this.addrId;
	}

	public void setAddrId(java.lang.Integer value) {
		this.addrId = value;
	}

	public java.lang.String getContacts() {
		return this.contacts;
	}

	public void setContacts(java.lang.String value) {
		this.contacts = value;
	}

	public java.lang.String getMobile() {
		return this.mobile;
	}

	public void setMobile(java.lang.String value) {
		this.mobile = value;
	}

	public java.lang.String getAddress() {
		return this.address;
	}

	public void setAddress(java.lang.String value) {
		this.address = value;
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

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}