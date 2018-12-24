package com.yuanjun.vo;

import java.util.List;

public class QuestionVo {
	  
	  //title 标题 string
	  private String title ;
	 // correctanswer 正确答案 string
	  private String correctanswer ;
	  //  category_pid 顶级分类id
	  private String  category_pid ;
	  // category_id 科目分类id
	  private String category_id ;
	  //  chapter_id 章节id
	  private String  chapter_id ;	 
	 
	  //  type  1单选题2多选题3判断题
	  private String type ;
	  //  kind 1免费 2付费
	  private String kind ;
	  //  fraction 试题分值
	  private String fraction ;
	  // analysis 试题解析
	  private String  analysis ;
	  // brief 试题描述
	  private String brief ;	  
	  //  status试题状态 1有效，2无效
	  private String status ;
	  private String sort_no;
	  
	  
	  public String getSort_no() {
		return sort_no;
	}
	public void setSort_no(String sort_no) {
		this.sort_no = sort_no;
	}
	private  List<Option> optionList ;
	  
	  
	public List<Option> getOptionList() {
		return optionList;
	}
	public void setOptionList(List<Option> optionList) {
		this.optionList = optionList;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCorrectanswer() {
		return correctanswer;
	}
	public void setCorrectanswer(String correctanswer) {
		this.correctanswer = correctanswer;
	}
	public String getCategory_pid() {
		return category_pid;
	}
	public void setCategory_pid(String category_pid) {
		this.category_pid = category_pid;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public String getChapter_id() {
		return chapter_id;
	}
	public void setChapter_id(String chapter_id) {
		this.chapter_id = chapter_id;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getFraction() {
		return fraction;
	}
	public void setFraction(String fraction) {
		this.fraction = fraction;
	}
	public String getAnalysis() {
		return analysis;
	}
	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	  
	  
	  
	  
	
	
	
	
	
	
	

}
