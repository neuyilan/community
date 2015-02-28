package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.ManageEstate;

public class ManageEstateQuery extends BaseBean {
	

	private java.lang.Integer estateId;
	private java.lang.Integer countyId;
	private java.lang.Integer cityId;
	private java.lang.Integer provinceId;
	private java.lang.String estateName;
	private java.lang.String estateDesc;
	private java.lang.String estateAddress;
	private java.lang.String estateMap;
	private java.lang.Double estateLongitude;
	private java.lang.Double estateLatitude;
	private java.lang.Double Longitude;
	private java.lang.Double Latitude;
	private java.lang.String estateCarMap;
	private Integer estateType;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.String keyword;
	private java.lang.Integer stationId;
	private java.lang.Integer proId;
	private java.lang.Integer comId;
	private java.lang.String stationName;
	private java.lang.Double busLongitude;
	private java.lang.Double busLatitude;
	private java.lang.Integer ID;
	private java.lang.Integer serviceId;
	private java.lang.String serviceName;
	private java.lang.String address;
	private java.lang.String tel;
	private String serviceCode;
	private java.lang.Integer userId;
	
	public java.lang.Integer getUserId() {
		return userId;
	}

	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public java.lang.Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(java.lang.Integer serviceId) {
		this.serviceId = serviceId;
	}

	public java.lang.String getServiceName() {
		return serviceName;
	}

	public void setServiceName(java.lang.String serviceName) {
		this.serviceName = serviceName;
	}

	public java.lang.String getAddress() {
		return address;
	}

	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	public java.lang.String getTel() {
		return tel;
	}

	public void setTel(java.lang.String tel) {
		this.tel = tel;
	}

	public java.lang.Integer getID() {
		return ID;
	}

	public void setID(java.lang.Integer iD) {
		ID = iD;
	}

	public java.lang.String getStationName() {
		return stationName;
	}

	public void setStationName(java.lang.String stationName) {
		this.stationName = stationName;
	}


	public java.lang.Double getBusLongitude() {
		return busLongitude;
	}

	public void setBusLongitude(java.lang.Double busLongitude) {
		this.busLongitude = busLongitude;
	}

	public java.lang.Double getBusLatitude() {
		return busLatitude;
	}

	public void setBusLatitude(java.lang.Double busLatitude) {
		this.busLatitude = busLatitude;
	}

	public ManageEstateQuery(ManageEstate manageEstate) {
		this.estateId = manageEstate.getEstateId();
		this.estateName = manageEstate.getEstateName();
		this.estateDesc = manageEstate.getEstateDesc();
		this.estateAddress = manageEstate.getEstateAddress();
		this.estateMap = manageEstate.getEstateMap();
		this.estateLongitude = manageEstate.getEstateLongitude();
		this.estateLatitude = manageEstate.getEstateLatitude();
		this.estateCarMap = manageEstate.getEstateCarMap();
		this.estateType = manageEstate.getEstateType();
		this.createTime = manageEstate.getCreateTime();
		this.editTime = manageEstate.getEditTime();
		this.editor = manageEstate.getEditor();
		this.stationId = manageEstate.getStationId();
		this.proId = manageEstate.getProId();
		this.comId = manageEstate.getComId();
	}
	
	public ManageEstateQuery() {
		
	}	
	
	public java.lang.Integer getEstateId() {
		return this.estateId;
	}
	
	public void setEstateId(java.lang.Integer value) {
		this.estateId = value;
	}
		
	public java.lang.Integer getCountyId() {
		return this.countyId;
	}
	
	public void setCountyId(java.lang.Integer value) {
		this.countyId = value;
	}
		
	public java.lang.Integer getCityId() {
		return this.cityId;
	}
	
	public void setCityId(java.lang.Integer value) {
		this.cityId = value;
	}
		
	public java.lang.Integer getProvinceId() {
		return this.provinceId;
	}
	
	public void setProvinceId(java.lang.Integer value) {
		this.provinceId = value;
	}
		
	public java.lang.String getEstateName() {
		return this.estateName;
	}
	
	public void setEstateName(java.lang.String value) {
		this.estateName = value;
	}
		
	public java.lang.String getEstateDesc() {
		return this.estateDesc;
	}
	
	public void setEstateDesc(java.lang.String value) {
		this.estateDesc = value;
	}
		
	public java.lang.String getEstateAddress() {
		return this.estateAddress;
	}
	
	public void setEstateAddress(java.lang.String value) {
		this.estateAddress = value;
	}
		
	public java.lang.String getEstateMap() {
		return this.estateMap;
	}
	
	public void setEstateMap(java.lang.String value) {
		this.estateMap = value;
	}
		
	public java.lang.Double getEstateLongitude() {
		return this.estateLongitude;
	}
	
	public void setEstateLongitude(java.lang.Double value) {
		this.estateLongitude = value;
	}
		
	public java.lang.Double getEstateLatitude() {
		return this.estateLatitude;
	}
	
	public void setEstateLatitude(java.lang.Double value) {
		this.estateLatitude = value;
	}
		
	public java.lang.String getEstateCarMap() {
		return this.estateCarMap;
	}
	
	public void setEstateCarMap(java.lang.String value) {
		this.estateCarMap = value;
	}
		
	public Integer getEstateType() {
		return this.estateType;
	}
	
	public void setEstateType(Integer value) {
		this.estateType = value;
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
		
	public java.lang.String getEditor() {
		return this.editor;
	}
	
	public void setEditor(java.lang.String value) {
		this.editor = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}

	public java.lang.String getKeyword() {
		return keyword;
	}

	public void setKeyword(java.lang.String keyword) {
		this.keyword = keyword;
	}

	public java.lang.Integer getStationId() {
		return stationId;
	}

	public void setStationId(java.lang.Integer stationId) {
		this.stationId = stationId;
	}

	public java.lang.Integer getProId() {
		return proId;
	}

	public void setProId(java.lang.Integer proId) {
		this.proId = proId;
	}

	public java.lang.Integer getComId() {
		return comId;
	}

	public void setComId(java.lang.Integer comId) {
		this.comId = comId;
	}

	public java.lang.Double getLongitude() {
		return Longitude;
	}

	public void setLongitude(java.lang.Double longitude) {
		Longitude = longitude;
	}

	public java.lang.Double getLatitude() {
		return Latitude;
	}

	public void setLatitude(java.lang.Double latitude) {
		Latitude = latitude;
	}
	
	
}

