package com.examportal.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		registry.addViewController("/403").setViewName("403");
	}
// 
//	 @Bean
//	    public ITemplateResolver thymeleafTemplateResolver() {
//	 
//	        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
//	        templateResolver.setPrefix("templates/"); 
//	        templateResolver.setSuffix(".html");
//	        templateResolver.setCharacterEncoding("UTF-8");
//	 
//	        return templateResolver;
//	    }
//	 @Bean
//	    public ViewResolver jspViewResolver() {
//	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//	         
//	        viewResolver.setViewClass(JstlView.class);
//	        viewResolver.setPrefix("/WEB-INF/");
//	        viewResolver.setSuffix(".jsp");
//	        viewResolver.setContentType("text/html");
//	         
//	        // Make sure > Thymeleaf order & FreeMarker order.
//	        viewResolver.setOrder(1000);
//	         
//	        return viewResolver;
//	    }
	 @Value("${spring.mvc.view.prefix}")
	    private String prefix;

	    @Value("${spring.mvc.view.suffix}")
	    private String suffix;

//	    @Value("${spring.mvc.view.view-names}")
//	    private String viewNames;

	    @Bean
	    InternalResourceViewResolver jspViewResolver() {
	        final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setPrefix(prefix);
	        viewResolver.setSuffix(suffix);
	        viewResolver.setViewClass(JstlView.class);
//	        viewResolver.setViewNames(viewNames);
	        return viewResolver;
	    }
	    @Bean
	    public ViewResolver getViewResolver() {
	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	        resolver.setPrefix("templates/");
	        resolver.setSuffix(".html");
	        return resolver;
	    }
	 

	
}
