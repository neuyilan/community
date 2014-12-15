package com.community.app.module.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.community.app.module.common.ModuleConst;

public class ShiroUser implements Serializable {
	private static final long serialVersionUID = -1373760761780840081L;
	private java.lang.Integer userId;
	private java.lang.String userEmail;
	private java.lang.String userName;
	private java.lang.String nickName;
	private java.lang.String userTel;
	private Integer positionId;
	private String posName;
	private String orgType;
	private Integer orgId;
	private List estateList = new ArrayList();//小区资源列表
	private List estateBeanList = new ArrayList();//简版小区列表
	private List menuList = new ArrayList();//菜单列表
	private List comList = new ArrayList();//社区列表
	private String lastLoginTime;
	private Integer curEstateId = 0; //当前小区ID，默认为0，代表没有当前小区ID
	private String curEstateName = "全部小区"; //当期小区名称
	private Integer curStateId = 0; //当前驿站ID，默认为0，代表没有当前驿站ID
	private Integer curComId = 0; //当前社区ID，默认为0，代表没有当前社区ID
	private String curComName = "全部社区"; //当前社区名称
	private String curOrgType = ""; //当前角色,这个只为运营角色切换业务时使用，通过这个属性访问相应的数据资源,如首页统计数据
	private String curOrgTypeName = ModuleConst.OPERATION_NAME; //当前部门名称
	
	public String getCurOrgTypeName() {
		return curOrgTypeName;
	}

	public void setCurOrgTypeName(String curOrgTypeName) {
		this.curOrgTypeName = curOrgTypeName;
	}

	public Integer getCurStateId() {
		return curStateId;
	}

	public void setCurStateId(Integer curStateId) {
		this.curStateId = curStateId;
	}

	public String getCurComName() {
		return curComName;
	}

	public void setCurComName(String curComName) {
		this.curComName = curComName;
	}

	public String getCurEstateName() {
		return curEstateName;
	}

	public void setCurEstateName(String curEstateName) {
		this.curEstateName = curEstateName;
	}

	public java.lang.String getNickName() {
		return nickName;
	}

	public void setNickName(java.lang.String nickName) {
		this.nickName = nickName;
	}
	
	public String getCurOrgType() {
		return curOrgType;
	}

	public void setCurOrgType(String curOrgType) {
		this.curOrgType = curOrgType;
	}

	public Integer getCurEstateId() {
		return curEstateId;
	}

	public void setCurEstateId(Integer curEstateId) {
		this.curEstateId = curEstateId;
	}

	public Integer getCurComId() {
		return curComId;
	}

	public void setCurComId(Integer curComId) {
		this.curComId = curComId;
	}

	public List getEstateBeanList() {
		return estateBeanList;
	}

	public void setEstateBeanList(List estateBeanList) {
		this.estateBeanList = estateBeanList;
	}

	public List getComList() {
		return comList;
	}

	public void setComList(List comList) {
		this.comList = comList;
	}

	public List getMenuList() {
		return menuList;
	}

	public void setMenuList(List menuList) {
		this.menuList = menuList;
	}

	public List getEstateList() {
		return estateList;
	}

	public void setEstateList(List estateList) {
		this.estateList = estateList;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public java.lang.Integer getUserId() {
		return userId;
	}

	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}

	public java.lang.String getUserName() {
		return userName;
	}

	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}

	public java.lang.String getUserTel() {
		return userTel;
	}

	public void setUserTel(java.lang.String userTel) {
		this.userTel = userTel;
	}

	public java.lang.String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(java.lang.String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * 本函数输出将作为默认的<shiro:principal/>输出.
	 */
	@Override
	public String toString() {
		//return userName;
		return this.userEmail;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * 重载hashCode,只计算loginName;
	 */
	@Override
	public int hashCode() {
		//return Objects.hashCode(loginName);
		return 0;
	}

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public String getPosName() {
		return posName;
	}

	public void setPosName(String posName) {
		this.posName = posName;
	}

}
