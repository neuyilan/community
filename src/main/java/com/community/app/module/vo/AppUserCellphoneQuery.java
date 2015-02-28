package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.AppUserCellphone;

public class AppUserCellphoneQuery extends BaseBean {
	

	private java.lang.Integer cellphoneId;
	private java.lang.Integer userId;
	private Integer isDefault;
	private java.lang.String cellphone;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.String tel;
	private java.lang.String value;
	private java.lang.Integer telId;


	public AppUserCellphoneQuery(AppUserCellphone appUserCellphone) {
		this.cellphoneId = appUserCellphone.getCellphoneId();
		this.userId = appUserCellphone.getUserId();
		this.isDefault = appUserCellphone.getIsDefault();
		this.cellphone = appUserCellphone.getCellphone();
		this.createTime = appUserCellphone.getCreateTime();
		this.editTime = appUserCellphone.getEditTime();
		this.editor = appUserCellphone.getEditor();
	}
	
	public AppUserCellphoneQuery() {
		
	}	
	
	public java.lang.Integer getCellphoneId() {
		return this.cellphoneId;
	}
	
	public void setCellphoneId(java.lang.Integer value) {
		this.cellphoneId = value;
	}
		
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
		
	public Integer getIsDefault() {
		return this.isDefault;
	}
	
	public void setIsDefault(Integer value) {
		this.isDefault = value;
	}
		
	public java.lang.String getCellphone() {
		return this.cellphone;
	}
	
	public void setCellphone(java.lang.String value) {
		this.cellphone = value;
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

	public java.lang.String getTel() {
		return tel;
	}

	public void setTel(java.lang.String tel) {
		this.tel = tel;
	}

	public java.lang.Integer getTelId() {
		return telId;
	}

	public void setTelId(java.lang.Integer telId) {
		this.telId = telId;
	}

	public java.lang.String getValue() {
		return value;
	}

	public void setValue(java.lang.String value) {
		this.value = value;
	}

	
}

