package com.community.app.module.vo;

import com.community.app.module.bean.AppHomepageScope;

public class AppHomepageScopeQuery extends BaseBean {
	
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

	public AppHomepageScopeQuery(AppHomepageScope appHomepageScope) {
		this.scopeId = appHomepageScope.getScopeId();
		this.id = appHomepageScope.getId();
		this.homePageId = appHomepageScope.getHomePageId();
		this.createTime = appHomepageScope.getCreateTime();
	}
	
	public AppHomepageScopeQuery() { }	
}