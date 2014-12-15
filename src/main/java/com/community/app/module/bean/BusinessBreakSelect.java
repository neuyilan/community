package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessBreakSelect implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessBreakSelect";

	private java.lang.Integer selectId;
	private java.lang.Integer breakId;
	private java.lang.Integer selectorId;
	private java.sql.Timestamp selectTime;
	private java.lang.String selectorName;
	private java.lang.Integer comId;
	private java.lang.String comName;
	private java.lang.String title;
	private java.lang.Integer newsState;
	
	public java.lang.Integer getNewsState() {
		return newsState;
	}

	public void setNewsState(java.lang.Integer newsState) {
		this.newsState = newsState;
	}

	public java.lang.String getTitle() {
		return title == null?"":title;
	}

	public void setTitle(java.lang.String title) {
		this.title = title;
	}

	private java.lang.Integer isSelected;

	public BusinessBreakSelect(){
	}

	public BusinessBreakSelect(
		java.lang.Integer selectId
	){
		this.selectId = selectId;
	}

	public void setSelectId(java.lang.Integer value) {
		this.selectId = value;
	}
	
	public java.lang.Integer getSelectId() {
		return this.selectId;
	}
	public void setBreakId(java.lang.Integer value) {
		this.breakId = value;
	}
	
	public java.lang.Integer getBreakId() {
		return this.breakId;
	}
	public void setSelectorId(java.lang.Integer value) {
		this.selectorId = value;
	}
	
	public java.lang.Integer getSelectorId() {
		return this.selectorId;
	}
	public void setSelectTime(java.sql.Timestamp value) {
		this.selectTime = value;
	}
	
	public java.sql.Timestamp getSelectTime() {
		return this.selectTime;
	}
	public void setSelectorName(java.lang.String value) {
		this.selectorName = value;
	}
	
	public java.lang.String getSelectorName() {
		return this.selectorName  == null?"":this.selectorName;
	}
	public void setComId(java.lang.Integer value) {
		this.comId = value;
	}
	
	public java.lang.Integer getComId() {
		return this.comId;
	}
	public void setComName(java.lang.String value) {
		this.comName = value;
	}
	
	public java.lang.String getComName() {
		return this.comName == null?"":this.comName;
	}
	public void setIsSelected(java.lang.Integer value) {
		this.isSelected = value;
	}
	
	public java.lang.Integer getIsSelected() {
		return this.isSelected;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("SelectId",getSelectId())
			.append("BreakId",getBreakId())
			.append("SelectorId",getSelectorId())
			.append("SelectTime",getSelectTime())
			.append("SelectorName",getSelectorName())
			.append("ComId",getComId())
			.append("ComName",getComName())
			.append("IsSelected",getIsSelected())
			.append("Title",getTitle())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getSelectId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessBreakSelect == false) return false;
		if(this == obj) return true;
		BusinessBreakSelect other = (BusinessBreakSelect)obj;
		return new EqualsBuilder()
			.append(getSelectId(),other.getSelectId())
			.isEquals();
	}
}

