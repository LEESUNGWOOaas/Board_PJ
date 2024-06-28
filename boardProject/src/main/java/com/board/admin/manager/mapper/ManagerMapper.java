package com.board.admin.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import com.board.vo.ManagerVO;

@Mapper
public interface ManagerMapper {

	List<ManagerVO> selectList(ManagerVO managerVO)throws Exception;
	
	ManagerVO selectManager(ManagerVO managerVO)throws Exception;

	int selectListCount(ManagerVO managerVO)throws Exception;
	
	int insert(ManagerVO managerVO)throws Exception; 
	
	int update(ManagerVO managerVO)throws Exception;
	
	int delete(ManagerVO managerVO)throws Exception; 
	
	ManagerVO selectManagerById(String managerId)throws Exception;
}
