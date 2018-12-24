package com.yuanjun.vo;

import java.util.List;
import java.util.Map;

public class CatalogMap {
	 private Map<String,String> questionInfo ;
	 private List<Catalog> subject;
	public Map<String, String> getQuestionInfo() {
		return questionInfo;
	}
	public void setQuestionInfo(Map<String, String> questionInfo) {
		this.questionInfo = questionInfo;
	}
	public List<Catalog> getSubject() {
		return subject;
	}
	public void setSubject(List<Catalog> subject) {
		this.subject = subject;
	}
	

}
