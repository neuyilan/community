
/**
 * Goods.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.6  Built on : Aug 30, 2011 (10:01:01 CEST)
 */
            
                package com.community.ws.shop.req.xsd;
            

            /**
            *  Goods bean class
            */
        
        public  class Goods
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = Goods
                Namespace URI = http://req.shop.ws.community.com/xsd
                Namespace Prefix = 
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://req.shop.ws.community.com/xsd")){
                return "";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for GoodsNO
                        */

                        
                                    protected com.community.ws.shop.req.xsd.GoodsNO_type1 localGoodsNO ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.community.ws.shop.req.xsd.GoodsNO_type1
                           */
                           public  com.community.ws.shop.req.xsd.GoodsNO_type1 getGoodsNO(){
                               return localGoodsNO;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param GoodsNO
                               */
                               public void setGoodsNO(com.community.ws.shop.req.xsd.GoodsNO_type1 param){
                            
                                            this.localGoodsNO=param;
                                    

                               }
                            

                        /**
                        * field for GoodsName
                        */

                        
                                    protected com.community.ws.shop.req.xsd.GoodsName_type1 localGoodsName ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.community.ws.shop.req.xsd.GoodsName_type1
                           */
                           public  com.community.ws.shop.req.xsd.GoodsName_type1 getGoodsName(){
                               return localGoodsName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param GoodsName
                               */
                               public void setGoodsName(com.community.ws.shop.req.xsd.GoodsName_type1 param){
                            
                                            this.localGoodsName=param;
                                    

                               }
                            

                        /**
                        * field for GoodsPrice
                        */

                        
                                    protected com.community.ws.shop.req.xsd.GoodsPrice_type1 localGoodsPrice ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.community.ws.shop.req.xsd.GoodsPrice_type1
                           */
                           public  com.community.ws.shop.req.xsd.GoodsPrice_type1 getGoodsPrice(){
                               return localGoodsPrice;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param GoodsPrice
                               */
                               public void setGoodsPrice(com.community.ws.shop.req.xsd.GoodsPrice_type1 param){
                            
                                            this.localGoodsPrice=param;
                                    

                               }
                            

                        /**
                        * field for GoodsAmount
                        */

                        
                                    protected com.community.ws.shop.req.xsd.GoodsAmount_type1 localGoodsAmount ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.community.ws.shop.req.xsd.GoodsAmount_type1
                           */
                           public  com.community.ws.shop.req.xsd.GoodsAmount_type1 getGoodsAmount(){
                               return localGoodsAmount;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param GoodsAmount
                               */
                               public void setGoodsAmount(com.community.ws.shop.req.xsd.GoodsAmount_type1 param){
                            
                                            this.localGoodsAmount=param;
                                    

                               }
                            

                        /**
                        * field for GoodsAgio
                        */

                        
                                    protected com.community.ws.shop.req.xsd.GoodsAgio_type1 localGoodsAgio ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.community.ws.shop.req.xsd.GoodsAgio_type1
                           */
                           public  com.community.ws.shop.req.xsd.GoodsAgio_type1 getGoodsAgio(){
                               return localGoodsAgio;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param GoodsAgio
                               */
                               public void setGoodsAgio(com.community.ws.shop.req.xsd.GoodsAgio_type1 param){
                            
                                            this.localGoodsAgio=param;
                                    

                               }
                            

                        /**
                        * field for Para_a
                        */

                        
                                    protected com.community.ws.shop.req.xsd.Para_a_type3 localPara_a ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPara_aTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.community.ws.shop.req.xsd.Para_a_type3
                           */
                           public  com.community.ws.shop.req.xsd.Para_a_type3 getPara_a(){
                               return localPara_a;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Para_a
                               */
                               public void setPara_a(com.community.ws.shop.req.xsd.Para_a_type3 param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localPara_aTracker = true;
                                       } else {
                                          localPara_aTracker = false;
                                              
                                       }
                                   
                                            this.localPara_a=param;
                                    

                               }
                            

                        /**
                        * field for Para_b
                        */

                        
                                    protected com.community.ws.shop.req.xsd.Para_b_type3 localPara_b ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPara_bTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.community.ws.shop.req.xsd.Para_b_type3
                           */
                           public  com.community.ws.shop.req.xsd.Para_b_type3 getPara_b(){
                               return localPara_b;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Para_b
                               */
                               public void setPara_b(com.community.ws.shop.req.xsd.Para_b_type3 param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localPara_bTracker = true;
                                       } else {
                                          localPara_bTracker = false;
                                              
                                       }
                                   
                                            this.localPara_b=param;
                                    

                               }
                            

                        /**
                        * field for Para_c
                        */

                        
                                    protected com.community.ws.shop.req.xsd.Para_c_type3 localPara_c ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPara_cTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.community.ws.shop.req.xsd.Para_c_type3
                           */
                           public  com.community.ws.shop.req.xsd.Para_c_type3 getPara_c(){
                               return localPara_c;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Para_c
                               */
                               public void setPara_c(com.community.ws.shop.req.xsd.Para_c_type3 param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localPara_cTracker = true;
                                       } else {
                                          localPara_cTracker = false;
                                              
                                       }
                                   
                                            this.localPara_c=param;
                                    

                               }
                            

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       Goods.this.serialize(parentQName,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               parentQName,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://req.shop.ws.community.com/xsd");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":Goods",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "Goods",
                           xmlWriter);
                   }

               
                   }
               
                                            if (localGoodsNO==null){
                                                 throw new org.apache.axis2.databinding.ADBException("goodsNO cannot be null!!");
                                            }
                                           localGoodsNO.serialize(new javax.xml.namespace.QName("http://req.shop.ws.community.com/xsd","goodsNO"),
                                               factory,xmlWriter);
                                        
                                            if (localGoodsName==null){
                                                 throw new org.apache.axis2.databinding.ADBException("goodsName cannot be null!!");
                                            }
                                           localGoodsName.serialize(new javax.xml.namespace.QName("http://req.shop.ws.community.com/xsd","goodsName"),
                                               factory,xmlWriter);
                                        
                                            if (localGoodsPrice==null){
                                                 throw new org.apache.axis2.databinding.ADBException("goodsPrice cannot be null!!");
                                            }
                                           localGoodsPrice.serialize(new javax.xml.namespace.QName("http://req.shop.ws.community.com/xsd","goodsPrice"),
                                               factory,xmlWriter);
                                        
                                            if (localGoodsAmount==null){
                                                 throw new org.apache.axis2.databinding.ADBException("goodsAmount cannot be null!!");
                                            }
                                           localGoodsAmount.serialize(new javax.xml.namespace.QName("http://req.shop.ws.community.com/xsd","goodsAmount"),
                                               factory,xmlWriter);
                                        
                                            if (localGoodsAgio==null){
                                                 throw new org.apache.axis2.databinding.ADBException("goodsAgio cannot be null!!");
                                            }
                                           localGoodsAgio.serialize(new javax.xml.namespace.QName("http://req.shop.ws.community.com/xsd","goodsAgio"),
                                               factory,xmlWriter);
                                         if (localPara_aTracker){
                                            if (localPara_a==null){
                                                 throw new org.apache.axis2.databinding.ADBException("para_a cannot be null!!");
                                            }
                                           localPara_a.serialize(new javax.xml.namespace.QName("http://req.shop.ws.community.com/xsd","para_a"),
                                               factory,xmlWriter);
                                        } if (localPara_bTracker){
                                            if (localPara_b==null){
                                                 throw new org.apache.axis2.databinding.ADBException("para_b cannot be null!!");
                                            }
                                           localPara_b.serialize(new javax.xml.namespace.QName("http://req.shop.ws.community.com/xsd","para_b"),
                                               factory,xmlWriter);
                                        } if (localPara_cTracker){
                                            if (localPara_c==null){
                                                 throw new org.apache.axis2.databinding.ADBException("para_c cannot be null!!");
                                            }
                                           localPara_c.serialize(new javax.xml.namespace.QName("http://req.shop.ws.community.com/xsd","para_c"),
                                               factory,xmlWriter);
                                        }
                    xmlWriter.writeEndElement();
               

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                
                            elementList.add(new javax.xml.namespace.QName("http://req.shop.ws.community.com/xsd",
                                                                      "goodsNO"));
                            
                            
                                    if (localGoodsNO==null){
                                         throw new org.apache.axis2.databinding.ADBException("goodsNO cannot be null!!");
                                    }
                                    elementList.add(localGoodsNO);
                                
                            elementList.add(new javax.xml.namespace.QName("http://req.shop.ws.community.com/xsd",
                                                                      "goodsName"));
                            
                            
                                    if (localGoodsName==null){
                                         throw new org.apache.axis2.databinding.ADBException("goodsName cannot be null!!");
                                    }
                                    elementList.add(localGoodsName);
                                
                            elementList.add(new javax.xml.namespace.QName("http://req.shop.ws.community.com/xsd",
                                                                      "goodsPrice"));
                            
                            
                                    if (localGoodsPrice==null){
                                         throw new org.apache.axis2.databinding.ADBException("goodsPrice cannot be null!!");
                                    }
                                    elementList.add(localGoodsPrice);
                                
                            elementList.add(new javax.xml.namespace.QName("http://req.shop.ws.community.com/xsd",
                                                                      "goodsAmount"));
                            
                            
                                    if (localGoodsAmount==null){
                                         throw new org.apache.axis2.databinding.ADBException("goodsAmount cannot be null!!");
                                    }
                                    elementList.add(localGoodsAmount);
                                
                            elementList.add(new javax.xml.namespace.QName("http://req.shop.ws.community.com/xsd",
                                                                      "goodsAgio"));
                            
                            
                                    if (localGoodsAgio==null){
                                         throw new org.apache.axis2.databinding.ADBException("goodsAgio cannot be null!!");
                                    }
                                    elementList.add(localGoodsAgio);
                                 if (localPara_aTracker){
                            elementList.add(new javax.xml.namespace.QName("http://req.shop.ws.community.com/xsd",
                                                                      "para_a"));
                            
                            
                                    if (localPara_a==null){
                                         throw new org.apache.axis2.databinding.ADBException("para_a cannot be null!!");
                                    }
                                    elementList.add(localPara_a);
                                } if (localPara_bTracker){
                            elementList.add(new javax.xml.namespace.QName("http://req.shop.ws.community.com/xsd",
                                                                      "para_b"));
                            
                            
                                    if (localPara_b==null){
                                         throw new org.apache.axis2.databinding.ADBException("para_b cannot be null!!");
                                    }
                                    elementList.add(localPara_b);
                                } if (localPara_cTracker){
                            elementList.add(new javax.xml.namespace.QName("http://req.shop.ws.community.com/xsd",
                                                                      "para_c"));
                            
                            
                                    if (localPara_c==null){
                                         throw new org.apache.axis2.databinding.ADBException("para_c cannot be null!!");
                                    }
                                    elementList.add(localPara_c);
                                }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static Goods parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Goods object =
                new Goods();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"Goods".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (Goods)com.community.ws.shop.rsp.xsd.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://req.shop.ws.community.com/xsd","goodsNO").equals(reader.getName())){
                                
                                                object.setGoodsNO(com.community.ws.shop.req.xsd.GoodsNO_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://req.shop.ws.community.com/xsd","goodsName").equals(reader.getName())){
                                
                                                object.setGoodsName(com.community.ws.shop.req.xsd.GoodsName_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://req.shop.ws.community.com/xsd","goodsPrice").equals(reader.getName())){
                                
                                                object.setGoodsPrice(com.community.ws.shop.req.xsd.GoodsPrice_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://req.shop.ws.community.com/xsd","goodsAmount").equals(reader.getName())){
                                
                                                object.setGoodsAmount(com.community.ws.shop.req.xsd.GoodsAmount_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://req.shop.ws.community.com/xsd","goodsAgio").equals(reader.getName())){
                                
                                                object.setGoodsAgio(com.community.ws.shop.req.xsd.GoodsAgio_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://req.shop.ws.community.com/xsd","para_a").equals(reader.getName())){
                                
                                                object.setPara_a(com.community.ws.shop.req.xsd.Para_a_type3.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://req.shop.ws.community.com/xsd","para_b").equals(reader.getName())){
                                
                                                object.setPara_b(com.community.ws.shop.req.xsd.Para_b_type3.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://req.shop.ws.community.com/xsd","para_c").equals(reader.getName())){
                                
                                                object.setPara_c(com.community.ws.shop.req.xsd.Para_c_type3.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                  
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          