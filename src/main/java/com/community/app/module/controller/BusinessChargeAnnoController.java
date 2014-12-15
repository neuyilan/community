package com.community.app.module.controller;

import static com.community.framework.utils.CommonUtils.getJSONString;
import static com.community.framework.utils.CommonUtils.getLongTime;
import static com.community.framework.utils.CommonUtils.getUser;
import static com.community.framework.utils.CommonUtils.print;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.bean.AppUser;
import com.community.app.module.bean.AppUserNews;
import com.community.app.module.bean.BusinessChargeAnno;
import com.community.app.module.bean.BusinessCharger;
import com.community.app.module.bean.ShiroUser;
import com.community.app.module.common.ModuleConst;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.AppUserNewsService;
import com.community.app.module.service.AppUserService;
import com.community.app.module.service.BusinessChargeAnnoService;
import com.community.app.module.service.BusinessChargerService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessChargeAnnoQuery;
import com.community.app.module.vo.BusinessChargerQuery;
import com.community.framework.utils.CommonUtils;
import com.community.framework.utils.excel.CheckExcel;
import com.community.framework.utils.excel.PaseExcel;

@Controller
@RequestMapping("/business/businessChargeAnno")
public class BusinessChargeAnnoController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessChargeAnnoController.class);
	@Autowired
	private BusinessChargeAnnoService businessChargeAnnoService;
    @Autowired
	private BusinessChargerService businessChargerService;
    @Autowired
    private AppUserService appUserService;
	@Autowired
	private AppUserNewsService appUserNewsService;
	@Autowired
	private AppLatestNewsService appLatestNewsService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="list")
	public ModelAndView list(BusinessChargeAnnoQuery query) {	
		BaseBean baseBean = null;
		ShiroUser shiroUser = CommonUtils.getUser();
		try{			
			if(!ModuleConst.PROPERTY_CODE.equals(shiroUser.getOrgType())) {
				query.setCurUserId(shiroUser.getUserId());
			}			
			if(shiroUser.getCurEstateId() != null) {
				query.setCurEstateId(shiroUser.getCurEstateId());
			}
			query.setSort("editTime");
			query.setOrder("desc");
			query.setRows(11);
			baseBean = businessChargeAnnoService.findAllPage(query);
		}catch(Exception e){
			GSLogger.error("进入businessChargeAnno管理页时发生错误：/business/businessChargeAnno/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/chargeAnno/list");
		mav.addObject("baseBean", baseBean);
		mav.addObject("pager", baseBean.getPager());
		mav.addObject("curEstateId", shiroUser.getCurEstateId());
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="getPageList")
	public void getPageList(BusinessChargeAnnoQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			if(!ModuleConst.PROPERTY_CODE.equals(shiroUser.getOrgType())) {
				query.setCurUserId(shiroUser.getUserId());
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
			query.setRows(11);
			BaseBean baseBean = businessChargeAnnoService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessChargeAnno businessChargeAnno = (BusinessChargeAnno) baseBean.getList().get(i);
				result.append("{")
			    .append("\"reportId\":\"").append(businessChargeAnno.getReportId()).append("\"").append(",")
			    .append("\"reportName\":\"").append(businessChargeAnno.getReportName()).append("\"").append(",")
			    .append("\"reportDesc\":\"").append(businessChargeAnno.getReportDesc()).append("\"").append(",")
			    .append("\"reportExcel\":\"").append(businessChargeAnno.getReportExcel()).append("\"").append(",")
			    .append("\"publisherId\":\"").append(businessChargeAnno.getPublisherId()).append("\"").append(",")
			    .append("\"publisherName\":\"").append(businessChargeAnno.getPublisherName()).append("\"").append(",")
			    .append("\"publisherState\":\"").append(businessChargeAnno.getPublisherState()).append("\"").append(",")
			    .append("\"publishTime\":\"").append(businessChargeAnno.getPublishTime()).append("\"").append(",")
			    .append("\"auditorId\":\"").append(businessChargeAnno.getAuditorId()).append("\"").append(",")
			    
			    .append("\"estateId\":\"").append(businessChargeAnno.getEstateId()).append("\"").append(",")
			    .append("\"estateName\":\"").append(businessChargeAnno.getEstateName()).append("\"").append(",")
			    
			    .append("\"auditorName\":\"").append(businessChargeAnno.getAuditorName()).append("\"").append(",")
			    .append("\"auditTime\":\"").append(businessChargeAnno.getAuditTime()).append("\"").append(",")
			    .append("\"users\":\"").append(businessChargeAnno.getUsers()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessChargeAnno.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessChargeAnno.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessChargeAnno.getEditor()).append("\"")
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
			GSLogger.error("显示businessChargeAnno列表时发生错误：/business/businessChargeAnno/list", e);
			e.printStackTrace();
		}
	}
	

    @RequestMapping(value="getChargeDetail")
    public void getChargeDetail(HttpServletResponse response, @RequestParam("reportId") String reportId) {
        int id = Integer.parseInt(reportId);
        BusinessChargeAnno obj = businessChargeAnnoService.findById(id);
        Map map = new HashMap();
        map.put("reportId", reportId);
        map.put("isReported", 0);
        List list = businessChargerService.findByMap(map);

        Map mapvalue = new HashMap();
        mapvalue.put("obj", obj);
        mapvalue.put("list", list);
        print(response, getJSONString(mapvalue));
    }
    
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessChargeAnnoQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessChargeAnno新增页时发生错误：/business/businessChargeAnno/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessChargeAnno/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessChargeAnnoQuery query) {
		BusinessChargeAnno businessChargeAnno = new BusinessChargeAnno();
	    ShiroUser shiroUser = CommonUtils.getUser();
		String json = "";
		try{
		    businessChargeAnno.setReportName(query.getReportName());
		    businessChargeAnno.setReportDesc("");
		    businessChargeAnno.setReportExcel(query.getReportExcel());
		    businessChargeAnno.setPublisherId(shiroUser.getUserId());
		    businessChargeAnno.setPublisherName(shiroUser.getNickName());
		    businessChargeAnno.setPublisherState(2);
		    businessChargeAnno.setPublishTime(new Timestamp(System.currentTimeMillis()));
		    businessChargeAnno.setAuditorId(0);
		    businessChargeAnno.setAuditorName("");
		    businessChargeAnno.setAuditTime(null);
		    businessChargeAnno.setUsers(query.getUsers());
		    businessChargeAnno.setCreateTime(new Timestamp(System.currentTimeMillis()));
		    businessChargeAnno.setEditTime(new Timestamp(System.currentTimeMillis()));
		    businessChargeAnno.setEditor("");
		    businessChargeAnno.setEstateId(shiroUser.getCurEstateId());
		    businessChargeAnno.setEstateName(shiroUser.getCurEstateName());
		    
			businessChargeAnnoService.save(businessChargeAnno);
			
			if(!"".equals(businessChargeAnno.getReportExcel()) && businessChargeAnno.getReportExcel() != null) {            
	            try {
                    File file = new File(CommonUtils.LOCALEXCELPATH, businessChargeAnno.getReportExcel());
                    PaseExcel paseExcel = new PaseExcel();
                    String path = file.getPath();
                    String[] columns = {"name","cellphone","estateName","building","unit","house","content"};
                    
                    List<BusinessCharger> list = paseExcel.parse(path, 0, 1, 0, 6, columns);
        			for(int i=0;i<list.size();i++) {
        				BusinessCharger businessCharger = (BusinessCharger) list.get(i);
        				AppUser appUser = appUserService.getAppUserByTel(businessCharger.getCellphone());
        				businessCharger.setReportId(businessChargeAnno.getReportId());
        				businessCharger.setFloor("");
        				businessCharger.setPublishTime(new Timestamp(System.currentTimeMillis()));
        				if(appUser == null) {businessCharger.setIsReported(1);} else {businessCharger.setIsReported(0);}
        				businessCharger.setIsRead(0);
        				
        				businessChargerService.save(businessCharger);
        			}
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessChargeAnno信息时发生错误：/business/businessChargeAnno/save", e);
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
	 * 进入修改页
	 * @return
	 */
	@RequestMapping(value="modify")
	public ModelAndView modify(BusinessChargeAnnoQuery query) {	
		BusinessChargeAnno businessChargeAnno=new BusinessChargeAnno();
		BusinessChargerQuery businessChargerQuery = new BusinessChargerQuery();
		int count1 = 0, count2 = 0;
		List<BusinessCharger> businessCharger1 = new ArrayList<BusinessCharger>();
		List<BusinessCharger> businessCharger2 = new ArrayList<BusinessCharger>();
		try{
			businessChargeAnno = businessChargeAnnoService.findById(query.getReportId());
			businessChargerQuery.setReportId(query.getReportId());
			businessChargerQuery.setIsReported(0);
			count2 = businessChargerService.selectCount(businessChargerQuery);
			businessCharger2 = businessChargerService.findByExample(businessChargerQuery);
			
			businessChargerQuery.setIsReported(1);
			count1 = businessChargerService.selectCount(businessChargerQuery);
			businessCharger1 = businessChargerService.findByExample(businessChargerQuery);
		}catch(Exception e){
			GSLogger.error("进入businessChargeAnno修改页时发生错误：/business/businessChargeAnno/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/chargeAnno/modify");
		mav.addObject("businessChargeAnno", businessChargeAnno);
		mav.addObject("count2", count2);	// 已通知
		mav.addObject("count1", count1);	// 未通知
		mav.addObject("businessCharger2", businessCharger2);	// 已通知
		mav.addObject("businessCharger1", businessCharger1);	// 未通知
		
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessChargeAnno businessChargeAnno) {
		//BusinessChargeAnno businessChargeAnno = null;
		String json = "";
		try{
		    businessChargeAnno.setReportName(businessChargeAnno.getReportName()); //通知名称
            businessChargeAnno.setReportId(businessChargeAnno.getReportId());
		    businessChargeAnno.setEditTime(new Timestamp(System.currentTimeMillis())); //编辑时间
		    businessChargeAnno.setEditor(CommonUtils.getUser().getNickName()); //编辑人
			businessChargeAnnoService.update(businessChargeAnno);
		    businessChargerService.delete(businessChargeAnno.getReportId());
		    
		    if(!"".equals(businessChargeAnno.getReportExcel()) && businessChargeAnno.getReportExcel() != null) {            
	            try {
                    File file = new File(CommonUtils.LOCALEXCELPATH, businessChargeAnno.getReportExcel());
                    PaseExcel paseExcel = new PaseExcel();
                    String path = file.getPath();
                    String[] columns = {"name","cellphone","estateName","building","unit","house","content"};
                    
                    List<BusinessCharger> list = paseExcel.parse(path, 0, 1, 0, 6, columns);
        			for(int i=0;i<list.size();i++) {
        				BusinessCharger businessCharger = (BusinessCharger) list.get(i);
        				AppUser appUser = appUserService.getAppUserByTel(businessCharger.getCellphone());
        				businessCharger.setReportId(businessChargeAnno.getReportId());
        				businessCharger.setFloor("");
        				businessCharger.setPublishTime(new Timestamp(System.currentTimeMillis()));
        				if(appUser == null) {businessCharger.setIsReported(1);} else {businessCharger.setIsReported(0);}
        				businessCharger.setIsRead(0);
        				
        				businessChargerService.save(businessCharger);
        			}
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessChargeAnno信息时发生错误：/business/businessChargeAnno/update", e);
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
						businessChargeAnnoService.delete(new Integer(ids[i]));
					}
				}else{
					Boolean result = businessChargeAnnoService.delete(new Integer(id));
					if(result) {
						businessChargerService.delete(new Integer(id));
					}
				}
			}
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessChargeAnno时发生错误：/business/businessChargeAnno/delete", e);
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
     * 解析Excel
     * @param excelname
     */
    @RequestMapping(value="jsonExcel")
    public void jsonExcel(@RequestParam(value="reportName") String reportName, HttpServletResponse response) {
    	String json = "";
		StringBuilder result = new StringBuilder();
		
		if(!"".equals(reportName) && reportName != null) {            
            try {
                    File file = new File(CommonUtils.LOCALEXCELPATH, reportName);
                    // ftp上传远程
                    PaseExcel paseExcel = new PaseExcel();
                    String path = file.getPath();
                    String[] columns = {"name","cellphone","estateName","building","unit","house","content"};
                    int count = 0, count1 = 0, count2 =0;
                    
                    List<BusinessCharger> list = paseExcel.parse(path, 0, 1, 0, 6, columns);
                    result.append("{\"total\":").append(list.size()).append(",")
        			.append("\"rows\":[");
        			for(int i=0;i<list.size();i++) {
        				BusinessCharger businessCharger = (BusinessCharger) list.get(i);
        				AppUser appUser = appUserService.getAppUserByTel(businessCharger.getCellphone());
        				
        				if(appUser == null){ count = 0; count1 += 1;} else { count = 1; count2 += 1;}
        				result.append("{")
        				.append("\"count\":\"").append(count).append("\"").append(",")
        			    .append("\"name\":\"").append(businessCharger.getName()).append("\"").append(",")
        			    .append("\"cellphone\":\"").append(businessCharger.getCellphone()).append("\"").append(",")
        			    .append("\"estateName\":\"").append(businessCharger.getEstateName()).append("\"").append(",")
        			    .append("\"building\":\"").append(businessCharger.getBuilding()).append("\"").append(",")
        			    .append("\"unit\":\"").append(businessCharger.getUnit()).append("\"").append(",")
        			    .append("\"house\":\"").append(businessCharger.getHouse()).append("\"").append(",")
        			    .append("\"content\":\"").append(businessCharger.getContent()).append("\"")
        				.append("}").append(",");
        			}
        			json = result.toString();
        			if(list.size() > 0) {
        				json = json.substring(0, json.length()-1);
        			}
        			json += "],";
        			json += "\"count1\":" + count1 + ",";
        			json += "\"count2\":" + count2;
        			json += "}";
        			
        			response.setHeader("Cache-Control", "no-cache");
        			response.setCharacterEncoding("utf-8");
        			try {
        				response.getWriter().write(json);
        			} catch (IOException e) {
        				e.printStackTrace();
        			}
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
	/**
	 * 跳转到上传页面
	 * @return
	 */
	@RequestMapping(value="chargeExcel")
    public ModelAndView chargeExcel() {
        ModelAndView mav = new ModelAndView("/module/chargeAnno/uploadexcel");
        return mav;
    }
	
	/**
	 * 上传EXCEL文件操作
	 * @param exclefile
	 * @param response
	 */
    @RequestMapping(value="uploadExcel")
    public void uploadExcel(@RequestParam MultipartFile[] exclefile, HttpServletResponse response) {
        //上传附件
        try {
            for(MultipartFile file : exclefile){
                if(!file.isEmpty()){
                    String fname = FilenameUtils.getBaseName(file.getOriginalFilename());
                    String extense = FilenameUtils.getExtension(file.getOriginalFilename());
                    DecimalFormat decimalFormat=new DecimalFormat(".0");
                    long ltime = getLongTime();
                    String fname2 =  fname + ltime + "." + extense;
                    File newfile =  new File(CommonUtils.LOCALEXCELPATH, fname2);
                    //拷贝到服务器临时文件进行验证excel格式是否正确
                    FileUtils.copyInputStreamToFile(file.getInputStream(), newfile);
                    CheckExcel checkExcel = new CheckExcel();
                    String path = newfile.getPath();
                    
                    String msg = checkExcel.parse(path, decimalFormat.format(((float)file.getSize()/1024)), fname2 ,0, 1, 0, 6);
                    print(response, msg);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 解析Excel
     * @param excelname
     */
    @RequestMapping(value="parseExcel")
    public void parseExcel(@RequestParam(value = "excelname") String excelname, @RequestParam(value="reportName") String reportName, HttpServletResponse response) {
        boolean flag = true;
        //保存通知名称
        Timestamp  ts=new Timestamp(new Date().getTime());
        BusinessChargeAnno businessChargeAnno = new BusinessChargeAnno();
        ShiroUser user = CommonUtils.getUser();
        businessChargeAnno.setReportName(reportName);
        businessChargeAnno.setPublisherId(user.getUserId());
        businessChargeAnno.setPublisherName(user.getUserName());
        businessChargeAnno.setPublishTime(ts);
        businessChargeAnno.setCreateTime(ts);
        businessChargeAnnoService.save(businessChargeAnno);
        //可能存在多个Excel文件,以逗号分隔
        if(!"".equals(excelname) && excelname != null) {
            String[] names = excelname.split("\\,");
            
            try {
                for(String fname : names) {
                    File file = new File(CommonUtils.LOCALEXCELPATH, fname);
                    //ftp上传远程
                    PaseExcel paseExcel = new PaseExcel();
                    String path = file.getPath();
                    String[] columns = {"name","cellphone","estateName","building","unit","house","content"};
                    
                    List<BusinessCharger> list = paseExcel.parse(path, 0, 1, 0, 6, columns);
                    
                    if(list.size() > 0) {
                        for(BusinessCharger obj : list) {
                            //信息入库
                            obj.setReportId(businessChargeAnno.getReportId());
                            businessChargerService.save(obj);
                        }
                    }
                }
            } catch (Exception e) {
                flag = false;
                e.printStackTrace();
            }
        }
        String msg = "";
        if(flag) {
            msg = getJSONString(true, "上传成功！");
        } else {
            msg = getJSONString(false, "上传失败！");
        }
        print(response, msg);
    }
    
    /**
	 * 发布/拒绝缴费对象
	 * @param request
	 * @param businessChargeAnno
	 * @return
	 */
	@RequestMapping(value="updateAnnoState")
	public void updateAnnoState(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="id") String id, @RequestParam(value="auditInfo") String auditInfo) {
		BusinessChargeAnnoQuery query = new BusinessChargeAnnoQuery();
		query.setReportId(Integer.parseInt(id));
		BusinessChargeAnno businessChargeAnno = businessChargeAnnoService.findById(query.getReportId());
		String json = "";
		try{
			if(!auditInfo.equals("")) {
				businessChargeAnno.setPublisherState(3);  // 未通过
				businessChargeAnno.setAuditInfo(auditInfo);//审核说明
			} else {
				businessChargeAnno.setPublisherState(0);  // 已发布
				businessChargeAnno.setPublishTime(new Timestamp(System.currentTimeMillis()));
			}

			businessChargeAnno.setEditTime(new Timestamp(System.currentTimeMillis()));
			businessChargeAnno.setAuditorId(getUser().getUserId());
			businessChargeAnno.setAuditorName(getUser().getUserName());
			businessChargeAnno.setAuditTime(new Timestamp(System.currentTimeMillis()));
			
			businessChargeAnnoService.update(businessChargeAnno);
			
			BusinessChargerQuery businessChargerQuery = new BusinessChargerQuery();
			businessChargerQuery.setReportId(businessChargeAnno.getReportId());
			List<BusinessCharger> list = businessChargerService.findByExample(businessChargerQuery);
			AppUserNews appUserNews = new AppUserNews(); 
 			for(int i=0;i<list.size();i++) {
 				BusinessCharger businessCharger = (BusinessCharger) list.get(i);
 				AppUser appUser = appUserService.getAppUserByTel(businessCharger.getCellphone());
				if(appUser != null && businessChargeAnno.getPublisherState() == 0){
					appUserNews = new AppUserNews();
					appUserNews.setUserId(appUser.getUserId());
					appUserNews.setCreateTime(new Timestamp(System.currentTimeMillis()));
					appUserNews.setNewTitle(businessChargeAnno.getReportName());
					appUserNews.setType(6);
					appUserNews.setId(businessChargeAnno.getReportId());
					appUserNews.setContent(businessCharger.getContent());
					appUserNews.setLastMessage("");
					appUserNews.setLastMessageName("");
					appUserNewsService.saveReply(appUserNews);
					AppLatestNews appLatestNews = new AppLatestNews();
					appLatestNews.setUserId(appUser.getUserId());
					appLatestNews.setTypeId(7);
					appLatestNews.setSourceId(businessChargeAnno.getReportId());
					appLatestNews.setTo(0);
					appLatestNews.setEstateId(0);
					appLatestNewsService.save_app(appLatestNews);
					appLatestNews.setTypeId(8);
					appLatestNewsService.save_app(appLatestNews);
					appLatestNews.setTypeId(10);
					appLatestNewsService.save_app(appLatestNews);
				}
 			}
			if(!auditInfo.equals("")) { json = "{\"success\":\"true\",\"message\":\"拒绝成功\"}"; } 
			else { json = "{\"success\":\"true\",\"message\":\"发布成功\"}"; }
		} catch(Exception e) {
			if(!auditInfo.equals("")) { json = "{\"success\":\"true\",\"message\":\"拒绝失败\"}"; } 
			else { json = "{\"success\":\"false\",\"message\":\"发布失败\"}"; }
			
			GSLogger.error("显示businessChargeAnno列表时发生错误：/business/businessChargeAnno/updateAnnoState", e);
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