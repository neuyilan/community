package com.community.app.module.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.BusinessNewsRecommend;
import com.community.app.module.service.BusinessNewsRecommendService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessNewsRecommendQuery;


@Controller
@RequestMapping("/business/businessNewsRecommend")
public class BusinessNewsRecommendController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessNewsRecommendController.class);
	@Autowired
	private BusinessNewsRecommendService businessNewsRecommendService;
	
	private final String LIST_ACTION = "redirect:/business/businessNewsRecommend/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessNewsRecommend管理页时发生错误：/business/businessNewsRecommend/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessNewsRecommend/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessNewsRecommendQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessNewsRecommendService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessNewsRecommend businessNewsRecommend = (BusinessNewsRecommend) baseBean.getList().get(i);
				result.append("{")
			    .append("\"recId\":\"").append(businessNewsRecommend.getRecId()).append("\"").append(",")
			    .append("\"newsId\":\"").append(businessNewsRecommend.getNewsId()).append("\"").append(",")
			    .append("\"recerId\":\"").append(businessNewsRecommend.getRecerId()).append("\"").append(",")
			    .append("\"recTime\":\"").append(businessNewsRecommend.getRecTime()).append("\"").append(",")
			    .append("\"recCom\":\"").append(businessNewsRecommend.getRecCom()).append("\"")
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
			GSLogger.error("显示businessNewsRecommend列表时发生错误：/business/businessNewsRecommend/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessNewsRecommendQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessNewsRecommend新增页时发生错误：/business/businessNewsRecommend/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessNewsRecommend/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessNewsRecommend
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessNewsRecommendQuery query) {
		BusinessNewsRecommend businessNewsRecommend = new BusinessNewsRecommend();
		String json = "";
		try{
		    businessNewsRecommend.setNewsId(query.getNewsId());
		    businessNewsRecommend.setRecerId(query.getRecerId());
		    businessNewsRecommend.setRecTime(query.getRecTime());
		    businessNewsRecommend.setRecCom(query.getRecCom());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessNewsRecommend.setCreateTime(ts);
	       // businessNewsRecommend.setEditTime(ts);
			businessNewsRecommendService.save(businessNewsRecommend);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessNewsRecommend信息时发生错误：/business/businessNewsRecommend/save", e);
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
	public ModelAndView modify(BusinessNewsRecommendQuery query) {	
		BusinessNewsRecommend businessNewsRecommend=new BusinessNewsRecommend();
		
		try{
			businessNewsRecommend = businessNewsRecommendService.findById(query.getRecId());
		}catch(Exception e){
			GSLogger.error("进入businessNewsRecommend修改页时发生错误：/business/businessNewsRecommend/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessNewsRecommend/modify");
		mav.addObject("businessNewsRecommend", businessNewsRecommend);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessNewsRecommendQuery query) {
		BusinessNewsRecommend businessNewsRecommend = null;
		String json = "";
		try{
		    businessNewsRecommend = businessNewsRecommendService.findById(query.getRecId());
		    businessNewsRecommend.setNewsId(query.getNewsId());
		    businessNewsRecommend.setRecerId(query.getRecerId());
		    businessNewsRecommend.setRecTime(query.getRecTime());
		    businessNewsRecommend.setRecCom(query.getRecCom());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessNewsRecommend.setEditTime(ts);
			businessNewsRecommendService.update(businessNewsRecommend);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessNewsRecommend信息时发生错误：/business/businessNewsRecommend/update", e);
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
						businessNewsRecommendService.delete(new Integer(ids[i]));
					}
				}else{
					businessNewsRecommendService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessNewsRecommend时发生错误：/business/businessNewsRecommend/delete", e);
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
