package com.community.framework.utils;



import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

/**
 * 短信工具类
 * 
 */
public class messagesUtil {
	static String sn="SDK-BBX-010-21023";
	static String pwd="b3d1-37_";
	
	public static String returnMessageRrid(String telphone, String messageContent) throws UnsupportedEncodingException{
		
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
