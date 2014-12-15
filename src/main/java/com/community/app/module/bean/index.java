package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.sql.Timestamp;
import java.util.*;


public class index implements java.io.Serializable{
	

	private Integer newsId;
	private String title;
	private String content;
	private String pageUrl;
	private String brief;
	private String subjectPic;
	private Integer newsType;
	private Integer publisherId;
	private String publisherName;
	private java.sql.Timestamp publishTime;
	private Integer state;
	private Integer auditorId;
	private String auditorName;
	private java.sql.Timestamp auditTime;
	private String auditInfo;
	private Integer visits;
	private Integer comments;
	private Integer supports;
	private Integer publishScope;
	private String setTime;
	private Integer isHot;
	private Integer isAd;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private String editor;
	private Integer isPush;
	private Integer isRecommend;
	private String portrait;
	private java.lang.Integer annoId;
	private java.lang.String annoTitle = "";
	private java.lang.String annoContent = "";
	private Integer annoType;
	private java.lang.String annoScope;
	private String annoBuilding;
	private String annoScopeInfo;
	private java.lang.String annoPic = "";
	private Integer userLevel;
	private Integer publishState;
	private Integer isImportant;
	private Integer isRemind;
	private Integer annoState;
	private java.lang.String delMemo = "";
    private String scope = "";
    private String orderBy = "";
    private Integer type;
    
	
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public java.lang.Integer getAnnoId() {
		return annoId;
	}

	public void setAnnoId(java.lang.Integer annoId) {
		this.annoId = annoId;
	}

	public java.lang.String getAnnoTitle() {
		return annoTitle;
	}

	public void setAnnoTitle(java.lang.String annoTitle) {
		this.annoTitle = annoTitle;
	}

	public java.lang.String getAnnoContent() {
		return annoContent;
	}

	public void setAnnoContent(java.lang.String annoContent) {
		this.annoContent = annoContent;
	}

	public Integer getAnnoType() {
		return annoType;
	}

	public void setAnnoType(Integer annoType) {
		this.annoType = annoType;
	}

	public java.lang.String getAnnoScope() {
		return annoScope;
	}

	public void setAnnoScope(java.lang.String annoScope) {
		this.annoScope = annoScope;
	}

	public String getAnnoBuilding() {
		return annoBuilding;
	}

	public void setAnnoBuilding(String annoBuilding) {
		this.annoBuilding = annoBuilding;
	}

	public String getAnnoScopeInfo() {
		return annoScopeInfo;
	}

	public void setAnnoScopeInfo(String annoScopeInfo) {
		this.annoScopeInfo = annoScopeInfo;
	}

	public java.lang.String getAnnoPic() {
		return annoPic;
	}

	public void setAnnoPic(java.lang.String annoPic) {
		this.annoPic = annoPic;
	}

	public Integer getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}

	public Integer getPublishState() {
		return publishState;
	}

	public void setPublishState(Integer publishState) {
		this.publishState = publishState;
	}

	public Integer getIsImportant() {
		return isImportant;
	}

	public void setIsImportant(Integer isImportant) {
		this.isImportant = isImportant;
	}

	public Integer getIsRemind() {
		return isRemind;
	}

	public void setIsRemind(Integer isRemind) {
		this.isRemind = isRemind;
	}

	public Integer getAnnoState() {
		return annoState;
	}

	public void setAnnoState(Integer annoState) {
		this.annoState = annoState;
	}

	public java.lang.String getDelMemo() {
		return delMemo;
	}

	public void setDelMemo(java.lang.String delMemo) {
		this.delMemo = delMemo;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public index(){
	}

	public index(
		Integer newsId
	){
		this.newsId = newsId;
	}

	public void setNewsId(Integer value) {
		this.newsId = value;
	}
	
	public Integer getNewsId() {
		return this.newsId;
	}
	public void setTitle(String value) {
		this.title = value;
	}
	
	public String getTitle() {
		return this.title;
	}
	public void setContent(String value) {
		this.content = value;
	}
	
	public String getContent() {
		return this.content;
	}
	public void setPageUrl(String value) {
		this.pageUrl = value;
	}
	
	public String getPageUrl() {
		return this.pageUrl;
	}
	public void setBrief(String value) {
		this.brief = value;
	}
	
	public String getBrief() {
		return this.brief;
	}
	public void setSubjectPic(String value) {
		this.subjectPic = value;
	}
	
	public String getSubjectPic() {
		return this.subjectPic;
	}
	public void setNewsType(Integer value) {
		this.newsType = value;
	}
	
	public Integer getNewsType() {
		return this.newsType;
	}
	public void setPublisherId(Integer value) {
		this.publisherId = value;
	}
	
	public Integer getPublisherId() {
		return this.publisherId;
	}
	public void setPublisherName(String value) {
		this.publisherName = value;
	}
	
	public String getPublisherName() {
		return this.publisherName;
	}
	public void setPublishTime(java.sql.Timestamp value) {
		this.publishTime = value;
	}
	
	public java.sql.Timestamp getPublishTime() {
		return this.publishTime;
	}
	public void setState(Integer value) {
		this.state = value;
	}
	
	public Integer getState() {
		return this.state;
	}
	public void setAuditorId(Integer value) {
		this.auditorId = value;
	}
	
	public Integer getAuditorId() {
		return this.auditorId;
	}
	public void setAuditorName(String value) {
		this.auditorName = value;
	}
	
	public String getAuditorName() {
		return this.auditorName;
	}
	public void setAuditTime(java.sql.Timestamp value) {
		this.auditTime = value;
	}
	
	public java.sql.Timestamp getAuditTime() {
		return this.auditTime;
	}
	public void setAuditInfo(String value) {
		this.auditInfo = value;
	}
	
	public String getAuditInfo() {
		return this.auditInfo;
	}
	public void setVisits(Integer value) {
		this.visits = value;
	}
	
	public Integer getVisits() {
		return this.visits;
	}
	public void setComments(Integer value) {
		this.comments = value;
	}
	
	public Integer getComments() {
		return this.comments;
	}
	public void setSupports(Integer value) {
		this.supports = value;
	}
	
	public Integer getSupports() {
		return this.supports;
	}
	public void setPublishScope(Integer value) {
		this.publishScope = value;
	}
	
	public Integer getPublishScope() {
		return this.publishScope;
	}
	public void setSetTime(String value) {
		this.setTime = value;
	}
	
	public String getSetTime() {
		return this.setTime;
	}
	public void setIsHot(Integer value) {
		this.isHot = value;
	}
	
	public Integer getIsHot() {
		return this.isHot;
	}
	public void setIsAd(Integer value) {
		this.isAd = value;
	}
	
	public Integer getIsAd() {
		return this.isAd;
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
	public void setEditor(String value) {
		this.editor = value;
	}
	
	public String getEditor() {
		return this.editor;
	}
	public void setIsPush(Integer value) {
		this.isPush = value;
	}
	
	public Integer getIsPush() {
		return this.isPush;
	}
	public void setIsRecommend(Integer value) {
		this.isRecommend = value;
	}
	
	public Integer getIsRecommend() {
		return this.isRecommend;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("NewsId",getNewsId())
			.append("Title",getTitle())
			.append("Content",getContent())
			.append("PageUrl",getPageUrl())
			.append("Brief",getBrief())
			.append("SubjectPic",getSubjectPic())
			.append("NewsType",getNewsType())
			.append("PublisherId",getPublisherId())
			.append("PublisherName",getPublisherName())
			.append("PublishTime",getPublishTime())
			.append("State",getState())
			.append("AuditorId",getAuditorId())
			.append("AuditorName",getAuditorName())
			.append("AuditTime",getAuditTime())
			.append("AuditInfo",getAuditInfo())
			.append("Visits",getVisits())
			.append("Comments",getComments())
			.append("Supports",getSupports())
			.append("PublishScope",getPublishScope())
			.append("SetTime",getSetTime())
			.append("IsHot",getIsHot())
			.append("IsAd",getIsAd())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.append("IsPush",getIsPush())
			.append("IsRecommend",getIsRecommend())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getNewsId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof index == false) return false;
		if(this == obj) return true;
		index other = (index)obj;
		return new EqualsBuilder()
			.append(getNewsId(),other.getNewsId())
			.isEquals();
	}
}

