package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.sql.Timestamp;

@SuppressWarnings("serial")
public class BusinessAnno implements java.io.Serializable{

	//别名
	public static final String TABLE_ALIAS = "BusinessAnno";

	private java.lang.Integer annoId;
	private java.lang.String annoTitle = "";
	private java.lang.String annoContent = "";
	private Integer annoType;
	private java.lang.String annoScope;
	private String annoBuilding;
	private String annoScopeInfo;
	private java.lang.String annoPic = "";
	private Integer userLevel;
	private java.lang.Integer publisherId;
	private java.lang.String publisherName = "";
	private Timestamp publishTime;
	private Integer publishState;
	private java.lang.Integer auditorId;
	private java.lang.String auditorName = "";
	private java.sql.Timestamp auditTime;
	private java.lang.String setTime = "";
	private Integer isPush;
	private Integer isRecommend;
	private Integer isImportant;
	private Integer isRemind;
	private java.lang.Integer visits;
	private java.lang.Integer supports;
	private java.lang.Integer comments;
	private Integer annoState;
	private java.lang.String delMemo = "";
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor = "";
    private String scope = "";
    private String orderBy = "";
    private String brief = "";
    private String pageUrl = "";
    private String portrait = "";
    private String nickname = "";
    private String appPic;
    private java.sql.Timestamp importantTime;
    
	public java.sql.Timestamp getImportantTime() {
		return importantTime;
	}

	public void setImportantTime(java.sql.Timestamp importantTime) {
		this.importantTime = importantTime;
	}

	public String getAppPic() {
		return appPic;
	}

	public void setAppPic(String appPic) {
		this.appPic = appPic;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(Integer isRecommend) {
		this.isRecommend = isRecommend;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public BusinessAnno(){
	}

	public BusinessAnno(
		java.lang.Integer annoId
	){
		this.annoId = annoId;
	}

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public void setAnnoId(java.lang.Integer value) {
		this.annoId = value;
	}
	
	public java.lang.Integer getAnnoId() {
		return this.annoId;
	}
	public void setAnnoTitle(java.lang.String value) {
		this.annoTitle = value;
	}
	
	public java.lang.String getAnnoTitle() {
		return this.annoTitle;
	}
	public void setAnnoContent(java.lang.String value) {
		this.annoContent = value;
	}
	
	public java.lang.String getAnnoContent() {
		return this.annoContent;
	}
	public void setAnnoType(Integer value) {
		this.annoType = value;
	}
	
	public Integer getAnnoType() {
		return this.annoType;
	}
	public void setAnnoScope(java.lang.String value) {
		this.annoScope = value;
	}
	
	public java.lang.String getAnnoScope() {
		return this.annoScope;
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

	public void setAnnoPic(java.lang.String value) {
		this.annoPic = value;
	}
	
	public java.lang.String getAnnoPic() {
		return this.annoPic;
	}
	public void setUserLevel(Integer value) {
		this.userLevel = value;
	}
	
	public Integer getUserLevel() {
		return this.userLevel;
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
	public void setSetTime(java.lang.String value) {
		this.setTime = value;
	}
	
	public java.lang.String getSetTime() {
		return this.setTime;
	}
	public void setIsPush(Integer value) {
		this.isPush = value;
	}
	
	public Integer getIsPush() {
		return this.isPush;
	}
	public void setIsImportant(Integer value) {
		this.isImportant = value;
	}
	
	public Integer getIsImportant() {
		return this.isImportant;
	}
	public void setIsRemind(Integer value) {
		this.isRemind = value;
	}
	
	public Integer getIsRemind() {
		return this.isRemind;
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
	public void setAnnoState(Integer value) {
		this.annoState = value;
	}
	
	public Integer getAnnoState() {
		return this.annoState;
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

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("AnnoId",getAnnoId())
			.append("AnnoTitle",getAnnoTitle())
			.append("AnnoContent",getAnnoContent())
			.append("AnnoType",getAnnoType())
			.append("AnnoScope",getAnnoScope())
			.append("AnnoPic",getAnnoPic())
			.append("UserLevel",getUserLevel())
			.append("PublisherId",getPublisherId())
			.append("PublisherName",getPublisherName())
			.append("PublishDate",getPublishTime())
			.append("PublishState",getPublishState())
			.append("AuditorId",getAuditorId())
			.append("AuditorName",getAuditorName())
			.append("AuditTime",getAuditTime())
			.append("SetTime",getSetTime())
			.append("IsPush",getIsPush())
			.append("IsImportant",getIsImportant())
			.append("IsRemind",getIsRemind())
			.append("Visits",getVisits())
			.append("Supports",getSupports())
			.append("Comments",getComments())
			.append("AnnoState",getAnnoState())
			.append("DelMemo",getDelMemo())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getAnnoId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessAnno == false) return false;
		if(this == obj) return true;
		BusinessAnno other = (BusinessAnno)obj;
		return new EqualsBuilder()
			.append(getAnnoId(),other.getAnnoId())
			.isEquals();
	}
}

