package com.sidj.mail;

import java.sql.Timestamp;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulerController {
	
	/*@Scheduled(cron = "${timing}")
	public void method1()  {
		
		
			
			System.out.println("Scheduler started at this time for method1 "
					+ new Timestamp(System.currentTimeMillis()));
		
	}*/
	
	/*@Scheduled(initialDelay = 1000, fixedRate = 1800000)
	public void method2()  {
		
		
			
			System.out.println("Scheduler started at midnight for method2 "
					+ new Timestamp(System.currentTimeMillis()));
		
	}*/

}
