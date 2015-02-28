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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.BusinessCommunity;
import com.community.app.module.bean.BusinessHelp;
import com.community.app.module.bean.BusinessHelpExpendestates;
import com.community.app.module.bean.BusinessHelpPic;
import com.community.app.module.bean.ManageEstate;
import com.community.app.module.bean.ShiroUser;
import com.community.app.module.service.BusinessCommunityService;
import com.community.app.module.service.BusinessHelpCommentService;
import com.community.app.module.service.BusinessHelpExpendestatesService;
import com.community.app.module.service.BusinessHelpPicService;
import com.community.app.module.service.BusinessHelpService;
import com.community.app.module.service.ManageEstateService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessHelpCommentQuery;
import com.community.app.module.vo.BusinessHelpQuery;
import com.community.framework.utils.CommonUtils;

@Controller
@RequestMapping("/business/businessHelp")
public class BusinessHelpController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessHelpController.class);
	@Autowired
	private BusinessHelpService businessHelpService;
	@Autowired
	private BusinessHelpCommentService businessHelpCommentService;
	@Autowired
	private BusinessHelpPicService businessHelpPicService;
	@Autowired
	private BusinessCommunityService businessCommunityService;
	@Autowired
	private ManageEstateService manageEstateService;
	@Autowired
	private BusinessHelpExpendestatesService businessHelpExpendestatesService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="list")
	public ModelAndView list(BusinessHelpQuery query) {	
		BaseBean baseBean = new BaseBean();
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			//if(!ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) {
				query.setCurUserId(shiroUser.getUserId());//社区和驿站根据小区范围数据范围不同
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
			baseBean = businessHelpService.findAllPage(query);
		}catch(Exception e){
			GSLogger.error("进入businessHelp管理页时发生错误：/business/businessHelp/list", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/help/list");
		mav.addObject("baseBean", baseBean);
		mav.addObject("pager", baseBean.getPager());
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="getPageList")
	public void getPageList(BusinessHelpQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			//if(!ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) {
				query.setCurUserId(shiroUser.getUserId());//社区和驿站根据小区范围数据范围不同
			//}			
			if(shiroUser.getCurComId() != null && shiroUser.getCurComId() != 0) {
				query.setCurComId(shiroUser.getCurComId());
			}
			if(shiroUser.getCurEstateId() != null) {
				query.setCurEstateId(shiroUser.getCurEstateId());
			}
			if(!("").equals(query.getOrderBy()) && query.getOrderBy() != null) {
				query.setSort(query.getOrderBy());
			}else{
				query.setSort("editTime");
			}
			query.setOrder("desc");
			query.setRows(12);
			BaseBean baseBean = businessHelpService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessHelp businessHelp = (BusinessHelp) baseBean.getList().get(i);
				result.append("{")
			    .append("\"helpId\":\"").append(businessHelp.getHelpId()).append("\"").append(",")
			    .append("\"helpTitle\":\"").append(businessHelp.getHelpTitle()).append("\"").append(",")
			    .append("\"helperId\":\"").append(businessHelp.getHelperId()).append("\"").append(",")
			    .append("\"helperName\":\"").append(businessHelp.getHelperName()).append("\"").append(",")
			    .append("\"helpTime\":\"").append(businessHelp.getHelpTime()).append("\"").append(",")
			    .append("\"helpContent\":\"").append(businessHelp.getHelpContent().replace("\"", "\\\"").replaceAll("(\r?\n()+)", "")).append("\"").append(",")
			    .append("\"helpType\":\"").append(businessHelp.getHelpType()).append("\"").append(",")
			    .append("\"estateId\":\"").append(businessHelp.getEstateId()).append("\"").append(",")
			    .append("\"estateName\":\"").append(businessHelp.getEstateName()).append("\"").append(",")
			    .append("\"state\":\"").append(businessHelp.getState()).append("\"").append(",")
			    .append("\"comments\":\"").append(businessHelp.getComments()).append("\"").append(",")
			    .append("\"visits\":\"").append(businessHelp.getVisits()).append("\"").append(",")
			    .append("\"supports\":\"").append(businessHelp.getSupports()).append("\"").append(",")
			    .append("\"isExpend\":\"").append(businessHelp.getIsExpend()).append("\"").append(",")
			    .append("\"expendEstates\":\"").append(businessHelp.getExpendEstates()).append("\"").append(",")
			    .append("\"lastCommentTime\":\"").append(businessHelp.getLastCommentTime()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessHelp.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessHelp.getEditTime()).append("\"").append(",")
			    .append("\"portrait\":\"").append(businessHelp.getPortrait()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessHelp.getEditor()).append("\"")
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
			GSLogger.error("显示businessHelp列表时发生错误：/business/businessHelp/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入求助详细信息页
	 * @return
	 */
	/*@RequestMapping(value="checkHelpDetail")
	public ModelAndView checkHelpDetail(BusinessHelpQuery query) {		
		BusinessHelp businessHelp = new BusinessHelp();
		List<BusinessBreakSelect> businessBreakSelectList = new ArrayList<BusinessBreakSelect>() ;
		List<BusinessBreakPic> businessBreakPicList = new ArrayList<BusinessBreakPic>() ;
		List<BusinessBreakAudio> businessBreakAudioList = new ArrayList<BusinessBreakAudio>() ;
		List<BusinessBreakComment> businessBreakCommentList = new ArrayList<BusinessBreakComment>() ;
		
		Properties p = propertiesUtil.getProperties("config.properties");
		String ip = p.getProperty("imageIp");   
		try{
			businessHelp = businessHelpService.findById(query.getHelpId());
		}catch(Exception e){
			GSLogger.error("进入businessBreak管理页时发生错误：/business/businessBreak/list", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/break/chekBreakInfo");
		mav.addObject("ip", ip);
		mav.addObject("businessHelp", businessHelp);
		mav.addObject("businessBreakSelectList", businessBreakSelectList);
		mav.addObject("businessBreakPicList", businessBreakPicList);
		mav.addObject("businessBreakAudioList", businessBreakAudioList);
		mav.addObject("businessBreakCommentList", businessBreakCommentList);
		return mav;
	}*/
	
	 /**
     * 查询求助评论信息
     * @param query
     * @param response
     */    
    @RequestMapping(value="getHelpCommentList")
	public ModelAndView getHelpCommentList(@RequestParam(value="helpId") String helpId) {
        BaseBean baseBean = new BaseBean();
        BusinessHelp businessHelp = new BusinessHelp();
        BusinessHelpCommentQuery query = new BusinessHelpCommentQuery();
        List<BusinessHelpPic> list = new ArrayList<BusinessHelpPic>();
        List<BusinessHelpExpendestates> listExpend = new ArrayList<BusinessHelpExpendestates>();
        String estateArr = "";
		try{
            int id = Integer.parseInt(helpId);
            query.setHelp(id);
            query.setRows(12);
            query.setOrder("desc");
            query.setSort("commentId");
			
            baseBean = businessHelpCommentService.findAllPage(query);
            businessHelp = businessHelpService.findById(id);
            Map paramMap = new HashMap();
            paramMap.put("helpId", id);
            list = businessHelpPicService.findByMap(paramMap);
            listExpend = businessHelpExpendestatesService.findByMap(paramMap);
            for(BusinessHelpExpendestates helpBean : listExpend) {
            	estateArr += "," + helpBean.getEstateId();
            }
        }catch(Exception e){
			GSLogger.error("进入businessNews管理页时发生错误：/business/businessHelp/comment", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/help/comment");
        mav.addObject("baseBean", baseBean);
        mav.addObject("businessHelp", businessHelp);
        mav.addObject("list", list);
        mav.addObject("listExpend", listExpend);
        mav.addObject("estateArr", estateArr);
        mav.addObject("pager", baseBean.getPager());
        
		return mav;
	}
    
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessHelpQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessHelp新增页时发生错误：/business/businessHelp/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/help/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessHelpQuery query) {
		BusinessHelp businessHelp = new BusinessHelp();
		String json = "";
		try{
		    businessHelp.setHelpTitle(query.getHelpTitle());
		    businessHelp.setHelperId(query.getHelperId());
		    businessHelp.setHelperName(query.getHelperName());

		    businessHelp.setHelpContent(query.getHelpContent());
		    businessHelp.setHelpType(query.getHelpType());
		    businessHelp.setEstateId(query.getEstateId());
		    businessHelp.setEstateName(query.getEstateName());
		    businessHelp.setState(0);//未回复
		    businessHelp.setVisits(0);
		    businessHelp.setSupports(0);
		    businessHelp.setIsExpend(query.getIsExpend());
		    businessHelp.setExpendEstates(query.getExpendEstates());
		    businessHelp.setCreateTime(new Timestamp(System.currentTimeMillis()));
		    businessHelp.setEditTime(new Timestamp(System.currentTimeMillis()));
		    businessHelp.setEditor(getUser().getUserName());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessHelp.setCreateTime(ts);
	        businessHelp.setEditTime(ts);
            businessHelp.setHelpTime(ts);
            // String scopeString = request.getParameter("scope");
            /*if(!"".equals(scopeString)) {
                //可取到 小区 楼栋和单元
                String[] rows = scopeString.split("\\,");
                Set cellidList = new HashSet();

                for(String row : rows) {
                    String estateId = "";
                    String[] attrs = row.split("\\&");
                    for (String attr : attrs) {
                        String[] values = attr.split("\\|");
                        String param_id = ((values[0]).split("\\_"))[1]; //id
                        //小区
                        if (attr.indexOf("eatate") == 0) {
                            estateId = param_id; //小区ID
                            cellidList.add(estateId);
                        }
                    }
                }
                if(cellidList.size() > 0) { //如果小区ID不为空，那么为求扩散
                    businessHelp.setIsExpend(1); //1 为求扩散
                    String cellIdString = listToString(cellidList);
                    businessHelp.setExpendEstates(cellIdString); //小区ID集合
                }
            }*/

			businessHelpService.save(businessHelp);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessHelp信息时发生错误：/business/businessHelp/save", e);
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
	public ModelAndView modify(BusinessHelpQuery query) {	
		BusinessHelp businessHelp=new BusinessHelp();
		
		try{
			businessHelp = businessHelpService.findById(query.getHelpId());
		}catch(Exception e){
			GSLogger.error("进入businessHelp修改页时发生错误：/business/businessHelp/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessHelp/modify");
		mav.addObject("businessHelp", businessHelp);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessHelpQuery query) {
		BusinessHelp businessHelp = null;
		String json = "";
		try{
		    businessHelp = businessHelpService.findById(query.getHelpId());
		    businessHelp.setHelpTitle(query.getHelpTitle());
		    businessHelp.setHelperId(query.getHelperId());
		    businessHelp.setHelperName(query.getHelperName());

		    businessHelp.setHelpContent(query.getHelpContent());
		    businessHelp.setHelpType(query.getHelpType());
		    businessHelp.setEstateId(query.getEstateId());
		    businessHelp.setEstateName(query.getEstateName());
		    businessHelp.setIsExpend(query.getIsExpend());
		    businessHelp.setExpendEstates(query.getExpendEstates());
		    businessHelp.setEditTime(new Timestamp(System.currentTimeMillis()));
		    businessHelp.setEditor(getUser().getUserName());
			businessHelpService.update(businessHelp);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessHelp信息时发生错误：/business/businessHelp/update", e);
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
						businessHelpService.delete(new Integer(ids[i]));
					}
				}else{
					businessHelpService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessHelp时发生错误：/business/businessHelp/delete", e);
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
	 * 获取用户要扩散到的所有社区下的小区列表 - 驿站发布求助
	 * @param response
	 */
	@RequestMapping(value="getExpendScopeTree")
	public void getExpendScopeTree(HttpServletRequest request, HttpServletResponse response) {
		JSONObject jsonObj = new JSONObject();
		JSONArray comArr = new JSONArray();
		String helpArray = request.getParameter("helpArray").substring(1);
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			String orgType = "";
			if(shiroUser.getCurOrgType().equals("") || shiroUser.getCurOrgType() == null) {
				orgType = shiroUser.getOrgType();
			} else {
				orgType = shiroUser.getCurOrgType();
			}
			//if(ModuleConst.STATION_CODE.equals(orgType)) {//驿站
				List comList = businessCommunityService.findAll();
				JSONObject comObj = null;
				Map paramMap = null;
				for(int i=0;i<comList.size();i++) {
					BusinessCommunity community = (BusinessCommunity) comList.get(i);
					comObj = new JSONObject();
					comObj.put("id", "com_"+community.getComId());
					comObj.put("text", community.getComName());
					paramMap = new HashMap();
					paramMap.put("comId", community.getComId());
					List estateList = manageEstateService.findByMap(paramMap);
					JSONArray estateArr = new JSONArray();
					for(int j=0;j<estateList.size();j++) {
						ManageEstate estate = (ManageEstate) estateList.get(j);
						JSONObject estateObj = new JSONObject();
						if(!helpArray.contains(String.valueOf(estate.getEstateId()))) {
							estateObj.put("id", "eatate_"+estate.getEstateId());
							estateObj.put("text", estate.getEstateName());
							estateObj.put("checkbox", true);
							estateObj.put("state", "close");
							estateArr.add(estateObj);
						}
					}
					comObj.put("children", estateArr);
					comArr.add(comObj);
				}
			//}
			jsonObj.put("success", true);
			jsonObj.put("result", comArr);
		}catch(Exception e){
			jsonObj.put("success", false);
			jsonObj.put("message", "获取失败");
			GSLogger.error("获取用户要扩散到的所有社区下的小区列表：/business/businessHelp/getExpendScopeTree", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(jsonObj.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}