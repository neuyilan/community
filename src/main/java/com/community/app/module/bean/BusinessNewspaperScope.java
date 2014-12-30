package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessNewspaperScope implements java.io.Serializable {

	// 别名
	public static final String TABLE_ALIAS = "BusinessNewspaperScope";

	private java.lang.Integer scopeId;
	private java.lang.Integer newspaperId;
	private java.lang.Integer comId;
	private java.lang.String comName;
	private java.sql.Timestamp createTime;

	public BusinessNewspaperScope() {
	}

	public BusinessNewspaperScope(java.lang.Integer scopeId) {
		this.scopeId = scopeId;
	}

	public void setScopeId(java.lang.Integer value) {
		this.scopeId = value;
	}

	public java.lang.Integer getScopeId() {
		return this.scopeId;
	}

	public void setNewspaperId(java.lang.Integer value) {
		this.newspaperId = value;
	}

	public java.lang.Integer getNewspaperId() {
		return this.newspaperId;
	}

	public void setComId(java.lang.Integer value) {
		this.comId = value;
	}

	public java.lang.Integer getComId() {
		return this.comId;
	}

	public void setComName(java.lang.String value) {
		this.comName = value;
	}

	public java.lang.String getComName() {
		return this.comName;
	}

	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}

	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("ScopeId", getScopeId())
				.append("NewspaperId", getNewspaperId())
				.append("ComId", getComId()).append("ComName", getComName())
				.append("CreateTime", getCreateTime()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getScopeId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof BusinessNewspaperScope == false)
			return false;
		if (this == obj)
			return true;
		BusinessNewspaperScope other = (BusinessNewspaperScope) obj;
		return new EqualsBuilder().append(getScopeId(), other.getScopeId())
				.isEquals();
	}
}