package com.realitylabs.event.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

	@RequestMapping("/login")
	public String showFormLogin(ModelMap model) {
		return "auth/login";
	}
	
}
