package com.community.app.module.vo;


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.ManageOrg;
import com.community.app.module.vo.BaseBean;

public class ManageOrgQuery extends BaseBean {
	

	private java.lang.Integer orgId;
	private java.lang.String orgName;
	private java.lang.String orgDesc;
	private java.lang.Integer parentId;
	private java.lang.String orgCode;
	private Integer orgState;
	private java.lang.String orgTypeCode;
	private java.lang.Double orgLongitude;
	private java.lang.Double orgLatitude;
	private java.lang.String orgIcon;
	private java.lang.String orgTel;
	private java.lang.String orgEmail;
	private java.lang.String orgWeixin;
	private java.lang.String orgSubType;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.Integer leaf;
	private java.lang.Integer ord;

	public ManageOrgQuery(ManageOrg manageOrg) {
		this.orgId = manageOrg.getOrgId();
		this.orgName = manageOrg.getOrgName();
		this.orgDesc = manageOrg.getOrgDesc();
		this.parentId = manageOrg.getParentId();
		this.orgCode = manageOrg.getOrgCode();
		this.orgState = manageOrg.getOrgState();
		this.orgTypeCode = manageOrg.getOrgTypeCode();
		this.orgLongitude = manageOrg.getOrgLongitude();
		this.orgLatitude = manageOrg.getOrgLatitude();
		this.orgIcon = manageOrg.getOrgIcon();
		this.orgTel = manageOrg.getOrgTel();
		this.orgEmail = manageOrg.getOrgEmail();
		this.orgWeixin = manageOrg.getOrgWeixin();
		this.orgSubType = manageOrg.getOrgSubType();
		this.createTime = manageOrg.getCreateTime();
		this.editTime = manageOrg.getEditTime();
		this.editor = manageOrg.getEditor();
		this.leaf = manageOrg.getLeaf();
		this.ord = manageOrg.getOrd();
	}
	
	public ManageOrgQuery() {
		
	}	
	
	public java.lang.Integer getOrgId() {
		return this.orgId;
	}
	
	public void setOrgId(java.lang.Integer value) {
		this.orgId = value;
	}
		
	public java.lang.String getOrgName() {
		return this.orgName;
	}
	
	public void setOrgName(java.lang.String value) {
		this.orgName = value;
	}
		
	public java.lang.String getOrgDesc() {
		return this.orgDesc;
	}
	
	public void setOrgDesc(java.lang.String value) {
		this.orgDesc = value;
	}
		
	public java.lang.Integer getParentId() {
		return this.parentId;
	}
	
	public void setParentId(java.lang.Integer value) {
		this.parentId = value;
	}
		
	public java.lang.String getOrgCode() {
		return this.orgCode;
	}
	
	public void setOrgCode(java.lang.String value) {
		this.orgCode = value;
	}
		
	public Integer getOrgState() {
		return this.orgState;
	}
	
	public void setOrgState(Integer value) {
		this.orgState = value;
	}
		
	public java.lang.String getOrgTypeCode() {
		return this.orgTypeCode;
	}
	
	public void setOrgTypeCode(java.lang.String value) {
		this.orgTypeCode = value;
	}
		
	public java.lang.Double getOrgLongitude() {
		return this.orgLongitude;
	}
	
	public void setOrgLongitude(java.lang.Double value) {
		this.orgLongitude = value;
	}
		
	public java.lang.Double getOrgLatitude() {
		return this.orgLatitude;
	}
	
	public void setOrgLatitude(java.lang.Double value) {
		this.orgLatitude = value;
	}
		
	public java.lang.String getOrgIcon() {
		return this.orgIcon;
	}
	
	public void setOrgIcon(java.lang.String value) {
		this.orgIcon = value;
	}
		
	public java.lang.String getOrgTel() {
		return this.orgTel;
	}
	
	public void setOrgTel(java.lang.String value) {
		this.orgTel = value;
	}
		
	public java.lang.String getOrgEmail() {
		return this.orgEmail;
	}
	
	public void setOrgEmail(java.lang.String value) {
		this.orgEmail = value;
	}
		
	public java.lang.String getOrgWeixin() {
		return this.orgWeixin;
	}
	
	public void setOrgWeixin(java.lang.String value) {
		this.orgWeixin = value;
	}
		
	public java.lang.String getOrgSubType() {
		return this.orgSubType;
	}
	
	public void setOrgSubType(java.lang.String value) {
		this.orgSubType = value;
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
		
	public java.lang.Integer getLeaf() {
		return this.leaf;
	}
	
	public void setLeaf(java.lang.Integer value) {
		this.leaf = value;
	}
		
	public java.lang.Integer getOrd() {
		return this.ord;
	}
	
	public void setOrd(java.lang.Integer value) {
		this.ord = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

