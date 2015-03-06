package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class BusinessFocusAd implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7027558752928853047L;

	//别名
	public static final String TABLE_ALIAS = "BusinessFocusAd";

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

	public BusinessFocusAd(){
	}

	public BusinessFocusAd(
		java.lang.Integer focusAdId
	){
		this.focusAdId = focusAdId;
	}

	public void setFocusAdId(java.lang.Integer value) {
		this.focusAdId = value;
	}
	
	public java.lang.Integer getFocusAdId() {
		return this.focusAdId;
	}
	public void setTitle(java.lang.String value) {
		this.title = value;
	}
	
	public java.lang.String getTitle() {
		return this.title == null?"":this.title;
	}
	public void setContent(java.lang.String value) {
		this.content = value;
	}
	
	public java.lang.String getContent() {
		return this.content == null?"":this.content;
	}
	public void setPicUrl(java.lang.String value) {
		this.picUrl = value;
	}
	
	public java.lang.String getPicUrl() {
		return this.picUrl == null?"":this.picUrl;
	}
	public void setSourceType(java.lang.Integer value) {
		this.sourceType = value;
	}
	
	public java.lang.Integer getSourceType() {
		return this.sourceType;
	}
	public void setSourceId(java.lang.Integer value) {
		this.sourceId = value;
	}
	
	public java.lang.Integer getSourceId() {
		return this.sourceId;
	}
	public void setSelectTime(java.sql.Timestamp value) {
		this.selectTime = value;
	}
	
	public java.sql.Timestamp getSelectTime() {
		return this.selectTime;
	}
	public void setState(java.lang.Integer value) {
		this.state = value;
	}
	
	public java.lang.Integer getState() {
		return this.state;
	}
	public void setPageUrl(java.lang.String value) {
		this.pageUrl = value;
	}
	
	public java.lang.String getPageUrl() {
		return this.pageUrl == null?"":this.pageUrl;
	}
	public void setSelectorId(java.lang.Integer value) {
		this.selectorId = value;
	}
	
	public java.lang.Integer getSelectorId() {
		return this.selectorId;
	}
	public void setSelectorName(java.lang.String value) {
		this.selectorName = value;
	}
	
	public java.lang.String getSelectorName() {
		return this.selectorName == null?"":this.selectorName;
	}
	public void setAuditorId(java.lang.Integer value) {
		this.auditorId = value;
	}
	
	public java.lang.Integer getAuditorId() {
		return this.auditorId;
	}
	public void setAuditTime(java.sql.Timestamp value) {
		this.auditTime = value;
	}
	
	public java.sql.Timestamp getAuditTime() {
		return this.auditTime;
	}
	public void setAuditorName(java.lang.String value) {
		this.auditorName = value;
	}
	
	public java.lang.String getAuditorName() {
		return this.auditorName;
	}
	public void setAuditInfo(java.lang.String value) {
		this.auditInfo = value;
	}
	
	public java.lang.String getAuditInfo() {
		return this.auditInfo == null?"":this.auditInfo;
	}
	public void setStartTime(java.lang.String value) {
		this.startTime = value;
	}
	
	public java.lang.String getStartTime() {
		return this.startTime;
	}
	public void setEndTime(java.lang.String value) {
		this.endTime = value;
	}
	
	public java.lang.String getEndTime() {
		return this.endTime;
	}
	public void setVisits(java.lang.Integer value) {
		this.visits = value;
	}
	
	public java.lang.Integer getVisits() {
		return this.visits;
	}
	public void setSupports(java.lang.Integer value) {
		this.supports = value;
	}
	
	public java.lang.Integer getSupports() {
		return this.supports;
	}
	public void setIshtml(Integer value) {
		this.ishtml = value;
	}
	
	public Integer getIshtml() {
		return this.ishtml;
	}
	public void setFocusAdScope(java.lang.String value) {
		this.focusAdScope = value;
	}
	
	public java.lang.String getFocusAdScope() {
		return this.focusAdScope == null?"":this.focusAdScope;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("FocusAdId",getFocusAdId())
			.append("Title",getTitle())
			.append("Content",getContent())
			.append("PicUrl",getPicUrl())
			.append("SourceType",getSourceType())
			.append("SourceId",getSourceId())
			.append("SelectTime",getSelectTime())
			.append("State",getState())
			.append("PageUrl",getPageUrl())
			.append("SelectorId",getSelectorId())
			.append("SelectorName",getSelectorName())
			.append("AuditorId",getAuditorId())
			.append("AuditTime",getAuditTime())
			.append("AuditorName",getAuditorName())
			.append("AuditInfo",getAuditInfo())
			.append("StartTime",getStartTime())
			.append("EndTime",getEndTime())
			.append("Visits",getVisits())
			.append("Supports",getSupports())
			.append("Ishtml",getIshtml())
			.append("FocusAdScope",getFocusAdScope())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getFocusAdId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessFocusAd == false) return false;
		if(this == obj) return true;
		BusinessFocusAd other = (BusinessFocusAd)obj;
		return new EqualsBuilder()
			.append(getFocusAdId(),other.getFocusAdId())
			.isEquals();
	}
}