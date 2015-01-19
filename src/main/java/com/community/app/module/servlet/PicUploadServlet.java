package com.community.app.module.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;

import com.community.framework.utils.Uploader;
/**
 * WEB图片上传的Serlvet类
 * 
 * Servlet implementation class FileUploadServlet
 */
public class PicUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletFileUpload upload;
	private final long MAXSize = 4194304*2L;//4*2MB
	private String filedir=null;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PicUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * 设置文件上传的初始化信息
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		FileItemFactory factory = new DiskFileItemFactory();// Create a factory for disk-based file items
		this.upload = new ServletFileUpload(factory);// Create a new file upload handler
		this.upload.setSizeMax(this.MAXSize);// Set overall request size constraint 4194304
		this.upload.setHeaderEncoding("utf-8");
		filedir=config.getServletContext().getRealPath("images");
		System.out.println("filedir="+filedir);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException{
		this.doPost(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("开始上传图片！！");
		PrintWriter out = response.getWriter();
		Map resultMap = new HashMap();
		String url = null;
		String picPath = "";
		try {
			String folderName = request.getParameter("folderName");
			System.out.println("==========folderName==========" + folderName);
			Uploader uploader = new Uploader(request);
			picPath = uploader.upload(folderName);
			System.out.println("上传文件成功!" + picPath);
			//out.write(picPath);
			//out.write("adfsdf");
		} catch (FileUploadException e) {
			e.printStackTrace();
			out.write("上传文件失败:"+e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.addHeader("P3P","CP=CAO PSA OUR");  
		response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept"); 
		//out.flush();
		//request.setAttribute("resultMap", resultMap);
		//request.getRequestDispatcher("/business/").forward(request, response);
		request.setAttribute("picPath", picPath);
		String isPHP = request.getParameter("isPHP");
		if (StringUtils.isNotBlank(isPHP) && "Y".equals(isPHP))
			request.getRequestDispatcher("/image/uploadSinglePicPHP.do").forward(request, response);
		else
			request.getRequestDispatcher("/image/uploadSinglePic.do").forward(request, response);
	}
}