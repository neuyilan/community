package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class BusinessExpResolve implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessExpResolve";

	private java.lang.Integer resolveId=0;
	private java.lang.Integer expId=0;
	private java.lang.Integer resolverId=0;
	private java.lang.String resolverName="";
	private java.sql.Timestamp resolveTime;
	private java.lang.Integer stateId=0;
	private java.lang.String state="";
	private java.lang.String resolveMemo="";
	private java.lang.String avatar="";
	private java.lang.Integer type=0;
	private java.lang.String videoTime="";
	
	public java.lang.Integer getType() {
		return type;
	}

	public void setType(java.lang.Integer type) {
		this.type = type;
	}

	public java.lang.String getVideoTime() {
		return videoTime;
	}

	public void setVideoTime(java.lang.String videoTime) {
		this.videoTime = videoTime;
	}

	public java.lang.String getAvatar() {
		return avatar;
	}

	public void setAvatar(java.lang.String avatar) {
		this.avatar = avatar;
	}

	public BusinessExpResolve(){
	}

	public BusinessExpResolve(
		java.lang.Integer resolveId
	){
		this.resolveId = resolveId;
	}

	public void setResolveId(java.lang.Integer value) {
		this.resolveId = value;
	}
	
	public java.lang.Integer getResolveId() {
		return this.resolveId;
	}
	public void setExpId(java.lang.Integer value) {
		this.expId = value;
	}
	
	public java.lang.Integer getExpId() {
		return this.expId;
	}
	public void setResolverId(java.lang.Integer value) {
		this.resolverId = value;
	}
	
	public java.lang.Integer getResolverId() {
		return this.resolverId;
	}
	public void setResolverName(java.lang.String value) {
		this.resolverName = value;
	}
	
	public java.lang.String getResolverName() {
		return this.resolverName;
	}
	public void setResolveTime(java.sql.Timestamp value) {
		this.resolveTime = value;
	}
	
	public java.sql.Timestamp getResolveTime() {
		return this.resolveTime;
	}
	public void setStateId(java.lang.Integer value) {
		this.stateId = value;
	}
	
	public java.lang.Integer getStateId() {
		return this.stateId;
	}
	public void setState(java.lang.String value) {
		this.state = value;
	}
	
	public java.lang.String getState() {
		return this.state;
	}
	public void setResolveMemo(java.lang.String value) {
		this.resolveMemo = value;
	}
	
	public java.lang.String getResolveMemo() {
		return this.resolveMemo;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("ResolveId",getResolveId())
			.append("ExpId",getExpId())
			.append("ResolverId",getResolverId())
			.append("ResolverName",getResolverName())
			.append("ResolveTime",getResolveTime())
			.append("StateId",getStateId())
			.append("State",getState())
			.append("ResolveMemo",getResolveMemo())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getResolveId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessExpResolve == false) return false;
		if(this == obj) return true;
		BusinessExpResolve other = (BusinessExpResolve)obj;
		return new EqualsBuilder()
			.append(getResolveId(),other.getResolveId())
			.isEquals();
	}
}

