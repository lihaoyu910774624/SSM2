package com.yuanjun.vo.front;

import java.util.List;

public class CatalongListMessage {
	private String code ;
	private String msg ;
	private String categoryPidTitle ;	
	private List<Subject>  data ;
	
	public String getCategoryPidTitle() {
		return categoryPidTitle;
	}
	public void setCategoryPidTitle(String categoryPidTitle) {
		this.categoryPidTitle = categoryPidTitle;
	}
	public List<Subject> getData() {
		return data;
	}
	public void setData(List<Subject> data) {
		this.data = data;
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
	
	

}
