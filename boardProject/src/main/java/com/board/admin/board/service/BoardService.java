package com.board.admin.board.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.board.vo.BoardVO;

public interface BoardService {

	List<BoardVO> selectBoardList(BoardVO boardVO)throws Exception;

	BoardVO selectBoard(BoardVO boardVO)throws Exception;

	int insert(BoardVO boardVO)throws Exception;

	int delete(BoardVO boardVO)throws Exception;

}
