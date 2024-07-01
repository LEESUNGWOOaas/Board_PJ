package com.board.admin.board.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.board.vo.BoardVO;

public interface BoardService {

	List<BoardVO> selectBoardList(BoardVO boardVO)throws Exception;

	BoardVO selectBoard(BoardVO boardVO)throws Exception;

	int insert(BoardVO boardVO, MultipartHttpServletRequest multi)throws Exception;

	int delete(BoardVO boardVO)throws Exception;

}
