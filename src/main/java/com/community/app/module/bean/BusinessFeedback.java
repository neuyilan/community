package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.sql.Timestamp;

@SuppressWarnings("serial")
public class BusinessFeedback implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessFeedback";

	private java.lang.Integer feedbackId;
	private java.lang.String fbTitle;
	private java.lang.Integer fberId;
	private java.lang.String fberName;
	private java.sql.Timestamp fbTime;
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
	private java.lang.Integer expId;
	private java.lang.String logo;
	private java.lang.String expCompany;
	private java.lang.String expCode;
	private java.lang.Integer expType;
	private java.lang.String pics;
	private java.lang.String audios;
	private java.lang.String Time;
	
	private Integer estateId;
	private String estateName;
	
	private String  portrait; 
	private String address; 
	private Integer newsCount; // 统计的最新消息记录数
	
	private String nickname;
	private String tel;
	private String realname;
	
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

	public Integer getNewsCount() {
		return newsCount;
	}

	public void setNewsCount(Integer newsCount) {
		this.newsCount = newsCount;
	}

	public String getAddress() {
		return address == null ? "" : address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public Integer getEstateId() {
		return estateId;
	}

	public void setEstateId(Integer estateId) {
		this.estateId = estateId;
	}

	public String getEstateName() {
		return estateName == null?"":estateName;
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

	public java.lang.String getTime() {
		return Time == null?"":Time;
	}

	public void setTime(java.lang.String time) {
		Time = time;
	}

	public java.lang.String getAudios() {
		return  this.audios;
	}

	public void setAudios(java.lang.String audios) {
		this.audios = audios;
	}

	public java.lang.String getPics() {
		return pics;
	}

	public void setPics(java.lang.String pics) {
		this.pics = pics;
	}

	public java.lang.String getExpCode() {
		return expCode == null?"":expCode;
	}

	public void setExpCode(java.lang.String expCode) {
		this.expCode = expCode;
	}

	public java.lang.String getLogo() {
		return logo;
	}

	public void setLogo(java.lang.String logo) {
		this.logo = logo;
	}

	public java.lang.String getExpCompany() {
		return expCompany == null?"":expCompany;
	}

	public void setExpCompany(java.lang.String expCompany) {
		this.expCompany = expCompany;
	}

	public java.lang.Integer getExpType() {
		return expType;
	}

	public void setExpType(java.lang.Integer expType) {
		this.expType = expType;
	}

	public java.lang.Integer getExpId() {
		return expId;
	}

	public void setExpId(java.lang.Integer expId) {
		this.expId = expId;
	}

	public BusinessFeedback(){
	}

	public BusinessFeedback(
		java.lang.Integer feedbackId
	){
		this.feedbackId = feedbackId;
	}

	public void setFeedbackId(java.lang.Integer value) {
		this.feedbackId = value;
	}
	
	public java.lang.Integer getFeedbackId() {
		return this.feedbackId;
	}
	public void setFbTitle(java.lang.String value) {
		this.fbTitle = value;
	}
	
	public java.lang.String getFbTitle() {
		return this.fbTitle == null?"":this.fbTitle;
	}
	public void setFberId(java.lang.Integer value) {
		this.fberId = value;
	}
	
	public java.lang.Integer getFberId() {
		return this.fberId;
	}
	public void setFberName(java.lang.String value) {
		this.fberName = value;
	}
	
	public java.lang.String getFberName() {
		return this.fberName == null?"":this.fberName;
	}
	public void setFbTime(java.sql.Timestamp value) {
		this.fbTime = value;
	}
	
	public java.sql.Timestamp getFbTime() {
		return this.fbTime;
	}
	public void setFbContent(java.lang.String value) {
		this.fbContent = value;
	}
	
	public java.lang.String getFbContent() {
		return this.fbContent == null?"":this.fbContent;
	}
	public void setFbType(Integer value) {
		this.fbType = value;
	}
	
	public Integer getFbType() {
		return this.fbType;
	}
	public void setFbState(java.lang.Integer value) {
		this.fbState = value;
	}
	
	public java.lang.Integer getFbState() {
		return this.fbState;
	}
	public void setFbReplies(java.lang.Integer value) {
		this.fbReplies = value;
	}
	
	public java.lang.Integer getFbReplies() {
		return this.fbReplies;
	}
	public void setFbScore(Float value) {
		this.fbScore = value;
	}
	
	public Float getFbScore() {
		return this.fbScore;
	}
	public void setNewReplies(java.lang.Integer value) {
		this.newReplies = value;
	}
	
	public java.lang.Integer getNewReplies() {
		return this.newReplies;
	}
	public void setReceiverId(java.lang.Integer value) {
		this.receiverId = value;
	}
	
	public java.lang.Integer getReceiverId() {
		return this.receiverId;
	}
	public void setReceiverName(java.lang.String value) {
		this.receiverName = value;
	}
	
	public java.lang.String getReceiverName() {
		return this.receiverName == null?"":this.receiverName;
	}
	public void setReceiveAvatar(java.lang.String value) {
		this.receiveAvatar = value;
	}
	
	public java.lang.String getReceiveAvatar() {
		return this.receiveAvatar == null?"":this.receiveAvatar;
	}
	public void setReceiveDate(java.sql.Timestamp value) {
		this.receiveDate = value;
	}
	
	public java.sql.Timestamp getReceiveDate() {
		return this.receiveDate;
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
	public void setEditor(java.lang.String value) {
		this.editor = value;
	}
	
	public java.lang.String getEditor() {
		return this.editor == null?"":this.editor;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("FeedbackId",getFeedbackId())
			.append("FbTitle",getFbTitle())
			.append("FberId",getFberId())
			.append("FberName",getFberName())
			.append("FbTime",getFbTime())
			.append("FbContent",getFbContent())
			.append("FbType",getFbType())
			.append("FbState",getFbState())
			.append("FbReplies",getFbReplies())
			.append("FbScore",getFbScore())
			.append("NewReplies",getNewReplies())
			.append("ReceiverId",getReceiverId())
			.append("ReceiverName",getReceiverName())
			.append("ReceiveAvatar",getReceiveAvatar())
			.append("ReceiveDate",getReceiveDate())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getFeedbackId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessFeedback == false) return false;
		if(this == obj) return true;
		BusinessFeedback other = (BusinessFeedback)obj;
		return new EqualsBuilder()
			.append(getFeedbackId(),other.getFeedbackId())
			.isEquals();
	}
}