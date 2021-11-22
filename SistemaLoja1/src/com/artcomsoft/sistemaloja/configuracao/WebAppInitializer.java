package com.artcomsoft.sistemaloja.configuracao;



import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

public class WebAppInitializer implements WebApplicationInitializer {

	private String TMP_FOLDER = "/tmp";
	private int MAX_UPLOAD_SIZE = 5 *1024* 1024;

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(WebMvcConfig.class);
		appContext.setServletContext(servletContext);

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
				"SpringDispatcher", new DispatcherServlet(appContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(TMP_FOLDER,
				MAX_UPLOAD_SIZE, MAX_UPLOAD_SIZE *2, MAX_UPLOAD_SIZE/2);

		dispatcher.setMultipartConfig(multipartConfigElement);

	}
	
	
}

