package com.yuanjun.comm;

import java.util.List;

import com.yuanjun.bean.SsmQuestionChapter;
import com.yuanjun.vo.QuestionInfo;

public class ChapterListMessage extends Message {
	private Integer currPage ;
	private Integer sumPage;
	List<QuestionInfo> data;
	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public Integer getSumPage() {
		return sumPage;
	}
	public void setSumPage(Integer sumPage) {
		this.sumPage = sumPage;
	}
	public List<QuestionInfo> getData() {
		return data;
	}
	public void setData(List<QuestionInfo> data) {
		this.data = data;
	} 
	
	
	
	
	
	

}
