package com.community.app.module.common;

import java.io.Serializable;

public class StationBean implements Serializable {
	
	private Integer stationId; //驿站ID
	private String stationName; //驿站名称
	
	public Integer getStationId() {
		return stationId;
	}
	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	
	

}
