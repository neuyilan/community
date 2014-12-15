package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessNewsRecommend implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessNewsRecommend";

	private java.lang.Integer recId;
	private java.lang.Integer newsId;
	private java.lang.Integer recerId;
	private java.sql.Timestamp recTime;
	private java.lang.String recCom;

	public BusinessNewsRecommend(){
	}

	public BusinessNewsRecommend(
		java.lang.Integer recId
	){
		this.recId = recId;
	}

	public void setRecId(java.lang.Integer value) {
		this.recId = value;
	}
	
	public java.lang.Integer getRecId() {
		return this.recId;
	}
	public void setNewsId(java.lang.Integer value) {
		this.newsId = value;
	}
	
	public java.lang.Integer getNewsId() {
		return this.newsId;
	}
	public void setRecerId(java.lang.Integer value) {
		this.recerId = value;
	}
	
	public java.lang.Integer getRecerId() {
		return this.recerId;
	}
	public void setRecTime(java.sql.Timestamp value) {
		this.recTime = value;
	}
	
	public java.sql.Timestamp getRecTime() {
		return this.recTime;
	}
	public void setRecCom(java.lang.String value) {
		this.recCom = value;
	}
	
	public java.lang.String getRecCom() {
		return this.recCom == null?"":this.recCom;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("RecId",getRecId())
			.append("NewsId",getNewsId())
			.append("RecerId",getRecerId())
			.append("RecTime",getRecTime())
			.append("RecCom",getRecCom())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getRecId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessNewsRecommend == false) return false;
		if(this == obj) return true;
		BusinessNewsRecommend other = (BusinessNewsRecommend)obj;
		return new EqualsBuilder()
			.append(getRecId(),other.getRecId())
			.isEquals();
	}
}