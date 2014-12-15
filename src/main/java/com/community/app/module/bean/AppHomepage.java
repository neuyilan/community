package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class AppHomepage implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "AppHomepage";

	private java.lang.Integer homePageId;
	private java.lang.Integer id;
	private java.lang.String title;
	private java.lang.String brief;
	private java.lang.String pic;
	private Integer type;
	private Integer top;
	private java.sql.Timestamp publishTime;

	public Integer getTop() {
		return top;
	}

	public void setTop(Integer top) {
		this.top = top;
	}

	public AppHomepage(){
	}

	public AppHomepage(
		java.lang.Integer homePageId
	){
		this.homePageId = homePageId;
	}

	public void setHomePageId(java.lang.Integer value) {
		this.homePageId = value;
	}
	
	public java.lang.Integer getHomePageId() {
		return this.homePageId;
	}
	public void setId(java.lang.Integer value) {
		this.id = value;
	}
	
	public java.lang.Integer getId() {
		return this.id;
	}
	public void setTitle(java.lang.String value) {
		this.title = value;
	}
	
	public java.lang.String getTitle() {
		return this.title;
	}
	public void setBrief(java.lang.String value) {
		this.brief = value;
	}
	
	public java.lang.String getBrief() {
		return this.brief;
	}
	public void setPic(java.lang.String value) {
		this.pic = value;
	}
	
	public java.lang.String getPic() {
		return this.pic;
	}
	public void setType(Integer value) {
		this.type = value;
	}
	
	public Integer getType() {
		return this.type;
	}
	public void setPublishTime(java.sql.Timestamp value) {
		this.publishTime = value;
	}
	
	public java.sql.Timestamp getPublishTime() {
		return this.publishTime;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("HomePageId",getHomePageId())
			.append("Id",getId())
			.append("Title",getTitle())
			.append("Brief",getBrief())
			.append("Pic",getPic())
			.append("Type",getType())
			.append("PublishTime",getPublishTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getHomePageId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AppHomepage == false) return false;
		if(this == obj) return true;
		AppHomepage other = (AppHomepage)obj;
		return new EqualsBuilder()
			.append(getHomePageId(),other.getHomePageId())
			.isEquals();
	}
}