package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;

public class BusinessTypeProperty implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessTypeProperty";

	private Integer propId;
	private Integer typeId;
	private String propName;
	private String propDesc;
	private Integer propType;
	private Integer parentId;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private String editor;

	public BusinessTypeProperty(){
	}

	public BusinessTypeProperty(
		Integer propId
	){
		this.propId = propId;
	}

	public void setPropId(Integer value) {
		this.propId = value;
	}
	
	public Integer getPropId() {
		return this.propId;
	}
	public void setTypeId(Integer value) {
		this.typeId = value;
	}
	
	public Integer getTypeId() {
		return this.typeId;
	}
	public void setPropName(String value) {
		this.propName = value;
	}
	
	public String getPropName() {
		return this.propName;
	}
	public void setPropDesc(String value) {
		this.propDesc = value;
	}
	
	public String getPropDesc() {
		return this.propDesc;
	}
	public void setPropType(Integer value) {
		this.propType = value;
	}
	
	public Integer getPropType() {
		return this.propType;
	}
	public void setParentId(Integer value) {
		this.parentId = value;
	}
	
	public Integer getParentId() {
		return this.parentId;
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
	
	private BusinessLifeType businessLifeType;
	
	public void setBusinessLifeType(BusinessLifeType businessLifeType){
		this.businessLifeType = businessLifeType;
	}
	
	public BusinessLifeType getBusinessLifeType() {
		return businessLifeType;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("PropId",getPropId())
			.append("TypeId",getTypeId())
			.append("PropName",getPropName())
			.append("PropDesc",getPropDesc())
			.append("PropType",getPropType())
			.append("ParentId",getParentId())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getPropId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessTypeProperty == false) return false;
		if(this == obj) return true;
		BusinessTypeProperty other = (BusinessTypeProperty)obj;
		return new EqualsBuilder()
			.append(getPropId(),other.getPropId())
			.isEquals();
	}
}

