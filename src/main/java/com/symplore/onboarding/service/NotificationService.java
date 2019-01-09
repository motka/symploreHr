package com.symplore.onboarding.service; 

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import com.symplore.onboarding.controller.OnboardingController;

import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.core.io.Resource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator; 



@Service
public class NotificationService { 

	@Autowired
    private JavaMailSender javaMailSender;
    private MailTemplateHandler mailTemplateHandler;
    private Log logger = LogFactory.getLog(NotificationService.class); 
	
    
    @Autowired
    public NotificationService(JavaMailSender javaMailSender, MailTemplateHandler mailTemplateHandler) {
        this.javaMailSender = javaMailSender;
        this.mailTemplateHandler = mailTemplateHandler;
    }

    @Async
    public void prepareAndSend(Tasks task) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(task.getSender());
            messageHelper.setTo(task.getAssignToEmail());
            messageHelper.setSubject(task.getName());

            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

            GregorianCalendar cal = new GregorianCalendar();
    		cal.setTime(task.getDueDate());
    		cal.add(Calendar.DATE, 7);
            
            String formatDate = formatter.format(cal.getTime());

    		Map<String, Object> model = new HashMap();
    		model.put("assignTo", task.getAssignTo()); 
    		model.put("subject", task.getName());
    		model.put("description", task.getDescription());
    		model.put("dueDate", formatDate); 
    		 
            String content = mailTemplateHandler.generateContent(model);
            messageHelper.setText(content, true);
        };
        try {
            javaMailSender.send(messagePreparator);
        } catch (MailException e) {
            logger.error("Error occured while attempting to send an email",e);
        }
    }
	 
	
	
}
