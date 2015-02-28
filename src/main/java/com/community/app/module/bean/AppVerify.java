package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class AppVerify implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "AppVerify";

	private java.lang.Integer verifyId;
	private java.lang.String cellphone;
	private java.lang.String verificationCode;
	private java.sql.Timestamp createTime;

	public AppVerify(){
	}

	public AppVerify(
		java.lang.Integer verifyId
	){
		this.verifyId = verifyId;
	}

	public void setVerifyId(java.lang.Integer value) {
		this.verifyId = value;
	}
	
	public java.lang.Integer getVerifyId() {
		return this.verifyId;
	}
	public void setCellphone(java.lang.String value) {
		this.cellphone = value;
	}
	
	public java.lang.String getCellphone() {
		return this.cellphone;
	}
	public void setVerificationCode(java.lang.String value) {
		this.verificationCode = value;
	}
	
	public java.lang.String getVerificationCode() {
		return this.verificationCode;
	}
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
	
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("VerifyId",getVerifyId())
			.append("Cellphone",getCellphone())
			.append("VerificationCode",getVerificationCode())
			.append("CreateTime",getCreateTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getVerifyId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AppVerify == false) return false;
		if(this == obj) return true;
		AppVerify other = (AppVerify)obj;
		return new EqualsBuilder()
			.append(getVerifyId(),other.getVerifyId())
			.isEquals();
	}
}

