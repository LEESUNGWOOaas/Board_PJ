package com.board.admin.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import com.board.vo.BoardVO;

@Mapper
public interface BoardMapper {
	List<BoardVO> selectBoardList(BoardVO boardVO)throws Exception;
	
	BoardVO selectBoard(BoardVO boardVO)throws Exception;
	
	int insert(BoardVO boardVO)throws Exception;
	
	int update(BoardVO boardVO)throws Exception;
	
	int delete(BoardVO boardVO)throws Exception;

	int selectBoardListCount(BoardVO boardVO)throws Exception;
}
