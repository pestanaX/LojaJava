package com.artcomsoft.sistemaloja.configuracao;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages= {"com.artcomsoft.sistemaloja"})
public class WebMvcConfig  implements WebMvcConfigurer {
	
	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;

	}
   @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    
	   String caminhoActual = System.getProperty("user.dir");		
	    registry.addResourceHandler("/imagem2/**")
	      .addResourceLocations("file:"+caminhoActual+"/imagem2/");
	 }
	
	@Bean
	public MessageSource messageSource(){
		ReloadableResourceBundleMessageSource bundle =	new ReloadableResourceBundleMessageSource();
		bundle.setBasename("/WEB-INF/messages");
		bundle.setDefaultEncoding("UTF-8");
		bundle.setCacheSeconds(1);
		return bundle;
	}
	
	@Bean
	public MultipartResolver multipartResolver(){
		  return new StandardServletMultipartResolver();	
	}
	
}
