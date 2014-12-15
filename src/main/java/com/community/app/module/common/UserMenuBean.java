package com.community.app.module.common;

import java.io.Serializable;

public class UserMenuBean  implements Serializable, Comparable<UserMenuBean> {

	private Integer menuId; //菜单ID
	private String menuName; //菜单名称
	private String menuPath; //菜单地址
	private Integer no; // 序号
	private String icon; // 菜单图标css
	
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuPath() {
		return menuPath;
	}
	public void setMenuPath(String menuPath) {
		this.menuPath = menuPath;
	}
	public int compareTo(UserMenuBean o) {
		return this.getNo().compareTo(o.getNo());
	}
	
	
}
