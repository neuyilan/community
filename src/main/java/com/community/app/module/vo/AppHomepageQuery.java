package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.AppHomepage;
import com.community.app.module.vo.BaseBean;

public class AppHomepageQuery extends BaseBean {
	
	private java.lang.Integer homePageId;
	private java.lang.Integer id;
	private java.lang.String title;
	private java.lang.String brief;
	private java.lang.String pic;
	private Integer type;
	private java.sql.Timestamp publishTime;
	private java.lang.Integer estateId;
	private java.lang.Integer stationId;
	private java.lang.Integer comId;
	private java.lang.Integer proId;
	private java.lang.Integer top;
	private java.lang.Integer userId;

	public java.lang.Integer getUserId() {
		return userId;
	}

	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	public java.lang.Integer getTop() {
		return top;
	}

	public void setTop(java.lang.Integer top) {
		this.top = top;
	}

	public java.lang.Integer getEstateId() {
		return estateId;
	}

	public void setEstateId(java.lang.Integer estateId) {
		this.estateId = estateId;
	}

	public java.lang.Integer getStationId() {
		return stationId;
	}

	public void setStationId(java.lang.Integer stationId) {
		this.stationId = stationId;
	}

	public java.lang.Integer getComId() {
		return comId;
	}

	public void setComId(java.lang.Integer comId) {
		this.comId = comId;
	}

	public java.lang.Integer getProId() {
		return proId;
	}

	public void setProId(java.lang.Integer proId) {
		this.proId = proId;
	}

	public AppHomepageQuery(AppHomepage appHomepage) {
		this.homePageId = appHomepage.getHomePageId();
		this.id = appHomepage.getId();
		this.title = appHomepage.getTitle();
		this.brief = appHomepage.getBrief();
		this.pic = appHomepage.getPic();
		this.type = appHomepage.getType();
		this.publishTime = appHomepage.getPublishTime();
	}
	
	public AppHomepageQuery() {
		
	}	
	
	public java.lang.Integer getHomePageId() {
		return this.homePageId;
	}
	
	public void setHomePageId(java.lang.Integer value) {
		this.homePageId = value;
	}
		
	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setId(java.lang.Integer value) {
		this.id = value;
	}
		
	public java.lang.String getTitle() {
		return this.title;
	}
	
	public void setTitle(java.lang.String value) {
		this.title = value;
	}
		
	public java.lang.String getBrief() {
		return this.brief;
	}
	
	public void setBrief(java.lang.String value) {
		this.brief = value;
	}
		
	public java.lang.String getPic() {
		return this.pic;
	}
	
	public void setPic(java.lang.String value) {
		this.pic = value;
	}
		
	public Integer getType() {
		return this.type;
	}
	
	public void setType(Integer value) {
		this.type = value;
	}
		
	public java.sql.Timestamp getPublishTime() {
		return this.publishTime;
	}
	
	public void setPublishTime(java.sql.Timestamp value) {
		this.publishTime = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
}