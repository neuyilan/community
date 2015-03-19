package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessNews implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessNews";

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
	private String creater;
	private java.sql.Timestamp editTime;
	private String editor;
	private java.sql.Timestamp cancleTime;
	private String cancler;
	private Integer isPush;
	private Integer isRecommend;
	private String portrait;
	private Integer breakId;
	private java.sql.Timestamp hotTime;
	private String hoter;
	private java.sql.Timestamp hotTime1;
	private String nickname;
	private String buNickname;
	private String avatar;
	private Integer selectId;
	private Integer isNickname;
	private String tag;
	
	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public java.sql.Timestamp getCancleTime() {
		return cancleTime;
	}

	public void setCancleTime(java.sql.Timestamp cancleTime) {
		this.cancleTime = cancleTime;
	}

	public String getCancler() {
		return cancler;
	}

	public void setCancler(String cancler) {
		this.cancler = cancler;
	}

	public String getHoter() {
		return hoter;
	}

	public void setHoter(String hoter) {
		this.hoter = hoter;
	}

	public java.sql.Timestamp getHotTime1() {
		return hotTime1;
	}

	public void setHotTime1(java.sql.Timestamp hotTime1) {
		this.hotTime1 = hotTime1;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Integer getIsNickname() {
		return isNickname;
	}

	public void setIsNickname(Integer isNickname) {
		this.isNickname = isNickname;
	}

	public Integer getSelectId() {
		return selectId;
	}

	public void setSelectId(Integer selectId) {
		this.selectId = selectId;
	}

	public String getNickname() {
		return nickname == null?"":nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getBuNickname() {
		return buNickname == null?"":buNickname;
	}

	public void setBuNickname(String buNickname) {
		this.buNickname = buNickname;
	}

	public String getAvatar() {
		return avatar == null?"":avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public java.sql.Timestamp getHotTime() {
		return hotTime;
	}

	public void setHotTime(java.sql.Timestamp hotTime) {
		this.hotTime = hotTime;
	}

	public Integer getBreakId() {
		return breakId;
	}

	public void setBreakId(Integer breakId) {
		this.breakId = breakId;
	}

	public String getAppPic() {
		return appPic == null?"":appPic;
	}

	public void setAppPic(String appPic) {
		this.appPic = appPic;
	}

	public String getPortrait() {
		return portrait == null?"":portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public BusinessNews(){
	}

	public BusinessNews(
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
		return this.title == null?"":this.title;
	}
	public void setContent(String value) {
		this.content = value;
	}
	
	public String getContent() {
		return this.content == null?"":this.content;
	}
	public void setPageUrl(String value) {
		this.pageUrl = value;
	}
	
	public String getPageUrl() {
		return this.pageUrl == null?"":this.pageUrl;
	}
	public void setBrief(String value) {
		this.brief = value;
	}
	
	public String getBrief() {
		return this.brief == null?"":this.brief;
	}
	public void setSubjectPic(String value) {
		this.subjectPic = value;
	}
	
	public String getSubjectPic() {
		return this.subjectPic == null?"":this.subjectPic;
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
		return this.publisherName == null?"":this.publisherName;
	}
	public void setPublishTime(java.sql.Timestamp value) {
		this.publishTime = value;
	}
	
	public java.sql.Timestamp getPublishTime() {
		return this.publishTime;
	}

	public String getComName() {
		return comName == null?"":comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
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
		return this.auditorName == null?"":this.auditorName;
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
		return this.auditInfo == null?"":this.auditInfo;
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
		return this.setTime == null?"":this.setTime;
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
		return this.editor == null?"":this.editor;
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
			.append("breakId",getBreakId())
			.append("hotTime",getHotTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getNewsId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessNews == false) return false;
		if(this == obj) return true;
		BusinessNews other = (BusinessNews)obj;
		return new EqualsBuilder()
			.append(getNewsId(),other.getNewsId())
			.isEquals();
	}
}