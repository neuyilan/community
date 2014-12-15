package com.community.service.family;



/**
 * 家庭相关处理接口
 * 包括：
 * 用户信息
 * 
 * @author zyp-2_000
 *
 */

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.community.app.module.bean.AppEstateUser;
import com.community.app.module.bean.AppUser;
import com.community.app.module.bean.AppUserNews;
import com.community.app.module.bean.BusinessCommunity;
import com.community.app.module.bean.BusinessFamily;
import com.community.app.module.bean.BusinessFamilyMember;
import com.community.app.module.bean.BusinessFamilyPet;
import com.community.app.module.bean.BusinessPetType;
import com.community.app.module.bean.MemberVO;
import com.community.app.module.service.AppEstateUserService;
import com.community.app.module.service.AppUserNewsService;
import com.community.app.module.service.AppUserService;
import com.community.app.module.service.BusinessAnnoService;
import com.community.app.module.service.BusinessFamilyMemberService;
import com.community.app.module.service.BusinessFamilyPetService;
import com.community.app.module.service.BusinessFamilyService;
import com.community.app.module.service.BusinessPetTypeService;
import com.community.app.module.vo.AppEstateUserQuery;
import com.community.app.module.vo.BusinessFamilyMemberQuery;
import com.community.app.module.vo.BusinessFamilyPetQuery;
import com.community.app.module.vo.BusinessFamilyQuery;
import com.community.framework.utils.StringUtil;
import com.community.framework.utils.propertiesUtil;


@Controller
@RequestMapping("/service/family")
public class FamilyController {
	private static Logger GSLogger = LoggerFactory.getLogger(FamilyController.class);
	
	@Autowired
	private BusinessFamilyService businessFamilyService;
	@Autowired
	private BusinessFamilyMemberService businessFamilyMemberService;
	@Autowired
	private BusinessPetTypeService businessPetTypeService;
	@Autowired
	private BusinessFamilyPetService businessFamilyPetService;
	@Autowired
	private AppUserService appUserService;
	@Autowired
	private AppUserNewsService appUserNewsService;
	@Autowired
	private AppEstateUserService appEstateUserService;
	
	
	
	
	/**
	 * 用户获取家庭信息
	 * @param userId,sessionid,familyId
	 * @return
	 * json
	 */
	@RequestMapping(value="getFamilyInfo")
	public void getFamilyInfo(HttpServletRequest request, HttpServletResponse response,BusinessFamilyQuery query) {
		String json = "";
		List<BusinessFamilyQuery> list;
		try{
			list=businessFamilyService.getFamilyInfo(query.getFamilyId());
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"familyId\":\""+list.get(0).getFamilyId()+"\",";
			json += "\"familyIName\":\""+list.get(0).getFamilyName()+"\",";
			json += "\"avatar\":\""+ip+list.get(0).getAvatar()+"\",";
			json += "\"info\":\""+list.get(0).getFamilyDesc()+"\",";
			json += "\"codeAddr\":\""+ip+list.get(0).getDimensionCode()+"\",";
			json += "\"attr\":\""+list.get(0).getAttr()+"\",";
			json += "\"verifyCode\":\""+list.get(0).getVerifyCode()+"\"";
			json += "}";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"获取失败\"";
			json += "}";
			GSLogger.error("进入businessCommunity管理页时发生错误：/business/businessCommunity/enter", e);
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
	 * 用户获取家庭信息
	 * @param userId,sessionid,familyId
	 * @return
	 * json
	 */
	@RequestMapping(value="getFamilyMember")
	public void getFamilyMember(HttpServletRequest request, HttpServletResponse response,BusinessFamilyQuery query) {
		String json = "";
		Properties p = propertiesUtil.getProperties("config.properties");
		String ip = p.getProperty("imageIp");   
		List<BusinessFamilyQuery> list;
		try{
			list=businessFamilyService.getFamilyInfo(query.getFamilyId());
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"amilyIMembers\":[";
			for (BusinessFamilyQuery businessFamilyQuery : list) {
				json += "{\"userId\":\""+businessFamilyQuery.getUserId()+"\",\"realname\":\""+businessFamilyQuery.getRealname()+"\",\"avatar\":\""+ip+businessFamilyQuery.getUserAvatar()+"\",\"tel\":\""+businessFamilyQuery.getTel()+"\"},";
			}
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]";
			json += "}";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"获取失败\"";
			json += "}";
			GSLogger.error("进入businessCommunity管理页时发生错误：/business/businessCommunity/enter", e);
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
	 * 用户创建家庭
	 * @param userId,sessionid,familyName
	 * @return
	 * json
	 */
	@RequestMapping(value="create")
	public void create(HttpServletRequest request, HttpServletResponse response,BusinessFamilyQuery query) {
		String json = "";
		
		boolean whetherRepeat = false;
		try {
			whetherRepeat = businessFamilyMemberService.whetherRepeat(query.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"添加失败\"";
			json += "}";
		}
		if(whetherRepeat){
			try{
				String uuid= UUID.randomUUID().toString();
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				String dateString = sf.format(new Date());
				String filedir = "app/image/" +dateString+"/"+uuid+".png";
				query.setPath(request.getSession().getServletContext().getRealPath("/").replace("\\", "/"));
				query.setFiledir(filedir);
				AppEstateUserQuery appEstateUserQuery = new AppEstateUserQuery();
				appEstateUserQuery.setUserId(query.getUserId());
				appEstateUserQuery.setEstateId(query.getEstateId());
				//List<AppEstateUser> list = appEstateUserService.findByExample_app(appEstateUserQuery);
				//if(list.get(0).get){
					
				//}
				
				BusinessFamily businessFamily = businessFamilyService.save(query);
				json += "{";
				json += "\"errorCode\":\"200\",";
				json += "\"message\":\"添加成功\",";
				json += "\"content\":{";
				json += "\"familyId\":\""+businessFamily.getFamilyId()+"\",";
				json += "\"codeAddr\":\""+businessFamily.getDimensionCode()+"\"";
				json += "}";
				json += "}";
			}catch(Exception e){
				json ="";
				json += "{";
				json += "\"errorCode\":\"400\",";
				json += "\"message\":\"保存失败\"";
				json += "}";
				e.printStackTrace();
			}
		}else{
			json ="";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"您已经有家庭了或在申请家庭中\"";
			json += "}";
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
	 * 用户设置家庭头像
	 * @param userId,familyId,sessionid,avatar
	 * @return
	 * json
	 */
	@RequestMapping(value="saveAvatar")
	public void saveAvatar(HttpServletRequest request, HttpServletResponse response,BusinessFamilyQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			Map map = (Map) request.getAttribute("resultMap");
			Map<String,String> paramMap=(Map) map.get("param");
			Map<String,String> imageMap=(Map) map.get("image");
			BusinessFamily businessFamily = new BusinessFamily();
			Timestamp  ts=new Timestamp(new Date().getTime());
			businessFamily.setEditTime(ts);
			Collection<String> c = imageMap.keySet();
			Iterator it = c.iterator();
	        for (; it.hasNext();) {
				businessFamily.setAvatar((String)imageMap.get((String)it.next()));
	        }
			businessFamily.setFamilyId(new Integer(paramMap.get("familyId")));
			businessFamilyService.update(businessFamily);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"保存成功\",";
			json += "\"content\":{";
			json += "\"avatar\":\""+ip+businessFamily.getAvatar()+"\"";
			json += "}";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"保存失败\"";
			json += "}";
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
	 * 用户设置家庭名称
	 * @param userId,sessionid,familyId,name
	 * @return
	 * json
	 */
	@RequestMapping(value="saveName")
	public void saveName(HttpServletRequest request, HttpServletResponse response,BusinessFamilyQuery query) {
		String json = "";
		try{
			BusinessFamily businessFamily = new BusinessFamily();
			Timestamp  ts=new Timestamp(new Date().getTime());
			businessFamily.setEditTime(ts);
			businessFamily.setFamilyName(query.getName());
			businessFamily.setFamilyId(query.getFamilyId());
			businessFamilyService.update(businessFamily);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"保存成功\"";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"保存失败\"";
			json += "}";
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
	 * 用户设置宠物类型
	 * @param userId,sessionid,familyId,petId
	 * @return
	 * json
	 */
	@RequestMapping(value="savePet")
	public void savePet(HttpServletRequest request, HttpServletResponse response,BusinessFamilyPetQuery query) {
		String json = "";
		try{
			BusinessFamilyPet businessFamilyPet = new BusinessFamilyPet();
			Timestamp  ts=new Timestamp(new Date().getTime());
			businessFamilyPet.setEditTime(ts);
			businessFamilyPet.setCreateTime(ts);
			businessFamilyPet.setFamilyId(query.getFamilyId());
			String[] id = query.getPetIds().split(",");
			businessFamilyPetService.delete(query.getFamilyId());
			for (int i = 0; i < id.length; i++) {
				businessFamilyPet.setTypeId(new Integer(id[i]));
				businessFamilyPetService.save(businessFamilyPet);
			}
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"保存成功\"";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"保存失败\"";
			json += "}";
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
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"设置成功\"";
		json += "}";
		
	}
	
	/**
	 * 用户设置家庭介绍
	 * @param userId,sessionid,familyId,info
	 * @return
	 * json
	 */
	@RequestMapping(value="saveInfo")
	public void saveInfo(HttpServletRequest request, HttpServletResponse response,BusinessFamilyQuery query) {
		String json = "";
		try{
			BusinessFamily businessFamily = new BusinessFamily();
			Timestamp  ts=new Timestamp(new Date().getTime());
			businessFamily.setEditTime(ts);
			businessFamily.setFamilyDesc(query.getInfo());
			businessFamily.setFamilyId(query.getFamilyId());
			businessFamilyService.update(businessFamily);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"保存成功\"";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"保存失败\"";
			json += "}";
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
	 * 用户添加家庭成员
	 * @param userId,familyId,sessionid,peopleId
	 * @return
	 * json
	 */
	@RequestMapping(value="addPeople")
	public void addPeople(HttpServletRequest request, HttpServletResponse response,BusinessFamilyQuery query) {
		String json = "";
		boolean whetherRepeat = false;
		try {
			whetherRepeat = businessFamilyMemberService.whetherRepeat(query.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"加入失败！！已有家庭\"";
			json += "}";
		}
		if (whetherRepeat) {
			try{
				BusinessFamilyMember businessFamilyMember = new BusinessFamilyMember();
				Timestamp  ts=new Timestamp(new Date().getTime());
				businessFamilyMember.setEditTime(ts);
				businessFamilyMember.setCreateTime(ts);
				businessFamilyMember.setState(0);
				businessFamilyMember.setFamilyId(query.getFamilyId());
				businessFamilyMember.setUserId(query.getUserId());
				businessFamilyMemberService.save(businessFamilyMember);
				json += "{";
				json += "\"errorCode\":\"200\",";
				json += "\"message\":\"添加成功\"";
				json += "}";
			}catch(Exception e){
				json = "";
				json += "{";
				json += "\"errorCode\":\"400\",";
				json += "\"message\":\"添加失败\"";
				json += "}";
				e.printStackTrace();
			}
		}else{
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"加入失败！！已有家庭\"";
			json += "}";
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
	 * 用户离开家庭
	 * @param userId,familyId,sessionid,peopleId
	 * @return
	 * json
	 */
	@RequestMapping(value="leave")
	public void leave(HttpServletRequest request, HttpServletResponse response,BusinessFamilyQuery query) {
		String json = "";
		try{
			businessFamilyMemberService.delete(query.getUserId());
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"设置成功\"";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"设置失败\"";
			json += "}";
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
	 * 用户使用验证码加入家庭
	 * @param userId,familyId,sessionid,verifyCode
	 * @return
	 * json
	 */
	@RequestMapping(value="joinFamily")
	public void joinFamily(HttpServletRequest request, HttpServletResponse response,BusinessFamilyQuery query) {
		String json = "";
		
		BusinessFamilyQuery BusinessFamilyQuery = new BusinessFamilyQuery();
		BusinessFamilyQuery.setVerifyCode(query.getVerifyCode());
		BusinessFamilyQuery.setFamilyState(0);
		List<BusinessFamily> list = businessFamilyService.findByExample(BusinessFamilyQuery);
		if(list.size()>0){
			boolean whetherRepeat = false;
			try {
				whetherRepeat = businessFamilyMemberService.whetherRepeat(query.getUserId());
			} catch (Exception e) {
				e.printStackTrace();
				json = "";
				json += "{";
				json += "\"errorCode\":\"400\",";
				json += "\"message\":\"申请失败！！已有家庭\"";
				json += "}";
			}
			if (whetherRepeat) {
				try{
					BusinessFamilyMember businessFamilyMember = new BusinessFamilyMember();
					businessFamilyMember.setFounderId(list.get(0).getFounderId());
					Timestamp  ts=new Timestamp(new Date().getTime());
					businessFamilyMember.setEditTime(ts);
					businessFamilyMember.setCreateTime(ts);
					businessFamilyMember.setFamilyId(list.get(0).getFamilyId());
					businessFamilyMember.setUserId(query.getUserId());
					businessFamilyMember.setState(2);
					businessFamilyMember.setTel(query.getTel());
					businessFamilyMember.setName(query.getName());
					businessFamilyMemberService.ApplySave(businessFamilyMember);
					
					
					json += "{";
					json += "\"errorCode\":\"200\",";
					json += "\"message\":\"正在申请中\"";
					json += "}";
				}catch(Exception e){
					json = "";
					json += "{";
					json += "\"errorCode\":\"400\",";
					json += "\"message\":\"申请失败\"";
					json += "}";
					e.printStackTrace();
				}
			}else{
				json = "";
				json += "{";
				json += "\"errorCode\":\"400\",";
				json += "\"message\":\"加入失败！！已有家庭\"";
				json += "}";
			}
		}else{
			json ="";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"验证码错误\"";
			json += "}";
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
	 * 用户宠物列表
	 * @param userId,sessionid,familyId
	 * @return
	 * json
	 */
	@RequestMapping(value="getPetList")
	public void getPetList(HttpServletRequest request, HttpServletResponse response,BusinessFamilyPetQuery query) {
		String json = "";
		try{
			List<BusinessPetType> typeList = businessPetTypeService.findAll();
			List<BusinessFamilyPet> petList =businessFamilyPetService.findByExample(query);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"pet\":[";
			for (BusinessPetType businessPetType : typeList) {
				json += "{\"petId\":\""+businessPetType.getTypeId()+"\",\"petName\":\""+businessPetType.getTypeName()+"\"";
				boolean flag=false;//标志位
				for (BusinessFamilyPet businessFamilyPet : petList) {
					if (businessPetType.getTypeId()==businessFamilyPet.getTypeId()) {
						flag=true;
					}
				}
				if(flag){
					json +=",\"state\":true},";
				}else{
					json +=",\"state\":false},";
				}
				
			}
			if(typeList.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]";
			json += "}";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"获取失败\"";
			json += "}";
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
	 * 用户是否同意申请加入家庭
	 * @param userId,sessionid,applyId
	 * @return
	 * json
	 */
	@RequestMapping(value="informationAgreeAdd")
	public void informationAgreeAdd(HttpServletRequest request, HttpServletResponse response, BusinessFamilyMemberQuery query) {
		String json = "";
		try{
			businessFamilyMemberService.informationAgreeAdd(query);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"设置成功\"";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"设置失败\"";
			json += "}";
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
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"添加成功\"";
		json += "}";
		
	}
	
}
