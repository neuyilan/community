package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessTelGroup;

public class BusinessTelGroupQuery extends BaseBean {
	

	private java.lang.Integer groupId;
	private java.lang.String groupName;
	private java.lang.String memo;
	private java.lang.Integer userId;
	private java.lang.Integer cityId;
	private java.lang.Integer comId;
	private java.lang.Integer estateId;
	private java.lang.Integer type;

	public BusinessTelGroupQuery(BusinessTelGroup businessTelGroup) {
		this.groupId = businessTelGroup.getGroupId();
		this.groupName = businessTelGroup.getGroupName();
		this.memo = businessTelGroup.getMemo();
	}
	
	public java.lang.Integer getType() {
		return type;
	}

	public void setType(java.lang.Integer type) {
		this.type = type;
	}

	public java.lang.Integer getUserId() {
		return userId;
	}

	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	public java.lang.Integer getCityId() {
		return cityId;
	}

	public void setCityId(java.lang.Integer cityId) {
		this.cityId = cityId;
	}

	public java.lang.Integer getComId() {
		return comId;
	}

	public void setComId(java.lang.Integer comId) {
		this.comId = comId;
	}

	public java.lang.Integer getEstateId() {
		return estateId;
	}

	public void setEstateId(java.lang.Integer estateId) {
		this.estateId = estateId;
	}

	public BusinessTelGroupQuery() {
		
	}	
	
	public java.lang.Integer getGroupId() {
		return this.groupId;
	}
	
	public void setGroupId(java.lang.Integer value) {
		this.groupId = value;
	}
		
	public java.lang.String getGroupName() {
		return this.groupName;
	}
	
	public void setGroupName(java.lang.String value) {
		this.groupName = value;
	}
		
	public java.lang.String getMemo() {
		return this.memo;
	}
	
	public void setMemo(java.lang.String value) {
		this.memo = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

