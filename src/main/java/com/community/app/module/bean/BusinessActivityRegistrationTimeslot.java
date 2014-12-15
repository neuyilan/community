package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessActivityRegistrationTimeslot implements
		java.io.Serializable {

	// 别名
	public static final String TABLE_ALIAS = "BusinessActivityRegistrationTimeslot";

	private java.lang.Integer timeSlotId;
	private java.lang.Integer actId;
	private java.lang.String timeSlotName;
	private java.lang.Integer number;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.Integer count;

	public java.lang.Integer getCount() {
		return count;
	}

	public void setCount(java.lang.Integer count) {
		this.count = count;
	}

	public BusinessActivityRegistrationTimeslot() {
	}

	public BusinessActivityRegistrationTimeslot(java.lang.Integer timeSlotId) {
		this.timeSlotId = timeSlotId;
	}

	public void setTimeSlotId(java.lang.Integer value) {
		this.timeSlotId = value;
	}

	public java.lang.Integer getTimeSlotId() {
		return this.timeSlotId;
	}

	public void setActId(java.lang.Integer value) {
		this.actId = value;
	}

	public java.lang.Integer getActId() {
		return this.actId;
	}

	public void setTimeSlotName(java.lang.String value) {
		this.timeSlotName = value;
	}

	public java.lang.String getTimeSlotName() {
		return this.timeSlotName;
	}

	public void setNumber(java.lang.Integer value) {
		this.number = value;
	}

	public java.lang.Integer getNumber() {
		return this.number;
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
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("TimeSlotId", getTimeSlotId())
				.append("ActId", getActId())
				.append("TimeSlotName", getTimeSlotName())
				.append("Number", getNumber())
				.append("CreateTime", getCreateTime())
				.append("EditTime", getEditTime())
				.append("Editor", getEditor()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getTimeSlotId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof BusinessActivityRegistrationTimeslot == false)
			return false;
		if (this == obj)
			return true;
		BusinessActivityRegistrationTimeslot other = (BusinessActivityRegistrationTimeslot) obj;
		return new EqualsBuilder().append(getTimeSlotId(),
				other.getTimeSlotId()).isEquals();
	}
}