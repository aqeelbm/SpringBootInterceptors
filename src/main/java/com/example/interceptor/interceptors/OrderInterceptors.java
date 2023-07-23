/**
 * 
 */
package com.example.interceptor.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Aqeel
 *
 */

@Component
public class OrderInterceptors implements HandlerInterceptor {

	Logger logger = LoggerFactory.getLogger(OrderInterceptors.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info(">>> preHandle {}:{}"+request.getRequestURI(),request.getMethod());

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info(">>> afterCompletion {}:{}"+request.getRequestURI(),request.getMethod());
		
		if(ex != null) {
			logger.error(">>> afterCompletion ... "+ex.getMessage());
		}
		
	}

}
