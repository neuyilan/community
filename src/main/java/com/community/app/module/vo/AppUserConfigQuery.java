package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.AppUserConfig;

public class AppUserConfigQuery extends BaseBean {
	

	private java.lang.Integer userId;
	private Integer helpSwitch;
	private Integer marketSwitch;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private Integer type;
	private Integer serviceSwitch;
	private Integer expressSwitch;
	private Integer brokeSwitch;
	private Integer weatherSwitch;

	public Integer getServiceSwitch() {
		return serviceSwitch;
	}

	public void setServiceSwitch(Integer serviceSwitch) {
		this.serviceSwitch = serviceSwitch;
	}

	public Integer getExpressSwitch() {
		return expressSwitch;
	}

	public void setExpressSwitch(Integer expressSwitch) {
		this.expressSwitch = expressSwitch;
	}

	public Integer getBrokeSwitch() {
		return brokeSwitch;
	}

	public void setBrokeSwitch(Integer brokeSwitch) {
		this.brokeSwitch = brokeSwitch;
	}

	public Integer getWeatherSwitch() {
		return weatherSwitch;
	}

	public void setWeatherSwitch(Integer weatherSwitch) {
		this.weatherSwitch = weatherSwitch;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public AppUserConfigQuery(AppUserConfig appUserConfig) {
		this.userId = appUserConfig.getUserId();
		this.helpSwitch = appUserConfig.getHelpSwitch();
		this.marketSwitch = appUserConfig.getMarketSwitch();
		this.createTime = appUserConfig.getCreateTime();
		this.editTime = appUserConfig.getEditTime();
		this.editor = appUserConfig.getEditor();
	}
	
	public AppUserConfigQuery() {
		
	}	
	
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
		
	public Integer getHelpSwitch() {
		return this.helpSwitch;
	}
	
	public void setHelpSwitch(Integer value) {
		this.helpSwitch = value;
	}
		
	public Integer getMarketSwitch() {
		return this.marketSwitch;
	}
	
	public void setMarketSwitch(Integer value) {
		this.marketSwitch = value;
	}
		
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
		
	public java.sql.Timestamp getEditTime() {
		return this.editTime;
	}
	
	public void setEditTime(java.sql.Timestamp value) {
		this.editTime = value;
	}
		
	public java.lang.String getEditor() {
		return this.editor;
	}
	
	public void setEditor(java.lang.String value) {
		this.editor = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

