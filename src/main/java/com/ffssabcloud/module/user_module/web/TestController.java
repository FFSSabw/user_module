package com.ffssabcloud.module.user_module.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffssabcloud.module.user_module.exception.JSONException;

@Controller
@RequestMapping(value="/test")
public class TestController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		System.out.println("get");
		return "index";
	}
	
	@RequestMapping(value="/throw_excpetion", method=RequestMethod.GET)
	public String throwException() throws Exception {
		System.out.println("get");
		throw new Exception("一个普通的Exception");
	}
	
	@RequestMapping(value="/throw_json_exception", method=RequestMethod.GET)
	@ResponseBody
	public String throwJsonException() throws JSONException {
		System.out.println("get");
		throw new JSONException("一个JSON的Exception");
	}
}
