package com.community.app.module.vo;

import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessNewsScope;

public class BusinessNewsScopeQuery extends BaseBean {
	

	private java.lang.Integer scopeId;
	private java.lang.Integer newsId;
	private java.lang.Integer comId;
	private java.lang.String comName;
	private java.sql.Timestamp createTime;

	private Map fieldMap;
	
	public BusinessNewsScopeQuery(BusinessNewsScope businessNewsScope) {
		this.scopeId = businessNewsScope.getScopeId();
		this.newsId = businessNewsScope.getNewsId();
		this.comId = businessNewsScope.getComId();
		this.comName = businessNewsScope.getComName();
		this.createTime = businessNewsScope.getCreateTime();
	}
	
	public BusinessNewsScopeQuery() {
		
	}	
	
	public java.lang.Integer getScopeId() {
		return this.scopeId;
	}
	
	public void setScopeId(java.lang.Integer value) {
		this.scopeId = value;
	}
		
	public java.lang.Integer getNewsId() {
		return this.newsId;
	}
	
	public void setNewsId(java.lang.Integer value) {
		this.newsId = value;
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
		
	
	public Map getFieldMap() {
		return this.fieldMap;
	}
	
	public void setFieldMap(Map fieldMap) {
		this.fieldMap = fieldMap;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

