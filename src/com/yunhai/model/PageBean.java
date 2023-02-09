package com.yunhai.model;

public class PageBean {
	private int page; // 第几页
	private int rows; // 每页的记录数
	private int start; // 起始页
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}

}
