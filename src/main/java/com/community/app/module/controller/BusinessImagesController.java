package com.community.app.module.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.BusinessImages;
import com.community.app.module.service.BusinessImagesService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessImagesQuery;

@Controller
@RequestMapping("/business/businessImages")
public class BusinessImagesController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessImagesController.class);
	@Autowired
	private BusinessImagesService businessImagesService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessImages管理页时发生错误：/business/businessImages/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessImages/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessImagesQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessImagesService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessImages businessImages = (BusinessImages) baseBean.getList().get(i);
				result.append("{")
			    .append("\"imgId\":\"").append(businessImages.getImgId()).append("\"").append(",")
			    .append("\"imgName\":\"").append(businessImages.getImgName()).append("\"").append(",")
			    .append("\"imgPath\":\"").append(businessImages.getImgPath()).append("\"").append(",")
			    .append("\"imgType\":\"").append(businessImages.getImgType()).append("\"")
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
			GSLogger.error("显示businessImages列表时发生错误：/business/businessImages/list", e);
			e.printStackTrace();
		}
	}
	
	 /**
     * 查询收件人信息
     * @param query
     * @param response
     */
    @RequestMapping(value="getImagesDetail")
    public void getImagesDetail(BusinessImagesQuery query, HttpServletResponse response) {
        try{
        	BusinessImages businessImages = businessImagesService.findById(query.getImgId());
        	JSONObject jsons= JSONObject.fromObject(businessImages);
        	
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("utf-8");
            try {
                response.getWriter().write(jsons.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch(Exception e){
            GSLogger.error("显示businessAddress列表时发生错误：/business/businessAddress/list", e);
            e.printStackTrace();
        }
    }
    
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessImagesQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessImages新增页时发生错误：/business/businessImages/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessImages/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessImages
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessImagesQuery query) {
		BusinessImages businessImages = new BusinessImages();
		String json = "";
		try{
		    businessImages.setImgName(query.getImgName());
		    businessImages.setImgPath(query.getImgPath());
		    businessImages.setImgType(query.getImgType());
			businessImagesService.save(businessImages);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessImages信息时发生错误：/business/businessImages/save", e);
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
	public ModelAndView modify(BusinessImagesQuery query) {	
		BusinessImages businessImages=new BusinessImages();
		
		try{
			businessImages = businessImagesService.findById(query.getImgId());
		}catch(Exception e){
			GSLogger.error("进入businessImages修改页时发生错误：/business/businessImages/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessImages/modify");
		mav.addObject("businessImages", businessImages);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessImagesQuery query) {
		BusinessImages businessImages = null;
		String json = "";
		try{
		    businessImages = businessImagesService.findById(query.getImgId());
		    businessImages.setImgName(query.getImgName());
		    businessImages.setImgPath(query.getImgPath());
		    businessImages.setImgType(query.getImgType());
			businessImagesService.update(businessImages);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessImages信息时发生错误：/business/businessImages/update", e);
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
						businessImagesService.delete(new Integer(ids[i]));
					}
				}else{
					businessImagesService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessImages时发生错误：/business/businessImages/delete", e);
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