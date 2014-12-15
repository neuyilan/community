package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessActivityVoteInformation;
import com.community.app.module.vo.BaseBean;

public class BusinessActivityVoteInformationQuery extends BaseBean {
	
	private java.lang.Integer informationId;
	private java.lang.Integer userId;
	private java.lang.Integer actId;
	private java.lang.Integer ID;
	private java.lang.Integer optionsId;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.String ids;
	private Integer estateId;
	private String realname;
	private String portrait;
	private String estateName;
	private String buildingName;
	private String unitName;
	private String houseNo;

	private String keyWord;
	
	public BusinessActivityVoteInformationQuery(BusinessActivityVoteInformation businessActivityVoteInformation) {
		this.informationId = businessActivityVoteInformation.getInformationId();
		this.userId = businessActivityVoteInformation.getUserId();
		this.actId = businessActivityVoteInformation.getActId();
		this.optionsId = businessActivityVoteInformation.getOptionsId();
		this.createTime = businessActivityVoteInformation.getCreateTime();
		this.editTime = businessActivityVoteInformation.getEditTime();
		this.editor = businessActivityVoteInformation.getEditor();
	}

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


	public String getKeyWord() {
		return keyWord;
	}


	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}


	public java.lang.Integer getID() {
		return ID;
	}

	public void setID(java.lang.Integer iD) {
		ID = iD;
	}

	public java.lang.String getIds() {
		return ids;
	}

	public void setIds(java.lang.String ids) {
		this.ids = ids;
	}

	public BusinessActivityVoteInformationQuery() {
		
	}	
	
	public java.lang.Integer getInformationId() {
		return this.informationId;
	}
	
	public void setInformationId(java.lang.Integer value) {
		this.informationId = value;
	}
		
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
		
	public java.lang.Integer getActId() {
		return this.actId;
	}
	
	public void setActId(java.lang.Integer value) {
		this.actId = value;
	}
		
	public java.lang.Integer getOptionsId() {
		return this.optionsId;
	}
	
	public void setOptionsId(java.lang.Integer value) {
		this.optionsId = value;
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
	
}

