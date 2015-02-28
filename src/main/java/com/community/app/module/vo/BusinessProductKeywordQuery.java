package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessProductKeyword;

public class BusinessProductKeywordQuery extends BaseBean {
	

	private java.lang.Integer keywordId;
	private java.lang.String keyword;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;

	public BusinessProductKeywordQuery(BusinessProductKeyword businessProductKeyword) {
		this.keywordId = businessProductKeyword.getKeywordId();
		this.keyword = businessProductKeyword.getKeyword();
		this.createTime = businessProductKeyword.getCreateTime();
		this.editTime = businessProductKeyword.getEditTime();
		this.editor = businessProductKeyword.getEditor();
	}
	
	public BusinessProductKeywordQuery() {
		
	}	
	
	public java.lang.Integer getKeywordId() {
		return this.keywordId;
	}
	
	public void setKeywordId(java.lang.Integer value) {
		this.keywordId = value;
	}
		
	public java.lang.String getKeyword() {
		return this.keyword;
	}
	
	public void setKeyword(java.lang.String value) {
		this.keyword = value;
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
	
}

