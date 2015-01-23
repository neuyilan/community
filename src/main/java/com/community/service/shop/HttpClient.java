//package com.community.service.shop;
//
//import java.io.BufferedInputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLEncoder;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map.Entry;
//
//
//public class HttpClient {
//	public static HttpRequestResult doGet(String url, HashMap<String, String> params) throws Exception{
//		
//		String strParams = "";
//		if(params != null && !params.isEmpty()){
//			strParams = buildHttpRequest(params);
//		}
//		
//		URL getUrl = new URL(url + "?" + strParams); 
//		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection(); 
//		
//		
//        connection.connect(); 
//        HttpRequestResult result = new HttpRequestResult();
//        int rcode = connection.getResponseCode();
//        result.setResponseCode(rcode);
//        if(rcode != 200){}
//        
//        BufferedInputStream reader = new BufferedInputStream(
//        		 connection.getInputStream());
//        byte[] buf = new byte[1024];
//        int bytesReaded = 0;
//        StringBuffer strBuf = new StringBuffer();
//        while((bytesReaded = reader.read(buf)) != -1){
//        	strBuf.append(new String(buf, 0, bytesReaded));
//        }
//        
//        result.setResponseBody(strBuf.toString());
//        return result;
//	}
//	
//public static HttpRequestResult doPost(String url, HashMap<String, String> params) throws Exception{
//		
//		String strParams = "";
//		if(params != null && !params.isEmpty()){
//			strParams = buildHttpRequest(params);
//		}
//		
//		URL getUrl = new URL(url); 
//		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
//		connection.setRequestMethod("POST");
//		connection.setDoOutput(true);
//		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
//		//connection.set
//		connection.getOutputStream().write(strParams.getBytes("utf-8"));
//		connection.connect(); 
////		connection.setConnectTimeout('300');
//         
//        HttpRequestResult result = new HttpRequestResult();
//        int rcode = connection.getResponseCode();
//        result.setResponseCode(rcode);
//        if(rcode != 200){}
//        
//        BufferedInputStream reader = new BufferedInputStream(
//        		 connection.getInputStream());
//        byte[] buf = new byte[1024];
//        int bytesReaded = 0;
//        StringBuffer strBuf = new StringBuffer();
//        while((bytesReaded = reader.read(buf)) != -1){
//        	strBuf.append(new String(buf, 0, bytesReaded));
//        }
//        
//        result.setResponseBody(strBuf.toString());
//        return result;
//	}
//	
//	
//	public static String buildHttpRequest(HashMap<String, String> params) throws Exception{
//		Iterator<Entry<String, String>> iter = params.entrySet().iterator();
//		StringBuffer strBuf = new StringBuffer();
//
//		while (iter.hasNext()) {
//			Entry<String, String> entry = iter.next();
//			String key = entry.getKey();
//			String val = URLEncoder.encode(entry.getValue(), "utf-8");
//			strBuf.append(key + "=" + val + "&");
//		}
//		return strBuf.substring(0, strBuf.length()-1);
//	}
//}
