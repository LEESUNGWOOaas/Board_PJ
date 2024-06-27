package com.board.admin.manager.service;

import java.util.List;

import com.board.vo.ManagerVO;

public interface ManagerService {


	ManagerVO selectManager(ManagerVO managerVO)throws Exception;

	List<ManagerVO> selectList(ManagerVO managerVO)throws Exception;

}
