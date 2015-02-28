package com.community.app.module.vo;

import java.sql.Timestamp;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessRepair;

public class BusinessRepairQuery extends BaseBean {
	
	private java.lang.Integer repairId;
	private java.lang.Integer propertyId;
	private java.lang.Integer reporterId;
	private String repairTime;
	private java.lang.String repairContent;
	private Integer repairType;
	private java.lang.Integer repairState;
	private Float repairScore;
	private java.lang.Integer repairReplies;
	private java.lang.Integer newReplies;
	private java.lang.Integer receiverId;
	private java.lang.String receiverName;
	private java.lang.String receiveAvatar;
	private java.sql.Timestamp receiveDate;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private Integer typeId;
	
	private String reporterName;
	private Timestamp lastCommentTime;
	
	private Integer estateId;
	private String estateName;
	
	private String timeScope;
	private String startTime;
	private String endTime;
	private String orderBy;
	private String keyWord;
	private java.lang.Integer userId;
	private java.lang.Integer type;
	private java.lang.Integer ID;
	private float evaluationGrade;
	private java.lang.Integer ifTheSolution;
	private String content;
	private Map<String,String> param;
	private Map<String,String> image;
	private Map<String,String> audio;
	private Integer curUserId;
	private Integer curEstateId;
	private String orgType;
	
	private String nickname;
	private String tel;
	private String realname;
	private Integer curComId;
	
	public Integer getCurComId() {
		return curComId;
	}

	public void setCurComId(Integer curComId) {
		this.curComId = curComId;
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

	public Integer getCurUserId() {
		return curUserId;
	}

	public void setCurUserId(Integer curUserId) {
		this.curUserId = curUserId;
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

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
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

	public java.lang.Integer getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(java.lang.Integer propertyId) {
		this.propertyId = propertyId;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public java.lang.Integer getID() {
		return ID;
	}

	public void setID(java.lang.Integer iD) {
		ID = iD;
	}

	public float getEvaluationGrade() {
		return evaluationGrade;
	}

	public void setEvaluationGrade(float evaluationGrade) {
		this.evaluationGrade = evaluationGrade;
	}

	public java.lang.Integer getIfTheSolution() {
		return ifTheSolution;
	}

	public void setIfTheSolution(java.lang.Integer ifTheSolution) {
		this.ifTheSolution = ifTheSolution;
	}

	public java.lang.Integer getType() {
		return type;
	}

	public void setType(java.lang.Integer type) {
		this.type = type;
	}

	public java.lang.Integer getUserId() {
		return userId;
	}

	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	public BusinessRepairQuery(BusinessRepair businessRepair) {
		this.repairId = businessRepair.getRepairId();
		this.reporterId = businessRepair.getReporterId();
		this.repairTime = businessRepair.getRepairTime().toLocaleString();
		this.repairContent = businessRepair.getRepairContent();
		this.repairType = businessRepair.getRepairType();
		this.repairState = businessRepair.getRepairState();
		this.repairScore = businessRepair.getRepairScore();
		this.repairReplies = businessRepair.getRepairReplies();
		this.newReplies = businessRepair.getNewReplies();
		this.receiverId = businessRepair.getReceiverId();
		this.receiverName = businessRepair.getReceiverName();
		this.receiveAvatar = businessRepair.getReceiveAvatar();
		this.receiveDate = businessRepair.getReceiveDate();
		this.createTime = businessRepair.getCreateTime();
		this.editTime = businessRepair.getEditTime();
		this.editor = businessRepair.getEditor();
		this.reporterName = businessRepair.getReporterName();
		this.lastCommentTime = businessRepair.getLastCommentTime();
		this.estateId = businessRepair.getEstateId();
		this.estateName = businessRepair.getEstateName();
		this.typeId = businessRepair.getTypeId();
		this.realname = businessRepair.getRealname();
		this.nickname = businessRepair.getNickname();
		this.tel = businessRepair.getTel();
	}
	
	public BusinessRepairQuery() {
		
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

	public String getReporterName() {
		return reporterName;
	}

	public void setReporterName(String reporterName) {
		this.reporterName = reporterName;
	}

	public Timestamp getLastCommentTime() {
		return lastCommentTime;
	}

	public void setLastCommentTime(Timestamp lastCommentTime) {
		this.lastCommentTime = lastCommentTime;
	}

	public java.lang.Integer getRepairId() {
		return this.repairId;
	}
	
	public void setRepairId(java.lang.Integer value) {
		this.repairId = value;
	}
		
	public java.lang.Integer getReporterId() {
		return this.reporterId;
	}
	
	public void setReporterId(java.lang.Integer value) {
		this.reporterId = value;
	}
		
	public String getRepairTime() {
		return this.repairTime;
	}
	
	public void setRepairTime(String value) {
		this.repairTime = value;
	}
		
	public java.lang.String getRepairContent() {
		return this.repairContent;
	}
	
	public void setRepairContent(java.lang.String value) {
		this.repairContent = value;
	}
		
	public Integer getRepairType() {
		return this.repairType;
	}
	
	public void setRepairType(Integer value) {
		this.repairType = value;
	}
		
	public java.lang.Integer getRepairState() {
		return this.repairState;
	}
	
	public void setRepairState(java.lang.Integer value) {
		this.repairState = value;
	}
		
	public Float getRepairScore() {
		return this.repairScore;
	}
	
	public void setRepairScore(Float value) {
		this.repairScore = value;
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

	public java.lang.Integer getRepairReplies() {
		return repairReplies;
	}

	public void setRepairReplies(java.lang.Integer repairReplies) {
		this.repairReplies = repairReplies;
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

	public String getTimeScope() {
		return timeScope;
	}

	public void setTimeScope(String timeScope) {
		this.timeScope = timeScope;
	}
	
}

