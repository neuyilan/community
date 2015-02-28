package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessCharger;

public class BusinessChargerQuery extends BaseBean {
	
	private Integer payerId;
	private Integer reportId;
	private String name;
	private String cellphone;
	private String building;
	private String unit;
	private String floor;
	private String house;
	private String content;
	private java.sql.Timestamp publishTime;
	private Integer isReported;
	private Integer isRead;
	private String estateName;

	public String getEstateName() {
		return estateName;
	}

	public void setEstateName(String estateName) {
		this.estateName = estateName;
	}

	public BusinessChargerQuery(BusinessCharger businessCharger) {
		this.payerId = businessCharger.getPayerId();
		this.reportId = businessCharger.getReportId();
		this.name = businessCharger.getName();
		this.cellphone = businessCharger.getCellphone();
		this.estateName = businessCharger.getEstateName();
		this.building = businessCharger.getBuilding();
		this.unit = businessCharger.getUnit();
		this.floor = businessCharger.getFloor();
		this.house = businessCharger.getHouse();
		this.publishTime = businessCharger.getPublishTime();
		this.isReported = businessCharger.getIsReported();
		this.isRead = businessCharger.getIsRead();
	}
	
	public BusinessChargerQuery() {
		
	}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPayerId() {
		return this.payerId;
	}
	
	public void setPayerId(Integer value) {
		this.payerId = value;
	}
		
	public Integer getReportId() {
		return this.reportId;
	}
	
	public void setReportId(Integer value) {
		this.reportId = value;
	}
		
	public String getName() {
		return this.name;
	}
	
	public void setName(String value) {
		this.name = value;
	}
		
	public String getCellphone() {
		return this.cellphone;
	}
	
	public void setCellphone(String value) {
		this.cellphone = value;
	}
		
	public String getBuilding() {
		return this.building;
	}
	
	public void setBuilding(String value) {
		this.building = value;
	}
		
	public String getUnit() {
		return this.unit;
	}
	
	public void setUnit(String value) {
		this.unit = value;
	}
		
	public String getFloor() {
		return this.floor;
	}
	
	public void setFloor(String value) {
		this.floor = value;
	}
		
	public String getHouse() {
		return this.house;
	}
	
	public void setHouse(String value) {
		this.house = value;
	}
		
	public java.sql.Timestamp getPublishTime() {
		return this.publishTime;
	}
	
	public void setPublishTime(java.sql.Timestamp value) {
		this.publishTime = value;
	}
		
	public Integer getIsReported() {
		return this.isReported;
	}
	
	public void setIsReported(Integer value) {
		this.isReported = value;
	}
		
	public Integer getIsRead() {
		return this.isRead;
	}
	
	public void setIsRead(Integer value) {
		this.isRead = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
}