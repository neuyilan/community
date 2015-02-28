package com.community.app.module.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.BusinessLifeType;
import com.community.app.module.bean.BusinessTypeProperty;
import com.community.app.module.service.BusinessLifeTypeService;
import com.community.app.module.service.BusinessTypePropertyService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessTypePropertyQuery;


@Controller
@RequestMapping("/business/businessTypeProperty")
public class BusinessTypePropertyController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessTypePropertyController.class);
	@Autowired
	private BusinessTypePropertyService businessTypePropertyService;
@Autowired
private BusinessLifeTypeService businessLifeTypeService;
	
	private final String LIST_ACTION = "redirect:/business/businessTypeProperty/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessTypeProperty管理页时发生错误：/business/businessTypeProperty/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessTypeProperty/enter");
		return mav;
	}

    /**
     * 查找属性
     * @param query
     * @param response
     */
    @RequestMapping(value = "getTypePropertyJSON")
    public void getTypePropertyJSON(BusinessTypePropertyQuery query, HttpServletResponse response) {
        String json = "";
        StringBuilder result = new StringBuilder();
        try{
            List list = businessTypePropertyService.findByExample(query);
            result.append("[");
            for(int i=0;i<list.size();i++) {
                BusinessTypeProperty businessTypeProperty = (BusinessTypeProperty) list.get(i);
                result.append("{")
                        .append("\"propId\":\"").append(businessTypeProperty.getPropId()).append("\"").append(",")
                        .append("\"typeId\":\"").append(businessTypeProperty.getTypeId()).append("\"").append(",")
                        .append("\"propName\":\"").append(businessTypeProperty.getPropName()).append("\"").append(",")
                        .append("\"propDesc\":\"").append(businessTypeProperty.getPropDesc()).append("\"").append(",")
                        .append("\"propType\":\"").append(businessTypeProperty.getPropType()).append("\"").append(",")
                        .append("\"parentId\":\"").append(businessTypeProperty.getParentId()).append("\"").append(",")
                        .append("\"createTime\":\"").append(businessTypeProperty.getCreateTime()).append("\"").append(",")
                        .append("\"editTime\":\"").append(businessTypeProperty.getEditTime()).append("\"").append(",")
                        .append("\"editor\":\"").append(businessTypeProperty.getEditor()).append("\"")
                        .append("}").append(",");
            }
            json = result.toString();
            if(list.size() > 0) {
                json = json.substring(0, json.length()-1);
            }
            json += "]";

            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("utf-8");
            try {
                response.getWriter().write(json);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }catch(Exception e){
            GSLogger.error("显示businessTypeProperty列表时发生错误：/business/businessTypeProperty/list", e);
            e.printStackTrace();
        }
    }
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessTypePropertyQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessTypePropertyService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessTypeProperty businessTypeProperty = (BusinessTypeProperty) baseBean.getList().get(i);
				result.append("{")
			    .append("\"propId\":\"").append(businessTypeProperty.getPropId()).append("\"").append(",")
			    .append("\"typeId\":\"").append(businessTypeProperty.getTypeId()).append("\"").append(",")
			    .append("\"propName\":\"").append(businessTypeProperty.getPropName()).append("\"").append(",")
			    .append("\"propDesc\":\"").append(businessTypeProperty.getPropDesc()).append("\"").append(",")
			    .append("\"propType\":\"").append(businessTypeProperty.getPropType()).append("\"").append(",")
			    .append("\"parentId\":\"").append(businessTypeProperty.getParentId()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessTypeProperty.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessTypeProperty.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessTypeProperty.getEditor()).append("\"")
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
			GSLogger.error("显示businessTypeProperty列表时发生错误：/business/businessTypeProperty/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessTypePropertyQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessTypeProperty新增页时发生错误：/business/businessTypeProperty/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessTypeProperty/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessTypePropertyQuery query) {
		BusinessTypeProperty businessTypeProperty = new BusinessTypeProperty();
		String json = "";
		try{
			BusinessLifeType businessLifeType = new BusinessLifeType();
			businessLifeType = businessLifeTypeService.findById(query.getTypeId());
			businessTypeProperty.setBusinessLifeType(businessLifeType);
		    businessTypeProperty.setTypeId(query.getTypeId());
		    businessTypeProperty.setPropName(query.getPropName());
		    businessTypeProperty.setPropDesc(query.getPropDesc());
		    businessTypeProperty.setPropType(query.getPropType());
		    businessTypeProperty.setParentId(query.getParentId());
		    businessTypeProperty.setCreateTime(query.getCreateTime());
		    businessTypeProperty.setEditTime(query.getEditTime());
		    businessTypeProperty.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessTypeProperty.setCreateTime(ts);
	        businessTypeProperty.setEditTime(ts);
			businessTypePropertyService.save(businessTypeProperty);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessTypeProperty信息时发生错误：/business/businessTypeProperty/save", e);
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
	public ModelAndView modify(BusinessTypePropertyQuery query) {	
		BusinessTypeProperty businessTypeProperty=new BusinessTypeProperty();
		
		try{
			businessTypeProperty = businessTypePropertyService.findById(query.getPropId());
		}catch(Exception e){
			GSLogger.error("进入businessTypeProperty修改页时发生错误：/business/businessTypeProperty/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessTypeProperty/modify");
		mav.addObject("businessTypeProperty", businessTypeProperty);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessTypePropertyQuery query) {
		BusinessTypeProperty businessTypeProperty = null;
		String json = "";
		try{
		    businessTypeProperty = businessTypePropertyService.findById(query.getPropId());
			BusinessLifeType businessLifeType = new BusinessLifeType();
			businessLifeType = businessLifeTypeService.findById(query.getTypeId());
			businessTypeProperty.setBusinessLifeType(businessLifeType);
		    businessTypeProperty.setTypeId(query.getTypeId());
		    businessTypeProperty.setPropName(query.getPropName());
		    businessTypeProperty.setPropDesc(query.getPropDesc());
		    businessTypeProperty.setPropType(query.getPropType());
		    businessTypeProperty.setParentId(query.getParentId());
		    businessTypeProperty.setCreateTime(query.getCreateTime());
		    businessTypeProperty.setEditTime(query.getEditTime());
		    businessTypeProperty.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessTypeProperty.setEditTime(ts);
			businessTypePropertyService.update(businessTypeProperty);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessTypeProperty信息时发生错误：/business/businessTypeProperty/update", e);
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
						businessTypePropertyService.delete(new Integer(ids[i]));
					}
				}else{
					businessTypePropertyService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessTypeProperty时发生错误：/business/businessTypeProperty/delete", e);
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
