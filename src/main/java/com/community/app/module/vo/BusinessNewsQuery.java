package com.community.app.module.vo;

import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessNews;

public class BusinessNewsQuery extends BaseBean {
	
	private Integer newsId;
	private String title;
	private String content;
	private String pageUrl;
	private String brief;
	private String subjectPic;
	private String appPic;
	private Integer newsType;
	private Integer publisherId;
	private String publisherName;
	private java.sql.Timestamp publishTime;
	private String comName;
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
	private Integer comId;
	private Integer breakId;

	private String timeScope;
	private String startTime;
	private String endTime;
	private String orderBy;
	private String keyWord;
	private Integer estateId;
	private Integer stationId;
	private Integer proId;
	private java.sql.Timestamp hotTime;
	private Integer selectId;
	
	private Integer curUserId;//当前用户ID
	private String curOrgType;//当前部门类型
	private Integer curComId; //当前社区ID
	
	private String dateField;
	
	private Integer userId;
	
	private String newsScope;
	private Map<String,String> param;
	private Map<String,String> image;
	private String newsScopeInfo;
	private String tag;
	
	private Integer curEstateId;
	private java.sql.Timestamp hotTime1;
	
	public java.sql.Timestamp getHotTime1() {
		return hotTime1;
	}

	public void setHotTime1(java.sql.Timestamp hotTime1) {
		this.hotTime1 = hotTime1;
	}

	public Integer getCurEstateId() {
		return curEstateId;
	}

	public void setCurEstateId(Integer curEstateId) {
		this.curEstateId = curEstateId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getNewsScopeInfo() {
		return newsScopeInfo;
	}

	public void setNewsScopeInfo(String newsScopeInfo) {
		this.newsScopeInfo = newsScopeInfo;
	}

	public Map<String, String> getParam() {
		return param;
	}

	public void setParam(Map<String, String> param) {
		this.param = param;
	}

	public Map<String, String> getImage() {
		return image;
	}

	public void setImage(Map<String, String> image) {
		this.image = image;
	}

	public String getNewsScope() {
		return newsScope;
	}

	public void setNewsScope(String newsScope) {
		this.newsScope = newsScope;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getDateField() {
		return dateField;
	}

	public void setDateField(String dateField) {
		this.dateField = dateField;
	}

	public Integer getCurComId() {
		return curComId;
	}

	public void setCurComId(Integer curComId) {
		this.curComId = curComId;
	}

	public Integer getCurUserId() {
		return curUserId;
	}

	public void setCurUserId(Integer curUserId) {
		this.curUserId = curUserId;
	}

	public String getCurOrgType() {
		return curOrgType;
	}

	public void setCurOrgType(String curOrgType) {
		this.curOrgType = curOrgType;
	}

	public Integer getSelectId() {
		return selectId;
	}

	public void setSelectId(Integer selectId) {
		this.selectId = selectId;
	}

	public java.sql.Timestamp getHotTime() {
		return hotTime;
	}

	public void setHotTime(java.sql.Timestamp hotTime) {
		this.hotTime = hotTime;
	}

	public Integer getEstateId() {
		return estateId;
	}

	public void setEstateId(Integer estateId) {
		this.estateId = estateId;
	}

	public Integer getStationId() {
		return stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

	public Integer getProId() {
		return proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
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

	public Integer getComId() {
		return comId;
	}

	public void setComId(Integer comId) {
		this.comId = comId;
	}

	public BusinessNewsQuery(BusinessNews businessNews) {
		this.newsId = businessNews.getNewsId();
		this.title = businessNews.getTitle();
		this.content = businessNews.getContent();
		this.pageUrl = businessNews.getPageUrl();
		this.brief = businessNews.getBrief();
		this.subjectPic = businessNews.getSubjectPic();
		this.appPic = businessNews.getAppPic();
		this.newsType = businessNews.getNewsType();
		this.publisherId = businessNews.getPublisherId();
		this.publisherName = businessNews.getPublisherName();
		this.publishTime = businessNews.getPublishTime();
		this.comName = businessNews.getComName();
		this.state = businessNews.getState();
		this.auditorId = businessNews.getAuditorId();
		this.auditorName = businessNews.getAuditorName();
		this.auditTime = businessNews.getAuditTime();
		this.auditInfo = businessNews.getAuditInfo();
		this.visits = businessNews.getVisits();
		this.comments = businessNews.getComments();
		this.supports = businessNews.getSupports();
		this.publishScope = businessNews.getPublishScope();
		this.setTime = businessNews.getSetTime();
		this.isHot = businessNews.getIsHot();
		this.isAd = businessNews.getIsAd();
		this.createTime = businessNews.getCreateTime();
		this.editTime = businessNews.getEditTime();
		this.editor = businessNews.getEditor();
		this.isPush = businessNews.getIsPush();
		this.isRecommend = businessNews.getIsRecommend();
		this.breakId = businessNews.getBreakId();
		this.hotTime = businessNews.getHotTime();
		this.selectId = businessNews.getSelectId();
	}
	
	public String getAppPic() {
		return appPic;
	}

	public void setAppPic(String appPic) {
		this.appPic = appPic;
	}

	public BusinessNewsQuery() {
		
	}	
	
	public Integer getNewsId() {
		return this.newsId;
	}
	
	public void setNewsId(Integer value) {
		this.newsId = value;
	}
		
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String value) {
		this.title = value;
	}
		
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String value) {
		this.content = value;
	}
		
	public String getPageUrl() {
		return this.pageUrl;
	}
	
	public void setPageUrl(String value) {
		this.pageUrl = value;
	}
		
	public String getBrief() {
		return this.brief;
	}
	
	public void setBrief(String value) {
		this.brief = value;
	}
		
	public String getSubjectPic() {
		return this.subjectPic;
	}
	
	public void setSubjectPic(String value) {
		this.subjectPic = value;
	}
		
	public Integer getNewsType() {
		return this.newsType;
	}
	
	public void setNewsType(Integer value) {
		this.newsType = value;
	}
		
	public Integer getPublisherId() {
		return this.publisherId;
	}
	
	public void setPublisherId(Integer value) {
		this.publisherId = value;
	}
		
	public String getPublisherName() {
		return this.publisherName;
	}
	
	public void setPublisherName(String value) {
		this.publisherName = value;
	}
		
	public java.sql.Timestamp getPublishTime() {
		return this.publishTime;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}
	
	public void setPublishTime(java.sql.Timestamp value) {
		this.publishTime = value;
	}
		
	public Integer getState() {
		return this.state;
	}
	
	public void setState(Integer value) {
		this.state = value;
	}
		
	public Integer getAuditorId() {
		return this.auditorId;
	}
	
	public void setAuditorId(Integer value) {
		this.auditorId = value;
	}
		
	public String getAuditorName() {
		return this.auditorName;
	}
	
	public void setAuditorName(String value) {
		this.auditorName = value;
	}
		
	public java.sql.Timestamp getAuditTime() {
		return this.auditTime;
	}
	
	public void setAuditTime(java.sql.Timestamp value) {
		this.auditTime = value;
	}
		
	public String getAuditInfo() {
		return this.auditInfo;
	}
	
	public void setAuditInfo(String value) {
		this.auditInfo = value;
	}
		
	public Integer getVisits() {
		return this.visits;
	}
	
	public void setVisits(Integer value) {
		this.visits = value;
	}
		
	public Integer getComments() {
		return this.comments;
	}
	
	public void setComments(Integer value) {
		this.comments = value;
	}
		
	public Integer getSupports() {
		return this.supports;
	}
	
	public void setSupports(Integer value) {
		this.supports = value;
	}
		
	public Integer getPublishScope() {
		return this.publishScope;
	}
	
	public void setPublishScope(Integer value) {
		this.publishScope = value;
	}
		
	public String getSetTime() {
		return this.setTime;
	}
	
	public void setSetTime(String value) {
		this.setTime = value;
	}
		
	public Integer getIsHot() {
		return this.isHot;
	}
	
	public void setIsHot(Integer value) {
		this.isHot = value;
	}
		
	public Integer getIsAd() {
		return this.isAd;
	}
	
	public void setIsAd(Integer value) {
		this.isAd = value;
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
		
	public String getEditor() {
		return this.editor;
	}
	
	public void setEditor(String value) {
		this.editor = value;
	}
		
	public Integer getIsPush() {
		return this.isPush;
	}
	
	public void setIsPush(Integer value) {
		this.isPush = value;
	}
		
	public Integer getIsRecommend() {
		return this.isRecommend;
	}
	
	public void setIsRecommend(Integer value) {
		this.isRecommend = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
	public Integer getBreakId() {
		return breakId;
	}

	public void setBreakId(Integer breakId) {
		this.breakId = breakId;
	}
}