package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.AppEstateUser;

public class AppEstateUserQuery extends BaseBean {
	

	private java.lang.Integer estMemId;
	private java.lang.Integer estateId;
	private java.lang.Integer userId;
	private java.lang.Integer buildingId;
	private java.lang.Integer unitId;
	private java.lang.Integer houseId;
	private java.lang.String estateName;
	private java.lang.String buildingName;
	private java.lang.String unitName;
	private java.lang.String houseNo;
	private java.lang.String houseCode;
	private Integer memberType;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.Integer buildtingId;
	private java.lang.Integer currestateId;
	private java.lang.Integer ordestateId;

	public java.lang.Integer getCurrestateId() {
		return currestateId;
	}

	public void setCurrestateId(java.lang.Integer currestateId) {
		this.currestateId = currestateId;
	}

	public java.lang.Integer getOrdestateId() {
		return ordestateId;
	}

	public void setOrdestateId(java.lang.Integer ordestateId) {
		this.ordestateId = ordestateId;
	}

	public java.lang.Integer getBuildtingId() {
		return buildtingId;
	}

	public void setBuildtingId(java.lang.Integer buildtingId) {
		this.buildtingId = buildtingId;
	}

	public AppEstateUserQuery(AppEstateUser appEstateUser) {
		this.estMemId = appEstateUser.getEstMemId();
		this.estateId = appEstateUser.getEstateId();
		this.userId = appEstateUser.getUserId();
		this.buildingId = appEstateUser.getBuildingId();
		this.unitId = appEstateUser.getUnitId();
		this.houseId = appEstateUser.getHouseId();
		this.estateName = appEstateUser.getEstateName();
		this.buildingName = appEstateUser.getBuildingName();
		this.unitName = appEstateUser.getUnitName();
		this.houseNo = appEstateUser.getHouseNo();
		this.memberType = appEstateUser.getMemberType();
		this.createTime = appEstateUser.getCreateTime();
		this.editTime = appEstateUser.getEditTime();
		this.editor = appEstateUser.getEditor();
	}
	
	public AppEstateUserQuery() {
		
	}	
	
	public java.lang.Integer getEstMemId() {
		return this.estMemId;
	}
	
	public void setEstMemId(java.lang.Integer value) {
		this.estMemId = value;
	}
		
	public java.lang.Integer getEstateId() {
		return this.estateId;
	}
	
	public void setEstateId(java.lang.Integer value) {
		this.estateId = value;
	}
		
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
		
	public java.lang.Integer getBuildingId() {
		return this.buildingId;
	}
	
	public void setBuildingId(java.lang.Integer value) {
		this.buildingId = value;
	}
		
	public java.lang.Integer getUnitId() {
		return this.unitId;
	}
	
	public void setUnitId(java.lang.Integer value) {
		this.unitId = value;
	}
		
	public java.lang.Integer getHouseId() {
		return this.houseId;
	}
	
	public void setHouseId(java.lang.Integer value) {
		this.houseId = value;
	}
		
	public java.lang.String getEstateName() {
		return this.estateName;
	}
	
	public void setEstateName(java.lang.String value) {
		this.estateName = value;
	}
		
	public java.lang.String getBuildingName() {
		return this.buildingName;
	}
	
	public void setBuildingName(java.lang.String value) {
		this.buildingName = value;
	}
		
	public java.lang.String getUnitName() {
		return this.unitName;
	}
	
	public void setUnitName(java.lang.String value) {
		this.unitName = value;
	}
		
	public java.lang.String getHouseNo() {
		return this.houseNo;
	}
	
	public void setHouseNo(java.lang.String value) {
		this.houseNo = value;
	}
		
	public Integer getMemberType() {
		return this.memberType;
	}
	
	public void setMemberType(Integer value) {
		this.memberType = value;
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

	public java.lang.String getHouseCode() {
		return houseCode;
	}

	public void setHouseCode(java.lang.String houseCode) {
		this.houseCode = houseCode;
	}
	
}

