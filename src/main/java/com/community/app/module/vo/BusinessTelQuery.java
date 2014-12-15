package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessTel;
import com.community.app.module.vo.BaseBean;

public class BusinessTelQuery extends BaseBean {
	

	private java.lang.Integer telId;
	private java.lang.Integer groupId;
	private java.lang.String tel;
	private java.lang.String telName;

	public BusinessTelQuery(BusinessTel businessTel) {
		this.telId = businessTel.getTelId();
		this.groupId = businessTel.getGroupId();
		this.tel = businessTel.getTel();
		this.telName = businessTel.getTelName();
	}
	
	public BusinessTelQuery() {
		
	}	
	
	public java.lang.Integer getTelId() {
		return this.telId;
	}
	
	public void setTelId(java.lang.Integer value) {
		this.telId = value;
	}
		
	public java.lang.Integer getGroupId() {
		return this.groupId;
	}
	
	public void setGroupId(java.lang.Integer value) {
		this.groupId = value;
	}
		
	public java.lang.String getTel() {
		return this.tel;
	}
	
	public void setTel(java.lang.String value) {
		this.tel = value;
	}
		
	public java.lang.String getTelName() {
		return this.telName;
	}
	
	public void setTelName(java.lang.String value) {
		this.telName = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

