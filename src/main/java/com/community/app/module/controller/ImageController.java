package com.community.app.module.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/image")
public class ImageController {
	
	/**
	 * 删除图片操作
	 * @return
	 */
	@RequestMapping(value="delImage")
	public void delImage(HttpServletRequest request, HttpServletResponse response) {		
		String json = "";
		try {
			String picPath = request.getParameter("picPath");
			String filedir = request.getSession().getServletContext().getRealPath("/");
			picPath = filedir + picPath;
			File file = new File(picPath);
			if(file.exists()) {
				file.delete();
				json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
			}else{
				json = "{\"success\":\"true\",\"message\":\"文件不存在\"}";
			}
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 上传单张图片操作
	 * @return
	 */
	@RequestMapping(value="uploadSinglePic")
	public void uploadSinglePic(HttpServletRequest request, HttpServletResponse response) {		
		try {
			String picPath = (String) request.getAttribute("picPath");
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(picPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 上传单张图片操作 for PHP
	 * @return
	 */
	@RequestMapping(value="uploadSinglePicPHP")
	public void uploadSinglePicPHP(HttpServletRequest request, HttpServletResponse response) {	
		String json = "" ;//"{\"success\":\"true\",\"message\":\"保存成功\"}";
		try {
			String picPath = (String) request.getAttribute("picPath");
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Content-Type", "application/json;charset=UTF-8");
			response.addHeader("Access-Control-Allow-Origin", "*");  
			response.addHeader("P3P","CP=CAO PSA OUR");  
			response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");  
			   response.addHeader("Access-Control-Allow-Origin", "*");  
		        response.addHeader("Access-Control-Allow-Headers", "x-requested-with");  
//			response.setHeader("Content-Type", "text/json"); 
			
			response.setCharacterEncoding("utf-8");
//			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"picPath\":\""+picPath+"\"";
			json += "}";
			response.getWriter().write(json);
		} catch (IOException e) {
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"返回图片路径失败\"";
			json += "}";
			e.printStackTrace();
		}
	}
}