package com.farmtracker.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.farmtracker.model.User;

public class LoginInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		// Avoid a redirect loop for some urls
		if( !request.getRequestURI().contains("login")){
			User userData = (User) request.getSession().getAttribute("LOGGEDIN_USER");
				if(userData == null){
				    response.sendRedirect("login");
				    return false;
				}   
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {}

	@Override
 	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)throws Exception {}

}
