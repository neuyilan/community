package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessStationFeedbackInformation implements java.io.Serializable {

	// 别名
	public static final String TABLE_ALIAS = "BusinessStationFeedbackInformation";

	private java.lang.Integer inforId;
	private java.lang.Integer feedId;
	private java.lang.Integer userId;
	private java.sql.Timestamp feedTime;
	private java.lang.Integer source;
	private java.lang.Integer flag;

	public BusinessStationFeedbackInformation() {
	}

	public BusinessStationFeedbackInformation(java.lang.Integer inforId) {
		this.inforId = inforId;
	}

	public void setInforId(java.lang.Integer value) {
		this.inforId = value;
	}

	public java.lang.Integer getInforId() {
		return this.inforId;
	}

	public void setFeedId(java.lang.Integer value) {
		this.feedId = value;
	}

	public java.lang.Integer getFeedId() {
		return this.feedId;
	}

	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}

	public java.lang.Integer getUserId() {
		return this.userId;
	}

	public void setFeedTime(java.sql.Timestamp value) {
		this.feedTime = value;
	}

	public java.sql.Timestamp getFeedTime() {
		return this.feedTime;
	}

	public void setSource(java.lang.Integer value) {
		this.source = value;
	}

	public java.lang.Integer getSource() {
		return this.source;
	}

	public void setFlag(java.lang.Integer value) {
		this.flag = value;
	}

	public java.lang.Integer getFlag() {
		return this.flag;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("InforId", getInforId()).append("FeedId", getFeedId())
				.append("UserId", getUserId())
				.append("FeedTime", getFeedTime())
				.append("Source", getSource()).append("Flag", getFlag())
				.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getInforId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof BusinessStationFeedbackInformation == false)
			return false;
		if (this == obj)
			return true;
		BusinessStationFeedbackInformation other = (BusinessStationFeedbackInformation) obj;
		return new EqualsBuilder().append(getInforId(), other.getInforId())
				.isEquals();
	}
}
