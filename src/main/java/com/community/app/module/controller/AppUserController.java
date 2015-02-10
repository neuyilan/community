package com.community.app.module.controller;

import static com.community.framework.utils.CommonUtils.getFomatDate;

import java.io.IOException;
import java.sql.Timestamp;
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

import com.community.app.module.bean.AppUser;
import com.community.app.module.bean.MemberVO;
import com.community.app.module.bean.ShiroUser;
import com.community.app.module.common.ModuleConst;
import com.community.app.module.service.AppUserService;
import com.community.app.module.service.BusinessCommunityService;
import com.community.app.module.service.BusinessUserPropertyComService;
import com.community.app.module.vo.AppUserQuery;
import com.community.app.module.vo.BaseBean;
import com.community.framework.utils.CommonUtils;

@Controller
@RequestMapping("/app/appUser")
public class AppUserController {
	private static Logger GSLogger = LoggerFactory.getLogger(AppUserController.class);
	@Autowired
	private AppUserService appUserService;
	@Autowired
	private BusinessUserPropertyComService businessUserPropertyComService;
    @Autowired
    private BusinessCommunityService businessCommunityService;
    
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="list")
	public ModelAndView list(AppUserQuery query) {	
		BaseBean baseBean = new BaseBean();
		ModelAndView mav = null;
		List comList = null;
		ShiroUser shiroUser = CommonUtils.getUser();
		try{
			if(ModuleConst.PROPERTY_CODE.equals(shiroUser.getOrgType())) {//物业人员访问 
				query.setCurUserId(shiroUser.getUserId());
				//query.setOrgType(ModuleConst.PROPERTY_CODE);
			}//运营人员 看到全部小区
			if(shiroUser.getCurEstateId() != null && shiroUser.getCurEstateId() != 0) {
				query.setCurEstateId(shiroUser.getCurEstateId());
			}
			query.setSort("registTime");
			query.setOrder("desc");
			query.setRows(12);
			baseBean = appUserService.findAllPage(query);
			baseBean.setRows(12);
			mav = new ModelAndView("/module/appUser/list");
			if(ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType()) && ("".equals(shiroUser.getCurOrgType()) || ModuleConst.OPERATION_CODE.equals(shiroUser.getCurOrgType()))) {
				comList = businessCommunityService.findAll();
				mav.addObject("orgType", shiroUser.getOrgType());
				mav.addObject("comList", comList);
			}
			mav.addObject("baseBean", baseBean);
			mav.addObject("pager", baseBean.getPager());
			mav.addObject("type", query.getType());
			mav.addObject("timeScope", query.getTimeScope());
			mav.addObject("dateField", query.getDateField());
		}catch(Exception e){
			GSLogger.error("进入appUser管理页时发生错误：/app/appUser/enter", e);
			e.printStackTrace();
		}
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="getPageList")
	public void getPageList(AppUserQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			if(ModuleConst.PROPERTY_CODE.equals(shiroUser.getOrgType())) {//物业人员访问 
				query.setCurUserId(shiroUser.getUserId());
				//query.setOrgType(ModuleConst.PROPERTY_CODE);
			}//运营人员 看到全部小区
			if(shiroUser.getCurEstateId() != null && shiroUser.getCurEstateId() != 0) {
				query.setCurEstateId(shiroUser.getCurEstateId());
			}
			if(!("").equals(query.getOrderBy()) && query.getOrderBy() != null) {
				query.setSort(query.getOrderBy());
			}else{
				query.setSort("registTime");
			}
			query.setOrder("desc");
			query.setRows(12);
			BaseBean baseBean = appUserService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				AppUser appUser = (AppUser) baseBean.getList().get(i);
				result.append("{")
			    .append("\"userId\":\"").append(appUser.getUserId()).append("\"").append(",")
			    .append("\"realname\":\"").append(appUser.getRealname()).append("\"").append(",")
			    .append("\"nickname\":\"").append(appUser.getNickname()).append("\"").append(",")
			    .append("\"password\":\"").append(appUser.getPassword()).append("\"").append(",")
			    .append("\"tel\":\"").append(appUser.getTel()).append("\"").append(",")
			    .append("\"sex\":\"").append(appUser.getSex()).append("\"").append(",")
			    .append("\"birthday\":\"").append(appUser.getBirthday()).append("\"").append(",")
			    .append("\"type\":\"").append(appUser.getType()).append("\"").append(",")
			    .append("\"state\":\"").append(appUser.getState()).append("\"").append(",")
			    .append("\"workerMemo\":\"").append(appUser.getWorkerMemo()).append("\"").append(",")
			    .append("\"dimensionCode\":\"").append(appUser.getDimensionCode()).append("\"").append(",")
			    .append("\"homeAttr\":\"").append(appUser.getHomeAttr()).append("\"").append(",")
			    .append("\"familyId\":\"").append(appUser.getFamilyId()).append("\"").append(",")
			    .append("\"lastLoginTime\":\"").append(appUser.getLastLoginTime()).append("\"").append(",")
			    
			    .append("\"address\":\"").append(appUser.getAddress()).append("\"").append(",")
			    .append("\"estateName\":\"").append(appUser.getEstateName()).append("\"").append(",")
			    
			    .append("\"random\":\"").append(appUser.getRandom()).append("\"").append(",")
			    .append("\"registTime\":\"").append(appUser.getRegistTime()).append("\"").append(",")
			    .append("\"verifyTime\":\"").append(appUser.getVerifyTime()).append("\"").append(",")
			    .append("\"verifier\":\"").append(appUser.getVerifier()).append("\"").append(",")
			    .append("\"portrait\":\"").append(appUser.getPortrait()).append("\"").append(",")
			    .append("\"idCard\":\"").append(appUser.getIdCard()).append("\"").append(",")
			    .append("\"estateId\":\"").append(appUser.getEstateId()).append("\"").append(",")
			    .append("\"createTime\":\"").append(appUser.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(appUser.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(appUser.getEditor()).append("\"")
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
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示appUser列表时发生错误：/app/appUser/getPageList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(AppUserQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入appUser新增页时发生错误：/app/appUser/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appUser/add");
		return mav;
	}

	/**
	 * 查询用户详情
	 * @return
	 */
	@RequestMapping(value="getUserDetail")
	public void getUserDetail(AppUserQuery query, HttpServletResponse response) {
		try{
            StringBuilder result = new StringBuilder("");

//            MemberVO appUser = appUserService.getAppUserInfo(query.getUserId());
            
            Map<String, Object> con = new HashMap<String, Object>();
            con.put("userId", query.getUserId());
            con.put("estateId", query.getEstateId()); 
            MemberVO appUser = appUserService.findByCon(con);
            
            Date date = appUser.getBirthday();
            String birthday = "";
            if(date != null) {
                birthday = getFomatDate(date);
            }
                    result.append("{")
                    .append("\"userId\":\"").append(appUser.getUserId()).append("\"").append(",")
                    .append("\"realname\":\"").append(appUser.getRealname()).append("\"").append(",")
                    .append("\"nickname\":\"").append(appUser.getNickname()).append("\"").append(",")
                    .append("\"tel\":\"").append(appUser.getTel()).append("\"").append(",")
                    .append("\"sex\":\"").append(appUser.getSex()).append("\"").append(",")
                    .append("\"birthday\":\"").append(birthday).append("\"").append(",")
                    .append("\"type\":\"").append(appUser.getType()).append("\"").append(",")
                    .append("\"isWorker\":\"").append(appUser.getIsWorker()).append("\"").append(",")
                    .append("\"state\":\"").append(appUser.getState()).append("\"").append(",")
                    .append("\"random\":\"").append(appUser.getRandom()).append("\"").append(",")
                    .append("\"registTime\":\"").append(appUser.getRegistTime() == null ?"":appUser.getRegistTime()).append("\"").append(",")
                    .append("\"verifyTime\":\"").append(appUser.getVerifyTime() == null ?"":appUser.getVerifyTime()).append("\"").append(",")
                    .append("\"verifier\":\"").append(appUser.getVerifier()).append("\"").append(",")
                    .append("\"signature\":\"").append(appUser.getSignature()).append("\"").append(",")
                    .append("\"portrait\":\"").append(appUser.getPortrait()).append("\"").append(",")
                    .append("\"idCard\":\"").append(appUser.getIdCard()).append("\"").append(",")
                    .append("\"estateId\":\"").append(appUser.getEstateId()).append("\"").append(",")
                    .append("\"isNameSecret\":\"").append(appUser.getIsNameSecret()).append("\"").append(",")
                    .append("\"isTelSecret\":\"").append(appUser.getIsTelSecret()).append("\"").append(",")
                    .append("\"workerMemo\":\"").append(appUser.getWorkerMemo()).append("\"").append(",")
                    .append("\"weixin\":\"").append(appUser.getWeixin()).append("\"").append(",")
                    .append("\"createTime\":\"").append(appUser.getCreateTime()).append("\"").append(",")
                    .append("\"editTime\":\"").append(appUser.getEditTime()).append("\"").append(",")
                    .append("\"editor\":\"").append(appUser.getEditor()).append("\"").append(",")
                    .append("\"oftenestate\":\"").append(appUser.getOftenestate()).append("\"").append(",")
                    .append("\"boundphone\":\"").append(appUser.getBoundphone()).append("\"").append(",")
                    .append("\"estateName\":\"").append(appUser.getEstateName()).append("\"").append(",")
                    .append("\"buildingName\":\"").append(appUser.getBuildingName()).append("\"").append(",")
                    .append("\"unitName\":\"").append(appUser.getUnitName()).append("\"").append(",")
                    .append("\"houseNo\":\"").append(appUser.getHouseNo()).append("\"").append(",")
                    .append("\"staName\":\"").append(appUser.getStaName()).append("\"").append(",")
                    .append("\"remarks\":\"").append(appUser.getRemarks()).append("\"")
                    .append("}");
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("utf-8");
            try {
                response.getWriter().write(result.toString());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		}catch(Exception e){
			GSLogger.error("进入appUser新增页时发生错误：/app/appUser/getUserDetail", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 备注居民信息对象
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="updateRemarks")
	public void updateRemarks(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="id") String id, @RequestParam(value="remarks") String remarks) {
		AppUserQuery query = new AppUserQuery();
		query.setUserId(Integer.parseInt(id));
		AppUser appUser = appUserService.findById(query.getUserId());
		String json = "";
		try{
			appUser.setRemarks(remarks);
		    appUserService.updateRemarks(appUser);
			json = "{\"success\":\"true\",\"message\":\"备注居民信息成功\"}"; 
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"备注居民信息失败\"}";
			GSLogger.error("进入appUser新增页时发生错误：/app/appUser/getUserDetail", e);
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
     * 查询用户详情
     * @return
     */
    @RequestMapping(value="getAppUserInfoByTel")
    public void getAppUserInfoByTel(AppUserQuery query, HttpServletResponse response) {
        try{
            StringBuilder result = new StringBuilder("");
            MemberVO memberVO = new MemberVO();
            memberVO.setTel(query.getTel());
            MemberVO appUser = appUserService.getAppUserInfoByTel(memberVO);
            if(appUser != null) {
            	
                result.append("{")
                		.append("\"success\":\"").append("true").append("\"").append(",")
                        .append("\"userId\":\"").append(appUser.getUserId()).append("\"").append(",")
                        .append("\"realname\":\"").append(appUser.getRealname()).append("\"").append(",")
                        .append("\"nickname\":\"").append(appUser.getNickname()).append("\"").append(",")
                        .append("\"boundphone\":\"").append(appUser.getBoundphone()).append("\"").append(",")
                        .append("\"portrait\":\"").append(appUser.getPortrait()).append("\"").append(",")
                        .append("\"estateName\":\"").append(appUser.getEstateName()).append("\"").append(",")
                        .append("\"buildingName\":\"").append(appUser.getBuildingName()).append("\"").append(",")
                        .append("\"unitName\":\"").append(appUser.getUnitName()).append("\"").append(",")
                        .append("\"houseNo\":\"").append(appUser.getHouseNo()).append("\"").append(",")
                        .append("\"tel\":\"").append(appUser.getTel()).append("\"").append(",")
                        .append("\"sex\":\"").append(appUser.getSex()).append("\"").append(",")
                        .append("\"type\":\"").append(appUser.getType()).append("\"").append(",")
                        .append("\"isWorker\":\"").append(appUser.getIsWorker()).append("\"").append(",")
                        .append("\"state\":\"").append(appUser.getState()).append("\"").append(",")
                        .append("\"random\":\"").append(appUser.getRandom()).append("\"").append(",")
                        .append("\"registTime\":\"").append(appUser.getRegistTime() == null ?"":appUser.getRegistTime()).append("\"").append(",")
                        .append("\"verifyTime\":\"").append(appUser.getVerifyTime() == null ?"":appUser.getVerifyTime()).append("\"").append(",")
                        .append("\"verifier\":\"").append(appUser.getVerifier()).append("\"").append(",")
                        .append("\"signature\":\"").append(appUser.getSignature()).append("\"").append(",")
                        .append("\"idCard\":\"").append(appUser.getIdCard()).append("\"").append(",")
                        .append("\"estateId\":\"").append(appUser.getEstateId()).append("\"").append(",")
                        .append("\"comId\":\"").append(appUser.getComId()).append("\"").append(",")
                        .append("\"isNameSecret\":\"").append(appUser.getIsNameSecret()).append("\"").append(",")
                        .append("\"isTelSecret\":\"").append(appUser.getIsTelSecret()).append("\"").append(",")
                        .append("\"workerMemo\":\"").append(appUser.getWorkerMemo()).append("\"").append(",")
                        .append("\"weixin\":\"").append(appUser.getWeixin()).append("\"").append(",")
                        .append("\"createTime\":\"").append(appUser.getCreateTime()).append("\"").append(",")
                        .append("\"editTime\":\"").append(appUser.getEditTime()).append("\"").append(",")
                        .append("\"editor\":\"").append(appUser.getEditor()).append("\"").append(",")
                        .append("\"oftenestate\":\"").append(appUser.getOftenestate()).append("\"").append(",")
                        .append("\"staName\":\"").append(appUser.getStaName()).append("\"")
                        .append("}");
            }else{
            	result.append("{")
        		.append("\"success\":\"").append("false").append("\"")
        		.append("}");
            }
            
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("utf-8");
            try {
                response.getWriter().write(result.toString());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }catch(Exception e){
            GSLogger.error("进入appUser新增页时发生错误：/app/appUser/getUserDetail", e);
            e.printStackTrace();
        }
    }
	
	/**
	 * 保存对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, AppUserQuery query) {
		AppUser appUser = new AppUser();
		String json = "";
		try{
		    appUser.setRealname(query.getRealname());
		    appUser.setNickname(query.getNickname());
		    appUser.setPassword(query.getPassword());
		    appUser.setTel(query.getTel());
		    appUser.setSex(query.getSex());
		    appUser.setType(query.getType());
		    appUser.setState(query.getState());
		    appUser.setRandom(query.getRandom());
		    appUser.setRegistTime(query.getRegistTime());
		    appUser.setVerifyTime(query.getVerifyTime());
		    appUser.setVerifier(query.getVerifier());
		    appUser.setPortrait(query.getPortrait());
		    appUser.setIdCard(query.getIdCard());
		    appUser.setEstateId(query.getEstateId());
		    appUser.setCreateTime(query.getCreateTime());
		    appUser.setEditTime(query.getEditTime());
		    appUser.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        appUser.setCreateTime(ts);
	        appUser.setEditTime(ts);
			appUserService.save(appUser);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存appUser信息时发生错误：/app/appUser/save", e);
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
	public ModelAndView modify(AppUserQuery query) {	
		AppUser appUser=new AppUser();
		
		try{
			appUser = appUserService.findById(query.getUserId());
		}catch(Exception e){
			GSLogger.error("进入appUser修改页时发生错误：/app/appUser/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appUser/modify");
		mav.addObject("appUser", appUser);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, AppUserQuery query) {
		AppUser appUser = null;
		String json = "";
		try{
		    appUser = appUserService.findById(query.getUserId());
		    appUser.setRealname(query.getRealname());
		    appUser.setNickname(query.getNickname());
		    appUser.setPassword(query.getPassword());
		    appUser.setTel(query.getTel());
		    appUser.setSex(query.getSex());
		    appUser.setType(query.getType());
		    appUser.setState(query.getState());
		    appUser.setRandom(query.getRandom());
		    appUser.setRegistTime(query.getRegistTime());
		    appUser.setVerifyTime(query.getVerifyTime());
		    appUser.setVerifier(query.getVerifier());
		    appUser.setPortrait(query.getPortrait());
		    appUser.setIdCard(query.getIdCard());
		    appUser.setEstateId(query.getEstateId());
		    appUser.setCreateTime(query.getCreateTime());
		    appUser.setEditTime(query.getEditTime());
		    appUser.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        appUser.setEditTime(ts);
			appUserService.update(appUser);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑appUser信息时发生错误：/app/appUser/update", e);
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
						appUserService.delete(new Integer(ids[i]));
					}
				}else{
					appUserService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除AppUser时发生错误：/app/appUser/delete", e);
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
	
	
	@RequestMapping(value="updateIdentity")
	public void updateIdentity(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="userId") Integer userId) {
		AppUser appUser = null;
		String json = "";
		try{
			appUser = appUserService.findById(userId);
			if (appUser.getIsWorker() == 0)
				appUser.setIsWorker(1);
			else
				appUser.setIsWorker(0);
			appUserService.update(appUser);//save(appUser);
			json = "{\"success\":\"true\",\"message\":\"修改身份成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"true\",\"message\":\"修改身份失败\"}"; 
			GSLogger.error("显示appUser列表时发生错误：/app/appUser/updateIdentity", e);
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

}
