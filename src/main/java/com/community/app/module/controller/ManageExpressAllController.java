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

import com.community.app.module.bean.ManageExpressAll;
import com.community.app.module.service.ManageExpressAllService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.ManageExpressAllQuery;

@Controller
@RequestMapping("/manage/manageExpressAll")
public class ManageExpressAllController {
	private static Logger GSLogger = LoggerFactory
			.getLogger(ManageExpressAllController.class);
	@Autowired
	private ManageExpressAllService manageExpressAllService;

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
					"进入manageExpressAll管理页时发生错误：/manage/manageExpressAll/enter",
					e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageExpressAll/enter");
		return mav;
	}

	/**
	 * 列示或者查询所有数据
	 * 
	 * @return
	 */
	@RequestMapping(value = "list")
	public void list(ManageExpressAllQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try {
			BaseBean baseBean = manageExpressAllService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount())
					.append(",").append("\"rows\":[");
			for (int i = 0; i < baseBean.getList().size(); i++) {
				ManageExpressAll manageExpressAll = (ManageExpressAll) baseBean
						.getList().get(i);
				result.append("{").append("\"expressId\":\"")
						.append(manageExpressAll.getExpressId()).append("\"")
						.append(",").append("\"expressComppay\":\"")
						.append(manageExpressAll.getExpressComppay())
						.append("\"").append(",").append("\"expressDesc\":\"")
						.append(manageExpressAll.getExpressDesc()).append("\"")
						.append(",").append("\"expressAddress\":\"")
						.append(manageExpressAll.getExpressAddress())
						.append("\"").append(",").append("\"expressIcon\":\"")
						.append(manageExpressAll.getExpressIcon()).append("\"")
						.append(",").append("\"expressFee\":\"")
						.append(manageExpressAll.getExpressFee()).append("\"")
						.append(",").append("\"expressTel\":\"")
						.append(manageExpressAll.getExpressTel()).append("\"")
						.append(",").append("\"createTime\":\"")
						.append(manageExpressAll.getCreateTime()).append("\"")
						.append(",").append("\"editTime\":\"")
						.append(manageExpressAll.getEditTime()).append("\"")
						.append(",").append("\"editor\":\"")
						.append(manageExpressAll.getEditor()).append("\"")
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
					"显示manageExpressAll列表时发生错误：/manage/manageExpressAll/list",
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
	public ModelAndView add(ManageExpressAllQuery query) {
		try {
		} catch (Exception e) {
			GSLogger.error(
					"进入manageExpressAll新增页时发生错误：/manage/manageExpressAll/add",
					e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageExpressAll/add");
		return mav;
	}

	/**
	 * 保存对象
	 * 
	 * @param request
	 * @param manageExpressAll
	 * @return
	 */
	@RequestMapping(value = "save")
	public void save(HttpServletRequest request, HttpServletResponse response,
			ManageExpressAllQuery query) {
		ManageExpressAll manageExpressAll = new ManageExpressAll();
		String json = "";
		try {
			manageExpressAll.setExpressComppay(query.getExpressComppay());
			manageExpressAll.setExpressDesc(query.getExpressDesc());
			manageExpressAll.setExpressAddress(query.getExpressAddress());
			manageExpressAll.setExpressIcon(query.getExpressIcon());
			manageExpressAll.setExpressFee(query.getExpressFee());
			manageExpressAll.setExpressTel(query.getExpressTel());
			manageExpressAll.setCreateTime(query.getCreateTime());
			manageExpressAll.setEditTime(query.getEditTime());
			manageExpressAll.setEditor(query.getEditor());
			manageExpressAllService.save(manageExpressAll);
			// 保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch (Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error(
					"保存manageExpressAll信息时发生错误：/manage/manageExpressAll/save",
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
	public ModelAndView modify(ManageExpressAllQuery query) {
		ManageExpressAll manageExpressAll = new ManageExpressAll();

		try {
			manageExpressAll = manageExpressAllService.findById(query
					.getExpressId());
		} catch (Exception e) {
			GSLogger.error(
					"进入manageExpressAll修改页时发生错误：/manage/manageExpressAll/modify",
					e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageExpressAll/modify");
		mav.addObject("manageExpressAll", manageExpressAll);
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
			HttpServletResponse response, ManageExpressAllQuery query) {
		ManageExpressAll manageExpressAll = null;
		String json = "";
		try {
			manageExpressAll = manageExpressAllService.findById(query
					.getExpressId());
			manageExpressAll.setExpressComppay(query.getExpressComppay());
			manageExpressAll.setExpressDesc(query.getExpressDesc());
			manageExpressAll.setExpressAddress(query.getExpressAddress());
			manageExpressAll.setExpressIcon(query.getExpressIcon());
			manageExpressAll.setExpressFee(query.getExpressFee());
			manageExpressAll.setExpressTel(query.getExpressTel());
			manageExpressAll.setCreateTime(query.getCreateTime());
			manageExpressAll.setEditTime(query.getEditTime());
			manageExpressAll.setEditor(query.getEditor());
			manageExpressAllService.update(manageExpressAll);

			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch (Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error(
					"编辑manageExpressAll信息时发生错误：/manage/manageExpressAll/update",
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
						manageExpressAllService.delete(new Integer(ids[i]));
					}
				} else {
					manageExpressAllService.delete(new Integer(id));
				}
			}

			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		} catch (Exception e) {
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error(
					"删除ManageExpressAll时发生错误：/manage/manageExpressAll/delete",
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