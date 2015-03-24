package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessFocusAd;

public class BusinessFocusAdQuery extends BaseBean {
	
	private java.lang.Integer focusAdId;
	private java.lang.String title;
	private java.lang.String content;
	private java.lang.String picUrl;
	private java.lang.Integer sourceType;
	private java.lang.Integer sourceId;
	private java.sql.Timestamp selectTime;
	private java.lang.Integer state;
	private java.lang.String pageUrl;
	private java.lang.Integer selectorId;
	private java.lang.String selectorName;
	private java.lang.Integer auditorId;
	private java.sql.Timestamp auditTime;
	private java.lang.String auditorName;
	private java.lang.String auditInfo;
	private java.lang.String startTime;
	private java.lang.String endTime;
	private java.lang.Integer visits;
	private java.lang.Integer supports;
	private Integer ishtml;
	private java.lang.String focusAdScope;
	private String focusAdScopeInfo;
	private String timeScope;
	private String startFocusTime;
	private String endFocusTime;
	private String orderBy;
	private String keyWord;
	private Integer curComId;
	private Integer curUserId;
	private Integer curEstateId;
	private String flag;
	private String scope;
	
	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getFocusAdScopeInfo() {
		return focusAdScopeInfo;
	}

	public void setFocusAdScopeInfo(String focusAdScopeInfo) {
		this.focusAdScopeInfo = focusAdScopeInfo;
	}

	public String getTimeScope() {
		return timeScope;
	}

	public void setTimeScope(String timeScope) {
		this.timeScope = timeScope;
	}

	public String getStartFocusTime() {
		return startFocusTime;
	}

	public void setStartFocusTime(String startFocusTime) {
		this.startFocusTime = startFocusTime;
	}

	public String getEndFocusTime() {
		return endFocusTime;
	}

	public void setEndFocusTime(String endFocusTime) {
		this.endFocusTime = endFocusTime;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public Integer getCurComId() {
		return curComId;
	}

	public void setCurComId(Integer curComId) {
		this.curComId = curComId;
	}

	public Integer getCurUserId() {
		return curUserId;
	}

	public void setCurUserId(Integer curUserId) {
		this.curUserId = curUserId;
	}

	public Integer getCurEstateId() {
		return curEstateId;
	}

	public void setCurEstateId(Integer curEstateId) {
		this.curEstateId = curEstateId;
	}
	
	public BusinessFocusAdQuery(BusinessFocusAd businessFocusAd) {
		this.focusAdId = businessFocusAd.getFocusAdId();
		this.title = businessFocusAd.getTitle();
		this.content = businessFocusAd.getContent();
		this.picUrl = businessFocusAd.getPicUrl();
		this.sourceType = businessFocusAd.getSourceType();
		this.sourceId = businessFocusAd.getSourceId();
		this.selectTime = businessFocusAd.getSelectTime();
		this.state = businessFocusAd.getState();
		this.pageUrl = businessFocusAd.getPageUrl();
		this.selectorId = businessFocusAd.getSelectorId();
		this.selectorName = businessFocusAd.getSelectorName();
		this.auditorId = businessFocusAd.getAuditorId();
		this.auditTime = businessFocusAd.getAuditTime();
		this.auditorName = businessFocusAd.getAuditorName();
		this.auditInfo = businessFocusAd.getAuditInfo();
		this.startTime = businessFocusAd.getStartTime();
		this.endTime = businessFocusAd.getEndTime();
		this.visits = businessFocusAd.getVisits();
		this.supports = businessFocusAd.getSupports();
		this.ishtml = businessFocusAd.getIshtml();
		this.focusAdScope = businessFocusAd.getFocusAdScope();
	}
	
	public BusinessFocusAdQuery() {
		
	}	
	
	public java.lang.Integer getFocusAdId() {
		return this.focusAdId;
	}
	
	public void setFocusAdId(java.lang.Integer value) {
		this.focusAdId = value;
	}
		
	public java.lang.String getTitle() {
		return this.title;
	}
	
	public void setTitle(java.lang.String value) {
		this.title = value;
	}
		
	public java.lang.String getContent() {
		return this.content;
	}
	
	public void setContent(java.lang.String value) {
		this.content = value;
	}
		
	public java.lang.String getPicUrl() {
		return this.picUrl;
	}
	
	public void setPicUrl(java.lang.String value) {
		this.picUrl = value;
	}
		
	public java.lang.Integer getSourceType() {
		return this.sourceType;
	}
	
	public void setSourceType(java.lang.Integer value) {
		this.sourceType = value;
	}
		
	public java.lang.Integer getSourceId() {
		return this.sourceId;
	}
	
	public void setSourceId(java.lang.Integer value) {
		this.sourceId = value;
	}
		
	public java.sql.Timestamp getSelectTime() {
		return this.selectTime;
	}
	
	public void setSelectTime(java.sql.Timestamp value) {
		this.selectTime = value;
	}
		
	public java.lang.Integer getState() {
		return this.state;
	}
	
	public void setState(java.lang.Integer value) {
		this.state = value;
	}
		
	public java.lang.String getPageUrl() {
		return this.pageUrl;
	}
	
	public void setPageUrl(java.lang.String value) {
		this.pageUrl = value;
	}
		
	public java.lang.Integer getSelectorId() {
		return this.selectorId;
	}
	
	public void setSelectorId(java.lang.Integer value) {
		this.selectorId = value;
	}
		
	public java.lang.String getSelectorName() {
		return this.selectorName;
	}
	
	public void setSelectorName(java.lang.String value) {
		this.selectorName = value;
	}
		
	public java.lang.Integer getAuditorId() {
		return this.auditorId;
	}
	
	public void setAuditorId(java.lang.Integer value) {
		this.auditorId = value;
	}
		
	public java.sql.Timestamp getAuditTime() {
		return this.auditTime;
	}
	
	public void setAuditTime(java.sql.Timestamp value) {
		this.auditTime = value;
	}
		
	public java.lang.String getAuditorName() {
		return this.auditorName;
	}
	
	public void setAuditorName(java.lang.String value) {
		this.auditorName = value;
	}
		
	public java.lang.String getAuditInfo() {
		return this.auditInfo;
	}
	
	public void setAuditInfo(java.lang.String value) {
		this.auditInfo = value;
	}
		
	public java.lang.String getStartTime() {
		return this.startTime;
	}
	
	public void setStartTime(java.lang.String value) {
		this.startTime = value;
	}
		
	public java.lang.String getEndTime() {
		return this.endTime;
	}
	
	public void setEndTime(java.lang.String value) {
		this.endTime = value;
	}
		
	public java.lang.Integer getVisits() {
		return this.visits;
	}
	
	public void setVisits(java.lang.Integer value) {
		this.visits = value;
	}
		
	public java.lang.Integer getSupports() {
		return this.supports;
	}
	
	public void setSupports(java.lang.Integer value) {
		this.supports = value;
	}
		
	public Integer getIshtml() {
		return this.ishtml;
	}
	
	public void setIshtml(Integer value) {
		this.ishtml = value;
	}
		
	public java.lang.String getFocusAdScope() {
		return this.focusAdScope;
	}
	
	public void setFocusAdScope(java.lang.String value) {
		this.focusAdScope = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
}