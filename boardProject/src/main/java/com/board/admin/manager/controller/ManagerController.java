package com.board.admin.manager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.board.admin.manager.service.ManagerService;
import com.board.vo.ManagerVO;


@Controller
public class ManagerController {
	@Autowired
	private ManagerService managerSerivce;
	
	@RequestMapping("/admin/manager")
	public String ManagerList(ManagerVO managerVO,Model model) throws Exception {
		List<ManagerVO> managerList = managerSerivce.selectList(managerVO);
		System.out.println("리스트 : "+managerList);
		System.out.println("PageVO : "+managerVO.getPageVO());
		System.out.println("전체 레코드 : "+managerVO.getPageVO().getTotPage());
		
		
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
	@ResponseBody
	@RequestMapping("/admin/manager/save")
	public Map<String, Object> save(Model model,ManagerVO managerVO)throws Exception{
		Map<String, Object>resultMap = new HashMap<String, Object>();
		int result = managerSerivce.insert(managerVO);
		if(result > 0) {
			resultMap.put("result",true);
			resultMap.put("msg","등록되었습니다");
		}else{
			resultMap.put("result",false);
			resultMap.put("msg","Error!");		
		}
		return resultMap;
	}
	
	
	@ResponseBody
	@RequestMapping("/admin/manager/delete")
	public Map<String, Object> delete(Model model,ManagerVO managerVO)throws Exception{
		Map<String, Object>resultMap = new HashMap<String, Object>();
		int result = managerSerivce.delete(managerVO);
		if(result > 0) {
			resultMap.put("result",true);
			resultMap.put("msg","삭제되었습니다");
		}else{
			resultMap.put("result",false);
			resultMap.put("msg","Error!");		
		}
		return resultMap;
	}
	
}

