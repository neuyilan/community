package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class BusinessActivityVoteInformation implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	// 别名
	public static final String TABLE_ALIAS = "BusinessActivityVoteInformation";

	private java.lang.Integer informationId;
	private java.lang.Integer userId;
	private java.lang.Integer actId;
	private java.lang.Integer optionsId;
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
	
	public Integer getEstateId() {
		return estateId;
	}

	public void setEstateId(Integer estateId) {
		this.estateId = estateId;
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
	
	public BusinessActivityVoteInformation() {
	}

	public BusinessActivityVoteInformation(java.lang.Integer informationId) {
		this.informationId = informationId;
	}

	public void setInformationId(java.lang.Integer value) {
		this.informationId = value;
	}

	public java.lang.Integer getInformationId() {
		return this.informationId;
	}

	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}

	public java.lang.Integer getUserId() {
		return this.userId;
	}

	public void setActId(java.lang.Integer value) {
		this.actId = value;
	}

	public java.lang.Integer getActId() {
		return this.actId;
	}

	public void setOptionsId(java.lang.Integer value) {
		this.optionsId = value;
	}

	public java.lang.Integer getOptionsId() {
		return this.optionsId;
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
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("InformationId", getInformationId())
				.append("UserId", getUserId()).append("ActId", getActId())
				.append("OptionsId", getOptionsId())
				.append("CreateTime", getCreateTime())
				.append("EditTime", getEditTime())
				.append("Editor", getEditor()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getInformationId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof BusinessActivityVoteInformation == false)
			return false;
		if (this == obj)
			return true;
		BusinessActivityVoteInformation other = (BusinessActivityVoteInformation) obj;
		return new EqualsBuilder().append(getInformationId(),
				other.getInformationId()).isEquals();
	}
}