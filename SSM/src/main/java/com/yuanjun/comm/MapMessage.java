package com.yuanjun.comm;

import java.util.List;
import java.util.Map;

import com.yuanjun.vo.Catalog;

public class MapMessage {
	private String code ;
	private String msg ;
	private Map<String,String> data ;
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
	public Map<String, String> getData() {
		return data;
	}
	public void setData(Map<String, String> data) {
		this.data = data;
	}
	
	
	
	
	
}
