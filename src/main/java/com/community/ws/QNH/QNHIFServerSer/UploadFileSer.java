package com.community.ws.QNH.QNHIFServerSer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import net.sf.json.JSONObject;
/**
 *  @autor baidd 
 *  参考实现：
 *  http://blog.csdn.net/thinkpadshi/article/details/8173765
 *  http://huangqiqing123.iteye.com/blog/1455169
 */
public class UploadFileSer {
	 /* 
     * 文件上传服务 
     */  
    public String uploadFile(String fileName,DataHandler dataHandler)  
    {  
    	
		//SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		//String dateString = sf.format(new Date());
    	String fileExt = "."+ fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
    	String newFileName =  new Timestamp(System.currentTimeMillis()).getTime() + fileExt;
    	String picPath = "F:\\"+fileName ;//= "/image/forderName/" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "/" + newFileName;
		String tmp;
		System.out.println(dataHandler.getDataSource());
//		if (222/1024 > 100)
//			 tmp = "tmp/";
//		else
//			tmp="";
//		String tmpPicDir = this.url +"/" + tmp;//"/tmp/";

    	JSONObject retJson = new JSONObject();
        OutputStream os = null;  
        try{  
            os = new FileOutputStream(picPath);  //"F:\\"+fileName
            dataHandler.writeTo(os);//大附件也会出现内存溢出  
            os.flush();  
        }catch (Exception e){  
            e.printStackTrace();  
            retJson.element("success", false);
            retJson.element("message", "文件传输失败！");
            return retJson.toString();  
        }finally{  
            try {  
                os.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }     
        }  
        retJson.element("success", true);
        retJson.element("message", "文件传输失败！");
        retJson.element("filePath", picPath);
        return "";  
    }  
    /* 
     * 文件下载服务 
     */  
    public DataHandler downloadFile()  
    {  
        String filepath = "F:\\head.jpg";  
        DataHandler dataHandler = new DataHandler(new FileDataSource(filepath));  
        return dataHandler;  
    }
    
//    public static void main(String[] args) {
//    	JSONObject retJson = new JSONObject();
//        retJson.element("success", "false");
//        retJson.element("message", "文件传输失败！");
//        System.out.println(retJson);
//        System.out.println(retJson.get("success"));
//        
//	}
}
