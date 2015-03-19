package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessOpertaion implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessOpertaion";

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
	
	public BusinessOpertaion(Integer operUserId, String operUserName, 
			String typeId, String attrId, Integer funcId,
			String funcTitle, String state, String operIp) {
		super();
		this.operUserId = operUserId;
		this.operUserName = operUserName;
		this.typeId = typeId;
		this.attrId = attrId;
		this.funcId = funcId;
		this.funcTitle = funcTitle;
		this.state = state;
		this.operIp = operIp;
	}

	public BusinessOpertaion(){
	}

	public BusinessOpertaion(java.lang.Integer operId){
		this.operId = operId;
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
	
	public java.lang.Integer getOperId() {
		return this.operId;
	}
	public void setOperUserId(java.lang.Integer value) {
		this.operUserId = value;
	}
	
	public java.lang.Integer getOperUserId() {
		return this.operUserId;
	}
	public void setOperUserName(java.lang.String value) {
		this.operUserName = value;
	}
	
	public java.lang.String getOperUserName() {
		return this.operUserName;
	}
	public void setOperIp(java.lang.String value) {
		this.operIp = value;
	}
	
	public java.lang.String getOperIp() {
		return this.operIp;
	}
	public void setTypeId(java.lang.String value) {
		this.typeId = value;
	}
	
	public java.lang.String getTypeId() {
		return this.typeId;
	}
	public void setAttrId(java.lang.String value) {
		this.attrId = value;
	}
	
	public java.lang.String getAttrId() {
		return this.attrId;
	}
	public void setFuncId(java.lang.Integer value) {
		this.funcId = value;
	}
	
	public java.lang.Integer getFuncId() {
		return this.funcId;
	}
	public void setFuncTitle(java.lang.String value) {
		this.funcTitle = value;
	}
	
	public java.lang.String getFuncTitle() {
		return this.funcTitle;
	}
	public void setLogTime(java.sql.Timestamp value) {
		this.logTime = value;
	}
	
	public java.sql.Timestamp getLogTime() {
		return this.logTime;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("OperId",getOperId())
			.append("OperUserId",getOperUserId())
			.append("OperUserName",getOperUserName())
			.append("OperIp",getOperIp())
			.append("TypeId",getTypeId())
			.append("AttrId",getAttrId())
			.append("FuncId",getFuncId())
			.append("FuncTitle",getFuncTitle())
			.append("LogTime",getLogTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getOperId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessOpertaion == false) return false;
		if(this == obj) return true;
		BusinessOpertaion other = (BusinessOpertaion)obj;
		return new EqualsBuilder()
			.append(getOperId(),other.getOperId())
			.isEquals();
	}
}