package com.symplore.onboarding.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map; 
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.symplore.onboarding.service.NotificationService;
import com.symplore.onboarding.service.Tasks; 

@RestController
@RequestMapping(value="/onboarding")
public class OnboardingController {
	
	private Log logger = LogFactory.getLog(OnboardingController.class); 
	
	@Autowired
	private NotificationService notificationService;

 
	@RequestMapping(value = "/assignTask", 
	  produces = "application/json", 
	  method=RequestMethod.GET)
	public String sendEmail() throws Exception {
		//This is for dummy, in reality, Task will be sent by client form
		
		Tasks task = new Tasks();
		task.setName("Update your profile.");
		task.setAssignTo("Khai"); 
		task.setAssignToEmail("khai.nyunt@symplore.com"); 
		task.setSender("khainyunt@gmail.com"); 
		task.setDescription("Sending Email with Thymeleaf HTML Template For Onboarding Assigned Task");
		task.setDueDate(new Date()); 
		 
		notificationService.prepareAndSend(task);  
		
		return "Assigned Task Sent."; 
		
	}

}
