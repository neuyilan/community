package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessProductKeyword implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessProductKeyword";

	private java.lang.Integer keywordId;
	private java.lang.String keyword;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public BusinessProductKeyword(){
	}

	public BusinessProductKeyword(
		java.lang.Integer keywordId
	){
		this.keywordId = keywordId;
	}

	public void setKeywordId(java.lang.Integer value) {
		this.keywordId = value;
	}
	
	public java.lang.Integer getKeywordId() {
		return this.keywordId;
	}
	public void setKeyword(java.lang.String value) {
		this.keyword = value;
	}
	
	public java.lang.String getKeyword() {
		return this.keyword;
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
			.append("KeywordId",getKeywordId())
			.append("Keyword",getKeyword())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getKeywordId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessProductKeyword == false) return false;
		if(this == obj) return true;
		BusinessProductKeyword other = (BusinessProductKeyword)obj;
		return new EqualsBuilder()
			.append(getKeywordId(),other.getKeywordId())
			.isEquals();
	}
}

