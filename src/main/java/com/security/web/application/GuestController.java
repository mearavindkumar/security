package com.security.web.application;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuestController {

	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}
	
	

}
