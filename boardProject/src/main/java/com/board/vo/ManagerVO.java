package com.board.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("managerVO")
@Data
public class ManagerVO {
	
	private int ManagerNo;
	private String ManagerName;
	private String ManagerPassword;
	private String Phone;
	private String email;
}
