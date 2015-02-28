package com.community.app.module.bean;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessProduct implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessProduct";

	private Integer productId;
	private String productName;
	private Integer publisherId;
	private String publisherName;
	private String content;
	private String title;
	private String contactName;
	private String contactTel;
	private String contactQq;
	private Integer typeId;
	private String typeName;
	private Integer estateId;
	private String estateScope;
	private java.lang.Long  price;
	private Integer isEstateAgent;
	private java.sql.Timestamp publishTime;
	private Integer dealState;
	private Integer visits;
	private Integer supports;
	private Integer comments;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private String editor;
	private Integer auditorId;
	private String auditorName;
	private java.sql.Timestamp auditTime;
	private Integer dealType;
	private String portrait;
	private String picUrl;
	private String addrName;//驿站地址
	private String addrUrl;//驿站地图
	private String remarks;
	private Integer closeId;
	private String closeName;
	private java.sql.Timestamp closeTime;
	private String ip;
	private Integer newsCount;
	private String nickname;
	private String realname;
	
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getNewsCount() {
		return newsCount;
	}

	public void setNewsCount(Integer newsCount) {
		this.newsCount = newsCount;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public java.sql.Timestamp getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(java.sql.Timestamp closeTime) {
		this.closeTime = closeTime;
	}
	
	public Integer getCloseId() {
		return closeId;
	}

	public void setCloseId(Integer closeId) {
		this.closeId = closeId;
	}

	public String getCloseName() {
		return closeName == null?"":closeName;
	}

	public void setCloseName(String closeName) {
		this.closeName = closeName;
	}
	
	public String getRemarks() {
		return remarks == null?"":remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getAddrName() {
		return addrName == null?"":addrName;
	}

	public void setAddrName(String addrName) {
		this.addrName = addrName;
	}

	public String getAddrUrl() {
		return addrUrl == null?"":addrUrl;
	}

	public void setAddrUrl(String addrUrl) {
		this.addrUrl = addrUrl;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getPortrait() {
		return portrait == null?"":portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public BusinessProduct(){
	}

	public BusinessProduct(
		Integer productId
	){
		this.productId = productId;
	}

	public void setProductId(Integer value) {
		this.productId = value;
	}
	
	public Integer getProductId() {
		return this.productId;
	}
	public void setProductName(String value) {
		this.productName = value;
	}
	
	public String getProductName() {
		return this.productName == null?"":this.productName;
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
		return this.publisherName == null?"":this.publisherName;
	}
	public void setContent(String value) {
		this.content = value;
	}
	
	public String getContent() {
		return this.content == null?"":this.content;
	}
	public void setTitle(String value) {
		this.title = value;
	}
	
	public String getTitle() {
		return this.title == null?"":this.title;
	}
	public void setContactName(String value) {
		this.contactName = value;
	}
	
	public String getContactName() {
		return this.contactName == null?"":this.contactName;
	}
	public void setContactTel(String value) {
		this.contactTel = value;
	}
	
	public String getContactTel() {
		return this.contactTel == null?"":this.contactTel;
	}
	public void setContactQq(String value) {
		this.contactQq = value;
	}
	
	public String getContactQq() {
		return this.contactQq == null?"":this.contactQq;
	}
	public void setTypeId(Integer value) {
		this.typeId = value;
	}
	
	public Integer getTypeId() {
		return this.typeId;
	}
	public void setEstateId(Integer value) {
		this.estateId = value;
	}
	
	public Integer getEstateId() {
		return this.estateId;
	}
	public void setEstateScope(String value) {
		this.estateScope = value;
	}
	
	public String getEstateScope() {
		return this.estateScope == null?"":this.estateScope;
	}
	public void setPrice(java.lang.Long  value) {
		this.price = value;
	}
	
	public java.lang.Long  getPrice() {
		return this.price;
	}
	public void setIsEstateAgent(Integer value) {
		this.isEstateAgent = value;
	}
	
	public Integer getIsEstateAgent() {
		return this.isEstateAgent;
	}
	public void setPublishTime(java.sql.Timestamp value) {
		this.publishTime = value;
	}
	
	public java.sql.Timestamp getPublishTime() {
		return this.publishTime;
	}
	public void setDealState(Integer value) {
		this.dealState = value;
	}
	
	public Integer getDealState() {
		return this.dealState;
	}
	public void setVisits(Integer value) {
		this.visits = value;
	}
	
	public Integer getVisits() {
		return this.visits;
	}
	public void setSupports(Integer value) {
		this.supports = value;
	}
	
	public Integer getSupports() {
		return this.supports;
	}
	public void setComments(Integer value) {
		this.comments = value;
	}
	
	public Integer getComments() {
		return this.comments;
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
		return this.editor == null?"":this.editor;
	}
	public void setAuditorId(Integer value) {
		this.auditorId = value;
	}
	
	public Integer getAuditorId() {
		return this.auditorId;
	}
	public void setAuditorName(String value) {
		this.auditorName = value;
	}
	
	public String getAuditorName() {
		return this.auditorName == null?"":this.auditorName;
	}
	public void setAuditTime(java.sql.Timestamp value) {
		this.auditTime = value;
	}
	
	public java.sql.Timestamp getAuditTime() {
		return this.auditTime;
	}
	public void setDealType(Integer value) {
		this.dealType = value;
	}
	
	public Integer getDealType() {
		return this.dealType;
	}
	
	private Set businessProductPics = new HashSet(0);
	public void setBusinessProductPics(Set businessProductPic){
		this.businessProductPics = businessProductPic;
	}
	
	public Set getBusinessProductPics() {
		return businessProductPics;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("ProductId",getProductId())
			.append("ProductName",getProductName())
			.append("PublisherId",getPublisherId())
			.append("PublisherName",getPublisherName())
			.append("Content",getContent())
			.append("Title",getTitle())
			.append("ContactName",getContactName())
			.append("ContactTel",getContactTel())
			.append("ContactQq",getContactQq())
			.append("TypeId",getTypeId())
			.append("EstateId",getEstateId())
			.append("EstateScope",getEstateScope())
			.append("Price",getPrice())
			.append("IsEstateAgent",getIsEstateAgent())
			.append("PublishTime",getPublishTime())
			.append("DealState",getDealState())
			.append("Visits",getVisits())
			.append("Supports",getSupports())
			.append("Comments",getComments())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.append("AuditorId",getAuditorId())
			.append("AuditorName",getAuditorName())
			.append("AuditTime",getAuditTime())
			.append("DealType",getDealType())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getProductId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessProduct == false) return false;
		if(this == obj) return true;
		BusinessProduct other = (BusinessProduct)obj;
		return new EqualsBuilder()
			.append(getProductId(),other.getProductId())
			.isEquals();
	}
}