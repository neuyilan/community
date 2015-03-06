package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.AppFocusAdScope;

public class AppFocusAdScopeQuery extends BaseBean {
	
	private java.lang.Integer scopeId;
	private java.lang.Integer focusAdId;
	private java.lang.Integer estateId;
	private java.sql.Timestamp createTime;

	public AppFocusAdScopeQuery(AppFocusAdScope appFocusAdScope) {
		this.scopeId = appFocusAdScope.getScopeId();
		this.focusAdId = appFocusAdScope.getFocusAdId();
		this.estateId = appFocusAdScope.getEstateId();
		this.createTime = appFocusAdScope.getCreateTime();
	}
	
	public AppFocusAdScopeQuery() {
		
	}	
	
	public java.lang.Integer getScopeId() {
		return this.scopeId;
	}
	
	public void setScopeId(java.lang.Integer value) {
		this.scopeId = value;
	}
		
	public java.lang.Integer getFocusAdId() {
		return this.focusAdId;
	}
	
	public void setFocusAdId(java.lang.Integer value) {
		this.focusAdId = value;
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