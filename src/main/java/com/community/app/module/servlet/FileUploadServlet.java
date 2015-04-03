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

import com.community.framework.utils.Uploader;
/**
 * 文件上传的Serlvet类
 * 
 * Servlet implementation class FileUploadServlet
 */
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletFileUpload upload;
	private final long MAXSize = 10485760*2L;//4*2MB
	private String filedir=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
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
			throws IOException{
		// TODO Auto-generated method stub
				PrintWriter out=response.getWriter();
				/*try {
					List<FileItem> items = this.upload.parseRequest(request);
					if(items!=null	&& !items.isEmpty()){
						for (FileItem fileItem : items) {
							String filename=fileItem.getName();
							String filepath=filedir+File.separator+filename;
							System.out.println("文件保存路径为:"+filepath);
							File file=new File(filepath);
							InputStream inputSteam=fileItem.getInputStream();
							BufferedInputStream fis=new BufferedInputStream(inputSteam);
						    FileOutputStream fos=new FileOutputStream(file);
						    int f;
						    while((f=fis.read())!=-1)
						    {
						       fos.write(f);
						    }
						    fos.flush();
						    fos.close();
						    fis.close();
							inputSteam.close();
							System.out.println("文件："+filename+"上传成功!");
						}
					}
					System.out.println("上传文件成功!");
					out.write("上传文件成功!");
				} catch (FileUploadException e) {
					e.printStackTrace();
					out.write("上传文件失败:"+e.getMessage());
				}*/
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("开始上传图片！！");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		Map resultMap = new HashMap();
		String url = null;
		try {
			Uploader uploader = new Uploader(request);
			resultMap = uploader.uploadForApp();
			Map paramMap = (Map) resultMap.get("param");
			url = (String) paramMap.get("url");
			/*List<FileItem> items = this.upload.parseRequest(request);
			if(items!=null	&& !items.isEmpty()){
				for (FileItem fileItem : items) {
					if(!fileItem.isFormField()) {//文件
						String filename=fileItem.getName();
						String filepath=filedir+File.separator+filename;
						System.out.println("文件保存路径为:"+filepath);
						File file=new File(filepath);
						InputStream inputSteam=fileItem.getInputStream();
						BufferedInputStream fis=new BufferedInputStream(inputSteam);
					    FileOutputStream fos=new FileOutputStream(file);
					    int f;
					    while((f=fis.read())!=-1)
					    {
					       fos.write(f);
					    }
					    fos.flush();
					    fos.close();
					    fis.close();
						inputSteam.close();
						System.out.println("文件："+filename+"上传成功!");
					}else{//字段
						String fieldName = fileItem.getFieldName();//字段名
						String fieldValue = fileItem.getString("UTF-8");
						System.out.println("fieldName  "+fieldName+"    fieldValue "+fieldValue);
					}
				}
			}*/
			
			System.out.println("上传文件成功!");
			out.write("上传文件成功!");
		} catch (FileUploadException e) {
			e.printStackTrace();
			out.write("上传文件失败:"+e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("resultMap", resultMap);
		request.getRequestDispatcher(url).forward(request, response);
	}
	
}
