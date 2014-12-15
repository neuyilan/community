package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessHelpExpendestates;

public class BusinessHelpExpendestatesQuery extends BaseBean {
	
	private java.lang.Integer expendEstatesId;
	private java.lang.Integer helpId;
	private java.lang.Integer estateId;
	private java.sql.Timestamp createTime;
	private java.lang.String scope;

	public BusinessHelpExpendestatesQuery(BusinessHelpExpendestates businessHelpExpendestates) {
		this.expendEstatesId = businessHelpExpendestates.getExpendEstatesId();
		this.helpId = businessHelpExpendestates.getHelpId();
		this.estateId = businessHelpExpendestates.getEstateId();
		this.createTime = businessHelpExpendestates.getCreateTime();
	}
	
	public BusinessHelpExpendestatesQuery() {  }	
	
	public java.lang.String getScope() {
		return scope;
	}

	public void setScope(java.lang.String scope) {
		this.scope = scope;
	}
	
	public java.lang.Integer getExpendEstatesId() {
		return this.expendEstatesId;
	}
	
	public void setExpendEstatesId(java.lang.Integer value) {
		this.expendEstatesId = value;
	}
		
	public java.lang.Integer getHelpId() {
		return this.helpId;
	}
	
	public void setHelpId(java.lang.Integer value) {
		this.helpId = value;
	}
		
	public java.lang.Integer getEstateId() {
		return this.estateId;
	}
	
	public void setEstateId(java.lang.Integer value) {
		this.estateId = value;
	}
		
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
}