package com.techniecode.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import nz.net.ultraq.thymeleaf.LayoutDialect;

	@Configuration
	public class MvcConfig extends WebMvcConfigurationSupport {

		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			// registry.addViewController("/").setViewName("dashboard");
			registry.addViewController("/").setViewName("pages/loan/loanindex");
			registry.addViewController("/newloan").setViewName("pages/loan/loanapplication");
			registry.addViewController("/saveBasicInfo").setViewName("pages/loan/loanapplication");
		//	registry.addViewController("/login").setViewName("pages/loginpage");
		}

		@Override
		
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//	System.out.println("************************addResourceHandlers***********************");
		// registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
		 registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
		 
		}
	 
	@Override
	protected void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		// TODO Auto-generated method stub
		super.extendHandlerExceptionResolvers(exceptionResolvers);
	}
		@Override
		public void configureViewResolvers(ViewResolverRegistry registry) {
			ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
			viewResolver.setTemplateEngine(templateEngine());
			viewResolver.setCharacterEncoding("UTF-8");
			registry.viewResolver(viewResolver);
		}
		  

		@Bean
		public SpringTemplateEngine templateEngine() {
			SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		 	templateEngine.setTemplateResolver(templateResolver());
			templateEngine.addDialect(new LayoutDialect());
			return templateEngine;
		}

		@Bean
		public ClassLoaderTemplateResolver templateResolver() {
			ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
			templateResolver.setPrefix("templates/");
			templateResolver.setSuffix(".html");
			templateResolver.setTemplateMode(TemplateMode.HTML);
			templateResolver.setForceSuffix(true);
			templateResolver.setCacheable(false);
			return templateResolver;
		}
}
