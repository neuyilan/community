package com.community.framework.utils;

import java.util.Iterator;
import java.util.Map;

/**
 * <p>
 * Title: WASU Platform
 * </p>
 * <p>
 * Description: 分页技术的实现。
 * </p>
 */
// oracle,sqlserver,mysql分页技术
public class Pager {

	private int pageId = 1; // 当前页
	private int rowCount = 0; // 总行数
	private int pageSize = 12; // 页大小
	private int pageCount = 0; // 总页数
	private int pageOffset = 0;// 当前页起始记录
	private int pageTail = 0;// 当前页到达的记录
	private String orderField;//默认排序字段
	private boolean orderDirection;//默认排序方向
	private Map<String, String> orderMap;//多个排序字段
	private String multiOrderStr;//多个字段排序字符串
	
	private String[] extendWhereArray;//扩展的自定义条件数组

	// 页面显示分页按钮个数
	private int length = 12;
	// 开始分页数字
	//private int startIndex = 0;
	// 结束分页数字
	//private int endIndex = 0;

	private int[] indexs;
	
	//private String indexString;

	// int pid = navigate.getPageId() ; //当前页
	// int pcount = navigate.getPageCount(); //总页数
	// int length=8; //共显示几个分页数字
	

	public String getMultiOrderStr() {
		return multiOrderStr;
	}

	public void setMultiOrderStr(String multiOrderStr) {
		this.multiOrderStr = multiOrderStr;
	}

	public String[] getExtendWhereArray() {
		return extendWhereArray;
	}

	public void setExtendWhereArray(String[] extendWhereArray) {
		this.extendWhereArray = extendWhereArray;
	}

	public int[] getIndexs() {
		return indexs;
	}

	public void setIndexs(int[] indexs) {
		this.indexs = indexs;
	}

	public int getLength() {
		return length;
	}

	//public String getIndexString() {
	//	return this.indexString;
	//}

	//public void setIndexString(String indexString) {
	//	this.indexString = indexString;
	//}

	public void setLength(int length) {
		this.length = length;
	}

//	public int[] getIndexs() {
//		int len = getEndIndex() - getStartIndex() + 1;
//		if(!(len<0)){
//			indexs = new int[len];
//		}
//		
//		ArrayList a;
//		for (int i = 0; i < len; i++) {
//			indexs[i] = (getStartIndex() + i);
//		}
//		return indexs;
//	}
//
//	public void setIndexs(int[] indexs) {
//		this.indexs = indexs;
//	}

//	//public int getStartIndex() {
//	//	startIndex = pageId - (length / 2);
//		if (startIndex < 1) {
//			startIndex = 1;
//		}
//		return startIndex;
//	}

//	public void setStartIndex(int startIndex) {
//		this.startIndex = startIndex;
//	}
//
//	public int getEndIndex() {
//		if (getStartIndex() < 1) {
//			setStartIndex(1);
//		}
//		endIndex = (getStartIndex() + length) <= getPageCount() ? (getStartIndex() + length)
//				: getPageCount();
//		return endIndex;
//	}
//
//	public void setEndIndex(int endIndex) {
//		this.endIndex = endIndex;
//	}

	public Pager() {
		this.orderDirection = true;
	}

	public void doPage() {
		// 如果模板==0，且总数大于1，则减一
		//if ((this.rowCount % this.pageSize == 0) && pageCount > 1)
		//	this.pageCount--;

		//如果输入也页面编号（pageId）大于总页数，将pageId设置为pageCount;
		//if(this.pageId > this.pageCount)
		//	this.pageId = this.pageCount;
		//this.pageOffset=(this.pageId-1)*this.pageSize+1;
        //this.pageTail=this.pageOffset+this.pageSize-1;
		//计算分页页号数据
		//getIndexs();
		/*String str = "";
		if(this.indexs != null) {
			for(int i=0;i<indexs.length;i++) {
				str += String.valueOf(indexs[i])+"|";
			}
		}
		if(str.indexOf("|") > -1) {
			str = str.substring(0, str.length()-1);
		}
		this.indexString = str;
		*/
		//计算页面数据展示上下索引号
		if(this.pageSize == 11) {//第一页显示5条，第二页起显示6调
			this.pageCount = (this.rowCount) / (this.pageSize+1) + 1;
			if(this.pageId == 1) {//第一页
				this.pageOffset = (this.pageId - 1) * this.pageSize;
			//	this.pageTail=10;
			}else{
				this.pageSize=this.pageSize+1;
				this.pageOffset = (this.pageId - 1) * this.pageSize-1;
				//this.pageTail=10;
			}
		}else{//每页显示6条或者默认条数
			this.pageCount = (this.rowCount-1) / this.pageSize+1;
			this.pageOffset = (this.pageId - 1) * this.pageSize;
			//this.pageTail=10;
		}
		indexs=new int [pageCount]; 
		for (int i = 1; i <= pageCount; i++) {
			indexs[i-1]=i;
		}
		
		//if ((this.pageOffset + this.pageSize) > this.rowCount)
		//	this.pageTail = this.rowCount;
	}

	public String getOrderCondition() {
		String condition = "";
		if (this.orderField != null && this.orderField.length() != 0) {
			condition = " order by " + orderField
					+ (orderDirection ? " " : " desc ");
		}
		return condition;
	}

	public String getMysqlQueryCondition() {
		String condition = "";
		/*if(this.pageSize == 5) {
			if(this.pageId == 1) {
				condition = " limit " + pageOffset + "," + pageSize;
			}else{
				condition = " limit " + pageOffset + "," + (pageSize + 1);
			}
		}else{*/
			condition = " limit " + pageOffset + "," + pageSize;
		//}
		//condition = " limit " + pageOffset + "," + pageSize;
		return condition;
	}

	public void setOrderDirection(boolean orderDirection) {
		this.orderDirection = orderDirection;
	}

	public boolean isOrderDirection() {
		return orderDirection;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getOrderField() {
		return orderField;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}

	public int getPageOffset() {
		return pageOffset;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageTail(int pageTail) {
		this.pageTail = pageTail;
	}

	public int getPageTail() {
		return pageTail;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
		this.doPage();
	}

	public int getRowCount() {
		return rowCount;
	}

	public Map<String, String> getOrderMap() {
		return orderMap;
	}

	public void setOrderMap(Map<String, String> orderMap) {
		String orderString = "";
		this.orderMap = orderMap;
		Iterator iter = orderMap.entrySet().iterator();
		while (iter.hasNext()) {
	 		Map.Entry entry = (Map.Entry) iter.next(); 
	 		String orderField = (String)entry.getKey();  
	        String orderDirection = (String)entry.getValue();
	        orderString += orderField+" "+orderDirection+",";
		}
		this.multiOrderStr = this.multiOrderStr.substring(0, this.multiOrderStr.length()-1);
	}
}