package com.yuanjun.comm.viprecord;

import java.util.List;

public class VipRecordListMessage {
	
	private String code ;
	private String msg ;
	private String currPage ;
	private String sumPage;
	
	List<VipRecordVo> data ;
	
	
	
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
	public List<VipRecordVo> getData() {
		return data;
	}
	public void setData(List<VipRecordVo> data) {
		this.data = data;
	}
	
	
	
	

}
