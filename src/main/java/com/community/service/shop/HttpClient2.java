//package com.community.service.shop;
//
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//
//
//
//
//
//import org.apache.commons.lang.exception.ExceptionUtils;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.HttpStatus;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.protocol.HTTP;
//import org.apache.http.util.EntityUtils;
//import org.codehaus.jettison.json.JSONTokener;
//import org.json.JSONObject;
//
//public class HttpClient2 {
//	// 接口地址
//	private String apiURL = "";
//////	private Log logger = LogFactory.getLog(this.getClass());
//	private static final String pattern = "yyyy-MM-dd HH:mm:ss:SSS";
//	private CloseableHttpClient httpClient = null;
//	private HttpPost method = null;
//	private long startTime = 0L;
//	private long endTime = 0L;
//	private int status = 0;
//
//	/**
//	 * 接口地址
//	 * 
//	 * @param url
//	 */
//	public HttpClient2(String url) {
//
//		if (url != null) {
//			this.apiURL = url;
//		}
//		if (apiURL != null) {
//			httpClient = HttpClients.createDefault();// new DefaultHttpClient();
//			method = new HttpPost(apiURL);
//
//		}
//	}
//
//	/**
//	 * 调用 API
//	 * 
//	 * @param parameters
//	 * @return
//	 */
//	public JSONObject  post(String parameters) {
//		String body = null;
////		logger.info("parameters:" + parameters);
//
//		if (method != null & parameters != null && !"".equals(parameters.trim())) {
//
//			try
//			{
////				HttpClient client = new DefaultHttpClient();
////				HttpPost post = new HttpPost(url);
//				JSONObject response = null;
//				try {
//				StringEntity s = new StringEntity(json.toString());
//				s.setContentEncoding("UTF-8");
//				s.setContentType("application/json");
//				method.setEntity(s);
//				 
//				HttpResponse res = httpClient.execute(method);
//				if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
//				HttpEntity entity = res.getEntity();
//				String charset = EntityUtils.getContentCharSet(entity);
//				response = new JSONObject(new JSONTokener(new InputStreamReader(entity.getContent(),charset)));
//				}
//				} catch (Exception e) {
//				throw new RuntimeException(e);
//				}
//				return response;
//			} catch (IOException e) {
//
//				status = 3;
//			} finally {
//
//			}
//
//		}
//		return body;
//	}
//
//	/**
//	 * 0.成功 1.执行方法失败 2.协议错误 3.网络错误
//	 * 
//	 * @return the status
//	 */
//	public int getStatus() {
//		return status;
//	}
//
//	/**
//	 * @param status
//	 *            the status to set
//	 */
//	public void setStatus(int status) {
//		this.status = status;
//	}
//
//	/**
//	 * @return the startTime
//	 */
//	public long getStartTime() {
//		return startTime;
//	}
//
//	/**
//	 * @return the endTime
//	 */
//	public long getEndTime() {
//		return endTime;
//	}
//	
//	public static void main(String[] args) {
//		
//			HttpClient2 ahc = new HttpClient2("http://121.199.0.31:8080/bu54/ubus/services/thirdm/register");
//			
//			String params = 
//					"[{"+"\r\n"+
//					"     \"typeId\": \"11111111131122\","+"\r\n"+
//					"     \"userId\": \"昵称1\","+"\r\n"+
//					"     \"estateId\": \"222222222\""+"\r\n"+
//					" }]" +//"\r\n"+
//					"";
//			String body = ahc.post(params);
//			System.out.println(body);
//
//	}
//}