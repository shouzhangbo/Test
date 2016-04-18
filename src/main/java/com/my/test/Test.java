package com.my.test;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test {

	@RequestMapping(value="/test")
	public String Test(){
		return "";
	}
	@RequestMapping(value="/testt")
	@ResponseBody
	public Object Testt(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("12", "213123");
		return map;
	}
}
