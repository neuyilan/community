package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessPropertyMaterial;

public class BusinessPropertyMaterialQuery extends BaseBean {
	

	private java.lang.Integer materialId;
	private java.lang.Integer proId;
	private java.lang.String materialName;
	private java.lang.String icon;
	private java.lang.String link;
	private java.lang.Integer ID;
	private java.lang.Integer buildingId;
	private java.lang.Integer userId;
	
	
	
	
	public java.lang.Integer getUserId() {
		return userId;
	}

	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	public java.lang.Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(java.lang.Integer buildingId) {
		this.buildingId = buildingId;
	}

	public java.lang.Integer getID() {
		return ID;
	}

	public void setID(java.lang.Integer iD) {
		ID = iD;
	}

	public BusinessPropertyMaterialQuery(BusinessPropertyMaterial businessPropertyMaterial) {
		this.materialId = businessPropertyMaterial.getMaterialId();
		this.proId = businessPropertyMaterial.getProId();
		this.materialName = businessPropertyMaterial.getMaterialName();
		this.icon = businessPropertyMaterial.getIcon();
		this.link = businessPropertyMaterial.getLink();
	}
	
	public BusinessPropertyMaterialQuery() {
		
	}	
	
	public java.lang.Integer getMaterialId() {
		return this.materialId;
	}
	
	public void setMaterialId(java.lang.Integer value) {
		this.materialId = value;
	}
		
	public java.lang.Integer getProId() {
		return this.proId;
	}
	
	public void setProId(java.lang.Integer value) {
		this.proId = value;
	}
		
	public java.lang.String getMaterialName() {
		return this.materialName;
	}
	
	public void setMaterialName(java.lang.String value) {
		this.materialName = value;
	}
		
	public java.lang.String getIcon() {
		return this.icon;
	}
	
	public void setIcon(java.lang.String value) {
		this.icon = value;
	}
		
	public java.lang.String getLink() {
		return this.link;
	}
	
	public void setLink(java.lang.String value) {
		this.link = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

