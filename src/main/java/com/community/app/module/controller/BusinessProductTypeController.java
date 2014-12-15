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

import com.community.app.module.bean.BusinessProductType;
import com.community.app.module.service.BusinessProductTypeService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessProductTypeQuery;

@Controller
@RequestMapping("/business/businessProductType")
public class BusinessProductTypeController {
	private static Logger GSLogger = LoggerFactory
			.getLogger(BusinessProductTypeController.class);
	@Autowired
	private BusinessProductTypeService businessProductTypeService;

	/**
	 * 进入管理页
	 * 
	 * @return
	 */
	@RequestMapping(value = "enter")
	public ModelAndView enter() {
		try {
		} catch (Exception e) {
			GSLogger.error(
					"进入businessProductType管理页时发生错误：/business/businessProductType/enter",
					e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView(
				"/business/businessProductType/enter");
		return mav;
	}

	/**
	 * 列示或者查询所有数据
	 * 
	 * @return
	 */
	@RequestMapping(value = "list")
	public void list(BusinessProductTypeQuery query,
			HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try {
			BaseBean baseBean = businessProductTypeService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount())
					.append(",").append("\"rows\":[");
			for (int i = 0; i < baseBean.getList().size(); i++) {
				BusinessProductType businessProductType = (BusinessProductType) baseBean
						.getList().get(i);
				result.append("{").append("\"typeId\":\"")
						.append(businessProductType.getTypeId()).append("\"")
						.append(",").append("\"typeName\":\"")
						.append(businessProductType.getTypeName()).append("\"")
						.append(",").append("\"typeImage\":\"")
						.append(businessProductType.getTypeImage())
						.append("\"").append(",").append("\"createTime\":\"")
						.append(businessProductType.getCreateTime())
						.append("\"").append(",").append("\"editTime\":\"")
						.append(businessProductType.getEditTime()).append("\"")
						.append(",").append("\"editor\":\"")
						.append(businessProductType.getEditor()).append("\"")
						.append("}").append(",");
			}
			json = result.toString();
			if (baseBean.getList().size() > 0) {
				json = json.substring(0, json.length() - 1);
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
		} catch (Exception e) {
			GSLogger.error(
					"显示businessProductType列表时发生错误：/business/businessProductType/list",
					e);
			e.printStackTrace();
		}
	}

	/**
	 * 进入新增页
	 * 
	 * @return
	 */
	@RequestMapping(value = "add")
	public ModelAndView add(BusinessProductTypeQuery query) {
		try {
		} catch (Exception e) {
			GSLogger.error(
					"进入businessProductType新增页时发生错误：/business/businessProductType/add",
					e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessProductType/add");
		return mav;
	}

	/**
	 * 保存对象
	 * 
	 * @param request
	 * @param businessProductType
	 * @return
	 */
	@RequestMapping(value = "save")
	public void save(HttpServletRequest request, HttpServletResponse response,
			BusinessProductTypeQuery query) {
		BusinessProductType businessProductType = new BusinessProductType();
		String json = "";
		try {
			businessProductType.setTypeName(query.getTypeName());
			businessProductType.setTypeImage(query.getTypeImage());
			businessProductType.setCreateTime(query.getCreateTime());
			businessProductType.setEditTime(query.getEditTime());
			businessProductType.setEditor(query.getEditor());
			businessProductTypeService.save(businessProductType);
			// 保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch (Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error(
					"保存businessProductType信息时发生错误：/business/businessProductType/save",
					e);
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
	 * 
	 * @return
	 */
	@RequestMapping(value = "modify")
	public ModelAndView modify(BusinessProductTypeQuery query) {
		BusinessProductType businessProductType = new BusinessProductType();

		try {
			businessProductType = businessProductTypeService.findById(query
					.getTypeId());
		} catch (Exception e) {
			GSLogger.error(
					"进入businessProductType修改页时发生错误：/business/businessProductType/modify",
					e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView(
				"/business/businessProductType/modify");
		mav.addObject("businessProductType", businessProductType);
		return mav;
	}

	/**
	 * 更新对象
	 * 
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value = "update")
	public void update(HttpServletRequest request,
			HttpServletResponse response, BusinessProductTypeQuery query) {
		BusinessProductType businessProductType = null;
		String json = "";
		try {
			businessProductType = businessProductTypeService.findById(query
					.getTypeId());
			businessProductType.setTypeName(query.getTypeName());
			businessProductType.setTypeImage(query.getTypeImage());
			businessProductType.setCreateTime(query.getCreateTime());
			businessProductType.setEditTime(query.getEditTime());
			businessProductType.setEditor(query.getEditor());
			businessProductTypeService.update(businessProductType);

			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch (Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error(
					"编辑businessProductType信息时发生错误：/business/businessProductType/update",
					e);
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
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delete")
	public void delete(@RequestParam(value = "id") String id,
			HttpServletResponse response) {
		String json = "";
		try {
			if (id != null) {
				if (id.indexOf(',') > -1) {
					String[] ids = id.split(",");
					for (int i = 0; i < ids.length; i++) {
						businessProductTypeService.delete(new Integer(ids[i]));
					}
				} else {
					businessProductTypeService.delete(new Integer(id));
				}
			}

			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		} catch (Exception e) {
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error(
					"删除BusinessProductType时发生错误：/business/businessProductType/delete",
					e);
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