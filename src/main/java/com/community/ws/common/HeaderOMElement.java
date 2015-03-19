package com.community.ws.common;

import java.util.Iterator;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.context.MessageContext;

/**
 * @author Administrator
 * @date 2015-3-16 13:32:16 
 */
public class HeaderOMElement {

	public static OMElement createHeaderOMElement(OMNamespace SecurityElementNamespace) {
		OMFactory factory = OMAbstractFactory.getOMFactory();
//		OMNamespace SecurityElementNamespace = factory.createOMNamespace(
//				"http://handler.com", "ok");
		OMElement authenticationOM = factory.createOMElement("MySoapHeader",
				SecurityElementNamespace);
		OMElement usernameOM = factory.createOMElement("Uname",
				SecurityElementNamespace);
		OMElement passwordOM = factory.createOMElement("Password",
				SecurityElementNamespace);
		usernameOM.setText("SQQNH");
		passwordOM.setText("naga+ok+");
		authenticationOM.addChild(usernameOM);
		authenticationOM.addChild(passwordOM);
		return authenticationOM;
	}
	
	
	/**
	 * @param msgContext
	 * @return
	 */
	public static boolean checkWSUser(MessageContext msgContext) {
		Iterator<?> list = msgContext.getEnvelope().getHeader().getFirstElement().getChildElements();
		String userName = "";
		String passWord = "";
		while (list.hasNext()) {
			OMElement element = (OMElement) list.next();
			if (element.getLocalName().equals("userName"))
				userName = element.getText();
			if (element.getLocalName().equals("passWord"))
				passWord = element.getText();
		}
		if (!userName.equals("BQSQOK") || !passWord.equals("ba5ae1ef")) 
			return false;
		else
			return true;
	}
	
	
}
