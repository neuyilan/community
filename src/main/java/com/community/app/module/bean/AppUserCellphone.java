package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class AppUserCellphone implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "AppUserCellphone";

	private java.lang.Integer cellphoneId;
	private java.lang.Integer userId;
	private Integer isDefault;
	private java.lang.String cellphone;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public AppUserCellphone(){
	}

	public AppUserCellphone(
		java.lang.Integer cellphoneId
	){
		this.cellphoneId = cellphoneId;
	}

	public void setCellphoneId(java.lang.Integer value) {
		this.cellphoneId = value;
	}
	
	public java.lang.Integer getCellphoneId() {
		return this.cellphoneId;
	}
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
	
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	public void setIsDefault(Integer value) {
		this.isDefault = value;
	}
	
	public Integer getIsDefault() {
		return this.isDefault;
	}
	public void setCellphone(java.lang.String value) {
		this.cellphone = value;
	}
	
	public java.lang.String getCellphone() {
		return this.cellphone;
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
			.append("CellphoneId",getCellphoneId())
			.append("UserId",getUserId())
			.append("IsDefault",getIsDefault())
			.append("Cellphone",getCellphone())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCellphoneId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AppUserCellphone == false) return false;
		if(this == obj) return true;
		AppUserCellphone other = (AppUserCellphone)obj;
		return new EqualsBuilder()
			.append(getCellphoneId(),other.getCellphoneId())
			.isEquals();
	}
}

