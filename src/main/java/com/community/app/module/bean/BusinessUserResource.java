package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class BusinessUserResource implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessUserResource";

	private Integer usreId;
	private Integer userId;
	private Integer estateId;
	private Integer buildingId;
	private Integer unitId;
	private String estateName;
	private String buildingName;
	private String unitName;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private String editor;
	private Integer comId;

	public Integer getComId() {
		return comId;
	}

	public void setComId(Integer comId) {
		this.comId = comId;
	}

	public BusinessUserResource(){
	}

	public BusinessUserResource(
		Integer usreId
	){
		this.usreId = usreId;
	}

	public void setUsreId(Integer value) {
		this.usreId = value;
	}
	
	public Integer getUsreId() {
		return this.usreId;
	}
	public void setUserId(Integer value) {
		this.userId = value;
	}
	
	public Integer getUserId() {
		return this.userId;
	}
	public void setEstateId(Integer value) {
		this.estateId = value;
	}
	
	public Integer getEstateId() {
		return this.estateId;
	}
	public void setBuildingId(Integer value) {
		this.buildingId = value;
	}
	
	public Integer getBuildingId() {
		return this.buildingId;
	}
	public void setUnitId(Integer value) {
		this.unitId = value;
	}
	
	public Integer getUnitId() {
		return this.unitId;
	}
	public void setEstateName(String value) {
		this.estateName = value;
	}
	
	public String getEstateName() {
		return this.estateName;
	}
	public void setBuildingName(String value) {
		this.buildingName = value;
	}
	
	public String getBuildingName() {
		return this.buildingName;
	}
	public void setUnitName(String value) {
		this.unitName = value;
	}
	
	public String getUnitName() {
		return this.unitName;
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
			.append("UsreId",getUsreId())
			.append("UserId",getUserId())
			.append("EstateId",getEstateId())
			.append("BuildingId",getBuildingId())
			.append("UnitId",getUnitId())
			.append("EstateName",getEstateName())
			.append("BuildingName",getBuildingName())
			.append("UnitName",getUnitName())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getUsreId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessUserResource == false) return false;
		if(this == obj) return true;
		BusinessUserResource other = (BusinessUserResource)obj;
		return new EqualsBuilder()
			.append(getUsreId(),other.getUsreId())
			.isEquals();
	}
}

