package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessFocus;

public class BusinessFocusQuery extends BaseBean {
	
	private Integer focusId;
	private String title;
	private String content;
	private String picUrl;
	private Integer sourceType;
	private Integer sourceId;
	private java.sql.Timestamp selectTime;
	private Integer state;
	private String pageUrl;
	private Integer selectorId;
	private String selectorName;
	private Integer auditorId;
	private java.sql.Timestamp auditTime;
	private String auditorName;
	private String startTime;
	private String endTime;
	private Integer visits;
	private Integer supports;
	private String focusScope;
	private String focusScopeInfo;
	private String auditInfo;

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

	public Integer getCurEstateId() {
		return curEstateId;
	}

	public void setCurEstateId(Integer curEstateId) {
		this.curEstateId = curEstateId;
	}

	public BusinessFocusQuery(BusinessFocus businessFocus) {
		this.focusId = businessFocus.getFocusId();
		this.title = businessFocus.getTitle();
		this.content = businessFocus.getContent();
		this.picUrl = businessFocus.getPicUrl();
		this.sourceType = businessFocus.getSourceType();
		this.sourceId = businessFocus.getSourceId();
		this.selectTime = businessFocus.getSelectTime();
		this.state = businessFocus.getState();
		this.pageUrl = businessFocus.getPageUrl();
		this.selectorId = businessFocus.getSelectorId();
		this.selectorName = businessFocus.getSelectorName();
		this.auditorId = businessFocus.getAuditorId();
		this.auditTime = businessFocus.getAuditTime();
		this.auditorName = businessFocus.getAuditorName();
		this.startTime = businessFocus.getStartTime();
		this.endTime = businessFocus.getEndTime();
		this.visits = businessFocus.getVisits();
		this.supports = businessFocus.getSupports();
		this.focusScope = businessFocus.getFocusScope();
		this.auditInfo = businessFocus.getAuditInfo();
	}
	
	public BusinessFocusQuery() {  }	
	
	public Integer getCurUserId() {
		return curUserId;
	}

	public void setCurUserId(Integer curUserId) {
		this.curUserId = curUserId;
	}

	public Integer getCurComId() {
		return curComId;
	}

	public void setCurComId(Integer curComId) {
		this.curComId = curComId;
	}

	public String getAuditInfo() {
		return auditInfo;
	}

	public void setAuditInfo(String auditInfo) {
		this.auditInfo = auditInfo;
	}
	
	public String getFocusScopeInfo() {
		return focusScopeInfo;
	}

	public void setFocusScopeInfo(String focusScopeInfo) {
		this.focusScopeInfo = focusScopeInfo;
	}
	
	public String getFocusScope() {
		return focusScope;
	}

	public void setFocusScope(String focusScope) {
		this.focusScope = focusScope;
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

	public String getTimeScope() {
		return timeScope;
	}

	public void setTimeScope(String timeScope) {
		this.timeScope = timeScope;
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

	public Integer getFocusId() {
		return this.focusId;
	}
	
	public void setFocusId(Integer value) {
		this.focusId = value;
	}
		
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String value) {
		this.title = value;
	}
		
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String value) {
		this.content = value;
	}
		
	public String getPicUrl() {
		return this.picUrl;
	}
	
	public void setPicUrl(String value) {
		this.picUrl = value;
	}
		
	public Integer getSourceType() {
		return this.sourceType;
	}
	
	public void setSourceType(Integer value) {
		this.sourceType = value;
	}
		
	public Integer getSourceId() {
		return this.sourceId;
	}
	
	public void setSourceId(Integer value) {
		this.sourceId = value;
	}
		
	public java.sql.Timestamp getSelectTime() {
		return this.selectTime;
	}
	
	public void setSelectTime(java.sql.Timestamp value) {
		this.selectTime = value;
	}
		
	public Integer getState() {
		return this.state;
	}
	
	public void setState(Integer value) {
		this.state = value;
	}
		
	public String getPageUrl() {
		return this.pageUrl;
	}
	
	public void setPageUrl(String value) {
		this.pageUrl = value;
	}
		
	public Integer getSelectorId() {
		return this.selectorId;
	}
	
	public void setSelectorId(Integer value) {
		this.selectorId = value;
	}
		
	public String getSelectorName() {
		return this.selectorName;
	}
	
	public void setSelectorName(String value) {
		this.selectorName = value;
	}
		
	public Integer getAuditorId() {
		return this.auditorId;
	}
	
	public void setAuditorId(Integer value) {
		this.auditorId = value;
	}
		
	public java.sql.Timestamp getAuditTime() {
		return this.auditTime;
	}
	
	public void setAuditTime(java.sql.Timestamp value) {
		this.auditTime = value;
	}
		
	public String getAuditorName() {
		return this.auditorName;
	}
	
	public void setAuditorName(String value) {
		this.auditorName = value;
	}
		
	public String getStartTime() {
		return this.startTime;
	}
	
	public void setStartTime(String value) {
		this.startTime = value;
	}
		
	public String getEndTime() {
		return this.endTime;
	}
	
	public void setEndTime(String value) {
		this.endTime = value;
	}
		
	public Integer getVisits() {
		return this.visits;
	}
	
	public void setVisits(Integer value) {
		this.visits = value;
	}
		
	public Integer getSupports() {
		return this.supports;
	}
	
	public void setSupports(Integer value) {
		this.supports = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}