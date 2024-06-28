package com.board.admin.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.board.admin.manager.mapper.ManagerMapper;
import com.board.admin.manager.service.ManagerService;
import com.board.vo.ManagerVO;
import com.board.vo.PageVO;

@Service
public class ManagerServiceimpl implements ManagerService{
	@Autowired
	ManagerMapper mapper;
	

	@Override
	public ManagerVO selectManager(ManagerVO managerVO) throws Exception {
		
		return mapper.selectManager(managerVO);
	}


	@Override
	public List<ManagerVO> selectList(ManagerVO managerVO) throws Exception {
		if(managerVO.isPaging()) managerVO.setPageVO(new PageVO(managerVO.getBlockSize(), managerVO.getListSize(), managerVO.getPage(), mapper.selectListCount(managerVO)));
		return mapper.selectList(managerVO);
	}


	@Override
	public int insert(ManagerVO managerVO) throws Exception {
		int result = 0;
		if(managerVO.getManagerNo() == 0) {
			result = mapper.insert(managerVO);
		}else {
			result = mapper.update(managerVO);
					
		}
		return result;
	}


	@Override
	public int delete(ManagerVO managerVO) throws Exception {
		// TODO Auto-generated method stub
		return mapper.delete(managerVO);
	}


	@Override
	public ManagerVO selectManagerById(String managerId) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectManagerById(managerId);
	}

}
