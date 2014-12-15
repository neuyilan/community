package com.community.app.module.common;

import java.util.Comparator;

public class MenuComparator implements Comparator{

	public int compare(Object arg0, Object arg1) {
		  UserMenuBean user0=(UserMenuBean)arg0;
		  UserMenuBean user1=(UserMenuBean)arg1;
		  int flag=user0.getNo().compareTo(user1.getNo());
		  if(flag==0){
		   return user0.getNo().compareTo(user1.getNo());
		  }else{
		   return flag;
		  }  
		 }
	
}
