package com.community.app.module.vo;


import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessActivityQnhInformation;
import com.community.app.module.vo.BaseBean;

public class BusinessActivityQnhInformationQuery extends BaseBean {
	

	private java.lang.Integer informationId;
	private java.lang.Integer userId;
	private java.lang.Integer actId;
	private java.lang.String realname;
	private java.lang.String tel;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.String ID;

	public java.lang.String getID() {
		return ID;
	}

	public void setID(java.lang.String iD) {
		ID = iD;
	}

	public java.lang.String getTel() {
		return tel;
	}

	public void setTel(java.lang.String tel) {
		this.tel = tel;
	}

	public BusinessActivityQnhInformationQuery(BusinessActivityQnhInformation businessActivityQnhInformation) {
		this.informationId = businessActivityQnhInformation.getInformationId();
		this.userId = businessActivityQnhInformation.getUserId();
		this.actId = businessActivityQnhInformation.getActId();
		this.realname = businessActivityQnhInformation.getRealname();
		this.createTime = businessActivityQnhInformation.getCreateTime();
		this.editTime = businessActivityQnhInformation.getEditTime();
		this.editor = businessActivityQnhInformation.getEditor();
	}
	
	public BusinessActivityQnhInformationQuery() {
		
	}	
	
	public java.lang.Integer getInformationId() {
		return this.informationId;
	}
	
	public void setInformationId(java.lang.Integer value) {
		this.informationId = value;
	}
		
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
		
	public java.lang.Integer getActId() {
		return this.actId;
	}
	
	public void setActId(java.lang.Integer value) {
		this.actId = value;
	}
		
	public java.lang.String getRealname() {
		return this.realname;
	}
	
	public void setRealname(java.lang.String value) {
		this.realname = value;
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

