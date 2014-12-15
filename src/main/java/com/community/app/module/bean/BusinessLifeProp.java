package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class BusinessLifeProp implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessLifeProp";

	private Integer lipoId;
	private Integer propId;
	private Integer serviceId;
	private String propName;
	private String propValue;
	private Integer propType;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private String editor;

	public BusinessLifeProp(){
	}

	public BusinessLifeProp(
		Integer lipoId
	){
		this.lipoId = lipoId;
	}

	public void setLipoId(Integer value) {
		this.lipoId = value;
	}
	
	public Integer getLipoId() {
		return this.lipoId;
	}
	public void setPropId(Integer value) {
		this.propId = value;
	}
	
	public Integer getPropId() {
		return this.propId;
	}
	public void setServiceId(Integer value) {
		this.serviceId = value;
	}
	
	public Integer getServiceId() {
		return this.serviceId;
	}
	public void setPropName(String value) {
		this.propName = value;
	}
	
	public String getPropName() {
		return this.propName;
	}
	public void setPropValue(String value) {
		this.propValue = value;
	}
	
	public String getPropValue() {
		return this.propValue;
	}
	public void setPropType(Integer value) {
		this.propType = value;
	}
	
	public Integer getPropType() {
		return this.propType;
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
	public void setEditor(String value) {
		this.editor = value;
	}
	
	public String getEditor() {
		return this.editor;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("LipoId",getLipoId())
			.append("PropId",getPropId())
			.append("ServiceId",getServiceId())
			.append("PropName",getPropName())
			.append("PropValue",getPropValue())
			.append("PropType",getPropType())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getLipoId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessLifeProp == false) return false;
		if(this == obj) return true;
		BusinessLifeProp other = (BusinessLifeProp)obj;
		return new EqualsBuilder()
			.append(getLipoId(),other.getLipoId())
			.isEquals();
	}
}

