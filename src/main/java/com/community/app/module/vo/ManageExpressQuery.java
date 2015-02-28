package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.ManageExpress;

public class ManageExpressQuery extends BaseBean {
	

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
	private Integer userId;
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getStationId() {
		return stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

	public ManageExpressQuery(ManageExpress manageExpress) {
		this.expressId = manageExpress.getExpressId();
		this.expressComppay = manageExpress.getExpressComppay();
		this.expressDesc = manageExpress.getExpressDesc();
		this.expressAddress = manageExpress.getExpressAddress();
		this.expressIcon = manageExpress.getExpressIcon();
		this.expressFee = manageExpress.getExpressFee();
		this.expressTel = manageExpress.getExpressTel();
		this.createTime = manageExpress.getCreateTime();
		this.editTime = manageExpress.getEditTime();
		this.editor = manageExpress.getEditor();
	}
	
	public ManageExpressQuery() {
		
	}	
	
	public Integer getExpressId() {
		return this.expressId;
	}
	
	public void setExpressId(Integer value) {
		this.expressId = value;
	}
		
	public String getExpressComppay() {
		return this.expressComppay;
	}
	
	public void setExpressComppay(String value) {
		this.expressComppay = value;
	}
		
	public String getExpressDesc() {
		return this.expressDesc;
	}
	
	public void setExpressDesc(String value) {
		this.expressDesc = value;
	}
		
	public String getExpressAddress() {
		return this.expressAddress;
	}
	
	public void setExpressAddress(String value) {
		this.expressAddress = value;
	}
		
	public String getExpressIcon() {
		return this.expressIcon;
	}
	
	public void setExpressIcon(String value) {
		this.expressIcon = value;
	}
		
	public String getExpressFee() {
		return this.expressFee;
	}
	
	public void setExpressFee(String value) {
		this.expressFee = value;
	}
		
	public String getExpressTel() {
		return this.expressTel;
	}
	
	public void setExpressTel(String value) {
		this.expressTel = value;
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
		
	public String getEditor() {
		return this.editor;
	}
	
	public void setEditor(String value) {
		this.editor = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

