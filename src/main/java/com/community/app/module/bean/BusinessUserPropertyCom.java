package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class BusinessUserPropertyCom implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessUserPropertyCom";

	private Integer comId;
	private Integer userId;
	private String userName;
	private Integer managerId;
	private String managerName;
	private String content;
	private java.sql.Timestamp pubTime;
	private Integer direction;

	public BusinessUserPropertyCom(){
	}

	public BusinessUserPropertyCom(
		Integer comId
	){
		this.comId = comId;
	}

	public void setComId(Integer value) {
		this.comId = value;
	}
	
	public Integer getComId() {
		return this.comId;
	}
	public void setUserId(Integer value) {
		this.userId = value;
	}
	
	public Integer getUserId() {
		return this.userId;
	}
	public void setUserName(String value) {
		this.userName = value;
	}
	
	public String getUserName() {
		return this.userName;
	}
	public void setManagerId(Integer value) {
		this.managerId = value;
	}
	
	public Integer getManagerId() {
		return this.managerId;
	}
	public void setManagerName(String value) {
		this.managerName = value;
	}
	
	public String getManagerName() {
		return this.managerName;
	}
	public void setContent(String value) {
		this.content = value;
	}
	
	public String getContent() {
		return this.content;
	}
	public void setPubTime(java.sql.Timestamp value) {
		this.pubTime = value;
	}
	
	public java.sql.Timestamp getPubTime() {
		return this.pubTime;
	}
	public void setDirection(Integer value) {
		this.direction = value;
	}
	
	public Integer getDirection() {
		return this.direction;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("ComId",getComId())
			.append("UserId",getUserId())
			.append("UserName",getUserName())
			.append("ManagerId",getManagerId())
			.append("ManagerName",getManagerName())
			.append("Content",getContent())
			.append("PubTime",getPubTime())
			.append("Direction",getDirection())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getComId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessUserPropertyCom == false) return false;
		if(this == obj) return true;
		BusinessUserPropertyCom other = (BusinessUserPropertyCom)obj;
		return new EqualsBuilder()
			.append(getComId(),other.getComId())
			.isEquals();
	}
}

