package com.board.admin.main.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.admin.main.service.MainService;
import com.board.vo.MainVO;

@Controller
public class MainController {
	@Autowired
	private MainService mainService;
	
	
	@RequestMapping({"/","/admin"})
	public String index() {
		
		return "redirect:/admin/index";
	}
	
	@GetMapping("/admin/index")
	public String main(Model model,MainVO mainVO) throws Exception{
		
		List<Map<String, Object>> chart1 = mainService.selectChart1();
		model.addAttribute("chart1",chart1);
		
		List<Map<String, Object>> chart2 = mainService.selectChart2();
		model.addAttribute("chart2",chart2);
		return "/main/index.admin";
	}
	
}
