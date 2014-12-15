package com.community.app.module.common;

import java.io.Serializable;

public class EstateBean implements Serializable {
	
	private Integer estateId; //小区ID
	private String estateName; //小区名称
	public Integer getEstateId() {
		return estateId;
	}
	public void setEstateId(Integer estateId) {
		this.estateId = estateId;
	}
	public String getEstateName() {
		return estateName;
	}
	public void setEstateName(String estateName) {
		this.estateName = estateName;
	}
	
	

}
