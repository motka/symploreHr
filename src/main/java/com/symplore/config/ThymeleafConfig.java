package com.symplore.config; 

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;

import java.nio.charset.StandardCharsets;



@Configuration
	public class ThymeleafConfig {

	    @Bean
	    public SpringTemplateEngine springTemplateEngine() {
	        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	        templateEngine.addTemplateResolver(htmlTemplateResolver());
	        return templateEngine;
	    }

//	    @Bean
//	    public SpringResourceTemplateResolver htmlTemplateResolver(){
//	        SpringResourceTemplateResolver emailTemplateResolver = new SpringResourceTemplateResolver();
//	        emailTemplateResolver.setPrefix("classpath:/resources/templates/");
//	        emailTemplateResolver.setSuffix(".html");
//	        emailTemplateResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
//	        return emailTemplateResolver;
//	    }
	    
	    @Bean
	    public ClassLoaderTemplateResolver htmlTemplateResolver() {
	        ClassLoaderTemplateResolver emailTemplateResolver = new ClassLoaderTemplateResolver();
	        emailTemplateResolver.setPrefix("/templates/");
	        emailTemplateResolver.setSuffix(".html");
	        emailTemplateResolver.setTemplateMode(TemplateMode.HTML);
	        emailTemplateResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
	        return emailTemplateResolver;
	    }
	    
	    
	} 