package com.board.admin.login;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.admin.manager.service.ManagerService;
import com.board.common.SHA256Util;
import com.board.common.SessionUtil;
import com.board.vo.ManagerVO;

@Controller
public class LoginController {
	@Autowired
	ManagerService managerService;	
	
	@RequestMapping("/admin/login")
	public String login() throws Exception{
		if(SessionUtil.isLogin())return "redirect:/admin/index";
			return "/admin/login/login";
	}
	
	@RequestMapping("/admin/logout")
	public String Logout() {
		if(SessionUtil.isLogin())
			SessionUtil.removeUser();
		return "redirect:/admin/login";
	}
	
	@ResponseBody
	@RequestMapping(value="/admin/logon",method =RequestMethod.POST)
	public Map<String, Object>loginCheck(Model model,ManagerVO infoVO)throws Exception{
		Map<String, Object>resultMap = new HashMap<String, Object>();
		
		ManagerVO managerVO = managerService.selectManagerById(infoVO.getManagerId());
		if(managerVO==null||
		   !managerVO.getDeleteYn().equals("N")||
		   !SHA256Util.getEncrypt(infoVO.getManagerPassword(),managerVO.getSalt()).equals(managerVO.getManagerPassword())){
					
			System.out.println("id : "+managerVO.getManagerId());
			resultMap.put("result",false);
			resultMap.put("msg","잘못된 정보입니다.");
			
			}else {
				SessionUtil.setUser(managerVO);
				System.out.println("로그인 성공!!");
				
				resultMap.put("result",true);
				resultMap.put("redirectUrl","/admin/index");
			}
		return resultMap;
	}
}
