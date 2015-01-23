package com.community.app.module.task;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.community.app.module.service.AppAutomobileNumberService;
import com.community.app.module.service.AppUserService;
import com.community.app.module.service.BusinessActivityService;
import com.community.app.module.service.BusinessExpService;
import com.community.framework.utils.weather;
@Component 

public class MyTask {  
	@Autowired
	private BusinessActivityService businessActivityService;
	@Autowired
	private BusinessExpService businessExpService;
	@Autowired
	private AppUserService appUserService;
	@Autowired
	private AppAutomobileNumberService appAutomobileNumberService;
	
	
//    @Scheduled(cron="0 0/1 * * * ? ")  
    public void taskCycle(){  //1分钟查询活动并改变活动状态
        //System.out.println(new Date());  
        businessActivityService.updateState();
    }   
//    @Scheduled(cron="0 0/1 * * * ? ") //
    public void taskisTimingPush(){  //1分钟查询活动是否有定时推送
        //System.out.println(new Date());  
        businessActivityService.isTimingPush();
    }  
//    @Scheduled(cron="0 0/1 * * * ? ") //
    public void taskisTimingPublicTime(){  //1分钟查询活动是否有定时发布
        //System.out.println(new Date());  
        businessActivityService.isTimingPublicTime();
    }
//    @Scheduled(cron="0 0 14 * * ? ") //14点时检查快件是否是问题件  
    public void taskExp1(){  
        System.out.println(new Date());    
        //businessExpService.taskUpdateState();
    }  
//    @Scheduled(cron="0 0 18 * * ? ") //18点时检查快件是否是问题件  
    public void taskExp2(){  
        System.out.println(new Date());  
        //businessExpService.taskUpdateState1();
    }  
   
    //@Scheduled(cron="0/5 * * * * ? ")  
//    @Scheduled(cron="0 0 0/1 * * ? ")  
    public void taskGrabWeather(){  //每一小时抓取一次天气
        System.out.println(new Date());  
        weather.grabWeather();
    }  
    
//    @Scheduled(cron="0 0 8 * * ? ")  
    //@Scheduled(cron="0/5 * * * * ? ")  
    public void taskPushWeather(){  //8点推送天气
        System.out.println(new Date());  
        appUserService.pushWeather();
    }  
    
    //@Scheduled(cron="0/5 * * * * ? ")  
//    @Scheduled(cron="0 2 0 * * ? ")  
    public void taskGrabLimit(){  //0点2分抓取一次限行
        System.out.println(new Date());  
        weather.grabLimit();
    }  
    
    //@Scheduled(cron="0/5 * * * * ? ")  
//    @Scheduled(cron="0 0 6 * * ? ")  
    public void taskGrabLimit1(){  //6点抓取限行抓取一次限行
        System.out.println(new Date());  
        weather.grabLimit();
    }  
    
    //@Scheduled(cron="0/5 * * * * ? ")  
//    @Scheduled(cron="0 0 20 * * ? ")  
    public void taskPushLimit(){  //推送限行
        System.out.println(new Date());  
        appAutomobileNumberService.pushLimit();
    }  
    
}  
