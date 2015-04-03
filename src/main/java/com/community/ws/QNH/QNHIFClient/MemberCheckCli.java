package com.community.ws.QNH.QNHIFClient;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.commons.httpclient.ConnectionPoolTimeoutException;

import com.community.framework.utils.CommonData;
import com.community.framework.utils.DefaultConfig;
import com.community.framework.utils.JsonUtils;
import com.community.ws.common.HeaderOMElement;

/**
 * @author Administrator 2.1.1 判断用户接口
 */
public class MemberCheckCli {

	private static EndpointReference targetEPR = new EndpointReference(DefaultConfig.getProperty("QHNSerAddr"));

	/**
	 * @param cellphone
	 * @return json 
	 */
	public String memberCheck(String cellphone) {
		String str="";
		Options options = new Options();
		options.setAction("http://ok.com/MemberCheck");
		options.setTo(targetEPR);
		ServiceClient sender = null;
		try {
			sender = new ServiceClient();
			sender.setOptions(options);
			OMFactory fac = OMAbstractFactory.getOMFactory();
			OMNamespace omNs = fac.createOMNamespace("http://ok.com/", "ok");
			OMElement callMethod = fac.createOMElement("MemberCheck", omNs);
			OMElement nameEle = fac.createOMElement("Json", omNs);
			
			
			JSONArray jsonArry = new JSONArray();
			jsonArry.add(0, new JSONObject().element("cellphone", cellphone));
			System.out.println(jsonArry);

			nameEle.setText(jsonArry.toString());
			callMethod.addChild(nameEle);
			long start = System.currentTimeMillis();
			/**添加soapHeader */
			sender.addHeader(HeaderOMElement.createHeaderOMElement(omNs));
			//设置超时
	        // This enables the user to pass in socket timeout value as an Integer. If nothing is set, the default value is 60000 milliseconds.
			sender.getOptions().setProperty(HTTPConstants.CONNECTION_TIMEOUT, (int)CommonData.TimeOutData.QHN_WS_TIMEOUT);
			// This enables the user to pass in connection timeout value as an Integer. If nothing is set, the default value is 60000 milliseconds.
			sender.getOptions().setProperty(HTTPConstants.SO_TIMEOUT, (int)CommonData.TimeOutData.QHN_WS_TIMEOUT);
			sender.getOptions().setTimeOutInMilliSeconds(CommonData.TimeOutData.QHN_WS_TIMEOUT);
			OMElement response = sender.sendReceive(callMethod);
			System.out.println("response====>" + response);
			long end = System.currentTimeMillis();
			System.out.println((end - start)/1000);
			System.out.println(response.getFirstElement().getText());
			str = JsonUtils.stringToJson( response.getFirstElement().getText());
		} catch (Exception e) {
			if (e.getCause() instanceof ConnectionPoolTimeoutException)
				System.out.println("访问超时！");
			str = "";
			e.printStackTrace();
		} finally {
			if (sender != null)
				sender.disengageModule("addressing");
			try {
				sender.cleanupTransport();
				sender.cleanup();
			} catch (Exception e) {
				str = "";
				e.printStackTrace();
			}
		}
		return str;
	}

	public static void main(String[] args) {
		MemberCheckCli memberCheckCli = new MemberCheckCli();
		memberCheckCli.memberCheck("13718877107");//15945116753
//		memberCheckCli.memberCheck("15945116753");//15945116753
//		memberCheckCli.memberCheck("15040636057");//15945116753
//		memberCheckCli.memberCheck("18911905706");//15945116753
	}

}
