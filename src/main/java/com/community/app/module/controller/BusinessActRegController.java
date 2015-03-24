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

import com.community.app.module.bean.BusinessActReg;
import com.community.app.module.service.BusinessActRegService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActRegQuery;


@Controller
@RequestMapping("/business/businessActReg")
public class BusinessActRegController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessActRegController.class);
	@Autowired
	private BusinessActRegService businessActRegService;
	
	private final String LIST_ACTION = "redirect:/business/businessActReg/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessActReg管理页时发生错误：/business/businessActReg/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActReg/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessActRegQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessActRegService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessActReg businessActReg = (BusinessActReg) baseBean.getList().get(i);
				result.append("{")
			    .append("\"regId\":\"").append(businessActReg.getRegId()).append("\"").append(",")
			    .append("\"userId\":\"").append(businessActReg.getUserId()).append("\"").append(",")
			    .append("\"nickName\":\"").append(businessActReg.getNickName()).append("\"").append(",")
			    .append("\"avatar\":\"").append(businessActReg.getAvatar()).append("\"").append(",")
			    .append("\"code\":\"").append(businessActReg.getCode()).append("\"").append(",")
			    .append("\"desc\":\"").append(businessActReg.getDesc()).append("\"").append(",")
			    .append("\"actId\":\"").append(businessActReg.getActId()).append("\"").append(",")
			    .append("\"votes\":\"").append(businessActReg.getVotes()).append("\"").append(",")
			    .append("\"regTime\":\"").append(businessActReg.getRegTime()).append("\"").append(",")
			    .append("\"flag\":\"").append(businessActReg.getFlag()).append("\"")
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
			GSLogger.error("显示businessActReg列表时发生错误：/business/businessActReg/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessActRegQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessActReg新增页时发生错误：/business/businessActReg/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActReg/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessActReg
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessActRegQuery query) {
		BusinessActReg businessActReg = new BusinessActReg();
		String json = "";
		try{
		    businessActReg.setUserId(query.getUserId());
		    businessActReg.setNickName(query.getNickName());
		    businessActReg.setAvatar(query.getAvatar());
		    businessActReg.setCode(query.getCode());
		    businessActReg.setDesc(query.getDesc());
		    businessActReg.setActId(query.getActId());
		    businessActReg.setVotes(query.getVotes());
		    businessActReg.setRegTime(query.getRegTime());
		    businessActReg.setFlag(query.getFlag());
			businessActRegService.save(businessActReg);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessActReg信息时发生错误：/business/businessActReg/save", e);
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
	public ModelAndView modify(BusinessActRegQuery query) {	
		BusinessActReg businessActReg=new BusinessActReg();
		
		try{
			businessActReg = businessActRegService.findById(query.getRegId());
		}catch(Exception e){
			GSLogger.error("进入businessActReg修改页时发生错误：/business/businessActReg/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActReg/modify");
		mav.addObject("businessActReg", businessActReg);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessActRegQuery query) {
		BusinessActReg businessActReg = null;
		String json = "";
		try{
		    businessActReg = businessActRegService.findById(query.getRegId());
		    businessActReg.setUserId(query.getUserId());
		    businessActReg.setNickName(query.getNickName());
		    businessActReg.setAvatar(query.getAvatar());
		    businessActReg.setCode(query.getCode());
		    businessActReg.setDesc(query.getDesc());
		    businessActReg.setActId(query.getActId());
		    businessActReg.setVotes(query.getVotes());
		    businessActReg.setRegTime(query.getRegTime());
		    businessActReg.setFlag(query.getFlag());
			businessActRegService.update(businessActReg);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessActReg信息时发生错误：/business/businessActReg/update", e);
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
						businessActRegService.delete(new Integer(ids[i]));
					}
				}else{
					businessActRegService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessActReg时发生错误：/business/businessActReg/delete", e);
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
