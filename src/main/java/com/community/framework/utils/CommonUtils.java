package com.community.framework.utils;


import com.community.app.module.bean.ShiroUser;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.codehaus.jackson.map.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2014/7/14.
 * 工具类
 * @param <CloseableHttpClient>
 */
public class CommonUtils<CloseableHttpClient> {
    //图片上传地址
    public static final String LOCALIMGPATH = "F:/pic/";
    //图片http地址
    public static final String HTTPLOCALIMGPATH = "http://localhost:8080/community/attach/140720/";
    //远程图片上传地址
    public static final String REMOTEIMGPATH = "F:/pic/";
    //本地EXCEL路径
    public static final String LOCALEXCELPATH = "F:/pic/";
    //远程EXCEL路径
    public static final String REMOTEEXCELPATH = "F:/pic/";
    //小图片
    public static final String SMALL = "S_M_A_L_L";


    /**
     * 获取时间戳
     * @return
     */
    public static long getLongTime() {
        Date date = new Date();
        return date.getTime();
    }

    public static ShiroUser getUser() {
        //当前用户标识
        Subject currentUser = SecurityUtils.getSubject();
        ShiroUser shiroUser = (ShiroUser)currentUser.getPrincipal();
        return shiroUser;
    }
    
    public static boolean hasRole(String roleName) {
    	Subject currentUser = SecurityUtils.getSubject();
    	return currentUser.hasRole(roleName);
    }

    public static void print(HttpServletResponse response, String json) {
        PrintWriter pw = null;
        try {
            response.setCharacterEncoding("UTF-8");
            pw = response.getWriter();
            pw.print(json);
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(pw != null) {
                pw.close();
            }
        }
    }

    /**
     * 取得单元格的值
     * @param cell
     * @return
     */
    public static String getCellValue(Cell cell) throws Exception {
        String cellValue = "";
        SimpleDateFormat dformat=new SimpleDateFormat("yyyy-MM");
        try {
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        double d = cell.getNumericCellValue();
                        Date date = HSSFDateUtil.getJavaDate(d);
                        cellValue = dformat.format(date);
                    } else {
                        short format = cell.getCellStyle().getDataFormat();
                        //自定义日期类型
                        SimpleDateFormat sdf = null;
                        if (format == 14 || format == 31 || format == 57 || format == 58) {
                            //日期
                            double value = cell.getNumericCellValue();
                            Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(value);
                            cellValue = dformat.format(date);
                        } else if (format == 20 || format == 32) {
                            //时间
                            double value = cell.getNumericCellValue();
                            Date date = DateUtil.getJavaDate(value);
                            SimpleDateFormat hhmmformat = new SimpleDateFormat("HH:mm");
                            cellValue = hhmmformat.format(date);
                        } else {
                            NumberFormat nf = NumberFormat.getInstance();
                            nf.setGroupingUsed(false);//true时的格式：1,234,567,890
                            cellValue = nf.format(cell.getNumericCellValue());//数值类型的数据为double，所以需要转换一下
                        }
                    }
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    break;
                case Cell.CELL_TYPE_FORMULA:   //读取函数产生的值
                    FormulaEvaluator evaluator = cell.getSheet().getWorkbook().getCreationHelper().createFormulaEvaluator();
                    evaluator.evaluateFormulaCell(cell);
                    CellValue cv = evaluator.evaluate(cell);
                    switch (cv.getCellType()) {
                        case Cell.CELL_TYPE_STRING:    //字符串
                            cellValue = cv.getStringValue();
                            break;
                        case Cell.CELL_TYPE_NUMERIC:   //数据值型
                            NumberFormat nf = NumberFormat.getInstance();
                            nf.setGroupingUsed(false);//true时的格式：1,234,567,890
                            cellValue = nf.format(cv.getNumberValue());//数值类型的数据为double，所以需要转换一下
                            break;
                        case Cell.CELL_TYPE_ERROR: //类型错误
                            break;
                        default:
                            cellValue = "";
                    }
                    break;
                case Cell.CELL_TYPE_BLANK:
                    cellValue = "";
                    break;
                default:
            }
        } catch (Exception e) {
            throw new Exception("Excel导入失败，请检查Excel数据格式是否正确！");
        }


        return cellValue;  //去掉前后空格
    }

    /**
     * 根据扩展名取得workbook
     * @param filepath
     * @return
     * @throws IOException
     */
    public static Workbook getWorkbook(String filepath) throws IOException {
        Workbook wb = null;
        File file = new File(filepath);
        String extentname = FilenameUtils.getExtension(file.getName()).trim();
        InputStream in = new FileInputStream(file);
        if("xlsx".equals(extentname)) {
            wb = new XSSFWorkbook(in);    //2007
        }
        else if("xls".equals(extentname)){
            wb = new HSSFWorkbook(in);    //2003
        }
        return wb;
    }

    /**
     * 获取合并单元格的值
     * @param sheet
     * @param row
     * @param column
     * @return
     */
    public static String getMergedRegionValue(Sheet sheet ,int row , int column) throws Exception {
        int sheetMergeCount = sheet.getNumMergedRegions();

        for(int i = 0 ; i < sheetMergeCount ; i++){
            CellRangeAddress ca = sheet.getMergedRegion(i);
            int firstColumn = ca.getFirstColumn();
            int lastColumn = ca.getLastColumn();
            int firstRow = ca.getFirstRow();
            int lastRow = ca.getLastRow();

            if(row >= firstRow && row <= lastRow){

                if(column >= firstColumn && column <= lastColumn){
                    Row fRow = sheet.getRow(firstRow);
                    Cell fCell = fRow.getCell(firstColumn);

                    return getCellValue(fCell) ;
                }
            }
        }

        return null ;
    }

    /**
     * 判断指定的单元格是否是合并单元格
     * @param sheet
     * @param row
     * @param column
     * @return
     */
    public static boolean isMergedRegion(Sheet sheet , int row , int column){
        int sheetMergeCount = sheet.getNumMergedRegions();

        for(int i = 0 ; i < sheetMergeCount ; i++ ){
            CellRangeAddress ca = sheet.getMergedRegion(i);
            int firstColumn = ca.getFirstColumn();
            int lastColumn = ca.getLastColumn();
            int firstRow = ca.getFirstRow();
            int lastRow = ca.getLastRow();

            if(row >= firstRow && row <= lastRow){
                if(column >= firstColumn && column <= lastColumn){

                    return true ;
                }
            }
        }

        return false ;
    }

    public static String getJSONString(boolean flag , String msg) {
        Map map = new HashMap();
        map.put("success", flag);
        map.put("message", msg);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        try {
            json = objectMapper.writeValueAsString(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static String getJSONString(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        try {
            json = objectMapper.writeValueAsString(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 判断手机号是否正确
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles){
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
   }

    /**
     * 日期转换
     * @param date
     * @return
     */
    public static String getFomatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    /**
     * list转字符串
     * @param stringList
     * @return
     */
    public static String listToString(Collection<String> stringList){
        if (stringList==null) {
            return null;
        }
        StringBuilder result=new StringBuilder();
        boolean flag=false;
        for (String string : stringList) {
            if (flag) {
                result.append(",");
            }else {
                flag=true;
            }
            result.append(string);
        }
        return result.toString();
    }
    //缩小图片
    public static void reduceImg(String imgsrc, String imgdist, int widthdist,int heightdist) {
        try {
            File srcfile = new File(imgsrc);
            if (!srcfile.exists()) {
                return;
            }
            Image src = javax.imageio.ImageIO.read(srcfile);

            BufferedImage tag= new BufferedImage((int) widthdist, (int) heightdist,
                    BufferedImage.TYPE_INT_RGB);

            tag.getGraphics().drawImage(src.getScaledInstance(widthdist, heightdist,  Image.SCALE_SMOOTH), 0, 0,  null);

            FileOutputStream out = new FileOutputStream(imgdist);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(tag);
            out.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
    	Document doc = Jsoup.connect("http://www.baidu.com/s?wd=%E5%A4%A9%E6%B0%94&rsv_spt=1&issp=1&f=8&rsv_bp=0&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_sug3=8&rsv_sug4=182&rsv_sug1=7&rsv_pq=c1a5ef740000059b&rsv_t=bbf0pWstHf3JU5L0ToPR1zNtli3vyTT4VsgF3Fq6mv%2FnsRfrZpV1&rsv_sug2=0&inputT=1196&rsv_sug=1").get();
    	String title = doc.title();
    	//周几
    	Elements dates = doc.select("p.op_weather4_twoicon_date");
    	//温度
    	Elements temps = doc.select("p.op_weather4_twoicon_temp");
    	//日期
    	Elements days = doc.select("p.op_weather4_twoicon_date_day");
    	//天气
    	Elements weaths = doc.select("p.op_weather4_twoicon_weath");
    	//风度
    	Elements winds = doc.select("p.op_weather4_twoicon_wind");
    	//空气质量
    	Elements pm25s = doc.select("p.op_weather4_twoicon_pm25");
    	//遍历周几到配置文件
    	for (int i = 0; i < dates.size(); i++) {
    		 System.out.println(dates.get(i).text());
    		 setProper("date"+(i+1), dates.get(i).text());
		}
    	//遍历日期到配置文件
    	setProper("days"+1, "");
    	for (int i = 0; i < days.size(); i++) {
	   		 System.out.println(days.get(i).text());
	   		 setProper("day"+(i+2), days.get(i).text());
		}
    	//遍历温度到配置文件
    	for (int i = 0; i < temps.size(); i++) {
	   		 System.out.println(temps.get(i).text());
	   		 setProper("temps"+(i+1), temps.get(i).text());
		}
    	//遍历天气到配置文件
    	for (int i = 0; i < weaths.size(); i++) {
	   		 System.out.println(weaths.get(i).text());
	   		 setProper("weaths"+(i+1), weaths.get(i).text());
		}
    	//遍历风度到配置文件
    	for (int i = 0; i < winds.size(); i++) {
	   		 System.out.println(winds.get(i).text());
	   		 setProper("winds"+(i+1), winds.get(i).text());
		}
    	//设置空气质量配置文件
    	setProper("pm251", pm25s.get(0).getElementsByTag("em").text().replaceAll("[\\d\\s\u00A0]",""));
    	System.out.println(pm25s.get(0).getElementsByTag("em").text().replaceAll("[\\d\\s\u00A0]",""));
    	
    }  
    public static  void setProper(String Key, Object value)
    {
	  File file=new File("src/main/resources/weather.properties");
	  Properties pro = new Properties();
                  FileInputStream  fis=null;
	  BufferedInputStream bis=null;
        try
        {
        	fis=new FileInputStream(file);
                bis=new BufferedInputStream(fis);
               pro.load(bis);
            FileOutputStream fos = new FileOutputStream(file);
            pro.setProperty(Key, String.valueOf(value));
            pro.store(fos, null);
            fos.close();
        }
        catch(Exception e)
        {
        e.printStackTrace();
        }
    }
    
    

}
