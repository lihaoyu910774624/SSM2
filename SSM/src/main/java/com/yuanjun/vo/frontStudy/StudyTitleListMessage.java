package com.yuanjun.vo.frontStudy;

import java.util.List;

public class StudyTitleListMessage {
	
	
	private String code ;
	private String msg ;
	private   List<StudyTitleVo> data ;
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
	public List<StudyTitleVo> getData() {
		return data;
	}
	public void setData(List<StudyTitleVo> data) {
		this.data = data;
	}
	

}
