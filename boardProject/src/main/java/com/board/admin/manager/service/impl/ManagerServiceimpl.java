package com.board.admin.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.admin.manager.mapper.ManagerMapper;
import com.board.admin.manager.service.ManagerService;
import com.board.vo.ManagerVO;

@Service
public class ManagerServiceimpl implements ManagerService{
	@Autowired
	private ManagerMapper mapper;
	@Override
	public List<ManagerVO> selectList(ManagerVO managerVO) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectList(managerVO);
	}

}
