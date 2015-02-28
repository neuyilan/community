package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessHealthydiet;

public class BusinessHealthydietQuery extends BaseBean {
	
	private java.lang.Integer healId;
	private java.lang.String healTitle;
	private java.lang.String healContent;
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
	private String auditInfo;
	private String doctorName;
	private String avatar;
	private String doctorBrief;
	private String label;

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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getTimeScope() {
		return timeScope;
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

	public BusinessHealthydietQuery(BusinessHealthydiet businessHealthydiet) {
		this.healId = businessHealthydiet.getHealId();
		this.healTitle = businessHealthydiet.getHealTitle();
		this.healContent = businessHealthydiet.getHealContent();
		this.cmhcPic = businessHealthydiet.getCmhcPic();
		this.appPic = businessHealthydiet.getAppPic();
		this.publisherId = businessHealthydiet.getPublisherId();
		this.publisherName = businessHealthydiet.getPublisherName();
		this.publishTime = businessHealthydiet.getPublishTime();
		this.publishState = businessHealthydiet.getPublishState();
		this.auditorId = businessHealthydiet.getAuditorId();
		this.auditorName = businessHealthydiet.getAuditorName();
		this.auditTime = businessHealthydiet.getAuditTime();
		this.visits = businessHealthydiet.getVisits();
		this.supports = businessHealthydiet.getSupports();
		this.comments = businessHealthydiet.getComments();
		this.delMemo = businessHealthydiet.getDelMemo();
		this.createTime = businessHealthydiet.getCreateTime();
		this.editTime = businessHealthydiet.getEditTime();
		this.editor = businessHealthydiet.getEditor();
		this.brief = businessHealthydiet.getBrief();
		this.isRecommend = businessHealthydiet.getIsRecommend();
		this.auditInfo = businessHealthydiet.getAuditInfo();
	}
	
	public BusinessHealthydietQuery() {
		
	}	
	
	public String getAuditInfo() {
		return auditInfo;
	}

	public void setAuditInfo(String auditInfo) {
		this.auditInfo = auditInfo;
	}

	public java.lang.Integer getHealId() {
		return this.healId;
	}
	
	public void setHealId(java.lang.Integer value) {
		this.healId = value;
	}
		
	public java.lang.String getHealTitle() {
		return this.healTitle;
	}
	
	public void setHealTitle(java.lang.String value) {
		this.healTitle = value;
	}
		
	public java.lang.String getHealContent() {
		return this.healContent;
	}
	
	public void setHealContent(java.lang.String value) {
		this.healContent = value;
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
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

