package com.community.app.module.common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import freemarker.cache.FileTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


/**
 * 使用FreeMarker自动生成html5静态页面到指定路径
 * @author zyp-2_000
 *
 */
public class StaticFileGen {
	private final static Log logger = LogFactory.getLog(StaticFileGen.class); 
	
	private Configuration configuration = null ;
	
	/**
	 * 读取freemarer配置
	 * @return
	 */
	protected Configuration getFreeMarkerCFG() { 
		if( null == configuration) { 
			configuration = new Configuration(); 
			configuration.setDefaultEncoding("UTF-8");
		}     
		return configuration; 
	}  
	
	/**
	 * 生成静态文件
	 * @param request 请求对象
	 * @param templateFileName 模板文件名
	 * @param propMap 数据Map
	 * @param genFilePath 生成文件存放文件夹
	 * @param genFileName 生成的文件名
	 * @return
	 */
	public String genHtmlFile(HttpServletRequest request, String templateFileName, Map propMap, String genFilePath, String genFileName) { 
	    

/*
			Map propMap = new HashMap();
			String path = request.getContextPath();
			String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 
			propMap.put("ctx", ctx);
			propMap.put("newsId", 1);
			propMap.put("publisherName", "发布人");
	        propMap.put("publishTime", "2014-08-07 12:23");
			propMap.put("title", "文章标题");
			propMap.put("content", "文章内容");
			propMap.put("protrait", "");
			propMap.put("supports", 121);
			List commentList = new ArrayList();
			Map commentMap = new HashMap();
			commentMap.put("commentId", 1);
			commentMap.put("commentorName", "评论人1");
			commentMap.put("content", "评论内容1");
			commentMap.put("commentTime", "2014-08-07 12:23");
			commentList.add(commentMap);
			commentMap = new HashMap();
			commentMap.put("commentId", 2);
			commentMap.put("commentorName", "评论人2");
			commentMap.put("content", "评论内容2");
			commentMap.put("commentTime", "2014-08-07 12:23");
			commentList.add(commentMap);
			propMap.put("commentList", commentList);
			StaticFileGen gen = new StaticFileGen();
			String htmlPath = gen.genHtmlFile(request, "newsInfo.ftl", propMap, "news", String.valueOf(new Timestamp(System.currentTimeMillis()).getTime())+".html");
			
			*/
			
		
		//从配置中取得要静态文件存放的根路径:需要改为自己的属性类调用  
		String path = request.getContextPath();
	    String filePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 
	    String context = request.getSession().getServletContext().getRealPath("/");
	    String templatePath = context +"WEB-INF/ftl/";
	    try { 
	    	TemplateLoader templateLoader=null;  
            //使用FileTemplateLoader  
            templateLoader = new FileTemplateLoader(new File(templatePath));
            getFreeMarkerCFG().setTemplateLoader(templateLoader);
	    	
	        Template t = getFreeMarkerCFG().getTemplate(templateFileName);   
	        //如果根路径存在,则递归创建子目录
	        String dateString = new Timestamp(System.currentTimeMillis()).toString().substring(0, 10);
	        File genFile = new File(context + "static/" + genFilePath + "/" + dateString + "/");
	        if(!genFile.exists()) {
	        	genFile.mkdirs();
	        }  
	        
	        File afile = new File(context + "static/" + genFilePath + "/" + dateString + "/" + genFileName);  
	        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(afile), "UTF-8"));  
	        t.process(propMap, out); 
	        out.flush();
	        out.close();
	        filePath += "/static/" + genFilePath + "/" + dateString + "/" + genFileName;
	    }catch(TemplateException e){ 
	        logger.error("Error while processing FreeMarker template" + templateFileName,e);
	        e.printStackTrace();
	    }catch(IOException e){ 
	        logger.error("Error while generate Static Html File" + genFileName,e); 
	        e.printStackTrace();
	    }  
	    return filePath ; 
	}
	
	/**
	 * 创建静态文件路径
	 * @param aParentDir
	 * @param aSubDir
	 * @return
	 */
	public boolean creatDirectory(String aParentDir, String aSubDir) { 
	   File file = new File(aParentDir); 
	    if(file.exists()) { 
	       File aSubFile = new File(aParentDir + aSubDir); 
	        if(!aSubFile.exists()) { 
	   				return aSubFile.mkdirs(); 
	        }else{ 
	   				return true ; 
	        }  
	    }else{ 
	        return false ; 
	    }  
	}	
}
