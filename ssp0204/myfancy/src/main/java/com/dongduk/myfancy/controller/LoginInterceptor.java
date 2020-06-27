package com.dongduk.myfancy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.dongduk.myfancy.domain.Store;


public class LoginInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		Store store = 
			(Store) WebUtils.getSessionAttribute(request, "storeSession");
		if (store == null) {
			String url = request.getRequestURL().toString(); 
			String query = request.getQueryString();
			ModelAndView modelAndView = new ModelAndView("index");
			if (query != null) {
				modelAndView.addObject("signonForwardAction", url+"?"+query);
			}
			else {
				modelAndView.addObject("signonForwardAction", url);
			}
			throw new ModelAndViewDefiningException(modelAndView);
		}
		else {
			return true;
		}
	}
}
