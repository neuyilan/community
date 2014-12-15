package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessActivityRegistrationTimeslot;

public class BusinessActivityRegistrationTimeslotQuery extends BaseBean {
	

	private java.lang.Integer timeSlotId;
	private java.lang.Integer actId;
	private java.lang.String timeSlotName;
	private java.lang.Integer number;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public BusinessActivityRegistrationTimeslotQuery(BusinessActivityRegistrationTimeslot businessActivityRegistrationTimeslot) {
		this.timeSlotId = businessActivityRegistrationTimeslot.getTimeSlotId();
		this.actId = businessActivityRegistrationTimeslot.getActId();
		this.timeSlotName = businessActivityRegistrationTimeslot.getTimeSlotName();
		this.number = businessActivityRegistrationTimeslot.getNumber();
		this.createTime = businessActivityRegistrationTimeslot.getCreateTime();
		this.editTime = businessActivityRegistrationTimeslot.getEditTime();
		this.editor = businessActivityRegistrationTimeslot.getEditor();
	}
	
	public BusinessActivityRegistrationTimeslotQuery() {
		
	}	
	
	public java.lang.Integer getTimeSlotId() {
		return this.timeSlotId;
	}
	
	public void setTimeSlotId(java.lang.Integer value) {
		this.timeSlotId = value;
	}
		
	public java.lang.Integer getActId() {
		return this.actId;
	}
	
	public void setActId(java.lang.Integer value) {
		this.actId = value;
	}
		
	public java.lang.String getTimeSlotName() {
		return this.timeSlotName;
	}
	
	public void setTimeSlotName(java.lang.String value) {
		this.timeSlotName = value;
	}
		
	public java.lang.Integer getNumber() {
		return this.number;
	}
	
	public void setNumber(java.lang.Integer value) {
		this.number = value;
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