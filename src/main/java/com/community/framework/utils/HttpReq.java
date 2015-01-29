package com.community.framework.utils;

import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
/*
 * Post 提交 json 响应 json
 */
public class HttpReq {
    public static JSONObject post(String url,JSONObject json){  
//        HttpClient client = new DefaultHttpClient();  
    	System.out.println("request url: " + url);
        CloseableHttpClient client = HttpClients.createDefault();  
        HttpPost post = new HttpPost(url);  
        JSONObject response = null;  
        try {  
            StringEntity se = new StringEntity(json.toString());  
            se.setContentEncoding("UTF-8");  
            se.setContentType("application/json");  
            post.setEntity(se);
            HttpResponse res = client.execute(post);  
            if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){                 
                String result = EntityUtils.toString(res.getEntity());// 返回json格式
                response = JSONObject.fromObject(result);
            }else
            {
            	System.out.println("Http Code:"+res.getStatusLine().getStatusCode() );
            }
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
        return response;  
    }  
    
    public static void main(String[] args) {
    				 
    	String url = "http://121.199.0.31:8080/bu54/ubus/services/thirdm/loginValidation";
    	JSONObject params = new JSONObject();
    	
    	params.put("primobile",  "111111111112");
    	params.put("nickname",  "昵称1");
    	params.put("userid",  "222222222");
    	params.put("longitude",  "116.427355");
    	params.put("latitude",  "39.994155");
    	
    	System.out.println(params.toString());
		JSONObject xx = post(url,params);
		if (xx != null)
		{
			System.out.println(xx.get("status"));
			System.out.println(xx.get("token"));
		}
		
		
	}
}
