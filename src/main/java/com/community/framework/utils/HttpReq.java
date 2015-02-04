package com.community.framework.utils;

import java.net.URI;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;

import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;



/*
 * Post 提交 json 响应 json
 */
public class HttpReq {
	public static JSONObject post(String url, JSONObject json) {
		// HttpClient client = new DefaultHttpClient();
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
			if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String result = EntityUtils.toString(res.getEntity());// 返回json格式
				response = JSONObject.fromObject(result);
			} else {
				System.out.println("Http Code:"+ res.getStatusLine().getStatusCode());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}

	public static CloseableHttpClient createSSLClientDefault() {
		try {
			SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
						// 信任所有
						// public boolean isTrusted(X509Certificate[] chain,
						// String authType) throws CertificateException {
						// return true;
						// }
						 //信任所有
//		                 public boolean isTrusted(X509Certificate[] chain,
//		                                 String authType) throws CertificateException {
//		                     return true;
//		                 }
//						public boolean isTrusted(
//								java.security.cert.X509Certificate[] arg0,
//								String arg1)
//								throws java.security.cert.CertificateException {
//							// TODO Auto-generated method stub
//							return true;
//						}

						public boolean isTrusted(
								java.security.cert.X509Certificate[] arg0,
								String arg1)
								throws java.security.cert.CertificateException {
							// TODO Auto-generated method stub
							
							return true;
						}
					}).build();
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, 
					SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
//			X509HostnameVerifier xv = SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
//			HttpsURLConnection.setDefaultHostnameVerifier( new HostnameVerifier(){
//			    public boolean verify(String string,SSLSession ssls) {
//			        return true;
//			    }
//			});
			//xv.verify(hostname, session)
//			xv = SSLConnectionSocketFactory.STRICT_HOSTNAME_VERIFIER;
//			sslsf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
//			sslsf.STRICT_HOSTNAME_VERIFIER=SSLConnectionSocketFactory.getSocketFactory().ALLOW_ALL_HOSTNAME_VERIFIER
//			SSLSocketFactory.getSocketFactory().setHostnameVerifier(new AllowAllHostnameVerifier()); 

			return HttpClients.custom().setSSLSocketFactory(sslsf).build();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		}
		return HttpClients.createDefault();
	}

	// 应用
	public static JSONObject httpsPost(String url, JSONObject json) {
		// CloseableHttpClient httpClient = createSSLClientDefault();
		// HttpGet get = new HttpGet();
		// get.setURI(new URI("你的https://地址"));
		// httpClient.execute(get）
		CloseableHttpClient httpClient = createSSLClientDefault();
		
		JSONObject response = null;
		try {
			HttpPost post = new HttpPost();
			post.setURI(new URI(url));
			
			
			// 设置http https支持
            
//			ClientConnectionManager gcm = httpClient.getConnectionManager();
			
			
			StringEntity se = new StringEntity(json.toString());
			se.setContentEncoding("UTF-8");
			se.setContentType("application/json");
			post.setEntity(se);
			HttpResponse res = httpClient.execute(post);
			System.out.println(res.getStatusLine());
			
			if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String result = EntityUtils.toString(res.getEntity());// 返回json格式
				response = JSONObject.fromObject(result);
			} else {
				System.out.println("Http Code:"
						+ res.getStatusLine().getStatusCode());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}

	public static void main(String[] args) {

		String url = "https://121.199.0.31/bu54/ubus/services/thirdm/loginValidation";
		JSONObject params = new JSONObject();

		params.put("primobile", "111111111112"); 
		params.put("nickname", "昵称1");
		params.put("userid", "222222222");
		params.put("longitude", "116.427355");
		params.put("latitude", "39.994155");
		params.put("authenticationString", "ebd5eb26df36b1545f1d0445f7f7d1f5");

		System.out.println(params.toString());
		JSONObject xx = httpsPost(url, params);
		System.out.println(xx);
		if (xx != null) {
			System.out.println(xx.get("status"));
			System.out.println(xx.get("token"));
		}

	}
	
	public static CloseableHttpClient createSSLClientDefault1(){
		try {
		             SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {

						public boolean isTrusted(
								java.security.cert.X509Certificate[] arg0,
								String arg1)
								throws java.security.cert.CertificateException {
							// TODO Auto-generated method stub
							return true;
						}
		                 //信任所有
//		                 public boolean isTrusted(X509Certificate[] chain,
//		                                 String authType) throws CertificateException {
//		                     return true;
//		                 }
		             }).build();
		             SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
		             return HttpClients.custom().setSSLSocketFactory(sslsf).build();
		         } catch (KeyManagementException e) {
		             e.printStackTrace();
		         } catch (NoSuchAlgorithmException e) {
		             e.printStackTrace();
		         } catch (KeyStoreException e) {
		             e.printStackTrace();
		         }
		         return  HttpClients.createDefault();
		}
}
