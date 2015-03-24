package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.BusinessPrize;
import com.community.app.module.vo.BaseBean;

public class BusinessPrizeQuery extends BaseBean {
	

	private java.lang.Integer prizeId;
	private java.lang.String awardName;
	private java.lang.String prizeName;
	private java.lang.Integer prizeQuota;
	private java.lang.String prizeContent;
	private java.lang.Integer actId;
	private java.lang.String prizeImg;
	private java.lang.Integer rankStart;
	private java.lang.Integer rankEnd;
	private java.lang.Integer prizeOrder;
	private java.sql.Timestamp creatTime;

	public BusinessPrizeQuery(BusinessPrize businessPrize) {
		this.prizeId = businessPrize.getPrizeId();
		this.awardName = businessPrize.getAwardName();
		this.prizeName = businessPrize.getPrizeName();
		this.prizeQuota = businessPrize.getPrizeQuota();
		this.prizeContent = businessPrize.getPrizeContent();
		this.actId = businessPrize.getActId();
		this.prizeImg = businessPrize.getPrizeImg();
		this.rankStart = businessPrize.getRankStart();
		this.rankEnd = businessPrize.getRankEnd();
		this.prizeOrder = businessPrize.getPrizeOrder();
		this.creatTime = businessPrize.getCreatTime();
	}
	
	public BusinessPrizeQuery() {
		
	}	
	
	public java.lang.Integer getPrizeId() {
		return this.prizeId;
	}
	
	public void setPrizeId(java.lang.Integer value) {
		this.prizeId = value;
	}
		
	public java.lang.String getAwardName() {
		return this.awardName;
	}
	
	public void setAwardName(java.lang.String value) {
		this.awardName = value;
	}
		
	public java.lang.String getPrizeName() {
		return this.prizeName;
	}
	
	public void setPrizeName(java.lang.String value) {
		this.prizeName = value;
	}
		
	public java.lang.Integer getPrizeQuota() {
		return this.prizeQuota;
	}
	
	public void setPrizeQuota(java.lang.Integer value) {
		this.prizeQuota = value;
	}
		
	public java.lang.String getPrizeContent() {
		return this.prizeContent;
	}
	
	public void setPrizeContent(java.lang.String value) {
		this.prizeContent = value;
	}
		
	public java.lang.Integer getActId() {
		return this.actId;
	}
	
	public void setActId(java.lang.Integer value) {
		this.actId = value;
	}
		
	public java.lang.String getPrizeImg() {
		return this.prizeImg;
	}
	
	public void setPrizeImg(java.lang.String value) {
		this.prizeImg = value;
	}
		
	public java.lang.Integer getRankStart() {
		return this.rankStart;
	}
	
	public void setRankStart(java.lang.Integer value) {
		this.rankStart = value;
	}
		
	public java.lang.Integer getRankEnd() {
		return this.rankEnd;
	}
	
	public void setRankEnd(java.lang.Integer value) {
		this.rankEnd = value;
	}
		
	public java.lang.Integer getPrizeOrder() {
		return this.prizeOrder;
	}
	
	public void setPrizeOrder(java.lang.Integer value) {
		this.prizeOrder = value;
	}
		
	public java.sql.Timestamp getCreatTime() {
		return this.creatTime;
	}
	
	public void setCreatTime(java.sql.Timestamp value) {
		this.creatTime = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

