package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessActivityRegistrationInformation implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessActivityRegistrationInformation";

	private java.lang.Integer informationId;
	private java.lang.Integer userId;
	private java.lang.Integer actId;
	private java.lang.Integer timeSlotId;
	private java.lang.String nickname;
	private java.lang.String realname;
	private java.lang.String tel;
	private java.lang.String birthday;
	private java.lang.String age;
	private java.lang.String job;
	private java.lang.String ID;
	private java.lang.String email;
	private java.lang.String addr;
	private java.lang.String title;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;

	public java.lang.String getTitle() {
		return title;
	}

	public void setTitle(java.lang.String title) {
		this.title = title;
	}

	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}

	public java.sql.Timestamp getEditTime() {
		return editTime;
	}

	public void setEditTime(java.sql.Timestamp editTime) {
		this.editTime = editTime;
	}

	public BusinessActivityRegistrationInformation(){
	}

	public BusinessActivityRegistrationInformation(
		java.lang.Integer informationId
	){
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
	public void setTimeSlotId(java.lang.Integer value) {
		this.timeSlotId = value;
	}
	
	public java.lang.Integer getTimeSlotId() {
		return this.timeSlotId;
	}
	public void setNickname(java.lang.String value) {
		this.nickname = value;
	}
	
	public java.lang.String getNickname() {
		return this.nickname;
	}
	public void setRealname(java.lang.String value) {
		this.realname = value;
	}
	
	public java.lang.String getRealname() {
		return this.realname;
	}
	public void setTel(java.lang.String value) {
		this.tel = value;
	}
	
	public java.lang.String getTel() {
		return this.tel;
	}
	public void setBirthday(java.lang.String value) {
		this.birthday = value;
	}
	
	public java.lang.String getBirthday() {
		return this.birthday;
	}
	public void setAge(java.lang.String value) {
		this.age = value;
	}
	
	public java.lang.String getAge() {
		return this.age;
	}
	public void setJob(java.lang.String value) {
		this.job = value;
	}
	
	public java.lang.String getJob() {
		return this.job;
	}
	public void setID(java.lang.String value) {
		this.ID = value;
	}
	
	public java.lang.String getID() {
		return this.ID;
	}
	public void setEmail(java.lang.String value) {
		this.email = value;
	}
	
	public java.lang.String getEmail() {
		return this.email;
	}
	public void setAddr(java.lang.String value) {
		this.addr = value;
	}
	
	public java.lang.String getAddr() {
		return this.addr;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("InformationId",getInformationId())
			.append("UserId",getUserId())
			.append("ActId",getActId())
			.append("TimeSlotId",getTimeSlotId())
			.append("Nickname",getNickname())
			.append("Realname",getRealname())
			.append("Tel",getTel())
			.append("Birthday",getBirthday())
			.append("Age",getAge())
			.append("Job",getJob())
			.append("Id",getID())
			.append("Email",getEmail())
			.append("Addr",getAddr())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getInformationId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessActivityRegistrationInformation == false) return false;
		if(this == obj) return true;
		BusinessActivityRegistrationInformation other = (BusinessActivityRegistrationInformation)obj;
		return new EqualsBuilder()
			.append(getInformationId(),other.getInformationId())
			.isEquals();
	}
}

