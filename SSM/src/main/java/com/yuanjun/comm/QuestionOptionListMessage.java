package com.yuanjun.comm;

import java.util.List;

import com.yuanjun.bean.SsmQuestionOption;

public class QuestionOptionListMessage {
	
	private String code ;
	private String msg ;
	private Integer currPage ;
	private Integer sumPage;
	List<SsmQuestionOption> data ;
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
	public List<SsmQuestionOption> getData() {
		return data;
	}
	public void setData(List<SsmQuestionOption> data) {
		this.data = data;
	}
	

}
