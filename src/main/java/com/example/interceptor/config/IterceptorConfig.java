/**
 * 
 */
package com.example.interceptor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.interceptor.interceptors.EmailInterceptor;
import com.example.interceptor.interceptors.OrderInterceptors;

/**
 * @author Aqeel
 *
 */

@Configuration
public class IterceptorConfig implements WebMvcConfigurer {

	@Autowired
	private OrderInterceptors orderInterceptors;
	
	@Autowired
	private EmailInterceptor emailInterceptor; 

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(orderInterceptors);
		registry.addInterceptor(emailInterceptor);
	} 
	
}