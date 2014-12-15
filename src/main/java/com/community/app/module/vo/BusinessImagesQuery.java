package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessImages;

public class BusinessImagesQuery extends BaseBean {

	private java.lang.Integer imgId;
	private java.lang.String imgName;
	private java.lang.String imgPath;
	private java.lang.Integer imgType;

	public BusinessImagesQuery(BusinessImages businessImages) {
		this.imgId = businessImages.getImgId();
		this.imgName = businessImages.getImgName();
		this.imgPath = businessImages.getImgPath();
		this.imgType = businessImages.getImgType();
	}

	public BusinessImagesQuery() {

	}

	public java.lang.Integer getImgId() {
		return this.imgId;
	}

	public void setImgId(java.lang.Integer value) {
		this.imgId = value;
	}

	public java.lang.String getImgName() {
		return this.imgName;
	}

	public void setImgName(java.lang.String value) {
		this.imgName = value;
	}

	public java.lang.String getImgPath() {
		return this.imgPath;
	}

	public void setImgPath(java.lang.String value) {
		this.imgPath = value;
	}

	public java.lang.Integer getImgType() {
		return this.imgType;
	}

	public void setImgType(java.lang.Integer value) {
		this.imgType = value;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}