package com.board.admin.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.vo.ManagerVO;

@Mapper
public interface ManagerMapper {

	List<ManagerVO> selectList(ManagerVO managerVO) throws Exception;
}
