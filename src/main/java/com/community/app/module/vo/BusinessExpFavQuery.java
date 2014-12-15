package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

import com.community.app.module.bean.BusinessExpFav;
import com.community.app.module.vo.BaseBean;

public class BusinessExpFavQuery extends BaseBean {
	

	private Integer favorableId;
	private String startDate;
	private String endDate;
	private String info;
	private java.sql.Timestamp createTime;
	private String editor;
	private java.sql.Timestamp editTime;
	private Integer stationId;
	private Integer userId;
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getStationId() {
		return stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

	public BusinessExpFavQuery(BusinessExpFav businessExpFav) {
		this.favorableId = businessExpFav.getFavorableId();
		this.startDate = businessExpFav.getStartDate();
		this.endDate = businessExpFav.getEndDate();
		this.info = businessExpFav.getInfo();
		this.createTime = businessExpFav.getCreateTime();
		this.editor = businessExpFav.getEditor();
		this.editTime = businessExpFav.getEditTime();
	}
	
	public BusinessExpFavQuery() {
		
	}	
	
	public Integer getFavorableId() {
		return this.favorableId;
	}
	
	public void setFavorableId(Integer value) {
		this.favorableId = value;
	}
		
	public String getStartDate() {
		return this.startDate;
	}
	
	public void setStartDate(String value) {
		this.startDate = value;
	}
		
	public String getEndDate() {
		return this.endDate;
	}
	
	public void setEndDate(String value) {
		this.endDate = value;
	}
		
	public String getInfo() {
		return this.info;
	}
	
	public void setInfo(String value) {
		this.info = value;
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
		
	public java.sql.Timestamp getEditTime() {
		return this.editTime;
	}
	
	public void setEditTime(java.sql.Timestamp value) {
		this.editTime = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

