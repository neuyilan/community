package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessActReg;

public class BusinessActRegQuery extends BaseBean {

	private java.lang.Integer regId;
	private java.lang.Integer ID;
	private java.lang.Integer userId;
	private java.lang.Integer estateId;
	private java.lang.String estateName;
	private java.lang.String nickName;
	private java.lang.String avatar;
	private java.lang.Integer code;
	private java.lang.String content;
	private java.lang.Integer actId;
	private java.lang.Integer type;
	private java.lang.Integer votes;
	private java.sql.Timestamp regTime;
	private Integer flag;
	private String orderBy;
	private java.lang.Integer comId;
	private String keyWord;
	private java.lang.String brief;
	private String picUrl;
	private String action;
	private String picUrlAvatar;
	private String contentAvatar;
	private java.lang.Integer regIdAvatar;
	
	public String getPicUrlAvatar() {
		return picUrlAvatar;
	}

	public void setPicUrlAvatar(String picUrlAvatar) {
		this.picUrlAvatar = picUrlAvatar;
	}

	public String getContentAvatar() {
		return contentAvatar;
	}

	public void setContentAvatar(String contentAvatar) {
		this.contentAvatar = contentAvatar;
	}

	public java.lang.Integer getRegIdAvatar() {
		return regIdAvatar;
	}

	public void setRegIdAvatar(java.lang.Integer regIdAvatar) {
		this.regIdAvatar = regIdAvatar;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public java.lang.Integer getComId() {
		return comId;
	}

	public void setComId(java.lang.Integer comId) {
		this.comId = comId;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	
	public java.lang.String getBrief() {
		return brief;
	}

	public void setBrief(java.lang.String brief) {
		this.brief = brief;
	}

	public java.lang.Integer getID() {
		return ID;
	}

	public void setID(java.lang.Integer iD) {
		ID = iD;
	}

	public java.lang.Integer getType() {
		return type;
	}

	public void setType(java.lang.Integer type) {
		this.type = type;
	}

	public BusinessActRegQuery(BusinessActReg businessActReg) {
		this.regId = businessActReg.getRegId();
		this.userId = businessActReg.getUserId();
		this.estateId = businessActReg.getEstateId();
		this.estateName = businessActReg.getEstateName();
		this.nickName = businessActReg.getNickName();
		this.avatar = businessActReg.getAvatar();
		this.code = businessActReg.getCode();
		this.content = businessActReg.getContent();
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

	public java.lang.String getContent() {
		return this.content;
	}

	public void setContent(java.lang.String value) {
		this.content = value;
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
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
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