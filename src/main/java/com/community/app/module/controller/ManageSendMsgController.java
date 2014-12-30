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

import com.community.app.module.bean.ManageSendMsg;
import com.community.app.module.service.ManageSendMsgService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.ManageSendMsgQuery;


@Controller
@RequestMapping("/manage/manageSendMsg")
public class ManageSendMsgController {
	private static Logger GSLogger = LoggerFactory.getLogger(ManageSendMsgController.class);
	@Autowired
	private ManageSendMsgService manageSendMsgService;
	
	private final String LIST_ACTION = "redirect:/manage/manageSendMsg/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageSendMsg管理页时发生错误：/manage/manageSendMsg/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageSendMsg/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(ManageSendMsgQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = manageSendMsgService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				ManageSendMsg manageSendMsg = (ManageSendMsg) baseBean.getList().get(i);
				result.append("{")
			    .append("\"sendId\":\"").append(manageSendMsg.getSendId()).append("\"").append(",")
			    .append("\"sendTel\":\"").append(manageSendMsg.getSendTel()).append("\"").append(",")
			    .append("\"sendContent\":\"").append(manageSendMsg.getSendContent()).append("\"").append(",")
			    .append("\"recvCode\":\"").append(manageSendMsg.getRecvCode()).append("\"").append(",")
			    .append("\"sendTime\":\"").append(manageSendMsg.getSendTime()).append("\"").append(",")
			    .append("\"sendType\":\"").append(manageSendMsg.getSendType()).append("\"")
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
			GSLogger.error("显示manageSendMsg列表时发生错误：/manage/manageSendMsg/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(ManageSendMsgQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageSendMsg新增页时发生错误：/manage/manageSendMsg/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageSendMsg/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param manageSendMsg
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, ManageSendMsgQuery query) {
		ManageSendMsg manageSendMsg = new ManageSendMsg();
		String json = "";
		try{
		    manageSendMsg.setSendTel(query.getSendTel());
		    manageSendMsg.setSendContent(query.getSendContent());
		    manageSendMsg.setRecvCode(query.getRecvCode());
		    manageSendMsg.setSendTime(query.getSendTime());
		    manageSendMsg.setSendType(query.getSendType());
			manageSendMsgService.save(manageSendMsg);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存manageSendMsg信息时发生错误：/manage/manageSendMsg/save", e);
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
	public ModelAndView modify(ManageSendMsgQuery query) {	
		ManageSendMsg manageSendMsg=new ManageSendMsg();
		
		try{
			manageSendMsg = manageSendMsgService.findById(query.getSendId());
		}catch(Exception e){
			GSLogger.error("进入manageSendMsg修改页时发生错误：/manage/manageSendMsg/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageSendMsg/modify");
		mav.addObject("manageSendMsg", manageSendMsg);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, ManageSendMsgQuery query) {
		ManageSendMsg manageSendMsg = null;
		String json = "";
		try{
		    manageSendMsg = manageSendMsgService.findById(query.getSendId());
		    manageSendMsg.setSendTel(query.getSendTel());
		    manageSendMsg.setSendContent(query.getSendContent());
		    manageSendMsg.setRecvCode(query.getRecvCode());
		    manageSendMsg.setSendTime(query.getSendTime());
		    manageSendMsg.setSendType(query.getSendType());
			manageSendMsgService.update(manageSendMsg);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑manageSendMsg信息时发生错误：/manage/manageSendMsg/update", e);
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
						manageSendMsgService.delete(new Integer(ids[i]));
					}
				}else{
					manageSendMsgService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除ManageSendMsg时发生错误：/manage/manageSendMsg/delete", e);
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
