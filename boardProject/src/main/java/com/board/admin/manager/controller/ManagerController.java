package com.board.admin.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.admin.manager.service.ManagerService;
import com.board.vo.ManagerVO;

@Controller
public class ManagerController {
	@Autowired
	private ManagerService managerSerivce;
	
	@RequestMapping("/admin/manager")
	public String ManagerList(ManagerVO managerVO,Model model) throws Exception {
		List<ManagerVO> managerList = managerSerivce.selectList(managerVO);
		model.addAttribute("managerList",managerList);
		return"/manager/List.admin";
	}
}
