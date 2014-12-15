package com.community.app.module.common;

import java.io.Serializable;

public class CommunityBean implements Serializable {

	private Integer comId; //社区ID
	private String comName; //社区名称
	public Integer getComId() {
		return comId;
	}
	public void setComId(Integer comId) {
		this.comId = comId;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	
	
	
}
