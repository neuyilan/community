package com.community.framework.utils;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadBase.InvalidContentTypeException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;

import sun.misc.BASE64Decoder;

/**
 * UEditor文件上传辅助类
 *
 */
public class Uploader {
	// 输出文件地址
	private String url = "";
	// 上传文件名
	private String fileName = "";
	// 状态
	private String state = "";
	// 文件类型
	private String type = "";
	// 原始文件名
	private String originalName = "";
	// 文件大小
	private long size = 0;

	private HttpServletRequest request = null;
	private String title = "";

	// 保存路径
	private String savePath = "";
	// 文件允许格式
	private String[] allowFiles = { ".rar", ".doc", ".docx", ".zip", ".pdf",".txt", ".swf", ".wmv", ".gif", ".png", ".jpg", ".jpeg", ".bmp", ".mp3", ".amr", ".caf" };
	// 文件大小限制，单位KB
	private int maxSize = 10000;
	
	private HashMap<String, String> errorInfo = new HashMap<String, String>();

	public Uploader(HttpServletRequest request) {
		this.request = request;
		HashMap<String, String> tmp = this.errorInfo;
		tmp.put("SUCCESS", "SUCCESS"); //默认成功
		tmp.put("NOFILE", "未包含文件上传域");
		tmp.put("TYPE", "不允许的文件格式");
		tmp.put("SIZE", "文件大小超出限制");
		tmp.put("ENTYPE", "请求类型ENTYPE错误");
		tmp.put("REQUEST", "上传请求异常");
		tmp.put("IO", "IO异常");
		tmp.put("DIR", "目录创建失败");
		tmp.put("UNKNOWN", "未知错误");
	}
	private final long MAXSize = 10485760*2L;//4*2MB
	
	public Map uploadForApp() throws Exception{
		Map all = new HashMap();//最终MAP
		Map paramMap = new HashMap();//参数MAP
		Map imageMap = new HashMap();//图片MAP
		Map audioMap = new HashMap();//音频MAP
		int imagecount = 0;
		int audiocount = 0;
		FileItemFactory factory = new DiskFileItemFactory();// Create a factory for disk-based file items
		ServletFileUpload upload = new ServletFileUpload(factory);// Create a new file upload handler
		upload.setSizeMax(this.MAXSize);// Set overall request size constraint 4194304
		String filedir = request.getSession().getServletContext().getRealPath("/")+savePath;
		List<FileItem> items = upload.parseRequest(request);
		if(items!=null	&& !items.isEmpty()){
			for (FileItem fileItem : items) {
				if(!fileItem.isFormField()) {//文件
					String filename=fileItem.getFieldName();
					String filepath=filedir+File.separator+filename;
					
					this.originalName = fileItem.getName().substring(fileItem.getName().lastIndexOf(System.getProperty("file.separator")) + 1);
					if (!this.checkFileType(this.originalName)) {
						this.state = this.errorInfo.get("TYPE");
						continue;
					}
					String[] nameArray = this.originalName.split("\\.");
					this.fileName = nameArray[0];
					this.type = "."+nameArray[1];
					SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
					String dateString = sf.format(new Date());
					//String[] audioNameArr = null;//音频文件名由"名字_时长"构成
					if(".jpg".equals(this.type)|| ".png".equals(this.type)) {
						this.url = filedir + savePath + "/app/image/" + dateString;
					}else if(".mp3".equals(this.type)|| ".caf".equals(this.type)) {
						//audioNameArr = this.fileName.split("_");
						this.url = filedir + savePath + "/app/audio/" + dateString;
					}
					File folder = new File(this.url);
					if(!folder.exists()) {
						folder.mkdirs();
					}
					this.url = this.url + "/" + this.originalName;
					System.out.println("文件保存路径为:"+this.url);
					File file = new File(this.url);
					InputStream inputSteam=fileItem.getInputStream();
					BufferedInputStream fis=new BufferedInputStream(inputSteam);
				    FileOutputStream fos=new FileOutputStream(file);
				    int f;
				    while((f=fis.read())!=-1)
				    {
				       fos.write(f);
				    }
				    //将文件地址保存到MAP
				    if(".jpg".equals(this.type)|| ".png".equals(this.type)) {
				    	imagecount++;
				    	imageMap.put(imagecount+"", "/app/image/" + dateString + "/" + fileName+this.type);
					}else if(".mp3".equals(this.type)|| ".caf".equals(this.type)) {
						//audioNameArr = nameArray[0].split("_");
						audiocount++;
						audioMap.put(audiocount+"", "/app/audio/" + dateString + "/" + fileName+".amr");
						
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
					paramMap.put(fieldName, fieldValue);
				}
			}
		}
		all.put("param", paramMap);
		all.put("image", imageMap);
		all.put("audio", audioMap);
		return all;
	}
		
	public String upload(String filePath) throws Exception {
		String picPath = "";
		boolean isMultipart = ServletFileUpload.isMultipartContent(this.request);
		if (!isMultipart) {
			this.state = this.errorInfo.get("NOFILE");
			return null;
		}
		Map paramMap = new HashMap();
		try {
			FileItemFactory factory = new DiskFileItemFactory();// Create a factory for disk-based file items
			ServletFileUpload upload = new ServletFileUpload(factory);// Create a new file upload handler
			upload.setSizeMax(this.MAXSize);// Set overall request size constraint 4194304
			String filedir = request.getSession().getServletContext().getRealPath("/")+savePath;
			List<FileItem> items = upload.parseRequest(request);
			if(items!=null	&& !items.isEmpty()){
				for (FileItem fileItem : items) {
					if(!fileItem.isFormField()) {//文件
						String filename=fileItem.getFieldName();
						String filepath=filedir+File.separator+filename;
						
						this.originalName = fileItem.getName().substring(fileItem.getName().lastIndexOf(System.getProperty("file.separator")) + 1);
						if (!this.checkFileType(this.originalName)) {
							this.state = this.errorInfo.get("TYPE");
							continue;
						}
						String[] nameArray = this.originalName.split("\\.");
						
						this.fileName = this.originalName.substring(0, this.originalName.lastIndexOf("."));
						this.type = "."+this.originalName.substring(this.originalName.lastIndexOf(".")+1, this.originalName.length());
						SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
						String dateString = sf.format(new Date());
						this.url = filedir + "/image/"+filePath+"/" + dateString;  //dir
						File folder = new File(this.url);
						if(!folder.exists()) {
							folder.mkdirs();
						}
						String newFileName = new Timestamp(System.currentTimeMillis()).getTime() + this.type;
						String tmp;
						String isZip = this.request.getParameter("isZip");
						if (fileItem.getSize()/1024 > 100)
							 tmp = "tmp/";
						else
							tmp="";
						if (isZip==null || isZip.equals("2")) {
							tmp="";
						}
						String tmpPicDir = this.url +"/" + tmp;//"/tmp/";
						File tmpFolder = new File(tmpPicDir);
						if(!tmpFolder.exists()) {
							tmpFolder.mkdirs();
						}
						String tmpPicFile = tmpPicDir  + newFileName;
						this.url = this.url + "/" + newFileName;
						System.out.println("文件上传成功 文件保存路径为:"+this.url);
						//File file = new File(this.url);
						File file = new File(tmpPicFile);
						InputStream inputSteam=fileItem.getInputStream();
						
						
				    	
				    	String rotation = this.request.getParameter("rotation");
				    	if (StringUtils.isNotBlank(rotation) && !"0".equals(rotation) )
				    	{
				    		int rota = Integer.valueOf(rotation);
					    	BufferedImage imagebuff = ImageIO.read(inputSteam);  
					    	inputSteam = image.rotateImg(imagebuff, rota, null);
				    	}
				    	System.out.println("文件旋转成功 文件保存路径为:"+this.url);
				    	
				    	BufferedInputStream fis=new BufferedInputStream(inputSteam);
					    FileOutputStream fos=new FileOutputStream(file);
					    int f;
					    while((f=fis.read())!=-1)
					    {
					       fos.write(f);
					    }
					    //将文件地址保存
					    picPath = "/image/"+filePath+"/" + dateString + "/" + newFileName;
					    fos.flush();
					    fos.close();
					    fis.close();
						inputSteam.close();
						if (StringUtils.isNotBlank(tmp))
						{
							//压缩图片
							CompressPicDemo cpd = new CompressPicDemo();
							cpd.compressPic(tmpPicFile, this.url,  100, 100, true);
							//压缩后删除原文件
							if (file.exists())
								file.delete();
						}
						
						System.out.println("文件压缩成功 文件："+filename+"上传成功!");
					}else{//字段
						String fieldName = fileItem.getFieldName();//字段名
						String fieldValue = fileItem.getString("UTF-8");
						System.out.println("fieldName  "+fieldName+"    fieldValue "+fieldValue);
						paramMap.put(fieldName, fieldValue);
					}
				}
			}
		} catch (SizeLimitExceededException e) {
			this.state = this.errorInfo.get("SIZE");
		} catch (InvalidContentTypeException e) {
			this.state = this.errorInfo.get("ENTYPE");
		} catch (FileUploadException e) {
			this.state = this.errorInfo.get("REQUEST");
		} catch (Exception e) {
			this.state = this.errorInfo.get("UNKNOWN");
		}
		return picPath;
	}
	
	/**
	 * 接受并保存以base64格式上传的文件
	 * @param fieldName
	 */
	public void uploadBase64(String fieldName){
		String savePath = this.getFolder(this.savePath);
		String base64Data = this.request.getParameter(fieldName);
		this.fileName = this.getName("test.png");
		this.url = savePath + "/" + this.fileName;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			File outFile = new File(this.getPhysicalPath(this.url));
			OutputStream ro = new FileOutputStream(outFile);
			byte[] b = decoder.decodeBuffer(base64Data);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					b[i] += 256;
				}
			}
			ro.write(b);
			ro.flush();
			ro.close();
			this.state=this.errorInfo.get("SUCCESS");
		} catch (Exception e) {
			this.state = this.errorInfo.get("IO");
		}
	}

	/**
	 * 文件类型判断
	 * 
	 * @param fileName
	 * @return
	 */
	private boolean checkFileType(String fileName) {
		Iterator<String> type = Arrays.asList(this.allowFiles).iterator();
		while (type.hasNext()) {
			String ext = type.next();
			if (fileName.toLowerCase().endsWith(ext)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 获取文件扩展名
	 * 
	 * @return string
	 */
	private String getFileExt(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}

	/**
	 * 依据原始文件名生成新文件名
	 * @return
	 */
	private String getName(String fileName) {
		Random random = new Random();
		return this.fileName = "" + random.nextInt(10000)
				+ System.currentTimeMillis() + this.getFileExt(fileName);
	}

	/**
	 * 根据字符串创建本地目录 并按照日期建立子目录返回
	 * @param path 
	 * @return 
	 */
	private String getFolder(String path) {
		SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
		path += "/" + formater.format(new Date());
		File dir = new File(this.getPhysicalPath(path));
		if (!dir.exists()) {
			try {
				dir.mkdirs();
			} catch (Exception e) {
				this.state = this.errorInfo.get("DIR");
				return "";
			}
		}
		return path;
	}

	/**
	 * 根据传入的虚拟路径获取物理路径
	 * 
	 * @param path
	 * @return
	 */
	private String getPhysicalPath(String path) {
		String servletPath = this.request.getServletPath();
		String realPath = this.request.getSession().getServletContext()
				.getRealPath(servletPath);
		return new File(realPath).getParent() +"/" +path;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public void setAllowFiles(String[] allowFiles) {
		this.allowFiles = allowFiles;
	}

	public void setMaxSize(int size) {
		this.maxSize = size;
	}

	public long getSize() {
		return this.size;
	}

	public String getUrl() {
		return this.url;
	}

	public String getFileName() {
		return this.fileName;
	}

	public String getState() {
		return this.state;
	}
	
	public String getTitle() {
		return this.title;
	}

	public String getType() {
		return this.type;
	}

	public String getOriginalName() {
		return this.originalName;
	}
	
	public static void main(String[] args) {
	
	}
	
	private byte[] decodeHex(char[] data) {  
		int len = data.length;  
		if ((len & 0x01) != 0) {  
			throw new RuntimeException("Odd number of characters.");  
		}  
		byte[] out = new byte[len >> 1];  
		// two characters form the hex value. 
		for (int i = 0, j = 0; j < len; i++) {  
			int f = toDigit(data[j], j) << 4;  
				j++;  
			f = f | toDigit(data[j], j);  
				j++;  
			out[i] = (byte) (f & 0xFF);  
		}  
		return out;  
	}
	
	private int toDigit(char ch, int index) {  
		int digit = Character.digit(ch, 16);  
		if (digit == -1) {  
			throw	new RuntimeException("Illegal hexadecimal character " + ch  
			+ " at index " + index);  
		}  
		return digit;  
	} 
	
}
