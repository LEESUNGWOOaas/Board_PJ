package com.board.admin.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.admin.manager.service.ManagerService;
import com.board.vo.ManagerVO;
import com.board.vo.PageVO;

@Controller
public class ManagerController {
	@Autowired
	private ManagerService managerSerivce;
	
	@RequestMapping("/admin/manager")
	public String ManagerList(ManagerVO managerVO,Model model) throws Exception {
		List<ManagerVO> managerList = managerSerivce.selectList(managerVO);
		System.out.println("리스트 : "+managerList);
		model.addAttribute("managerList",managerList);
		model.addAttribute("pageVO",managerVO.getPageVO());
		return"/manager/List.admin";
	}
	
	@RequestMapping("/admin/manager/{managerNo}")
	public String ManagerDetail(ManagerVO managerVO,Model model)throws Exception {
		ManagerVO manager =  managerSerivce.selectManager(managerVO);
		model.addAttribute("manager",manager);
		return "/manager/View.admin";
		
	}
	
	@RequestMapping("/admin/manager/form")
	public String ManagerForm(ManagerVO managerVO,Model model) throws Exception{
		ManagerVO manager =  managerSerivce.selectManager(managerVO);
		model.addAttribute("manager",manager);
		return "/manager/Form.admin";
	}
	

}
