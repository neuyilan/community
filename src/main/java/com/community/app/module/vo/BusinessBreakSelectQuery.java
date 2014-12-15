package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessBreakSelect;
import com.community.app.module.vo.BaseBean;

public class BusinessBreakSelectQuery extends BaseBean {
	

	private java.lang.Integer selectId;
	private java.lang.Integer breakId;
	private java.lang.Integer selectorId;
	private java.sql.Timestamp selectTime;
	private java.lang.String selectorName;
	private java.lang.Integer comId;
	private java.lang.String comName;
	private java.lang.String title;
	private java.lang.Integer isSelected;

	public BusinessBreakSelectQuery(BusinessBreakSelect businessBreakSelect) {
		this.selectId = businessBreakSelect.getSelectId();
		this.breakId = businessBreakSelect.getBreakId();
		this.selectorId = businessBreakSelect.getSelectorId();
		this.selectTime = businessBreakSelect.getSelectTime();
		this.selectorName = businessBreakSelect.getSelectorName();
		this.comId = businessBreakSelect.getComId();
		this.comName = businessBreakSelect.getComName();
		this.isSelected = businessBreakSelect.getIsSelected();
		this.title = businessBreakSelect.getTitle();
	}
	
	public java.lang.String getTitle() {
		return title;
	}

	public void setTitle(java.lang.String title) {
		this.title = title;
	}

	public BusinessBreakSelectQuery() {
		
	}	
	
	public java.lang.Integer getSelectId() {
		return this.selectId;
	}
	
	public void setSelectId(java.lang.Integer value) {
		this.selectId = value;
	}
		
	public java.lang.Integer getBreakId() {
		return this.breakId;
	}
	
	public void setBreakId(java.lang.Integer value) {
		this.breakId = value;
	}
		
	public java.lang.Integer getSelectorId() {
		return this.selectorId;
	}
	
	public void setSelectorId(java.lang.Integer value) {
		this.selectorId = value;
	}
		
	public java.sql.Timestamp getSelectTime() {
		return this.selectTime;
	}
	
	public void setSelectTime(java.sql.Timestamp value) {
		this.selectTime = value;
	}
		
	public java.lang.String getSelectorName() {
		return this.selectorName;
	}
	
	public void setSelectorName(java.lang.String value) {
		this.selectorName = value;
	}
		
	public java.lang.Integer getComId() {
		return this.comId;
	}
	
	public void setComId(java.lang.Integer value) {
		this.comId = value;
	}
		
	public java.lang.String getComName() {
		return this.comName;
	}
	
	public void setComName(java.lang.String value) {
		this.comName = value;
	}
		
	public java.lang.Integer getIsSelected() {
		return this.isSelected;
	}
	
	public void setIsSelected(java.lang.Integer value) {
		this.isSelected = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

