package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessLife;

public class BusinessLifeQuery extends BaseBean {
	

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
	
	private String timeScope;
	private String startTime;
	private String endTime;
	private String orderBy;
	private String keyWord;

	public BusinessLifeQuery(BusinessLife businessLife) {
		this.serviceId = businessLife.getServiceId();
		this.typeId = businessLife.getTypeId();
		this.serviceName = businessLife.getServiceName();
		this.publisherId = businessLife.getPublisherId();
		this.publisherName = businessLife.getPublisherName();
		this.content = businessLife.getContent();
		this.estateLongitude = businessLife.getEstateLongitude();
		this.estateLatitude = businessLife.getEstateLatitude();
		this.typeName = businessLife.getTypeName();
		this.estateScope = businessLife.getEstateScope();
		this.publishTime = businessLife.getPublishTime();
		this.link = businessLife.getLink();
		this.pulishState = businessLife.getPulishState();
		this.visits = businessLife.getVisits();
		this.createTime = businessLife.getCreateTime();
		this.editTime = businessLife.getEditTime();
		this.editor = businessLife.getEditor();
	}
	
	public BusinessLifeQuery() {
		
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

	public String getTimeScope() {
		return timeScope;
	}

	public void setTimeScope(String timeScope) {
		this.timeScope = timeScope;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public Integer getServiceId() {
		return this.serviceId;
	}
	
	public void setServiceId(Integer value) {
		this.serviceId = value;
	}
		
	public Integer getTypeId() {
		return this.typeId;
	}
	
	public void setTypeId(Integer value) {
		this.typeId = value;
	}
		
	public String getServiceName() {
		return this.serviceName;
	}
	
	public void setServiceName(String value) {
		this.serviceName = value;
	}
		
	public Integer getPublisherId() {
		return this.publisherId;
	}
	
	public void setPublisherId(Integer value) {
		this.publisherId = value;
	}
		
	public String getPublisherName() {
		return this.publisherName;
	}
	
	public void setPublisherName(String value) {
		this.publisherName = value;
	}
		
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String value) {
		this.content = value;
	}
		
	public Double getEstateLongitude() {
		return this.estateLongitude;
	}
	
	public void setEstateLongitude(Double value) {
		this.estateLongitude = value;
	}
		
	public Double getEstateLatitude() {
		return this.estateLatitude;
	}
	
	public void setEstateLatitude(Double value) {
		this.estateLatitude = value;
	}
		
	public String getTypeName() {
		return this.typeName;
	}
	
	public void setTypeName(String value) {
		this.typeName = value;
	}
		
	public String getEstateScope() {
		return this.estateScope;
	}
	
	public void setEstateScope(String value) {
		this.estateScope = value;
	}
		
	public java.sql.Timestamp getPublishTime() {
		return this.publishTime;
	}
	
	public void setPublishTime(java.sql.Timestamp value) {
		this.publishTime = value;
	}
		
	public String getLink() {
		return this.link;
	}
	
	public void setLink(String value) {
		this.link = value;
	}
		
	public Integer getPulishState() {
		return this.pulishState;
	}
	
	public void setPulishState(Integer value) {
		this.pulishState = value;
	}
		
	public Integer getVisits() {
		return this.visits;
	}
	
	public void setVisits(Integer value) {
		this.visits = value;
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

