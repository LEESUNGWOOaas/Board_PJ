package com.board.admin.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.board.admin.interceptor.AdminInterceptor;

@SuppressWarnings("deprecation")
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter{

	
	  @Override 
	  public void addInterceptors(InterceptorRegistry registry) {
	  registry.addInterceptor(new AdminInterceptor())
	  .excludePathPatterns("/admin/login") 
	  .addPathPatterns("/admin/**");
	  
	  }
	 
	 
}
