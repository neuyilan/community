package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.community.app.module.bean.BusinessUser;

public class BusinessUserQuery extends BaseBean {
	
	private Integer userId;
	private String userName;
	private String userTel;
	private String userPassword;
	private String userCode;
	private java.sql.Timestamp lastLoginTime;
	private String userEmail;
	private String userPhoto;
	private String userBrief;
	private String userService;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private String editor;
	private Integer positionId;
	private String posName;
	private String modules;
	private Integer isCharge;
	private String orgType;
	private String fromAddress;
	private String homeAddress;
	private String sex;
	private String age;
	private String isMarriage;
	private String hometown;
	private String nation;
	private String nickname;
	private String avatar;
	private Integer isManager;
	private String state;
    private String scope;
    private String rights;

    private String annoPic; //头像
    
    private String timeScope;
	private String startTime;
	private String endTime;
	private String orderBy;
	private String keyWord;
	
	private String rightsInfo;
	private Integer isGirl;
	private Integer orgId;
	private String comWord;
	private Integer depId;
	private Integer curUserId;
	private String newpassword;
	private String valipassword;
	private Integer curEstateId;
	private Integer curComId;
	private String flag;
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Integer getCurComId() {
		return curComId;
	}

	public void setCurComId(Integer curComId) {
		this.curComId = curComId;
	}

	public Integer getCurEstateId() {
		return curEstateId;
	}

	public void setCurEstateId(Integer curEstateId) {
		this.curEstateId = curEstateId;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getValipassword() {
		return valipassword;
	}

	public void setValipassword(String valipassword) {
		this.valipassword = valipassword;
	}

	public BusinessUserQuery(BusinessUser businessUser) {
		this.userId = businessUser.getUserId();
		this.userName = businessUser.getUserName();
		this.userTel = businessUser.getUserTel();
		this.userPassword = businessUser.getUserPassword();
		this.userCode = businessUser.getUserCode();
		this.lastLoginTime = businessUser.getLastLoginTime();
		this.userEmail = businessUser.getUserEmail();
		this.userPhoto = businessUser.getUserPhoto();
		this.userBrief = businessUser.getUserBrief();
		this.userService = businessUser.getUserService();
		this.createTime = businessUser.getCreateTime();
		this.editTime = businessUser.getEditTime();
		this.editor = businessUser.getEditor();
		this.positionId = businessUser.getPositionId();
		this.posName = businessUser.getPosName();
		this.modules = businessUser.getModules();
		this.isCharge = businessUser.getIsCharge();
		this.orgType = businessUser.getOrgType();
		this.fromAddress = businessUser.getFromAddress();
		this.homeAddress = businessUser.getHomeAddress();
		this.sex = businessUser.getSex();
		this.age = businessUser.getAge();
		this.isMarriage = businessUser.getIsMarriage();
		this.hometown = businessUser.getHometown();
		this.nation = businessUser.getNation();
		this.nickname = businessUser.getNickname();
		this.avatar = businessUser.getAvatar();
		this.isManager = businessUser.getIsManager();
		this.state = businessUser.getState();
        this.scope = businessUser.getScope();
        this.rights = businessUser.getRights();
        this.annoPic = businessUser.getAnnoPic();
        this.rightsInfo = businessUser.getRightsInfo();
        this.isGirl = businessUser.getIsGirl();
        this.orgId = businessUser.getOrgId();
        this.comWord = businessUser.getComWord();
        this.depId = businessUser.getDepId();
	}
	
	public Integer getCurUserId() {
		return curUserId;
	}

	public void setCurUserId(Integer curUserId) {
		this.curUserId = curUserId;
	}

	public Integer getDepId() {
		return depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	public String getComWord() {
		return comWord;
	}

	public void setComWord(String comWord) {
		this.comWord = comWord;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public Integer getIsGirl() {
		return isGirl;
	}

	public void setIsGirl(Integer isGirl) {
		this.isGirl = isGirl;
	}

	public String getRightsInfo() {
		return rightsInfo;
	}

	public void setRightsInfo(String rightsInfo) {
		this.rightsInfo = rightsInfo;
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

	public BusinessUserQuery() {
		
	}

    public String getAnnoPic() {
        return annoPic;
    }

    public void setAnnoPic(String annoPic) {
        this.annoPic = annoPic;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    public Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(Integer value) {
		this.userId = value;
	}
		
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String value) {
		this.userName = value;
	}
		
	public String getUserTel() {
		return this.userTel;
	}
	
	public void setUserTel(String value) {
		this.userTel = value;
	}
		
	public String getUserPassword() {
		return this.userPassword;
	}
	
	public void setUserPassword(String value) {
		this.userPassword = value;
	}
		
	public String getUserCode() {
		return this.userCode;
	}
	
	public void setUserCode(String value) {
		this.userCode = value;
	}
		
	public java.sql.Timestamp getLastLoginTime() {
		return this.lastLoginTime;
	}
	
	public void setLastLoginTime(java.sql.Timestamp value) {
		this.lastLoginTime = value;
	}
		
	public String getUserEmail() {
		return this.userEmail;
	}
	
	public void setUserEmail(String value) {
		this.userEmail = value;
	}
		
	public String getUserPhoto() {
		return this.userPhoto;
	}
	
	public void setUserPhoto(String value) {
		this.userPhoto = value;
	}
		
	public String getUserBrief() {
		return this.userBrief;
	}
	
	public void setUserBrief(String value) {
		this.userBrief = value;
	}
		
	public String getUserService() {
		return this.userService;
	}
	
	public void setUserService(String value) {
		this.userService = value;
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
		
	public Integer getPositionId() {
		return this.positionId;
	}
	
	public void setPositionId(Integer value) {
		this.positionId = value;
	}
		
	public String getPosName() {
		return this.posName;
	}
	
	public void setPosName(String value) {
		this.posName = value;
	}
		
	public String getModules() {
		return this.modules;
	}
	
	public void setModules(String value) {
		this.modules = value;
	}
		
	public Integer getIsCharge() {
		return this.isCharge;
	}
	
	public void setIsCharge(Integer value) {
		this.isCharge = value;
	}
		
	public String getOrgType() {
		return this.orgType;
	}
	
	public void setOrgType(String value) {
		this.orgType = value;
	}
		
	public String getFromAddress() {
		return this.fromAddress;
	}
	
	public void setFromAddress(String value) {
		this.fromAddress = value;
	}
		
	public String getHomeAddress() {
		return this.homeAddress;
	}
	
	public void setHomeAddress(String value) {
		this.homeAddress = value;
	}
		
	public String getSex() {
		return this.sex;
	}
	
	public void setSex(String value) {
		this.sex = value;
	}
		
	public String getAge() {
		return this.age;
	}
	
	public void setAge(String value) {
		this.age = value;
	}
		
	public String getIsMarriage() {
		return this.isMarriage;
	}
	
	public void setIsMarriage(String value) {
		this.isMarriage = value;
	}
		
	public String getHometown() {
		return this.hometown;
	}
	
	public void setHometown(String value) {
		this.hometown = value;
	}
		
	public String getNation() {
		return this.nation;
	}
	
	public void setNation(String value) {
		this.nation = value;
	}
		
	public String getNickname() {
		return this.nickname;
	}
	
	public void setNickname(String value) {
		this.nickname = value;
	}
		
	public String getAvatar() {
		return this.avatar;
	}
	
	public void setAvatar(String value) {
		this.avatar = value;
	}
		
	public Integer getIsManager() {
		return this.isManager;
	}
	
	public void setIsManager(Integer value) {
		this.isManager = value;
	}
		
	public String getState() {
		return this.state;
	}
	
	public void setState(String value) {
		this.state = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
}