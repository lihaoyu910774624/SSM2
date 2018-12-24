package com.yuanjun.vo;

import java.util.Date;
import java.util.List;

public class QuestionInfo {
	
    private String chapterId;    
    private String categoryId ;
    private String category ;
    private String categoryPId ;
    private String categoryTitle ;
    private String title ;
    private Integer sortNo ;
    private String addTime ;
    private List<Catalog> catalogList;
    
	
	
	public List<Catalog> getCatalogList() {
		return catalogList;
	}
	public void setCatalogList(List<Catalog> catalogList) {
		this.catalogList = catalogList;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public String getChapterId() {
		return chapterId;
	}
	public void setChapterId(String chapterId) {
		this.chapterId = chapterId;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategoryPId() {
		return categoryPId;
	}
	public void setCategoryPId(String categoryPId) {
		this.categoryPId = categoryPId;
	}
	public String getCategoryTitle() {
		return categoryTitle;
	}
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getSortNo() {
		return sortNo;
	}
	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}
	
    
    
	
	
	

}
