
import java.io.*;
import java.net.*;
import java.security.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WSClient {
	public static void main(String[] args) {

		SendMsg();
	}
	
	public static String SendMsg()
	{
		String result = "";
//		String soapAction = "http://entinfo.cn/mdsmssend";
//		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
//		xml += "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">";
//		xml += "<soap:Body>";
//		xml += "<mdsmssend  xmlns=\"http://entinfo.cn/\">";
//		xml += "<sn>" + sn + "</sn>";
//		xml += "<pwd>" + pwd + "</pwd>";
//		xml += "<mobile>" + mobile + "</mobile>";
//		xml += "<content>" + content + "</content>";
//		xml += "<ext>" + ext + "</ext>";
//		xml += "<stime>" + stime + "</stime>";
//		xml += "<rrid>" + rrid + "</rrid>";
//		xml += "<msgfmt>" + msgfmt + "</msgfmt>";
//		xml += "</mdsmssend>";
//		xml += "</soap:Body>";
//		xml += "</soap:Envelope>";
		String  xml = "<soapenv:Envelope xmlns:soapenv='\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://ser.shop.ws.community.com\" xmlns:xsd=\"http://req.shop.ws.community.com/xsd\">";
		xml += "   <soapenv:Header/>";
		xml += "   <soapenv:Body>";
		xml += "      <ser:retOrder>";
		xml += "         <ser:root>";
		xml += "            <xsd:body>";
		xml += "               <xsd:order>";
		xml += "                  <xsd:userId>111</xsd:userId>";
		xml += "                  <xsd:orderNo>111</xsd:orderNo>";
		xml += "                  <xsd:orderTime>20150101122323</xsd:orderTime>";
		xml += "                  <xsd:goodsList>";
		xml += "                     <!--1 or more repetitions:-->";
		xml += "                     <xsd:goods>";
		xml += "                        <xsd:goodsAgio>7.5</xsd:goodsAgio>";
		xml += "                        <xsd:goodsAmount>100</xsd:goodsAmount>";
		xml += "                        <xsd:goodsNO>1000</xsd:goodsNO>";
		xml += "                        <xsd:goodsName>ADDDS</xsd:goodsName>";
		xml += "                        <xsd:goodsPrice>79.40</xsd:goodsPrice>";
		xml += "                     </xsd:goods>";
		xml += "                     <xsd:goods>";
		xml += "                        <xsd:goodsAgio>7.5</xsd:goodsAgio>";
		xml += "                        <xsd:goodsAmount>10</xsd:goodsAmount>";
		xml += "                        <xsd:goodsNO>100</xsd:goodsNO>";
		xml += "                        <xsd:goodsName>SDSD</xsd:goodsName>";
		xml += "                        <xsd:goodsPrice>99.40</xsd:goodsPrice>";
		xml += "                     </xsd:goods>";
		xml += "                     <xsd:goods>";
		xml += "                        <xsd:goodsAgio>8</xsd:goodsAgio>";
		xml += "                        <xsd:goodsAmount>10330</xsd:goodsAmount>";
		xml += "                        <xsd:goodsNO>1900</xsd:goodsNO>";
		xml += "                        <xsd:goodsName>XDSSD</xsd:goodsName>";
		xml += "                        <xsd:goodsPrice>100.00</xsd:goodsPrice>";
		xml += "                     </xsd:goods>";
		xml += "                  </xsd:goodsList>";
		xml += "               </xsd:order>";
		xml += "            </xsd:body>";
		xml += "            <xsd:header>";
		xml += "               <xsd:flowId>12</xsd:flowId>";
		xml += "               <xsd:shopCode>12</xsd:shopCode>";
		xml += "               <xsd:shopKey>234</xsd:shopKey>";
		xml += "            </xsd:header>";
		xml += "         </ser:root>";
		xml += "      </ser:retOrder>";
		xml += "   </soapenv:Body>";
		xml += "</soapenv:Envelope>";
		URL url;
		try {
			url = new URL("http://localhost:8080/community/services/RetOrderSer?wsdl");

			URLConnection connection = url.openConnection();
			HttpURLConnection httpconn = (HttpURLConnection) connection;
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			bout.write(xml.getBytes());
			byte[] b = bout.toByteArray();
			httpconn.setConnectTimeout(300);
			httpconn.setRequestProperty("Content-Length", String.valueOf(b.length));
			httpconn.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			httpconn.setRequestProperty("SOAPAction", "urn:retOrder");
			httpconn.setRequestProperty("User-Agent", "Jakarta Commons-HttpClient/3.1"); 
			httpconn.setRequestMethod("POST");
			
			httpconn.setDoInput(true);
			httpconn.setDoOutput(true);

			OutputStream out = httpconn.getOutputStream();
			out.write(b);
			out.close();

			InputStreamReader isr = new InputStreamReader(httpconn.getInputStream());
			BufferedReader in = new BufferedReader(isr);
			System.out.println(in.toString());
//			String inputLine;
//			while (null != (inputLine = in.readLine())) {
//				Pattern pattern = Pattern.compile("<mdsmssendResult>(.*)</mdsmssendResult>");
//				Matcher matcher = pattern.matcher(inputLine);
//				while (matcher.find()) {
//					result = matcher.group(1);
//				}
//			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	
	}
}
