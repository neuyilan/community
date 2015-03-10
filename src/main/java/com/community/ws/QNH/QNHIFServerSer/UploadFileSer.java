package com.community.ws.QNH.QNHIFServerSer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.activation.DataHandler;

import net.sf.json.JSONObject;

import com.community.framework.utils.CompressPicDemo;
/**
 *  @autor baidd 
 *  @desc 文件上传接口
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
    	
    	JSONObject retJson = new JSONObject();
        OutputStream os = null; 
        retJson.element("errorCode", 200);
        retJson.element("message", "文件传输成功！");
        JSONObject retJsonChild = new JSONObject();
        String picPath = "";
        File tmpfile =  null;
        String retPath = "";
        
        try{  
        	String fileExt = "."+ fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
        	String newFileName =  new Timestamp(System.currentTimeMillis()).getTime() + fileExt;
    		String path = this.getClass().getResource("/").getPath();
    		System.out.println(path);
    		if (path.endsWith("/WEB-INF/classes/"))
    			path = path.substring(0,path.indexOf("/WEB-INF/classes/"));
    		String dir =  path + "/image/activity/" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "/tmp/";
            picPath = dir + newFileName;
            retPath = "/image/activity/" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +"/"+ newFileName;
            
        	File fileDir = new File(java.net.URLDecoder.decode(dir,"utf-8") );
        	fileDir.mkdirs();
        	if (fileDir.exists())
        		System.out.println("------>"+fileDir.getPath());
        	
            os = new FileOutputStream(java.net.URLDecoder.decode(picPath,"utf-8") );  //"F:\\"+fileName
            dataHandler.writeTo(os);//大附件也会出现内存溢出  
            os.flush();
            tmpfile = new File(java.net.URLDecoder.decode(picPath,"utf-8") );
            System.out.println("------>"+tmpfile.length()/1024);
            retJsonChild.element("filePath", retPath);
            retJson.put("data", retJsonChild);
        }catch (Exception e){  
            e.printStackTrace();  
            retJson.element("errorCode", 400);
            retJson.element("message", "文件传输失败！");
            retJsonChild = new JSONObject();
            retJsonChild.element("filePath", "");
            retJson.put("data", retJsonChild);
           // return retJson.toString();  // return放在try-finally块中不合理
        }finally{  
            try {
                os.close();
            } catch (IOException e){
                retJson.element("errorCode", 400);
                retJson.element("message", "文件传输失败！");
                retJsonChild = new JSONObject();
                retJsonChild.element("filePath", "");
                e.printStackTrace();
            }     
        }  
        if ("200".equals(String.valueOf(retJson.get("errorCode"))))
        {
        	/*压缩图片对方实现 */
        	System.out.println("tmp"+File.separator);
        	String realPath = tmpfile.getPath().replaceAll("tmp", ""); 
        	File dstFile = new File(realPath); 
        	if (tmpfile.exists() && tmpfile.length() !=0 ){
	            if (tmpfile.length()/1024>100)
	            {
					CompressPicDemo cpd = new CompressPicDemo();
	            	cpd.compressPic(tmpfile.getPath(), realPath,  100, 100, true);
	            }else
	            	tmpfile.renameTo(dstFile);
	            if (dstFile.exists())
	            	tmpfile.delete();
        	}
        }
        
        return retJson.toString();  
    }  
    /* 
     * 文件下载服务 
     */  
//    public DataHandler downloadFile()  
//    {  
//        String filepath = "F:\\head.jpg";  
//        DataHandler dataHandler = new DataHandler(new FileDataSource(filepath));  
//        return dataHandler;  
//    }

}
