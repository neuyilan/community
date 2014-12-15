package com.community.framework.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Pattern;

import net.sf.json.util.NewBeanInstanceStrategy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import com.community.app.module.service.AppUserConfigService;

public class weather {

	/**
	 * 抓取五天内的天气情况
	 * 
	 * @param
	 * @return
	 * @throws
	 */
	public static void grabWeather() {
		Document doc;
		try {
			doc = Jsoup
					.connect(
							"http://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=2&tn=baiduhome_pg&wd=%E5%8C%97%E4%BA%AC%E5%A4%A9%E6%B0%94&rsv_spt=1&rsv_pq=9af64cef00006539&rsv_t=6dfbXRJ0jkZSy2YIT2s4nMGEVWceOePkGcuQ1sCFMZsxKZqPKzJ0MBE%2F55hPhGeL605G&rsv_enter=0&rsv_sug3=6&rsv_sug4=255&rsv_sug1=6&inputT=4684&rsv_sug=1")
					.get();
			String title = doc.title();
			// 周几
			Elements dates = doc.select("p.op_weather4_twoicon_date");
			// 温度
			Elements temps = doc.select("p.op_weather4_twoicon_temp");
			// 日期
			Elements days = doc.select("p.op_weather4_twoicon_date_day");
			// 天气
			Elements weaths = doc.select("p.op_weather4_twoicon_weath");
			// 风度
			Elements winds = doc.select("p.op_weather4_twoicon_wind");
			// 空气质量
			Elements pm25s = doc.select("p.op_weather4_twoicon_pm25");
			// 遍历周几到配置文件
			for (int i = 0; i < dates.size(); i++) {
				System.out.println(dates.get(i).text());
				if (i == 0) {
					String[] arr = dates.get(i).text().split(" ");
					setWeatherProper("date" + (i + 1), new SimpleDateFormat(
							"yyyy.MM.dd").format(new Date().getTime())
							+ "/"
							+ arr[0] + "(" + arr[2] + ")");
					setWeatherProper("nowTemp", arr[3].replaceAll("[实时：()]", ""));
					System.out.println("nowTemp:"
							+ arr[3].replaceAll("[实时：()]", ""));
				} else {
					setWeatherProper("date" + (i + 1), dates.get(i).text());
				}

			}
			// 遍历日期到配置文件
			setWeatherProper("day" + 1, "");
			for (int i = 0; i < days.size(); i++) {
				System.out.println(days.get(i).text());
				setWeatherProper("day" + (i + 2), days.get(i).text());
			}
			// 遍历温度到配置文件
			for (int i = 0; i < temps.size(); i++) {
				System.out.println(temps.get(i).text());
				setWeatherProper("temp" + (i + 1), temps.get(i).text());
			}
			// 遍历天气到配置文件
			for (int i = 0; i < weaths.size(); i++) {
				System.out.println(weaths.get(i).text());
				setWeatherProper("weath" + (i + 1), weaths.get(i).text());
			}
			// 遍历风度到配置文件
			for (int i = 0; i < winds.size(); i++) {
				System.out.println(winds.get(i).text());
				setWeatherProper("wind" + (i + 1), winds.get(i).text());
			}
			// 设置空气质量配置文件
			setWeatherProper("pm251", pm25s.get(0).getElementsByTag("em").text()
					.replaceAll("[\\d\\s\u00A0]", ""));
			setWeatherProper("pm25", pm25s.get(0).getElementsByTag("em").text()
					.replaceAll("[\\s\u00A0\u4e00-\u9fa5]", ""));
			System.out.println(pm25s.get(0).getElementsByTag("em").text()
					.replaceAll("[\\d\\s\u00A0]", ""));
			System.out.println(pm25s.get(0).getElementsByTag("em").text()
					.replaceAll("[\\s\u00A0\u4e00-\u9fa5]", ""));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * 抓取俩天的限行情况
	 * 
	 * @param
	 * @return
	 * @throws
	 */
	public static void grabLimit() {
		Document doc;
		try {
			doc = Jsoup
					.connect(
							"http://www.baidu.com/s?wd=%E5%8C%97%E4%BA%AC%E9%99%90%E8%A1%8C&ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&rsv_pq=a1451db00009f709&rsv_t=f897l1tNmVRDDbamcicf6%2FZgeSHHc8sE0ML56FuycdcjZON7mkdv8XCwW%2FM&bs=%E9%99%90%E8%A1%8C")
					.get();
			String title = doc.title();
			// 今天
			Elements arr= doc.select("div.op_traffic_title~div");
			System.out.println(arr.get(0).text());
			System.out.println(arr.get(1).text());
			setLimitProper("today", arr.get(0).text());
			setLimitProper("tomorrow", arr.get(1).text());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 设置weather.properties的值
	 * 
	 * @param
	 * @return
	 * @throws
	 */
	public static void setWeatherProper(String Key, Object value) {
		String path = weather.class.getClassLoader().getResource("/").getPath();
		File file = new File(path + "weather.properties");
		Properties pro = new Properties();
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			pro.load(bis);
			FileOutputStream fos = new FileOutputStream(file);
			pro.setProperty(Key, String.valueOf(value));
			pro.store(fos, null);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 设置weather.properties的值
	 * 
	 * @param
	 * @return
	 * @throws
	 */
	public static void setLimitProper(String Key, Object value) {
		String path = weather.class.getClassLoader().getResource("/").getPath();
		File file = new File(path + "limit.properties");
		Properties pro = new Properties();
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			pro.load(bis);
			FileOutputStream fos = new FileOutputStream(file);
			pro.setProperty(Key, String.valueOf(value));
			pro.store(fos, null);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		Timestamp  ts=new Timestamp(new Date().getTime());
		System.out.println(dayForWeek("2014-12-7"));
	}

	/**
	 * 判断当前日期是星期几
	 * 
	 * @param pTime
	 *            修要判断的时间
	 * @return dayForWeek 判断结果
	 * @Exception 发生异常
	 */
	public static String dayForWeek(String pTime) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(format.parse(pTime));
		int dayForWeek = 0;
		if (c.get(Calendar.DAY_OF_WEEK) == 1) {
			dayForWeek = 7;
		} else {
			dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		}
		String str="";
		switch (dayForWeek) {
		case 1:
			str="周一";
			break;
		case 2:
			str="周二";
			break;
		case 3:
			str="周三";
			break;
		case 4:
			str="周四";
			break;
		case 5:
			str="周五";
			break;
		case 6:
			str="周六";
			break;
		case 7:
			str="周日";
			break;
		default:
			break;
		}
		return str;
	}
	
	public static String percentage(double number1,double number2) {
		   //这里的数后面加“D”是表明它是Double类型，否则相除的话取整，无法正常使用
		   double percent = number1 / number2;
		   //输出一下，确认你的小数无误
		   System.out.println("小数：" + percent);
		   //获取格式化对象
		   NumberFormat nt = NumberFormat.getPercentInstance();
		   //设置百分数精确度2即保留两位小数
		   nt.setMinimumFractionDigits(1);
		   //最后格式化并输出
		   System.out.println("百分数：" + nt.format(percent));
		   String str = nt.format(percent);
		   if(str.equals("100.0%")){
			   str="100%";
		   }
		   return str;
		 
		}

}
