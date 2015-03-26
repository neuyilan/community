package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessVote;

public class BusinessVoteQuery extends BaseBean {

	private java.lang.Integer voteId;
	private java.lang.Integer regId;
	private java.lang.Integer userId;
	private java.sql.Timestamp vateTime;

	public BusinessVoteQuery(BusinessVote businessVote) {
		this.voteId = businessVote.getVoteId();
		this.regId = businessVote.getRegId();
		this.userId = businessVote.getUserId();
		this.vateTime = businessVote.getVateTime();
	}

	public BusinessVoteQuery() {

	}

	public java.lang.Integer getVoteId() {
		return this.voteId;
	}

	public void setVoteId(java.lang.Integer value) {
		this.voteId = value;
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

	public java.sql.Timestamp getVateTime() {
		return this.vateTime;
	}

	public void setVateTime(java.sql.Timestamp value) {
		this.vateTime = value;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}