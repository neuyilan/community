package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessLifeProp;
import com.community.app.module.vo.BaseBean;

public class BusinessLifePropQuery extends BaseBean {
	

	private Integer lipoId;
	private Integer propId;
	private Integer serviceId;
	private String propName;
	private String propValue;
	private Integer propType;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private String editor;

	public BusinessLifePropQuery(BusinessLifeProp businessLifeProp) {
		this.lipoId = businessLifeProp.getLipoId();
		this.propId = businessLifeProp.getPropId();
		this.serviceId = businessLifeProp.getServiceId();
		this.propName = businessLifeProp.getPropName();
		this.propValue = businessLifeProp.getPropValue();
		this.propType = businessLifeProp.getPropType();
		this.createTime = businessLifeProp.getCreateTime();
		this.editTime = businessLifeProp.getEditTime();
		this.editor = businessLifeProp.getEditor();
	}
	
	public BusinessLifePropQuery() {
		
	}	
	
	public Integer getLipoId() {
		return this.lipoId;
	}
	
	public void setLipoId(Integer value) {
		this.lipoId = value;
	}
		
	public Integer getPropId() {
		return this.propId;
	}
	
	public void setPropId(Integer value) {
		this.propId = value;
	}
		
	public Integer getServiceId() {
		return this.serviceId;
	}
	
	public void setServiceId(Integer value) {
		this.serviceId = value;
	}
		
	public String getPropName() {
		return this.propName;
	}
	
	public void setPropName(String value) {
		this.propName = value;
	}
		
	public String getPropValue() {
		return this.propValue;
	}
	
	public void setPropValue(String value) {
		this.propValue = value;
	}
		
	public Integer getPropType() {
		return this.propType;
	}
	
	public void setPropType(Integer value) {
		this.propType = value;
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

