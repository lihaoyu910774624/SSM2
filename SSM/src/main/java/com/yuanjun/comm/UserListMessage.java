package com.yuanjun.comm;

import java.util.List;
import java.util.Map;

import com.yuanjun.vo.UserInfo;

public class UserListMessage {

	private String code ;
	private String msg ;
	private String phone;
	private Integer currPage ;
	private Integer sumPage;
	private List<UserInfo> data ;
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public List<UserInfo> getData() {
		return data;
	}
	public void setData(List<UserInfo> data) {
		this.data = data;
	}
	
	
	
	
	
	
}
