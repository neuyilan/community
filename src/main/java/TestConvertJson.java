import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.community.framework.utils.JsonUtils;


//import net.sf.json.JSONObject;


public class TestConvertJson {
	
//	JSON.toJSONString(object);
	
	
	public static void main(String[] args) {
		String a= "aaa\"aaaa";
		System.out.println(a);
		System.out.println(JSON.toJSONString(a));
		JSONObject obj = new JSONObject();
		/*
		 //定义JSON字符串
	     String jsonStr = "{\"id\": 2," + 
	             " \"title\": \"json title\", " + 
	             "\"config\": {" +
	                 "\"width\": 34," +
	                 "\"height\": 35," +
	             "}, \"data\": [" +
	                 "\"JAVA\", \"Java\nScript\", \"PHP\"" +
	             "]}";
	     System.out.println(jsonStr);
	     System.out.println( JsonUtils.stringToJson(jsonStr));
//	     System.out.println(string2Json(jsonStr));
	     //转换成为JSONObject对象
//	     JSONObjectDeserializer.instance;
//	     JSONObject jo = new JSONObject();
//	     String aa=  "aaa\nbbb";
//	     System.out.println(aa);
//	     jo.put("xx", aa);
//	     System.out.println(jo.toString());
	 */    
	}
	
	public static StringBuffer string2Json(String s) {       
	    StringBuffer sb = new StringBuffer ();       
	    for (int i=0; i<s.length(); i++) {       
	     
	        char c = s.charAt(i);       
	        switch (c) {       
	        case '\"':       
	            sb.append("\\\"");       
	            break;       
	        case '\\':       
	            sb.append("\\\\");       
	            break;       
	        case '/':       
	            sb.append("\\/");       
	            break;       
	        case '\b':       
	            sb.append("\\b");       
	            break;       
	        case '\f':       
	            sb.append("\\f");       
	            break;       
	        case '\n':       
	            sb.append("\\n");       
	            break;       
	        case '\r':       
	            sb.append("\\r");       
	            break;       
	        case '\t':       
	            sb.append("\\t");       
	            break;       
	        default:       
	            sb.append(c);       
	        }  
	     
	 }  
	    return sb;     
	}

}
