package com.community.app.module.controller;

import static com.community.framework.utils.CommonUtils.getUser;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.BusinessLife;
import com.community.app.module.bean.BusinessLifeProp;
import com.community.app.module.bean.BusinessLifeType;
import com.community.app.module.service.BusinessLifePropService;
import com.community.app.module.service.BusinessLifeService;
import com.community.app.module.service.BusinessLifeTypeService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessLifeQuery;

@Controller
@RequestMapping("/business/businessLife")
public class BusinessLifeController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessLifeController.class);
	@Autowired
	private BusinessLifeService businessLifeService;
    @Autowired
	private BusinessLifePropService businessLifePropService;
    @Autowired
	private BusinessLifeTypeService businessLifeTypeService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="list")
	public ModelAndView list(BusinessLifeQuery query) {		
		BaseBean baseBean = new BaseBean();
		try{
			query.setSort("serviceId");
			query.setOrder("desc");
			query.setRows(5);
			baseBean = businessLifeService.findAllPage(query);
		}catch(Exception e){
			GSLogger.error("进入businessLife管理页时发生错误：/business/businessLife/list", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/life/list");
		mav.addObject("baseBean", baseBean);
		mav.addObject("pager", baseBean.getPager());
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="getPageList")
	public void getPageList(BusinessLifeQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			if(!("").equals(query.getOrderBy()) && query.getOrderBy() != null) {
				query.setSort(query.getOrderBy());
			}else{
				query.setSort("serviceId");
			}
			query.setOrder("desc");
			query.setRows(5);
			BaseBean baseBean = businessLifeService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessLife businessLife = (BusinessLife) baseBean.getList().get(i);
				result.append("{")
			    .append("\"serviceId\":\"").append(businessLife.getServiceId()).append("\"").append(",")
			    .append("\"typeId\":\"").append(businessLife.getTypeId()).append("\"").append(",")
			    .append("\"serviceName\":\"").append(businessLife.getServiceName()).append("\"").append(",")
			    .append("\"publisherId\":\"").append(businessLife.getPublisherId()).append("\"").append(",")
			    .append("\"publisherName\":\"").append(businessLife.getPublisherName()).append("\"").append(",")
			    .append("\"content\":\"").append(businessLife.getContent()).append("\"").append(",")
			    .append("\"estateLongitude\":\"").append(businessLife.getEstateLongitude()).append("\"").append(",")
			    .append("\"estateLatitude\":\"").append(businessLife.getEstateLatitude()).append("\"").append(",")
			    .append("\"typeName\":\"").append(businessLife.getTypeName()).append("\"").append(",")
			    .append("\"estateScope\":\"").append(businessLife.getEstateScope()).append("\"").append(",")
			    .append("\"publishTime\":\"").append(businessLife.getPublishTime()).append("\"").append(",")
			    .append("\"link\":\"").append(businessLife.getLink()).append("\"").append(",")
			    .append("\"pulishState\":\"").append(businessLife.getPulishState()).append("\"").append(",")
			    .append("\"visits\":\"").append(businessLife.getVisits()).append("\"").append(",")
			    .append("\"tel\":\"").append(businessLife.getTel()).append("\"").append(",")
			    .append("\"address\":\"").append(businessLife.getAddress()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessLife.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessLife.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessLife.getEditor()).append("\"")
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
			GSLogger.error("显示businessLife列表时发生错误：/business/businessLife/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessLifeQuery query) {
        List lifeList = new ArrayList();
		try{
            //查询生活类型
            lifeList = businessLifeTypeService.findAll();
		}catch(Exception e){
			GSLogger.error("进入businessLife新增页时发生错误：/business/businessLife/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/life/add");
        mav.addObject("lifeList", lifeList);
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessLifeQuery query) {
		BusinessLife businessLife = new BusinessLife();
		String json = "";
		try{
			businessLife.setEstateLongitude(Double.valueOf(query.getEstateLongitude()));
            businessLife.setEstateLatitude(Double.valueOf(query.getEstateLatitude()));
		    businessLife.setTypeId(query.getTypeId());
            BusinessLifeType businessLifeType = businessLifeTypeService.findById(query.getTypeId());
		    businessLife.setServiceName(query.getServiceName());
		    businessLife.setPublisherId(getUser().getUserId());
		    businessLife.setPublisherName(getUser().getUserName());
		    //businessLife.setContent(query.getContent());
		    businessLife.setTypeName(businessLifeType.getTypeName());
		    businessLife.setEstateScope(String.valueOf(getUser().getOrgId()));//驿站ID
		    businessLife.setLink(query.getLink());
		    businessLife.setPulishState(1);//待审核
		    businessLife.setVisits(0);
		    businessLife.setTel(query.getTel());
		    businessLife.setAddress(query.getAddress());
		    businessLife.setCreateTime(new Timestamp(System.currentTimeMillis()));
		    businessLife.setEditTime(new Timestamp(System.currentTimeMillis()));
		    businessLife.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessLife.setCreateTime(ts);
	        businessLife.setEditTime(ts);
            businessLife.setPublishTime(ts);

			businessLifeService.save(businessLife);
            //保存属性
            String values = request.getParameter("values");
            String[] arys = values.split("\\,");
            for(String ary : arys) {
                String[] aa = ary.split("\\|");
                int i = aa.length;
                String value = "";
                if(i > 0) {
                    value = aa[1];
                }
                String[] attrs = aa[0].split("\\&");
                String propId = attrs[0];
                String propName = attrs[1];
                String propType = attrs[2];
                String propValue = value;

                BusinessLifeProp blp = new BusinessLifeProp();
                blp.setCreateTime(ts);
                blp.setEditTime(ts);
                blp.setPropId(Integer.valueOf(propId));
                blp.setPropName(propName);
                blp.setPropValue(propValue);
                blp.setEditor(getUser().getUserName());
                blp.setPropType(Integer.valueOf(propType));
                blp.setServiceId(businessLife.getServiceId());
                businessLifePropService.save(blp);
            }

			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessLife信息时发生错误：/business/businessLife/save", e);
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
	public ModelAndView modify(BusinessLifeQuery query) {	
		BusinessLife businessLife=new BusinessLife();
		//business_life_prop
        Map map = new HashMap();
        map.put("serviceId", query.getServiceId());
        List<BusinessLifeProp> proplist = businessLifePropService.findByMap(map);
        //查询生活类型
        List lifeList = businessLifeTypeService.findAll();
		try{
			businessLife = businessLifeService.findById(query.getServiceId());
		}catch(Exception e){
			GSLogger.error("进入businessLife修改页时发生错误：/business/businessLife/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/life/modify");
		mav.addObject("businessLife", businessLife);
		mav.addObject("proplist", proplist);
		mav.addObject("lifeList", lifeList);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessLifeQuery query) {
		String json = "";
		try{
			BusinessLife businessLife = businessLifeService.findById(query.getServiceId());
            Timestamp  ts=new Timestamp(new Date().getTime());
            businessLife.setServiceName(query.getServiceName());
		    businessLife.setPublisherId(getUser().getUserId());
		    businessLife.setPublisherName(getUser().getUserName());
		    //businessLife.setContent(query.getContent());
		    //businessLife.setEstateScope(query.getEstateScope());
		    //businessLife.setLink(query.getLink());
		    businessLife.setPulishState(1);//待审核
		    businessLife.setVisits(0);
		    businessLife.setTel(query.getTel());
		    businessLife.setAddress(query.getAddress());
		    //businessLife.setCreateTime(query.getCreateTime());
		    businessLife.setEditTime(new Timestamp(System.currentTimeMillis()));
		    businessLife.setEditor(query.getEditor());
		    
            businessLife.setEditTime(ts);
            businessLife.setEditor(getUser().getUserName());
            businessLife.setTypeId(query.getTypeId());
            businessLife.setTel(query.getTel());
            BusinessLifeType businessLifeType = businessLifeTypeService.findById(query.getTypeId());
            businessLife.setTypeName(businessLifeType.getTypeName());
            //保存属性
            String values = request.getParameter("values");
            if(!"1".equals(values) && !"".equals(values)) {
                //删除
                businessLifePropService.deleteLifeProp(query.getServiceId());
                String[] arys = values.split("\\,");
                for(String ary : arys) {
                    String[] aa = ary.split("\\|");
                    int i = aa.length;
                    String value = "";
                    if(i > 0) {
                        value = aa[1];
                    }
                    String[] attrs = aa[0].split("\\&");
                    String propId = attrs[0];
                    String propName = attrs[1];
                    String propType = attrs[2];
                    String propValue = value;

                    BusinessLifeProp blp = new BusinessLifeProp();
                    blp.setCreateTime(ts);
                    blp.setEditTime(ts);
                    blp.setPropId(Integer.valueOf(propId));
                    blp.setPropName(propName);
                    blp.setPropValue(propValue);
                    blp.setEditor(getUser().getUserName());
                    blp.setPropType(Integer.valueOf(propType));
                    blp.setServiceId(businessLife.getServiceId());
                    businessLifePropService.save(blp);
                }
            }
            businessLife.setEstateLongitude(Double.valueOf(query.getEstateLongitude()));
            businessLife.setEstateLatitude(Double.valueOf(query.getEstateLatitude()));
			businessLifeService.update(businessLife);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessLife信息时发生错误：/business/businessLife/update", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
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
						businessLifeService.delete(new Integer(ids[i]));
					}
				}else{
					businessLifeService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessLife时发生错误：/business/businessLife/delete", e);
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
