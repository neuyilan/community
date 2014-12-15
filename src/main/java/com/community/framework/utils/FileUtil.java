package com.community.framework.utils;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class FileUtil {
	
	private static final Logger logger = Logger.getLogger(FileUtil.class);
	
	public FileUtil()
    {
    }

    public static String generateFilename(String originalFilename)
    {
        SimpleDateFormat dirSdf = new SimpleDateFormat("yyyyMM");
        String filePre = dirSdf.format(new Date());
        String fileExt = "";
        int lastIndex = originalFilename.lastIndexOf('.');
        if(lastIndex != -1)
            fileExt = originalFilename.substring(lastIndex);
        String filename = (new StringBuilder(String.valueOf(filePre))).append("/").append(UUIDGenerator.getUUID()).append(fileExt).toString();
        return filename;
    }

    public static void writeFile(String filePath, String data)
    {
        FileOutputStream fos;
        OutputStreamWriter writer;
        fos = null;
        writer = null;
        try
        {
            fos = new FileOutputStream(new File(filePath));
            writer = new OutputStreamWriter(fos, "UTF-8");
            writer.write(data);
        }
        catch(Exception ex)
        {
            logger.error(ex.getMessage());
        }
        try
        {
            if(writer != null)
                writer.close();
            if(fos != null)
                fos.close();
        }
        catch(Exception exception1) { }
        try
        {
            if(writer != null)
                writer.close();
            if(fos != null)
                fos.close();
        }
        catch(Exception exception2) { }

        try
        {
            if(writer != null)
                writer.close();
            if(fos != null)
                fos.close();
        }
        catch(Exception exception3) { }
    }

    public static String readFile(String filePath)
    {
        StringBuffer buffer = new StringBuffer();
        try
        {
            File file = new File(filePath);
            FileInputStream fis = null;
            BufferedReader breader = null;
            try
            {
                fis = new FileInputStream(file);
                InputStreamReader isReader = new InputStreamReader(fis, "UTF-8");
                breader = new BufferedReader(isReader);
                String line;
                while((line = breader.readLine()) != null) 
                {
                    buffer.append(line);
                    buffer.append("\r\n");
                }
                breader.close();
                isReader.close();
                fis.close();
            }
            catch(FileNotFoundException e)
            {
                logger.error(e.getMessage());
            }
            catch(IOException e)
            {
                logger.error(e.getMessage());
            }
        }
        catch(Exception e)
        {
            logger.error(e.getMessage());
        }
        return buffer.toString();
    }
    private static double rad(double d)

	{

		return d * Math.PI / 180.0;

	}

	public static double GetDistance(double lat1, double lng1, double lat2,
			double lng2)

	{
		final double EARTH_RADIUS = 6378.137;

		double radLat1 = rad(lat1);

		double radLat2 = rad(lat2);

		double a = radLat1 - radLat2;

		double b = rad(lng1) - rad(lng2);

		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +

		Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));

		s = s * EARTH_RADIUS;
		//System.out.println(s);
		//System.out.println(s * 10000);
		//System.out.println(Math.round(s * 10000));
		//System.out.println(Math.round(s * 10000) / 10000);

		//s = Math.round(s * 10000) / 10000;

		return s;

	}
	
	public static double gps2m(double lat_a, double lng_a, double lat_b, double lng_b) { 
		double pk = (float) (180/3.14169); 
	 
		double a1 = lat_a / pk; 
		double a2 = lng_a / pk; 
		double b1 = lat_b / pk; 
		double b2 = lng_b / pk; 
	 
		double t1 = Math.cos(a1)*Math.cos(a2)*Math.cos(b1)*Math.cos(b2); 
		double t2 = Math.cos(a1)*Math.sin(a2)*Math.cos(b1)*Math.sin(b2); 
		double t3 = Math.sin(a1)*Math.sin(b1); 
		double tt = Math.acos(t1 + t2 + t3); 
	    
	    return 6366000*tt; 
	} 

	public static void main(String[] args) {
		//System.out.println(gps2m(116.519589, 39.930419, 116.522638, 39.929536));
	}
}
