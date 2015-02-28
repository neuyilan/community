package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.ManageFunction;

public class ManageFunctionQuery extends BaseBean {
	

	private java.lang.Integer functionId;
	private java.lang.Integer menuId;
	private java.lang.String functionName;
	private java.lang.String functionDesc;
	private java.lang.String functionCode;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public ManageFunctionQuery(ManageFunction manageFunction) {
		this.functionId = manageFunction.getFunctionId();
		this.menuId = manageFunction.getMenuId();
		this.functionName = manageFunction.getFunctionName();
		this.functionDesc = manageFunction.getFunctionDesc();
		this.functionCode = manageFunction.getFunctionCode();
		this.createTime = manageFunction.getCreateTime();
		this.editTime = manageFunction.getEditTime();
		this.editor = manageFunction.getEditor();
	}
	
	public ManageFunctionQuery() {
		
	}	
	
	public java.lang.Integer getFunctionId() {
		return this.functionId;
	}
	
	public void setFunctionId(java.lang.Integer value) {
		this.functionId = value;
	}
		
	public java.lang.Integer getMenuId() {
		return this.menuId;
	}
	
	public void setMenuId(java.lang.Integer value) {
		this.menuId = value;
	}
		
	public java.lang.String getFunctionName() {
		return this.functionName;
	}
	
	public void setFunctionName(java.lang.String value) {
		this.functionName = value;
	}
		
	public java.lang.String getFunctionDesc() {
		return this.functionDesc;
	}
	
	public void setFunctionDesc(java.lang.String value) {
		this.functionDesc = value;
	}
		
	public java.lang.String getFunctionCode() {
		return this.functionCode;
	}
	
	public void setFunctionCode(java.lang.String value) {
		this.functionCode = value;
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

