package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessBreak implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessBreak";

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
	private java.lang.String pics;
	private java.lang.String audios;
	private java.lang.String time;
	private java.lang.Integer comments;
	private java.sql.Timestamp lastCommentTime;
	private String address;
	private java.lang.Integer picCount;
	private String portrait;
	private java.lang.Integer estateId;
	private String estateName;
	private Integer newsCount;
	private String tel;
	private Integer isNickname;
	private String realname;
	
	public java.lang.String getComName() {
		return comName;
	}

	public void setComName(java.lang.String comName) {
		this.comName = comName;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Integer getIsNickname() {
		return isNickname;
	}

	public void setIsNickname(Integer isNickname) {
		this.isNickname = isNickname;
	}

	public Integer getNewsCount() {
		return newsCount;
	}

	public void setNewsCount(Integer newsCount) {
		this.newsCount = newsCount;
	}

	public java.lang.Integer getEstateId() {
		return estateId;
	}

	public void setEstateId(java.lang.Integer estateId) {
		this.estateId = estateId;
	}

	public String getEstateName() {
		return estateName;
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
	
	public java.lang.Integer getPicCount() {
		return picCount;
	}

	public void setPicCount(java.lang.Integer picCount) {
		this.picCount = picCount;
	}
	
	public String getTel() {
		return tel == null?"":tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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

	public java.lang.String getTime() {
		return time == null?"":time;
	}

	public void setTime(java.lang.String time) {
		this.time = time;
	}

	public BusinessBreak(){
	}

	public BusinessBreak(
		java.lang.Integer breakId
	){
		this.breakId = breakId;
	}

	public void setBreakId(java.lang.Integer value) {
		this.breakId = value;
	}
	
	public java.lang.Integer getBreakId() {
		return this.breakId;
	}
	public void setBreakerId(java.lang.Integer value) {
		this.breakerId = value;
	}
	
	public java.lang.Integer getBreakerId() {
		return this.breakerId;
	}
	public void setBreakerName(java.lang.String value) {
		this.breakerName = value;
	}
	
	public java.lang.String getBreakerName() {
		return this.breakerName == null?"":this.breakerName;
	}
	public void setBreakContent(java.lang.String value) {
		this.breakContent = value;
	}
	
	public java.lang.String getBreakContent() {
		return this.breakContent == null?"":this.breakContent;
	}
	public void setBreakTime(java.sql.Timestamp value) {
		this.breakTime = value;
	}
	
	public java.sql.Timestamp getBreakTime() {
		return this.breakTime;
	}
	public void setBreakType(java.lang.Integer value) {
		this.breakType = value;
	}
	
	public java.lang.Integer getBreakType() {
		return this.breakType;
	}
	public void setComId(java.lang.String value) {
		this.comId = value;
	}
	
	public java.lang.String getComId() {
		return this.comId == null?"":this.comId;
	}
	public void setState(java.lang.Integer value) {
		this.state = value;
	}
	
	public java.lang.Integer getState() {
		return this.state;
	}
	public void setIsUsed(java.lang.Integer value) {
		this.isUsed = value;
	}
	
	public java.lang.Integer getIsUsed() {
		return this.isUsed;
	}
	public void setSelectedNum(java.lang.Integer value) {
		this.selectedNum = value;
	}
	
	public java.lang.Integer getSelectedNum() {
		return this.selectedNum;
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
		return this.editor == null?"": this.editor;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("BreakId",getBreakId())
			.append("BreakerId",getBreakerId())
			.append("BreakerName",getBreakerName())
			.append("BreakContent",getBreakContent())
			.append("BreakTime",getBreakTime())
			.append("BreakType",getBreakType())
			.append("comId",getComId())
			.append("State",getState())
			.append("IsUsed",getIsUsed())
			.append("SelectedNum",getSelectedNum())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.append("comments",getComments())
			.append("lastCommentTime",getLastCommentTime())
			.append("address",getAddress())
			.append("tel",getTel())
			.append("picCount",getPicCount())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getBreakId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessBreak == false) return false;
		if(this == obj) return true;
		BusinessBreak other = (BusinessBreak)obj;
		return new EqualsBuilder()
			.append(getBreakId(),other.getBreakId())
			.isEquals();
	}

	public java.lang.String getPics() {
		return pics = this.pics;
	}

	public void setPics(java.lang.String pics) {
		this.pics = pics;
	}

	public java.lang.String getAudios() {
		return audios = this.audios;
	}

	public void setAudios(java.lang.String audios) {
		this.audios = audios;
	}

	public String getAddress() {
		return address == null?"":address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}