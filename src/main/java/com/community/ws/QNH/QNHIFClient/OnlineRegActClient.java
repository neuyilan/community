package com.community.ws.QNH.QNHIFClient;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ConfigurationContextFactory;
import org.codehaus.jettison.json.JSONObject;

import com.community.ws.common.HeaderOMElement;


 
public class OnlineRegActClient {
 
         private static EndpointReference targetEPR = new EndpointReference("http://localhost:8080/community/services/QNHOfflineRegActSer?wsdl");
 
         private String getAxis2ConfPath() {
                   StringBuilder confPath = new StringBuilder();
                   confPath.append(this.getClass().getResource("/").getPath());
                   confPath.append("repository");
                   return confPath.toString();
         }
 
         private String getAxis2ConfFilePath() {
                   String confFilePath = "";
                   confFilePath = getAxis2ConfPath() + "/axis2.xml";
                   return confFilePath;
 
         }
         
         public void testMyRampartService() {
                   Options options = new Options();
                   options.setAction("urn:regAct");
                   options.setTo(targetEPR);
                   ServiceClient sender = null;
                   String confFilePath = "";
                   String confPath = "";
                   try {
                            confPath = this.getAxis2ConfPath();
                            confFilePath = getAxis2ConfFilePath();
                            System.out.println("confPath======" + confPath);
                            System.out.println("confFilePath====" + confFilePath);
                            ConfigurationContext configContext = ConfigurationContextFactory
                                              .createConfigurationContextFromFileSystem(
                                            		  java.net.URLDecoder.decode(confPath,"utf-8") ,
                                            		  java.net.URLDecoder.decode(confFilePath,"utf-8")       );
                            sender = new ServiceClient(configContext, null);
//                            sender = new ServiceClient();
                            sender.setOptions(options);
 
                            OMFactory fac = OMAbstractFactory.getOMFactory();
                           
                            
                            
                            OMNamespace omNs = fac.createOMNamespace(
                                               "http://QNHIFServer.QNH.ws.community.com", "");
                            OMElement callMethod = fac.createOMElement("addActivity", omNs);
                            OMElement nameEle = fac.createOMElement("reqStr", omNs);
                            
                            JSONObject json = new JSONObject();
                            /* Test data */
                            json.put("QNHActId", "\"5><<>");
                            json.put("cellphone", "18610583510");
                            //{QNHActId:5,cellphone:18610583510}
//                          nameEle.setText("{id:001,name:sam,age:20}");
                            nameEle.setText(json.toString());
                            callMethod.addChild(nameEle);
                            long start = System.currentTimeMillis();
                            
//                           System.out.println(callMethod.toStringWithConsume());
//                            sender.addHeader();
                			/**添加soapHeader */
//                			sender.addHeader(HeaderOMElement.createHeaderOMElement(omNs));
                            OMFactory factory = OMAbstractFactory.getOMFactory();
                    		OMElement authenticationOM = factory.createOMElement("OKSoapHeader",	omNs);
                    		OMElement usernameOM = factory.createOMElement("userName",
                    				omNs);
                    		OMElement passwordOM = factory.createOMElement("passWord",
                    				omNs);
                    		usernameOM.setText("SQQNH");
                    		passwordOM.setText("naga+ok+");
                    		authenticationOM.addChild(usernameOM);
                    		authenticationOM.addChild(passwordOM);
                            OMElement response = sender.sendReceive(callMethod);
                            System.out.println("response====>" + response);
                            long end = System.currentTimeMillis();
                            System.out.println(end-start);
                            System.out.println(response.getFirstElement().getText());
                   } catch (Exception e) {
                            e.printStackTrace();
                   } finally {
                            if (sender != null)
                                     sender.disengageModule("addressing");
                            try {
                                     sender.cleanup();
                            } catch (Exception e) {
                            }
                   }
         }
 
         public static void main(String[] args) {
        	 OnlineRegActClient rampartServiceClient = new OnlineRegActClient();
                   rampartServiceClient.testMyRampartService();
 
         }
 
}