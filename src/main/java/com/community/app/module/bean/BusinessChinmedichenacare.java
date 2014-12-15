package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessChinmedichenacare implements java.io.Serializable {

	// 别名
	public static final String TABLE_ALIAS = "BusinessChinmedichenacare";

	private java.lang.Integer cmhcId;
	private java.lang.String cmhcTitle;
	private java.lang.String cmhcContent;
	private java.lang.String cmhcPic;
	private java.lang.String appPic;
	private java.lang.Integer publisherId;
	private java.lang.String publisherName;
	private java.sql.Timestamp publishTime;
	private Integer publishState;
	private java.lang.Integer auditorId;
	private java.lang.String auditorName;
	private java.sql.Timestamp auditTime;
	private java.lang.Integer visits;
	private java.lang.Integer supports;
	private java.lang.Integer comments;
	private java.lang.String delMemo;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.String brief;
	private java.lang.Integer isRecommend;
	private java.lang.String label;
	private String auditInfo;
	private String doctorName;
	private String avatar;
	private String doctorBrief;

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getDoctorBrief() {
		return doctorBrief;
	}

	public void setDoctorBrief(String doctorBrief) {
		this.doctorBrief = doctorBrief;
	}

	public BusinessChinmedichenacare() {
	}

	public String getAuditInfo() {
		return auditInfo;
	}

	public void setAuditInfo(String auditInfo) {
		this.auditInfo = auditInfo;
	}

	public BusinessChinmedichenacare(java.lang.Integer cmhcId) {
		this.cmhcId = cmhcId;
	}

	public void setCmhcId(java.lang.Integer value) {
		this.cmhcId = value;
	}

	public java.lang.Integer getCmhcId() {
		return this.cmhcId;
	}

	public void setCmhcTitle(java.lang.String value) {
		this.cmhcTitle = value;
	}

	public java.lang.String getCmhcTitle() {
		return this.cmhcTitle;
	}

	public void setCmhcContent(java.lang.String value) {
		this.cmhcContent = value;
	}

	public java.lang.String getCmhcContent() {
		return this.cmhcContent;
	}

	public void setCmhcPic(java.lang.String value) {
		this.cmhcPic = value;
	}

	public java.lang.String getCmhcPic() {
		return this.cmhcPic;
	}

	public void setAppPic(java.lang.String value) {
		this.appPic = value;
	}

	public java.lang.String getAppPic() {
		return this.appPic;
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
		return this.publisherName;
	}

	public void setPublishTime(java.sql.Timestamp value) {
		this.publishTime = value;
	}

	public java.sql.Timestamp getPublishTime() {
		return this.publishTime;
	}

	public void setPublishState(Integer value) {
		this.publishState = value;
	}

	public Integer getPublishState() {
		return this.publishState;
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
		return this.auditorName;
	}

	public void setAuditTime(java.sql.Timestamp value) {
		this.auditTime = value;
	}

	public java.sql.Timestamp getAuditTime() {
		return this.auditTime;
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

	public void setComments(java.lang.Integer value) {
		this.comments = value;
	}

	public java.lang.Integer getComments() {
		return this.comments;
	}

	public void setDelMemo(java.lang.String value) {
		this.delMemo = value;
	}

	public java.lang.String getDelMemo() {
		return this.delMemo;
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
		return this.editor;
	}

	public void setBrief(java.lang.String value) {
		this.brief = value;
	}

	public java.lang.String getBrief() {
		return this.brief;
	}

	public void setIsRecommend(java.lang.Integer value) {
		this.isRecommend = value;
	}

	public java.lang.Integer getIsRecommend() {
		return this.isRecommend;
	}

	public void setLabel(java.lang.String value) {
		this.label = value;
	}

	public java.lang.String getLabel() {
		return this.label;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
			.append("CmhcId", getCmhcId())
			.append("CmhcTitle", getCmhcTitle())
			.append("CmhcContent", getCmhcContent())
			.append("CmhcPic", getCmhcPic()).append("AppPic", getAppPic())
			.append("PublisherId", getPublisherId())
			.append("PublisherName", getPublisherName())
			.append("PublishTime", getPublishTime())
			.append("PublishState", getPublishState())
			.append("AuditorId", getAuditorId())
			.append("AuditorName", getAuditorName())
			.append("AuditTime", getAuditTime())
			.append("Visits", getVisits())
			.append("Supports", getSupports())
			.append("Comments", getComments())
			.append("DelMemo", getDelMemo())
			.append("CreateTime", getCreateTime())
			.append("EditTime", getEditTime())
			.append("Editor", getEditor()).append("Brief", getBrief())
			.append("IsRecommend", getIsRecommend())
			.append("Label", getLabel()).toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder().append(getCmhcId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof BusinessChinmedichenacare == false)
			return false;
		if (this == obj)
			return true;
		BusinessChinmedichenacare other = (BusinessChinmedichenacare) obj;
		return new EqualsBuilder().append(getCmhcId(), other.getCmhcId()).isEquals();
	}
}