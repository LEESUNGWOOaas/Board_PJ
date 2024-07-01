package com.board.vo;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("boardVO")
@Data
public class BoardVO extends CommonVO{
	private String process = "board";
	
	private int boardNo;
	private String title;
	private String content;
	private Timestamp insertDate;
	private String deleteYn;
	private String writer;
	private int readCount;
	private String thumbnail;
}
