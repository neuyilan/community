package com.community.framework.utils;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class TimeInterceptor extends HandlerInterceptorAdapter {  
    // �̳�HandlerInterceptorAdapter��  
 

 /* @Override
  public boolean preHandle(HttpServletRequest request,
		HttpServletResponse response, Object handler) throws Exception {
	  if(request.getSession().getAttribute("user")==null){
		  return true;
	  }else{
		  response.sendRedirect("/login/login.jsp"); // ������ʾҳ��  
		  return false;
	  }
	
 
  }  
  @Override
public void afterCompletion(HttpServletRequest request,
		HttpServletResponse response, Object handler, Exception ex)
		throws Exception {
	// TODO Auto-generated method stub
	super.afterCompletion(request, response, handler, ex);
}
  @Override
public void postHandle(HttpServletRequest request,
		HttpServletResponse response, Object handler,
		ModelAndView modelAndView) throws Exception {
	// TODO Auto-generated method stub
	super.postHandle(request, response, handler, modelAndView);
}*/
}