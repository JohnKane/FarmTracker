package com.farmtracker.uibeans;

import com.farmtracker.util.Util;

public abstract class SearchBean {
	
	private Integer page=0;
	private Long count;
	
	public Integer getPage() {return page;}
	public Long getCount() {return count;}
	
	public void setPage(Integer page) {this.page=page;}
	public void setCount(Long count) {this.count=count;}
	
	public boolean hasNextResults() {
		return (page+1)*Util.MAX_RESULTS<count;
	}
	
	public boolean hasPreviousResults() {
		return page>0;
	}
}
