package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("main")
	public String main() throws Exception {
		return "/user/main";
	}
	
	@RequestMapping("test")
	public String test() throws Exception {
		return "/test";
	}

}
