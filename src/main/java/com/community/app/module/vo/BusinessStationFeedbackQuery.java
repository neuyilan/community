package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessStationFeedback;

public class BusinessStationFeedbackQuery extends BaseBean {
	
	private java.lang.Integer feedId;
	private java.lang.Integer comId;
	private java.lang.String comName;
	private java.lang.Integer estateId;
	private java.lang.String estateName;
	private java.lang.Integer state;
	private java.lang.Integer totalPoll;

	public BusinessStationFeedbackQuery(BusinessStationFeedback businessStationFeedback) {
		this.feedId = businessStationFeedback.getFeedId();
		this.comId = businessStationFeedback.getComId();
		this.comName = businessStationFeedback.getComName();
		this.estateId = businessStationFeedback.getEstateId();
		this.estateName = businessStationFeedback.getEstateName();
		this.state = businessStationFeedback.getState();
		this.totalPoll = businessStationFeedback.getTotalPoll();
	}
	
	public BusinessStationFeedbackQuery() {
		
	}	
	
	public java.lang.Integer getFeedId() {
		return this.feedId;
	}
	
	public void setFeedId(java.lang.Integer value) {
		this.feedId = value;
	}
		
	public java.lang.Integer getComId() {
		return this.comId;
	}
	
	public void setComId(java.lang.Integer value) {
		this.comId = value;
	}
		
	public java.lang.String getComName() {
		return this.comName;
	}
	
	public void setComName(java.lang.String value) {
		this.comName = value;
	}
		
	public java.lang.Integer getEstateId() {
		return this.estateId;
	}
	
	public void setEstateId(java.lang.Integer value) {
		this.estateId = value;
	}
		
	public java.lang.String getEstateName() {
		return this.estateName;
	}
	
	public void setEstateName(java.lang.String value) {
		this.estateName = value;
	}
		
	public java.lang.Integer getState() {
		return this.state;
	}
	
	public void setState(java.lang.Integer value) {
		this.state = value;
	}
		
	public java.lang.Integer getTotalPoll() {
		return this.totalPoll;
	}
	
	public void setTotalPoll(java.lang.Integer value) {
		this.totalPoll = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
}