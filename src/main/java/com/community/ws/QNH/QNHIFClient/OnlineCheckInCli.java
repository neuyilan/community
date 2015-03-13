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

/**
 * @author Administrator 2.1.7 线上签到活动
 */
public class OnlineCheckInCli {

	private static EndpointReference targetEPR = new EndpointReference(DefaultConfig.getProperty("QHNSerAddr"));

	public void signOnline() {
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
			jsonArry.add(0, new JSONObject().element("QNHActId", "229408").element("cellphone", "15945116753"));
			System.out.println(jsonArry);

			nameEle.setText(jsonArry.toString());
			callMethod.addChild(nameEle);
			long start = System.currentTimeMillis();
			sender.getOptions().setTimeOutInMilliSeconds(CommonData.TimeOutData.QHN_WS_TIMEOUT);
			OMElement response = sender.sendReceive(callMethod);
			System.out.println("response====>" + response);
			long end = System.currentTimeMillis();
			System.out.println(end - start);
			System.out.println(response.getFirstElement().getText());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sender != null)
				sender.disengageModule("addressing");
			try {
				sender.cleanup();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		OnlineCheckInCli onlineCheckInCli = new OnlineCheckInCli();
		onlineCheckInCli.signOnline();
	}

}
