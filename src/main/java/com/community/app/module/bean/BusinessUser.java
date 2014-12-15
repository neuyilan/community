package com.community.app.module.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class BusinessUser implements java.io.Serializable{

    //别名
    public static final String TABLE_ALIAS = "BusinessUser";

    private java.lang.Integer userId;
    private java.lang.String userName;
    private java.lang.String userTel;
    private java.lang.String userPassword;
    private java.lang.String userCode;
    private java.sql.Timestamp lastLoginTime;
    private java.lang.String userEmail;
    private java.lang.String userPhoto;
    private java.lang.String userBrief;
    private java.lang.String userService;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp editTime;
    private java.lang.String editor;
    private java.lang.Integer positionId;
    private java.lang.String posName;
    private java.lang.String modules;
    private Integer isCharge;
    private java.lang.String orgType;
    private java.lang.String fromAddress;
    private java.lang.String homeAddress;
    private java.lang.String sex;
    private java.lang.String age;
    private java.lang.String isMarriage;
    private java.lang.String hometown;
    private java.lang.String nation;
    private java.lang.String nickname;
    private java.lang.String avatar;
    private java.lang.Integer isManager;
    private java.lang.String state;
    private String scope;
    private String rights;
    private String annoPic;
    private String stationtel;
    private String stationName;
    
    private Integer count;
    private String sql;
    private String rightsInfo;
    
    private Integer isGirl;
    private Integer orgId;
    private String comWord;
    private Integer depId;
    private String depName;

    public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
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

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getStationName() {
		return stationName == null?"":stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getStationtel() {
		return stationtel == null?"":stationtel;
	}

	public void setStationtel(String stationtel) {
		this.stationtel = stationtel;
	}

	public BusinessUser(){
    }

    public BusinessUser(
            java.lang.Integer userId
    ){
        this.userId = userId;
    }

    public String getAnnoPic() {
        return annoPic == null?"":annoPic;
    }

    public void setAnnoPic(String annoPic) {
        this.annoPic = annoPic;
    }

    public String getScope() {
        return scope == null?"":scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getRights() {
        return rights == null?"":rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    public void setUserId(java.lang.Integer value) {
        this.userId = value;
    }

    public java.lang.Integer getUserId() {
        return this.userId;
    }
    public void setUserName(java.lang.String value) {
        this.userName = value;
    }

    public java.lang.String getUserName() {
        return this.userName == null?"":this.userName;
    }
    public void setUserTel(java.lang.String value) {
        this.userTel = value;
    }

    public java.lang.String getUserTel() {
        return this.userTel == null?"":this.userTel;
    }
    public void setUserPassword(java.lang.String value) {
        this.userPassword = value;
    }

    public java.lang.String getUserPassword() {
        return this.userPassword == null?"":this.userPassword;
    }
    public void setUserCode(java.lang.String value) {
        this.userCode = value;
    }

    public java.lang.String getUserCode() {
        return this.userCode == null?"":this.userCode;
    }
    public void setLastLoginTime(java.sql.Timestamp value) {
        this.lastLoginTime = value;
    }

    public java.sql.Timestamp getLastLoginTime() {
        return this.lastLoginTime;
    }
    public void setUserEmail(java.lang.String value) {
        this.userEmail = value;
    }

    public java.lang.String getUserEmail() {
        return this.userEmail == null?"":this.userEmail;
    }
    public void setUserPhoto(java.lang.String value) {
        this.userPhoto = value;
    }

    public java.lang.String getUserPhoto() {
        return this.userPhoto == null?"":this.userPhoto;
    }
    public void setUserBrief(java.lang.String value) {
        this.userBrief = value;
    }

    public java.lang.String getUserBrief() {
        return this.userBrief == null?"":this.userBrief;
    }
    public void setUserService(java.lang.String value) {
        this.userService = value;
    }

    public java.lang.String getUserService() {
        return this.userService == null?"":this.userService;
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
    public void setEditor(java.lang.String value) {
        this.editor = value;
    }

    public java.lang.String getEditor() {
        return this.editor == null?"":this.editor;
    }
    public void setPositionId(java.lang.Integer value) {
        this.positionId = value;
    }

    public java.lang.Integer getPositionId() {
        return this.positionId;
    }
    public void setPosName(java.lang.String value) {
        this.posName = value;
    }

    public java.lang.String getPosName() {
        return this.posName == null?"":this.posName;
    }
    public void setModules(java.lang.String value) {
        this.modules = value;
    }

    public java.lang.String getModules() {
        return this.modules == null?"":this.modules;
    }
    public void setIsCharge(Integer value) {
        this.isCharge = value;
    }

    public Integer getIsCharge() {
        return this.isCharge;
    }
    public void setOrgType(java.lang.String value) {
        this.orgType = value;
    }

    public java.lang.String getOrgType() {
        return this.orgType == null?"":this.orgType;
    }
    public void setFromAddress(java.lang.String value) {
        this.fromAddress = value;
    }

    public java.lang.String getFromAddress() {
        return this.fromAddress == null?"":this.fromAddress;
    }
    public void setHomeAddress(java.lang.String value) {
        this.homeAddress = value;
    }

    public java.lang.String getHomeAddress() {
        return this.homeAddress == null?"":this.homeAddress;
    }
    public void setSex(java.lang.String value) {
        this.sex = value;
    }

    public java.lang.String getSex() {
        return this.sex == null?"":this.sex;
    }
    public void setAge(java.lang.String value) {
        this.age = value;
    }

    public java.lang.String getAge() {
        return this.age;
    }
    public void setIsMarriage(java.lang.String value) {
        this.isMarriage = value;
    }

    public java.lang.String getIsMarriage() {
        return this.isMarriage == null?"":this.isMarriage;
    }
    public void setHometown(java.lang.String value) {
        this.hometown = value;
    }

    public java.lang.String getHometown() {
        return this.hometown == null?"":this.hometown;
    }
    public void setNation(java.lang.String value) {
        this.nation = value;
    }

    public java.lang.String getNation() {
        return this.nation == null?"":this.nation;
    }
    public void setNickname(java.lang.String value) {
        this.nickname = value;
    }

    public java.lang.String getNickname() {
        return this.nickname == null?"":this.nickname;
    }
    public void setAvatar(java.lang.String value) {
        this.avatar = value;
    }

    public java.lang.String getAvatar() {
        return this.avatar == null?"":this.avatar;
    }
    public void setIsManager(java.lang.Integer value) {
        this.isManager = value;
    }

    public java.lang.Integer getIsManager() {
        return this.isManager;
    }
    public void setState(java.lang.String value) {
        this.state = value;
    }

    public java.lang.String getState() {
        return this.state == null?"":this.state;
    }

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("UserId",getUserId())
                .append("UserName",getUserName())
                .append("UserTel",getUserTel())
                .append("UserPassword",getUserPassword())
                .append("UserCode",getUserCode())
                .append("LastLoginTime",getLastLoginTime())
                .append("UserEmail",getUserEmail())
                .append("UserPhoto",getUserPhoto())
                .append("UserBrief",getUserBrief())
                .append("UserService",getUserService())
                .append("CreateTime",getCreateTime())
                .append("EditTime",getEditTime())
                .append("Editor",getEditor())
                .append("PositionId",getPositionId())
                .append("PosName",getPosName())
                .append("Modules",getModules())
                .append("IsCharge",getIsCharge())
                .append("OrgType",getOrgType())
                .append("FromAddress",getFromAddress())
                .append("HomeAddress",getHomeAddress())
                .append("Sex",getSex())
                .append("Age",getAge())
                .append("IsMarriage",getIsMarriage())
                .append("Hometown",getHometown())
                .append("Nation",getNation())
                .append("Nickname",getNickname())
                .append("Avatar",getAvatar())
                .append("IsManager",getIsManager())
                .append("State",getState())
                .toString();
    }

    public int hashCode() {
        return new HashCodeBuilder()
                .append(getUserId())
                .toHashCode();
    }

    public boolean equals(Object obj) {
        if(obj instanceof BusinessUser == false) return false;
        if(this == obj) return true;
        BusinessUser other = (BusinessUser)obj;
        return new EqualsBuilder()
                .append(getUserId(),other.getUserId())
                .isEquals();
    }
}