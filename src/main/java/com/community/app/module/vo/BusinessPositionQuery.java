package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessPosition;
import com.community.app.module.vo.BaseBean;

public class BusinessPositionQuery extends BaseBean {
	

	private java.lang.Integer positionId;
	private java.lang.Integer orgId;
	private java.lang.String orgName;
	private java.lang.Integer parentId;
	private java.lang.String parentName;
	private java.lang.String positionCode;
	private Integer positionState;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.Integer ord;
	private Integer leaf;
	private java.lang.String positionName;
	private java.lang.Integer depId;
	private java.lang.String depName;
	private java.lang.String orgType;
	private Integer level;
	private String positionDesc;

	public BusinessPositionQuery(BusinessPosition businessPosition) {
		this.positionId = businessPosition.getPositionId();
		this.orgId = businessPosition.getOrgId();
		this.orgName = businessPosition.getOrgName();
		this.parentId = businessPosition.getParentId();
		this.parentName = businessPosition.getParentName();
		this.positionCode = businessPosition.getPositionCode();
		this.positionState = businessPosition.getPositionState();
		this.createTime = businessPosition.getCreateTime();
		this.editTime = businessPosition.getEditTime();
		this.editor = businessPosition.getEditor();
		this.ord = businessPosition.getOrd();
		this.leaf = businessPosition.getLeaf();
		this.positionName = businessPosition.getPositionName();
		this.depId = businessPosition.getDepId();
		this.depName = businessPosition.getDepName();
		this.orgType = businessPosition.getOrgType();
		this.level = businessPosition.getLevel();
		this.positionDesc = businessPosition.getPositionDesc();
	}
	
	public String getPositionDesc() {
		return positionDesc;
	}

	public void setPositionDesc(String positionDesc) {
		this.positionDesc = positionDesc;
	}

	public BusinessPositionQuery() {
		
	}	
	
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public java.lang.Integer getPositionId() {
		return this.positionId;
	}
	
	public void setPositionId(java.lang.Integer value) {
		this.positionId = value;
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
		
	public java.lang.Integer getParentId() {
		return this.parentId;
	}
	
	public void setParentId(java.lang.Integer value) {
		this.parentId = value;
	}
		
	public java.lang.String getParentName() {
		return this.parentName;
	}
	
	public void setParentName(java.lang.String value) {
		this.parentName = value;
	}
		
	public java.lang.String getPositionCode() {
		return this.positionCode;
	}
	
	public void setPositionCode(java.lang.String value) {
		this.positionCode = value;
	}
		
	public Integer getPositionState() {
		return this.positionState;
	}
	
	public void setPositionState(Integer value) {
		this.positionState = value;
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
		
	public java.lang.Integer getOrd() {
		return this.ord;
	}
	
	public void setOrd(java.lang.Integer value) {
		this.ord = value;
	}
		
	public Integer getLeaf() {
		return this.leaf;
	}
	
	public void setLeaf(Integer value) {
		this.leaf = value;
	}
		
	public java.lang.String getPositionName() {
		return this.positionName;
	}
	
	public void setPositionName(java.lang.String value) {
		this.positionName = value;
	}
		
	public java.lang.Integer getDepId() {
		return this.depId;
	}
	
	public void setDepId(java.lang.Integer value) {
		this.depId = value;
	}
		
	public java.lang.String getDepName() {
		return this.depName;
	}
	
	public void setDepName(java.lang.String value) {
		this.depName = value;
	}
		
	public java.lang.String getOrgType() {
		return this.orgType;
	}
	
	public void setOrgType(java.lang.String value) {
		this.orgType = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

