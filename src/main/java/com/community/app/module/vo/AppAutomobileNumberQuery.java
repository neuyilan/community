package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.AppAutomobileNumber;


public class AppAutomobileNumberQuery extends BaseBean {
	

	private java.lang.Integer numberId;
	private java.lang.String numberName;
	private java.lang.Integer userId;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.String deleteNumber;
	private java.lang.String addNumber;

	public AppAutomobileNumberQuery(AppAutomobileNumber appAutomobileNumber) {
		this.numberId = appAutomobileNumber.getNumberId();
		this.numberName = appAutomobileNumber.getNumberName();
		this.userId = appAutomobileNumber.getUserId();
		this.createTime = appAutomobileNumber.getCreateTime();
		this.editTime = appAutomobileNumber.getEditTime();
		this.editor = appAutomobileNumber.getEditor();
	}
	
	public java.lang.String getDeleteNumber() {
		return deleteNumber;
	}

	public void setDeleteNumber(java.lang.String deleteNumber) {
		this.deleteNumber = deleteNumber;
	}

	public java.lang.String getAddNumber() {
		return addNumber;
	}

	public void setAddNumber(java.lang.String addNumber) {
		this.addNumber = addNumber;
	}

	public AppAutomobileNumberQuery() {
		
	}	
	
	public java.lang.Integer getNumberId() {
		return this.numberId;
	}
	
	public void setNumberId(java.lang.Integer value) {
		this.numberId = value;
	}
		
	public java.lang.String getNumberName() {
		return this.numberName;
	}
	
	public void setNumberName(java.lang.String value) {
		this.numberName = value;
	}
		
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
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

