package com.board.vo;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("managerVO")
@Data
public class ManagerVO extends CommonVO{
	
	private int managerNo;
	private String managerId;
	private String managerName;
	private String managerPassword;
	private String Phone;
	private String email;
	private String deleteYn;
	private Timestamp insertDate;
}
