package com.yuanjun.vo.front;

import java.util.List;

public class Subject {
	
	private   String categoryId ;
	private String categoryTitle;
	private String  sumCount ;
	private String flag ;
	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	private List<Chapter>  chapterList	;
	
	public String getSumCount() {
		return sumCount;
	}
	public void setSumCount(String sumCount) {
		this.sumCount = sumCount;
	}
	public List<Chapter> getChapterList() {
		return chapterList;
	}
	public void setChapterList(List<Chapter> chapterList) {
		this.chapterList = chapterList;
	}
	
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryTitle() {
		return categoryTitle;
	}
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}
	

}
