package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class AppHomepageScope implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "AppHomepageScope";

	private java.lang.Integer scopeId;
	private java.lang.Integer homePageId;
	private Integer id;
	private java.sql.Timestamp createTime;
	
	public java.lang.Integer getScopeId() {
		return scopeId;
	}

	public void setScopeId(java.lang.Integer scopeId) {
		this.scopeId = scopeId;
	}

	public java.lang.Integer getHomePageId() {
		return homePageId;
	}

	public void setHomePageId(java.lang.Integer homePageId) {
		this.homePageId = homePageId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("scopeId",getScopeId())
			.append("Id",getId())
			.append("homePageId",getHomePageId())
			.append("createTime",getCreateTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder().append(getScopeId()).toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AppHomepageScope == false) return false;
		if(this == obj) return true;
		AppHomepageScope other = (AppHomepageScope)obj;
		return new EqualsBuilder().append(getScopeId(),other.getScopeId()).isEquals();
	}
}