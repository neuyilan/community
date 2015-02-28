package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessBusStation;

public class BusinessBusStationQuery extends BaseBean {
	

	private java.lang.Integer stationId;
	private java.lang.String stationName;
	private java.lang.Double estateLongitude;
	private java.lang.Double estateLatitude;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.Integer busId;
	private java.lang.String busName;

	public java.lang.Integer getBusId() {
		return busId;
	}

	public void setBusId(java.lang.Integer busId) {
		this.busId = busId;
	}

	public java.lang.String getBusName() {
		return busName;
	}

	public void setBusName(java.lang.String busName) {
		this.busName = busName;
	}

	public BusinessBusStationQuery(BusinessBusStation businessBusStation) {
		this.stationId = businessBusStation.getStationId();
		this.stationName = businessBusStation.getStationName();
		this.estateLongitude = businessBusStation.getEstateLongitude();
		this.estateLatitude = businessBusStation.getEstateLatitude();
		this.createTime = businessBusStation.getCreateTime();
		this.editTime = businessBusStation.getEditTime();
		this.editor = businessBusStation.getEditor();
	}
	
	public BusinessBusStationQuery() {
		
	}	
	
	public java.lang.Integer getStationId() {
		return this.stationId;
	}
	
	public void setStationId(java.lang.Integer value) {
		this.stationId = value;
	}
		
	public java.lang.String getStationName() {
		return this.stationName;
	}
	
	public void setStationName(java.lang.String value) {
		this.stationName = value;
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
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

