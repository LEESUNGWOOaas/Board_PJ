package com.board.admin.manager.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.board.vo.ManagerVO;

public interface ManagerService {


	ManagerVO selectManager(ManagerVO managerVO)throws Exception;

	List<ManagerVO> selectList(ManagerVO managerVO)throws Exception;

	int insert(ManagerVO managerVO)throws Exception;

	int delete(ManagerVO managerVO)throws Exception;

	ManagerVO selectManagerById(String managerId)throws Exception; 

}
