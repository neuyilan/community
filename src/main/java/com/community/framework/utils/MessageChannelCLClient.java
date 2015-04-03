package com.community.framework.utils;
import com.bcloud.msg.http.HttpSender;
/*
 * 创蓝短信验证码服务接口
 */
public class MessageChannelCLClient {
	
	private static String uri = "http://222.73.117.158/msg/HttpBatchSendSM"; //应用地址
	private static String account = "jiekou-cs-01"; //账号
	private static String pswd = "Tch147256"; //密码
	private static boolean needstatus = true; //是否需要状态报告，需要true，不需要false
	private static String product = ""; //产品ID
	private static String extno = "";	 //扩展码
	
	/*
	 * 群发短信方法
	 */
	public static String batchSend(String mobiles, String content) {
		String result = "";
		try {
			String resultCode = HttpSender.batchSend(uri, account, pswd, mobiles, content, needstatus, product, extno);
			String[] resultArr = resultCode.split(",");
			if(resultArr.length == 2) {
				if(Integer.parseInt(resultArr[1].substring(0, 1)) == 0) {
					result = getReturnCode(Integer.parseInt(resultArr[1].substring(0, 1)));
				} else {
					result = getReturnCode(Integer.parseInt(resultArr[1].substring(0, 3)));
				}
			} else {
				result = "返回码格式错误" + resultCode;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/*
	 * TODO 处理返回值,参见HTTP协议文档
	 */
	public static String getReturnCode(int code) {
		String result;
		switch (code) {
			case 0:
				result = "提交成功";
				break;
			case 101:
				result = "无此用户";
				break;
			case 102:
				result = "密码错";
				break;
			case 103:
				result = "提交过快（提交速度超过流速限制）";
				break;
			case 104:
				result = "系统忙（因平台侧原因，暂时无法处理提交的短信）";
				break;
			case 105:
				result = "敏感短信（短信内容包含敏感词）";
				break;
			case 106:
				result = "消息长度错（>536或<=0）";
				break;
			case 107:
				result = "包含错误的手机号码";
				break;
			case 108:
				result = "手机号码个数错（群发>50000或<=0;单发>200或<=0）";
				break;
			case 109:
				result = "无发送额度（该用户可用短信数已使用完）";
				break;
			case 110:
				result = "不在发送时间内";
				break;
			case 111:
				result = "超出该账户当月发送额度限制";
				break;
			case 112:
				result = "无此产品，用户没有订购该产品";
				break;
			case 113:
				result = "extno格式错（非数字或者长度不对）";
				break;
			case 115:
				result = "自动审核驳回";
				break;
			case 116:
				result = "签名不合法，未带签名（用户必须带签名的前提下）";
				break;
			case 117:
				result = "IP地址认证错,请求调用的IP地址不是系统登记的IP地址";
				break;
			case 118:
				result = "用户没有相应的发送权限";
				break;
			case 119:
				result = "用户已过期";
				break;
			default :
				result = "未知错误";
		}
		return result;
	}
	
	public static void main(String[] args) {
		try {
			String result = batchSend("18618166710,15001300375", "验证码：123456");
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}