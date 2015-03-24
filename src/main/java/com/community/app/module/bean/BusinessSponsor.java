package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessSponsor implements java.io.Serializable{
	

	private static final long serialVersionUID = 6757441600445754874L;

	//别名
	public static final String TABLE_ALIAS = "BusinessSponsor";

	private java.lang.Integer sponsorId;
	private java.lang.Integer userId;
	private java.lang.Integer actId;
	private java.lang.String sponsorName;
	private java.lang.String sponsorPhone;
	private java.lang.String sponsorContent;
	private java.sql.Timestamp creatTime;
	private Integer flag;

	public BusinessSponsor(){
	}

	public BusinessSponsor(
		java.lang.Integer sponsorId
	){
		this.sponsorId = sponsorId;
	}

	public void setSponsorId(java.lang.Integer value) {
		this.sponsorId = value;
	}
	
	public java.lang.Integer getSponsorId() {
		return this.sponsorId;
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
	public void setSponsorName(java.lang.String value) {
		this.sponsorName = value;
	}
	
	public java.lang.String getSponsorName() {
		return this.sponsorName;
	}
	public void setSponsorPhone(java.lang.String value) {
		this.sponsorPhone = value;
	}
	
	public java.lang.String getSponsorPhone() {
		return this.sponsorPhone;
	}
	public void setSponsorContent(java.lang.String value) {
		this.sponsorContent = value;
	}
	
	public java.lang.String getSponsorContent() {
		return this.sponsorContent;
	}
	public void setCreatTime(java.sql.Timestamp value) {
		this.creatTime = value;
	}
	
	public java.sql.Timestamp getCreatTime() {
		return this.creatTime;
	}
	public void setFlag(Integer value) {
		this.flag = value;
	}
	
	public Integer getFlag() {
		return this.flag;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("SponsorId",getSponsorId())
			.append("UserId",getUserId())
			.append("ActId",getActId())
			.append("SponsorName",getSponsorName())
			.append("SponsorPhone",getSponsorPhone())
			.append("SponsorContent",getSponsorContent())
			.append("CreatTime",getCreatTime())
			.append("Flag",getFlag())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getSponsorId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessSponsor == false) return false;
		if(this == obj) return true;
		BusinessSponsor other = (BusinessSponsor)obj;
		return new EqualsBuilder()
			.append(getSponsorId(),other.getSponsorId())
			.isEquals();
	}
}

