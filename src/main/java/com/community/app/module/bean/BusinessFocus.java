package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessFocus implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessFocus";

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
	private Integer ishtml;
	private String focusScope;
	private String auditInfo;
	
	public String getAuditInfo() {
		return auditInfo  == null?"":auditInfo;
	}

	public void setAuditInfo(String auditInfo) {
		this.auditInfo = auditInfo;
	}

	public String getFocusScope() {
		return focusScope  == null?"":focusScope;
	}

	public void setFocusScope(String focusScope) {
		this.focusScope = focusScope;
	}

	public Integer getIshtml() {
		return ishtml;
	}

	public void setIshtml(Integer ishtml) {
		this.ishtml = ishtml;
	}

	public BusinessFocus(){
	}

	public BusinessFocus(
		Integer focusId
	){
		this.focusId = focusId;
	}

	public void setFocusId(Integer value) {
		this.focusId = value;
	}
	
	public Integer getFocusId() {
		return this.focusId;
	}
	public void setTitle(String value) {
		this.title = value;
	}
	
	public String getTitle() {
		return this.title == null?"":this.title;
	}
	public void setContent(String value) {
		this.content = value;
	}
	
	public String getContent() {
		return this.content == null?"":this.content;
	}
	public void setPicUrl(String value) {
		this.picUrl = value;
	}
	
	public String getPicUrl() {
		return this.picUrl == null?"":this.picUrl;
	}
	public void setSourceType(Integer value) {
		this.sourceType = value;
	}
	
	public Integer getSourceType() {
		return this.sourceType;
	}
	public void setSourceId(Integer value) {
		this.sourceId = value;
	}
	
	public Integer getSourceId() {
		return this.sourceId;
	}
	public void setSelectTime(java.sql.Timestamp value) {
		this.selectTime = value;
	}
	
	public java.sql.Timestamp getSelectTime() {
		return this.selectTime;
	}
	public void setState(Integer value) {
		this.state = value;
	}
	
	public Integer getState() {
		return this.state;
	}
	public void setPageUrl(String value) {
		this.pageUrl = value;
	}
	
	public String getPageUrl() {
		return this.pageUrl == null?"":this.pageUrl;
	}
	public void setSelectorId(Integer value) {
		this.selectorId = value;
	}
	
	public Integer getSelectorId() {
		return this.selectorId;
	}
	public void setSelectorName(String value) {
		this.selectorName = value;
	}
	
	public String getSelectorName() {
		return this.selectorName == null?"":this.selectorName;
	}
	public void setAuditorId(Integer value) {
		this.auditorId = value;
	}
	
	public Integer getAuditorId() {
		return this.auditorId;
	}
	public void setAuditTime(java.sql.Timestamp value) {
		this.auditTime = value;
	}
	
	public java.sql.Timestamp getAuditTime() {
		return this.auditTime;
	}
	public void setAuditorName(String value) {
		this.auditorName = value;
	}
	
	public String getAuditorName() {
		return this.auditorName == null?"":this.auditorName;
	}
	public void setStartTime(String value) {
		this.startTime = value;
	}
	
	public String getStartTime() {
		return this.startTime;
	}
	public void setEndTime(String value) {
		this.endTime = value;
	}
	
	public String getEndTime() {
		return this.endTime;
	}
	public void setVisits(Integer value) {
		this.visits = value;
	}
	
	public Integer getVisits() {
		return this.visits;
	}
	public void setSupports(Integer value) {
		this.supports = value;
	}
	
	public Integer getSupports() {
		return this.supports;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("FocusId",getFocusId())
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
			.append("StartTime",getStartTime())
			.append("EndTime",getEndTime())
			.append("Visits",getVisits())
			.append("Supports",getSupports())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getFocusId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessFocus == false) return false;
		if(this == obj) return true;
		BusinessFocus other = (BusinessFocus)obj;
		return new EqualsBuilder()
			.append(getFocusId(),other.getFocusId())
			.isEquals();
	}
}