package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor 
public class UserController {
	private UserService userService;
	
	@GetMapping("register")
	public String register() throws Exception {
		return "/user/register";
	}
	
	@PostMapping("register")
	public String registerProcess(UserDTO userDTO) throws Exception {
		
		userService.joinUser(userDTO);
		
		return "/user/login";
	}

	@GetMapping("login")
	public String login() throws Exception {
		return "/user/login";
	}

	@GetMapping("loginSuccess")
	public String loginSuccess() throws Exception {
		return "/user/loginSuccess"; }
	  
	@GetMapping("logout")
	public String logout() throws Exception {
		return "/user/logout"; }
	 

}
