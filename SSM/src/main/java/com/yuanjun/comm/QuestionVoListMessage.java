package com.yuanjun.comm;

import java.util.List;

import com.yuanjun.vo.QuestionVo;

public class QuestionVoListMessage {
	private String code ;
	private String msg ;
	private QuestionVo data ;
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
	public QuestionVo getData() {
		return data;
	}
	public void setData(QuestionVo data) {
		this.data = data;
	}
	

}
