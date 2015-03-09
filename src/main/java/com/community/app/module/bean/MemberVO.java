package com.community.app.module.bean;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Administrator on 2014/7/17.
 * 手机端用户信息
 */
public class MemberVO {
    private Integer userId = 0;
    private Integer orgId = 0;
    private String realname = "";
    private String nickname = "";
    private String password = "";
    private Integer sex= 0;
    private Date birthday;
    private Integer type=0;
    private Integer isWorker= 0;
    private Integer state= 0;
    private String random = "";
    private java.sql.Timestamp registTime;
    private java.sql.Timestamp verifyTime;
    private String verifier = "";
    private String signature = "";
    private String portrait = "";
    private String idCard = "";
    private Integer estateId;
    private Integer isNameSecret;
    private Integer isTelSecret;
    private String workerMemo = "";
    private String weixin = "" ;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp editTime;
    private String dimensionCode = "";//二维码
    private String estateMap = "";//小区静态图
    private String buildingId = ""; //楼栋id
    private String unitId = ""; //单元id
    private String houseId = ""; //门号id;
    private String staId = ""; //所属id
    private String editor = "";
    private String realName = ""; //业主姓名
    private String tel = ""; //业主电话
    private String estateName = ""; //小区名称
    private String buildingName = ""; //楼栋名称
    private String unitName = ""; //单元
    private String houseNo = ""; //门号;
    private String oftenestate = ""; //常用小区
    private String boundphone = ""; //绑定手机
    private String staName = ""; //所属驿站

    private String userName = ""; //员工姓名
    private String userEmail = ""; //员工邮箱
    private String userTel = "";   //员工电话
    private String userPhoto = ""; //员工照片
    private String userBrief = ""; //员工个人介绍
    private String avatar = "";    //员工头像
    private Integer isManager;  //是否物业管家
    private String orgType = "";     //昵称
    private String modules = "";     //模块ID集合
    private String posName = "";     //职位名称
    private String lastLoginTime = "";  //最近登录时间
    private String depName = "";      //部门名称
    private String comName;           //社区名称
    private String comId;			  //社区id
    private String proId;			  //物业id
    private String proName;			  //物业名称
    private String homeAttr;		  //家庭位置
    private String unitHomeAttr;	//家庭位置
    private Integer familyId;         //家庭id
    private Integer mount;            //家庭成员数量
    private Integer helpSwitch;            //邻里求助通知
    private Integer marketSwitch;            //二手市场通知
    private Integer serviceSwitch;            //系统通知
    private Integer expressSwitch;            //快递通知
    private Integer brokeSwitch;            //爆料通知
    private Integer weatherSwitch;            //天气通知
    private Integer limitSwitch;            //限行通知
    private String baiduId;			  
    private String channelId;		  
    private Integer deviceType;
    private String remarks;
    
    private Integer isDoor;//驿站是否支持预约上门
    private String estateLongitude;//小区经度
    private String estateLatitude;//小区纬度
    
    private Integer isQNH;            //0不是青年汇用户1是青年汇用户
    private Integer age;            //年龄
    
    
    public Integer getIsQNH() {
		return isQNH;
	}

	public void setIsQNH(Integer isQNH) {
		this.isQNH = isQNH;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getIsDoor() {
		return isDoor;
	}

	public void setIsDoor(Integer isDoor) {
		this.isDoor = isDoor;
	}

	public String getEstateLongitude() {
		return estateLongitude;
	}

	public void setEstateLongitude(String estateLongitude) {
		this.estateLongitude = estateLongitude;
	}

	public String getEstateLatitude() {
		return estateLatitude;
	}

	public void setEstateLatitude(String estateLatitude) {
		this.estateLatitude = estateLatitude;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getUnitHomeAttr() {
		return unitHomeAttr;
	}

	public void setUnitHomeAttr(String unitHomeAttr) {
		this.unitHomeAttr = unitHomeAttr;
	}

	public Integer getLimitSwitch() {
		return limitSwitch;
	}

	public void setLimitSwitch(Integer limitSwitch) {
		this.limitSwitch = limitSwitch;
	}

	public Integer getWeatherSwitch() {
		return weatherSwitch;
	}

	public void setWeatherSwitch(Integer weatherSwitch) {
		this.weatherSwitch = weatherSwitch;
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

	public Integer getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}

	public Integer getServiceSwitch() {
		return serviceSwitch;
	}

	public void setServiceSwitch(Integer serviceSwitch) {
		this.serviceSwitch = serviceSwitch;
	}

	public Integer getExpressSwitch() {
		return expressSwitch;
	}

	public void setExpressSwitch(Integer expressSwitch) {
		this.expressSwitch = expressSwitch;
	}

	public Integer getBrokeSwitch() {
		return brokeSwitch;
	}

	public void setBrokeSwitch(Integer brokeSwitch) {
		this.brokeSwitch = brokeSwitch;
	}

	private String address;
    
    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getHelpSwitch() {
		return helpSwitch;
	}

	public void setHelpSwitch(Integer helpSwitch) {
		this.helpSwitch = helpSwitch;
	}

	public Integer getMarketSwitch() {
		return marketSwitch;
	}

	public void setMarketSwitch(Integer marketSwitch) {
		this.marketSwitch = marketSwitch;
	}

	public Integer getFamilyId() {
		return familyId;
	}

	public void setFamilyId(Integer familyId) {
		this.familyId = familyId;
	}

	public Integer getMount() {
		return mount;
	}

	public void setMount(Integer mount) {
		this.mount = mount;
	}

	public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUserBrief() {
        return userBrief;
    }

    public void setUserBrief(String userBrief) {
        this.userBrief = userBrief;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getIsManager() {
        return isManager;
    }

    public void setIsManager(Integer isManager) {
        this.isManager = isManager;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getModules() {
        return modules;
    }

    public void setModules(String modules) {
        this.modules = modules;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getStaName() {
        return staName;
    }

    public void setStaName(String staName) {
        this.staName = staName;
    }

    public String getOftenestate() {
        return oftenestate;
    }

    public void setOftenestate(String oftenestate) {
        this.oftenestate = oftenestate;
    }

    public String getBoundphone() {
        return boundphone;
    }

    public void setBoundphone(String boundphone) {
        this.boundphone = boundphone;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsWorker() {
        return isWorker;
    }

    public void setIsWorker(Integer isWorker) {
        this.isWorker = isWorker;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }

    public Timestamp getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Timestamp registTime) {
        this.registTime = registTime;
    }

    public Timestamp getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(Timestamp verifyTime) {
        this.verifyTime = verifyTime;
    }

    public String getVerifier() {
        return verifier;
    }

    public void setVerifier(String verifier) {
        this.verifier = verifier;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
    }

    public Integer getIsNameSecret() {
        return isNameSecret;
    }

    public void setIsNameSecret(Integer isNameSecret) {
        this.isNameSecret = isNameSecret;
    }

    public Integer getIsTelSecret() {
        return isTelSecret;
    }

    public void setIsTelSecret(Integer isTelSecret) {
        this.isTelSecret = isTelSecret;
    }

    public String getWorkerMemo() {
        return workerMemo;
    }

    public void setWorkerMemo(String workerMemo) {
        this.workerMemo = workerMemo;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getEditTime() {
        return editTime;
    }

    public void setEditTime(Timestamp editTime) {
        this.editTime = editTime;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
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

    public String getEstateName() {
        return estateName;
    }

    public void setEstateName(String estateName) {
        this.estateName = estateName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

	public String getDimensionCode() {
		return dimensionCode;
	}

	public void setDimensionCode(String dimensionCode) {
		this.dimensionCode = dimensionCode;
	}

	public String getEstateMap() {
		return estateMap;
	}

	public void setEstateMap(String estateMap) {
		this.estateMap = estateMap;
	}

	public String getStaId() {
		return staId;
	}

	public void setStaId(String staId) {
		this.staId = staId;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getComId() {
		return comId;
	}

	public void setComId(String comId) {
		this.comId = comId;
	}

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getHomeAttr() {
		return homeAttr;
	}

	public void setHomeAttr(String homeAttr) {
		this.homeAttr = homeAttr;
	}

	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}
	
    
}
