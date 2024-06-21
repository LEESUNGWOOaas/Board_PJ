package com.board.admin.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mainController {
	
	@RequestMapping({"/","/admin"})
	public String index() {
		return "redirect:/admin/index";
	}
	
	@GetMapping("/admin/index")
	public String main() {
		return "redirect:/admin/main/index";
	}
}
