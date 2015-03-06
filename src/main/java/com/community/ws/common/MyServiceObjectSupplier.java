package com.community.ws.common;


/* 
@Component
public class MyServiceObjectSupplier  implements ServiceObjectSupplier,ApplicationContextAware {

	 
//	private static ApplicationContext applicationContext;
	@Autowired
	 private ApplicationContext applicationContext;  

	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		System.err.println("进入 MyServiceObjectSupplier set");
		this.applicationContext = ctx;
	}

	public Object getServiceObject(AxisService axisService) throws AxisFault {
		 System.err.println("进入 MyServiceObjectSupplier get");
		  
	        Parameter springBeanName = axisService.getParameter("SpringBeanName");  
	        String beanName = ((String) springBeanName.getValue()).trim();  
	  
	        if (beanName != null) {  
	        	//这块是个人添加的，在网络上找到很多帖子，不知道如何注入applicationContext,就想了这样的一个笨办法  
	            applicationContext = ApplicationContextHolder.getContext();  
	            if (applicationContext == null)  
	                throw new AxisFault("applicationContext is NULL! ");  
	            if (applicationContext.getBean(beanName) == null)  
	                throw new AxisFault("Axis2 Can't find Spring Bean: " + beanName);  
	            return applicationContext.getBean(beanName);  
	        } else {  
	            throw new AxisFault(Messages.getMessage("paramIsNotSpecified",  
	                    "SERVICE_SPRING_BEANNAME"));  
	        }  
	  
	         
		 Parameter springBeanName = axisService.getParameter("SpringBeanName");
	        String beanName = ((String) springBeanName.getValue()).trim();
	        if (beanName != null) {
	            if (applicationContext == null)
	                throw new AxisFault("applicationContext is NULL! ");
	            if (applicationContext.getBean(beanName) == null)
	                throw new AxisFault("Axis2 Can't find Spring Bean: " + beanName);
	            return applicationContext.getBean(beanName);
	        } else {
	            throw new AxisFault(Messages.getMessage("paramIsNotSpecified",
	                    "SERVICE_SPRING_BEANNAME"));
	        }
	}
//
}
*/