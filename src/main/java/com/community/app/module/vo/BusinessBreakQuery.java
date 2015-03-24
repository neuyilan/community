package com.community.app.module.vo;

import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessBreak;

public class BusinessBreakQuery extends BaseBean {

	private java.lang.Integer breakId;
	private java.lang.Integer breakerId;
	private java.lang.String breakerName;
	private java.lang.String breakContent;
	private java.sql.Timestamp breakTime;
	private java.lang.Integer breakType;
	private java.lang.String comId;
	private java.lang.String comName;
	private java.lang.Integer state;
	private java.lang.Integer isUsed;
	private java.lang.Integer selectedNum;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.Integer userId;
	private java.lang.Integer type;
	private java.lang.String picUrl;

	private java.lang.Integer comments;
	private java.sql.Timestamp lastCommentTime;
	private String address;
	private java.lang.Integer picCount;
	private String tel;
	
	private String timeScope;
	private String startTime;
	private String endTime;
	private String orderBy;
	private String keyWord;
	private String content;
	private java.lang.Integer ID;
	private Map<String,String> param;
	private Map<String,String> image;
	private Map<String,String> audio;
	private java.lang.Integer estateId;
	private Integer isNickname;

	private Integer curUserId;//当前用户ID
	private String curOrgType;//当前部门类型
	private Integer curComId;//当前社区ID
	
	private Integer curEstateId;
	private Integer newsCount;
	
	public Integer getNewsCount() {
		return newsCount;
	}

	public void setNewsCount(Integer newsCount) {
		this.newsCount = newsCount;
	}

	public java.lang.String getComName() {
		return comName;
	}

	public void setComName(java.lang.String comName) {
		this.comName = comName;
	}

	public Integer getCurEstateId() {
		return curEstateId;
	}

	public void setCurEstateId(Integer curEstateId) {
		this.curEstateId = curEstateId;
	}

	public Integer getIsNickname() {
		return isNickname;
	}

	public void setIsNickname(Integer isNickname) {
		this.isNickname = isNickname;
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

	public java.lang.Integer getEstateId() {
		return estateId;
	}

	public void setEstateId(java.lang.Integer estateId) {
		this.estateId = estateId;
	}

	public java.lang.Integer getPicCount() {
		return picCount;
	}

	public void setPicCount(java.lang.Integer picCount) {
		this.picCount = picCount;
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

	public Map<String, String> getAudio() {
		return audio;
	}

	public void setAudio(Map<String, String> audio) {
		this.audio = audio;
	}

	public java.lang.Integer getComments() {
		return comments;
	}

	public void setComments(java.lang.Integer comments) {
		this.comments = comments;
	}

	public java.sql.Timestamp getLastCommentTime() {
		return lastCommentTime;
	}

	public void setLastCommentTime(java.sql.Timestamp lastCommentTime) {
		this.lastCommentTime = lastCommentTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public java.lang.Integer getID() {
		return ID;
	}

	public void setID(java.lang.Integer iD) {
		ID = iD;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public java.lang.String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(java.lang.String picUrl) {
		this.picUrl = picUrl;
	}

	public java.lang.Integer getUserId() {
		return userId;
	}

	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	public java.lang.Integer getType() {
		return type;
	}

	public void setType(java.lang.Integer type) {
		this.type = type;
	}

	public BusinessBreakQuery(BusinessBreak businessBreak) {
		this.breakId = businessBreak.getBreakId();
		this.breakerId = businessBreak.getBreakerId();
		this.breakerName = businessBreak.getBreakerName();
		this.breakContent = businessBreak.getBreakContent();
		this.breakTime = businessBreak.getBreakTime();
		this.breakType = businessBreak.getBreakType();
		this.comId = businessBreak.getComId();
		this.state = businessBreak.getState();
		this.isUsed = businessBreak.getIsUsed();
		this.selectedNum = businessBreak.getSelectedNum();
		this.createTime = businessBreak.getCreateTime();
		this.editTime = businessBreak.getEditTime();
		this.editor = businessBreak.getEditor();
		this.address = businessBreak.getAddress();
		this.tel = businessBreak.getTel();
		this.comments = businessBreak.getComments();
		this.lastCommentTime = businessBreak.getLastCommentTime();
		this.picCount = businessBreak.getPicCount();
	}
	
	public BusinessBreakQuery() {
		
	}	
	
	public java.lang.Integer getBreakId() {
		return this.breakId;
	}
	
	public void setBreakId(java.lang.Integer value) {
		this.breakId = value;
	}
		
	public java.lang.Integer getBreakerId() {
		return this.breakerId;
	}
	
	public void setBreakerId(java.lang.Integer value) {
		this.breakerId = value;
	}
		
	public java.lang.String getBreakerName() {
		return this.breakerName;
	}
	
	public void setBreakerName(java.lang.String value) {
		this.breakerName = value;
	}
		
	public java.lang.String getBreakContent() {
		return this.breakContent;
	}
	
	public void setBreakContent(java.lang.String value) {
		this.breakContent = value;
	}
		
	public java.sql.Timestamp getBreakTime() {
		return this.breakTime;
	}
	
	public void setBreakTime(java.sql.Timestamp value) {
		this.breakTime = value;
	}
		
	public java.lang.Integer getBreakType() {
		return this.breakType;
	}
	
	public void setBreakType(java.lang.Integer value) {
		this.breakType = value;
	}
		
	public java.lang.String getComId() {
		return this.comId;
	}
	
	public void setComId(java.lang.String value) {
		this.comId = value;
	}
		
	public java.lang.Integer getState() {
		return this.state;
	}
	
	public void setState(java.lang.Integer value) {
		this.state = value;
	}
		
	public java.lang.Integer getIsUsed() {
		return this.isUsed;
	}
	
	public void setIsUsed(java.lang.Integer value) {
		this.isUsed = value;
	}
		
	public java.lang.Integer getSelectedNum() {
		return this.selectedNum;
	}
	
	public void setSelectedNum(java.lang.Integer value) {
		this.selectedNum = value;
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