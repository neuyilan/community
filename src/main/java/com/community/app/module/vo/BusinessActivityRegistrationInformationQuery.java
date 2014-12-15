package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessActivityRegistrationInformation;

public class BusinessActivityRegistrationInformationQuery extends BaseBean {
	

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
	private String keyWord;

	public BusinessActivityRegistrationInformationQuery(BusinessActivityRegistrationInformation businessActivityRegistrationInformation) {
		this.informationId = businessActivityRegistrationInformation.getInformationId();
		this.userId = businessActivityRegistrationInformation.getUserId();
		this.actId = businessActivityRegistrationInformation.getActId();
		this.timeSlotId = businessActivityRegistrationInformation.getTimeSlotId();
		this.nickname = businessActivityRegistrationInformation.getNickname();
		this.realname = businessActivityRegistrationInformation.getRealname();
		this.tel = businessActivityRegistrationInformation.getTel();
		this.birthday = businessActivityRegistrationInformation.getBirthday();
		this.age = businessActivityRegistrationInformation.getAge();
		this.job = businessActivityRegistrationInformation.getJob();
		this.ID = businessActivityRegistrationInformation.getID();
		this.email = businessActivityRegistrationInformation.getEmail();
		this.addr = businessActivityRegistrationInformation.getAddr();
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	
	public BusinessActivityRegistrationInformationQuery() {
		
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
		
	public java.lang.Integer getTimeSlotId() {
		return this.timeSlotId;
	}
	
	public void setTimeSlotId(java.lang.Integer value) {
		this.timeSlotId = value;
	}
		
	public java.lang.String getNickname() {
		return this.nickname;
	}
	
	public void setNickname(java.lang.String value) {
		this.nickname = value;
	}
		
	public java.lang.String getRealname() {
		return this.realname;
	}
	
	public void setRealname(java.lang.String value) {
		this.realname = value;
	}
		
	public java.lang.String getTel() {
		return this.tel;
	}
	
	public void setTel(java.lang.String value) {
		this.tel = value;
	}
		
	public java.lang.String getBirthday() {
		return this.birthday;
	}
	
	public void setBirthday(java.lang.String value) {
		this.birthday = value;
	}
		
	public java.lang.String getAge() {
		return this.age;
	}
	
	public void setAge(java.lang.String value) {
		this.age = value;
	}
		
	public java.lang.String getJob() {
		return this.job;
	}
	
	public void setJob(java.lang.String value) {
		this.job = value;
	}
		
	public java.lang.String getID() {
		return this.ID;
	}
	
	public void setID(java.lang.String value) {
		this.ID = value;
	}
		
	public java.lang.String getEmail() {
		return this.email;
	}
	
	public void setEmail(java.lang.String value) {
		this.email = value;
	}
		
	public java.lang.String getAddr() {
		return this.addr;
	}
	
	public void setAddr(java.lang.String value) {
		this.addr = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

