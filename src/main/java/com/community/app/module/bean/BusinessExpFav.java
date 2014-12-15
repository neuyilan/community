package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class BusinessExpFav implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessExpFav";

	private Integer favorableId=0;
	private String startDate="";
	private String endDate="";
	private String info="";
	private java.sql.Timestamp createTime;
	private String editor="";
	private java.sql.Timestamp editTime;
	private Integer stationId=0;
	private String addrName="";
	private String addrUrl="";
	private String staTel="";
	
	public String getStaTel() {
		return staTel;
	}

	public void setStaTel(String staTel) {
		this.staTel = staTel;
	}

	public String getAddrName() {
		return addrName;
	}

	public void setAddrName(String addrName) {
		this.addrName = addrName;
	}

	public String getAddrUrl() {
		return addrUrl;
	}

	public void setAddrUrl(String addrUrl) {
		this.addrUrl = addrUrl;
	}

	public Integer getStationId() {
		return stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

	public BusinessExpFav(){
	}

	public BusinessExpFav(
		Integer favorableId
	){
		this.favorableId = favorableId;
	}

	public void setFavorableId(Integer value) {
		this.favorableId = value;
	}
	
	public Integer getFavorableId() {
		return this.favorableId;
	}
	public void setStartDate(String value) {
		this.startDate = value;
	}
	
	public String getStartDate() {
		return this.startDate;
	}
	public void setEndDate(String value) {
		this.endDate = value;
	}
	
	public String getEndDate() {
		return this.endDate;
	}
	public void setInfo(String value) {
		this.info = value;
	}
	
	public String getInfo() {
		return this.info;
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
	public void setEditTime(java.sql.Timestamp value) {
		this.editTime = value;
	}
	
	public java.sql.Timestamp getEditTime() {
		return this.editTime;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("FavorableId",getFavorableId())
			.append("StartDate",getStartDate())
			.append("EndDate",getEndDate())
			.append("Info",getInfo())
			.append("CreateTime",getCreateTime())
			.append("Editor",getEditor())
			.append("EditTime",getEditTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getFavorableId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessExpFav == false) return false;
		if(this == obj) return true;
		BusinessExpFav other = (BusinessExpFav)obj;
		return new EqualsBuilder()
			.append(getFavorableId(),other.getFavorableId())
			.isEquals();
	}
}

