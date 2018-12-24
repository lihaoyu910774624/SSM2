package com.yuanjun.comm;

import java.util.List;

import com.yuanjun.vo.QuestionVo;

public class QuestionPageListMessage {
	
	private String code ;
	private String msg ;
	private String currPage ;
	private String sumPage;
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
	public List<QuestionVo> getData() {
		return data;
	}
	public void setData(List<QuestionVo> data) {
		this.data = data;
	}
	private List<QuestionVo> data ;

}
