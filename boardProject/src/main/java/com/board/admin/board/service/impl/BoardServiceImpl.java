package com.board.admin.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.board.admin.board.mapper.BoardMapper;
import com.board.admin.board.service.BoardService;
import com.board.common.file.service.FileService;
import com.board.vo.BoardVO;
import com.board.vo.FileVO;
import com.board.vo.PageVO;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardMapper mapper;
	@Autowired
	FileService fileService;
	
	@Override
	public List<BoardVO> selectBoardList(BoardVO boardVO) throws Exception {
		if(boardVO.isPaging()) boardVO.setPageVO(new PageVO(boardVO.getBlockSize(), boardVO.getListSize(), boardVO.getPage(), mapper.selectBoardListCount(boardVO)));
		return mapper.selectBoardList(boardVO);
	}
	@Override
	public BoardVO selectBoard(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectBoard(boardVO);
	}
	@Override
	public int insert(BoardVO boardVO,MultipartHttpServletRequest multi) throws Exception {
		int result = 0;
		
		MultipartFile file = multi.getFile("file");
		
		if(boardVO.getBoardNo()==0) {
			result = mapper.insert(boardVO);
			
		}else {
			result = mapper.update(boardVO);
		}
		if(result > 0) {
			FileVO fileVO= fileService.saveFile(file, boardVO.getProcess(), boardVO.getBoardNo(),"file");
			if(fileVO!=null) {
				 fileVO.setExceptNo(fileVO.getFileNo()); 
				 fileService.deleteOldFile(fileVO);
				 System.out.println("notice : "+ fileVO.getFileNo());
			}
		}
		
		return result;
	}
	@Override
	public int delete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return mapper.delete(boardVO);
	}

}
