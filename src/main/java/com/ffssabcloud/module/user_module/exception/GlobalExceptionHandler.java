package com.ffssabcloud.module.user_module.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ffssabcloud.module.user_module.domain.JSONBean;
import com.ffssabcloud.module.user_module.exception.JSONException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static String DEFAULT_ERROR_VIEW = "error";
	
	@ExceptionHandler(value=JSONException.class)
	@ResponseBody
	public JSONBean<String> jsonErrorHandler(HttpServletRequest request, Exception e)
		throws Exception {
		JSONBean<String> jb = new JSONBean<String>();
		jb.setCode(JSONBean.ERROR);
		jb.setData(e.getLocalizedMessage());
		jb.setMessage(e.getMessage());
		
		return jb;
	}
	
	@ExceptionHandler(value=Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e)
		throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", request.getRemoteAddr());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		
		return mav;
	}
}
