package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class BusinessRegPic implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessRegPic";

	private java.lang.Integer picId;
	private java.lang.Integer regId;
	private java.lang.String picUrl;

	public BusinessRegPic(){
	}

	public BusinessRegPic(
		java.lang.Integer picId
	){
		this.picId = picId;
	}

	public void setPicId(java.lang.Integer value) {
		this.picId = value;
	}
	
	public java.lang.Integer getPicId() {
		return this.picId;
	}
	public void setRegId(java.lang.Integer value) {
		this.regId = value;
	}
	
	public java.lang.Integer getRegId() {
		return this.regId;
	}
	public void setPicUrl(java.lang.String value) {
		this.picUrl = value;
	}
	
	public java.lang.String getPicUrl() {
		return this.picUrl;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("PicId",getPicId())
			.append("RegId",getRegId())
			.append("PicUrl",getPicUrl())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getPicId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessRegPic == false) return false;
		if(this == obj) return true;
		BusinessRegPic other = (BusinessRegPic)obj;
		return new EqualsBuilder()
			.append(getPicId(),other.getPicId())
			.isEquals();
	}
}

