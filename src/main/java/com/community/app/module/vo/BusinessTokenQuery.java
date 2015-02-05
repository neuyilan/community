package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessToken;

public class BusinessTokenQuery extends BaseBean {
	

	private java.lang.Integer userId;
	private java.lang.String token;

	public BusinessTokenQuery(BusinessToken businessToken) {
		this.userId = businessToken.getUserId();
		this.token = businessToken.getToken();
	}
	
	public BusinessTokenQuery() {
		
	}	
	
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
		
	public java.lang.String getToken() {
		return this.token;
	}
	
	public void setToken(java.lang.String value) {
		this.token = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

