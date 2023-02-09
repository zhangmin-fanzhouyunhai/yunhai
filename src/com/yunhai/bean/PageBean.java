package com.yunhai.bean;

import java.util.List;

public class PageBean <T>{

	private List<T> list;		//当前页内容		查询
	private int currentPage;	//当前页码			传递
	private int pageSize;		//每页显示的条数	固定
	private int totalCount;		//总条数			查询
	private int totalPageCount;	//总页数			计算
	public PageBean() {
	}
	
	
	
	
	public PageBean(List<T> list, int currentPage, int pageSize, int totalCount) {
		super();
		this.list = list;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
	}




	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	/**
	 * 获取部页数
	 * @return
	 */
	public int getTotalPageCount() {
		return (int)Math.ceil(totalCount*1.0/pageSize);
	}
	
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	
	
	
	
}
