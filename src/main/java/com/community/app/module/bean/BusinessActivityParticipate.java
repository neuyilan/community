package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessActivityParticipate implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessActivityParticipate";

	private java.lang.Integer memberId;
	private java.lang.Integer actId;
	private java.lang.Integer userId;
	private java.sql.Timestamp joinTime;
	private java.lang.Integer isAward;
	private java.lang.Integer rank;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	
	private Integer estateId;
	
	private String realname;
	private String portrait;
	private String estateName;
	private String buildingName;
	private String unitName;
	private String houseNo;
	
	private String nickname;
	private String tel;
	private Integer isnotice;

	public Integer getIsnotice() {
		return isnotice;
	}
	
	public void setIsnotice(Integer isnotice) {
		this.isnotice = isnotice;
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

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public String getEstateName() {
		return estateName;
	}

	public void setEstateName(String estateName) {
		this.estateName = estateName;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public Integer getEstateId() {
		return estateId;
	}

	public void setEstateId(Integer estateId) {
		this.estateId = estateId;
	}

	public BusinessActivityParticipate(){
	}

	public BusinessActivityParticipate(
		java.lang.Integer memberId
	){
		this.memberId = memberId;
	}

	public void setMemberId(java.lang.Integer value) {
		this.memberId = value;
	}
	
	public java.lang.Integer getMemberId() {
		return this.memberId;
	}
	public void setActId(java.lang.Integer value) {
		this.actId = value;
	}
	
	public java.lang.Integer getActId() {
		return this.actId;
	}
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
	
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	public void setJoinTime(java.sql.Timestamp value) {
		this.joinTime = value;
	}
	
	public java.sql.Timestamp getJoinTime() {
		return this.joinTime;
	}
	public void setIsAward(java.lang.Integer value) {
		this.isAward = value;
	}
	
	public java.lang.Integer getIsAward() {
		return this.isAward;
	}
	public void setRank(java.lang.Integer value) {
		this.rank = value;
	}
	
	public java.lang.Integer getRank() {
		return this.rank;
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
		return this.editor;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("MemberId",getMemberId())
			.append("ActId",getActId())
			.append("UserId",getUserId())
			.append("JoinTime",getJoinTime())
			.append("IsAward",getIsAward())
			.append("Rank",getRank())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getMemberId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessActivityParticipate == false) return false;
		if(this == obj) return true;
		BusinessActivityParticipate other = (BusinessActivityParticipate)obj;
		return new EqualsBuilder()
			.append(getMemberId(),other.getMemberId())
			.isEquals();
	}
}