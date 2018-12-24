package com.yuanjun.comm.viprecord;

import java.util.List;

public class VipRecordListMessage {
	
	private String code ;
	private String msg ;
	List<VipRecordVo> list ;
	
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
	public List<VipRecordVo> getList() {
		return list;
	}
	public void setList(List<VipRecordVo> list) {
		this.list = list;
	}
	
	
	

}
