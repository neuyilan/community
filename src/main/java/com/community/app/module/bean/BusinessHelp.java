package com.community.app.module.bean;

import java.sql.Timestamp;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessHelp implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "BusinessHelp";

	private Integer helpId;
	private String helpTitle;
	private Integer helperId;
	private String helperName;
	private java.sql.Timestamp helpTime;
	private String helpContent;
	private Integer helpType;
	private Integer estateId;
	private String estateName;
	private Integer state;
	private Integer visits;
	private Integer comments;
	private Timestamp lastCommentTime;
	private Integer supports;
	private Integer isExpend;
	private String expendEstates;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private String editor;
	private String portrait;
	private String pics;
	private String audios;
	private String time;
	private Integer isNickname;
	private String realname;
	private String nickname;
	private String tel;
	private Integer userId;
	private String typeName;
	private Integer typeId ;


	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getIsNickname() {
		return isNickname;
	}

	public void setIsNickname(Integer isNickname) {
		this.isNickname = isNickname;
	}

	public String getPics() {
		return pics;
	}

	public void setPics(String pics) {
		this.pics = pics;
	}

	public String getAudios() {
		return audios;
	}

	public void setAudios(String audios) {
		this.audios = audios;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public BusinessHelp(){
	}

	public Integer getComments() {
		return comments;
	}

	public void setComments(Integer comments) {
		this.comments = comments;
	}

	public Timestamp getLastCommentTime() {
		return lastCommentTime;
	}

	public void setLastCommentTime(Timestamp lastCommentTime) {
		this.lastCommentTime = lastCommentTime;
	}

	public BusinessHelp(
		Integer helpId
	){
		this.helpId = helpId;
	}

	public void setHelpId(Integer value) {
		this.helpId = value;
	}
	
	public Integer getHelpId() {
		return this.helpId;
	}
	public void setHelpTitle(String value) {
		this.helpTitle = value;
	}
	
	public String getHelpTitle() {
		return this.helpTitle;
	}
	public void setHelperId(Integer value) {
		this.helperId = value;
	}
	
	public Integer getHelperId() {
		return this.helperId;
	}
	public void setHelperName(String value) {
		this.helperName = value;
	}
	
	public String getHelperName() {
		return this.helperName;
	}
	public void setHelpTime(java.sql.Timestamp value) {
		this.helpTime = value;
	}
	
	public java.sql.Timestamp getHelpTime() {
		return this.helpTime;
	}
	public void setHelpContent(String value) {
		this.helpContent = value;
	}
	
	public String getHelpContent() {
		return this.helpContent;
	}
	public void setHelpType(Integer value) {
		this.helpType = value;
	}
	
	public Integer getHelpType() {
		return this.helpType;
	}
	public void setEstateId(Integer value) {
		this.estateId = value;
	}
	
	public Integer getEstateId() {
		return this.estateId;
	}
	public void setEstateName(String value) {
		this.estateName = value;
	}
	
	public String getEstateName() {
		return this.estateName;
	}
	public void setState(Integer value) {
		this.state = value;
	}
	
	public Integer getState() {
		return this.state;
	}
	public void setVisits(Integer value) {
		this.visits = value;
	}
	
	public Integer getVisits() {
		return this.visits;
	}
	public void setSupports(Integer value) {
		this.supports = value;
	}
	
	public Integer getSupports() {
		return this.supports;
	}
	public void setIsExpend(Integer value) {
		this.isExpend = value;
	}
	
	public Integer getIsExpend() {
		return this.isExpend;
	}
	public void setExpendEstates(String value) {
		this.expendEstates = value;
	}
	
	public String getExpendEstates() {
		return this.expendEstates;
	}
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
	
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	public void setEditTime(java.sql.Timestamp value) {
		this.editTime = value;
	}
	
	public java.sql.Timestamp getEditTime() {
		return this.editTime;
	}

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("HelpId",getHelpId())
			.append("HelpTitle",getHelpTitle())
			.append("HelperId",getHelperId())
			.append("HelperName",getHelperName())
			.append("HelpTime",getHelpTime())
			.append("HelpContent",getHelpContent())
			.append("HelpType",getHelpType())
			.append("EstateId",getEstateId())
			.append("EstateName",getEstateName())
			.append("State",getState())
			.append("Visits",getVisits())
			.append("Supports",getSupports())
			.append("IsExpend",getIsExpend())
			.append("ExpendEstates",getExpendEstates())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getHelpId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BusinessHelp == false) return false;
		if(this == obj) return true;
		BusinessHelp other = (BusinessHelp)obj;
		return new EqualsBuilder()
			.append(getHelpId(),other.getHelpId())
			.isEquals();
	}
}

