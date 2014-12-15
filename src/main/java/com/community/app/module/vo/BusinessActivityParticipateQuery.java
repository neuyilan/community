package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessActivityParticipate;
import com.community.app.module.vo.BaseBean;

public class BusinessActivityParticipateQuery extends BaseBean {

	private java.lang.Integer memberId;
	private java.lang.Integer actId;
	private java.lang.Integer userId;
	private java.lang.String userName;
	private java.sql.Timestamp joinTime;
	private java.lang.Integer isAward;
	private java.lang.Integer rank;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	private java.lang.Integer ID;
	private java.lang.Integer NO0;
	private java.lang.Integer NO1;
	private java.lang.Integer NO2;
	private java.lang.Integer NO3;
	private java.lang.Integer NO4;
	private java.lang.Integer NO5;
	private java.lang.Integer NO6;
	private java.lang.Integer NO7;
	private java.lang.Integer NO8;
	private java.lang.Integer NO9;

	private Integer estateId;
	private String realname;
	private String portrait;
	private String estateName;
	private String buildingName;
	private String unitName;
	private String houseNo;

	private String keyWord;
	private Integer ranks;
	private Integer isnotice;

	public Integer getIsnotice() {
		return isnotice;
	}

	public void setIsnotice(Integer isnotice) {
		this.isnotice = isnotice;
	}

	public Integer getRanks() {
		return ranks;
	}

	public void setRanks(Integer ranks) {
		this.ranks = ranks;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public Integer getEstateId() {
		return estateId;
	}

	public void setEstateId(Integer estateId) {
		this.estateId = estateId;
	}

	public java.lang.Integer getID() {
		return ID;
	}

	public void setID(java.lang.Integer iD) {
		ID = iD;
	}

	public java.lang.Integer getNO0() {
		return NO0;
	}

	public void setNO0(java.lang.Integer nO0) {
		NO0 = nO0;
	}

	public java.lang.Integer getNO1() {
		return NO1;
	}

	public void setNO1(java.lang.Integer nO1) {
		NO1 = nO1;
	}

	public java.lang.Integer getNO2() {
		return NO2;
	}

	public void setNO2(java.lang.Integer nO2) {
		NO2 = nO2;
	}

	public java.lang.Integer getNO3() {
		return NO3;
	}

	public void setNO3(java.lang.Integer nO3) {
		NO3 = nO3;
	}

	public java.lang.Integer getNO4() {
		return NO4;
	}

	public void setNO4(java.lang.Integer nO4) {
		NO4 = nO4;
	}

	public java.lang.Integer getNO5() {
		return NO5;
	}

	public void setNO5(java.lang.Integer nO5) {
		NO5 = nO5;
	}

	public java.lang.Integer getNO6() {
		return NO6;
	}

	public void setNO6(java.lang.Integer nO6) {
		NO6 = nO6;
	}

	public java.lang.Integer getNO7() {
		return NO7;
	}

	public void setNO7(java.lang.Integer nO7) {
		NO7 = nO7;
	}

	public java.lang.Integer getNO8() {
		return NO8;
	}

	public void setNO8(java.lang.Integer nO8) {
		NO8 = nO8;
	}

	public java.lang.Integer getNO9() {
		return NO9;
	}

	public void setNO9(java.lang.Integer nO9) {
		NO9 = nO9;
	}

	public java.lang.String getUserName() {
		return userName;
	}

	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}

	public BusinessActivityParticipateQuery(
			BusinessActivityParticipate businessActivityParticipate) {
		this.memberId = businessActivityParticipate.getMemberId();
		this.actId = businessActivityParticipate.getActId();
		this.userId = businessActivityParticipate.getUserId();
		this.joinTime = businessActivityParticipate.getJoinTime();
		this.isAward = businessActivityParticipate.getIsAward();
		this.rank = businessActivityParticipate.getRank();
		this.createTime = businessActivityParticipate.getCreateTime();
		this.editTime = businessActivityParticipate.getEditTime();
		this.editor = businessActivityParticipate.getEditor();
		this.estateId = businessActivityParticipate.getEstateId();
		this.estateName = businessActivityParticipate.getEstateName();
		this.realname = businessActivityParticipate.getRealname();
		this.portrait = businessActivityParticipate.getPortrait();
		this.buildingName = businessActivityParticipate.getBuildingName();
		this.unitName = businessActivityParticipate.getUnitName();
		this.houseNo = businessActivityParticipate.getHouseNo();
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

	public BusinessActivityParticipateQuery() {

	}

	public java.lang.Integer getMemberId() {
		return this.memberId;
	}

	public void setMemberId(java.lang.Integer value) {
		this.memberId = value;
	}

	public java.lang.Integer getActId() {
		return this.actId;
	}

	public void setActId(java.lang.Integer value) {
		this.actId = value;
	}

	public java.lang.Integer getUserId() {
		return this.userId;
	}

	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}

	public java.sql.Timestamp getJoinTime() {
		return this.joinTime;
	}

	public void setJoinTime(java.sql.Timestamp value) {
		this.joinTime = value;
	}

	public java.lang.Integer getIsAward() {
		return this.isAward;
	}

	public void setIsAward(java.lang.Integer value) {
		this.isAward = value;
	}

	public java.lang.Integer getRank() {
		return this.rank;
	}

	public void setRank(java.lang.Integer value) {
		this.rank = value;
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
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}