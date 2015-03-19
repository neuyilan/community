package com.community.app.module.controller;

import static com.community.framework.utils.CommonUtils.getUser;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.bean.AppUser;
import com.community.app.module.bean.BusinessRepair;
import com.community.app.module.bean.BusinessRepairComment;
import com.community.app.module.bean.MemberVO;
import com.community.app.module.bean.ShiroUser;
import com.community.app.module.dao.BusinessRepairCommentDao;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.AppUserService;
import com.community.app.module.service.BusinessRepairCommentService;
import com.community.app.module.service.BusinessRepairReplyService;
import com.community.app.module.service.BusinessRepairService;
import com.community.app.module.vo.AppLatestNewsQuery;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessRepairQuery;
import com.community.framework.utils.CommonUtils;
import com.community.framework.utils.JsonUtils;
import com.community.framework.utils.propertiesUtil;

@Controller
@RequestMapping("/business/businessRepair")
public class BusinessRepairController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessRepairController.class);
	@Autowired
	private BusinessRepairService businessRepairService;
	@Autowired
	private BusinessRepairReplyService businessRepairReplyService;
    @Autowired
	private AppUserService appUserService;
    @Autowired
	private BusinessRepairCommentService businessRepairCommentService;
    @Autowired
 	private BusinessRepairCommentDao businessRepairCommentDao;
    @Autowired
	private AppLatestNewsService appLatestNewsService;
    
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="list")
	public ModelAndView list(BusinessRepairQuery query) {		
		BaseBean baseBean = new BaseBean();
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			//if(!ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) {
				query.setCurUserId(shiroUser.getUserId());
			//}			
			if(shiroUser.getCurEstateId() != null) {
				query.setCurEstateId(shiroUser.getCurEstateId());
			}
			if(shiroUser.getCurComId() != null && shiroUser.getCurComId() != 0) {
				query.setCurComId(shiroUser.getCurComId());
			}
			query.setSort("editTime");
			query.setOrder("desc");
			query.setRows(12);
			baseBean = businessRepairService.findAllPage(query);
		}catch(Exception e){
			GSLogger.error("进入businessRepair管理页时发生错误：/business/businessRepair/list", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/repair/list");
		baseBean.setRows(12);
		mav.addObject("baseBean", baseBean);
		mav.addObject("pager", baseBean.getPager());
		mav.addObject("repairState", query.getRepairState());
		return mav;
	}

    /**
     * 查看详情页
     * @param query
     * @return
     */
    @RequestMapping(value="getDetails")
    public ModelAndView getDetails(HttpServletRequest request, BusinessRepairQuery query) {
        BusinessRepair obj = businessRepairService.findById(query.getRepairId());
        Properties p = propertiesUtil.getProperties("config.properties");
		String ip = p.getProperty("imageIp");   
		String isNew = request.getParameter("isNew");
        //获取app端用户信息
        MemberVO userVO = appUserService.getAppUserInfo(query.getReporterId());
        Map map = new HashMap();
        map.put("repairId", query.getRepairId());
        List list = businessRepairCommentService.findByMap(map);
        
        //如果有新消息则删除消息
        if(isNew != null && new Integer(isNew) == 1) {
        	AppLatestNewsQuery newsQuery = new AppLatestNewsQuery();
        	newsQuery.setTypeId(37);//报修
        	newsQuery.setSourceId(query.getRepairId());
        	newsQuery.setTo(1);//居民向后台发送
        	appLatestNewsService.deleteByCondition(newsQuery);
        }
        
        ModelAndView mav = new ModelAndView("/module/repair/details");
        mav.addObject("ip", ip);
        mav.addObject("obj", obj);
        mav.addObject("userVO", userVO);
        mav.addObject("replyList", list);
        
        return mav;
    }

    /**
     * 报修次数
     * @param query
     * @return
     */
    @RequestMapping(value = "getRepairtCount")
    public @ResponseBody String getRepairtCount(BusinessRepairQuery query) {
        Map map = new HashMap();
        map.put("reporterId", query.getReporterId()); //报修人
        List list = new ArrayList();
        list = businessRepairService.findByMap(map);
        String count = String.valueOf(list.size());
        return count;
    }

    /**
     * 报修信息
     * @param query
     */
    @RequestMapping(value = "getRepairtInfoByUser")
    public void getRepairtInfoByUser(BusinessRepairQuery query, HttpServletResponse response) {
        Map map = new HashMap();
        map.put("reporterId", query.getReporterId()); //报修人
        List list = new ArrayList();
        list = businessRepairService.findByMap(map);
        StringBuilder result = new StringBuilder("");
        String json = "";
        result.append("[");
        for(int i=0;i<list.size();i++) {
            BusinessRepair businessRepair = (BusinessRepair)list.get(i);
            result.append("{")
                    .append("\"repairId\":\"").append(businessRepair.getRepairId()).append("\"").append(",")
                    .append("\"reporterId\":\"").append(businessRepair.getReporterId()).append("\"").append(",")
                    .append("\"repairTime\":\"").append(businessRepair.getRepairTime()).append("\"").append(",")
                    .append("\"repairContent\":\"").append(businessRepair.getRepairContent().replace("\"", "\\\"").replaceAll("(\r?\n()+)", "")).append("\"").append(",")
                    .append("\"repairType\":\"").append(businessRepair.getRepairType()).append("\"").append(",")
                    .append("\"repairState\":\"").append(businessRepair.getRepairState()).append("\"").append(",")
                    .append("\"repairScore\":\"").append(businessRepair.getRepairScore()).append("\"").append(",")
                    .append("\"newReplies\":\"").append(businessRepair.getNewReplies()).append("\"").append(",")
                    .append("\"receiverId\":\"").append(businessRepair.getReceiverId()).append("\"").append(",")
                    .append("\"receiverName\":\"").append(businessRepair.getReceiverName()).append("\"").append(",")
                    .append("\"receiveAvatar\":\"").append(businessRepair.getReceiveAvatar()).append("\"").append(",")
                    .append("\"receiveDate\":\"").append(businessRepair.getReceiveDate()).append("\"").append(",")
                    .append("\"createTime\":\"").append(businessRepair.getCreateTime()).append("\"").append(",")
                    .append("\"editTime\":\"").append(businessRepair.getEditTime()).append("\"").append(",")
                    .append("\"editor\":\"").append(businessRepair.getEditor()).append("\"")
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
    }
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="getPageList")
	public void getPageList(BusinessRepairQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			//if(!ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) {
				query.setCurUserId(shiroUser.getUserId());
			//}			
			if(shiroUser.getCurEstateId() != null) {
				query.setCurEstateId(shiroUser.getCurEstateId());
			}
			if(shiroUser.getCurComId() != null && shiroUser.getCurComId() != 0) {
				query.setCurComId(shiroUser.getCurComId());
			}
			query.setOrder("desc");
			query.setRows(12);
			if(!("").equals(query.getOrderBy()) && query.getOrderBy() != null) {
				query.setSort(query.getOrderBy());
			}else{
				query.setSort("editTime");
			}
			BaseBean baseBean = businessRepairService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessRepair businessRepair = (BusinessRepair) baseBean.getList().get(i);
				result.append("{")
			    .append("\"repairId\":\"").append(businessRepair.getRepairId()).append("\"").append(",")
			    .append("\"reporterId\":\"").append(businessRepair.getReporterId()).append("\"").append(",")
			    .append("\"repairTime\":\"").append(businessRepair.getRepairTime()).append("\"").append(",")
			    .append("\"repairContent\":\"").append(businessRepair.getRepairContent()).append("\"").append(",")
			    .append("\"repairType\":\"").append(businessRepair.getRepairType()).append("\"").append(",")
			    .append("\"repairState\":\"").append(businessRepair.getRepairState()).append("\"").append(",")
			    .append("\"repairScore\":\"").append(businessRepair.getRepairScore()).append("\"").append(",")
			    
			    .append("\"repairReplies\":\"").append(businessRepair.getRepairReplies()).append("\"").append(",")
			    .append("\"reporterName\":\"").append(businessRepair.getReporterName()).append("\"").append(",")
			    .append("\"lastCommentTime\":\"").append(businessRepair.getLastCommentTime()).append("\"").append(",")
			    .append("\"typeId\":\"").append(businessRepair.getTypeId()).append("\"").append(",")
			    
			    .append("\"estateId\":\"").append(businessRepair.getEstateId()).append("\"").append(",")
			    .append("\"estateName\":\"").append(businessRepair.getEstateName()).append("\"").append(",")
			    .append("\"portrait\":\"").append(businessRepair.getPortrait()).append("\"").append(",")
			    .append("\"address\":\"").append(businessRepair.getAddress()).append("\"").append(",")
			    .append("\"newsCount\":\"").append(businessRepair.getNewsCount()).append("\"").append(",")
			    .append("\"newReplies\":\"").append(businessRepair.getNewReplies()).append("\"").append(",")
			    .append("\"receiverId\":\"").append(businessRepair.getReceiverId()).append("\"").append(",")
			    .append("\"receiverName\":\"").append(businessRepair.getReceiverName()).append("\"").append(",")
			    .append("\"receiveAvatar\":\"").append(businessRepair.getReceiveAvatar()).append("\"").append(",")
			    .append("\"receiveDate\":\"").append(businessRepair.getReceiveDate()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessRepair.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessRepair.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessRepair.getEditor()).append("\"")
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
			GSLogger.error("显示businessRepair列表时发生错误：/business/businessRepair/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessRepairQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessRepair新增页时发生错误：/business/businessRepair/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRepair/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessRepairQuery query) {
		BusinessRepair businessRepair = new BusinessRepair();
		String json = "";
		try{
		    businessRepair.setReporterId(query.getReporterId());
		    businessRepair.setRepairContent(query.getRepairContent());
		    businessRepair.setRepairType(query.getRepairType());
		    businessRepair.setRepairState(query.getRepairState());
		    businessRepair.setRepairScore(query.getRepairScore());
		    businessRepair.setNewReplies(query.getNewReplies());
		    businessRepair.setReceiverId(query.getReceiverId());
		    businessRepair.setReceiverName(query.getReceiverName());
		    businessRepair.setReceiveAvatar(query.getReceiveAvatar());
		    businessRepair.setReceiveDate(query.getReceiveDate());
		    businessRepair.setEditor(query.getEditor());
	        businessRepair.setCreateTime(new Timestamp(new Date().getTime()));
	        businessRepair.setEditTime(new Timestamp(new Date().getTime()));
			businessRepairService.save(businessRepair);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessRepair信息时发生错误：/business/businessRepair/save", e);
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
	public ModelAndView modify(BusinessRepairQuery query) {	
		BusinessRepair businessRepair=new BusinessRepair();
		
		try{
			businessRepair = businessRepairService.findById(query.getRepairId());
		}catch(Exception e){
			GSLogger.error("进入businessRepair修改页时发生错误：/business/businessRepair/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRepair/modify");
		mav.addObject("businessRepair", businessRepair);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessRepairQuery query) {
		BusinessRepair businessRepair = null;
		String json = "";
		try{
		    businessRepair = businessRepairService.findById(query.getRepairId());
		    businessRepair.setReporterId(query.getReporterId());
		    businessRepair.setRepairContent(query.getRepairContent());
		    businessRepair.setRepairType(query.getRepairType());
		    businessRepair.setRepairState(query.getRepairState());
		    businessRepair.setRepairScore(query.getRepairScore());
		    businessRepair.setNewReplies(query.getNewReplies());
		    businessRepair.setReceiverId(query.getReceiverId());
		    businessRepair.setReceiverName(query.getReceiverName());
		    businessRepair.setReceiveAvatar(query.getReceiveAvatar());
		    businessRepair.setReceiveDate(query.getReceiveDate());
		    businessRepair.setEditor(query.getEditor());
		    businessRepair.setEditTime(new Timestamp(new Date().getTime()));
			businessRepairService.update(businessRepair);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessRepair信息时发生错误：/business/businessRepair/update", e);
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
						businessRepairService.delete(new Integer(ids[i]));
					}
				}else{
					businessRepairService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessRepair时发生错误：/business/businessRepair/delete", e);
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

    //维修完成
    @RequestMapping(value = "repairFinish")
    public void repairFinish(HttpServletResponse response,BusinessRepair query) {
        String json = "";
        try{
        	Timestamp  ts=new Timestamp(new Date().getTime());
            query.setRepairState(4);  //已解决
            query.setReceiverId(getUser().getUserId());
            query.setReceiverName(getUser().getUserName());
            query.setEditTime(ts);
            businessRepairService.update(query);
            
            //改变报修居民的状态为验证类型居民
            AppUser appUser = new AppUser();
            appUser.setUserId(query.getReporterId());
            appUser.setType(1);//验证居民
            appUser.setVerifyTime(ts);
            appUser.setVerifier(getUser().getUserName());
            appUserService.update(appUser);
            
            BusinessRepairComment businessRepairComment = new BusinessRepairComment();
            businessRepairComment.setRepairId(query.getRepairId());
            businessRepairComment.setContentType(0);
            businessRepairComment.setCommentorId(getUser().getUserId());
            businessRepairComment.setCommentorName(getUser().getUserName());
            businessRepairComment.setComment("您好，请您对我本次提供的服务整体表现做出评价！");
            businessRepairComment.setCommentTime(ts);
            businessRepairComment.setVideoSize(0);
            businessRepairComment.setTo(1);
		    businessRepairCommentDao.save_manage(businessRepairComment);
		    
		    AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(query.getReporterId());
			appLatestNews.setTypeId(32);
			appLatestNews.setSourceId(query.getRepairId());
			appLatestNews.setTo(0);
			appLatestNews.setEstateId(0);
			appLatestNewsService.save_app(appLatestNews);
			appLatestNews.setTypeId(31);
			appLatestNewsService.save_app(appLatestNews);
			appLatestNews.setTypeId(30);
			appLatestNewsService.save_app(appLatestNews);
            json = "{\"success\":\"true\",\"message\":\"维修成功\"}";
        }catch(Exception e){
            json = "{\"success\":\"false\",\"message\":\"维修失败\"}";
            GSLogger.error("删除BusinessRepair时发生错误：/business/businessRepair/delete", e);
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