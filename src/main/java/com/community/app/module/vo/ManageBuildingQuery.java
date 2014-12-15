package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.ManageBuilding;
import com.community.app.module.vo.BaseBean;

public class ManageBuildingQuery extends BaseBean {
	

	private java.lang.Integer buildingId;
	private java.lang.Integer estateId;
	private java.lang.String buildingName;
	private java.lang.String buildingDesc;
	private java.lang.Integer buildingFloor;
	private java.lang.Double estateLongitude;
	private java.lang.Double estateLatitude;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.String buildingMap;

	public ManageBuildingQuery(ManageBuilding manageBuilding) {
		this.buildingId = manageBuilding.getBuildingId();
		this.estateId = manageBuilding.getEstateId();
		this.buildingName = manageBuilding.getBuildingName();
		this.buildingDesc = manageBuilding.getBuildingDesc();
		this.buildingFloor = manageBuilding.getBuildingFloor();
		this.estateLongitude = manageBuilding.getEstateLongitude();
		this.estateLatitude = manageBuilding.getEstateLatitude();
		this.createTime = manageBuilding.getCreateTime();
		this.editTime = manageBuilding.getEditTime();
		this.editor = manageBuilding.getEditor();
		this.buildingMap = manageBuilding.getBuildingMap();
	}
	
	public ManageBuildingQuery() {
		
	}	
	
	public java.lang.Integer getBuildingId() {
		return this.buildingId;
	}
	
	public void setBuildingId(java.lang.Integer value) {
		this.buildingId = value;
	}
		
	public java.lang.Integer getEstateId() {
		return this.estateId;
	}
	
	public void setEstateId(java.lang.Integer value) {
		this.estateId = value;
	}
		
	public java.lang.String getBuildingName() {
		return this.buildingName;
	}
	
	public void setBuildingName(java.lang.String value) {
		this.buildingName = value;
	}
		
	public java.lang.String getBuildingDesc() {
		return this.buildingDesc;
	}
	
	public void setBuildingDesc(java.lang.String value) {
		this.buildingDesc = value;
	}
		
	public java.lang.Integer getBuildingFloor() {
		return this.buildingFloor;
	}
	
	public void setBuildingFloor(java.lang.Integer value) {
		this.buildingFloor = value;
	}
		
	public java.lang.Double getEstateLongitude() {
		return this.estateLongitude;
	}
	
	public void setEstateLongitude(java.lang.Double value) {
		this.estateLongitude = value;
	}
		
	public java.lang.Double getEstateLatitude() {
		return this.estateLatitude;
	}
	
	public void setEstateLatitude(java.lang.Double value) {
		this.estateLatitude = value;
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
		
	public java.lang.String getBuildingMap() {
		return this.buildingMap;
	}
	
	public void setBuildingMap(java.lang.String value) {
		this.buildingMap = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

