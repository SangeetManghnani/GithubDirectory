package com.lovejeet.spring.controller;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
public class RestController {
	
	@RequestMapping("/hello")
	public String restMethod() {
		JSONObject object = new JSONObject();
		object.put("key", "value");
		return object.toString();
		
	}

}
