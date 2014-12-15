package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.ManageUnit;
import com.community.app.module.vo.BaseBean;

public class ManageUnitQuery extends BaseBean {
	

	private java.lang.Integer unitId;
	private java.lang.Integer buildingId;
	private java.lang.String unitName;
	private java.lang.Double estateLongitude;
	private java.lang.Double estateLatitude;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.String unitMap;

	public ManageUnitQuery(ManageUnit manageUnit) {
		this.unitId = manageUnit.getUnitId();
		this.buildingId = manageUnit.getBuildingId();
		this.unitName = manageUnit.getUnitName();
		this.estateLongitude = manageUnit.getEstateLongitude();
		this.estateLatitude = manageUnit.getEstateLatitude();
		this.createTime = manageUnit.getCreateTime();
		this.editTime = manageUnit.getEditTime();
		this.editor = manageUnit.getEditor();
		this.unitMap = manageUnit.getUnitMap();
	}
	
	public ManageUnitQuery() {
		
	}	
	
	public java.lang.Integer getUnitId() {
		return this.unitId;
	}
	
	public void setUnitId(java.lang.Integer value) {
		this.unitId = value;
	}
		
	public java.lang.Integer getBuildingId() {
		return this.buildingId;
	}
	
	public void setBuildingId(java.lang.Integer value) {
		this.buildingId = value;
	}
		
	public java.lang.String getUnitName() {
		return this.unitName;
	}
	
	public void setUnitName(java.lang.String value) {
		this.unitName = value;
	}
		
	public java.lang.Double getEstateLongitude() {
		return this.estateLongitude;
	}
	
	public void setEstateLongitude(java.lang.Double value) {
		this.estateLongitude = value;
	}
		
	public java.lang.Double getEstateLatitude() {
		return this.estateLatitude;
	}
	
	public void setEstateLatitude(java.lang.Double value) {
		this.estateLatitude = value;
	}
		
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
		
	public java.sql.Timestamp getEditTime() {
		return this.editTime;
	}
	
	public void setEditTime(java.sql.Timestamp value) {
		this.editTime = value;
	}
		
	public java.lang.String getEditor() {
		return this.editor;
	}
	
	public void setEditor(java.lang.String value) {
		this.editor = value;
	}
		
	public java.lang.String getUnitMap() {
		return this.unitMap;
	}
	
	public void setUnitMap(java.lang.String value) {
		this.unitMap = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

