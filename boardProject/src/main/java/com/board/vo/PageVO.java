package com.board.vo;

public class PageVO {

	
	// 페이징 처리와 관계된 변수들-------------------------------------
	
	private int totSize = 0; // 선택된 레코드의 전체 건수
	private int listSize = 10; // 페이지당 표시될 행수
	private int totPage = 0; // 전체 페이지 수
	private int blockSize = 10; // 블럭의 크기
	private int totBlock = 0; // 전체 블럭 수
	private int startPage = 0; // 블럭에 표시될 시작페이지
	private int endPage = 0; // 블럭에 표시될 끝페이지
	private int nowBlock = 0; // 현재 표시되고 있는 블럭
	private int page = 1; // 현재 표시되고 있는 페이지
	private int startNo = 0; // 표시될 리스트의 시작
	private int endNo = 0; // 표시될 리스트의 끝
	
	private int rownum = 0; //rownum
	
	// ----------------------------------------------------------------
	
	public PageVO() {
		
	}
	
	public PageVO(int totalRecord) {
		this.totSize = totalRecord;
		
		calculate();
	}
	
	public PageVO(int listSize, int page, int totalRecord) {
		if(page<1) page=1;
		this.listSize=listSize;
		this.page=page;
		this.totSize = totalRecord;
		
		calculate();
	}
	
	public PageVO(int blockSize, int listSize, int page, int totalRecord) {
		if(page<1) page=1;
		this.blockSize = blockSize;
		this.listSize=listSize;
		this.page=page;
		this.totSize = totalRecord;
		
		calculate();
	}
	
	public void calculate() {
		totPage = (int) Math.ceil(totSize / (double) listSize);
		totBlock = (int) Math.ceil(totPage / (double) blockSize);
		nowBlock = (int) Math.ceil(page / (double) blockSize);
		endPage = nowBlock * blockSize;
		startPage = endPage - blockSize + 1;
		endNo = page * listSize;
		startNo = endNo - listSize;
		if (endPage > totPage) endPage = totPage;
		if (endNo > totSize) endNo = totSize;
		
		rownum = totSize - listSize*(page-1);
	}

	public int getTotSize() {
		return totSize;
	}

	public void setTotSize(int totSize) {
		this.totSize = totSize;
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public int getTotPage() {
		return totPage;
	}

	public void setTotPage(int totPage) {
		this.totPage = totPage;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

	public int getTotBlock() {
		return totBlock;
	}

	public void setTotBlock(int totBlock) {
		this.totBlock = totBlock;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getNowBlock() {
		return nowBlock;
	}

	public void setNowBlock(int nowBlock) {
		this.nowBlock = nowBlock;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getStartNo() {
		return startNo;
	}

	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}

	public int getEndNo() {
		return endNo;
	}

	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	
	//----------------------------------------------------------------
	
}
