package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class BusinessBusStation implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessBusStation";

	private java.lang.Integer stationId;
	private java.lang.String stationName;
	private java.lang.Double estateLongitude;
	private java.lang.Double estateLatitude;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public BusinessBusStation(){
	}

	public BusinessBusStation(
		java.lang.Integer stationId
	){
		this.stationId = stationId;
	}

	public void setStationId(java.lang.Integer value) {
		this.stationId = value;
	}
	
	public java.lang.Integer getStationId() {
		return this.stationId;
	}
	public void setStationName(java.lang.String value) {
		this.stationName = value;
	}
	
	public java.lang.String getStationName() {
		return this.stationName;
	}
	public void setEstateLongitude(java.lang.Double value) {
		this.estateLongitude = value;
	}
	
	public java.lang.Double getEstateLongitude() {
		return this.estateLongitude;
	}
	public void setEstateLatitude(java.lang.Double value) {
		this.estateLatitude = value;
	}
	
	public java.lang.Double getEstateLatitude() {
		return this.estateLatitude;
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
			.append("StationId",getStationId())
			.append("StationName",getStationName())
			.append("EstateLongitude",getEstateLongitude())
			.append("EstateLatitude",getEstateLatitude())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getStationId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessBusStation == false) return false;
		if(this == obj) return true;
		BusinessBusStation other = (BusinessBusStation)obj;
		return new EqualsBuilder()
			.append(getStationId(),other.getStationId())
			.isEquals();
	}
}

