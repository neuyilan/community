package com.community.app.module.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.qq.connect.QQConnectException;
import com.qq.connect.oauth.Oauth;

/**
 * Date: 12-12-4
 * Time: 上午10:28
 */
public class IndexServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7493564702663286317L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        try {
        	String url = new Oauth().getAuthorizeURL(request);
        	System.out.println(request.getParameter("type"));
        	System.out.println(request.getParameter("ID"));
        	String type = request.getParameter("type");
        	String id = request.getParameter("ID");
        	//& %26  ? - %3F  = - %3D
        	response.sendRedirect(url.replace("qqThirdPartyLogin.json", "qqThirdPartyLogin.json%3FactArgs%3D"+type+","+id)); 
        	System.out.println("sendRedirect URL ===> "+ url.replace("qqThirdPartyLogin.json", "qqThirdPartyLogin.json%3FactArgs%3D"+type+","+id));
        } catch (QQConnectException e) {
            e.printStackTrace();
        }
    }

	
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,  response);
    }
   
    
}
