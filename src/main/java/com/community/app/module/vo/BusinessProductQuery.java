package com.community.app.module.vo;

import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessProduct;

public class BusinessProductQuery extends BaseBean {
	
	private Integer productId;
	private String productName;
	private Integer publisherId;
	private String publisherName;
	private String content;
	private String like;
	private String title;
	private String contactName;
	private String contactTel;
	private String contactQq;
	private Integer typeId;
	private String typeName;
	private Integer estateId;
	private Integer comId;
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
	private String dealTypea;
	private Integer userId;
	private Integer type=1;
	private Integer ID;
	private String startTime;
	private String desc;
	private String name;
	private String contact;
	private String cellphone;
	private String qq;
	private String weixin;
	private Integer isAgent;
	private Integer submitType;
	private Map<String,String> param;
	private Map<String,String> image;
	private Map<String,String> audio;
	private String endTime;
	private Integer closeId;
	private String closeName;
	private java.sql.Timestamp closeTime;
	private String appPic;
	
	private Integer curUserId;//当前用户ID
	private String curOrgType;//当前部门类型
	private Integer curEstateId;//当前小区ID
	private Integer curComId; //当前社区ID
	private String nickname;
	private String realname;
	private String orgType;		//部门类型
	private String picPaths[];  //商品多图片路径
	
	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getLike() {
		return like;
	}

	public void setLike(String like) {
		this.like = like;
	}

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

	public Integer getCurComId() {
		return curComId;
	}

	public void setCurComId(Integer curComId) {
		this.curComId = curComId;
	}

	public Integer getCurEstateId() {
		return curEstateId;
	}

	public void setCurEstateId(Integer curEstateId) {
		this.curEstateId = curEstateId;
	}

	public String getDealTypea() {
		return dealTypea;
	}

	public void setDealTypea(String dealTypea) {
		this.dealTypea = dealTypea;
	}

	public Integer getComId() {
		return comId;
	}

	public void setComId(Integer comId) {
		this.comId = comId;
	}

	public Integer getCurUserId() {
		return curUserId;
	}

	public void setCurUserId(Integer curUserId) {
		this.curUserId = curUserId;
	}

	public String getCurOrgType() {
		return curOrgType;
	}

	public void setCurOrgType(String curOrgType) {
		this.curOrgType = curOrgType;
	}

	public String getAppPic() {
		return appPic;
	}

	public void setAppPic(String appPic) {
		this.appPic = appPic;
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
		return closeName;
	}

	public void setCloseName(String closeName) {
		this.closeName = closeName;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Map<String, String> getParam() {
		return param;
	}

	public void setParam(Map<String, String> param) {
		this.param = param;
	}

	public Map<String, String> getImage() {
		return image;
	}

	public void setImage(Map<String, String> image) {
		this.image = image;
	}

	public Map<String, String> getAudio() {
		return audio;
	}

	public void setAudio(Map<String, String> audio) {
		this.audio = audio;
	}

	public Integer getSubmitType() {
		return submitType;
	}

	public void setSubmitType(Integer submitType) {
		this.submitType = submitType;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public Integer getIsAgent() {
		return isAgent;
	}

	public void setIsAgent(Integer isAgent) {
		this.isAgent = isAgent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	private String timeScope;
	private String startRepairTime;
	private String endRepairTime;
	private String orderBy;
	private String keyWord;
	
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public BusinessProductQuery(BusinessProduct businessProduct) {
		this.productId = businessProduct.getProductId();
		this.productName = businessProduct.getProductName();
		this.publisherId = businessProduct.getPublisherId();
		this.publisherName = businessProduct.getPublisherName();
		this.content = businessProduct.getContent();
		this.title = businessProduct.getTitle();
		this.contactName = businessProduct.getContactName();
		this.contactTel = businessProduct.getContactTel();
		this.contactQq = businessProduct.getContactQq();
		this.typeId = businessProduct.getTypeId();
		this.estateId = businessProduct.getEstateId();
		this.estateScope = businessProduct.getEstateScope();
		this.price = businessProduct.getPrice();
		this.isEstateAgent = businessProduct.getIsEstateAgent();
		this.publishTime = businessProduct.getPublishTime();
		this.dealState = businessProduct.getDealState();
		this.visits = businessProduct.getVisits();
		this.supports = businessProduct.getSupports();
		this.comments = businessProduct.getComments();
		this.createTime = businessProduct.getCreateTime();
		this.editTime = businessProduct.getEditTime();
		this.editor = businessProduct.getEditor();
		this.auditorId = businessProduct.getAuditorId();
		this.auditorName = businessProduct.getAuditorName();
		this.auditTime = businessProduct.getAuditTime();
		this.dealType = businessProduct.getDealType();
		this.closeId = businessProduct.getCloseId();
		this.closeName =businessProduct.getCloseName();
		this.closeTime = businessProduct.getCloseTime();
	}
	
	public String getTimeScope() {
		return timeScope;
	}

	public void setTimeScope(String timeScope) {
		this.timeScope = timeScope;
	}

	public String getStartRepairTime() {
		return startRepairTime;
	}

	public void setStartRepairTime(String startRepairTime) {
		this.startRepairTime = startRepairTime;
	}

	public String getEndRepairTime() {
		return endRepairTime;
	}

	public void setEndRepairTime(String endRepairTime) {
		this.endRepairTime = endRepairTime;
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

	public BusinessProductQuery() {
		
	}	
	
	public Integer getProductId() {
		return this.productId;
	}
	
	public void setProductId(Integer value) {
		this.productId = value;
	}
		
	public String getProductName() {
		return this.productName;
	}
	
	public void setProductName(String value) {
		this.productName = value;
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
		
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String value) {
		this.title = value;
	}
		
	public String getContactName() {
		return this.contactName;
	}
	
	public void setContactName(String value) {
		this.contactName = value;
	}
		
	public String getContactTel() {
		return this.contactTel;
	}
	
	public void setContactTel(String value) {
		this.contactTel = value;
	}
		
	public String getContactQq() {
		return this.contactQq;
	}
	
	public void setContactQq(String value) {
		this.contactQq = value;
	}
		
	public Integer getTypeId() {
		return this.typeId;
	}
	
	public void setTypeId(Integer value) {
		this.typeId = value;
	}
		
	public Integer getEstateId() {
		return this.estateId;
	}
	
	public void setEstateId(Integer value) {
		this.estateId = value;
	}
		
	public String getEstateScope() {
		return this.estateScope;
	}
	
	public void setEstateScope(String value) {
		this.estateScope = value;
	}
		
	public java.lang.Long  getPrice() {
		return this.price;
	}
	
	public void setPrice(java.lang.Long  value) {
		this.price = value;
	}
		
	public Integer getIsEstateAgent() {
		return this.isEstateAgent;
	}
	
	public void setIsEstateAgent(Integer value) {
		this.isEstateAgent = value;
	}
		
	public java.sql.Timestamp getPublishTime() {
		return this.publishTime;
	}
	
	public void setPublishTime(java.sql.Timestamp value) {
		this.publishTime = value;
	}
		
	public Integer getDealState() {
		return this.dealState;
	}
	
	public void setDealState(Integer value) {
		this.dealState = value;
	}
		
	public Integer getVisits() {
		return this.visits;
	}
	
	public void setVisits(Integer value) {
		this.visits = value;
	}
		
	public Integer getSupports() {
		return this.supports;
	}
	
	public void setSupports(Integer value) {
		this.supports = value;
	}
		
	public Integer getComments() {
		return this.comments;
	}
	
	public void setComments(Integer value) {
		this.comments = value;
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
		
	public Integer getAuditorId() {
		return this.auditorId;
	}
	
	public void setAuditorId(Integer value) {
		this.auditorId = value;
	}
		
	public String getAuditorName() {
		return this.auditorName;
	}
	
	public void setAuditorName(String value) {
		this.auditorName = value;
	}
		
	public java.sql.Timestamp getAuditTime() {
		return this.auditTime;
	}
	
	public void setAuditTime(java.sql.Timestamp value) {
		this.auditTime = value;
	}
		
	public Integer getDealType() {
		return this.dealType;
	}
	
	public void setDealType(Integer value) {
		this.dealType = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}

	public String[] getPicPaths() {
		return picPaths;
	}

	public void setPicPaths(String[] picPaths) {
		this.picPaths = picPaths;
	}
	
}

