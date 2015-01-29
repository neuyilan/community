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
}