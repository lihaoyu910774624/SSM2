package com.yuanjun.vo.frontRecord;

import java.util.List;

public class RecordMessage {
	
	private String code ;
	private String msg ;
	 private List<RecordDto> data  ;
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
	public List<RecordDto> getData() {
		return data;
	}
	public void setData(List<RecordDto> data) {
		this.data = data;
	}
	 
	 
	

}
