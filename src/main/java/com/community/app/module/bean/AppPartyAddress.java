package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class AppPartyAddress implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "AppPartyAddress";

	private java.lang.Integer partyAddressId;
	private java.lang.Integer estMemId;
	private java.lang.String name;
	private java.lang.String tel;
	private java.lang.String address;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.Integer type;

	public java.lang.Integer getType() {
		return type;
	}

	public void setType(java.lang.Integer type) {
		this.type = type;
	}

	public AppPartyAddress(){
	}

	public AppPartyAddress(
		java.lang.Integer partyAddressId
	){
		this.partyAddressId = partyAddressId;
	}

	public void setPartyAddressId(java.lang.Integer value) {
		this.partyAddressId = value;
	}
	
	public java.lang.Integer getPartyAddressId() {
		return this.partyAddressId;
	}
	public void setEstMemId(java.lang.Integer value) {
		this.estMemId = value;
	}
	
	public java.lang.Integer getEstMemId() {
		return this.estMemId;
	}
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	public void setTel(java.lang.String value) {
		this.tel = value;
	}
	
	public java.lang.String getTel() {
		return this.tel;
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
	public void setEditor(java.lang.String value) {
		this.editor = value;
	}
	
	public java.lang.String getEditor() {
		return this.editor;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("PartyAddressId",getPartyAddressId())
			.append("EstMemId",getEstMemId())
			.append("Name",getName())
			.append("Tel",getTel())
			.append("AddressId",getAddress())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getPartyAddressId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AppPartyAddress == false) return false;
		if(this == obj) return true;
		AppPartyAddress other = (AppPartyAddress)obj;
		return new EqualsBuilder()
			.append(getPartyAddressId(),other.getPartyAddressId())
			.isEquals();
	}
}

