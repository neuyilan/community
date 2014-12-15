package com.community.framework.utils;



import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class MyFilter1 implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		//request.getRequestURL()
		if (isAjaxRequest(request)) {
			if(request.getRequestURI().toLowerCase().indexOf("log.jsp")>=0 || request.getRequestURI().toLowerCase().indexOf("login.jsp")>=0){
				filterChain.doFilter(arg0, arg1);
				
			} else if (request.getSession().getAttribute("user") == null) {
			response.setHeader("sessionstatus", "timeout");
			response.setContentType("text/x-json;charset=utf-8");
			response.setHeader("Cache-Control", "no-cache");
			JSONObject json=new JSONObject();
			json.put("sessionstatus", "timeout");
			response.getWriter().write(json.toString());
				
			}else{
				filterChain.doFilter(arg0, arg1);
			}
		}else {
			if(request.getRequestURI().toLowerCase().indexOf("log.jsp")>=0 || request.getRequestURI().toLowerCase().indexOf("login.jsp")>=0){
				filterChain.doFilter(arg0, arg1);
				
			} else if (request.getSession().getAttribute("user") == null) {
				RequestDispatcher dispatcher=request.getRequestDispatcher("/login/log.jsp");
				dispatcher.forward(arg0, arg1);
				
			}else{
				filterChain.doFilter(arg0, arg1);
			}
		}
		
	}
	/**
	 * 判断请求是否为ajax提交
	 * @param request
	 * @return
	 */
	private boolean isAjaxRequest(HttpServletRequest request) {  
        String header = request.getHeader("X-Requested-With");  
        if (header != null && "XMLHttpRequest".equals(header))  
            return true;  
        else  
            return false;  
    }
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
