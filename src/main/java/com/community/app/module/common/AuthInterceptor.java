package com.community.app.module.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		//String url = request.getRequestURL().toString();
		String url = request.getServletPath();
        if(url.endsWith("login.do") || url.endsWith("logout.do")){    
            //request.getRequestDispatcher("/msg.jsp").forward(request, response);  
            return true;   
        } 
        if(url.endsWith(".json")){    
            //request.getRequestDispatcher("/msg.jsp").forward(request, response);  
            return true;   
        } 
        Subject currentUser = SecurityUtils.getSubject();
   
        if(currentUser.isAuthenticated()) {  
            //更好的实现方式的使用cookie  
            return true; 
        }else{
        	//request.getRequestDispatcher("/index/logout.do").forward(request, response);
        	//request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
            //return true;
        	if (request.getHeader("x-requested-with") != null  
                    && request.getHeader("x-requested-with")  
                            .equalsIgnoreCase("XMLHttpRequest"))//如果是ajax请求响应头会有，x-requested-with；  
            	{  
        		response.setHeader("sessionstatus", "timeout");
				
				//response.setHeader("Cache-Control", "no-cache");
				JSONObject json=new JSONObject();
				json.put("sessionstatus", "111");
				//response.setContentType("text/x-json;charset=utf-8");
				//response.setHeader("Cache-Control", "no-cache");
                //response.setCharacterEncoding("utf-8");
                try {
                	response.getWriter().write(json.toString());
                    response.getWriter().write(json.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return false;  
            }else{
            	request.getRequestDispatcher("/index/logout.do").forward(request, response);
            	return false;
            }
        } 
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
	}

	
	
}
