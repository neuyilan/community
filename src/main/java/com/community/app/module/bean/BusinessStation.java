package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;


public class BusinessStation implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessStation";

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
	private String addrName;
	private String addrUrl;


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

	public BusinessStation(){
	}

	public BusinessStation(
		Integer stationId
	){
		this.stationId = stationId;
	}

	public void setStationId(Integer value) {
		this.stationId = value;
	}
	
	public Integer getStationId() {
		return this.stationId;
	}
	public void setOrgId(Integer value) {
		this.orgId = value;
	}
	
	public Integer getOrgId() {
		return this.orgId;
	}
	public void setStaName(String value) {
		this.staName = value;
	}
	
	public String getStaName() {
		return this.staName;
	}
	public void setStaBrief(String value) {
		this.staBrief = value;
	}
	
	public String getStaBrief() {
		return this.staBrief;
	}
	public void setStaService(String value) {
		this.staService = value;
	}
	
	public String getStaService() {
		return this.staService;
	}
	public void setStaTel(String value) {
		this.staTel = value;
	}
	
	public String getStaTel() {
		return this.staTel;
	}
	public void setStaEmail(String value) {
		this.staEmail = value;
	}
	
	public String getStaEmail() {
		return this.staEmail;
	}
	public void setStaWeixin(String value) {
		this.staWeixin = value;
	}
	
	public String getStaWeixin() {
		return this.staWeixin;
	}
	public void setStaIcon(String value) {
		this.staIcon = value;
	}
	
	public String getStaIcon() {
		return this.staIcon;
	}
	public void setStaLongitude(Double value) {
		this.staLongitude = value;
	}
	
	public Double getStaLongitude() {
		return this.staLongitude;
	}
	public void setStaLatitude(Double value) {
		this.staLatitude = value;
	}
	
	public Double getStaLatitude() {
		return this.staLatitude;
	}
	public void setCrateTime(java.sql.Timestamp value) {
		this.crateTime = value;
	}
	
	public java.sql.Timestamp getCrateTime() {
		return this.crateTime;
	}
	public void setEditTime(java.sql.Timestamp value) {
		this.editTime = value;
	}
	
	public java.sql.Timestamp getEditTime() {
		return this.editTime;
	}
	public void setEditor(String value) {
		this.editor = value;
	}
	
	public String getEditor() {
		return this.editor;
	}
	public void setStaCode(String value) {
		this.staCode = value;
	}
	
	public String getStaCode() {
		return this.staCode;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("StationId",getStationId())
			.append("OrgId",getOrgId())
			.append("StaName",getStaName())
			.append("StaBrief",getStaBrief())
			.append("StaService",getStaService())
			.append("StaTel",getStaTel())
			.append("StaEmail",getStaEmail())
			.append("StaWeixin",getStaWeixin())
			.append("StaIcon",getStaIcon())
			.append("StaLongitude",getStaLongitude())
			.append("StaLatitude",getStaLatitude())
			.append("CrateTime",getCrateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.append("StaCode",getStaCode())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getStationId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessStation == false) return false;
		if(this == obj) return true;
		BusinessStation other = (BusinessStation)obj;
		return new EqualsBuilder()
			.append(getStationId(),other.getStationId())
			.isEquals();
	}
}

