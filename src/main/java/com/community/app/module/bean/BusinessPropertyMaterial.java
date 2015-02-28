package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessPropertyMaterial implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessPropertyMaterial";

	private java.lang.Integer materialId;
	private java.lang.Integer proId;
	private java.lang.String materialName;
	private java.lang.String icon;
	private java.lang.String link;

	public BusinessPropertyMaterial(){
	}

	public BusinessPropertyMaterial(
		java.lang.Integer materialId
	){
		this.materialId = materialId;
	}

	public void setMaterialId(java.lang.Integer value) {
		this.materialId = value;
	}
	
	public java.lang.Integer getMaterialId() {
		return this.materialId;
	}
	public void setProId(java.lang.Integer value) {
		this.proId = value;
	}
	
	public java.lang.Integer getProId() {
		return this.proId;
	}
	public void setMaterialName(java.lang.String value) {
		this.materialName = value;
	}
	
	public java.lang.String getMaterialName() {
		return this.materialName;
	}
	public void setIcon(java.lang.String value) {
		this.icon = value;
	}
	
	public java.lang.String getIcon() {
		return this.icon;
	}
	public void setLink(java.lang.String value) {
		this.link = value;
	}
	
	public java.lang.String getLink() {
		return this.link;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("MaterialId",getMaterialId())
			.append("ProId",getProId())
			.append("MaterialName",getMaterialName())
			.append("Icon",getIcon())
			.append("Link",getLink())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getMaterialId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessPropertyMaterial == false) return false;
		if(this == obj) return true;
		BusinessPropertyMaterial other = (BusinessPropertyMaterial)obj;
		return new EqualsBuilder()
			.append(getMaterialId(),other.getMaterialId())
			.isEquals();
	}
}

