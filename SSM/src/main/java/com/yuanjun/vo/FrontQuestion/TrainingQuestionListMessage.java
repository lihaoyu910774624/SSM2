package com.yuanjun.vo.FrontQuestion;

import java.util.List;

public class TrainingQuestionListMessage {
	private String code ;
	private String msg ;
	private String currPage ;
	private String sumPage;
	private long duoxuan ;
	private long danxuan ;
	private long panduan ;
	
	private List<TrainingQuestion> data ;
	
	private String categoryPidTitle ;
	
	
	
	

	public long getDuoxuan() {
		return duoxuan;
	}
	public void setDuoxuan(long duoxuan) {
		this.duoxuan = duoxuan;
	}
	public long getDanxuan() {
		return danxuan;
	}
	public void setDanxuan(long danxuan) {
		this.danxuan = danxuan;
	}
	public long getPanduan() {
		return panduan;
	}
	public void setPanduan(long panduan) {
		this.panduan = panduan;
	}
	public void setPanduan(int panduan) {
		this.panduan = panduan;
	}
	public String getCategoryPidTitle() {
		return categoryPidTitle;
	}
	public void setCategoryPidTitle(String categoryPidTitle) {
		this.categoryPidTitle = categoryPidTitle;
	}
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
	public List<TrainingQuestion> getData() {
		return data;
	}
	public void setData(List<TrainingQuestion> data) {
		this.data = data;
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
	
	
	
	
	
	

}
