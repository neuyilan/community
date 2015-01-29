package com.community.service.ambitus;






/**
 * 小区周边相关处理接口
 * 包括：
 * 用户信息
 * 
 * @author whh-2_000
 *
 */

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.vo.BaseBean;


import com.community.app.module.vo.BusinessBusQuery;
import com.community.app.module.vo.BusinessBusStationQuery;
import com.community.app.module.vo.BusinessLifePropQuery;
import com.community.app.module.vo.BusinessTelQuery;
import com.community.app.module.vo.ManageEstateQuery;
import com.community.app.module.bean.AppStatisticsClick;
import com.community.app.module.bean.BusinessAnno;
import com.community.app.module.bean.BusinessLifeProp;
import com.community.app.module.bean.BusinessTel;
import com.community.app.module.bean.BusinessTelGroup;
import com.community.app.module.dao.BusinessLifePropDao;
import com.community.app.module.service.AppStatisticsClickService;
import com.community.app.module.service.BusinessAnnoService;
import com.community.app.module.service.BusinessBusService;
import com.community.app.module.service.BusinessBusStationService;
import com.community.app.module.service.ManageEstateService;
import com.community.app.module.vo.BusinessAnnoQuery;
import com.community.framework.utils.FileUtil;
import com.community.framework.utils.propertiesUtil;


@Controller
@RequestMapping("/service/ambitus")
public class ambitusController {
	private static Logger GSLogger = LoggerFactory.getLogger(ambitusController.class);
	@Autowired
	private ManageEstateService manageEstateService;
	@Autowired
	private BusinessBusStationService businessBusStationService;
	@Autowired
	private BusinessBusService businessBusService;
	@Autowired
	private BusinessLifePropDao businessLifePropDao;
	@Autowired
	private AppStatisticsClickService appStatisticsClickService;
	
	
	
	/**
	 * 用户查看小区周边
	 * @param userId,sessionid
	 * @return
	 * json
	 */
	@RequestMapping(value="findByEstate")
	public void findByUser(HttpServletRequest request, HttpServletResponse response,ManageEstateQuery query) {
		String json = "";
		try {
			if(!"40005".equals(query.getServiceCode())){
				List<ManageEstateQuery> groupList = manageEstateService.findByEstateAmbitus(query);
				if(groupList.size()==0){
					json += "{";
					json += "\"errorCode\":\"200\",";
					json += "\"message\":\"获取成功\",";
					json += "\"content\":{";
					json += "\"PageState\":false,";
					json += "\"list\":[";
					json += "]";
					json += "}";
					json += "}";
				}else{
					json += "{";
					json += "\"errorCode\":\"200\",";
					json += "\"message\":\"获取成功\",";
					json += "\"content\":{";
					if(groupList!=null){
						json += "\"estateLongitude\":\""+groupList.get(0).getEstateLongitude()+"\",";
						json += "\"estateLatitude\":\""+groupList.get(0).getEstateLatitude()+"\",";
					}
					json += "\"PageState\":true,";
					json += "\"list\":[";
					for (ManageEstateQuery manageEstateQuery : groupList) {
						BusinessLifePropQuery BusinessLifePropQuery = new BusinessLifePropQuery();
						BusinessLifePropQuery.setServiceId(manageEstateQuery.getServiceId());
						List<BusinessLifeProp> lifeList = businessLifePropDao.findByExample(BusinessLifePropQuery);
						json += "{\"ID\":\""+manageEstateQuery.getServiceId()+"\",\"title\":\""+manageEstateQuery.getServiceName()+"\",";
						json += "\"Address\":\""+manageEstateQuery.getAddress()+"\",\"tel\":\""+manageEstateQuery.getTel()+"\",";
						json += "\"comLongitude\":\""+manageEstateQuery.getBusLongitude()+"\",\"comLatitude\":\""+manageEstateQuery.getBusLatitude()+"\",";
						int distance = (int) Math.floor(FileUtil.gps2m(manageEstateQuery.getEstateLongitude(),manageEstateQuery.getEstateLatitude(),manageEstateQuery.getBusLongitude(),manageEstateQuery.getBusLatitude()));
						json += "\"distance\":\""+distance+"\",";
						json +="\"attribute\":[";
						for (BusinessLifeProp BusinessLifeProp : lifeList) {
							if(BusinessLifeProp.getPropValue().indexOf("http://")>=0){
								json += "{\"key\":\""+BusinessLifeProp.getPropName()+"\",\"value\":\""+BusinessLifeProp.getPropValue()+"\",\"type\":\"2\"},";
							}else{
								json += "{\"key\":\""+BusinessLifeProp.getPropName()+"\",\"value\":\""+BusinessLifeProp.getPropValue()+"\",\"type\":\"1\"},";
							}
							
						}
						if(lifeList.size() > 0) {
							json = json.substring(0, json.length()-1);
						}
						json += "]";
						json += "},";
					}
					if(groupList.size() > 0) {
						json = json.substring(0, json.length()-1);
					}
					json += "]";
					json += "}";
					json += "}";
				}
				
			}else{
				List<ManageEstateQuery> groupList = manageEstateService.findByEstateBus(query.getEstateId());
				if(groupList.size()==0){
					json += "{";
					json += "\"errorCode\":\"200\",";
					json += "\"message\":\"获取成功\",";
					json += "\"content\":{";
					json += "\"PageState\":false,";
					json += "\"list\":[";
					json += "]";
					json += "}";
					json += "}";
				}else{
					json += "{";
					json += "\"errorCode\":\"200\",";
					json += "\"message\":\"获取成功\",";
					json += "\"content\":{";
					if(groupList!=null){
						json += "\"estateLongitude\":\""+groupList.get(0).getEstateLongitude()+"\",";
						json += "\"estateLatitude\":\""+groupList.get(0).getEstateLatitude()+"\",";
					}
					json += "\"PageState\":true,";
					json += "\"list\":[";
					for (ManageEstateQuery manageEstateQuery : groupList) {
						List<BusinessBusStationQuery> busList = businessBusStationService.findStaBus(manageEstateQuery.getStationId());
						json += "{\"ID\":\""+manageEstateQuery.getStationId()+"\",\"title\":\""+manageEstateQuery.getStationName()+"\",";
						json += "\"comLongitude\":\""+manageEstateQuery.getBusLongitude()+"\",\"comLatitude\":\""+manageEstateQuery.getBusLatitude()+"\",";
						int distance = (int) Math.floor(FileUtil.gps2m(manageEstateQuery.getEstateLongitude(),manageEstateQuery.getEstateLatitude(),manageEstateQuery.getBusLongitude(),manageEstateQuery.getBusLatitude()));
						json += "\"distance\":\""+distance+"\",";
						json +="\"attribute\":[";
						for (BusinessBusStationQuery businessBusStationQuery : busList) {
							json += "{\"name\":\""+businessBusStationQuery.getBusName()+"\",\"ID\":\""+businessBusStationQuery.getBusId()+"\"},";
						}
						if(busList.size() > 0) {
							json = json.substring(0, json.length()-1);
						}
						json += "]";
						json += "},";
					}
					if(groupList.size() > 0) {
						json = json.substring(0, json.length()-1);
					}
					json += "]";
					json += "}";
					json += "}";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"获取失败\"";
			json += "}";
		}
		
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json.replace("\n", "\\n\\r").replace("\n\r", "\\n\\r"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			if(null==query.getUserId()){
				appStatisticsClick.setUserId(0);
			}else{
				appStatisticsClick.setUserId(query.getUserId());
			}
			appStatisticsClick.setType(43);
			appStatisticsClick.setTypeName("小区周边列表");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看公交线路详情
	 * @param userId,sessionid
	 * @return
	 * json
	 */
	@RequestMapping(value="busLineDetails")
	public void busLineDetails(HttpServletRequest request, HttpServletResponse response,ManageEstateQuery query) {
		String json = "";
		try {
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			List<BusinessBusQuery> groupList = businessBusService.busLineDetails(query.getID());
			json += "\"busName\":\""+groupList.get(0).getBusName()+"\",";
			json += "\"arr\":[";
			for (BusinessBusQuery businessBusQuery : groupList) {
				if("0".equals(businessBusQuery.getType())){
					json += "{\"startTime\":\""+businessBusQuery.getStarTime()+"\",";
					json += "\"endTime\":\""+businessBusQuery.getEndTime()+"\",";
					json += "\"start\":\""+businessBusQuery.getStarName()+"\",";
					json += "\"end\":\""+businessBusQuery.getEndName()+"\",";
					json += "\"count\":\""+businessBusQuery.getCount()+"\",";
					break;
				}
			}
			json += "\"list\":[";
			for (BusinessBusQuery businessBusQuery : groupList) {
				if("0".equals(businessBusQuery.getType())){
					json += "{\"name\":\""+businessBusQuery.getBusStopName()+"\"},";
				}
			}
			if(groupList.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]";
			json += "},";
			for (BusinessBusQuery businessBusQuery : groupList) {
				if("1".equals(businessBusQuery.getType())){
					json += "{\"startTime\":\""+businessBusQuery.getStarTime()+"\",";
					json += "\"endTime\":\""+businessBusQuery.getEndTime()+"\",";
					json += "\"start\":\""+businessBusQuery.getStarName()+"\",";
					json += "\"end\":\""+businessBusQuery.getEndName()+"\",";
					json += "\"count\":\""+businessBusQuery.getCount()+"\",";
					break;
				}
			}
			json += "\"list\":[";
			for (BusinessBusQuery businessBusQuery : groupList) {
				if("1".equals(businessBusQuery.getType())){
					json += "{\"name\":\""+businessBusQuery.getBusStopName()+"\"},";
				}
			}
			if(groupList.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]";
			json += "}";
			json += "]";
			json += "}";
			json += "}";
		} catch (Exception e) {
			e.printStackTrace();
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"获取失败\"";
			json += "}";
		}
		
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json.replace("\n", "\\n\\r").replace("\n\r", "\\n\\r"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看地铁图片详情
	 * @param userId,sessionid
	 * @return
	 * json
	 */
	@RequestMapping(value="getbeijingdt")
	public void getbeijingdt(HttpServletRequest request, HttpServletResponse response,ManageEstateQuery query) {
		String json = "";
		try {
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"pic\":\""+ip+"/images/icon/beijingdt.jpg\"";
			json += "}";
			json += "}";
		} catch (Exception e) {
			e.printStackTrace();
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"获取失败\"";
			json += "}";
		}
		
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json.replace("\n", "\\n\\r").replace("\n\r", "\\n\\r"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
