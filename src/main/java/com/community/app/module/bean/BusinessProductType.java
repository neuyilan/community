package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class BusinessProductType implements java.io.Serializable {

	// 别名
	public static final String TABLE_ALIAS = "BusinessProductType";

	private java.lang.Integer typeId;
	private java.lang.String typeName;
	private java.lang.String typeImage;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public BusinessProductType() {
	}

	public BusinessProductType(java.lang.Integer typeId) {
		this.typeId = typeId;
	}

	public void setTypeId(java.lang.Integer value) {
		this.typeId = value;
	}

	public java.lang.Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeName(java.lang.String value) {
		this.typeName = value;
	}

	public java.lang.String getTypeName() {
		return this.typeName;
	}

	public void setTypeImage(java.lang.String value) {
		this.typeImage = value;
	}

	public java.lang.String getTypeImage() {
		return this.typeImage;
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
				.append("TypeId", getTypeId())
				.append("TypeName", getTypeName())
				.append("TypeImage", getTypeImage())
				.append("CreateTime", getCreateTime())
				.append("EditTime", getEditTime())
				.append("Editor", getEditor()).toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getTypeId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof BusinessProductType == false)
			return false;
		if (this == obj)
			return true;
		BusinessProductType other = (BusinessProductType) obj;
		return new EqualsBuilder().append(getTypeId(), other.getTypeId())
				.isEquals();
	}
}