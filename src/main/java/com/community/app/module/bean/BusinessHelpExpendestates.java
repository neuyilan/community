package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessHelpExpendestates implements java.io.Serializable {

	// 别名
	public static final String TABLE_ALIAS = "BusinessHelpExpendestates";

	private java.lang.Integer expendEstatesId;
	private java.lang.Integer helpId;
	private java.lang.Integer estateId;
	private java.sql.Timestamp createTime;
	private java.lang.String estateName;

	public java.lang.String getEstateName() {
		return estateName;
	}

	public void setEstateName(java.lang.String estateName) {
		this.estateName = estateName;
	}

	public BusinessHelpExpendestates() {
	}

	public BusinessHelpExpendestates(java.lang.Integer expendEstatesId) {
		this.expendEstatesId = expendEstatesId;
	}

	public void setExpendEstatesId(java.lang.Integer value) {
		this.expendEstatesId = value;
	}

	public java.lang.Integer getExpendEstatesId() {
		return this.expendEstatesId;
	}

	public void setHelpId(java.lang.Integer value) {
		this.helpId = value;
	}

	public java.lang.Integer getHelpId() {
		return this.helpId;
	}

	public void setEstateId(java.lang.Integer value) {
		this.estateId = value;
	}

	public java.lang.Integer getEstateId() {
		return this.estateId;
	}

	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}

	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("ExpendEstatesId", getExpendEstatesId())
				.append("HelpId", getHelpId())
				.append("EstateId", getEstateId())
				.append("CreateTime", getCreateTime()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getExpendEstatesId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof BusinessHelpExpendestates == false)
			return false;
		if (this == obj)
			return true;
		BusinessHelpExpendestates other = (BusinessHelpExpendestates) obj;
		return new EqualsBuilder().append(getExpendEstatesId(),
				other.getExpendEstatesId()).isEquals();
	}
}