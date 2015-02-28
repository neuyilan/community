package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessLifeType;
import com.community.app.module.bean.BusinessTypeProperty;

public class BusinessTypePropertyQuery extends BaseBean {
	

	private Integer propId;
	private Integer typeId;
	private String propName;
	private String propDesc;
	private Integer propType;
	private Integer parentId;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private String editor;

	public BusinessTypePropertyQuery(BusinessTypeProperty businessTypeProperty) {
		this.propId = businessTypeProperty.getPropId();
		this.typeId = businessTypeProperty.getTypeId();
		this.propName = businessTypeProperty.getPropName();
		this.propDesc = businessTypeProperty.getPropDesc();
		this.propType = businessTypeProperty.getPropType();
		this.parentId = businessTypeProperty.getParentId();
		this.createTime = businessTypeProperty.getCreateTime();
		this.editTime = businessTypeProperty.getEditTime();
		this.editor = businessTypeProperty.getEditor();
	    this.businessLifeType = businessTypeProperty.getBusinessLifeType();
	}
	
	public BusinessTypePropertyQuery() {
		
	}	
	
	public Integer getPropId() {
		return this.propId;
	}
	
	public void setPropId(Integer value) {
		this.propId = value;
	}
		
	public Integer getTypeId() {
		return this.typeId;
	}
	
	public void setTypeId(Integer value) {
		this.typeId = value;
	}
		
	public String getPropName() {
		return this.propName;
	}
	
	public void setPropName(String value) {
		this.propName = value;
	}
		
	public String getPropDesc() {
		return this.propDesc;
	}
	
	public void setPropDesc(String value) {
		this.propDesc = value;
	}
		
	public Integer getPropType() {
		return this.propType;
	}
	
	public void setPropType(Integer value) {
		this.propType = value;
	}
		
	public Integer getParentId() {
		return this.parentId;
	}
	
	public void setParentId(Integer value) {
		this.parentId = value;
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
		

private BusinessLifeType businessLifeType;

public void setBusinessLifeType(BusinessLifeType businessLifeType){
	this.businessLifeType = businessLifeType;
}

public BusinessLifeType getBusinessLifeType() {
	return businessLifeType;
}
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

