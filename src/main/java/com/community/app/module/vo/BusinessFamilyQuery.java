package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessFamily;

public class BusinessFamilyQuery extends BaseBean {
	

	private java.lang.Integer familyId;
	private java.lang.String familyName;
	private java.lang.String avatar;
	private java.lang.String familyDesc;
	private java.lang.String dimensionCode;
	private java.lang.String verifyCode;
	private java.lang.Integer mount;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.Integer userId;
	private java.lang.String name;
	private java.lang.String info;
	private java.lang.String realname;
	private java.lang.String userAvatar;
	private java.lang.String tel;
	private java.lang.Integer familyState;
	private java.lang.String path;
	private java.lang.String filedir;
	private java.lang.String attr;
	private java.lang.Integer estateId;

	public java.lang.Integer getEstateId() {
		return estateId;
	}

	public void setEstateId(java.lang.Integer estateId) {
		this.estateId = estateId;
	}

	public java.lang.String getAttr() {
		return attr;
	}

	public void setAttr(java.lang.String attr) {
		this.attr = attr;
	}

	public java.lang.String getPath() {
		return path;
	}

	public void setPath(java.lang.String path) {
		this.path = path;
	}

	public java.lang.String getFiledir() {
		return filedir;
	}

	public void setFiledir(java.lang.String filedir) {
		this.filedir = filedir;
	}

	public java.lang.Integer getFamilyState() {
		return familyState;
	}

	public void setFamilyState(java.lang.Integer familyState) {
		this.familyState = familyState;
	}

	public java.lang.String getTel() {
		return tel;
	}

	public void setTel(java.lang.String tel) {
		this.tel = tel;
	}

	public java.lang.String getRealname() {
		return realname;
	}

	public void setRealname(java.lang.String realname) {
		this.realname = realname;
	}

	public java.lang.String getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(java.lang.String userAvatar) {
		this.userAvatar = userAvatar;
	}

	public java.lang.String getInfo() {
		return info;
	}

	public void setInfo(java.lang.String info) {
		this.info = info;
	}

	public BusinessFamilyQuery(BusinessFamily businessFamily) {
		this.familyId = businessFamily.getFamilyId();
		this.familyName = businessFamily.getFamilyName();
		this.avatar = businessFamily.getAvatar();
		this.familyDesc = businessFamily.getFamilyDesc();
		this.dimensionCode = businessFamily.getDimensionCode();
		this.verifyCode = businessFamily.getVerifyCode();
		this.mount = businessFamily.getMount();
		this.createTime = businessFamily.getCreateTime();
		this.editTime = businessFamily.getEditTime();
		this.editor = businessFamily.getEditor();
	}
	
	public BusinessFamilyQuery() {
		
	}	
	
	public java.lang.Integer getFamilyId() {
		return this.familyId;
	}
	
	public void setFamilyId(java.lang.Integer value) {
		this.familyId = value;
	}
		
	public java.lang.String getFamilyName() {
		return this.familyName;
	}
	
	public void setFamilyName(java.lang.String value) {
		this.familyName = value;
	}
		
	public java.lang.String getAvatar() {
		return this.avatar;
	}
	
	public void setAvatar(java.lang.String value) {
		this.avatar = value;
	}
		
	public java.lang.String getFamilyDesc() {
		return this.familyDesc;
	}
	
	public void setFamilyDesc(java.lang.String value) {
		this.familyDesc = value;
	}
		
	public java.lang.String getDimensionCode() {
		return this.dimensionCode;
	}
	
	public void setDimensionCode(java.lang.String value) {
		this.dimensionCode = value;
	}
		
	public java.lang.String getVerifyCode() {
		return this.verifyCode;
	}
	
	public void setVerifyCode(java.lang.String value) {
		this.verifyCode = value;
	}
		
	public java.lang.Integer getMount() {
		return this.mount;
	}
	
	public void setMount(java.lang.Integer value) {
		this.mount = value;
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

	public java.lang.Integer getUserId() {
		return userId;
	}

	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}
	
	
}

