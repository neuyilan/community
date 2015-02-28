package com.community.app.module.vo;

import java.sql.Timestamp;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessFeedback;

public class BusinessFeedbackQuery extends BaseBean {
	

	private java.lang.Integer feedbackId;
	private java.lang.String fbTitle;
	private java.lang.Integer fberId;
	private java.lang.String fberName;
	private String fbTime;
	private java.lang.String fbContent;
	private Integer fbType;
	private java.lang.Integer fbState;
	private java.lang.Integer fbReplies;
	private Timestamp lastCommentTime;
	private Float fbScore;
	private java.lang.Integer newReplies;
	private java.lang.Integer receiverId;
	private java.lang.String receiverName;
	private java.lang.String receiveAvatar;
	private java.sql.Timestamp receiveDate;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private String startFbTime;
	private String endFbTime;
	private String orderBy;
	private String keyWord;
	private Integer type;
	private Integer userId;
	private Integer ID;
	private float evaluationGrade;
	private Integer ifTheSolution;
	
	private String nickname;
	private String tel;
	private String realname;

	private Integer estateId;
	private String estateName;
	
	private String timeScope;
	private String startTime;
	private String endTime;
	private java.lang.String content;
	private Map<String,String> param;
	private Map<String,String> image;
	private Map<String,String> audio;
	
	private Integer curUserId;
	private Integer curEstateId;
	private String orgType;
	private Integer[] fbTypes;
	
	private Integer curComId;
	
	
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

	public Integer[] getFbTypes() {
		return fbTypes;
	}

	public void setFbTypes(Integer[] fbTypes) {
		this.fbTypes = fbTypes;
	}

	public Integer getCurEstateId() {
		return curEstateId;
	}

	public void setCurEstateId(Integer curEstateId) {
		this.curEstateId = curEstateId;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
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

	public java.lang.String getContent() {
		return content;
	}

	public void setContent(java.lang.String content) {
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

	public Integer getEstateId() {
		return estateId;
	}

	public void setEstateId(Integer estateId) {
		this.estateId = estateId;
	}

	public String getEstateName() {
		return estateName;
	}

	public void setEstateName(String estateName) {
		this.estateName = estateName;
	}

	public Timestamp getLastCommentTime() {
		return lastCommentTime;
	}

	public void setLastCommentTime(Timestamp lastCommentTime) {
		this.lastCommentTime = lastCommentTime;
	}

	public float getEvaluationGrade() {
		return evaluationGrade;
	}

	public void setEvaluationGrade(float evaluationGrade) {
		this.evaluationGrade = evaluationGrade;
	}

	public Integer getIfTheSolution() {
		return ifTheSolution;
	}

	public void setIfTheSolution(Integer ifTheSolution) {
		this.ifTheSolution = ifTheSolution;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public BusinessFeedbackQuery(BusinessFeedback businessFeedback) {
		this.feedbackId = businessFeedback.getFeedbackId();
		this.fbTitle = businessFeedback.getFbTitle();
		this.fberId = businessFeedback.getFberId();
		this.fberName = businessFeedback.getFberName();
		this.fbTime = businessFeedback.getFbTime().toLocaleString();
		this.fbContent = businessFeedback.getFbContent();
		this.fbType = businessFeedback.getFbType();
		this.fbState = businessFeedback.getFbState();
		this.fbReplies = businessFeedback.getFbReplies();
		this.fbScore = businessFeedback.getFbScore();
		this.newReplies = businessFeedback.getNewReplies();
		this.receiverId = businessFeedback.getReceiverId();
		this.receiverName = businessFeedback.getReceiverName();
		this.receiveAvatar = businessFeedback.getReceiveAvatar();
		this.receiveDate = businessFeedback.getReceiveDate();
		this.createTime = businessFeedback.getCreateTime();
		this.editTime = businessFeedback.getEditTime();
		this.editor = businessFeedback.getEditor();
		this.lastCommentTime = businessFeedback.getLastCommentTime();
		this.estateId = businessFeedback.getEstateId();
		this.estateName = businessFeedback.getEstateName();
		this.nickname = businessFeedback.getNickname();
		this.realname = businessFeedback.getRealname();
		this.tel = businessFeedback.getTel();
	}
	
	public BusinessFeedbackQuery() {
		
	}	
	
	public java.lang.Integer getFeedbackId() {
		return this.feedbackId;
	}
	
	public void setFeedbackId(java.lang.Integer value) {
		this.feedbackId = value;
	}
		
	public java.lang.String getFbTitle() {
		return this.fbTitle;
	}
	
	public void setFbTitle(java.lang.String value) {
		this.fbTitle = value;
	}
		
	public java.lang.Integer getFberId() {
		return this.fberId;
	}
	
	public void setFberId(java.lang.Integer value) {
		this.fberId = value;
	}
		
	public java.lang.String getFberName() {
		return this.fberName;
	}
	
	public void setFberName(java.lang.String value) {
		this.fberName = value;
	}
		
	public String getFbTime() {
		return this.fbTime;
	}
	
	public void setFbTime(String value) {
		this.fbTime = value;
	}
		
	public java.lang.String getFbContent() {
		return this.fbContent;
	}
	
	public void setFbContent(java.lang.String value) {
		this.fbContent = value;
	}
		
	public Integer getFbType() {
		return this.fbType;
	}
	
	public void setFbType(Integer value) {
		this.fbType = value;
	}
		
	public java.lang.Integer getFbState() {
		return this.fbState;
	}
	
	public void setFbState(java.lang.Integer value) {
		this.fbState = value;
	}
		
	public java.lang.Integer getFbReplies() {
		return this.fbReplies;
	}
	
	public void setFbReplies(java.lang.Integer value) {
		this.fbReplies = value;
	}
		
	public Float getFbScore() {
		return this.fbScore;
	}
	
	public void setFbScore(Float value) {
		this.fbScore = value;
	}
		
	public java.lang.Integer getNewReplies() {
		return this.newReplies;
	}
	
	public void setNewReplies(java.lang.Integer value) {
		this.newReplies = value;
	}
		
	public java.lang.Integer getReceiverId() {
		return this.receiverId;
	}
	
	public void setReceiverId(java.lang.Integer value) {
		this.receiverId = value;
	}
		
	public java.lang.String getReceiverName() {
		return this.receiverName;
	}
	
	public void setReceiverName(java.lang.String value) {
		this.receiverName = value;
	}
		
	public java.lang.String getReceiveAvatar() {
		return this.receiveAvatar;
	}
	
	public void setReceiveAvatar(java.lang.String value) {
		this.receiveAvatar = value;
	}
		
	public java.sql.Timestamp getReceiveDate() {
		return this.receiveDate;
	}
	
	public void setReceiveDate(java.sql.Timestamp value) {
		this.receiveDate = value;
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

	public String getStartFbTime() {
		return startFbTime;
	}

	public void setStartFbTime(String Fb) {
		this.startFbTime = startFbTime;
	}

	public String getEndFbTime() {
		return endFbTime;
	}

	public void setEndFbTime(String endFbTime) {
		this.endFbTime = endFbTime;
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
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}
}