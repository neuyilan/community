package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessAnnoScope;
import com.community.app.module.vo.BaseBean;

public class BusinessAnnoScopeQuery extends BaseBean {
	

	private java.lang.Integer scopeId;
	private java.lang.Integer annoId;
	private java.lang.Integer estateId;
	private java.lang.String estateName;
	private java.sql.Timestamp createTime;
	private Integer proId;
	private Integer scopeType;

	public BusinessAnnoScopeQuery(BusinessAnnoScope businessAnnoScope) {
		this.scopeId = businessAnnoScope.getScopeId();
		this.annoId = businessAnnoScope.getAnnoId();
		this.estateId = businessAnnoScope.getEstateId();
		this.estateName = businessAnnoScope.getEstateName();
		this.createTime = businessAnnoScope.getCreateTime();
		this.proId = businessAnnoScope.getProId();
		this.scopeType = businessAnnoScope.getScopeType();
	}
	
	public BusinessAnnoScopeQuery() {
		
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

	public java.lang.Integer getScopeId() {
		return this.scopeId;
	}
	
	public void setScopeId(java.lang.Integer value) {
		this.scopeId = value;
	}
		
	public java.lang.Integer getAnnoId() {
		return this.annoId;
	}
	
	public void setAnnoId(java.lang.Integer value) {
		this.annoId = value;
	}
		
	public java.lang.Integer getEstateId() {
		return this.estateId;
	}
	
	public void setEstateId(java.lang.Integer value) {
		this.estateId = value;
	}
		
	public java.lang.String getEstateName() {
		return this.estateName;
	}
	
	public void setEstateName(java.lang.String value) {
		this.estateName = value;
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

