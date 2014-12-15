package com.community.app.module.vo;

import com.community.app.module.bean.BusinessProduct;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessProductPic;
import com.community.app.module.vo.BaseBean;

public class BusinessProductPicQuery extends BaseBean {
	

	private Integer productId;
	private Integer picId;
	private String picPath;
	private java.sql.Timestamp createTime;
	private String editor;

	public BusinessProductPicQuery(BusinessProductPic businessProductPic) {
		this.productId = businessProductPic.getProductId();
		this.picId = businessProductPic.getPicId();
		this.picPath = businessProductPic.getPicPath();
		this.createTime = businessProductPic.getCreateTime();
		this.editor = businessProductPic.getEditor();
	    this.businessProduct = businessProductPic.getBusinessProduct();
	}
	
	public BusinessProductPicQuery() {
		
	}	
	
	public Integer getProductId() {
		return this.productId;
	}
	
	public void setProductId(Integer value) {
		this.productId = value;
	}
		
	public Integer getPicId() {
		return this.picId;
	}
	
	public void setPicId(Integer value) {
		this.picId = value;
	}
		
	public String getPicPath() {
		return this.picPath;
	}
	
	public void setPicPath(String value) {
		this.picPath = value;
	}
		
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
		
	public String getEditor() {
		return this.editor;
	}
	
	public void setEditor(String value) {
		this.editor = value;
	}
		

private BusinessProduct businessProduct;

public void setBusinessProduct(BusinessProduct businessProduct){
	this.businessProduct = businessProduct;
}

public BusinessProduct getBusinessProduct() {
	return businessProduct;
}
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

