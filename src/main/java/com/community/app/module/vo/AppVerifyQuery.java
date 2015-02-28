package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.AppVerify;

public class AppVerifyQuery extends BaseBean {
	

	private java.lang.Integer verifyId;
	private java.lang.String cellphone;
	private java.lang.String verificationCode;
	private java.lang.String verifyCode;
	private java.sql.Timestamp createTime;

	public AppVerifyQuery(AppVerify appVerify) {
		this.verifyId = appVerify.getVerifyId();
		this.cellphone = appVerify.getCellphone();
		this.verificationCode = appVerify.getVerificationCode();
		this.createTime = appVerify.getCreateTime();
	}
	
	public AppVerifyQuery() {
		
	}	
	
	public java.lang.Integer getVerifyId() {
		return this.verifyId;
	}
	
	public void setVerifyId(java.lang.Integer value) {
		this.verifyId = value;
	}
		
	public java.lang.String getCellphone() {
		return this.cellphone;
	}
	
	public void setCellphone(java.lang.String value) {
		this.cellphone = value;
	}
		
	public java.lang.String getVerificationCode() {
		return this.verificationCode;
	}
	
	public void setVerificationCode(java.lang.String value) {
		this.verificationCode = value;
	}
		
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}

	public java.lang.String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(java.lang.String verifyCode) {
		this.verifyCode = verifyCode;
	}
	
}

