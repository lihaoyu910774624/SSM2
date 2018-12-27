package com.yuanjun.vo.simulate;

import java.util.List;

public class SimulateInfoMessage {
	

	private String code ;
	private String msg ;
	private List<SimulateInfo> data ;
	
	public List<SimulateInfo> getData() {
		return data;
	}
	public void setData(List<SimulateInfo> data) {
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
