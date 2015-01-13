package com.community.framework.utils;



import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MyFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		arg0.setCharacterEncoding("utf-8");
		HttpServletRequest request = (HttpServletRequest)arg0 ;

		   Enumeration<?> names = request.getHeaderNames();  
	        StringBuilder sb = new StringBuilder("headerInfo---");  
	        while(names.hasMoreElements()) {  
	            String name = names.nextElement().toString();  
	            Enumeration<?> headers = request.getHeaders(name);  
	            sb.append(name).append(":");  
	            while(headers.hasMoreElements()) {  
	                sb.append(headers.nextElement()).append(" ");  
	            }  
	            sb.append("\n");  
	        }  
	        System.out.println(sb.toString());  
		
		System.out.println("-----------filter---------------"); 
		arg2.doFilter(arg0, arg1);

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
