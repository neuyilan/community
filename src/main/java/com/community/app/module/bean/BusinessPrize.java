package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessPrize implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1533568447644223091L;

	//别名
	public static final String TABLE_ALIAS = "BusinessPrize";

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

	public BusinessPrize(){
	}

	public BusinessPrize(
		java.lang.Integer prizeId
	){
		this.prizeId = prizeId;
	}

	public void setPrizeId(java.lang.Integer value) {
		this.prizeId = value;
	}
	
	public java.lang.Integer getPrizeId() {
		return this.prizeId;
	}
	public void setAwardName(java.lang.String value) {
		this.awardName = value;
	}
	
	public java.lang.String getAwardName() {
		return this.awardName;
	}
	public void setPrizeName(java.lang.String value) {
		this.prizeName = value;
	}
	
	public java.lang.String getPrizeName() {
		return this.prizeName;
	}
	public void setPrizeQuota(java.lang.Integer value) {
		this.prizeQuota = value;
	}
	
	public java.lang.Integer getPrizeQuota() {
		return this.prizeQuota;
	}
	public void setPrizeContent(java.lang.String value) {
		this.prizeContent = value;
	}
	
	public java.lang.String getPrizeContent() {
		return this.prizeContent;
	}
	public void setActId(java.lang.Integer value) {
		this.actId = value;
	}
	
	public java.lang.Integer getActId() {
		return this.actId;
	}
	public void setPrizeImg(java.lang.String value) {
		this.prizeImg = value;
	}
	
	public java.lang.String getPrizeImg() {
		return this.prizeImg;
	}
	public void setRankStart(java.lang.Integer value) {
		this.rankStart = value;
	}
	
	public java.lang.Integer getRankStart() {
		return this.rankStart;
	}
	public void setRankEnd(java.lang.Integer value) {
		this.rankEnd = value;
	}
	
	public java.lang.Integer getRankEnd() {
		return this.rankEnd;
	}
	public void setPrizeOrder(java.lang.Integer value) {
		this.prizeOrder = value;
	}
	
	public java.lang.Integer getPrizeOrder() {
		return this.prizeOrder;
	}
	public void setCreatTime(java.sql.Timestamp value) {
		this.creatTime = value;
	}
	
	public java.sql.Timestamp getCreatTime() {
		return this.creatTime;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("PrizeId",getPrizeId())
			.append("AwardName",getAwardName())
			.append("PrizeName",getPrizeName())
			.append("PrizeQuota",getPrizeQuota())
			.append("PrizeContent",getPrizeContent())
			.append("ActId",getActId())
			.append("PrizeImg",getPrizeImg())
			.append("RankStart",getRankStart())
			.append("RankEnd",getRankEnd())
			.append("PrizeOrder",getPrizeOrder())
			.append("CreatTime",getCreatTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getPrizeId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessPrize == false) return false;
		if(this == obj) return true;
		BusinessPrize other = (BusinessPrize)obj;
		return new EqualsBuilder()
			.append(getPrizeId(),other.getPrizeId())
			.isEquals();
	}
}

