package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessRegPic;
import com.community.app.module.vo.BaseBean;

public class BusinessRegPicQuery extends BaseBean {
	

	private java.lang.Integer picId;
	private java.lang.Integer regId;
	private java.lang.String picUrl;

	public BusinessRegPicQuery(BusinessRegPic businessRegPic) {
		this.picId = businessRegPic.getPicId();
		this.regId = businessRegPic.getRegId();
		this.picUrl = businessRegPic.getPicUrl();
	}
	
	public BusinessRegPicQuery() {
		
	}	
	
	public java.lang.Integer getPicId() {
		return this.picId;
	}
	
	public void setPicId(java.lang.Integer value) {
		this.picId = value;
	}
		
	public java.lang.Integer getRegId() {
		return this.regId;
	}
	
	public void setRegId(java.lang.Integer value) {
		this.regId = value;
	}
		
	public java.lang.String getPicUrl() {
		return this.picUrl;
	}
	
	public void setPicUrl(java.lang.String value) {
		this.picUrl = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

