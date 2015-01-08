package com.community.framework.utils;



import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

/**
 * 日期工具类
 * 
 */
public class DateUtil {
	/**
	 * 获取当前时间，格式：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String nowTime(){
		String nowTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		return nowTime;
	}
	
	/**
	 * 获取当前时间，格式：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String nowTime1(){
		String nowTime=new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Calendar.getInstance().getTime());
		return nowTime;
	}
	
	/**
	 * 获取当前日期，格式：yyyy-MM-dd
	 * @return
	 */
	public static String getDate(){
		String date=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		return date;
	}
	
	/**
	 * 此方法现在未使用
	 * @return
	 */
	public static String dateForJavaScript(){
		String nowTime=new SimpleDateFormat("yyyy,MM,dd,HH,mm").format(Calendar.getInstance().getTime());
		return nowTime;
	}
	public static void main(String[] args) {
		//System.out.println(nowTime1());
	}
	
	public static Calendar setStartDay(Calendar cal)
    {
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        return cal;
    }

    public static Calendar setEndDay(Calendar cal)
    {
        cal.set(11, 23);
        cal.set(12, 59);
        cal.set(13, 59);
        return cal;
    }

    public static void copyYearMonthDay(Calendar destCal, Calendar sourceCal)
    {
        destCal.set(1, sourceCal.get(1));
        destCal.set(2, sourceCal.get(2));
        destCal.set(5, sourceCal.get(5));
    }

    public static String formatEnDate(Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
        return sdf.format(date).replaceAll("\u4E0A\u5348", "AM").replaceAll("\u4E0B\u5348", "PM");
    }

    public static Date parseDate(String dateString)
    {
        Date date = null;
        try
        {
            date = DateUtils.parseDate(dateString, new String[] {
                "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd"
            });
        }
        catch(Exception ex)
        {
            
        }
        return date;
    } 
    
    public static int getTheMonth() {
    	Calendar c = Calendar.getInstance();
		 int month = c.get(Calendar.MONTH);//获取是本月的第几周
		 return (month+1);
    }
    
    /*
     * 本月第几周
     */
    public static int getTheWeek() {
    	Calendar c = Calendar.getInstance();
		 int week = c.get(Calendar.WEEK_OF_MONTH);//获取是本月的第几周
		 return week;
    }
    
    /*
     * 某天为当月第几周
     */
    public static int getWeek(Date date) {
    	Calendar c = Calendar.getInstance();
    	c.setTime(date);
		 int week = c.get(Calendar.WEEK_OF_MONTH);//获取是本月的第几周
		 return week;
    }
    
    /*
     *  某天为周几
     */
    public static int getDayInWeek(Date date) {
    	Calendar c = Calendar.getInstance();
    	c.setTime(date);
		  int day = c.get(Calendar.DAY_OF_WEEK);//获致是本周的第几天地, 1代表星期天...7代表星期六
		  return (day-1);
    }
    
    /*
     * 本周周几
     */
    public static int getTheDayInWeek() {
    	Calendar c = Calendar.getInstance();
		  int day = c.get(Calendar.DAY_OF_WEEK);//获致是本周的第几天地, 1代表星期天...7代表星期六
		  return (day-1);
    }
    
    private static String getTime(Date date) {  
        String todySDF = "今天 HH:mm";  
        String yesterDaySDF = "昨天 HH:mm";  
        String otherSDF = "yyyy-MM-dd HH:mm";  
        SimpleDateFormat sfd = null;  
        String time = "";  
        Calendar dateCalendar = Calendar.getInstance();  
        dateCalendar.setTime(date);  
        Date now = new Date();  
        Calendar targetCalendar = Calendar.getInstance();  
        targetCalendar.setTime(now);  
        targetCalendar.set(Calendar.HOUR_OF_DAY, 0);  
        targetCalendar.set(Calendar.MINUTE, 0);  
        if (dateCalendar.after(targetCalendar)) {  
            sfd = new SimpleDateFormat(todySDF);  
            time = sfd.format(date);  
            return time;  
        } else {  
            targetCalendar.add(Calendar.DATE, -1);  
            if (dateCalendar.after(targetCalendar)) {  
                sfd = new SimpleDateFormat(yesterDaySDF);  
                time = sfd.format(date);  
                return time;  
            }  
        }  
        sfd = new SimpleDateFormat(otherSDF);  
        time = sfd.format(date);  
        return time;  
    }  
    //不加年
    public static String getTime1(Date date) {  
        String todySDF = "今天 HH:mm";  
        String yesterDaySDF = "昨天 HH:mm";  
        String otherSDF = "MM-dd HH:mm";  
        SimpleDateFormat sfd = null;  
        String time = "";  
        Calendar dateCalendar = Calendar.getInstance();  
        dateCalendar.setTime(date);  
        Date now = new Date();  
        Calendar targetCalendar = Calendar.getInstance();  
        targetCalendar.setTime(now);  
        targetCalendar.set(Calendar.HOUR_OF_DAY, 0);  
        targetCalendar.set(Calendar.MINUTE, 0);  
        if (dateCalendar.after(targetCalendar)) {  
            sfd = new SimpleDateFormat(todySDF);  
            time = sfd.format(date);  
            return time;  
        } else {  
            targetCalendar.add(Calendar.DATE, -1);  
            if (dateCalendar.after(targetCalendar)) {  
                sfd = new SimpleDateFormat(yesterDaySDF);  
                time = sfd.format(date);  
                return time;  
            }  
        }  
        sfd = new SimpleDateFormat(otherSDF);  
        time = sfd.format(date);  
        return time;  
    }  
    
    public static String getInterval(Timestamp timestamp) { //传入的时间格式必须类似于2012-8-21 17:53:20这样的格式  
        String interval = null;  
        /*SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        ParsePosition pos = new ParsePosition(0);  
        Date d1 = (Date) sd.parse(timestamp+"", pos);  
          
        //用现在距离1970年的时间间隔new Date().getTime()减去以前的时间距离1970年的时间间隔d1.getTime()得出的就是以前的时间与现在时间的时间间隔  
        long time = new Date().getTime() - d1.getTime();// 得出的时间间隔是毫秒  
          
        if(time/1000 < 10 && time/1000 >= 0) {  
        //如果时间间隔小于10秒则显示“刚刚”time/10得出的时间间隔的单位是秒  
            interval ="刚刚";  
              
        } else if(time/1000 < 60 && time/1000 > 0) {  
        //如果时间间隔小于60秒则显示多少秒前  
            int se = (int) ((time%60000)/1000);  
            interval = se + "秒前";  
              
        } else if(time/60000 < 60 && time/60000 > 0) {  
        //如果时间间隔小于60分钟则显示多少分钟前  
            int m = (int) ((time%3600000)/60000);//得出的时间间隔的单位是分钟  
            interval = m + "分钟前";  
              
        }else if(time/3600000 < 24 && time/3600000 >= 0) {  
        //如果时间间隔小于24小时则显示多少小时前  
            int h = (int) (time/3600000);//得出的时间间隔的单位是小时  
            interval = h + "小时前";  
              
        }else {  */
            //大于24小时，则显示正常的时间，但是不显示秒  
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
  
            ParsePosition pos2 = new ParsePosition(0);  
            Date d2 = (Date) sdf.parse(timestamp+"", pos2);  
            
            interval = getTime(d2);  
      //  }  
        return interval;  
    }  
    
    public static String getInterval1(Timestamp timestamp) { //传入的时间格式必须类似于2012-8-21 17:53:20这样的格式  
        String interval = null;  
        /*SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        ParsePosition pos = new ParsePosition(0);  
        Date d1 = (Date) sd.parse(timestamp+"", pos);  
          
        //用现在距离1970年的时间间隔new Date().getTime()减去以前的时间距离1970年的时间间隔d1.getTime()得出的就是以前的时间与现在时间的时间间隔  
        long time = new Date().getTime() - d1.getTime();// 得出的时间间隔是毫秒  
          
        if(time/1000 < 10 && time/1000 >= 0) {  
        //如果时间间隔小于10秒则显示“刚刚”time/10得出的时间间隔的单位是秒  
            interval ="刚刚";  
              
        }else if(time/1000 < 60 && time/1000 > 0) {  
        //如果时间间隔小于60秒则显示多少秒前  
            int se = (int) ((time%60000)/1000);  
            interval = se + " 秒前";  
              
        }
        else if(time/60000 < 60 && time/60000 > 0) {  
        //如果时间间隔小于60分钟则显示多少分钟前  
            int m = (int) ((time%3600000)/60000);//得出的时间间隔的单位是分钟  
            interval = m + " 分钟前";  
              
        }  else if(time/3600000 < 24 && time/3600000 >= 0) {  
        //如果时间间隔小于24小时则显示多少小时前  
            int h = (int) (time/3600000);//得出的时间间隔的单位是小时  
            interval = h + " 小时前";  
              
        }else {  */
            //大于24小时，则显示正常的时间，但是不显示秒  
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
  
            ParsePosition pos2 = new ParsePosition(0);  
            Date d2 = (Date) sdf.parse(timestamp+"", pos2);  
            
            interval = getTime(d2);  
       // }  
        return interval;  
    }  
}
