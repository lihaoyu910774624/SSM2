package com.yuanjun.vo.frontStudy;

import java.util.List;

import com.yuanjun.vo.FrontQuestion.TrainingQuestion;

public class StudyInfoListMessage {
	
	private String code ;
	private String msg ;
	private String currPage ;
	private String sumPage;
    private List<StudyQuestion> data ;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getCurrPage() {
		return currPage;
	}
	public void setCurrPage(String currPage) {
		this.currPage = currPage;
	}
	public String getSumPage() {
		return sumPage;
	}
	public void setSumPage(String sumPage) {
		this.sumPage = sumPage;
	}
	public List<StudyQuestion> getData() {
		return data;
	}
	public void setData(List<StudyQuestion> data) {
		this.data = data;
	}
	
	

	
	

}
