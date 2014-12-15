package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessExpResolve;
import com.community.app.module.vo.BaseBean;

public class BusinessExpResolveQuery extends BaseBean {
	

	private java.lang.Integer resolveId;
	private java.lang.Integer expId;
	private java.lang.Integer resolverId;
	private java.lang.String resolverName;
	private java.sql.Timestamp resolveTime;
	private java.lang.Integer stateId;
	private java.lang.String state;
	private java.lang.String resolveMemo;

	public BusinessExpResolveQuery(BusinessExpResolve businessExpResolve) {
		this.resolveId = businessExpResolve.getResolveId();
		this.expId = businessExpResolve.getExpId();
		this.resolverId = businessExpResolve.getResolverId();
		this.resolverName = businessExpResolve.getResolverName();
		this.resolveTime = businessExpResolve.getResolveTime();
		this.stateId = businessExpResolve.getStateId();
		this.state = businessExpResolve.getState();
		this.resolveMemo = businessExpResolve.getResolveMemo();
	}
	
	public BusinessExpResolveQuery() {
		
	}	
	
	public java.lang.Integer getResolveId() {
		return this.resolveId;
	}
	
	public void setResolveId(java.lang.Integer value) {
		this.resolveId = value;
	}
		
	public java.lang.Integer getExpId() {
		return this.expId;
	}
	
	public void setExpId(java.lang.Integer value) {
		this.expId = value;
	}
		
	public java.lang.Integer getResolverId() {
		return this.resolverId;
	}
	
	public void setResolverId(java.lang.Integer value) {
		this.resolverId = value;
	}
		
	public java.lang.String getResolverName() {
		return this.resolverName;
	}
	
	public void setResolverName(java.lang.String value) {
		this.resolverName = value;
	}
		
	public java.sql.Timestamp getResolveTime() {
		return this.resolveTime;
	}
	
	public void setResolveTime(java.sql.Timestamp value) {
		this.resolveTime = value;
	}
		
	public java.lang.Integer getStateId() {
		return this.stateId;
	}
	
	public void setStateId(java.lang.Integer value) {
		this.stateId = value;
	}
		
	public java.lang.String getState() {
		return this.state;
	}
	
	public void setState(java.lang.String value) {
		this.state = value;
	}
		
	public java.lang.String getResolveMemo() {
		return this.resolveMemo;
	}
	
	public void setResolveMemo(java.lang.String value) {
		this.resolveMemo = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

