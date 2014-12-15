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

import com.community.app.module.bean.BusinessAddress;
import com.community.app.module.service.BusinessAddressService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessAddressQuery;

@Controller
@RequestMapping("/business/businessAddress")
public class BusinessAddressController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessAddressController.class);
	@Autowired
	private BusinessAddressService businessAddressService;

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
					"进入businessAddress管理页时发生错误：/business/businessAddress/enter",
					e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessAddress/enter");
		return mav;
	}

	/**
	 * 列示或者查询所有数据
	 * 
	 * @return
	 */
	@RequestMapping(value = "list")
	public void list(BusinessAddressQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try {
			BaseBean baseBean = businessAddressService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount())
					.append(",").append("\"rows\":[");
			for (int i = 0; i < baseBean.getList().size(); i++) {
				BusinessAddress businessAddress = (BusinessAddress) baseBean
						.getList().get(i);
				result.append("{").append("\"addrId\":\"")
						.append(businessAddress.getAddrId()).append("\"")
						.append(",").append("\"contacts\":\"")
						.append(businessAddress.getContacts()).append("\"")
						.append(",").append("\"mobile\":\"")
						.append(businessAddress.getMobile()).append("\"")
						.append(",").append("\"address\":\"")
						.append(businessAddress.getAddress()).append("\"")
						.append(",").append("\"createTime\":\"")
						.append(businessAddress.getCreateTime()).append("\"")
						.append(",").append("\"editTime\":\"")
						.append(businessAddress.getEditTime()).append("\"")
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
			GSLogger.error("显示businessAddress列表时发生错误：/business/businessAddress/list", e);
			e.printStackTrace();
		}
	}
	
	 /**
     * 查询收件人信息
     * @param query
     * @param response
     */
    @RequestMapping(value="getAddressDetail")
    public void getAddressDetail(BusinessAddressQuery query, HttpServletResponse response) {
        try{
        	BusinessAddress businessAddress = businessAddressService.findById(query.getAddrId());
        	JSONObject jsons= JSONObject.fromObject(businessAddress);
        	
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
	 * 
	 * @return
	 */
	@RequestMapping(value = "add")
	public ModelAndView add(BusinessAddressQuery query) {
		try {
		} catch (Exception e) {
			GSLogger.error(
					"进入businessAddress新增页时发生错误：/business/businessAddress/add",
					e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessAddress/add");
		return mav;
	}

	/**
	 * 保存对象
	 * 
	 * @param request
	 * @param businessAddress
	 * @return
	 */
	@RequestMapping(value = "save")
	public void save(HttpServletRequest request, HttpServletResponse response,
			BusinessAddressQuery query) {
		BusinessAddress businessAddress = new BusinessAddress();
		String json = "";
		try {
			businessAddress.setContacts(query.getContacts());
			businessAddress.setMobile(query.getMobile());
			businessAddress.setAddress(query.getAddress());
			businessAddress.setCreateTime(query.getCreateTime());
			businessAddress.setEditTime(query.getEditTime());
			businessAddressService.save(businessAddress);
			// 保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch (Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error(
					"保存businessAddress信息时发生错误：/business/businessAddress/save",
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
	public ModelAndView modify(BusinessAddressQuery query) {
		BusinessAddress businessAddress = new BusinessAddress();

		try {
			businessAddress = businessAddressService
					.findById(query.getAddrId());
		} catch (Exception e) {
			GSLogger.error(
					"进入businessAddress修改页时发生错误：/business/businessAddress/modify",
					e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessAddress/modify");
		mav.addObject("businessAddress", businessAddress);
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
			HttpServletResponse response, BusinessAddressQuery query) {
		BusinessAddress businessAddress = null;
		String json = "";
		try {
			businessAddress = businessAddressService
					.findById(query.getAddrId());
			businessAddress.setContacts(query.getContacts());
			businessAddress.setMobile(query.getMobile());
			businessAddress.setAddress(query.getAddress());
			businessAddress.setCreateTime(query.getCreateTime());
			businessAddress.setEditTime(query.getEditTime());
			businessAddressService.update(businessAddress);

			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch (Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error(
					"编辑businessAddress信息时发生错误：/business/businessAddress/update",
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
						businessAddressService.delete(new Integer(ids[i]));
					}
				} else {
					businessAddressService.delete(new Integer(id));
				}
			}

			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		} catch (Exception e) {
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error(
					"删除BusinessAddress时发生错误：/business/businessAddress/delete",
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