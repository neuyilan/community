package com.community.service.shop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class APIHttpClient {
	// 接口地址
	private String apiURL = "";
////	private Log logger = LogFactory.getLog(this.getClass());
	private static final String pattern = "yyyy-MM-dd HH:mm:ss:SSS";
	private CloseableHttpClient httpClient = null;
	private HttpPost method = null;
	private long startTime = 0L;
	private long endTime = 0L;
	private int status = 0;

	/**
	 * 接口地址
	 * 
	 * @param url
	 */
	public APIHttpClient(String url) {

		if (url != null) {
			this.apiURL = url;
		}
		if (apiURL != null) {
			httpClient = HttpClients.createDefault();// new DefaultHttpClient();
			method = new HttpPost(apiURL);

		}
	}

	/**
	 * 调用 API
	 * 
	 * @param parameters
	 * @return
	 */
	public String post(String parameters) {
		String body = null;
//		logger.info("parameters:" + parameters);

		if (method != null & parameters != null && !"".equals(parameters.trim())) {
//			JSONArray jsonObject = JSONArray.fromObject(parameters);
//			logger.info("json:" + jsonObject.toString());
			try {
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				// 建立一个NameValuePair数组，用于存储欲传送的参数
				params.add(new BasicNameValuePair("data", parameters));
				// 添加参数
				method.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
//				method.addRequestHeader("Content-Type","text/html;charset=UTF-8");  
				startTime = System.currentTimeMillis();
				// 设置请求和传输超时时间
				RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
				method.setConfig(requestConfig);
				// 设置编码
				
				HttpResponse response = httpClient.execute(method);
				
				endTime = System.currentTimeMillis();
				int statusCode = response.getStatusLine().getStatusCode();
//				logger.info("statusCode:" + statusCode);
//				logger.info("调用API 花费时间(单位：毫秒)：" + (endTime - startTime));
				if (statusCode != HttpStatus.SC_OK) {
//					logger.error("Method failed:" + response.getStatusLine());
					status = 1;
				}
				// Read the response body
				body = EntityUtils.toString(response.getEntity());
				
			} catch (IOException e) {
				// 发生网络异常
//				logger.error("exception occurred!\n"						+ ExceptionUtils.getFullStackTrace(e));
				// 网络错误
				status = 3;
			} finally {
//				logger.info("调用接口状态：" + status);
			}

		}
		return body;
	}

	/**
	 * 0.成功 1.执行方法失败 2.协议错误 3.网络错误
	 * 
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the startTime
	 */
	public long getStartTime() {
		return startTime;
	}

	/**
	 * @return the endTime
	 */
	public long getEndTime() {
		return endTime;
	}
	
	public static void main(String[] args) {
		
			APIHttpClient ahc = new APIHttpClient("http://121.199.0.31:8080/bu54/ubus/services/thirdm/register");
			
			String params = 
					"[{"+"\r\n"+
					"     \"typeId\": \"11111111131122\","+"\r\n"+
					"     \"userId\": \"昵称1\","+"\r\n"+
					"     \"estateId\": \"222222222\""+"\r\n"+
					" }]" +//"\r\n"+
					"";
			String body = ahc.post(params);
			System.out.println(body);

	}
}