package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessMenu;
import com.community.app.module.vo.BaseBean;

public class BusinessMenuQuery extends BaseBean {
	

	private java.lang.Integer menuId;
	private java.lang.String name;
	private java.lang.String url;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp modifyTime;
	private java.lang.String editor;
	private java.lang.Integer parentId;
	private java.lang.Integer ord;
	private java.lang.Integer leaf;
	private java.lang.String code;
	private java.lang.String selectedIcon;
	private java.lang.String unSelectedIcon;

	public BusinessMenuQuery(BusinessMenu businessMenu) {
		this.menuId = businessMenu.getMenuId();
		this.name = businessMenu.getName();
		this.url = businessMenu.getUrl();
		this.createTime = businessMenu.getCreateTime();
		this.modifyTime = businessMenu.getModifyTime();
		this.editor = businessMenu.getEditor();
		this.parentId = businessMenu.getParentId();
		this.ord = businessMenu.getOrd();
		this.leaf = businessMenu.getLeaf();
		this.code = businessMenu.getCode();
		this.selectedIcon = businessMenu.getSelectedIcon();
		this.unSelectedIcon = businessMenu.getUnSelectedIcon();
	}
	
	public BusinessMenuQuery() {
		
	}	
	
	public java.lang.Integer getMenuId() {
		return this.menuId;
	}
	
	public void setMenuId(java.lang.Integer value) {
		this.menuId = value;
	}
		
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setName(java.lang.String value) {
		this.name = value;
	}
		
	public java.lang.String getUrl() {
		return this.url;
	}
	
	public void setUrl(java.lang.String value) {
		this.url = value;
	}
		
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
		
	public java.sql.Timestamp getModifyTime() {
		return this.modifyTime;
	}
	
	public void setModifyTime(java.sql.Timestamp value) {
		this.modifyTime = value;
	}
		
	public java.lang.String getEditor() {
		return this.editor;
	}
	
	public void setEditor(java.lang.String value) {
		this.editor = value;
	}
		
	public java.lang.Integer getParentId() {
		return this.parentId;
	}
	
	public void setParentId(java.lang.Integer value) {
		this.parentId = value;
	}
		
	public java.lang.Integer getOrd() {
		return this.ord;
	}
	
	public void setOrd(java.lang.Integer value) {
		this.ord = value;
	}
		
	public java.lang.Integer getLeaf() {
		return this.leaf;
	}
	
	public void setLeaf(java.lang.Integer value) {
		this.leaf = value;
	}
		
	public java.lang.String getCode() {
		return this.code;
	}
	
	public void setCode(java.lang.String value) {
		this.code = value;
	}
		
	public java.lang.String getSelectedIcon() {
		return this.selectedIcon;
	}
	
	public void setSelectedIcon(java.lang.String value) {
		this.selectedIcon = value;
	}
		
	public java.lang.String getUnSelectedIcon() {
		return this.unSelectedIcon;
	}
	
	public void setUnSelectedIcon(java.lang.String value) {
		this.unSelectedIcon = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

