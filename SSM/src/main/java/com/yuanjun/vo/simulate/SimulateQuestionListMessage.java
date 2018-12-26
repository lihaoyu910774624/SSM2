package com.yuanjun.vo.simulate;

import java.util.List;

public class SimulateQuestionListMessage {
	private String code ;
	private String msg ;
	private String simulateid;
	private long startTime ;
	private long endTime ;
	private  SimulateVo data ;
	private String categoryPidTitle ;
	
	
	
	public String getSimulateid() {
		return simulateid;
	}
	public void setSimulateid(String simulateid) {
		this.simulateid = simulateid;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
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
	public SimulateVo getData() {
		return data;
	}
	public void setData(SimulateVo data) {
		this.data = data;
	}
	public String getCategoryPidTitle() {
		return categoryPidTitle;
	}
	public void setCategoryPidTitle(String categoryPidTitle) {
		this.categoryPidTitle = categoryPidTitle;
	}
	
	
	

	
	
	
	
	

}
