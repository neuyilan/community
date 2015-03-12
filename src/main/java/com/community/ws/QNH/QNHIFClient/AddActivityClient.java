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

//import cn.com.common.DefaultConfig;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;
 
public class AddActivityClient {
 
         private static EndpointReference targetEPR = new EndpointReference("http://123.177.21.155:8888/ok_.asmx?wsdl"/*DefaultConfig.getProperty("QNHActivitySer")*/);
 
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
//                   options.setAction("urn:MemberCheck");
                   options.setAction("http://ok.com/MemberCheck");
                   
                   options.setTo(targetEPR);
                   ServiceClient sender = null;
                   String confFilePath = "";
                   String confPath = "";
                   try {
                            confPath = this.getAxis2ConfPath();
                            confFilePath = getAxis2ConfFilePath();
                            System.out.println("confPath======" + confPath);
                            System.out.println("confFilePath====" + confFilePath);
//                            ConfigurationContext configContext = ConfigurationContextFactory
//                                              .createConfigurationContextFromFileSystem(
//                                            		  java.net.URLDecoder.decode(confPath,"utf-8") ,
//                                            		  java.net.URLDecoder.decode(confFilePath,"utf-8")       );
//                            sender = new ServiceClient(configContext, null);
                            sender = new ServiceClient();
                            sender.setOptions(options);
 
                            OMFactory fac = OMAbstractFactory.getOMFactory();
                           
                            OMNamespace omNs = fac.createOMNamespace(
                                               "http://ok.com/", "");
                            OMElement callMethod = fac.createOMElement("MemberCheck", omNs);
                            OMElement nameEle = fac.createOMElement("phone", omNs);
                            OMElement nameEle2 = fac.createOMElement("flag", omNs);
                            JSONObject json = new JSONObject();
                            
                            /* Test data */
                            json.put("typeId", "5");
                            json.put("QNHActId", "23");
                            json.put("actName", "活动名称");
                            json.put("brief", "活动简介");
                            json.put("actContent", "<p><span style=\"color: rgb(4, 4, 4); font-family: 微软雅黑; font-size: medium; background-color: rgb(255, 255, 255);\">报名活动</span></p>");
                            json.put("actPic", "活动图片");
                            json.put("startTime", "开始时间");
                            json.put("endTime", "结束时间");
                            json.put("brief", "活动简介");
                            json.put("longitude", "139.3243324");
                            json.put("latitude", "49.2323432");
                            json.put("QNHName", "青年汇名称");
                            json.put("QNHId", "11");
                            
//                          nameEle.setText("{id:001,name:sam,age:20}");
                            //nameEle.setText(json.toString());
                            nameEle.setText("18610583510");
                            nameEle2.setText("1");
                            callMethod.addChild(nameEle);
                            callMethod.addChild(nameEle2);
                            long start = System.currentTimeMillis();
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
        	 AddActivityClient rampartServiceClient = new AddActivityClient();
                   rampartServiceClient.testMyRampartService();
 
         }
 
}