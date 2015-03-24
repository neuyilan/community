package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessActReg;

public class BusinessActRegQuery extends BaseBean {
	

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
	private Integer flag;

	public BusinessActRegQuery(BusinessActReg businessActReg) {
		this.regId = businessActReg.getRegId();
		this.userId = businessActReg.getUserId();
		this.estateId = businessActReg.getEstateId();
		this.estateName = businessActReg.getEstateName();
		this.nickName = businessActReg.getNickName();
		this.avatar = businessActReg.getAvatar();
		this.code = businessActReg.getCode();
		this.desc = businessActReg.getDesc();
		this.actId = businessActReg.getActId();
		this.votes = businessActReg.getVotes();
		this.regTime = businessActReg.getRegTime();
		this.flag = businessActReg.getFlag();
	}
	
	public BusinessActRegQuery() {
		
	}	
	
	public java.lang.Integer getRegId() {
		return this.regId;
	}
	
	public void setRegId(java.lang.Integer value) {
		this.regId = value;
	}
		
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
		
	public java.lang.String getNickName() {
		return this.nickName;
	}
	
	public void setNickName(java.lang.String value) {
		this.nickName = value;
	}
		
	public java.lang.String getAvatar() {
		return this.avatar;
	}
	
	public void setAvatar(java.lang.String value) {
		this.avatar = value;
	}
		
	public java.lang.Integer getCode() {
		return this.code;
	}
	
	public void setCode(java.lang.Integer value) {
		this.code = value;
	}
		
	public java.lang.String getDesc() {
		return this.desc;
	}
	
	public void setDesc(java.lang.String value) {
		this.desc = value;
	}
		
	public java.lang.Integer getActId() {
		return this.actId;
	}
	
	public void setActId(java.lang.Integer value) {
		this.actId = value;
	}
		
	public java.lang.Integer getVotes() {
		return this.votes;
	}
	
	public void setVotes(java.lang.Integer value) {
		this.votes = value;
	}
		
	public java.sql.Timestamp getRegTime() {
		return this.regTime;
	}
	
	public void setRegTime(java.sql.Timestamp value) {
		this.regTime = value;
	}
		
	public Integer getFlag() {
		return this.flag;
	}
	
	public void setFlag(Integer value) {
		this.flag = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
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
	
}

