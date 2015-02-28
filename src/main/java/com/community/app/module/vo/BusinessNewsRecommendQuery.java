package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessNewsRecommend;

public class BusinessNewsRecommendQuery extends BaseBean {
	

	private java.lang.Integer recId;
	private java.lang.Integer newsId;
	private java.lang.Integer recerId;
	private java.sql.Timestamp recTime;
	private java.lang.String recCom;

	public BusinessNewsRecommendQuery(BusinessNewsRecommend businessNewsRecommend) {
		this.recId = businessNewsRecommend.getRecId();
		this.newsId = businessNewsRecommend.getNewsId();
		this.recerId = businessNewsRecommend.getRecerId();
		this.recTime = businessNewsRecommend.getRecTime();
		this.recCom = businessNewsRecommend.getRecCom();
	}
	
	public BusinessNewsRecommendQuery() {
		
	}	
	
	public java.lang.Integer getRecId() {
		return this.recId;
	}
	
	public void setRecId(java.lang.Integer value) {
		this.recId = value;
	}
		
	public java.lang.Integer getNewsId() {
		return this.newsId;
	}
	
	public void setNewsId(java.lang.Integer value) {
		this.newsId = value;
	}
		
	public java.lang.Integer getRecerId() {
		return this.recerId;
	}
	
	public void setRecerId(java.lang.Integer value) {
		this.recerId = value;
	}
		
	public java.sql.Timestamp getRecTime() {
		return this.recTime;
	}
	
	public void setRecTime(java.sql.Timestamp value) {
		this.recTime = value;
	}
		
	public java.lang.String getRecCom() {
		return this.recCom;
	}
	
	public void setRecCom(java.lang.String value) {
		this.recCom = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

