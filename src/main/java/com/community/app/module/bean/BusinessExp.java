package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessExp implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessExp";

	private Integer expId=0;
	private Integer senderId=0;
	private String senderName="";
	private String expCode="";
	private String senderTel="";
	private String receiverName="";
	private String receiverTel="";
	private java.sql.Timestamp receiveTime;
	private String receiverAddr="";
	private java.sql.Timestamp sendTime;
	private String expContent="";
	private Integer expState=0;
	private java.sql.Timestamp checkInTime;
	private String senderAddr="";
	private Integer expType=0;
	private String station="";
	private Integer expCompanyID=0;
	private String expCompany="";
	private Integer isPay=0;
	private Float payMount;
	private Integer isAgent=0;
	private Float agentMount;
	private String memo="";
	private String getDate="";
	private Integer isAnytime=0;
	private String getTime="";
	private Integer appointType=0;
	private String appointContent="";
	private String signname="";
	private java.sql.Timestamp signTime;
	private Integer isSelf=0;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp modifyTime;
	private String editor="";
	private String logo="";
	private String lastMessage="";
	private String addrUrl="";
	private String code="";
	private Integer isVideo=0;
	
	private Integer isSigned;	
	private String returnMemo;
	
	private Integer receiverId;
	
	private Integer stationId;
	
	private Integer isDistributed;
	
	private String briefMessage;
	private Integer newsCount;
	private String realname;
	private String nickname;
	private String tel;
	private Integer flag;
	private Integer isProblem;
	private Integer estateId;
	private Integer phoneType;
	
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

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
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

	public Integer getNewsCount() {
		return newsCount;
	}

	public void setNewsCount(Integer newsCount) {
		this.newsCount = newsCount;
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

	public Integer getIsSigned() {
		return isSigned;
	}

	public void setIsSigned(Integer isSigned) {
		this.isSigned = isSigned;
	}

	public Integer getIsVideo() {
		return isVideo;
	}

	public void setIsVideo(Integer isVideo) {
		this.isVideo = isVideo;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAddrUrl() {
		return addrUrl;
	}

	public void setAddrUrl(String addrUrl) {
		this.addrUrl = addrUrl;
	}

	public String getLastMessage() {
		return lastMessage;
	}

	public void setLastMessage(String lastMessage) {
		this.lastMessage = lastMessage;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public BusinessExp(){
	}

	public BusinessExp(
		Integer expId
	){
		this.expId = expId;
	}

	public void setExpId(Integer value) {
		this.expId = value;
	}
	
	public Integer getExpId() {
		return this.expId;
	}
	public void setSenderId(Integer value) {
		this.senderId = value;
	}
	
	public Integer getSenderId() {
		return this.senderId;
	}
	public void setSenderName(String value) {
		this.senderName = value;
	}
	
	public String getSenderName() {
		return this.senderName;
	}
	public void setExpCode(String value) {
		this.expCode = value;
	}
	
	public String getExpCode() {
		return this.expCode;
	}
	public void setSenderTel(String value) {
		this.senderTel = value;
	}
	
	public String getSenderTel() {
		return this.senderTel;
	}
	public void setReceiverName(String value) {
		this.receiverName = value;
	}
	
	public String getReceiverName() {
		return this.receiverName;
	}
	public void setReceiverTel(String value) {
		this.receiverTel = value;
	}
	
	public String getReceiverTel() {
		return this.receiverTel;
	}
	public void setReceiveTime(java.sql.Timestamp value) {
		this.receiveTime = value;
	}
	
	public java.sql.Timestamp getReceiveTime() {
		return this.receiveTime;
	}
	public void setReceiverAddr(String value) {
		this.receiverAddr = value;
	}
	
	public String getReceiverAddr() {
		return this.receiverAddr;
	}
	public void setSendTime(java.sql.Timestamp value) {
		this.sendTime = value;
	}
	
	public java.sql.Timestamp getSendTime() {
		return this.sendTime;
	}
	public void setExpContent(String value) {
		this.expContent = value;
	}
	
	public String getExpContent() {
		return this.expContent;
	}
	public void setExpState(Integer value) {
		this.expState = value;
	}
	
	public Integer getExpState() {
		return this.expState;
	}
	public void setCheckInTime(java.sql.Timestamp value) {
		this.checkInTime = value;
	}
	
	public java.sql.Timestamp getCheckInTime() {
		return this.checkInTime;
	}
	public void setSenderAddr(String value) {
		this.senderAddr = value;
	}
	
	public String getSenderAddr() {
		return this.senderAddr;
	}
	public void setExpType(Integer value) {
		this.expType = value;
	}
	
	public Integer getExpType() {
		return this.expType;
	}
	public void setStation(String value) {
		this.station = value;
	}
	
	public String getStation() {
		return this.station;
	}
	public void setExpCompanyID(Integer value) {
		this.expCompanyID = value;
	}
	
	public Integer getExpCompanyID() {
		return this.expCompanyID;
	}
	public void setExpCompany(String value) {
		this.expCompany = value;
	}
	
	public String getExpCompany() {
		return this.expCompany;
	}
	public void setIsPay(Integer value) {
		this.isPay = value;
	}
	
	public Integer getIsPay() {
		return this.isPay;
	}
	public void setPayMount(Float value) {
		this.payMount = value;
	}
	
	public Float getPayMount() {
		return this.payMount;
	}
	public void setIsAgent(Integer value) {
		this.isAgent = value;
	}
	
	public Integer getIsAgent() {
		return this.isAgent;
	}
	public void setAgentMount(Float value) {
		this.agentMount = value;
	}
	
	public Float getAgentMount() {
		return this.agentMount;
	}
	public void setMemo(String value) {
		this.memo = value;
	}
	
	public String getMemo() {
		return this.memo;
	}
	public void setGetDate(String value) {
		this.getDate = value;
	}
	
	public String getGetDate() {
		return this.getDate;
	}
	public void setIsAnytime(Integer value) {
		this.isAnytime = value;
	}
	
	public Integer getIsAnytime() {
		return this.isAnytime;
	}
	public void setGetTime(String value) {
		this.getTime = value;
	}
	
	public String getGetTime() {
		return this.getTime;
	}
	public void setAppointType(Integer value) {
		this.appointType = value;
	}
	
	public Integer getAppointType() {
		return this.appointType;
	}
	public void setAppointContent(String value) {
		this.appointContent = value;
	}
	
	public String getAppointContent() {
		return this.appointContent;
	}
	public void setSignname(String value) {
		this.signname = value;
	}
	
	public String getSignname() {
		return this.signname;
	}
	public void setSignTime(java.sql.Timestamp value) {
		this.signTime = value;
	}
	
	public java.sql.Timestamp getSignTime() {
		return this.signTime;
	}
	public void setIsSelf(Integer value) {
		this.isSelf = value;
	}
	
	public Integer getIsSelf() {
		return this.isSelf;
	}
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
	
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	public void setModifyTime(java.sql.Timestamp value) {
		this.modifyTime = value;
	}
	
	public java.sql.Timestamp getModifyTime() {
		return this.modifyTime;
	}
	public void setEditor(String value) {
		this.editor = value;
	}
	
	public String getEditor() {
		return this.editor;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("ExpId",getExpId())
			.append("SenderId",getSenderId())
			.append("SenderName",getSenderName())
			.append("ExpCode",getExpCode())
			.append("SenderTel",getSenderTel())
			.append("ReceiverName",getReceiverName())
			.append("ReceiverTel",getReceiverTel())
			.append("ReceiveTime",getReceiveTime())
			.append("ReceiverAddr",getReceiverAddr())
			.append("SendTime",getSendTime())
			.append("ExpContent",getExpContent())
			.append("ExpState",getExpState())
			.append("CheckInTime",getCheckInTime())
			.append("SenderAddr",getSenderAddr())
			.append("ExpType",getExpType())
			.append("Station",getStation())
			.append("ExpCompanyId",getExpCompanyID())
			.append("ExpCompany",getExpCompany())
			.append("IsPay",getIsPay())
			.append("PayMount",getPayMount())
			.append("IsAgent",getIsAgent())
			.append("AgentMount",getAgentMount())
			.append("Memo",getMemo())
			.append("GetDate",getGetDate())
			.append("IsAnytime",getIsAnytime())
			.append("GetTime",getGetTime())
			.append("AppointType",getAppointType())
			.append("AppointContent",getAppointContent())
			.append("Signname",getSignname())
			.append("SignTime",getSignTime())
			.append("IsSelf",getIsSelf())
			.append("CreateTime",getCreateTime())
			.append("ModifyTime",getModifyTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getExpId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof BusinessExp)) return false;
		if(this == obj) return true;
		BusinessExp other = (BusinessExp)obj;
		return new EqualsBuilder()
			.append(getExpId(),other.getExpId())
			.isEquals();
	}
}

