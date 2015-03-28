package com.community.framework.utils;



import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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
	
	public static String returnMessageRridSpeech(String telphone, String messageContent) throws UnsupportedEncodingException{
		
		MessageChannelClient client=new MessageChannelClient(sn,pwd);
		String result_mt = client.mdAudioSend("验证码", telphone, messageContent, "", "", "");
		return result_mt;
	}
	
	public static String digitalConversion(String code) throws UnsupportedEncodingException{
		String str = "";
		String[] arr = code.split("");
		for (int i = 0; i < arr.length; i++) {
			switch (arr[i]) {
			case "0":
				str += "零";
				break;
			case "1":
				str += "一";
				break;
			case "2":
				str += "二";
				break;
			case "3":
				str += "三";
				break;
			case "4":
				str += "四";
				break;
			case "5":
				str += "五";
				break;
			case "6":
				str += "六";
				break;
			case "7":
				str += "七";
				break;
			case "8":
				str += "八";
				break;
			case "9":
				str += "九";
				break;
			default:
				break;
			}
		}
		return str;
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		//String aaString =returnMessageRrid("13910830458","【罗马嘉园西区驿站】尊贵的主人，我是您的快件。现已到达社区服务驿站，请您快来社区服务驿站接我吧！驿站电话:58627223取件签收码：885061请妥善保管；为了让尊贵的主人享受更便捷的服务，驿站专属手机社区服务平台“OK家”已经发布了，猛戳后边链接，也把他接回家吧：http://www.bqsqcm.com/community/download/index.html?id=11【OK家】");
		System.out.println(digitalConversion("786215"));
	}
}
