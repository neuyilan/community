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

import com.community.framework.utils.CommonData;
import com.community.framework.utils.DefaultConfig;
import com.community.framework.utils.JsonUtils;
import com.community.ws.common.HeaderOMElement;

/**
 * @author Administrator 2.1.3 获取青年汇信息 ok
 */
public class GetQnhInfoCli {

	private static EndpointReference targetEPR = new EndpointReference(DefaultConfig.getProperty("QHNSerAddr"));

	/**
	 * @param QNHActId  青年汇 活动ID
	 */
	public String getQnhInfo(String QNHActId) {
		String retStr = "";
		Options options = new Options();
		options.setAction("http://ok.com/GetQnh_info");
		options.setTo(targetEPR);
		ServiceClient sender = null;
		try {
			sender = new ServiceClient();
			sender.setOptions(options);
			OMFactory fac = OMAbstractFactory.getOMFactory();
			OMNamespace omNs = fac.createOMNamespace("http://ok.com/", "ok");
			OMElement callMethod = fac.createOMElement("GetQnh_info", omNs);
			OMElement nameEle = fac.createOMElement("Json", omNs);
			JSONArray jsonArry = new JSONArray();
			jsonArry.add(0, new JSONObject().element("id", QNHActId));

			nameEle.setText(jsonArry.toString());
			callMethod.addChild(nameEle);
			long start = System.currentTimeMillis();
			/**添加soapHeader */
			sender.addHeader(HeaderOMElement.createHeaderOMElement(omNs));
			//180000 
			sender.getOptions().setTimeOutInMilliSeconds(180000L/*CommonData.TimeOutData.QHN_WS_TIMEOUT*/);
			OMElement response = sender.sendReceive(callMethod);
//			System.out.println("response====>" + response);
			long end = System.currentTimeMillis();
			System.out.println(end - start);
			retStr = JsonUtils.stringToJson( response.getFirstElement().getText());
			System.out.println(retStr);
		} catch (Exception e) {
			retStr = "";
			e.printStackTrace();
		} finally {
			if (sender != null)
				sender.disengageModule("addressing");
			try {
				sender.cleanupTransport();
				sender.cleanup();
			} catch (Exception e) {
				retStr = "";
				e.printStackTrace();
			}
		}
		return retStr;
	}

	public static void main(String[] args) {
		GetQnhInfoCli getQnhInfoCli = new GetQnhInfoCli();
//		getQnhInfoCli.getQnhInfo("C027DDC5-2096-4B87-9477-7B79C36E8938");
//		getQnhInfoCli.getQnhInfo("3AC6C979-7DB7-4F1D-91C8-069C2A70F752");
		getQnhInfoCli.getQnhInfo("36F79468-8976-4CB7-9EF0-01464DFBDEC7");
//		getQnhInfoCli.getQnhInfo("F1B382F2-7085-4AD1-B715-0171CB2AA448");
	}

}
