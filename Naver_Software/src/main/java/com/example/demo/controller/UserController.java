package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@RequestMapping("login")
	public String login() throws Exception {
		return "/user/login";
	}

	@RequestMapping("register")
	public String register() throws Exception {
		return "/user/register";
	}
	
	@RequestMapping("index")
	public String index() throws Exception {
		return "/user/index";
	}


}
