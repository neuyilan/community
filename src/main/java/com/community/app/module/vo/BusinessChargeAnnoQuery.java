package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessChargeAnno;

public class BusinessChargeAnnoQuery extends BaseBean {
	
	private java.lang.Integer reportId;
	private java.lang.String reportName;
	private java.lang.String reportDesc;
	private java.lang.String reportExcel;
	private java.lang.Integer publisherId;
	private java.lang.String publisherName;
	private Integer publisherState;
	private java.sql.Timestamp publishTime;
	private java.lang.Integer auditorId;
	private java.lang.String auditorName;
	private java.sql.Timestamp auditTime;
	private java.lang.Integer users;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	private String timeScope;
	private String startTime;
	private String endTime;
	private String orderBy;
	private String keyWord;
	
	private Integer estateId;
	private String estateName;
	
	private Integer curUserId;
	private Integer curEstateId;
	private String auditInfo;

	public BusinessChargeAnnoQuery(BusinessChargeAnno businessChargeAnno) {
		this.reportId = businessChargeAnno.getReportId();
		this.reportName = businessChargeAnno.getReportName();
		this.reportDesc = businessChargeAnno.getReportDesc();
		this.reportExcel = businessChargeAnno.getReportExcel();
		this.publisherId = businessChargeAnno.getPublisherId();
		this.publisherName = businessChargeAnno.getPublisherName();
		this.publisherState = businessChargeAnno.getPublisherState();
		this.publishTime = businessChargeAnno.getPublishTime();
		this.auditorId = businessChargeAnno.getAuditorId();
		this.auditorName = businessChargeAnno.getAuditorName();
		this.auditTime = businessChargeAnno.getAuditTime();
		this.users = businessChargeAnno.getUsers();
		this.createTime = businessChargeAnno.getCreateTime();
		this.editTime = businessChargeAnno.getEditTime();
		this.editor = businessChargeAnno.getEditor();
		this.estateId = businessChargeAnno.getEstateId();
		this.estateName = businessChargeAnno.getEstateName();
		this.auditInfo = businessChargeAnno.getAuditInfo();
	}
	
	public BusinessChargeAnnoQuery() {
		
	}	
	
	public String getAuditInfo() {
		return auditInfo;
	}

	public void setAuditInfo(String auditInfo) {
		this.auditInfo = auditInfo;
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

	public Integer getEstateId() {
		return estateId;
	}

	public void setEstateId(Integer estateId) {
		this.estateId = estateId;
	}

	public String getEstateName() {
		return estateName;
	}

	public void setEstateName(String estateName) {
		this.estateName = estateName;
	}

	public java.lang.Integer getReportId() {
		return this.reportId;
	}
	
	public void setReportId(java.lang.Integer value) {
		this.reportId = value;
	}
		
	public java.lang.String getReportName() {
		return this.reportName;
	}
	
	public void setReportName(java.lang.String value) {
		this.reportName = value;
	}
		
	public java.lang.String getReportDesc() {
		return this.reportDesc;
	}
	
	public void setReportDesc(java.lang.String value) {
		this.reportDesc = value;
	}
		
	public java.lang.String getReportExcel() {
		return this.reportExcel;
	}
	
	public void setReportExcel(java.lang.String value) {
		this.reportExcel = value;
	}
		
	public java.lang.Integer getPublisherId() {
		return this.publisherId;
	}
	
	public void setPublisherId(java.lang.Integer value) {
		this.publisherId = value;
	}
		
	public java.lang.String getPublisherName() {
		return this.publisherName;
	}
	
	public void setPublisherName(java.lang.String value) {
		this.publisherName = value;
	}
		
	public Integer getPublisherState() {
		return this.publisherState;
	}
	
	public void setPublisherState(Integer value) {
		this.publisherState = value;
	}
		
	public java.sql.Timestamp getPublishTime() {
		return this.publishTime;
	}
	
	public void setPublishTime(java.sql.Timestamp value) {
		this.publishTime = value;
	}
		
	public java.lang.Integer getAuditorId() {
		return this.auditorId;
	}
	
	public void setAuditorId(java.lang.Integer value) {
		this.auditorId = value;
	}
		
	public java.lang.String getAuditorName() {
		return this.auditorName;
	}
	
	public void setAuditorName(java.lang.String value) {
		this.auditorName = value;
	}
		
	public java.sql.Timestamp getAuditTime() {
		return this.auditTime;
	}
	
	public void setAuditTime(java.sql.Timestamp value) {
		this.auditTime = value;
	}
		
	public java.lang.Integer getUsers() {
		return this.users;
	}
	
	public void setUsers(java.lang.Integer value) {
		this.users = value;
	}
		
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
		
	public java.sql.Timestamp getEditTime() {
		return this.editTime;
	}
	
	public void setEditTime(java.sql.Timestamp value) {
		this.editTime = value;
	}
		
	public java.lang.String getEditor() {
		return this.editor;
	}
	
	public void setEditor(java.lang.String value) {
		this.editor = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}

	public String getTimeScope() {
		return timeScope;
	}

	public void setTimeScope(String timeScope) {
		this.timeScope = timeScope;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
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
}