package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class ManageModule implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "ManageModule";

	private java.lang.Integer moduleId;
	private java.lang.String moduleName;
	private java.lang.String moduleCode;
	private java.lang.String moduleDesc;
	private java.lang.String moduleIcon;
	private java.lang.String moduleUrl;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public ManageModule(){
	}

	public ManageModule(
		java.lang.Integer moduleId
	){
		this.moduleId = moduleId;
	}

	public void setModuleId(java.lang.Integer value) {
		this.moduleId = value;
	}
	
	public java.lang.Integer getModuleId() {
		return this.moduleId;
	}
	public void setModuleName(java.lang.String value) {
		this.moduleName = value;
	}
	
	public java.lang.String getModuleName() {
		return this.moduleName;
	}
	public void setModuleCode(java.lang.String value) {
		this.moduleCode = value;
	}
	
	public java.lang.String getModuleCode() {
		return this.moduleCode;
	}
	public void setModuleDesc(java.lang.String value) {
		this.moduleDesc = value;
	}
	
	public java.lang.String getModuleDesc() {
		return this.moduleDesc;
	}
	public void setModuleIcon(java.lang.String value) {
		this.moduleIcon = value;
	}
	
	public java.lang.String getModuleIcon() {
		return this.moduleIcon;
	}
	public void setModuleUrl(java.lang.String value) {
		this.moduleUrl = value;
	}
	
	public java.lang.String getModuleUrl() {
		return this.moduleUrl;
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
			.append("ModuleId",getModuleId())
			.append("ModuleName",getModuleName())
			.append("ModuleCode",getModuleCode())
			.append("ModuleDesc",getModuleDesc())
			.append("ModuleIcon",getModuleIcon())
			.append("ModuleUrl",getModuleUrl())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getModuleId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ManageModule == false) return false;
		if(this == obj) return true;
		ManageModule other = (ManageModule)obj;
		return new EqualsBuilder()
			.append(getModuleId(),other.getModuleId())
			.isEquals();
	}
}

