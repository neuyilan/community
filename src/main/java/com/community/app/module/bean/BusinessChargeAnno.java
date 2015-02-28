package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessChargeAnno implements java.io.Serializable {

	// 别名
	public static final String TABLE_ALIAS = "BusinessChargeAnno";

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
	private String auditInfo;

	private Integer estateId;
	private String estateName;

	public String getAuditInfo() {
		return auditInfo == null?"":auditInfo;
	}

	public void setAuditInfo(String auditInfo) {
		this.auditInfo = auditInfo;
	}

	public Integer getEstateId() {
		return estateId;
	}

	public void setEstateId(Integer estateId) {
		this.estateId = estateId;
	}

	public String getEstateName() {
		return estateName == null?"":estateName;
	}

	public void setEstateName(String estateName) {
		this.estateName = estateName;
	}

	public BusinessChargeAnno() {
	}

	public BusinessChargeAnno(java.lang.Integer reportId) {
		this.reportId = reportId;
	}

	public void setReportId(java.lang.Integer value) {
		this.reportId = value;
	}

	public java.lang.Integer getReportId() {
		return this.reportId;
	}

	public void setReportName(java.lang.String value) {
		this.reportName = value;
	}

	public java.lang.String getReportName() {
		return this.reportName == null?"":this.reportName;
	}

	public void setReportDesc(java.lang.String value) {
		this.reportDesc = value;
	}

	public java.lang.String getReportDesc() {
		return this.reportDesc == null?"":this.reportDesc;
	}

	public void setReportExcel(java.lang.String value) {
		this.reportExcel = value;
	}

	public java.lang.String getReportExcel() {
		return this.reportExcel == null?"":this.reportExcel;
	}

	public void setPublisherId(java.lang.Integer value) {
		this.publisherId = value;
	}

	public java.lang.Integer getPublisherId() {
		return this.publisherId;
	}

	public void setPublisherName(java.lang.String value) {
		this.publisherName = value;
	}

	public java.lang.String getPublisherName() {
		return this.publisherName == null?"":this.publisherName;
	}

	public void setPublisherState(Integer value) {
		this.publisherState = value;
	}

	public Integer getPublisherState() {
		return this.publisherState;
	}

	public void setPublishTime(java.sql.Timestamp value) {
		this.publishTime = value;
	}

	public java.sql.Timestamp getPublishTime() {
		return this.publishTime;
	}

	public void setAuditorId(java.lang.Integer value) {
		this.auditorId = value;
	}

	public java.lang.Integer getAuditorId() {
		return this.auditorId;
	}

	public void setAuditorName(java.lang.String value) {
		this.auditorName = value;
	}

	public java.lang.String getAuditorName() {
		return this.auditorName == null?"":this.auditorName;
	}

	public void setAuditTime(java.sql.Timestamp value) {
		this.auditTime = value;
	}

	public java.sql.Timestamp getAuditTime() {
		return this.auditTime;
	}

	public void setUsers(java.lang.Integer value) {
		this.users = value;
	}

	public java.lang.Integer getUsers() {
		return this.users != null? this.users:0;
	}

	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}

	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setEditTime(java.sql.Timestamp value) {
		this.editTime = value;
	}

	public java.sql.Timestamp getEditTime() {
		return this.editTime;
	}

	public void setEditor(java.lang.String value) {
		this.editor = value;
	}

	public java.lang.String getEditor() {
		return this.editor == null?"":this.editor;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("ReportId", getReportId())
				.append("ReportName", getReportName())
				.append("ReportDesc", getReportDesc())
				.append("ReportExcel", getReportExcel())
				.append("PublisherId", getPublisherId())
				.append("PublisherName", getPublisherName())
				.append("PublisherState", getPublisherState())
				.append("PublishTime", getPublishTime())
				.append("AuditorId", getAuditorId())
				.append("AuditorName", getAuditorName())
				.append("AuditTime", getAuditTime())
				.append("Users", getUsers())
				.append("CreateTime", getCreateTime())
				.append("EditTime", getEditTime())
				.append("Editor", getEditor()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getReportId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof BusinessChargeAnno == false)
			return false;
		if (this == obj)
			return true;
		BusinessChargeAnno other = (BusinessChargeAnno) obj;
		return new EqualsBuilder().append(getReportId(), other.getReportId()).isEquals();
	}
}