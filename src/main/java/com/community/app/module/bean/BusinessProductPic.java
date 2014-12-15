package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessProductPic implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessProductPic";

	private Integer productId;
	private Integer picId;
	private String picPath;
	private java.sql.Timestamp createTime;
	private String editor;

	public BusinessProductPic(){
	}

	public void setProductId(Integer value) {
		this.productId = value;
	}
	
	public Integer getProductId() {
		return this.productId;
	}
	public void setPicId(Integer value) {
		this.picId = value;
	}
	
	public Integer getPicId() {
		return this.picId;
	}
	public void setPicPath(String value) {
		this.picPath = value;
	}
	
	public String getPicPath() {
		return this.picPath;
	}
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
	
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	public void setEditor(String value) {
		this.editor = value;
	}
	
	public String getEditor() {
		return this.editor;
	}
	
	private BusinessProduct businessProduct;
	
	public void setBusinessProduct(BusinessProduct businessProduct){
		this.businessProduct = businessProduct;
	}
	
	public BusinessProduct getBusinessProduct() {
		return businessProduct;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("ProductId",getProductId())
			.append("PicId",getPicId())
			.append("PicPath",getPicPath())
			.append("CreateTime",getCreateTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessProductPic == false) return false;
		if(this == obj) return true;
		BusinessProductPic other = (BusinessProductPic)obj;
		return new EqualsBuilder()
			.isEquals();
	}
}

