package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.sql.Timestamp;

@SuppressWarnings("serial")
public class BusinessRepair implements java.io.Serializable {

	// 别名
	public static final String TABLE_ALIAS = "BusinessRepair";

	private java.lang.Integer repairId;
	private java.lang.Integer reporterId;
	private java.sql.Timestamp repairTime;
	private java.lang.String repairContent;
	private Integer repairType;
	private java.lang.Integer repairState;
	private Float repairScore;
	private Integer repairReplies;
	private java.lang.Integer newReplies;
	private java.lang.Integer receiverId;
	private java.lang.String receiverName;
	private java.lang.String receiveAvatar;
	private java.sql.Timestamp receiveDate;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.Integer typeId;
	private java.lang.String typeName;
	private java.lang.String pics;
	private java.lang.String audios;
	private java.lang.String time;

	private String reporterName;
	private Timestamp lastCommentTime;
	private Integer estateId;
	private String estateName;
	private String portrait;
	private String address;
	private Integer newsCount;
	
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

	public String getReporterName() {
		return reporterName == null ? "" : reporterName;
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

	public Integer getEstateId() {
		return estateId;
	}

	public void setEstateId(Integer estateId) {
		this.estateId = estateId;
	}

	public String getEstateName() {
		return estateName == null ? "" : estateName;
	}

	public void setEstateName(String estateName) {
		this.estateName = estateName;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public String getAddress() {
		return address == null ? "" : address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static String getTableAlias() {
		return TABLE_ALIAS;
	}

	public java.lang.String getPics() {
		return pics;
	}

	public void setPics(java.lang.String pics) {
		this.pics = pics;
	}

	public java.lang.String getTime() {
		return time;
	}

	public void setTime(java.lang.String time) {
		this.time = time;
	}

	public java.lang.String getAudios() {
		return audios;
	}

	public void setAudios(java.lang.String audios) {
		this.audios = audios;
	}

	public java.lang.Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(java.lang.Integer typeId) {
		this.typeId = typeId;
	}

	public java.lang.String getTypeName() {
		return typeName == null ? "" : typeName;
	}

	public void setTypeName(java.lang.String typeName) {
		this.typeName = typeName;
	}

	public BusinessRepair() {
	}

	public BusinessRepair(java.lang.Integer repairId) {
		this.repairId = repairId;
	}

	public void setRepairId(java.lang.Integer value) {
		this.repairId = value;
	}

	public java.lang.Integer getRepairId() {
		return this.repairId;
	}

	public void setReporterId(java.lang.Integer value) {
		this.reporterId = value;
	}

	public java.lang.Integer getReporterId() {
		return this.reporterId;
	}

	public void setRepairTime(java.sql.Timestamp value) {
		this.repairTime = value;
	}

	public java.sql.Timestamp getRepairTime() {
		return this.repairTime;
	}

	public void setRepairContent(java.lang.String value) {
		this.repairContent = value;
	}

	public java.lang.String getRepairContent() {
		return this.repairContent == null ? "" : this.repairContent;
	}

	public void setRepairType(Integer value) {
		this.repairType = value;
	}

	public Integer getRepairType() {
		return this.repairType;
	}

	public void setRepairState(java.lang.Integer value) {
		this.repairState = value;
	}

	public java.lang.Integer getRepairState() {
		return this.repairState;
	}

	public void setRepairScore(Float value) {
		this.repairScore = value;
	}

	public Float getRepairScore() {
		return this.repairScore;
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
		return this.receiverName == null ? "" : this.receiverName;
	}

	public void setReceiveAvatar(java.lang.String value) {
		this.receiveAvatar = value;
	}

	public java.lang.String getReceiveAvatar() {
		return this.receiveAvatar == null ? "" : this.receiveAvatar;
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
		return this.editor == null ? "" : this.editor;
	}

	public Integer getRepairReplies() {
		return repairReplies;
	}

	public void setRepairReplies(Integer repairReplies) {
		this.repairReplies = repairReplies;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("RepairId", getRepairId())
				.append("ReporterId", getReporterId())
				.append("RepairTime", getRepairTime())
				.append("RepairContent", getRepairContent())
				.append("RepairType", getRepairType())
				.append("RepairState", getRepairState())
				.append("RepairScore", getRepairScore())
				.append("NewReplies", getNewReplies())
				.append("ReceiverId", getReceiverId())
				.append("ReceiverName", getReceiverName())
				.append("ReceiveAvatar", getReceiveAvatar())
				.append("ReceiveDate", getReceiveDate())
				.append("CreateTime", getCreateTime())
				.append("EditTime", getEditTime())
				.append("Editor", getEditor()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getRepairId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof BusinessRepair == false)
			return false;
		if (this == obj)
			return true;
		BusinessRepair other = (BusinessRepair) obj;
		return new EqualsBuilder().append(getRepairId(), other.getRepairId())
				.isEquals();
	}
}
