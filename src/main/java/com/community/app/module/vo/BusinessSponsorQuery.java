package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessSponsor;

public class BusinessSponsorQuery extends BaseBean {
	

	private java.lang.Integer sponsorId;
	private java.lang.Integer userId;
	private java.lang.Integer actId;
	private java.lang.String sponsorName;
	private java.lang.String sponsorPhone;
	private java.lang.String sponsorContent;
	private java.sql.Timestamp creatTime;
	private Integer flag;
	private java.lang.Integer ID;
	private String keyWord;
	
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

	public BusinessSponsorQuery(BusinessSponsor businessSponsor) {
		this.sponsorId = businessSponsor.getSponsorId();
		this.userId = businessSponsor.getUserId();
		this.actId = businessSponsor.getActId();
		this.sponsorName = businessSponsor.getSponsorName();
		this.sponsorPhone = businessSponsor.getSponsorPhone();
		this.sponsorContent = businessSponsor.getSponsorContent();
		this.creatTime = businessSponsor.getCreatTime();
		this.flag = businessSponsor.getFlag();
	}
	
	public BusinessSponsorQuery() {
		
	}	
	
	public java.lang.Integer getSponsorId() {
		return this.sponsorId;
	}
	
	public void setSponsorId(java.lang.Integer value) {
		this.sponsorId = value;
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
		
	public java.lang.String getSponsorName() {
		return this.sponsorName;
	}
	
	public void setSponsorName(java.lang.String value) {
		this.sponsorName = value;
	}
		
	public java.lang.String getSponsorPhone() {
		return this.sponsorPhone;
	}
	
	public void setSponsorPhone(java.lang.String value) {
		this.sponsorPhone = value;
	}
		
	public java.lang.String getSponsorContent() {
		return this.sponsorContent;
	}
	
	public void setSponsorContent(java.lang.String value) {
		this.sponsorContent = value;
	}
		
	public java.sql.Timestamp getCreatTime() {
		return this.creatTime;
	}
	
	public void setCreatTime(java.sql.Timestamp value) {
		this.creatTime = value;
	}
		
	public Integer getFlag() {
		return this.flag;
	}
	
	public void setFlag(Integer value) {
		this.flag = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
	
	
}

