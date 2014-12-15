package com.community.app.module.push;

import java.util.Map;

import net.sf.json.JSONObject;

import com.baidu.yun.channel.auth.ChannelKeyPair;
import com.baidu.yun.channel.client.BaiduChannelClient;
import com.baidu.yun.channel.exception.ChannelClientException;
import com.baidu.yun.channel.exception.ChannelServerException;
import com.baidu.yun.channel.model.PushUnicastMessageRequest;
import com.baidu.yun.channel.model.PushUnicastMessageResponse;
import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;

public class AppPushNotificationUtil {

	//private static final String apiKey = "I33gkje52QsuMfTGsj9pAAg7";
	//private static final String secretKey = "XMZYGMvChe5TbF5rlSGqAmY1TifCKFki";
	
	/**
	 * 发送单播通知  device_type => 1: web 2: pc 3:android 4:ios 5:wp
	 * @param title
	 * @param description
	 * @param deviceType
	 * 返回值 0：成功， 1：失败
	 * @throws ChannelServerException 
	 */
	public static Integer pushNotification(
			String title, 
			String description, 
			Integer deviceType,
			Long channelId,
			String userId,
			Map paramMap
			) {
		Integer success = 1;
		String apiKey = "I33gkje52QsuMfTGsj9pAAg7";
        String secretKey = "XMZYGMvChe5TbF5rlSGqAmY1TifCKFki";
		//String apiKey = "Z6usnGeLGeecxzyoScM9HG5E";
        //String secretKey = "DsLVSPmfB4swM4jHEvn3fWETrpBjSigi";
		ChannelKeyPair pair = new ChannelKeyPair(apiKey, secretKey);

        // 2. 创建BaiduChannelClient对象实例
        BaiduChannelClient channelClient = new BaiduChannelClient(pair);
        // 3. 若要了解交互细节，请注册YunLogHandler类
        channelClient.setChannelLogHandler(new YunLogHandler() {
            public void onHandle(YunLogEvent event) {
                System.out.println(event.getMessage());
            }
        });
        try {
            // 4. 创建请求类对象
            // 手机端的ChannelId， 手机端的UserId， 先用1111111111111代替，用户需替换为自己的
            PushUnicastMessageRequest request = new PushUnicastMessageRequest();
            //request.setDeviceType(3); // device_type => 1: web 2: pc 3:android 4:ios 5:wp
            
            //拼装自定义参数字符串
            String customParam = "";
            JSONObject paraJson = null;
            if(paramMap != null) {
            	paraJson = JSONObject.fromObject(paramMap);
            	customParam = paraJson.toString();
            }
                        
            request.setDeviceType(deviceType);
            /*System.out.println("title" + title);
            System.out.println("description" + description);
            System.out.println("deviceType" + deviceType);
            System.out.println("channelId" + channelId);
            System.out.println("userId" + userId);*/
            if(deviceType == DeviceTypeConst.ANDROID) {
            	request.setMessage("{\"title\":\""+title+"\",\"description\":\""+description+"\",\"open_type\":\"2\",\"custom_content\":"+customParam+"}");
            }else if(deviceType == DeviceTypeConst.IOS) {
            	request.setMessage("{\"aps\":{\"alert\":\""+description+"\",\"sound\":\"default\",\"badge\":\"1\"},\"open_type\":\"2\",\"custom_content\":"+customParam+"}");
            	request.setDeployStatus(2);//开发模式
            	//request.setDeployStatus(1);//开发模式
            }                
            request.setChannelId(channelId);
            request.setUserId(userId);

            request.setMessageType(1);
            

            // 5. 调用pushMessage接口
            PushUnicastMessageResponse response = channelClient.pushUnicastMessage(request);

            // 6. 认证推送成功
            System.out.println("push amount : " + response.getSuccessAmount());
            success = 0;
        } catch (ChannelClientException e) {
            // 处理客户端错误异常
            e.printStackTrace();
        } catch (ChannelServerException e) {
            // 处理服务端错误异常
            System.out.println(String.format(
                    "request_id: %d, error_code: %d, error_message: %s",
                    e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
        }
        return success;
	}
	
	/**
	 * 发送广播通知  device_type => 1: web 2: pc 3:android 4:ios 5:wp
	 * @param title
	 * @param description
	 * @param deviceType
	 */
	public static boolean pushBroadcastNotification(
			String title, 
			String description, 
			Integer deviceType) {
		boolean success = false;
		String apiKey = "I33gkje52QsuMfTGsj9pAAg7";
        String secretKey = "XMZYGMvChe5TbF5rlSGqAmY1TifCKFki";
		ChannelKeyPair pair = new ChannelKeyPair(apiKey, secretKey);

        // 2. 创建BaiduChannelClient对象实例
        BaiduChannelClient channelClient = new BaiduChannelClient(pair);
        // 3. 若要了解交互细节，请注册YunLogHandler类
        channelClient.setChannelLogHandler(new YunLogHandler() {
            public void onHandle(YunLogEvent event) {
                System.out.println(event.getMessage());
            }
        });
        try {
            // 4. 创建请求类对象
            // 手机端的ChannelId， 手机端的UserId， 先用1111111111111代替，用户需替换为自己的
            PushUnicastMessageRequest request = new PushUnicastMessageRequest();
            //request.setDeviceType(3); // device_type => 1: web 2: pc 3:android 4:ios 5:wp
            if(deviceType != null) {
            	request.setDeviceType(deviceType); 
            }                                     

            request.setMessageType(1);
            request.setMessage("{\"title\":\""+title+"\",\"description\":\""+description+"\"}");

            // 5. 调用pushMessage接口
            PushUnicastMessageResponse response = channelClient.pushUnicastMessage(request);

            // 6. 认证推送成功
            System.out.println("push amount : " + response.getSuccessAmount());
            
        } catch (ChannelClientException e) {
            // 处理客户端错误异常
            e.printStackTrace();
        } catch (ChannelServerException e) {
            // 处理服务端错误异常
            System.out.println(String.format(
                    "request_id: %d, error_code: %d, error_message: %s",
                    e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
        }
        return success;
	}
	
	
	/**
	 * 发送单播消息
	 * 返回值 0：成功， 1：失败
	 * @throws ChannelServerException 
	 */
	public static Integer AndroidPushMessageSample(
			Long channelId,
			String userId,
			Map paramMap
			) {
		Integer success = 1;
        /*
         * @brief 推送单播消息(消息类型为透传，由开发方应用自己来解析消息内容) message_type = 0 (默认为0)
         */

        // 1. 设置developer平台的ApiKey/SecretKey
        String apiKey = "I33gkje52QsuMfTGsj9pAAg7";
        String secretKey = "XMZYGMvChe5TbF5rlSGqAmY1TifCKFki";
        ChannelKeyPair pair = new ChannelKeyPair(apiKey, secretKey);

        // 2. 创建BaiduChannelClient对象实例
        BaiduChannelClient channelClient = new BaiduChannelClient(pair);

        // 3. 若要了解交互细节，请注册YunLogHandler类
        channelClient.setChannelLogHandler(new YunLogHandler() {
            public void onHandle(YunLogEvent event) {
                System.out.println(event.getMessage());
            }
        });
        try {
        	 // 4. 创建请求类对象
            // 手机端的ChannelId， 手机端的UserId， 先用1111111111111代替，用户需替换为自己的
            PushUnicastMessageRequest request = new PushUnicastMessageRequest();
            request.setDeviceType(3); // device_type => 1: web 2: pc 3:android
                                      // 4:ios 5:wp
            request.setChannelId(channelId);
            request.setUserId(userId);
          //拼装自定义参数字符串
            String customParam = "";
            JSONObject paraJson = null;
            if(paramMap != null) {
            	paraJson = JSONObject.fromObject(paramMap);
            	customParam = paraJson.toString();
            }

            request.setMessage(customParam);
            //request.setMessage("{\"title\":\"111\",\"open_type\":\"2\",\"description\":\"111\",\"custom_content\":{\"messageType\":\"15\"}}");
            // 5. 调用pushMessage接口
            PushUnicastMessageResponse response = channelClient
                    .pushUnicastMessage(request);

            // 6. 认证推送成功
            System.out.println("push amount : " + response.getSuccessAmount());
            success = 0;
        } catch (ChannelClientException e) {
            // 处理客户端错误异常
            e.printStackTrace();
        } catch (ChannelServerException e) {
            // 处理服务端错误异常
            System.out.println(String.format(
                    "request_id: %d, error_code: %d, error_message: %s",
                    e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
        }
        return success;
	}
	
	public static void main(String[] args) {

        /*
         * @brief 推送单播通知(Android Push SDK拦截并解析) message_type = 1 (默认为0)
         */

        // 1. 设置developer平台的ApiKey/SecretKey
        String apiKey = "I33gkje52QsuMfTGsj9pAAg7";
        String secretKey = "XMZYGMvChe5TbF5rlSGqAmY1TifCKFki";
        ChannelKeyPair pair = new ChannelKeyPair(apiKey, secretKey);

        // 2. 创建BaiduChannelClient对象实例
        BaiduChannelClient channelClient = new BaiduChannelClient(pair);

        // 3. 若要了解交互细节，请注册YunLogHandler类
        channelClient.setChannelLogHandler(new YunLogHandler() {
            public void onHandle(YunLogEvent event) {
                System.out.println(event.getMessage());
            }
        });

        try {

            // 4. 创建请求类对象
            // 手机端的ChannelId， 手机端的UserId， 先用1111111111111代替，用户需替换为自己的
            PushUnicastMessageRequest request = new PushUnicastMessageRequest();
            //request.setDeviceType(3); // device_type => 1: web 2: pc 3:android
            request.setDeviceType(4);                          // 4:ios 5:wp
            String channelId = "4693848578141770886";
            request.setChannelId(Long.valueOf(channelId).longValue());
            request.setUserId("1132382359257778536");

            request.setMessageType(1);
        	request.setMessage("{\"aps\":{\"alert\":\""+1+"\",\"sound\":\"default\",\"badge\":\"1\"},\"open_type\":\"2\",\"custom_content\":"+1+"}");

            // 5. 调用pushMessage接口
            PushUnicastMessageResponse response = channelClient
                    .pushUnicastMessage(request);

            // 6. 认证推送成功
            System.out.println("push amount : " + response.getSuccessAmount());

        } catch (ChannelClientException e) {
            // 处理客户端错误异常
            e.printStackTrace();
        } catch (ChannelServerException e) {
            // 处理服务端错误异常
            System.out.println(String.format(
                    "request_id: %d, error_code: %d, error_message: %s",
                    e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
        }

    }
    
	
    public static void test() {
		System.out.println("发的法师打发士大夫");

        /*
         * @brief 推送单播通知(Android Push SDK拦截并解析) message_type = 1 (默认为0)
         */

        // 1. 设置developer平台的ApiKey/SecretKey
        String apiKey = "I33gkje52QsuMfTGsj9pAAg7";
        String secretKey = "XMZYGMvChe5TbF5rlSGqAmY1TifCKFki";
        ChannelKeyPair pair = new ChannelKeyPair(apiKey, secretKey);

        // 2. 创建BaiduChannelClient对象实例
        BaiduChannelClient channelClient = new BaiduChannelClient(pair);

        // 3. 若要了解交互细节，请注册YunLogHandler类
        channelClient.setChannelLogHandler(new YunLogHandler() {
            public void onHandle(YunLogEvent event) {
                System.out.println(event.getMessage());
            }
        });

        try {

            // 4. 创建请求类对象
            // 手机端的ChannelId， 手机端的UserId， 先用1111111111111代替，用户需替换为自己的
            PushUnicastMessageRequest request = new PushUnicastMessageRequest();
            //request.setDeviceType(3); // device_type => 1: web 2: pc 3:android
            request.setDeviceType(4);                          // 4:ios 5:wp
            String channelId = "4693848578141770886";
            request.setChannelId(Long.valueOf(channelId).longValue());
            request.setUserId("1132382359257778536");

            request.setMessageType(1);
            request.setMessage("{\"title\":\"Notify_title_danbo916\",\"description\":\"Notify_description_content\"}");

            // 5. 调用pushMessage接口
            PushUnicastMessageResponse response = channelClient
                    .pushUnicastMessage(request);

            // 6. 认证推送成功
            System.out.println("push amount : " + response.getSuccessAmount());

        } catch (ChannelClientException e) {
            // 处理客户端错误异常
            e.printStackTrace();
        } catch (ChannelServerException e) {
            // 处理服务端错误异常
            System.out.println(String.format(
                    "request_id: %d, error_code: %d, error_message: %s",
                    e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
        }
	}
	
}
