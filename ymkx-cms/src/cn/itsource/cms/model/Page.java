package cn.itsource.cms.model;

import java.util.List;

/**
 * 分页信息
 * @author st
 *
 */
public class Page {
	// 当前第几页
	private int pageNo;
	// 总页数
	private int totalPage;
	// 总条数
	private int pageCount;
	// 新闻集合
	private List<News> list;
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public List<News> getList() {
		return list;
	}
	public void setList(List<News> list) {
		this.list = list;
	}
	
}
