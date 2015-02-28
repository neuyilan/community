package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessLife implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessLife";

	private Integer serviceId;
	private Integer typeId;
	private String serviceName;
	private Integer publisherId;
	private String publisherName;
	private String content;
	private Double estateLongitude;
	private Double estateLatitude;
	private String typeName;
	private String estateScope;
	private java.sql.Timestamp publishTime;
	private String link;
	private Integer pulishState;
	private Integer visits;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private String editor;
	
	private String tel;
	private String address;

	public BusinessLife(){
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BusinessLife(
		Integer serviceId
	){
		this.serviceId = serviceId;
	}

	public void setServiceId(Integer value) {
		this.serviceId = value;
	}
	
	public Integer getServiceId() {
		return this.serviceId;
	}
	public void setTypeId(Integer value) {
		this.typeId = value;
	}
	
	public Integer getTypeId() {
		return this.typeId;
	}
	public void setServiceName(String value) {
		this.serviceName = value;
	}
	
	public String getServiceName() {
		return this.serviceName;
	}
	public void setPublisherId(Integer value) {
		this.publisherId = value;
	}
	
	public Integer getPublisherId() {
		return this.publisherId;
	}
	public void setPublisherName(String value) {
		this.publisherName = value;
	}
	
	public String getPublisherName() {
		return this.publisherName;
	}
	public void setContent(String value) {
		this.content = value;
	}
	
	public String getContent() {
		return this.content;
	}
	public void setEstateLongitude(Double value) {
		this.estateLongitude = value;
	}
	
	public Double getEstateLongitude() {
		return this.estateLongitude;
	}
	public void setEstateLatitude(Double value) {
		this.estateLatitude = value;
	}
	
	public Double getEstateLatitude() {
		return this.estateLatitude;
	}
	public void setTypeName(String value) {
		this.typeName = value;
	}
	
	public String getTypeName() {
		return this.typeName;
	}
	public void setEstateScope(String value) {
		this.estateScope = value;
	}
	
	public String getEstateScope() {
		return this.estateScope;
	}
	public void setPublishTime(java.sql.Timestamp value) {
		this.publishTime = value;
	}
	
	public java.sql.Timestamp getPublishTime() {
		return this.publishTime;
	}
	public void setLink(String value) {
		this.link = value;
	}
	
	public String getLink() {
		return this.link;
	}
	public void setPulishState(Integer value) {
		this.pulishState = value;
	}
	
	public Integer getPulishState() {
		return this.pulishState;
	}
	public void setVisits(Integer value) {
		this.visits = value;
	}
	
	public Integer getVisits() {
		return this.visits;
	}
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
	
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
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

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("ServiceId",getServiceId())
			.append("TypeId",getTypeId())
			.append("ServiceName",getServiceName())
			.append("PublisherId",getPublisherId())
			.append("PublisherName",getPublisherName())
			.append("Content",getContent())
			.append("EstateLongitude",getEstateLongitude())
			.append("EstateLatitude",getEstateLatitude())
			.append("TypeName",getTypeName())
			.append("EstateScope",getEstateScope())
			.append("PublishTime",getPublishTime())
			.append("Link",getLink())
			.append("PulishState",getPulishState())
			.append("Visits",getVisits())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getServiceId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessLife == false) return false;
		if(this == obj) return true;
		BusinessLife other = (BusinessLife)obj;
		return new EqualsBuilder()
			.append(getServiceId(),other.getServiceId())
			.isEquals();
	}
}

