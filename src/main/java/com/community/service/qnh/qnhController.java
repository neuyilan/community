package com.community.service.qnh;






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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.community.app.module.bean.AppStatisticsClick;
import com.community.app.module.bean.BusinessLife;
import com.community.app.module.bean.BusinessLifeProp;
import com.community.app.module.dao.BusinessLifeDao;
import com.community.app.module.dao.BusinessLifePropDao;
import com.community.app.module.service.AppStatisticsClickService;
import com.community.app.module.service.BusinessBusService;
import com.community.app.module.service.BusinessBusStationService;
import com.community.app.module.service.ManageEstateService;
import com.community.app.module.vo.BusinessBusQuery;
import com.community.app.module.vo.BusinessBusStationQuery;
import com.community.app.module.vo.BusinessLifePropQuery;
import com.community.app.module.vo.BusinessLifeQuery;
import com.community.app.module.vo.ManageEstateQuery;
import com.community.framework.utils.FileUtil;
import com.community.framework.utils.JsonUtils;
import com.community.framework.utils.propertiesUtil;


@Controller
@RequestMapping("/service/qnh")
public class qnhController {
	private static Logger GSLogger = LoggerFactory.getLogger(qnhController.class);

	
	
	
	/**
	 * 用户查看小区周边
	 * @param userId,sessionid
	 * @return
	 * json
	 */
	@RequestMapping(value="getQNHList")
	public void findByUser(HttpServletRequest request, HttpServletResponse response,ManageEstateQuery query) {
		String json = "";
		try {
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"count\":\"2\",";
			json += "\"list\":[";
			json += "{";
			json +=	"\"activities\":{\"ID\":\"28\",\"title\":\"文艺·尚汇，邀青年一起品味艺术人生\",\"time\":\"2015-3-4\",\"brief\":\"社区青年汇的服务对象既包括户籍青年，也包括流动青年，并注重不同青年群体之间的交流。针对青年成长需求，青年汇开展三类工作：提供包括学习培训、城市融入、交友联谊、志愿服务、文化艺术、体育比赛六项全市统一活动；支持各青年汇结合自身所服务青年的特点，开展创新性特色活动。\",\"pic\":\"/images.jpg\",\"state\":\"1\",\"startTime\":\"2014-1-1\",\"endTime\":\"2014-1-1\"},";
			json += "\"name\":\"青年汇\",";
			json += "\"addr\":\"朝阳区武胜路128号东塔2号楼103\",";
			json += "\"longitude\":\"116.522639\",";
			json += "\"latitude\":\"39.930924\",";
			json += "\"brief\":\"社区青年汇的服务对象既包括户籍青年，也包括流动青年，并注重不同青年群体之间的交流。针对青年成长需求，青年汇开展三类工作：提供包括学习培训、城市融入、交友联谊、志愿服务、文化艺术、体育比赛六项全市统一活动；支持各青年汇结合自身所服务青年的特点，开展创新性特色活动。\",";
			json += "\"staff\":[{\"name\":\"张三\",\"brief\":\"社区青年汇，您温暖的港湾！\",\"tel\":\"110\",\"avatar\":\"110.jpg\"},{\"name\":\"张三\",\"brief\":\"社区青年汇，您温暖的港湾！\",\"tel\":\"110\",\"avatar\":\"110.jpg\"}]";
			json += "},";
			json += "{";
			json +=	"\"activities\":{\"ID\":\"28\",\"title\":\"文艺·尚汇，邀青年一起品味艺术人生\",\"time\":\"2015-3-4\",\"brief\":\"社区青年汇的服务对象既包括户籍青年，也包括流动青年，并注重不同青年群体之间的交流。针对青年成长需求，青年汇开展三类工作：提供包括学习培训、城市融入、交友联谊、志愿服务、文化艺术、体育比赛六项全市统一活动；支持各青年汇结合自身所服务青年的特点，开展创新性特色活动。\",\"pic\":\"/images.jpg\",\"state\":\"1\",\"startTime\":\"2014-1-1\",\"endTime\":\"2014-1-1\"},";
			json += "\"name\":\"青年汇\",";
			json += "\"addr\":\"朝阳区武胜路128号东塔2号楼103\",";
			json += "\"longitude\":\"116.49308\",";
			json += "\"latitude\":\"39.913577\",";
			json += "\"brief\":\"社区青年汇的服务对象既包括户籍青年，也包括流动青年，并注重不同青年群体之间的交流。针对青年成长需求，青年汇开展三类工作：提供包括学习培训、城市融入、交友联谊、志愿服务、文化艺术、体育比赛六项全市统一活动；支持各青年汇结合自身所服务青年的特点，开展创新性特色活动。\",";
			json += "\"staff\":[{\"name\":\"张三\",\"brief\":\"社区青年汇，您温暖的港湾！\",\"tel\":\"110\",\"avatar\":\"110.jpg\"},{\"name\":\"张三\",\"brief\":\"社区青年汇，您温暖的港湾！\",\"tel\":\"110\",\"avatar\":\"110.jpg\"}]";
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
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try{
//			Timestamp  ts=new Timestamp(new Date().getTime());
//			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
//			appStatisticsClick.setCreateTime(ts);
//			appStatisticsClick.setEditTime(ts);
//			if(null==query.getUserId()){
//				appStatisticsClick.setUserId(0);
//			}else{
//				appStatisticsClick.setUserId(query.getUserId());
//			}
//			appStatisticsClick.setType(43);
//			appStatisticsClick.setTypeName("小区周边列表");
//			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
