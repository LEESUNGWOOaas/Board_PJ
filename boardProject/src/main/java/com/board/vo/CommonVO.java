package com.board.vo;

import lombok.Data;

@Data
public class CommonVO {

	private int page = 1;
	private int listSize = 10;
	private int blockSize = 10;
	private boolean isPaging = true;
	
	private String searchType;
	private String searchKeyword;
	
	private String orderBy;
	
	private PageVO pageVO;
	
}
