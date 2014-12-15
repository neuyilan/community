package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.sql.Timestamp;
import java.util.*;

@SuppressWarnings("serial")
public class AppUser implements java.io.Serializable{
	
	//别名
	public static final String TABLE_ALIAS = "AppUser";

	private Integer userId;
	private String realname;
	private String nickname;
	private String password;
	private String tel;
	private Integer sex;
	private Date birthday;
	private String strBirthday;
	private Integer type;
	private Integer isWorker;
	private Integer state;
	private String random;
	private java.sql.Timestamp registTime;
	private java.sql.Timestamp verifyTime;
	private String verifier;
	private String signature;
	private String portrait;
	private String idCard;
	private Integer estateId;
	private Integer isNameSecret;
	private Integer isTelSecret;
	private String workerMemo;
	private String weixin;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private String editor;
	private String address;
	private String estateName;
	
	private String dimensionCode;
	private String homeAttr;
	private Integer familyId;
	private Timestamp lastLoginTime;
	private String path;
	private String filedir;
	private String baiduId;
	private String channelId;
	private Integer deviceType;

	public Integer getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}

	public String getBaiduId() {
		return baiduId;
	}

	public void setBaiduId(String baiduId) {
		this.baiduId = baiduId;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFiledir() {
		return filedir;
	}

	public void setFiledir(String filedir) {
		this.filedir = filedir;
	}

	public String getEstateName() {
		return estateName;
	}

	public void setEstateName(String estateName) {
		this.estateName = estateName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStrBirthday() {
		return strBirthday;
	}

	public String getDimensionCode() {
		return dimensionCode;
	}

	public void setDimensionCode(String dimensionCode) {
		this.dimensionCode = dimensionCode;
	}

	public String getHomeAttr() {
		return homeAttr == null?"":homeAttr;
	}

	public void setHomeAttr(String homeAttr) {
		this.homeAttr = homeAttr;
	}

	public Integer getFamilyId() {
		return familyId;
	}

	public void setFamilyId(Integer familyId) {
		this.familyId = familyId;
	}

	public void setStrBirthday(String strBirthday) {
		this.strBirthday = strBirthday;
	}

	public AppUser(){
	}

	public AppUser(
		Integer userId
	){
		this.userId = userId;
	}

	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public void setUserId(Integer value) {
		this.userId = value;
	}
	
	public Integer getUserId() {
		return this.userId;
	}
	public void setRealname(String value) {
		this.realname = value;
	}
	
	public String getRealname() {
		return this.realname ;
	}
	public void setNickname(String value) {
		this.nickname = value;
	}
	
	public String getNickname() {
		return this.nickname ;
	}
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return this.password;
	}
	public void setTel(String value) {
		this.tel = value;
	}
	
	public String getTel() {
		return this.tel;
	}
	public void setSex(Integer value) {
		this.sex = value;
	}
	
	public Integer getSex() {
		return this.sex;
	}
	public void setBirthday(Date value) {
		this.birthday = value;
	}
	
	public Date getBirthday() {
		return this.birthday;
	}
	public void setType(Integer value) {
		this.type = value;
	}
	
	public Integer getType() {
		return this.type;
	}
	public void setIsWorker(Integer value) {
		this.isWorker = value;
	}
	
	public Integer getIsWorker() {
		return this.isWorker;
	}
	public void setState(Integer value) {
		this.state = value;
	}
	
	public Integer getState() {
		return this.state;
	}
	public void setRandom(String value) {
		this.random = value;
	}
	
	public String getRandom() {
		return this.random;
	}
	public void setRegistTime(java.sql.Timestamp value) {
		this.registTime = value;
	}
	
	public java.sql.Timestamp getRegistTime() {
		return this.registTime;
	}
	public void setVerifyTime(java.sql.Timestamp value) {
		this.verifyTime = value;
	}
	
	public java.sql.Timestamp getVerifyTime() {
		return this.verifyTime;
	}
	public void setVerifier(String value) {
		this.verifier = value;
	}
	
	public String getVerifier() {
		return this.verifier;
	}
	public void setSignature(String value) {
		this.signature = value;
	}
	
	public String getSignature() {
		return this.signature;
	}
	public void setPortrait(String value) {
		this.portrait = value;
	}
	
	public String getPortrait() {
		return this.portrait;
	}
	public void setIdCard(String value) {
		this.idCard = value;
	}
	
	public String getIdCard() {
		return this.idCard;
	}
	public void setEstateId(Integer value) {
		this.estateId = value;
	}
	
	public Integer getEstateId() {
		return this.estateId;
	}
	public void setIsNameSecret(Integer value) {
		this.isNameSecret = value;
	}
	
	public Integer getIsNameSecret() {
		return this.isNameSecret;
	}
	public void setIsTelSecret(Integer value) {
		this.isTelSecret = value;
	}
	
	public Integer getIsTelSecret() {
		return this.isTelSecret;
	}
	public void setWorkerMemo(String value) {
		this.workerMemo = value;
	}
	
	public String getWorkerMemo() {
		return this.workerMemo;
	}
	public void setWeixin(String value) {
		this.weixin = value;
	}
	
	public String getWeixin() {
		return this.weixin;
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
	public void setEditor(String value) {
		this.editor = value;
	}
	
	public String getEditor() {
		return this.editor == null?"":this.editor;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("UserId",getUserId())
			.append("Realname",getRealname())
			.append("Nickname",getNickname())
			.append("Password",getPassword())
			.append("Tel",getTel())
			.append("Sex",getSex())
			.append("Birthday",getBirthday())
			.append("Type",getType())
			.append("IsWorker",getIsWorker())
			.append("State",getState())
			.append("Random",getRandom())
			.append("RegistTime",getRegistTime())
			.append("VerifyTime",getVerifyTime())
			.append("Verifier",getVerifier())
			.append("Signature",getSignature())
			.append("Portrait",getPortrait())
			.append("IdCard",getIdCard())
			.append("EstateId",getEstateId())
			.append("IsNameSecret",getIsNameSecret())
			.append("IsTelSecret",getIsTelSecret())
			.append("WorkerMemo",getWorkerMemo())
			.append("Weixin",getWeixin())
			.append("CreateTime",getCreateTime())
			.append("EditTime",getEditTime())
			.append("Editor",getEditor())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getUserId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AppUser == false) return false;
		if(this == obj) return true;
		AppUser other = (AppUser)obj;
		return new EqualsBuilder()
			.append(getUserId(),other.getUserId())
			.isEquals();
	}
}