package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessStationFeedback implements java.io.Serializable {

	// 别名
	public static final String TABLE_ALIAS = "BusinessStationFeedback";

	private java.lang.Integer feedId;
	private java.lang.Integer comId;
	private java.lang.String comName;
	private java.lang.Integer estateId;
	private java.lang.String estateName;
	private java.lang.Integer state;
	private java.lang.Integer totalPoll;
	private java.lang.Integer yznh;
	private java.lang.Integer kdds;
	private java.lang.Integer yzgg;
	
	public java.lang.Integer getYznh() {
		return yznh;
	}

	public void setYznh(java.lang.Integer yznh) {
		this.yznh = yznh;
	}

	public java.lang.Integer getKdds() {
		return kdds;
	}

	public void setKdds(java.lang.Integer kdds) {
		this.kdds = kdds;
	}

	public java.lang.Integer getYzgg() {
		return yzgg;
	}

	public void setYzgg(java.lang.Integer yzgg) {
		this.yzgg = yzgg;
	}

	public BusinessStationFeedback() {
	}

	public BusinessStationFeedback(java.lang.Integer feedId) {
		this.feedId = feedId;
	}

	public void setFeedId(java.lang.Integer value) {
		this.feedId = value;
	}

	public java.lang.Integer getFeedId() {
		return this.feedId;
	}

	public void setComId(java.lang.Integer value) {
		this.comId = value;
	}

	public java.lang.Integer getComId() {
		return this.comId;
	}

	public void setComName(java.lang.String value) {
		this.comName = value;
	}

	public java.lang.String getComName() {
		return this.comName;
	}

	public void setEstateId(java.lang.Integer value) {
		this.estateId = value;
	}

	public java.lang.Integer getEstateId() {
		return this.estateId;
	}

	public void setEstateName(java.lang.String value) {
		this.estateName = value;
	}

	public java.lang.String getEstateName() {
		return this.estateName;
	}

	public void setState(java.lang.Integer value) {
		this.state = value;
	}

	public java.lang.Integer getState() {
		return this.state;
	}

	public void setTotalPoll(java.lang.Integer value) {
		this.totalPoll = value;
	}

	public java.lang.Integer getTotalPoll() {
		return this.totalPoll;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("FeedId", getFeedId()).append("ComId", getComId())
				.append("ComName", getComName())
				.append("EstateId", getEstateId())
				.append("EstateName", getEstateName())
				.append("State", getState())
				.append("TotalPoll", getTotalPoll()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getFeedId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof BusinessStationFeedback == false)
			return false;
		if (this == obj)
			return true;
		BusinessStationFeedback other = (BusinessStationFeedback) obj;
		return new EqualsBuilder().append(getFeedId(), other.getFeedId())
				.isEquals();
	}
}