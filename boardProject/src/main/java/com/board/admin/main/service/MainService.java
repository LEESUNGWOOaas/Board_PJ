package com.board.admin.main.service;

import java.util.List;
import java.util.Map;

public interface MainService {

	List<Map<String, Object>> selectChart1()throws Exception;

	List<Map<String, Object>> selectChart2()throws Exception;
}
