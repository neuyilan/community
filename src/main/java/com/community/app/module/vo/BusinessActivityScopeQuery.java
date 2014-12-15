package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessActivityScope;
import com.community.app.module.vo.BaseBean;

public class BusinessActivityScopeQuery extends BaseBean {
	

	private java.lang.Integer scopeId;
	private java.lang.Integer actId;
	private java.lang.Integer estateId;
	private java.lang.String estateName;
	private java.sql.Timestamp createTime;

	public BusinessActivityScopeQuery(BusinessActivityScope businessActivityScope) {
		this.scopeId = businessActivityScope.getScopeId();
		this.actId = businessActivityScope.getActId();
		this.estateId = businessActivityScope.getEstateId();
		this.estateName = businessActivityScope.getEstateName();
		this.createTime = businessActivityScope.getCreateTime();
	}
	
	public BusinessActivityScopeQuery() {
		
	}	
	
	public java.lang.Integer getScopeId() {
		return this.scopeId;
	}
	
	public void setScopeId(java.lang.Integer value) {
		this.scopeId = value;
	}
		
	public java.lang.Integer getActId() {
		return this.actId;
	}
	
	public void setActId(java.lang.Integer value) {
		this.actId = value;
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

