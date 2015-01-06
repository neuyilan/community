package com.community.service.verify;

/**
 * 用户相关处理接口
 * 包括：
 * 用户信息
 * 
 * @author zyp-2_000
 *
 */
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.community.app.module.bean.AppVerify;
import com.community.app.module.service.AppUserService;
import com.community.app.module.service.AppVerifyService;
import com.community.app.module.service.ManageSendMsgService;
import com.community.app.module.vo.AppVerifyQuery;
import com.community.framework.utils.MessageChannelClient;
import com.community.framework.utils.StringUtil;

@Controller
@RequestMapping("/service/verify")
public class VerifyController {
	@Autowired
	private AppVerifyService appVerifyService;
	@Autowired
	private AppUserService appUserService;
	@Autowired
	private ManageSendMsgService manageSendMsgService;
	/**
	 * 用户注册时获取验证码，服务器返回验证码
	 * @param cellphone
	 * @return
	 * json
	 */
	@RequestMapping(value="getCode")
	public void getCode(HttpServletRequest request, HttpServletResponse response,AppVerifyQuery query) {
		String json = "";
		boolean whetherRepeat = false;
		try {
			whetherRepeat = appUserService.whetherRepeat(query.getCellphone());
		} catch (Exception e) {
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"验证失败\"";
			json += "}";
			e.printStackTrace();
		}
		if("0".equals(request.getParameter("type"))){
			if(whetherRepeat){
				AppVerify appVerify = new AppVerify();
				try{
					String str=StringUtil.createRandom(true, 6);
					appVerify.setCellphone(query.getCellphone());
				    appVerify.setVerificationCode(str);
				    appVerify.setCreateTime(query.getCreateTime());
			        Timestamp  ts=new Timestamp(new Date().getTime());
			        appVerify.setCreateTime(ts);
			        appVerifyService.delete(query);
					appVerifyService.save(appVerify);
					// 发送短信
					str="您正在申请注册OK家注册用户,验证码"+str+",2分钟内有效。【OK家】";
					String returnMessage = returnMessageRrid(query.getCellphone(), str);
					manageSendMsgService.save(query.getCellphone(),returnMessage,str,1);
					if(!returnMessage.contains("-")) {
						json += "{";
						json += "\"errorCode\":\"200\",";
						json += "\"message\":\"发送成功\"";
						json += "}";
					}
				}catch(Exception e){
					json = "";
					json += "{";
					json += "\"errorCode\":\"400\",";
					json += "\"message\":\"发送失败\"";
					json += "}";
					e.printStackTrace();
				}
			}else{
				json = "";
				json += "{";
				json += "\"errorCode\":\"400\",";
				json += "\"message\":\"该手机号已注册\"";
				json += "}";
			}
		}else {
			if(!whetherRepeat){
				AppVerify appVerify = new AppVerify();
				try{
					String str=StringUtil.createRandom(true, 6);
					appVerify.setCellphone(query.getCellphone());
				    appVerify.setVerificationCode(str);
				    appVerify.setCreateTime(query.getCreateTime());
			        Timestamp  ts=new Timestamp(new Date().getTime());
			        appVerify.setCreateTime(ts);
			        appVerifyService.delete(query);
					appVerifyService.save(appVerify);
					// 发送短信
					str="您获取的验证码为 "+str+"，请在页面中输入以完成验证。【OK家】";
					String returnMessage = returnMessageRrid(query.getCellphone(), str);
					if(!returnMessage.contains("-")) {
						json += "{";
						json += "\"errorCode\":\"200\",";
						json += "\"message\":\"发送成功\"";
						json += "}";
					}
				}catch(Exception e){
					json = "";
					json += "{";
					json += "\"errorCode\":\"400\",";
					json += "\"message\":\"发送失败\"";
					json += "}";
					e.printStackTrace();
				}
			}else{
				json = "";
				json += "{";
				json += "\"errorCode\":\"400\",";
				json += "\"message\":\"该手机号未注册\"";
				json += "}";
			}
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
	 * 服务端验证用户输入的手机号码和验证码是否正确，保证该手机号码有效
	 * @param cellphone,verifyCode
	 * @return
	 * json
	 */
	@RequestMapping(value="verifyCode")
	public void verifyCode(HttpServletRequest request, HttpServletResponse response,AppVerifyQuery query) {
		String json = "";
		try{
	        query.setVerificationCode(query.getVerifyCode());
	        List<AppVerify> list = appVerifyService.findByExample(query);
	        if(list.size()>0){
	        	if(new Date().getTime()-list.get(0).getCreateTime().getTime()<=120000){
	        		appVerifyService.delete(query);
	        		json += "{";
	    			json += "\"errorCode\":\"200\",";
	    			json += "\"message\":\"验证成功\"";
	    			json += "}";
	        	}else{
	        		json = "";
	        		json += "{";
	    			json += "\"errorCode\":\"400\",";
	    			json += "\"message\":\"已过期\"";
	    			json += "}";
	        	}
	        }else{
	        	json = "";
	        	json += "{";
    			json += "\"errorCode\":\"400\",";
    			json += "\"message\":\"验证失败\"";
    			json += "}";
	        }
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"验证失败\"";
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
	
	public static String returnMessageRrid(String telphone, String messageContent) throws UnsupportedEncodingException{
		String sn="SDK-BBX-010-21023";
		String pwd="b3d1-37_";
		MessageChannelClient client=new MessageChannelClient(sn,pwd);
		//获取信息
		// String result = client.mdgetSninfo();
		// System.out.print(result);
		//短信发送		
		StringBuilder sb = new StringBuilder();
		sb.append(messageContent);
		//sb.append("您正在申请注册OK家注册用户,验证码").append(messageContent).append(",2分钟内有效。【OK家】");
		String content=URLEncoder.encode(sb.toString(), "utf8");
		String result_mt = client.mdsmssend(telphone, content, "", "", "", "");
		// System.out.print(result_mt);
		return result_mt;
	}
	public static void main(String[] args) throws UnsupportedEncodingException {
		returnMessageRrid("13621026736","测试。【OK家】");
	}
}