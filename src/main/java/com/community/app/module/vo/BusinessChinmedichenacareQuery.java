package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessChinmedichenacare;

public class BusinessChinmedichenacareQuery extends BaseBean {
	
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
	
	private String timeScope;
	private String startTime;
	private String endTime;
	private String orderBy;
	private String keyWord;
	private java.lang.Integer userId;

	public java.lang.Integer getUserId() {
		return userId;
	}

	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	public BusinessChinmedichenacareQuery(BusinessChinmedichenacare businessChinmedichenacare) {
		this.cmhcId = businessChinmedichenacare.getCmhcId();
		this.cmhcTitle = businessChinmedichenacare.getCmhcTitle();
		this.cmhcContent = businessChinmedichenacare.getCmhcContent();
		this.cmhcPic = businessChinmedichenacare.getCmhcPic();
		this.appPic = businessChinmedichenacare.getAppPic();
		this.publisherId = businessChinmedichenacare.getPublisherId();
		this.publisherName = businessChinmedichenacare.getPublisherName();
		this.publishTime = businessChinmedichenacare.getPublishTime();
		this.publishState = businessChinmedichenacare.getPublishState();
		this.auditorId = businessChinmedichenacare.getAuditorId();
		this.auditorName = businessChinmedichenacare.getAuditorName();
		this.auditTime = businessChinmedichenacare.getAuditTime();
		this.visits = businessChinmedichenacare.getVisits();
		this.supports = businessChinmedichenacare.getSupports();
		this.comments = businessChinmedichenacare.getComments();
		this.delMemo = businessChinmedichenacare.getDelMemo();
		this.createTime = businessChinmedichenacare.getCreateTime();
		this.editTime = businessChinmedichenacare.getEditTime();
		this.editor = businessChinmedichenacare.getEditor();
		this.brief = businessChinmedichenacare.getBrief();
		this.isRecommend = businessChinmedichenacare.getIsRecommend();
		this.label = businessChinmedichenacare.getLabel();
		this.auditInfo = businessChinmedichenacare.getAuditInfo();
		this.avatar = businessChinmedichenacare.getAvatar();
		this.doctorBrief = businessChinmedichenacare.getDoctorBrief();
		this.doctorName = businessChinmedichenacare.getDoctorName();
	}
	
	public BusinessChinmedichenacareQuery() {
		
	}	
	
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
	
	public String getAuditInfo() {
		return auditInfo;
	}

	public void setAuditInfo(String auditInfo) {
		this.auditInfo = auditInfo;
	}

	public java.lang.Integer getCmhcId() {
		return this.cmhcId;
	}
	
	public void setCmhcId(java.lang.Integer value) {
		this.cmhcId = value;
	}
		
	public java.lang.String getCmhcTitle() {
		return this.cmhcTitle;
	}
	
	public void setCmhcTitle(java.lang.String value) {
		this.cmhcTitle = value;
	}
		
	public java.lang.String getCmhcContent() {
		return this.cmhcContent;
	}
	
	public void setCmhcContent(java.lang.String value) {
		this.cmhcContent = value;
	}
		
	public java.lang.String getCmhcPic() {
		return this.cmhcPic;
	}
	
	public void setCmhcPic(java.lang.String value) {
		this.cmhcPic = value;
	}
		
	public java.lang.String getAppPic() {
		return this.appPic;
	}
	
	public void setAppPic(java.lang.String value) {
		this.appPic = value;
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
		
	public java.sql.Timestamp getPublishTime() {
		return this.publishTime;
	}
	
	public void setPublishTime(java.sql.Timestamp value) {
		this.publishTime = value;
	}
		
	public Integer getPublishState() {
		return this.publishState;
	}
	
	public void setPublishState(Integer value) {
		this.publishState = value;
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
		
	public java.lang.Integer getComments() {
		return this.comments;
	}
	
	public void setComments(java.lang.Integer value) {
		this.comments = value;
	}
		
	public java.lang.String getDelMemo() {
		return this.delMemo;
	}
	
	public void setDelMemo(java.lang.String value) {
		this.delMemo = value;
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
		
	public java.lang.String getBrief() {
		return this.brief;
	}
	
	public void setBrief(java.lang.String value) {
		this.brief = value;
	}
		
	public java.lang.Integer getIsRecommend() {
		return this.isRecommend;
	}
	
	public void setIsRecommend(java.lang.Integer value) {
		this.isRecommend = value;
	}
		
	public java.lang.String getLabel() {
		return this.label;
	}
	
	public void setLabel(java.lang.String value) {
		this.label = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

