package com.community.app.module.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.community.app.module.bean.MemberVO;
import com.community.app.module.service.AppUserService;
import com.community.app.module.service.BusinessUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.community.app.module.vo.BaseBean;

import com.community.app.module.bean.BusinessUserPropertyCom;
import com.community.app.module.service.BusinessUserPropertyComService;
import com.community.app.module.vo.BusinessUserPropertyComQuery;
import com.community.framework.utils.CommonUtils;

import static com.community.framework.utils.CommonUtils.getUser;

@Controller
@RequestMapping("/business/businessUserPropertyCom")
public class BusinessUserPropertyComController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessUserPropertyComController.class);
	@Autowired
	private BusinessUserPropertyComService businessUserPropertyComService;
    @Autowired
	private AppUserService appUserService;
    @Autowired
	private BusinessUserService businessUserService;
	
	/**
	 * 进入互动交流页面
	 * @return
	 */
	@RequestMapping(value="getChatInfo")
	public ModelAndView getChatInfo(BusinessUserPropertyComQuery query) {
        List list = new ArrayList();
        MemberVO obj = new MemberVO();
        MemberVO worker = new MemberVO();
        try{
            //管理员ID
            int managerId = CommonUtils.getUser().getUserId();
            query.setManagerId(managerId);
            //互动记录
            list = businessUserPropertyComService.getChatInfo(query);
            //获取居民的基本信息
            obj = appUserService.getAppUserInfo(query.getUserId());
            //获取员工的基本信息
            worker = businessUserService.getWorkerInfo(managerId);
		}catch(Exception e){
			GSLogger.error("进入businessUserPropertyCom互动交流页面时发生错误：/business/businessUserPropertyCom/getChatInfo", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/appUser/chat");
        mav.addObject("list", list);
        mav.addObject("data", obj);
        mav.addObject("worker", worker);
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessUserPropertyComQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessUserPropertyComService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessUserPropertyCom businessUserPropertyCom = (BusinessUserPropertyCom) baseBean.getList().get(i);
				result.append("{")
			    .append("\"comId\":\"").append(businessUserPropertyCom.getComId()).append("\"").append(",")
			    .append("\"userId\":\"").append(businessUserPropertyCom.getUserId()).append("\"").append(",")
			    .append("\"userName\":\"").append(businessUserPropertyCom.getUserName()).append("\"").append(",")
			    .append("\"managerId\":\"").append(businessUserPropertyCom.getManagerId()).append("\"").append(",")
			    .append("\"managerName\":\"").append(businessUserPropertyCom.getManagerName()).append("\"").append(",")
			    .append("\"content\":\"").append(businessUserPropertyCom.getContent()).append("\"").append(",")
			    .append("\"pubTime\":\"").append(businessUserPropertyCom.getPubTime()).append("\"").append(",")
			    .append("\"direction\":\"").append(businessUserPropertyCom.getDirection()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(baseBean.getList().size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示businessUserPropertyCom列表时发生错误：/business/businessUserPropertyCom/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessUserPropertyComQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessUserPropertyCom新增页时发生错误：/business/businessUserPropertyCom/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessUserPropertyCom/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessUserPropertyComQuery query) {
		BusinessUserPropertyCom businessUserPropertyCom = new BusinessUserPropertyCom();
		String json = "";
		try{
		    businessUserPropertyCom.setManagerId(getUser().getUserId());
		    businessUserPropertyCom.setManagerName(getUser().getUserName());
		    businessUserPropertyCom.setContent(query.getContent());

		    businessUserPropertyCom.setDirection(1); //员工向用户发送消息
	        Timestamp  ts=new Timestamp(new Date().getTime());
            businessUserPropertyCom.setPubTime(ts);
            businessUserPropertyCom.setUserName(query.getUserName());
            businessUserPropertyCom.setUserId(query.getUserId());
			businessUserPropertyComService.save(businessUserPropertyCom);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessUserPropertyCom信息时发生错误：/business/businessUserPropertyCom/save", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入修改页
	 * @return
	 */
	@RequestMapping(value="modify")
	public ModelAndView modify(BusinessUserPropertyComQuery query) {	
		BusinessUserPropertyCom businessUserPropertyCom=new BusinessUserPropertyCom();
		
		try{
			businessUserPropertyCom = businessUserPropertyComService.findById(query.getComId());
		}catch(Exception e){
			GSLogger.error("进入businessUserPropertyCom修改页时发生错误：/business/businessUserPropertyCom/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessUserPropertyCom/modify");
		mav.addObject("businessUserPropertyCom", businessUserPropertyCom);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessUserPropertyComQuery query) {
		BusinessUserPropertyCom businessUserPropertyCom = null;
		String json = "";
		try{
		    businessUserPropertyCom = businessUserPropertyComService.findById(query.getComId());
		    businessUserPropertyCom.setUserId(query.getUserId());
		    businessUserPropertyCom.setUserName(query.getUserName());
		    businessUserPropertyCom.setManagerId(query.getManagerId());
		    businessUserPropertyCom.setManagerName(query.getManagerName());
		    businessUserPropertyCom.setContent(query.getContent());
		    businessUserPropertyCom.setPubTime(query.getPubTime());
		    businessUserPropertyCom.setDirection(query.getDirection());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessUserPropertyCom.setEditTime(ts);
			businessUserPropertyComService.update(businessUserPropertyCom);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessUserPropertyCom信息时发生错误：/business/businessUserPropertyCom/update", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 删除单个或多个对象
	 * @param id
	 * @return
	 */
	@RequestMapping(value="delete")
	public void delete(@RequestParam(value="id") String id, HttpServletResponse response) {
		String json = "";
		try{
			if(id != null) {
				if(id.indexOf(',') > -1) {
					String[] ids = id.split(",");
					for(int i=0;i<ids.length;i++) {
						businessUserPropertyComService.delete(new Integer(ids[i]));
					}
				}else{
					businessUserPropertyComService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessUserPropertyCom时发生错误：/business/businessUserPropertyCom/delete", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
