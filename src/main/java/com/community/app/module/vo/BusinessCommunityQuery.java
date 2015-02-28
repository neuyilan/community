package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessCommunity;

public class BusinessCommunityQuery extends BaseBean {
	

	private java.lang.Integer comId;
	private java.lang.Integer orgId;
	private java.lang.String comName;
	private java.lang.String comBrief;
	private java.lang.String comService;
	private java.lang.String comTel;
	private java.lang.String comEmail;
	private java.lang.String comWeixin;
	private java.lang.String comIcon;
	private java.lang.Double comLongitude;
	private java.lang.Double comLatitude;
	private java.sql.Timestamp crateTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.String comCode;
	private java.lang.String orgType;

	public java.lang.String getOrgType() {
		return orgType;
	}

	public void setOrgType(java.lang.String orgType) {
		this.orgType = orgType;
	}

	public BusinessCommunityQuery(BusinessCommunity businessCommunity) {
		this.comId = businessCommunity.getComId();
		this.orgId = businessCommunity.getOrgId();
		this.comName = businessCommunity.getComName();
		this.comBrief = businessCommunity.getComBrief();
		this.comService = businessCommunity.getComService();
		this.comTel = businessCommunity.getComTel();
		this.comEmail = businessCommunity.getComEmail();
		this.comWeixin = businessCommunity.getComWeixin();
		this.comIcon = businessCommunity.getComIcon();
		this.comLongitude = businessCommunity.getComLongitude();
		this.comLatitude = businessCommunity.getComLatitude();
		this.crateTime = businessCommunity.getCreateTime();
		this.editTime = businessCommunity.getEditTime();
		this.editor = businessCommunity.getEditor();
		this.comCode = businessCommunity.getComCode();
		this.orgType = businessCommunity.getOrgType();
	}
	
	public BusinessCommunityQuery() {
		
	}	
	
	public java.lang.Integer getComId() {
		return this.comId;
	}
	
	public void setComId(java.lang.Integer value) {
		this.comId = value;
	}
		
	public java.lang.Integer getOrgId() {
		return this.orgId;
	}
	
	public void setOrgId(java.lang.Integer value) {
		this.orgId = value;
	}
		
	public java.lang.String getComName() {
		return this.comName;
	}
	
	public void setComName(java.lang.String value) {
		this.comName = value;
	}
		
	public java.lang.String getComBrief() {
		return this.comBrief;
	}
	
	public void setComBrief(java.lang.String value) {
		this.comBrief = value;
	}
		
	public java.lang.String getComService() {
		return this.comService;
	}
	
	public void setComService(java.lang.String value) {
		this.comService = value;
	}
		
	public java.lang.String getComTel() {
		return this.comTel;
	}
	
	public void setComTel(java.lang.String value) {
		this.comTel = value;
	}
		
	public java.lang.String getComEmail() {
		return this.comEmail;
	}
	
	public void setComEmail(java.lang.String value) {
		this.comEmail = value;
	}
		
	public java.lang.String getComWeixin() {
		return this.comWeixin;
	}
	
	public void setComWeixin(java.lang.String value) {
		this.comWeixin = value;
	}
		
	public java.lang.String getComIcon() {
		return this.comIcon;
	}
	
	public void setComIcon(java.lang.String value) {
		this.comIcon = value;
	}
		
	public java.lang.Double getComLongitude() {
		return this.comLongitude;
	}
	
	public void setComLongitude(java.lang.Double value) {
		this.comLongitude = value;
	}
		
	public java.lang.Double getComLatitude() {
		return this.comLatitude;
	}
	
	public void setComLatitude(java.lang.Double value) {
		this.comLatitude = value;
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
		
	public java.lang.String getEditor() {
		return this.editor;
	}
	
	public void setEditor(java.lang.String value) {
		this.editor = value;
	}
		
	public java.lang.String getComCode() {
		return this.comCode;
	}
	
	public void setComCode(java.lang.String value) {
		this.comCode = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
}