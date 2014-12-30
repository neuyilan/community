package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.sql.Timestamp;

import com.community.app.module.bean.AppUser;
import com.community.app.module.vo.BaseBean;

public class AppUserQuery extends BaseBean {
	

	private Integer userId;
	private String realname;
	private String nickname;
	private String password;
	private String cellphone;
	private String tel;
	private Integer sex;
	private String birthday;
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
	private String avatar;
	private String dimensionCode;
	private String homeAttr;
	private Integer familyId;
	private Timestamp lastLoginTime;

	private String timeScope;
	private String startTime;
	private String endTime;
	private String orderBy;
	private String keyWord;
	
	private String estateName;
	private String address;
	private Integer buildingId;
	private Integer propertyId;

	private Integer curEstateId;
	private String orgType;
	private Integer curUserId;
	private String baiduId;
	private String channelId;
	private Integer deviceType;
	private String dateField;
	private String remarks;
	private String wenxinId;
	private String qqId;
	private Integer comId;
	private String ids;
	
    public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public Integer getComId() {
		return comId;
	}

	public void setComId(Integer comId) {
		this.comId = comId;
	}

	public String getWenxinId() {
		return wenxinId;
	}

	public void setWenxinId(String wenxinId) {
		this.wenxinId = wenxinId;
	}

	public String getQqId() {
		return qqId;
	}

	public void setQqId(String qqId) {
		this.qqId = qqId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDateField() {
		return dateField;
	}

	public void setDateField(String dateField) {
		this.dateField = dateField;
	}

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

	public Integer getCurUserId() {
		return curUserId;
	}

	public void setCurUserId(Integer curUserId) {
		this.curUserId = curUserId;
	}

	public Integer getCurEstateId() {
		return curEstateId;
	}

	public void setCurEstateId(Integer curEstateId) {
		this.curEstateId = curEstateId;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Integer propertyId) {
		this.propertyId = propertyId;
	}

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public AppUserQuery(AppUser appUser) {
		this.userId = appUser.getUserId();
		this.realname = appUser.getRealname();
		this.nickname = appUser.getNickname();
		this.password = appUser.getPassword();
		this.tel = appUser.getTel();
		this.sex = appUser.getSex();
		this.type = appUser.getType();
		this.isWorker = appUser.getIsWorker();
		this.state = appUser.getState();
		this.random = appUser.getRandom();
		this.registTime = appUser.getRegistTime();
		this.verifyTime = appUser.getVerifyTime();
		this.verifier = appUser.getVerifier();
		this.signature = appUser.getSignature();
		this.portrait = appUser.getPortrait();
		this.idCard = appUser.getIdCard();
		this.estateId = appUser.getEstateId();
		this.isNameSecret = appUser.getIsNameSecret();
		this.isTelSecret = appUser.getIsTelSecret();
		this.workerMemo = appUser.getWorkerMemo();
		this.weixin = appUser.getWeixin();
		this.createTime = appUser.getCreateTime();
		this.editTime = appUser.getEditTime();
		this.editor = appUser.getEditor();
		this.lastLoginTime = appUser.getLastLoginTime();
		this.dimensionCode = appUser.getDimensionCode();
		this.familyId = appUser.getFamilyId();
		this.homeAttr = appUser.getHomeAttr();
		this.address = appUser.getAddress();
		this.estateName = appUser.getEstateName();
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

	public String getDimensionCode() {
		return dimensionCode;
	}

	public void setDimensionCode(String dimensionCode) {
		this.dimensionCode = dimensionCode;
	}

	public String getHomeAttr() {
		return homeAttr;
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

	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getTimeScope() {
		return timeScope;
	}

	public void setTimeScope(String timeScope) {
		this.timeScope = timeScope;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
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

	public AppUserQuery() {
		
	}	
	
	public Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(Integer value) {
		this.userId = value;
	}
		
	public String getRealname() {
		return this.realname;
	}
	
	public void setRealname(String value) {
		this.realname = value;
	}
		
	public String getNickname() {
		return this.nickname;
	}
	
	public void setNickname(String value) {
		this.nickname = value;
	}
		
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
		
	public String getTel() {
		return this.tel;
	}
	
	public void setTel(String value) {
		this.tel = value;
	}
		
	public Integer getSex() {
		return this.sex;
	}
	
	public void setSex(Integer value) {
		this.sex = value;
	}
		
		
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getType() {
		return this.type;
	}
	
	public void setType(Integer value) {
		this.type = value;
	}
		
	public Integer getIsWorker() {
		return this.isWorker;
	}
	
	public void setIsWorker(Integer value) {
		this.isWorker = value;
	}
		
	public Integer getState() {
		return this.state;
	}
	
	public void setState(Integer value) {
		this.state = value;
	}
		
	public String getRandom() {
		return this.random;
	}
	
	public void setRandom(String value) {
		this.random = value;
	}
		
	public java.sql.Timestamp getRegistTime() {
		return this.registTime;
	}
	
	public void setRegistTime(java.sql.Timestamp value) {
		this.registTime = value;
	}
		
	public java.sql.Timestamp getVerifyTime() {
		return this.verifyTime;
	}
	
	public void setVerifyTime(java.sql.Timestamp value) {
		this.verifyTime = value;
	}
		
	public String getVerifier() {
		return this.verifier;
	}
	
	public void setVerifier(String value) {
		this.verifier = value;
	}
		
	public String getSignature() {
		return this.signature;
	}
	
	public void setSignature(String value) {
		this.signature = value;
	}
		
	public String getPortrait() {
		return this.portrait;
	}
	
	public void setPortrait(String value) {
		this.portrait = value;
	}
		
	public String getIdCard() {
		return this.idCard;
	}
	
	public void setIdCard(String value) {
		this.idCard = value;
	}
		
	public Integer getEstateId() {
		return this.estateId;
	}
	
	public void setEstateId(Integer value) {
		this.estateId = value;
	}
		
	public Integer getIsNameSecret() {
		return this.isNameSecret;
	}
	
	public void setIsNameSecret(Integer value) {
		this.isNameSecret = value;
	}
		
	public Integer getIsTelSecret() {
		return this.isTelSecret;
	}
	
	public void setIsTelSecret(Integer value) {
		this.isTelSecret = value;
	}
		
	public String getWorkerMemo() {
		return this.workerMemo;
	}
	
	public void setWorkerMemo(String value) {
		this.workerMemo = value;
	}
		
	public String getWeixin() {
		return this.weixin;
	}
	
	public void setWeixin(String value) {
		this.weixin = value;
	}
		
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
		
	public java.sql.Timestamp getEditTime() {
		return this.editTime;
	}
	
	public void setEditTime(java.sql.Timestamp value) {
		this.editTime = value;
	}
		
	public String getEditor() {
		return this.editor;
	}
	
	public void setEditor(String value) {
		this.editor = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

