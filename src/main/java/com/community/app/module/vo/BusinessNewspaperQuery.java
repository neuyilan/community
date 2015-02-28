package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessNewspaper;

public class BusinessNewspaperQuery extends BaseBean {
	
	private java.lang.Integer newspaperId;
	private java.lang.String title;
	private java.lang.String pic;
	private java.lang.String url;
	private java.lang.Integer comId;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	
	private String timeScope;
	private String startTime;
	private String endTime;
	private String keyWord;
	private String comNameScope;
	private java.lang.Integer curUserId;
	private java.lang.Integer curComId;
	private Integer curEstateId;	
	
	public Integer getCurEstateId() {
		return curEstateId;
	}

	public void setCurEstateId(Integer curEstateId) {
		this.curEstateId = curEstateId;
	}

	public java.lang.Integer getCurUserId() {
		return curUserId;
	}

	public void setCurUserId(java.lang.Integer curUserId) {
		this.curUserId = curUserId;
	}

	public java.lang.Integer getCurComId() {
		return curComId;
	}

	public void setCurComId(java.lang.Integer curComId) {
		this.curComId = curComId;
	}

	public String getComNameScope() {
		return comNameScope;
	}

	public void setComNameScope(String comNameScope) {
		this.comNameScope = comNameScope;
	}

	public String getTimeScope() {
		return timeScope;
	}

	public void setTimeScope(String timeScope) {
		this.timeScope = timeScope;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public BusinessNewspaperQuery(BusinessNewspaper businessNewspaper) {
		this.newspaperId = businessNewspaper.getNewspaperId();
		this.title = businessNewspaper.getTitle();
		this.pic = businessNewspaper.getPic();
		this.url = businessNewspaper.getUrl();
		this.comId = businessNewspaper.getComId();
		this.createTime = businessNewspaper.getCreateTime();
		this.editTime = businessNewspaper.getEditTime();
		this.editor = businessNewspaper.getEditor();
	}
	
	public java.lang.Integer getNewspaperId() {
		return this.newspaperId;
	}
	
	public void setNewspaperId(java.lang.Integer value) {
		this.newspaperId = value;
	}
		
	public java.lang.String getTitle() {
		return this.title;
	}
	
	public void setTitle(java.lang.String value) {
		this.title = value;
	}
		
	public java.lang.String getPic() {
		return this.pic;
	}
	
	public void setPic(java.lang.String value) {
		this.pic = value;
	}
		
	public java.lang.String getUrl() {
		return this.url;
	}
	
	public void setUrl(java.lang.String value) {
		this.url = value;
	}
		
	public java.lang.Integer getComId() {
		return this.comId;
	}
	
	public void setComId(java.lang.Integer value) {
		this.comId = value;
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
		
	public BusinessNewspaperQuery() {
		
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
}