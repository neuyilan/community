package com.community.ws.common;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.soap.SOAP11Constants;
import org.apache.axiom.soap.SOAP12Constants;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axiom.soap.SOAPFactory;
import org.apache.axiom.soap.SOAPHeader;
import org.apache.axiom.soap.SOAPHeaderBlock;
import org.apache.axis2.AxisFault;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.description.HandlerDescription;
import org.apache.axis2.engine.Handler;
import org.apache.axis2.handlers.AbstractHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
 

public class HeaderOutHandler extends AbstractHandler implements Handler{
	 
    private static final Log log = LogFactory.getLog(HeaderOutHandler.class);  
    public InvocationResponse invoke(MessageContext messageContext) throws AxisFault {
    //////这里是响应soapheader
        SOAPEnvelope soapEnvelope = messageContext.getEnvelope();
        if (soapEnvelope.getHeader() == null) {
            String soapNamespace = soapEnvelope.getNamespace()
                    .getNamespaceURI();
            // creating a soap factory according the the soap namespce uri
            SOAPFactory soapFactory = null;
            if (soapNamespace
                    .equals(SOAP11Constants.SOAP_ENVELOPE_NAMESPACE_URI)) {
                soapFactory = OMAbstractFactory.getSOAP11Factory();
            } else if (soapNamespace
                    .equals(SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI)) {
                soapFactory = OMAbstractFactory.getSOAP12Factory();
            } else {
                System.out.println("Unknow soap message");
            }
            soapFactory.createSOAPHeader(soapEnvelope);
        }
        OMNamespace omNamespace = OMAbstractFactory.getOMFactory().createOMNamespace("", "");
        SOAPHeader header = soapEnvelope.getHeader();
        SOAPHeaderBlock soapHeaderBlock = soapEnvelope.getHeader().addHeaderBlock("responsehead", omNamespace);
        //这里的aa,bb就是我要响应回去的response的头部消息,这里是写死了值,怎么可以在这个方法里面拿到request过来的头部消息
        SOAPHeaderBlock bizcode = soapEnvelope.getHeader().addHeaderBlock("aa", omNamespace);
        bizcode.setText("11223344");
        SOAPHeaderBlock transid = soapEnvelope.getHeader().addHeaderBlock("bb", omNamespace);
        transid.setText(new java.util.Date().toString());
        soapHeaderBlock.addChild(bizcode);
        soapHeaderBlock.addChild(transid);
    return InvocationResponse.CONTINUE;
    }
 
    @Override
    public void init(HandlerDescription handlerdesc) {
        System.out.println("########### HeaderOutHandler init() ###########");
    }

//	public void cleanup() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void flowComplete(MessageContext arg0) {
//		// TODO Auto-generated method stub
//		
//	}

//	public HandlerDescription getHandlerDesc() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public String getName() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public Parameter getParameter(String arg0) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public void init(HandlerDescription arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public InvocationResponse invoke(MessageContext arg0) throws AxisFault {
//		// TODO Auto-generated method stub
//		return null;
//	}
}