package com.go8.admin.config;

import java.io.File;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSWebMvcConfigurer implements WebMvcConfigurer {
	/*
	 * @Override public void addCorsMappings(CorsRegistry registry) {
	 * registry.addMapping("/**")
	 * .allowedOrigins("http://127.0.0.1:8000,http://localhost:8000")
	 * .allowedMethods("POST,GET,OPTIONS,DELETE,PUT") .allowedHeaders(
	 * "Content-Type,ContentType,Access-Token,Access-Control-Allow-Headers,Access-Control-Allow-Origin,Authorization,X-Requested-With")
	 * .allowCredentials(true); }
	 */
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		ApplicationHome h = new ApplicationHome(getClass());
        File jarF = h.getSource();
        String filepath = jarF.getParentFile().toString()+"/images/";
        System.out.println("file:"+filepath);
		registry.addResourceHandler("/images/**").addResourceLocations("file:"+filepath);
	}
}