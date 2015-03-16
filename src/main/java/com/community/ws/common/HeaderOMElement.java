package com.community.ws.common;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;

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
}
