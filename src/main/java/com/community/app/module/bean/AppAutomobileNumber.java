package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class AppAutomobileNumber implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "AppAutomobileNumber";

	private java.lang.Integer numberId;
	private java.lang.String numberName;
	private java.lang.Integer userId;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private String baiduId;
	private String channelId;
	private Integer deviceType;

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

	public AppAutomobileNumber(){
	}

	public AppAutomobileNumber(
		java.lang.Integer numberId
	){
		this.numberId = numberId;
	}

	public void setNumberId(java.lang.Integer value) {
		this.numberId = value;
	}
	
	public java.lang.Integer getNumberId() {
		return this.numberId;
	}
	public void setNumberName(java.lang.String value) {
		this.numberName = value;
	}
	
	public java.lang.String getNumberName() {
		return this.numberName;
	}
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
	
	public java.lang.Integer getUserId() {
		return this.userId;
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
			.append("NumberId",getNumberId())
			.append("NumberName",getNumberName())
			.append("UserId",getUserId())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getNumberId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AppAutomobileNumber == false) return false;
		if(this == obj) return true;
		AppAutomobileNumber other = (AppAutomobileNumber)obj;
		return new EqualsBuilder()
			.append(getNumberId(),other.getNumberId())
			.isEquals();
	}
}

