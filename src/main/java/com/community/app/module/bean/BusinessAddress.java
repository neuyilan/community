package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessAddress implements java.io.Serializable {

	// 别名
	public static final String TABLE_ALIAS = "BusinessAddress";

	private java.lang.Integer addrId;
	private java.lang.String contacts;
	private java.lang.String mobile;
	private java.lang.String address;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;

	public BusinessAddress() {
	}

	public BusinessAddress(java.lang.Integer addrId) {
		this.addrId = addrId;
	}

	public void setAddrId(java.lang.Integer value) {
		this.addrId = value;
	}

	public java.lang.Integer getAddrId() {
		return this.addrId;
	}

	public void setContacts(java.lang.String value) {
		this.contacts = value;
	}

	public java.lang.String getContacts() {
		return this.contacts;
	}

	public void setMobile(java.lang.String value) {
		this.mobile = value;
	}

	public java.lang.String getMobile() {
		return this.mobile;
	}

	public void setAddress(java.lang.String value) {
		this.address = value;
	}

	public java.lang.String getAddress() {
		return this.address;
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

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("AddrId", getAddrId())
				.append("Contacts", getContacts())
				.append("Mobile", getMobile()).append("Address", getAddress())
				.append("CreateTime", getCreateTime())
				.append("EditTime", getEditTime()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getAddrId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof BusinessAddress == false)
			return false;
		if (this == obj)
			return true;
		BusinessAddress other = (BusinessAddress) obj;
		return new EqualsBuilder().append(getAddrId(), other.getAddrId())
				.isEquals();
	}
}