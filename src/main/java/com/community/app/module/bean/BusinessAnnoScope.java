package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class BusinessAnnoScope implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessAnnoScope";

	private java.lang.Integer scopeId;
	private java.lang.Integer annoId;
	private java.lang.Integer estateId;
	private java.lang.String estateName;
	private java.sql.Timestamp createTime;
	private Integer proId;
	private Integer scopeType;

	public BusinessAnnoScope(){
	}

	public Integer getScopeType() {
		return scopeType;
	}

	public void setScopeType(Integer scopeType) {
		this.scopeType = scopeType;
	}

	public Integer getProId() {
		return proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public BusinessAnnoScope(
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
	public void setAnnoId(java.lang.Integer value) {
		this.annoId = value;
	}
	
	public java.lang.Integer getAnnoId() {
		return this.annoId;
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
			.append("AnnoId",getAnnoId())
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
		if(obj instanceof BusinessAnnoScope == false) return false;
		if(this == obj) return true;
		BusinessAnnoScope other = (BusinessAnnoScope)obj;
		return new EqualsBuilder()
			.append(getScopeId(),other.getScopeId())
			.isEquals();
	}
}

