package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessUserPropertyCom;

public class BusinessUserPropertyComQuery extends BaseBean {
	

	private Integer comId;
	private Integer userId;
	private String userName;
	private Integer managerId;
	private String managerName;
	private String content;
	private java.sql.Timestamp pubTime;
	private Integer direction;

	public BusinessUserPropertyComQuery(BusinessUserPropertyCom businessUserPropertyCom) {
		this.comId = businessUserPropertyCom.getComId();
		this.userId = businessUserPropertyCom.getUserId();
		this.userName = businessUserPropertyCom.getUserName();
		this.managerId = businessUserPropertyCom.getManagerId();
		this.managerName = businessUserPropertyCom.getManagerName();
		this.content = businessUserPropertyCom.getContent();
		this.pubTime = businessUserPropertyCom.getPubTime();
		this.direction = businessUserPropertyCom.getDirection();
	}
	
	public BusinessUserPropertyComQuery() {
		
	}	
	
	public Integer getComId() {
		return this.comId;
	}
	
	public void setComId(Integer value) {
		this.comId = value;
	}
		
	public Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(Integer value) {
		this.userId = value;
	}
		
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String value) {
		this.userName = value;
	}
		
	public Integer getManagerId() {
		return this.managerId;
	}
	
	public void setManagerId(Integer value) {
		this.managerId = value;
	}
		
	public String getManagerName() {
		return this.managerName;
	}
	
	public void setManagerName(String value) {
		this.managerName = value;
	}
		
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String value) {
		this.content = value;
	}
		
	public java.sql.Timestamp getPubTime() {
		return this.pubTime;
	}
	
	public void setPubTime(java.sql.Timestamp value) {
		this.pubTime = value;
	}
		
	public Integer getDirection() {
		return this.direction;
	}
	
	public void setDirection(Integer value) {
		this.direction = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

