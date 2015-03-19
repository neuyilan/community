package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessOpertaion;

public class BusinessOpertaionQuery extends BaseBean {
	
	private java.lang.Integer operId;
	private java.lang.Integer operUserId;
	private java.lang.String operUserName;
	private java.lang.String operIp;
	private java.lang.String typeId;
	private java.lang.String attrId;
	private java.lang.Integer funcId;
	private java.lang.String funcTitle;
	private java.lang.String state;
	private java.sql.Timestamp logTime;

	public BusinessOpertaionQuery(BusinessOpertaion businessOpertaion) {
		this.operId = businessOpertaion.getOperId();
		this.operUserId = businessOpertaion.getOperUserId();
		this.operUserName = businessOpertaion.getOperUserName();
		this.operIp = businessOpertaion.getOperIp();
		this.typeId = businessOpertaion.getTypeId();
		this.attrId = businessOpertaion.getAttrId();
		this.funcId = businessOpertaion.getFuncId();
		this.funcTitle = businessOpertaion.getFuncTitle();
		this.state = businessOpertaion.getState();
		this.logTime = businessOpertaion.getLogTime();
	}
	
	public BusinessOpertaionQuery() {
		
	}	
	
	public java.lang.Integer getOperId() {
		return this.operId;
	}
	
	public java.lang.String getState() {
		return state;
	}

	public void setState(java.lang.String state) {
		this.state = state;
	}

	public void setOperId(java.lang.Integer value) {
		this.operId = value;
	}
		
	public java.lang.Integer getOperUserId() {
		return this.operUserId;
	}
	
	public void setOperUserId(java.lang.Integer value) {
		this.operUserId = value;
	}
		
	public java.lang.String getOperUserName() {
		return this.operUserName;
	}
	
	public void setOperUserName(java.lang.String value) {
		this.operUserName = value;
	}
		
	public java.lang.String getOperIp() {
		return this.operIp;
	}
	
	public void setOperIp(java.lang.String value) {
		this.operIp = value;
	}
		
	public java.lang.String getTypeId() {
		return this.typeId;
	}
	
	public void setTypeId(java.lang.String value) {
		this.typeId = value;
	}
		
	public java.lang.String getAttrId() {
		return this.attrId;
	}
	
	public void setAttrId(java.lang.String value) {
		this.attrId = value;
	}
		
	public java.lang.Integer getFuncId() {
		return this.funcId;
	}
	
	public void setFuncId(java.lang.Integer value) {
		this.funcId = value;
	}
		
	public java.lang.String getFuncTitle() {
		return this.funcTitle;
	}
	
	public void setFuncTitle(java.lang.String value) {
		this.funcTitle = value;
	}
		
	public java.sql.Timestamp getLogTime() {
		return this.logTime;
	}
	
	public void setLogTime(java.sql.Timestamp value) {
		this.logTime = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
}