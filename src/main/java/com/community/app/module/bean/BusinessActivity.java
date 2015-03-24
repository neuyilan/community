package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessActivity implements java.io.Serializable {

	// 别名
	public static final String TABLE_ALIAS = "BusinessActivity";

	private Integer actId;
	private Integer typeId;
	private String actName;
	private String actContent;
	private String typeName;
	private String actScope;
	private String brief;
	private String actPic;
	private String actPicNo;
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
	private String editor;
	private String portrait;
	private String nickname;

	private Integer isImportant;
	private String refuseMemo;
	private java.sql.Timestamp importantTime;

	private Integer isTimingPush;
	private String timingPushconTent;
	private java.sql.Timestamp timingPushTime;
	private Integer times;
	private java.sql.Timestamp timingPublicTime;
	private String attributeValues;
	private Integer voteType;
	private Integer votes;
	private String content;
	private String image;

	private String actRegWords;
	private String prizeRules;
	private String couponName;
	private String couponDesc;
	private String couponImg;
	private Integer couponNum;
	private String couponStartDate;
	private String couponEndDate;
	private String couponValid;
	private String reportExcel;
	private String QNHActId;
	private String QNHName;
	private String QNHId;
	private String timeslot;
	private Integer isQNH;
	
	public String getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(String timeslot) {
		this.timeslot = timeslot;
	}

	public String getQNHActId() {
		return QNHActId;
	}

	public void setQNHActId(String qNHActId) {
		QNHActId = qNHActId;
	}

	public String getQNHName() {
		return QNHName;
	}

	public void setQNHName(String qNHName) {
		QNHName = qNHName;
	}

	public String getQNHId() {
		return QNHId;
	}

	public void setQNHId(String qNHId) {
		QNHId = qNHId;
	}

	public Integer getIsQNH() {
		return isQNH;
	}

	public void setIsQNH(Integer isQNH) {
		this.isQNH = isQNH;
	}

	public String getActPicNo() {
		return actPicNo;
	}

	public void setActPicNo(String actPicNo) {
		this.actPicNo = actPicNo;
	}

	public String getReportExcel() {
		return reportExcel;
	}

	public void setReportExcel(String reportExcel) {
		this.reportExcel = reportExcel;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public String getCouponDesc() {
		return couponDesc;
	}

	public void setCouponDesc(String couponDesc) {
		this.couponDesc = couponDesc;
	}

	public String getCouponImg() {
		return couponImg;
	}

	public void setCouponImg(String couponImg) {
		this.couponImg = couponImg;
	}

	public Integer getCouponNum() {
		return couponNum;
	}

	public void setCouponNum(Integer couponNum) {
		this.couponNum = couponNum;
	}

	public String getCouponStartDate() {
		return couponStartDate;
	}

	public void setCouponStartDate(String couponStartDate) {
		this.couponStartDate = couponStartDate;
	}

	public String getCouponEndDate() {
		return couponEndDate;
	}

	public void setCouponEndDate(String couponEndDate) {
		this.couponEndDate = couponEndDate;
	}

	public String getCouponValid() {
		return couponValid;
	}

	public void setCouponValid(String couponValid) {
		this.couponValid = couponValid;
	}

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

	private String appPic;

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

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public BusinessActivity() {
	}

	public BusinessActivity(Integer actId) {
		this.actId = actId;
	}

	public void setActId(Integer value) {
		this.actId = value;
	}

	public Integer getActId() {
		return this.actId;
	}

	public void setTypeId(Integer value) {
		this.typeId = value;
	}

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setActName(String value) {
		this.actName = value;
	}

	public String getActName() {
		return this.actName;
	}

	public void setActContent(String value) {
		this.actContent = value;
	}

	public String getActContent() {
		return this.actContent;
	}

	public void setTypeName(String value) {
		this.typeName = value;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setActScope(String value) {
		this.actScope = value;
	}

	public String getActScope() {
		return this.actScope;
	}

	public void setBrief(String value) {
		this.brief = value;
	}

	public String getBrief() {
		return this.brief;
	}

	public void setActPic(String value) {
		this.actPic = value;
	}

	public String getActPic() {
		return this.actPic;
	}

	public void setActLink(String value) {
		this.actLink = value;
	}

	public String getActLink() {
		return this.actLink;
	}

	public void setActManage(String value) {
		this.actManage = value;
	}

	public String getActManage() {
		return this.actManage;
	}

	public void setUserType(Integer value) {
		this.userType = value;
	}

	public Integer getUserType() {
		return this.userType;
	}

	public void setPublisherId(Integer value) {
		this.publisherId = value;
	}

	public Integer getPublisherId() {
		return this.publisherId;
	}

	public void setPublishDate(String value) {
		this.publishDate = value;
	}

	public String getPublishDate() {
		return this.publishDate;
	}

	public void setPublishTime(String value) {
		this.publishTime = value;
	}

	public String getPublishTime() {
		return this.publishTime;
	}

	public void setStartTime(String value) {
		this.startTime = value;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public void setEndTime(String value) {
		this.endTime = value;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setRank(Integer value) {
		this.rank = value;
	}

	public Integer getRank() {
		return this.rank;
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

	public void setParticpates(Integer value) {
		this.particpates = value;
	}

	public Integer getParticpates() {
		return this.particpates;
	}

	public void setIsComment(Integer value) {
		this.isComment = value;
	}

	public Integer getIsComment() {
		return this.isComment;
	}

	public void setRecommend(Integer value) {
		this.recommend = value;
	}

	public Integer getRecommend() {
		return this.recommend;
	}

	public void setIsPush(Integer value) {
		this.isPush = value;
	}

	public Integer getIsPush() {
		return this.isPush;
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

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("ActId", getActId()).append("TypeId", getTypeId())
				.append("ActName", getActName())
				.append("ActContent", getActContent())
				.append("TypeName", getTypeName())
				.append("ActScope", getActScope()).append("Brief", getBrief())
				.append("ActPic", getActPic()).append("ActLink", getActLink())
				.append("ActManage", getActManage())
				.append("UserType", getUserType())
				.append("PublisherId", getPublisherId())
				.append("PublishDate", getPublishDate())
				.append("PublishTime", getPublishTime())
				.append("StartTime", getStartTime())
				.append("EndTime", getEndTime()).append("Rank", getRank())
				.append("State", getState())
				.append("AuditorId", getAuditorId())
				.append("AuditorName", getAuditorName())
				.append("AuditTime", getAuditTime())
				.append("Visits", getVisits())
				.append("Comments", getComments())
				.append("Supports", getSupports())
				.append("Particpates", getParticpates())
				.append("IsComment", getIsComment())
				.append("Recommend", getRecommend())
				.append("IsPush", getIsPush())
				.append("CreateTime", getCreateTime())
				.append("EditTime", getEditTime())
				.append("actRegWords", getActRegWords())
				.append("prizeRules", getPrizeRules())
				.append("Editor", getEditor()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getActId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof BusinessActivity == false)
			return false;
		if (this == obj)
			return true;
		BusinessActivity other = (BusinessActivity) obj;
		return new EqualsBuilder().append(getActId(), other.getActId())
				.isEquals();
	}

	public String getActRegWords() {
		return actRegWords;
	}

	public void setActRegWords(String actRegWords) {
		this.actRegWords = actRegWords;
	}

	public String getPrizeRules() {
		return prizeRules;
	}

	public void setPrizeRules(String prizeRules) {
		this.prizeRules = prizeRules;
	}
}