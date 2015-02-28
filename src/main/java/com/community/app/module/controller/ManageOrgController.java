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

import com.community.app.module.bean.ManageOrg;
import com.community.app.module.service.ManageOrgService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.ManageOrgQuery;


@Controller
@RequestMapping("/manage/manageOrg")
public class ManageOrgController {
	private static Logger GSLogger = LoggerFactory.getLogger(ManageOrgController.class);
	@Autowired
	private ManageOrgService manageOrgService;
	
	private final String LIST_ACTION = "redirect:/manage/manageOrg/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageOrg管理页时发生错误：/manage/manageOrg/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageOrg/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(ManageOrgQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = manageOrgService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				ManageOrg manageOrg = (ManageOrg) baseBean.getList().get(i);
				result.append("{")
			    .append("\"orgId\":\"").append(manageOrg.getOrgId()).append("\"").append(",")
			    .append("\"orgName\":\"").append(manageOrg.getOrgName()).append("\"").append(",")
			    .append("\"orgDesc\":\"").append(manageOrg.getOrgDesc()).append("\"").append(",")
			    .append("\"parentId\":\"").append(manageOrg.getParentId()).append("\"").append(",")
			    .append("\"orgCode\":\"").append(manageOrg.getOrgCode()).append("\"").append(",")
			    .append("\"orgState\":\"").append(manageOrg.getOrgState()).append("\"").append(",")
			    .append("\"orgTypeCode\":\"").append(manageOrg.getOrgTypeCode()).append("\"").append(",")
			    .append("\"orgLongitude\":\"").append(manageOrg.getOrgLongitude()).append("\"").append(",")
			    .append("\"orgLatitude\":\"").append(manageOrg.getOrgLatitude()).append("\"").append(",")
			    .append("\"orgIcon\":\"").append(manageOrg.getOrgIcon()).append("\"").append(",")
			    .append("\"orgTel\":\"").append(manageOrg.getOrgTel()).append("\"").append(",")
			    .append("\"orgEmail\":\"").append(manageOrg.getOrgEmail()).append("\"").append(",")
			    .append("\"orgWeixin\":\"").append(manageOrg.getOrgWeixin()).append("\"").append(",")
			    .append("\"orgSubType\":\"").append(manageOrg.getOrgSubType()).append("\"").append(",")
			    .append("\"createTime\":\"").append(manageOrg.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(manageOrg.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(manageOrg.getEditor()).append("\"").append(",")
			    .append("\"leaf\":\"").append(manageOrg.getLeaf()).append("\"").append(",")
			    .append("\"ord\":\"").append(manageOrg.getOrd()).append("\"")
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
			GSLogger.error("显示manageOrg列表时发生错误：/manage/manageOrg/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(ManageOrgQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageOrg新增页时发生错误：/manage/manageOrg/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageOrg/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param manageOrg
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, ManageOrgQuery query) {
		ManageOrg manageOrg = new ManageOrg();
		String json = "";
		try{
		    manageOrg.setOrgName(query.getOrgName());
		    manageOrg.setOrgDesc(query.getOrgDesc());
		    manageOrg.setParentId(query.getParentId());
		    manageOrg.setOrgCode(query.getOrgCode());
		    manageOrg.setOrgState(query.getOrgState());
		    manageOrg.setOrgTypeCode(query.getOrgTypeCode());
		    manageOrg.setOrgLongitude(query.getOrgLongitude());
		    manageOrg.setOrgLatitude(query.getOrgLatitude());
		    manageOrg.setOrgIcon(query.getOrgIcon());
		    manageOrg.setOrgTel(query.getOrgTel());
		    manageOrg.setOrgEmail(query.getOrgEmail());
		    manageOrg.setOrgWeixin(query.getOrgWeixin());
		    manageOrg.setOrgSubType(query.getOrgSubType());
		    manageOrg.setCreateTime(query.getCreateTime());
		    manageOrg.setEditTime(query.getEditTime());
		    manageOrg.setEditor(query.getEditor());
		    manageOrg.setLeaf(query.getLeaf());
		    manageOrg.setOrd(query.getOrd());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        manageOrg.setCreateTime(ts);
	        manageOrg.setEditTime(ts);
			manageOrgService.save(manageOrg);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存manageOrg信息时发生错误：/manage/manageOrg/save", e);
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
	public ModelAndView modify(ManageOrgQuery query) {	
		ManageOrg manageOrg=new ManageOrg();
		
		try{
			manageOrg = manageOrgService.findById(query.getOrgId());
		}catch(Exception e){
			GSLogger.error("进入manageOrg修改页时发生错误：/manage/manageOrg/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageOrg/modify");
		mav.addObject("manageOrg", manageOrg);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, ManageOrgQuery query) {
		ManageOrg manageOrg = null;
		String json = "";
		try{
		    manageOrg = manageOrgService.findById(query.getOrgId());
		    manageOrg.setOrgName(query.getOrgName());
		    manageOrg.setOrgDesc(query.getOrgDesc());
		    manageOrg.setParentId(query.getParentId());
		    manageOrg.setOrgCode(query.getOrgCode());
		    manageOrg.setOrgState(query.getOrgState());
		    manageOrg.setOrgTypeCode(query.getOrgTypeCode());
		    manageOrg.setOrgLongitude(query.getOrgLongitude());
		    manageOrg.setOrgLatitude(query.getOrgLatitude());
		    manageOrg.setOrgIcon(query.getOrgIcon());
		    manageOrg.setOrgTel(query.getOrgTel());
		    manageOrg.setOrgEmail(query.getOrgEmail());
		    manageOrg.setOrgWeixin(query.getOrgWeixin());
		    manageOrg.setOrgSubType(query.getOrgSubType());
		    manageOrg.setCreateTime(query.getCreateTime());
		    manageOrg.setEditTime(query.getEditTime());
		    manageOrg.setEditor(query.getEditor());
		    manageOrg.setLeaf(query.getLeaf());
		    manageOrg.setOrd(query.getOrd());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        manageOrg.setEditTime(ts);
			manageOrgService.update(manageOrg);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑manageOrg信息时发生错误：/manage/manageOrg/update", e);
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
						manageOrgService.delete(new Integer(ids[i]));
					}
				}else{
					manageOrgService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除ManageOrg时发生错误：/manage/manageOrg/delete", e);
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
