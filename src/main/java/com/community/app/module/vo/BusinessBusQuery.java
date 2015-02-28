package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessBus;

public class BusinessBusQuery extends BaseBean {
	

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
	private java.lang.String busStopName;
	
	public java.lang.String getBusStopName() {
		return busStopName;
	}

	public void setBusStopName(java.lang.String busStopName) {
		this.busStopName = busStopName;
	}

	public BusinessBusQuery(BusinessBus businessBus) {
		this.busId = businessBus.getBusId();
		this.busName = businessBus.getBusName();
		this.createTime = businessBus.getCreateTime();
		this.editTime = businessBus.getEditTime();
		this.editor = businessBus.getEditor();
		this.starTime = businessBus.getStarTime();
		this.endTime = businessBus.getEndTime();
		this.starName = businessBus.getStarName();
		this.endName = businessBus.getEndName();
		this.count = businessBus.getCount();
		this.type = businessBus.getType();
	}
	
	public BusinessBusQuery() {
		
	}	
	
	public java.lang.Integer getBusId() {
		return this.busId;
	}
	
	public void setBusId(java.lang.Integer value) {
		this.busId = value;
	}
		
	public java.lang.String getBusName() {
		return this.busName;
	}
	
	public void setBusName(java.lang.String value) {
		this.busName = value;
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
		
	public java.lang.String getStarTime() {
		return this.starTime;
	}
	
	public void setStarTime(java.lang.String value) {
		this.starTime = value;
	}
		
	public java.lang.String getEndTime() {
		return this.endTime;
	}
	
	public void setEndTime(java.lang.String value) {
		this.endTime = value;
	}
		
	public java.lang.String getStarName() {
		return this.starName;
	}
	
	public void setStarName(java.lang.String value) {
		this.starName = value;
	}
		
	public java.lang.String getEndName() {
		return this.endName;
	}
	
	public void setEndName(java.lang.String value) {
		this.endName = value;
	}
		
	public java.lang.Integer getCount() {
		return this.count;
	}
	
	public void setCount(java.lang.Integer value) {
		this.count = value;
	}
		
	public java.lang.String getType() {
		return this.type;
	}
	
	public void setType(java.lang.String value) {
		this.type = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

