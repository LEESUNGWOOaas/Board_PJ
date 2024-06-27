package com.board.admin.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.admin.manager.mapper.ManagerMapper;
import com.board.admin.manager.service.ManagerService;
import com.board.vo.ManagerVO;
import com.board.vo.PageVO;

@Service
public class ManagerServiceimpl implements ManagerService{
	@Autowired
	private ManagerMapper mapper;
	

	@Override
	public ManagerVO selectManager(ManagerVO managerVO) throws Exception {
		if(managerVO.isPaging()) managerVO.setPageVO(new PageVO(managerVO.getBlockSize(), managerVO.getListSize(), managerVO.getPage(), mapper.selectListCount(managerVO)));
		return mapper.selectManager(managerVO);
	}


	@Override
	public List<ManagerVO> selectList(ManagerVO managerVO) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectList(managerVO);
	}

}
