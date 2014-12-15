package com.community.app.module.vo;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.community.framework.utils.Pager;

public class BaseBean {

	private Integer page = 1;	// 当前页
	private Integer rows = 11;   //当前页行数
	private Integer count = 0; // 总行数
	private List list;
	private String sort;
	private String order;
	private String orderField;//默认排序字段
	
	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
	
	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	/**
	 * 分页导航
	 */
	private Pager pager = new Pager();
	
	public Pager getPager() {
		pager.setPageId(getPage());
		pager.setPageSize(getRows());
		pager.setRowCount(getCount());
		if(StringUtils.isNotBlank(sort)){
			pager.setOrderField(getSort());
		}
		boolean isAsc = true;
		if(StringUtils.isNotBlank(order)){
			if(!"asc".equals(order)) {
				isAsc = false;
			}
		}
		pager.setOrderDirection(isAsc);
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}
	
	
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
}