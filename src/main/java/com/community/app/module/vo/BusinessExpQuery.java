package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Map;

import com.community.app.module.bean.BusinessExp;
import com.community.app.module.vo.BaseBean;

public class BusinessExpQuery extends BaseBean {
	

	private Integer expId;
	private Integer senderId;
	private String senderName;
	private String expCode;
	private String senderTel;
	private String receiverName;
	private String receiverTel;
	private java.sql.Timestamp receiveTime;
	private String receiverAddr;
	private java.sql.Timestamp sendTime;
	private String expContent;
	private Integer expState;
	private java.sql.Timestamp checkInTime;
	private String senderAddr;
	private Integer expType;
	private String station;
	private Integer expCompanyID;
	private String expCompany;
	private Integer isPay;
	private Float payMount;
	private Integer isAgent;
	private Float agentMount;
	private String memo;
	private String getDate;
	private Integer isAnytime;
	private String getTime;
	private Integer appointType;
	private String appointContent;
	private String signname;
	private java.sql.Timestamp signTime;
	private Integer isSelf;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp modifyTime;
	private String editor;
	
	private String timeScope;
	private String startTime;
	private String endTime;
	private String orderBy;
	private String keyWord;
	private Integer userId;
	private String tel;
	private String address;
	private Integer expressId;
	private String timeGap;
	private Integer type;
	private Integer ID;
	private Map<String,String> param;
	private Map<String,String> image;
	private Map<String,String> audio;
	
	private String anyTime;
	private Integer isSigned;
	private String code;
	private String returnMemo;
	private Integer receiverId;
	
	private String lastMessage;
	private Integer stationId;
	private Integer isDistributed;
	private Integer taskUpdateState;
	
	private String  briefMessage;
	private String  orderCode;
	
	private Integer curUserId;
	private String[] expStates;
	private Integer curEstateId;
	private Integer isVideo;
	private Integer flag;
	private Integer isProblem;
	private Integer estateId;
	private Integer phoneType;
	private String expIds;
	private String[] expIdArray;
	
	public String[] getExpIdArray() {
		return expIdArray;
	}

	public void setExpIdArray(String[] expIdArray) {
		this.expIdArray = expIdArray;
	}

	public String getExpIds() {
		return expIds;
	}

	public void setExpIds(String expIds) {
		this.expIds = expIds;
	}

	public Integer getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(Integer phoneType) {
		this.phoneType = phoneType;
	}

	public Integer getEstateId() {
		return estateId;
	}

	public void setEstateId(Integer estateId) {
		this.estateId = estateId;
	}
	public Integer getIsProblem() {
		return isProblem;
	}

	public void setIsProblem(Integer isProblem) {
		this.isProblem = isProblem;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getIsVideo() {
		return isVideo;
	}

	public void setIsVideo(Integer isVideo) {
		this.isVideo = isVideo;
	}

	public Integer getCurEstateId() {
		return curEstateId;
	}

	public void setCurEstateId(Integer curEstateId) {
		this.curEstateId = curEstateId;
	}

	public String[] getExpStates() {
		return expStates;
	}

	public void setExpStates(String[] expStates) {
		this.expStates = expStates;
	}

	public Integer getCurUserId() {
		return curUserId;
	}

	public void setCurUserId(Integer curUserId) {
		this.curUserId = curUserId;
	}

	public Integer getTaskUpdateState() {
		return taskUpdateState;
	}

	public void setTaskUpdateState(Integer taskUpdateState) {
		this.taskUpdateState = taskUpdateState;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getBriefMessage() {
		return briefMessage;
	}

	public void setBriefMessage(String briefMessage) {
		this.briefMessage = briefMessage;
	}

	public Integer getIsDistributed() {
		return isDistributed;
	}

	public void setIsDistributed(Integer isDistributed) {
		this.isDistributed = isDistributed;
	}

	public String getLastMessage() {
		return lastMessage;
	}

	public void setLastMessage(String lastMessage) {
		this.lastMessage = lastMessage;
	}

	public Integer getStationId() {
		return stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

	public Integer getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Integer receiverId) {
		this.receiverId = receiverId;
	}

	public String getReturnMemo() {
		return returnMemo;
	}

	public void setReturnMemo(String returnMemo) {
		this.returnMemo = returnMemo;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAnyTime() {
		return anyTime;
	}

	public void setAnyTime(String anyTime) {
		this.anyTime = anyTime;
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

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTimeGap() {
		return timeGap;
	}

	public void setTimeGap(String timeGap) {
		this.timeGap = timeGap;
	}

	public Integer getExpressId() {
		return expressId;
	}

	public void setExpressId(Integer expressId) {
		this.expressId = expressId;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public BusinessExpQuery(BusinessExp businessExp) {
		this.expId = businessExp.getExpId();
		this.senderId = businessExp.getSenderId();
		this.senderName = businessExp.getSenderName();
		this.expCode = businessExp.getExpCode();
		this.senderTel = businessExp.getSenderTel();
		this.receiverName = businessExp.getReceiverName();
		this.receiverTel = businessExp.getReceiverTel();
		this.receiveTime = businessExp.getReceiveTime();
		this.receiverAddr = businessExp.getReceiverAddr();
		this.sendTime = businessExp.getSendTime();
		this.expContent = businessExp.getExpContent();
		this.expState = businessExp.getExpState();
		this.checkInTime = businessExp.getCheckInTime();
		this.senderAddr = businessExp.getSenderAddr();
		this.expType = businessExp.getExpType();
		this.station = businessExp.getStation();
		this.expCompanyID = businessExp.getExpCompanyID();
		this.expCompany = businessExp.getExpCompany();
		this.isPay = businessExp.getIsPay();
		this.payMount = businessExp.getPayMount();
		this.isAgent = businessExp.getIsAgent();
		this.agentMount = businessExp.getAgentMount();
		this.memo = businessExp.getMemo();
		this.getDate = businessExp.getGetDate();
		this.isAnytime = businessExp.getIsAnytime();
		this.getTime = businessExp.getGetTime();
		this.appointType = businessExp.getAppointType();
		this.appointContent = businessExp.getAppointContent();
		this.signname = businessExp.getSignname();
		this.signTime = businessExp.getSignTime();
		this.isSelf = businessExp.getIsSelf();
		this.createTime = businessExp.getCreateTime();
		this.modifyTime = businessExp.getModifyTime();
		this.editor = businessExp.getEditor();
		this.isSigned = businessExp.getIsSigned();
		this.returnMemo = businessExp.getReturnMemo();
		this.lastMessage = businessExp.getLastMessage();
		this.stationId = businessExp.getStationId();
		this.isDistributed = businessExp.getIsDistributed();
		this.isProblem = businessExp.getIsProblem();
	}
	
	public Integer getIsSigned() {
		return isSigned;
	}

	public void setIsSigned(Integer isSigned) {
		this.isSigned = isSigned;
	}

	public BusinessExpQuery() {
		
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

	public Integer getExpId() {
		return this.expId;
	}
	
	public void setExpId(Integer value) {
		this.expId = value;
	}
		
	public Integer getSenderId() {
		return this.senderId;
	}
	
	public void setSenderId(Integer value) {
		this.senderId = value;
	}
		
	public String getSenderName() {
		return this.senderName;
	}
	
	public void setSenderName(String value) {
		this.senderName = value;
	}
		
	public String getExpCode() {
		return this.expCode;
	}
	
	public void setExpCode(String value) {
		this.expCode = value;
	}
		
	public String getSenderTel() {
		return this.senderTel;
	}
	
	public void setSenderTel(String value) {
		this.senderTel = value;
	}
		
	public String getReceiverName() {
		return this.receiverName;
	}
	
	public void setReceiverName(String value) {
		this.receiverName = value;
	}
		
	public String getReceiverTel() {
		return this.receiverTel;
	}
	
	public void setReceiverTel(String value) {
		this.receiverTel = value;
	}
		
	public java.sql.Timestamp getReceiveTime() {
		return this.receiveTime;
	}
	
	public void setReceiveTime(java.sql.Timestamp value) {
		this.receiveTime = value;
	}
		
	public String getReceiverAddr() {
		return this.receiverAddr;
	}
	
	public void setReceiverAddr(String value) {
		this.receiverAddr = value;
	}
		
	public java.sql.Timestamp getSendTime() {
		return this.sendTime;
	}
	
	public void setSendTime(java.sql.Timestamp value) {
		this.sendTime = value;
	}
		
	public String getExpContent() {
		return this.expContent;
	}
	
	public void setExpContent(String value) {
		this.expContent = value;
	}
		
	public Integer getExpState() {
		return this.expState;
	}
	
	public void setExpState(Integer value) {
		this.expState = value;
	}
		
	public java.sql.Timestamp getCheckInTime() {
		return this.checkInTime;
	}
	
	public void setCheckInTime(java.sql.Timestamp value) {
		this.checkInTime = value;
	}
		
	public String getSenderAddr() {
		return this.senderAddr;
	}
	
	public void setSenderAddr(String value) {
		this.senderAddr = value;
	}
		
	public Integer getExpType() {
		return this.expType;
	}
	
	public void setExpType(Integer value) {
		this.expType = value;
	}
		
	public String getStation() {
		return this.station;
	}
	
	public void setStation(String value) {
		this.station = value;
	}
		
	public Integer getExpCompanyID() {
		return this.expCompanyID;
	}
	
	public void setExpCompanyID(Integer value) {
		this.expCompanyID = value;
	}
		
	public String getExpCompany() {
		return this.expCompany;
	}
	
	public void setExpCompany(String value) {
		this.expCompany = value;
	}
		
	public Integer getIsPay() {
		return this.isPay;
	}
	
	public void setIsPay(Integer value) {
		this.isPay = value;
	}
		
	public Float getPayMount() {
		return this.payMount;
	}
	
	public void setPayMount(Float value) {
		this.payMount = value;
	}
		
	public Integer getIsAgent() {
		return this.isAgent;
	}
	
	public void setIsAgent(Integer value) {
		this.isAgent = value;
	}
		
	public Float getAgentMount() {
		return this.agentMount;
	}
	
	public void setAgentMount(Float value) {
		this.agentMount = value;
	}
		
	public String getMemo() {
		return this.memo;
	}
	
	public void setMemo(String value) {
		this.memo = value;
	}
		
	public String getGetDate() {
		return this.getDate;
	}
	
	public void setGetDate(String value) {
		this.getDate = value;
	}
		
	public Integer getIsAnytime() {
		return this.isAnytime;
	}
	
	public void setIsAnytime(Integer value) {
		this.isAnytime = value;
	}
		
	public String getGetTime() {
		return this.getTime;
	}
	
	public void setGetTime(String value) {
		this.getTime = value;
	}
		
	public Integer getAppointType() {
		return this.appointType;
	}
	
	public void setAppointType(Integer value) {
		this.appointType = value;
	}
		
	public String getAppointContent() {
		return this.appointContent;
	}
	
	public void setAppointContent(String value) {
		this.appointContent = value;
	}
		
	public String getSignname() {
		return this.signname;
	}
	
	public void setSignname(String value) {
		this.signname = value;
	}
		
	public java.sql.Timestamp getSignTime() {
		return this.signTime;
	}
	
	public void setSignTime(java.sql.Timestamp value) {
		this.signTime = value;
	}
		
	public Integer getIsSelf() {
		return this.isSelf;
	}
	
	public void setIsSelf(Integer value) {
		this.isSelf = value;
	}
		
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
		
	public java.sql.Timestamp getModifyTime() {
		return this.modifyTime;
	}
	
	public void setModifyTime(java.sql.Timestamp value) {
		this.modifyTime = value;
	}
		
	public String getEditor() {
		return this.editor;
	}
	
	public void setEditor(String value) {
		this.editor = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

