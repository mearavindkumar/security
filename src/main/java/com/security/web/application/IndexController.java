package com.security.web.application;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping(value = { "/", "/index" })
	public String index() {
		return "index";
	}

	@GetMapping("/sign")
	@PreAuthorize("hasRole('USER')")
	public String sign() {
		return "status";
	}
}
