package com.symplore.onboarding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;

@Service
public class MailTemplateHandler {

    public static final String MESSAGE = "message";
    public static final String MAIL_TEMPLATE = "email_template";

    private TemplateEngine templateEngine;
 
    @Autowired
    public MailTemplateHandler(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String generateContent(Map<String,Object> ctx) {
        Context context = new Context();  
        context.setVariables(ctx);
        return templateEngine.process(MAIL_TEMPLATE, context);
    }
 
}
