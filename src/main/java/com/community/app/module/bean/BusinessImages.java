package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessImages implements java.io.Serializable {

	// 别名
	public static final String TABLE_ALIAS = "BusinessImages";

	private java.lang.Integer imgId;
	private java.lang.String imgName;
	private java.lang.String imgPath;
	private java.lang.Integer imgType;

	public BusinessImages() {
	}

	public BusinessImages(java.lang.Integer imgId) {
		this.imgId = imgId;
	}

	public void setImgId(java.lang.Integer value) {
		this.imgId = value;
	}

	public java.lang.Integer getImgId() {
		return this.imgId;
	}

	public void setImgName(java.lang.String value) {
		this.imgName = value;
	}

	public java.lang.String getImgName() {
		return this.imgName;
	}

	public void setImgPath(java.lang.String value) {
		this.imgPath = value;
	}

	public java.lang.String getImgPath() {
		return this.imgPath;
	}

	public void setImgType(java.lang.Integer value) {
		this.imgType = value;
	}

	public java.lang.Integer getImgType() {
		return this.imgType;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("ImgId", getImgId()).append("ImgName", getImgName())
				.append("ImgPath", getImgPath())
				.append("ImgType", getImgType()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getImgId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof BusinessImages == false)
			return false;
		if (this == obj)
			return true;
		BusinessImages other = (BusinessImages) obj;
		return new EqualsBuilder().append(getImgId(), other.getImgId())
				.isEquals();
	}
}