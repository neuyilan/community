package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.AppPartyAddress;
import com.community.app.module.vo.BaseBean;

public class AppPartyAddressQuery extends BaseBean {
	

	private java.lang.Integer partyAddressId;
	private java.lang.Integer estMemId;
	private java.lang.String name;
	private java.lang.String tel;
	private java.lang.String address;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.Integer userId;
	private java.lang.Integer estateId;
	private java.lang.Integer buildtingId;
	private java.lang.Integer unitId;
	private java.lang.String realname;
	private java.lang.String houseCode;
	private java.lang.Integer addrId;

	public java.lang.Integer getAddrId() {
		return addrId;
	}

	public void setAddrId(java.lang.Integer addrId) {
		this.addrId = addrId;
	}

	public java.lang.Integer getUserId() {
		return userId;
	}

	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	public java.lang.Integer getEstateId() {
		return estateId;
	}

	public void setEstateId(java.lang.Integer estateId) {
		this.estateId = estateId;
	}

	public java.lang.Integer getBuildtingId() {
		return buildtingId;
	}

	public void setBuildtingId(java.lang.Integer buildtingId) {
		this.buildtingId = buildtingId;
	}

	public java.lang.Integer getUnitId() {
		return unitId;
	}

	public void setUnitId(java.lang.Integer unitId) {
		this.unitId = unitId;
	}

	public java.lang.String getRealname() {
		return realname;
	}

	public void setRealname(java.lang.String realname) {
		this.realname = realname;
	}

	public java.lang.String getHouseCode() {
		return houseCode;
	}

	public void setHouseCode(java.lang.String houseCode) {
		this.houseCode = houseCode;
	}

	public AppPartyAddressQuery(AppPartyAddress appPartyAddress) {
		this.partyAddressId = appPartyAddress.getPartyAddressId();
		this.estMemId = appPartyAddress.getEstMemId();
		this.name = appPartyAddress.getName();
		this.tel = appPartyAddress.getTel();
		this.address = appPartyAddress.getAddress();
		this.createTime = appPartyAddress.getCreateTime();
		this.editTime = appPartyAddress.getEditTime();
		this.editor = appPartyAddress.getEditor();
	}
	
	public AppPartyAddressQuery() {
		
	}	
	
	public java.lang.Integer getPartyAddressId() {
		return this.partyAddressId;
	}
	
	public void setPartyAddressId(java.lang.Integer value) {
		this.partyAddressId = value;
	}
		
	public java.lang.Integer getEstMemId() {
		return this.estMemId;
	}
	
	public void setEstMemId(java.lang.Integer value) {
		this.estMemId = value;
	}
		
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setName(java.lang.String value) {
		this.name = value;
	}
		
	public java.lang.String getTel() {
		return this.tel;
	}
	
	public void setTel(java.lang.String value) {
		this.tel = value;
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

