package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class AppUserConfig implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "AppUserConfig";

	private java.lang.Integer userId;
	private Integer helpSwitch;
	private Integer marketSwitch;
	private Integer serviceSwitch;
	private Integer expressSwitch;
	private Integer brokeSwitch;
	private Integer weatherSwitch;
	private Integer limitSwitch;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private String baiduId;
	private String channelId;
	private Integer deviceType;

	public Integer getLimitSwitch() {
		return limitSwitch;
	}

	public void setLimitSwitch(Integer limitSwitch) {
		this.limitSwitch = limitSwitch;
	}

	public String getBaiduId() {
		return baiduId;
	}

	public void setBaiduId(String baiduId) {
		this.baiduId = baiduId;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public Integer getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}

	public Integer getWeatherSwitch() {
		return weatherSwitch;
	}

	public void setWeatherSwitch(Integer weatherSwitch) {
		this.weatherSwitch = weatherSwitch;
	}

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

	public AppUserConfig(){
	}

	public AppUserConfig(
		java.lang.Integer userId
	){
		this.userId = userId;
	}

	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
	
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	public void setHelpSwitch(Integer value) {
		this.helpSwitch = value;
	}
	
	public Integer getHelpSwitch() {
		return this.helpSwitch;
	}
	public void setMarketSwitch(Integer value) {
		this.marketSwitch = value;
	}
	
	public Integer getMarketSwitch() {
		return this.marketSwitch;
	}
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
	
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	public void setEditTime(java.sql.Timestamp value) {
		this.editTime = value;
	}
	
	public java.sql.Timestamp getEditTime() {
		return this.editTime;
	}
	public void setEditor(java.lang.String value) {
		this.editor = value;
	}
	
	public java.lang.String getEditor() {
		return this.editor;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("UserId",getUserId())
			.append("HelpSwitch",getHelpSwitch())
			.append("MarketSwitch",getMarketSwitch())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getUserId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AppUserConfig == false) return false;
		if(this == obj) return true;
		AppUserConfig other = (AppUserConfig)obj;
		return new EqualsBuilder()
			.append(getUserId(),other.getUserId())
			.isEquals();
	}
}

