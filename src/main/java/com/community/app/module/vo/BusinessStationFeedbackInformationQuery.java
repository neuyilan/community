package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessStationFeedbackInformation;

public class BusinessStationFeedbackInformationQuery extends BaseBean {

	private java.lang.Integer inforId;
	private java.lang.Integer feedId;
	private java.lang.Integer userId;
	private java.sql.Timestamp feedTime;
	private java.lang.Integer source;
	private java.lang.Integer flag;
	private String keyWord;
	private String nickName;
	private String realName;
	private String tel;
	
	public BusinessStationFeedbackInformationQuery(
			BusinessStationFeedbackInformation businessStationFeedbackInformation) {
		this.inforId = businessStationFeedbackInformation.getInforId();
		this.feedId = businessStationFeedbackInformation.getFeedId();
		this.userId = businessStationFeedbackInformation.getUserId();
		this.feedTime = businessStationFeedbackInformation.getFeedTime();
		this.source = businessStationFeedbackInformation.getSource();
		this.flag = businessStationFeedbackInformation.getFlag();
	}

	public BusinessStationFeedbackInformationQuery() {

	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public java.lang.Integer getInforId() {
		return this.inforId;
	}

	public void setInforId(java.lang.Integer value) {
		this.inforId = value;
	}

	public java.lang.Integer getFeedId() {
		return this.feedId;
	}

	public void setFeedId(java.lang.Integer value) {
		this.feedId = value;
	}

	public java.lang.Integer getUserId() {
		return this.userId;
	}

	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}

	public java.sql.Timestamp getFeedTime() {
		return this.feedTime;
	}

	public void setFeedTime(java.sql.Timestamp value) {
		this.feedTime = value;
	}

	public java.lang.Integer getSource() {
		return this.source;
	}

	public void setSource(java.lang.Integer value) {
		this.source = value;
	}

	public java.lang.Integer getFlag() {
		return this.flag;
	}

	public void setFlag(java.lang.Integer value) {
		this.flag = value;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}