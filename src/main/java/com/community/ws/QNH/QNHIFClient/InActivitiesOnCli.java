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
 * @author Administrator 2.1.5 线上报名活动
 */
public class InActivitiesOnCli {

	private static EndpointReference targetEPR = new EndpointReference(DefaultConfig.getProperty("QHNSerAddr"));


	/**
	 * @author Administrator
	 * @desc 线上报名活动
	 * @param QNHActId 青年汇活动ID
	 * @param cellphone  报名手机号
	 */
	public String regOnLine(String QNHActId, String cellphone) {
		String retStr = "";
		Options options = new Options();
		options.setAction("http://ok.com/InActivities_on");
		options.setTo(targetEPR);
		ServiceClient sender = null;
		try {
			sender = new ServiceClient();
			sender.setOptions(options);
			OMFactory fac = OMAbstractFactory.getOMFactory();
			OMNamespace omNs = fac.createOMNamespace("http://ok.com/", "ok");
			OMElement callMethod = fac.createOMElement("InActivities_on", omNs);
			OMElement nameEle = fac.createOMElement("Json", omNs);
			JSONArray jsonArry = new JSONArray();
			// 
			jsonArry.add(0, new JSONObject().element("QNHActId", QNHActId)
					.element("cellphone", cellphone));
			System.out.println(jsonArry);

			nameEle.setText(jsonArry.toString());
			callMethod.addChild(nameEle);
			long start = System.currentTimeMillis();
			/**添加soapHeader */
			sender.addHeader(HeaderOMElement.createHeaderOMElement(omNs));
			sender.getOptions().setTimeOutInMilliSeconds(CommonData.TimeOutData.QHN_WS_TIMEOUT);
			OMElement response = sender.sendReceive(callMethod);
			System.out.println("response====>" + response);
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
		/*
00008A9E-CFFB-4C4D-A36D-5E8C83DD6E94
000A8003-A2CC-4BDC-A3C7-20A1E4179E61
000B148F-C7DB-4B31-AAF1-7F86BF6D8C1B
000B86FB-50C4-4E29-B681-EA86D1AF52FC

13718877107
15945116753
15040636057
18911905706

		 */
		InActivitiesOnCli inActivitiesOnCli = new InActivitiesOnCli();
		inActivitiesOnCli.regOnLine("00008A9E-CFFB-4C4D-A36D-5E8C83DD6E94", "13718877107");
//		inActivitiesOnCli.regOnLine("000A8003-A2CC-4BDC-A3C7-20A1E4179E61", "15945116753");
//		inActivitiesOnCli.regOnLine("000B148F-C7DB-4B31-AAF1-7F86BF6D8C1B", "15040636057");
//		inActivitiesOnCli.regOnLine("000B86FB-50C4-4E29-B681-EA86D1AF52FC", "18911905706");
	}

}
