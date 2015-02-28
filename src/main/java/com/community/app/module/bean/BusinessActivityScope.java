package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessActivityScope implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessActivityScope";

	private java.lang.Integer scopeId;
	private java.lang.Integer actId;
	private java.lang.Integer estateId;
	private java.lang.String estateName;
	private java.sql.Timestamp createTime;

	public BusinessActivityScope(){
	}

	public BusinessActivityScope(
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
	public void setActId(java.lang.Integer value) {
		this.actId = value;
	}
	
	public java.lang.Integer getActId() {
		return this.actId;
	}
	public void setEstateId(java.lang.Integer value) {
		this.estateId = value;
	}
	
	public java.lang.Integer getEstateId() {
		return this.estateId;
	}
	public void setEstateName(java.lang.String value) {
		this.estateName = value;
	}
	
	public java.lang.String getEstateName() {
		return this.estateName;
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
			.append("ActId",getActId())
			.append("EstateId",getEstateId())
			.append("EstateName",getEstateName())
			.append("CreateTime",getCreateTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getScopeId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessActivityScope == false) return false;
		if(this == obj) return true;
		BusinessActivityScope other = (BusinessActivityScope)obj;
		return new EqualsBuilder()
			.append(getScopeId(),other.getScopeId())
			.isEquals();
	}
}

