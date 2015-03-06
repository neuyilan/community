package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class AppFocusAdScope implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "AppFocusAdScope";

	private java.lang.Integer scopeId;
	private java.lang.Integer focusAdId;
	private java.lang.Integer estateId;
	private java.sql.Timestamp createTime;
	private java.lang.String estateName;
	
	public java.lang.String getEstateName() {
		return estateName;
	}

	public void setEstateName(java.lang.String estateName) {
		this.estateName = estateName;
	}

	public AppFocusAdScope(){
	}

	public AppFocusAdScope(
		java.lang.Integer scopeId
	){
		this.scopeId = scopeId;
	}

	public void setScopeId(java.lang.Integer value) {
		this.scopeId = value;
	}
	
	public java.lang.Integer getScopeId() {
		return this.scopeId;
	}
	public void setFocusAdId(java.lang.Integer value) {
		this.focusAdId = value;
	}
	
	public java.lang.Integer getFocusAdId() {
		return this.focusAdId;
	}
	public void setEstateId(java.lang.Integer value) {
		this.estateId = value;
	}
	
	public java.lang.Integer getEstateId() {
		return this.estateId;
	}
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
	
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("ScopeId",getScopeId())
			.append("FocusAdId",getFocusAdId())
			.append("EstateId",getEstateId())
			.append("CreateTime",getCreateTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getScopeId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AppFocusAdScope == false) return false;
		if(this == obj) return true;
		AppFocusAdScope other = (AppFocusAdScope)obj;
		return new EqualsBuilder()
			.append(getScopeId(),other.getScopeId())
			.isEquals();
	}
}