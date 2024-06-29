package com.board.admin.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.board.admin.board.mapper.BoardMapper;
import com.board.admin.board.service.BoardService;
import com.board.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardMapper mapper;
	@Override
	public List<BoardVO> selectBoardList(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectBoardList(boardVO);
	}
	@Override
	public BoardVO selectBoard(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectBoard(boardVO);
	}
	@Override
	public int insert(BoardVO boardVO) throws Exception {
		int result = 0;
		
		if(boardVO.getBoardNo()==0) {
			result = mapper.insert(boardVO);
			
		}else {
			result = mapper.update(boardVO);
		}
		
		return result;
	}
	@Override
	public int delete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return mapper.delete(boardVO);
	}

}
