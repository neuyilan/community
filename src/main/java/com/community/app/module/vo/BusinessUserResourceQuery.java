package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessUserResource;

public class BusinessUserResourceQuery extends BaseBean {
	

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

	public BusinessUserResourceQuery(BusinessUserResource businessUserResource) {
		this.usreId = businessUserResource.getUsreId();
		this.userId = businessUserResource.getUserId();
		this.estateId = businessUserResource.getEstateId();
		this.buildingId = businessUserResource.getBuildingId();
		this.unitId = businessUserResource.getUnitId();
		this.estateName = businessUserResource.getEstateName();
		this.buildingName = businessUserResource.getBuildingName();
		this.unitName = businessUserResource.getUnitName();
		this.createTime = businessUserResource.getCreateTime();
		this.editTime = businessUserResource.getEditTime();
		this.editor = businessUserResource.getEditor();
		this.comId = businessUserResource.getComId();
	}
	
	public Integer getComId() {
		return comId;
	}

	public void setComId(Integer comId) {
		this.comId = comId;
	}

	public BusinessUserResourceQuery() {
		
	}	
	
	public Integer getUsreId() {
		return this.usreId;
	}
	
	public void setUsreId(Integer value) {
		this.usreId = value;
	}
		
	public Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(Integer value) {
		this.userId = value;
	}
		
	public Integer getEstateId() {
		return this.estateId;
	}
	
	public void setEstateId(Integer value) {
		this.estateId = value;
	}
		
	public Integer getBuildingId() {
		return this.buildingId;
	}
	
	public void setBuildingId(Integer value) {
		this.buildingId = value;
	}
		
	public Integer getUnitId() {
		return this.unitId;
	}
	
	public void setUnitId(Integer value) {
		this.unitId = value;
	}
		
	public String getEstateName() {
		return this.estateName;
	}
	
	public void setEstateName(String value) {
		this.estateName = value;
	}
		
	public String getBuildingName() {
		return this.buildingName;
	}
	
	public void setBuildingName(String value) {
		this.buildingName = value;
	}
		
	public String getUnitName() {
		return this.unitName;
	}
	
	public void setUnitName(String value) {
		this.unitName = value;
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
		
	public String getEditor() {
		return this.editor;
	}
	
	public void setEditor(String value) {
		this.editor = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

