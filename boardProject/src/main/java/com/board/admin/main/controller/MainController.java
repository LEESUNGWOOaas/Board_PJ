package com.board.admin.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.admin.main.service.MainService;

@Controller
public class MainController {
	@Autowired
	private MainService MainService;
	
	
	@RequestMapping({"/","/admin"})
	public String index() {
		return "redirect:/admin/index";
	}
	
	@GetMapping("/admin/index")
	public String main() {
		
		
		return "/main/index.admin";
	}
	
}
