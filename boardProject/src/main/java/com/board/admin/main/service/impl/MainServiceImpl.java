package com.board.admin.main.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.admin.main.mapper.MainMapper;
import com.board.admin.main.service.MainService;

@Service
public class MainServiceImpl implements MainService{
	@Autowired
	MainMapper mapper;
	
	@Override
	public List<Map<String, Object>> selectChart1() throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectChart1();
	}

	@Override
	public List<Map<String, Object>> selectChart2() throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectChart2();
	}
	
}
