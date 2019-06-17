package com.example.demo;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new PersonFormatter());
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new GreetingInterceptor());
		registry.addInterceptor(new AnotherInterceptor());
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/mobile/**")
				.addResourceLocations("classpath:/mobile/")
				.setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES ));
	}
	
	

	
	
	
}
