package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessStation;
import com.community.app.module.vo.BaseBean;

public class BusinessStationQuery extends BaseBean {
	

	private Integer stationId;
	private Integer orgId;
	private String staName;
	private String staBrief;
	private String staService;
	private String staTel;
	private String staEmail;
	private String staWeixin;
	private String staIcon;
	private Double staLongitude;
	private Double staLatitude;
	private java.sql.Timestamp crateTime;
	private java.sql.Timestamp editTime;
	private String editor;
	private String staCode;

	public BusinessStationQuery(BusinessStation businessStation) {
		this.stationId = businessStation.getStationId();
		this.orgId = businessStation.getOrgId();
		this.staName = businessStation.getStaName();
		this.staBrief = businessStation.getStaBrief();
		this.staService = businessStation.getStaService();
		this.staTel = businessStation.getStaTel();
		this.staEmail = businessStation.getStaEmail();
		this.staWeixin = businessStation.getStaWeixin();
		this.staIcon = businessStation.getStaIcon();
		this.staLongitude = businessStation.getStaLongitude();
		this.staLatitude = businessStation.getStaLatitude();
		this.crateTime = businessStation.getCrateTime();
		this.editTime = businessStation.getEditTime();
		this.editor = businessStation.getEditor();
		this.staCode = businessStation.getStaCode();
	}
	
	public BusinessStationQuery() {
		
	}	
	
	public Integer getStationId() {
		return this.stationId;
	}
	
	public void setStationId(Integer value) {
		this.stationId = value;
	}
		
	public Integer getOrgId() {
		return this.orgId;
	}
	
	public void setOrgId(Integer value) {
		this.orgId = value;
	}
		
	public String getStaName() {
		return this.staName;
	}
	
	public void setStaName(String value) {
		this.staName = value;
	}
		
	public String getStaBrief() {
		return this.staBrief;
	}
	
	public void setStaBrief(String value) {
		this.staBrief = value;
	}
		
	public String getStaService() {
		return this.staService;
	}
	
	public void setStaService(String value) {
		this.staService = value;
	}
		
	public String getStaTel() {
		return this.staTel;
	}
	
	public void setStaTel(String value) {
		this.staTel = value;
	}
		
	public String getStaEmail() {
		return this.staEmail;
	}
	
	public void setStaEmail(String value) {
		this.staEmail = value;
	}
		
	public String getStaWeixin() {
		return this.staWeixin;
	}
	
	public void setStaWeixin(String value) {
		this.staWeixin = value;
	}
		
	public String getStaIcon() {
		return this.staIcon;
	}
	
	public void setStaIcon(String value) {
		this.staIcon = value;
	}
		
	public Double getStaLongitude() {
		return this.staLongitude;
	}
	
	public void setStaLongitude(Double value) {
		this.staLongitude = value;
	}
		
	public Double getStaLatitude() {
		return this.staLatitude;
	}
	
	public void setStaLatitude(Double value) {
		this.staLatitude = value;
	}
		
	public java.sql.Timestamp getCrateTime() {
		return this.crateTime;
	}
	
	public void setCrateTime(java.sql.Timestamp value) {
		this.crateTime = value;
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
		
	public String getStaCode() {
		return this.staCode;
	}
	
	public void setStaCode(String value) {
		this.staCode = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

