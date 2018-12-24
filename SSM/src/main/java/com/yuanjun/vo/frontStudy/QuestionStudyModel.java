package com.yuanjun.vo.frontStudy;

import java.util.List;

public class QuestionStudyModel {
	
	private String  userid ;
  private String	categorypid ;
  private String   categoryid ;
  private List<AnserDto> anserList ;
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getCategorypid() {
	return categorypid;
}
public void setCategorypid(String categorypid) {
	this.categorypid = categorypid;
}
public String getCategoryid() {
	return categoryid;
}
public void setCategoryid(String categoryid) {
	this.categoryid = categoryid;
}
public List<AnserDto> getAnserList() {
	return anserList;
}
public void setAnserList(List<AnserDto> anserList) {
	this.anserList = anserList;
}
  
  

}
