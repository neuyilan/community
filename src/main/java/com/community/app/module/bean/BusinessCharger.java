package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessCharger implements java.io.Serializable {

	// 别名
	public static final String TABLE_ALIAS = "BusinessCharger";

	private Integer payerId;
	private Integer reportId;
	private String name;
	private String cellphone;
	private String estateName;
	private String building;
	private String unit;
	private String floor;
	private String house;
	private String content;
	private java.sql.Timestamp publishTime;
	private Integer isReported;
	private Integer isRead;

	public BusinessCharger() {
	}

	public String getEstateName() {
		return estateName == null?"":estateName;
	}

	public void setEstateName(String estateName) {
		this.estateName = estateName;
	}

	public BusinessCharger(Integer payerId) {
		this.payerId = payerId;
	}

	public String getContent() {
		return content == null?"":content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setPayerId(Integer value) {
		this.payerId = value;
	}

	public Integer getPayerId() {
		return this.payerId;
	}

	public void setReportId(Integer value) {
		this.reportId = value;
	}

	public Integer getReportId() {
		return this.reportId;
	}

	public void setName(String value) {
		this.name = value;
	}

	public String getName() {
		return this.name == null?"":this.name;
	}

	public void setCellphone(String value) {
		this.cellphone = value;
	}

	public String getCellphone() {
		return this.cellphone == null?"":this.cellphone;
	}

	public void setBuilding(String value) {
		this.building = value;
	}

	public String getBuilding() {
		return this.building == null?"":this.building;
	}

	public void setUnit(String value) {
		this.unit = value;
	}

	public String getUnit() {
		return this.unit == null?"":this.unit;
	}

	public void setFloor(String value) {
		this.floor = value;
	}

	public String getFloor() {
		return this.floor == null?"":this.floor;
	}

	public void setHouse(String value) {
		this.house = value;
	}

	public String getHouse() {
		return this.house == null?"":this.house;
	}

	public void setPublishTime(java.sql.Timestamp value) {
		this.publishTime = value;
	}

	public java.sql.Timestamp getPublishTime() {
		return this.publishTime;
	}

	public void setIsReported(Integer value) {
		this.isReported = value;
	}

	public Integer getIsReported() {
		return this.isReported;
	}

	public void setIsRead(Integer value) {
		this.isRead = value;
	}

	public Integer getIsRead() {
		return this.isRead;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("PayerId", getPayerId())
				.append("ReportId", getReportId()).append("Name", getName())
				.append("Cellphone", getCellphone())
				.append("Building", getBuilding()).append("Unit", getUnit())
				.append("Floor", getFloor()).append("House", getHouse())
				.append("PublishTime", getPublishTime())
				.append("IsReported", getIsReported())
				.append("IsRead", getIsRead()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getPayerId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof BusinessCharger == false)
			return false;
		if (this == obj)
			return true;
		BusinessCharger other = (BusinessCharger) obj;
		return new EqualsBuilder().append(getPayerId(), other.getPayerId()).isEquals();
	}
}