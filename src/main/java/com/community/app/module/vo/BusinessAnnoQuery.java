package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessAnno;
import com.community.app.module.vo.BaseBean;

public class BusinessAnnoQuery extends BaseBean {
	
	private java.lang.Integer annoId;
	private java.lang.String annoTitle;
	private java.lang.String annoContent;
	private Integer annoType;
	private java.lang.String annoScope;
	private String annoBuilding;
	private String annoScopeInfo;
	private java.lang.String annoPic;
	private Integer userLevel;
	private java.lang.Integer publisherId;
	private java.lang.String publisherName;
	private java.lang.String publishTime;
	private Integer publishState;
	private java.lang.Integer auditorId;
	private java.lang.String auditorName;
	private java.sql.Timestamp auditTime;
	private java.lang.String setTime;
	private Integer isPush;
	private Integer isImportant;
	private Integer isRemind;
	private java.lang.Integer visits;
	private java.lang.Integer supports;
	private java.lang.Integer comments;
	private Integer annoState;
	private java.lang.String delMemo;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
    private String scope;
    private Integer isRecommend;
    
    private String timeScope;
	private String startTime;
	private String endTime;
	private String orderBy;
	private String keyWord;
	private String appPic;
	private Integer proId;
	
	private java.sql.Timestamp importantTime;
	
	private Integer curUserId;
	private Integer curEstateId;
	private Integer userId;
	private String orgType;
	
	private Integer scopeType; //范围类型 只为首页的内部公告查询使用预留
	private String dateField;
		
	public String getDateField() {
		return dateField;
	}

	public void setDateField(String dateField) {
		this.dateField = dateField;
	}

	public Integer getCurUserId() {
		return curUserId;
	}

	public void setCurUserId(Integer curUserId) {
		this.curUserId = curUserId;
	}

	public Integer getScopeType() {
		return scopeType;
	}

	public void setScopeType(Integer scopeType) {
		this.scopeType = scopeType;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public Integer getCurEstateId() {
		return curEstateId;
	}

	public void setCurEstateId(Integer curEstateId) {
		this.curEstateId = curEstateId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getProId() {
		return proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public java.sql.Timestamp getImportantTime() {
		return importantTime;
	}

	public void setImportantTime(java.sql.Timestamp importantTime) {
		this.importantTime = importantTime;
	}

	private Integer[] annoTypes;//多类型同时搜索条件,类型用“,”隔开
	private Integer estateId;//按小区查询公告的小区ID条件

	private String brief;

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getAppPic() {
		return appPic;
	}

	public void setAppPic(String appPic) {
		this.appPic = appPic;
	}

	public Integer[] getAnnoTypes() {
		return annoTypes;
	}

	public void setAnnoTypes(Integer[] annoTypes) {
		this.annoTypes = annoTypes;
	}

	public java.lang.Integer getEstateId() {
		return estateId;
	}

	public void setEstateId(java.lang.Integer estateId) {
		this.estateId = estateId;
	}

	public BusinessAnnoQuery(BusinessAnno businessAnno) {
		this.annoId = businessAnno.getAnnoId();
		this.annoTitle = businessAnno.getAnnoTitle();
		this.annoContent = businessAnno.getAnnoContent();
		this.annoType = businessAnno.getAnnoType();
		this.annoScope = businessAnno.getAnnoScope();
		this.annoPic = businessAnno.getAnnoPic();
		this.userLevel = businessAnno.getUserLevel();
		this.publisherId = businessAnno.getPublisherId();
		this.publisherName = businessAnno.getPublisherName();
		this.publishTime = businessAnno.getPublishTime().toLocaleString();
		this.publishState = businessAnno.getPublishState();
		this.auditorId = businessAnno.getAuditorId();
		this.auditorName = businessAnno.getAuditorName();
		this.auditTime = businessAnno.getAuditTime();
		this.setTime = businessAnno.getSetTime();
		this.isPush = businessAnno.getIsPush();
		this.isImportant = businessAnno.getIsImportant();
		this.isRemind = businessAnno.getIsRemind();
		this.visits = businessAnno.getVisits();
		this.supports = businessAnno.getSupports();
		this.comments = businessAnno.getComments();
		this.annoState = businessAnno.getAnnoState();
		this.delMemo = businessAnno.getDelMemo();
		this.createTime = businessAnno.getCreateTime();
		this.editTime = businessAnno.getEditTime();
		this.editor = businessAnno.getEditor();
		this.scope = businessAnno.getScope();
		this.annoScope = businessAnno.getAnnoScope();
		this.annoBuilding = businessAnno.getAnnoBuilding();
		this.annoScopeInfo = businessAnno.getAnnoScopeInfo();
		this.isRecommend = businessAnno.getIsRecommend();
		this.brief = businessAnno.getBrief();
		this.appPic = businessAnno.getAppPic();
		this.importantTime = businessAnno.getImportantTime();
	}
	
	public BusinessAnnoQuery() {
		
	}

    public Integer getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(Integer isRecommend) {
		this.isRecommend = isRecommend;
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

	public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public java.lang.Integer getAnnoId() {
		return this.annoId;
	}
	
	public void setAnnoId(java.lang.Integer value) {
		this.annoId = value;
	}
		
	public java.lang.String getAnnoTitle() {
		return this.annoTitle;
	}
	
	public void setAnnoTitle(java.lang.String value) {
		this.annoTitle = value;
	}
		
	public java.lang.String getAnnoContent() {
		return this.annoContent;
	}
	
	public void setAnnoContent(java.lang.String value) {
		this.annoContent = value;
	}
		
	public Integer getAnnoType() {
		return this.annoType;
	}
	
	public void setAnnoType(Integer value) {
		this.annoType = value;
	}
		
	public java.lang.String getAnnoScope() {
		return this.annoScope;
	}
	
	public void setAnnoScope(java.lang.String value) {
		this.annoScope = value;
	}
		
	public java.lang.String getAnnoPic() {
		return this.annoPic;
	}
	
	public void setAnnoPic(java.lang.String value) {
		this.annoPic = value;
	}
		
	public Integer getUserLevel() {
		return this.userLevel;
	}
	
	public void setUserLevel(Integer value) {
		this.userLevel = value;
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
		
	public java.lang.String getPublishTime() {
		return this.publishTime;
	}
	
	public void setPublishTime(java.lang.String value) {
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
		
	public java.lang.String getSetTime() {
		return this.setTime;
	}
	
	public void setSetTime(java.lang.String value) {
		this.setTime = value;
	}
		
	public Integer getIsPush() {
		return this.isPush;
	}
	
	public void setIsPush(Integer value) {
		this.isPush = value;
	}
		
	public Integer getIsImportant() {
		return this.isImportant;
	}
	
	public void setIsImportant(Integer value) {
		this.isImportant = value;
	}
		
	public Integer getIsRemind() {
		return this.isRemind;
	}
	
	public void setIsRemind(Integer value) {
		this.isRemind = value;
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
		
	public Integer getAnnoState() {
		return this.annoState;
	}
	
	public void setAnnoState(Integer value) {
		this.annoState = value;
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
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
}