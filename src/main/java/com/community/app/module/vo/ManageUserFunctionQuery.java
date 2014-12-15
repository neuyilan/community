package com.community.app.module.vo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import com.community.app.module.bean.ManageUserFunction;
import com.community.app.module.vo.BaseBean;

public class ManageUserFunctionQuery extends BaseBean {
	

	private java.lang.Integer userAuthId;
	private java.lang.Integer functionId;
	private java.lang.Integer userId;
	private java.lang.String functionName;
	private java.lang.Integer menuId;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private java.lang.String editor;
	private java.lang.Integer moduleId;
    private String moduleCode;
	public ManageUserFunctionQuery(ManageUserFunction manageUserFunction) {
		this.userAuthId = manageUserFunction.getUserAuthId();
		this.functionId = manageUserFunction.getFunctionId();
		this.userId = manageUserFunction.getUserId();
		this.functionName = manageUserFunction.getFunctionName();
		this.menuId = manageUserFunction.getMenuId();
		this.createTime = manageUserFunction.getCreateTime();
		this.editTime = manageUserFunction.getEditTime();
		this.editor = manageUserFunction.getEditor();
		this.moduleId = manageUserFunction.getModuleId();
	}
	
	public ManageUserFunctionQuery() {
		
	}

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public java.lang.Integer getUserAuthId() {
		return this.userAuthId;
	}
	
	public void setUserAuthId(java.lang.Integer value) {
		this.userAuthId = value;
	}
		
	public java.lang.Integer getFunctionId() {
		return this.functionId;
	}
	
	public void setFunctionId(java.lang.Integer value) {
		this.functionId = value;
	}
		
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
		
	public java.lang.String getFunctionName() {
		return this.functionName;
	}
	
	public void setFunctionName(java.lang.String value) {
		this.functionName = value;
	}
		
	public java.lang.Integer getMenuId() {
		return this.menuId;
	}
	
	public void setMenuId(java.lang.Integer value) {
		this.menuId = value;
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
		
	public java.lang.String getEditor() {
		return this.editor;
	}
	
	public void setEditor(java.lang.String value) {
		this.editor = value;
	}
		
	public java.lang.Integer getModuleId() {
		return this.moduleId;
	}
	
	public void setModuleId(java.lang.Integer value) {
		this.moduleId = value;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

