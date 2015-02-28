package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessBus implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessBus";

	private java.lang.Integer busId;
	private java.lang.String busName;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.String starTime;
	private java.lang.String endTime;
	private java.lang.String starName;
	private java.lang.String endName;
	private java.lang.Integer count;
	private java.lang.String type;

	public BusinessBus(){
	}

	public BusinessBus(
		java.lang.Integer busId
	){
		this.busId = busId;
	}

	public void setBusId(java.lang.Integer value) {
		this.busId = value;
	}
	
	public java.lang.Integer getBusId() {
		return this.busId;
	}
	public void setBusName(java.lang.String value) {
		this.busName = value;
	}
	
	public java.lang.String getBusName() {
		return this.busName;
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
	public void setStarTime(java.lang.String value) {
		this.starTime = value;
	}
	
	public java.lang.String getStarTime() {
		return this.starTime;
	}
	public void setEndTime(java.lang.String value) {
		this.endTime = value;
	}
	
	public java.lang.String getEndTime() {
		return this.endTime;
	}
	public void setStarName(java.lang.String value) {
		this.starName = value;
	}
	
	public java.lang.String getStarName() {
		return this.starName;
	}
	public void setEndName(java.lang.String value) {
		this.endName = value;
	}
	
	public java.lang.String getEndName() {
		return this.endName;
	}
	public void setCount(java.lang.Integer value) {
		this.count = value;
	}
	
	public java.lang.Integer getCount() {
		return this.count;
	}
	public void setType(java.lang.String value) {
		this.type = value;
	}
	
	public java.lang.String getType() {
		return this.type;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("BusId",getBusId())
			.append("BusName",getBusName())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.append("StarTime",getStarTime())
			.append("EndTime",getEndTime())
			.append("StarName",getStarName())
			.append("EndName",getEndName())
			.append("Count",getCount())
			.append("Type",getType())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getBusId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessBus == false) return false;
		if(this == obj) return true;
		BusinessBus other = (BusinessBus)obj;
		return new EqualsBuilder()
			.append(getBusId(),other.getBusId())
			.isEquals();
	}
}

