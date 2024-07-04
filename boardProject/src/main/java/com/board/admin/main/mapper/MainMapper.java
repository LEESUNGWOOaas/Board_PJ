package com.board.admin.main.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainMapper {

	List<Map<String, Object>> selectChart1()throws Exception;

	List<Map<String, Object>> selectChart2()throws Exception;
}
