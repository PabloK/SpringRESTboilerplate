package com.realitylabs.event.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SPAController {
	@RequestMapping("/")
	public String showFormLogin() {
		return "index";
	}
}
