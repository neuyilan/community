package com.community.framework.utils;

/**
 * Created with IntelliJ IDEA.
 * User: victor
 * Date: 13-10-11
 * Time: 下午3:09
 * To change this template use File | Settings | File Templates.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;

import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 代码展示了如果使用ssl context创建安全socket连接
 */
public class ClientCustomSSL {

	public final static void main(String[] args) throws Exception {
		
		//String url = "https://121.199.0.31/bu54/ubus/services/thirdm/loginValidation";
		String url = "https://121.199.0.31/bu54/ubus/services/thirdm/loginValidation";

    	JSONObject params = new JSONObject();
    	
    	params.put("primobile",  "111111111112");
    	params.put("nickname",  "昵称1");
    	params.put("userid",  "222222222");
    	params.put("longitude",  "116.427355");
    	params.put("latitude",  "39.994155");
    	params.put("authenticationString",  "ebd5eb26df36b1545f1d0445f7f7d1f5");
    	
    	System.out.println(params.toString());
		JSONObject xx = httpPost("C:\\Users\\Administrator\\Desktop\\bu54.store",url,params);
		System.out.println(xx);
		if (xx != null)
		{
			System.out.println(xx.get("status"));
			System.out.println(xx.get("token"));
		}
	}

	public static JSONObject httpPost(String cerPath, String url, JSONObject json) {
		try {
			
			KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
			// 加载证书文件  cerPaht
			//String cerFile = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("");
			FileInputStream instream = new FileInputStream(new File(cerPath));
//			FileInputStream instream = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\bu54.store"));
			try {
				trustStore.load(instream, "bu54xx".toCharArray());
			} finally {
				instream.close();
			}
			
			SSLContext sslcontext = SSLContexts.custom().loadTrustMaterial(trustStore).build();

			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext,
					SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER );//BROWSER_COMPATIBLE_HOSTNAME_VERIFIER
					
			CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();

			HttpPost post = new HttpPost(url);
			JSONObject response = null;

			StringEntity se = new StringEntity(json.toString());
			se.setContentEncoding("UTF-8");
			se.setContentType("application/json");
			post.setEntity(se);
			HttpResponse res = httpclient.execute(post);
			if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String result = EntityUtils.toString(res.getEntity());// 返回json格式
				response = JSONObject.fromObject(result);
			} else {
				System.out.println("Http Code:"
						+ res.getStatusLine().getStatusCode());
			}
			return response;
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

}
