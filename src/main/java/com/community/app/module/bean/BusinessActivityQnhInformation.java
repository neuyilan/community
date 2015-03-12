package com.community.app.module.bean;



import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;



public class BusinessActivityQnhInformation implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessActivityQnhInformation";

	private java.lang.Integer informationId;
	private java.lang.Integer userId;
	private java.lang.Integer state;
	private java.lang.Integer actId;
	private java.lang.String realname;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public java.lang.Integer getState() {
		return state;
	}

	public void setState(java.lang.Integer state) {
		this.state = state;
	}

	public BusinessActivityQnhInformation(){
	}

	public BusinessActivityQnhInformation(
		java.lang.Integer informationId
	){
		this.informationId = informationId;
	}

	public void setInformationId(java.lang.Integer value) {
		this.informationId = value;
	}
	
	public java.lang.Integer getInformationId() {
		return this.informationId;
	}
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
	
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	public void setActId(java.lang.Integer value) {
		this.actId = value;
	}
	
	public java.lang.Integer getActId() {
		return this.actId;
	}
	public void setRealname(java.lang.String value) {
		this.realname = value;
	}
	
	public java.lang.String getRealname() {
		return this.realname;
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
	public void setEditor(java.lang.String value) {
		this.editor = value;
	}
	
	public java.lang.String getEditor() {
		return this.editor;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("InformationId",getInformationId())
			.append("UserId",getUserId())
			.append("ActId",getActId())
			.append("Realname",getRealname())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getInformationId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessActivityQnhInformation == false) return false;
		if(this == obj) return true;
		BusinessActivityQnhInformation other = (BusinessActivityQnhInformation)obj;
		return new EqualsBuilder()
			.append(getInformationId(),other.getInformationId())
			.isEquals();
	}
}

