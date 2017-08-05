package com.farmtracker.uibeans;

public class EventSearch{
	
	public static enum SearchType{
		ACTION(0,"Action"),
		NAME(1,"Name"),
		ID(2,"Id");
		
		private final int key;
		private final String value;
		
		SearchType(int key,String value){
			this.key=key;
			this.value=value;
		}
		
		public Integer getKey() {return key;}
		public String getValue() {return value;}
	}
	
	private Integer searchType;
	private String searchValue;
	
	public Integer getSearchType() {return searchType;}
	public String getSearchValue() {return searchValue;}
	
	public void setSearchType(Integer searchType) {this.searchType=searchType;}
	public void setSearchValue(String searchValue) {this.searchValue=searchValue;}

}
