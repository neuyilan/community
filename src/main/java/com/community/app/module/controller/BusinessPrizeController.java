package com.community.app.module.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.BusinessPrize;
import com.community.app.module.service.BusinessPrizeService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessPrizeQuery;


@Controller
@RequestMapping("/business/businessPrize")
public class BusinessPrizeController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessPrizeController.class);
	@Autowired
	private BusinessPrizeService businessPrizeService;
	
	private final String LIST_ACTION = "redirect:/business/businessPrize/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessPrize管理页时发生错误：/business/businessPrize/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessPrize/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessPrizeQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessPrizeService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessPrize businessPrize = (BusinessPrize) baseBean.getList().get(i);
				result.append("{")
			    .append("\"prizeId\":\"").append(businessPrize.getPrizeId()).append("\"").append(",")
			    .append("\"awardName\":\"").append(businessPrize.getAwardName()).append("\"").append(",")
			    .append("\"prizeName\":\"").append(businessPrize.getPrizeName()).append("\"").append(",")
			    .append("\"prizeQuota\":\"").append(businessPrize.getPrizeQuota()).append("\"").append(",")
			    .append("\"prizeContent\":\"").append(businessPrize.getPrizeContent()).append("\"").append(",")
			    .append("\"actId\":\"").append(businessPrize.getActId()).append("\"").append(",")
			    .append("\"prizeImg\":\"").append(businessPrize.getPrizeImg()).append("\"").append(",")
			    .append("\"rankStart\":\"").append(businessPrize.getRankStart()).append("\"").append(",")
			    .append("\"rankEnd\":\"").append(businessPrize.getRankEnd()).append("\"").append(",")
			    .append("\"prizeOrder\":\"").append(businessPrize.getPrizeOrder()).append("\"").append(",")
			    .append("\"creatTime\":\"").append(businessPrize.getCreatTime()).append("\"")
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
			GSLogger.error("显示businessPrize列表时发生错误：/business/businessPrize/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessPrizeQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessPrize新增页时发生错误：/business/businessPrize/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessPrize/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessPrize
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessPrizeQuery query) {
		BusinessPrize businessPrize = new BusinessPrize();
		String json = "";
		try{
		    businessPrize.setAwardName(query.getAwardName());
		    businessPrize.setPrizeName(query.getPrizeName());
		    businessPrize.setPrizeQuota(query.getPrizeQuota());
		    businessPrize.setPrizeContent(query.getPrizeContent());
		    businessPrize.setActId(query.getActId());
		    businessPrize.setPrizeImg(query.getPrizeImg());
		    businessPrize.setRankStart(query.getRankStart());
		    businessPrize.setRankEnd(query.getRankEnd());
		    businessPrize.setPrizeOrder(query.getPrizeOrder());
		    businessPrize.setCreatTime(query.getCreatTime());
			businessPrizeService.save(businessPrize);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessPrize信息时发生错误：/business/businessPrize/save", e);
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
	public ModelAndView modify(BusinessPrizeQuery query) {	
		BusinessPrize businessPrize=new BusinessPrize();
		
		try{
			businessPrize = businessPrizeService.findById(query.getPrizeId());
		}catch(Exception e){
			GSLogger.error("进入businessPrize修改页时发生错误：/business/businessPrize/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessPrize/modify");
		mav.addObject("businessPrize", businessPrize);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessPrizeQuery query) {
		BusinessPrize businessPrize = null;
		String json = "";
		try{
		    businessPrize = businessPrizeService.findById(query.getPrizeId());
		    businessPrize.setAwardName(query.getAwardName());
		    businessPrize.setPrizeName(query.getPrizeName());
		    businessPrize.setPrizeQuota(query.getPrizeQuota());
		    businessPrize.setPrizeContent(query.getPrizeContent());
		    businessPrize.setActId(query.getActId());
		    businessPrize.setPrizeImg(query.getPrizeImg());
		    businessPrize.setRankStart(query.getRankStart());
		    businessPrize.setRankEnd(query.getRankEnd());
		    businessPrize.setPrizeOrder(query.getPrizeOrder());
		    businessPrize.setCreatTime(query.getCreatTime());
			businessPrizeService.update(businessPrize);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessPrize信息时发生错误：/business/businessPrize/update", e);
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
						businessPrizeService.delete(new Integer(ids[i]));
					}
				}else{
					businessPrizeService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessPrize时发生错误：/business/businessPrize/delete", e);
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
