package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessActivity;
import com.community.app.module.vo.BaseBean;

public class BusinessActivityQuery extends BaseBean {

	private Integer actId;
	private Integer typeId;
	private String actName;
	private String actContent;
	private String typeName;
	private String actScope;
	private String brief;
	private String actPic;
	private String actLink;
	private String actManage;
	private Integer userType;
	private Integer publisherId;
	private String publishDate;
	private String publishTime;
	private String startTime;
	private String endTime;
	private Integer rank;
	private Integer state;
	private Integer auditorId;
	private String auditorName;
	private java.sql.Timestamp auditTime;
	private Integer visits;
	private Integer comments;
	private Integer supports;
	private Integer particpates;
	private Integer isComment;
	private Integer recommend;
	private Integer isPush;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private String editTime1;
	private String editor;

	private String timeScope;
	private String startActTime;
	private String endActTime;
	private String orderBy;
	private String keyWord;
	private Integer estateId;

	private String planTime;
	private String appPic;

	private Integer isImportant;
	private String refuseMemo;
	private java.sql.Timestamp importantTime;
	private Integer type;
	private Integer statetype;
	private Integer curUserId;//当前用户ID
	private String curOrgType;//当前部门类型
	private String[] states; //状态数组
	private Integer curComId;//当前社区id
	private Integer userId;
	
	private Integer isTimingPush;
	private String timingPushconTent;
	private java.sql.Timestamp timingPushTime;
	private String timingPushTime1;
	private Integer times;
	private Integer timeSlotId;
	private Integer ID;
	private String tel;
	private Integer isTimingPushType;
	private Integer voteType;
	private Integer votes;
	private String content;
	private String image;
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getVoteType() {
		return voteType;
	}

	public void setVoteType(Integer voteType) {
		this.voteType = voteType;
	}

	public Integer getVotes() {
		return votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}

	public Integer getIsTimingPushType() {
		return isTimingPushType;
	}

	public void setIsTimingPushType(Integer isTimingPushType) {
		this.isTimingPushType = isTimingPushType;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getTimeSlotId() {
		return timeSlotId;
	}

	public void setTimeSlotId(Integer timeSlotId) {
		this.timeSlotId = timeSlotId;
	}

	public String getEditTime1() {
		return editTime1;
	}

	public void setEditTime1(String editTime1) {
		this.editTime1 = editTime1;
	}

	public String getTimingPublicTime1() {
		return timingPublicTime1;
	}

	public void setTimingPublicTime1(String timingPublicTime1) {
		this.timingPublicTime1 = timingPublicTime1;
	}

	private java.sql.Timestamp timingPublicTime;
	private String timingPublicTime1;
	private String attributeValues;
	
	public String getAttributeValues() {
		return attributeValues;
	}

	public void setAttributeValues(String attributeValues) {
		this.attributeValues = attributeValues;
	}

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	public java.sql.Timestamp getTimingPublicTime() {
		return timingPublicTime;
	}

	public void setTimingPublicTime(java.sql.Timestamp timingPublicTime) {
		this.timingPublicTime = timingPublicTime;
	}

	public String getTimingPushTime1() {
		return timingPushTime1;
	}

	public void setTimingPushTime1(String timingPushTime1) {
		this.timingPushTime1 = timingPushTime1;
	}

	public Integer getIsTimingPush() {
		return isTimingPush;
	}

	public void setIsTimingPush(Integer isTimingPush) {
		this.isTimingPush = isTimingPush;
	}

	public String getTimingPushconTent() {
		return timingPushconTent;
	}

	public void setTimingPushconTent(String timingPushconTent) {
		this.timingPushconTent = timingPushconTent;
	}

	public java.sql.Timestamp getTimingPushTime() {
		return timingPushTime;
	}

	public void setTimingPushTime(java.sql.Timestamp timingPushTime) {
		this.timingPushTime = timingPushTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCurComId() {
		return curComId;
	}

	public void setCurComId(Integer curComId) {
		this.curComId = curComId;
	}

	public String[] getStates() {
		return states;
	}

	public void setStates(String[] states) {
		this.states = states;
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

	public Integer getStatetype() {
		return statetype;
	}

	public void setStatetype(Integer statetype) {
		this.statetype = statetype;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public java.sql.Timestamp getImportantTime() {
		return importantTime;
	}

	public void setImportantTime(java.sql.Timestamp importantTime) {
		this.importantTime = importantTime;
	}

	public Integer getIsImportant() {
		return isImportant;
	}

	public void setIsImportant(Integer isImportant) {
		this.isImportant = isImportant;
	}

	public String getRefuseMemo() {
		return refuseMemo;
	}

	public void setRefuseMemo(String refuseMemo) {
		this.refuseMemo = refuseMemo;
	}

	public String getAppPic() {
		return appPic;
	}

	public void setAppPic(String appPic) {
		this.appPic = appPic;
	}

	public Integer getEstateId() {
		return estateId;
	}

	public void setEstateId(Integer estateId) {
		this.estateId = estateId;
	}

	public String getPlanTime() {
		return planTime;
	}

	public void setPlanTime(String planTime) {
		this.planTime = planTime;
	}

	public BusinessActivityQuery(BusinessActivity businessActivity) {
		this.actId = businessActivity.getActId();
		this.typeId = businessActivity.getTypeId();
		this.actName = businessActivity.getActName();
		this.actContent = businessActivity.getActContent();
		this.typeName = businessActivity.getTypeName();
		this.actScope = businessActivity.getActScope();
		this.brief = businessActivity.getBrief();
		this.actPic = businessActivity.getActPic();
		this.actLink = businessActivity.getActLink();
		this.actManage = businessActivity.getActManage();
		this.userType = businessActivity.getUserType();
		this.publisherId = businessActivity.getPublisherId();
		this.publishDate = businessActivity.getPublishDate();
		this.publishTime = businessActivity.getPublishTime();
		this.startTime = businessActivity.getStartTime();
		this.endTime = businessActivity.getEndTime();
		this.rank = businessActivity.getRank();
		this.state = businessActivity.getState();
		this.auditorId = businessActivity.getAuditorId();
		this.auditorName = businessActivity.getAuditorName();
		this.auditTime = businessActivity.getAuditTime();
		this.visits = businessActivity.getVisits();
		this.comments = businessActivity.getComments();
		this.supports = businessActivity.getSupports();
		this.particpates = businessActivity.getParticpates();
		this.isComment = businessActivity.getIsComment();
		this.recommend = businessActivity.getRecommend();
		this.isPush = businessActivity.getIsPush();
		this.createTime = businessActivity.getCreateTime();
		this.editTime = businessActivity.getEditTime();
		this.editor = businessActivity.getEditor();
		this.appPic = businessActivity.getAppPic();
		this.isImportant = businessActivity.getIsImportant();
		this.refuseMemo = businessActivity.getRefuseMemo();
		this.importantTime = businessActivity.getImportantTime();
	}

	public BusinessActivityQuery() {
		
	}

	public String getStartActTime() {
		return startActTime;
	}

	public void setStartActTime(String startActTime) {
		this.startActTime = startActTime;
	}

	public String getEndActTime() {
		return endActTime;
	}

	public void setEndActTime(String endActTime) {
		this.endActTime = endActTime;
	}

	public String getTimeScope() {
		return timeScope;
	}

	public void setTimeScope(String timeScope) {
		this.timeScope = timeScope;
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

	public Integer getActId() {
		return this.actId;
	}

	public void setActId(Integer value) {
		this.actId = value;
	}

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer value) {
		this.typeId = value;
	}

	public String getActName() {
		return this.actName;
	}

	public void setActName(String value) {
		this.actName = value;
	}

	public String getActContent() {
		return this.actContent;
	}

	public void setActContent(String value) {
		this.actContent = value;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String value) {
		this.typeName = value;
	}

	public String getActScope() {
		return this.actScope;
	}

	public void setActScope(String value) {
		this.actScope = value;
	}

	public String getBrief() {
		return this.brief;
	}

	public void setBrief(String value) {
		this.brief = value;
	}

	public String getActPic() {
		return this.actPic;
	}

	public void setActPic(String value) {
		this.actPic = value;
	}

	public String getActLink() {
		return this.actLink;
	}

	public void setActLink(String value) {
		this.actLink = value;
	}

	public String getActManage() {
		return this.actManage;
	}

	public void setActManage(String value) {
		this.actManage = value;
	}

	public Integer getUserType() {
		return this.userType;
	}

	public void setUserType(Integer value) {
		this.userType = value;
	}

	public Integer getPublisherId() {
		return this.publisherId;
	}

	public void setPublisherId(Integer value) {
		this.publisherId = value;
	}

	public String getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(String value) {
		this.publishDate = value;
	}

	public String getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(String value) {
		this.publishTime = value;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String value) {
		this.startTime = value;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String value) {
		this.endTime = value;
	}

	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer value) {
		this.rank = value;
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

	public Integer getParticpates() {
		return this.particpates;
	}

	public void setParticpates(Integer value) {
		this.particpates = value;
	}

	public Integer getIsComment() {
		return this.isComment;
	}

	public void setIsComment(Integer value) {
		this.isComment = value;
	}

	public Integer getRecommend() {
		return this.recommend;
	}

	public void setRecommend(Integer value) {
		this.recommend = value;
	}

	public Integer getIsPush() {
		return this.isPush;
	}

	public void setIsPush(Integer value) {
		this.isPush = value;
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

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}