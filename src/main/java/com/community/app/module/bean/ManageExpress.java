package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class ManageExpress implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "ManageExpress";

	private Integer expressId;
	private String expressComppay;
	private String expressDesc;
	private String expressAddress;
	private String expressIcon;
	private String expressFee;
	private String expressTel;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private String editor;
	private Integer stationId;
	private String staTel;
	private Integer state;
	
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getStaTel() {
		return staTel;
	}

	public void setStaTel(String staTel) {
		this.staTel = staTel;
	}

	public Integer getStationId() {
		return stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

	public ManageExpress(){
	}

	public ManageExpress(
		Integer expressId
	){
		this.expressId = expressId;
	}

	public void setExpressId(Integer value) {
		this.expressId = value;
	}
	
	public Integer getExpressId() {
		return this.expressId;
	}
	public void setExpressComppay(String value) {
		this.expressComppay = value;
	}
	
	public String getExpressComppay() {
		return this.expressComppay;
	}
	public void setExpressDesc(String value) {
		this.expressDesc = value;
	}
	
	public String getExpressDesc() {
		return this.expressDesc;
	}
	public void setExpressAddress(String value) {
		this.expressAddress = value;
	}
	
	public String getExpressAddress() {
		return this.expressAddress;
	}
	public void setExpressIcon(String value) {
		this.expressIcon = value;
	}
	
	public String getExpressIcon() {
		return this.expressIcon;
	}
	public void setExpressFee(String value) {
		this.expressFee = value;
	}
	
	public String getExpressFee() {
		return this.expressFee;
	}
	public void setExpressTel(String value) {
		this.expressTel = value;
	}
	
	public String getExpressTel() {
		return this.expressTel;
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
	public void setEditor(String value) {
		this.editor = value;
	}
	
	public String getEditor() {
		return this.editor;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("ExpressId",getExpressId())
			.append("ExpressComppay",getExpressComppay())
			.append("ExpressDesc",getExpressDesc())
			.append("ExpressAddress",getExpressAddress())
			.append("ExpressIcon",getExpressIcon())
			.append("ExpressFee",getExpressFee())
			.append("ExpressTel",getExpressTel())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getExpressId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ManageExpress == false) return false;
		if(this == obj) return true;
		ManageExpress other = (ManageExpress)obj;
		return new EqualsBuilder()
			.append(getExpressId(),other.getExpressId())
			.isEquals();
	}
}

