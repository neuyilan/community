package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessActReg implements java.io.Serializable{

	
	private static final long serialVersionUID = -2876496547488181892L;

	//别名
	public static final String TABLE_ALIAS = "BusinessActReg";

	private java.lang.Integer regId;
	private java.lang.Integer userId;
	private java.lang.Integer estateId;
	private java.lang.String estateName;
	private java.lang.String nickName;
	private java.lang.String avatar;
	private java.lang.Integer code;
	private java.lang.String desc;
	private java.lang.Integer actId;
	private java.lang.Integer votes;
	private java.sql.Timestamp regTime;
	private java.lang.Integer rank;
	private Integer flag;

	public BusinessActReg(){
	}

	public BusinessActReg(
		java.lang.Integer regId
	){
		this.regId = regId;
	}

	public void setRegId(java.lang.Integer value) {
		this.regId = value;
	}
	
	public java.lang.Integer getRegId() {
		return this.regId;
	}
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
	
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	public void setNickName(java.lang.String value) {
		this.nickName = value;
	}
	
	public java.lang.String getNickName() {
		return this.nickName;
	}
	public void setAvatar(java.lang.String value) {
		this.avatar = value;
	}
	
	public java.lang.String getAvatar() {
		return this.avatar;
	}
	public void setCode(java.lang.Integer value) {
		this.code = value;
	}
	
	public java.lang.Integer getCode() {
		return this.code;
	}
	public void setDesc(java.lang.String value) {
		this.desc = value;
	}
	
	public java.lang.String getDesc() {
		return this.desc;
	}
	public void setActId(java.lang.Integer value) {
		this.actId = value;
	}
	
	public java.lang.Integer getActId() {
		return this.actId;
	}
	public void setVotes(java.lang.Integer value) {
		this.votes = value;
	}
	
	public java.lang.Integer getVotes() {
		return this.votes;
	}
	public void setRegTime(java.sql.Timestamp value) {
		this.regTime = value;
	}
	
	public java.sql.Timestamp getRegTime() {
		return this.regTime;
	}
	public void setFlag(Integer value) {
		this.flag = value;
	}
	
	public Integer getFlag() {
		return this.flag;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("RegId",getRegId())
			.append("UserId",getUserId())
			.append("EstateId", getEstateId())
			.append("EstateName", getEstateName())
			.append("NickName",getNickName())
			.append("Avatar",getAvatar())
			.append("Code",getCode())
			.append("Desc",getDesc())
			.append("ActId",getActId())
			.append("Votes",getVotes())
			.append("RegTime",getRegTime())
			.append("Flag",getFlag())
			.append("Rank", getRank())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getRegId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessActReg == false) return false;
		if(this == obj) return true;
		BusinessActReg other = (BusinessActReg)obj;
		return new EqualsBuilder()
			.append(getRegId(),other.getRegId())
			.isEquals();
	}

	public java.lang.Integer getEstateId() {
		return estateId;
	}

	public void setEstateId(java.lang.Integer estateId) {
		this.estateId = estateId;
	}

	public java.lang.String getEstateName() {
		return estateName;
	}

	public void setEstateName(java.lang.String estateName) {
		this.estateName = estateName;
	}

	public java.lang.Integer getRank() {
		return rank;
	}

	public void setRank(java.lang.Integer rank) {
		this.rank = rank;
	}
}

