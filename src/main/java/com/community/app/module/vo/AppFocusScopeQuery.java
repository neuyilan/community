package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.AppFocusScope;

public class AppFocusScopeQuery extends BaseBean {
	
	private java.lang.Integer scopeId;
	private java.lang.Integer focusId;
	private java.lang.Integer estateId;
	private java.sql.Timestamp createTime;

	public AppFocusScopeQuery(AppFocusScope appFocusScope) {
		this.scopeId = appFocusScope.getScopeId();
		this.focusId = appFocusScope.getFocusId();
		this.estateId = appFocusScope.getEstateId();
		this.createTime = appFocusScope.getCreateTime();
	}
	
	public AppFocusScopeQuery() {
		
	}	
	
	public java.lang.Integer getScopeId() {
		return this.scopeId;
	}
	
	public void setScopeId(java.lang.Integer value) {
		this.scopeId = value;
	}
		
	public java.lang.Integer getFocusId() {
		return this.focusId;
	}
	
	public void setFocusId(java.lang.Integer value) {
		this.focusId = value;
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