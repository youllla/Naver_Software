package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("main")
	public String main() throws Exception {
		return "main";
	}

	@RequestMapping("main2")
	public String main2() throws Exception {
		return "main2";
	}

}
