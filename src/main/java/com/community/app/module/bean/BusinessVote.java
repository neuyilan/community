package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class BusinessVote implements java.io.Serializable{
	

	private static final long serialVersionUID = 1709633576326671998L;

	//别名
	public static final String TABLE_ALIAS = "BusinessVote";

	private java.lang.Integer voteId;
	private java.lang.Integer regId;
	private java.lang.Integer userId;
	private java.sql.Timestamp vateTime;
	private java.lang.Integer actId;

	public BusinessVote(){
	}

	public BusinessVote(
		java.lang.Integer voteId
	){
		this.voteId = voteId;
	}

	public void setVoteId(java.lang.Integer value) {
		this.voteId = value;
	}
	
	public java.lang.Integer getVoteId() {
		return this.voteId;
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
	public void setVateTime(java.sql.Timestamp value) {
		this.vateTime = value;
	}
	
	public java.sql.Timestamp getVateTime() {
		return this.vateTime;
	}
	public void setActId(java.lang.Integer value) {
		this.actId = value;
	}
	
	public java.lang.Integer getActId() {
		return this.actId;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("VoteId",getVoteId())
			.append("RegId",getRegId())
			.append("UserId",getUserId())
			.append("VateTime",getVateTime())
			.append("ActId",getActId())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getVoteId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessVote == false) return false;
		if(this == obj) return true;
		BusinessVote other = (BusinessVote)obj;
		return new EqualsBuilder()
			.append(getVoteId(),other.getVoteId())
			.isEquals();
	}
}

