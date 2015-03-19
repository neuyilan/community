package com.community.ws.QNH.QNHIFServer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.activation.DataHandler;

import net.sf.json.JSONObject;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMText;
import org.apache.axis2.context.MessageContext;

import com.community.framework.utils.CompressPicDemo;
import com.community.ws.common.HeaderOMElement;
/**
 *  @autor baidd 
 *  @desc 2.1.8	文件上传接口
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
    	
    	JSONObject json = new JSONObject();
		json.element("errorCode", 200).element("message", "文件传输成功!");
		MessageContext msgContext = MessageContext.getCurrentMessageContext();
		/**暂时解决方案*/
		Iterator<?> list = msgContext.getEnvelope().getBody().getFirstElement().getChildElements();
		while (list.hasNext()) {
			OMElement element = (OMElement) list.next();;
			if (element.getLocalName().equals("fileName"))
				fileName = element.getText();
			OMText binaryNode ;
			if (element.getLocalName().equals("dataHandler"))
			{
				binaryNode = (OMText) element.getFirstOMChild();
				binaryNode.setOptimize(true); //必须加此句，否则会出现ContentID is null的异常!  
				dataHandler = (DataHandler) binaryNode.getDataHandler();
			}
		}
		
		/**校验 qhn WS 用户密码*/
		if(!HeaderOMElement.checkWSUser(msgContext))
		{
			json.element("errorCode", 400).element("message", "新增活动失败 ， 用户名或密码错误！");
			return json.toString();
		}
    	
        OutputStream os = null; 
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
            json.put("data", retJsonChild);
        }catch (Exception e){  
            e.printStackTrace();  
            json.element("errorCode", 400).element("message", "文件传输失败！");
            retJsonChild = new JSONObject();
            retJsonChild.element("filePath", "");
            json.put("data", retJsonChild);
           // return retJson.toString();  // return放在try-finally块中不合理
        }finally{  
            try {
                os.close();
            } catch (IOException e){
                json.element("errorCode", 400).element("message", "文件传输失败！");
                retJsonChild = new JSONObject();
                retJsonChild.element("filePath", "");
                e.printStackTrace();
            }     
        }  
        if ("200".equals(String.valueOf(json.get("errorCode"))))
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
        
        return json.toString();  
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
