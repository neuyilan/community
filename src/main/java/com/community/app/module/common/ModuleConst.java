package com.community.app.module.common;

/**
 * 对应数据库中的manage_module中的4条记录，数据库发生主键变化，即修改这里
 * @author zyp-2_000
 *
 */
public class ModuleConst {

	public static Integer COMMUNITY = 1; // 社区模块
	public static String COMMUNITY_CODE = "community"; // 社区模块编码
	public static String COMMUNITY_NAME = "社区管理"; // 社区模块编码
	
	public static Integer PROPERTY = 2; // 物业模块
	public static String PROPERTY_CODE = "property"; // 物业模块编码
	public static String PROPERTY_NAME = "物业管理"; // 物业模块编码
	
	public static Integer STATION = 3; // 驿站模块
	public static String STATION_CODE = "station"; // 驿站模块编码
	public static String STATION_NAME = "驿站管理"; // 驿站模块编码
	
	public static Integer OPERATION = 4; // 运营模块
	public static String OPERATION_CODE = "operation"; // 运营模块编码
	public static String OPERATION_NAME = "运营管理"; // 运营模块编码
	
	/**
	 * 按ID查找对应的模块编码
	 * @param moduleId
	 * @return
	 */
	public static String getModuleCode(Integer moduleId) {
		String code = "";
		switch (moduleId) {
			case 1:
				code = ModuleConst.COMMUNITY_CODE;// 社区模块编码
				break;
			case 2:
				code = ModuleConst.PROPERTY_CODE;// 物业模块编码
				break;
			case 3:
				code = ModuleConst.STATION_CODE;// 驿站模块编码
				break;	
			default: 
				code = ModuleConst.OPERATION_CODE;// 运营模块编码
		}
		return code;
	}
	
	/**
	 * 按编码查询模块ID
	 * @param moduleCode
	 * @return
	 */
	public static Integer getModuleId(String moduleCode) {
		Integer id = 0;
		if(moduleCode.equals(ModuleConst.COMMUNITY_CODE)) {// 社区模块ID
			id = ModuleConst.COMMUNITY;
		}else if(moduleCode.equals(ModuleConst.PROPERTY_CODE)) {// 物业模块ID
			id = ModuleConst.PROPERTY;
		}else if(moduleCode.equals(ModuleConst.STATION_CODE)) {// 驿站模块ID
			id = ModuleConst.STATION;
		}else{// 运营模块ID
			id = ModuleConst.OPERATION;
		}
		return id;
	}
	
}
