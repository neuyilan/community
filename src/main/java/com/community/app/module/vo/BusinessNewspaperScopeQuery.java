package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessNewspaperScope;

public class BusinessNewspaperScopeQuery extends BaseBean {

	private java.lang.Integer scopeId;
	private java.lang.Integer newspaperId;
	private java.lang.Integer comId;
	private java.lang.String comName;
	private java.sql.Timestamp createTime;

	public BusinessNewspaperScopeQuery(
			BusinessNewspaperScope businessNewspaperScope) {
		this.scopeId = businessNewspaperScope.getScopeId();
		this.newspaperId = businessNewspaperScope.getNewspaperId();
		this.comId = businessNewspaperScope.getComId();
		this.comName = businessNewspaperScope.getComName();
		this.createTime = businessNewspaperScope.getCreateTime();
	}

	public BusinessNewspaperScopeQuery() {

	}

	public java.lang.Integer getScopeId() {
		return this.scopeId;
	}

	public void setScopeId(java.lang.Integer value) {
		this.scopeId = value;
	}

	public java.lang.Integer getNewspaperId() {
		return this.newspaperId;
	}

	public void setNewspaperId(java.lang.Integer value) {
		this.newspaperId = value;
	}

	public java.lang.Integer getComId() {
		return this.comId;
	}

	public void setComId(java.lang.Integer value) {
		this.comId = value;
	}

	public java.lang.String getComName() {
		return this.comName;
	}

	public void setComName(java.lang.String value) {
		this.comName = value;
	}

	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}