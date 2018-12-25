package com.yuanjun.vo.frontStudy;

import java.util.List;

public class QuestionStudyModel {
	
	private String  userid ;
  private String	categorypid ;
  private String   categoryid ;
  private String kind ;
  private String status ;
  
  
  public String getKind() {
	return kind;
}
public void setKind(String kind) {
	this.kind = kind;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
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
