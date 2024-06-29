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
	private String phone;
	private String email;
	private String deleteYn;
	private Timestamp insertDate;
	
	private String salt; //비밀번호 해쉬값
}
