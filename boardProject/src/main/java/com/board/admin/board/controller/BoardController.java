package com.board.admin.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.board.admin.board.service.BoardService;
import com.board.vo.BoardVO;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/admin/board")
	public String BoardList(Model model,BoardVO boardVO) throws Exception{
		List<BoardVO> list = boardService.selectBoardList(boardVO);
		model.addAttribute("list",list);
		model.addAttribute("pageVO",boardVO.getPageVO());
		return "/board/List.admin";
	}
	@RequestMapping("/admin/board/{boardNo}")
	public String BoardView(Model model,BoardVO boardVO) throws Exception{
		BoardVO board = boardService.selectBoard(boardVO);
		model.addAttribute("board",board);
		return "/board/View.admin";
	}
	@RequestMapping("/admin/board/form")
	public String boardForm(Model model,BoardVO boardVO)throws Exception {
		BoardVO board = boardService.selectBoard(boardVO);
		model.addAttribute("board",board);
		return "/board/Form.admin";
	}
	
	@ResponseBody
	@RequestMapping("/admin/board/save")
	public Map<String, Object> insert(Model model,BoardVO boardVO,MultipartHttpServletRequest multi)throws Exception{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int result = boardService.insert(boardVO,multi);
		
		if(result > 0) {
			resultMap.put("result",true);
			resultMap.put("msg","등록되었습니다.");
		}else {
			resultMap.put("result",false);
			resultMap.put("msg","오류가 발생 했습니다.");
		}
		return resultMap;
	}
	
	@ResponseBody
	@RequestMapping("/admin/board/delete")
	public Map<String, Object> delete(Model model,BoardVO boardVO)throws Exception{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int result = boardService.delete(boardVO);
		
		if(result > 0) {
			resultMap.put("result",true);
			resultMap.put("msg","등록되었습니다.");
		}else {
			resultMap.put("result",false);
			resultMap.put("msg","오류가 발생 했습니다.");
		}
		return resultMap;
	}
	
}
