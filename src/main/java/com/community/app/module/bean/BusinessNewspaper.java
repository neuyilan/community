package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessNewspaper implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessNewspaper";

	private java.lang.Integer newspaperId;
	private java.lang.String title;
	private java.lang.String pic;
	private java.lang.String url;
	private java.lang.Integer comId;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.String comName;
	private java.lang.String comNameScope;
	
	public java.lang.String getComNameScope() {
		return comNameScope;
	}

	public void setComNameScope(java.lang.String comNameScope) {
		this.comNameScope = comNameScope;
	}

	public java.lang.String getComName() {
		return comName;
	}

	public void setComName(java.lang.String comName) {
		this.comName = comName;
	}

	public BusinessNewspaper(){
	}

	public BusinessNewspaper(
		java.lang.Integer newspaperId
	){
		this.newspaperId = newspaperId;
	}

	public void setNewspaperId(java.lang.Integer value) {
		this.newspaperId = value;
	}
	
	public java.lang.Integer getNewspaperId() {
		return this.newspaperId;
	}
	public void setTitle(java.lang.String value) {
		this.title = value;
	}
	
	public java.lang.String getTitle() {
		return this.title;
	}
	public void setPic(java.lang.String value) {
		this.pic = value;
	}
	
	public java.lang.String getPic() {
		return this.pic;
	}
	public void setUrl(java.lang.String value) {
		this.url = value;
	}
	
	public java.lang.String getUrl() {
		return this.url;
	}
	public void setComId(java.lang.Integer value) {
		this.comId = value;
	}
	
	public java.lang.Integer getComId() {
		return this.comId;
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
			.append("NewspaperId",getNewspaperId())
			.append("Title",getTitle())
			.append("Pic",getPic())
			.append("Url",getUrl())
			.append("ComId",getComId())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getNewspaperId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessNewspaper == false) return false;
		if(this == obj) return true;
		BusinessNewspaper other = (BusinessNewspaper)obj;
		return new EqualsBuilder()
			.append(getNewspaperId(),other.getNewspaperId())
			.isEquals();
	}
}