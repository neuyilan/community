package com.community.ws.QNH.QNHIFClient;

import java.util.Iterator;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.MessageContext;

import com.community.framework.utils.CommonData;
import com.community.framework.utils.DefaultConfig;
import com.community.ws.common.HeaderOMElement;

/**
 * @author Administrator 2.1.1 判断用户接口
 */
public class MemberCheckCli {

	private static EndpointReference targetEPR = new EndpointReference(DefaultConfig.getProperty("QHNSerAddr"));

	public void memberCheck() {
		
		
		
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
			jsonArry.add(0, new JSONObject().element("cellphone", "15945116753"));
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
		MemberCheckCli memberCheckCli = new MemberCheckCli();
		memberCheckCli.memberCheck();
	}

}
