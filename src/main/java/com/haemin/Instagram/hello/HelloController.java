package com.haemin.Instagram.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@ResponseBody
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello World!!";
	}
	
	@GetMapping("/hello/hello")
	public String helloThymeleaf() {
		return "hello/hello";
	}

}
