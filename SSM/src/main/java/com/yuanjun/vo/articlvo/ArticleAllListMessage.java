package com.yuanjun.vo.articlvo;

import java.util.List;

public class ArticleAllListMessage {
	
	private String code ;
	private String msg ;
	private List<ArticlTitleId> data ;
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
	public List<ArticlTitleId> getData() {
		return data;
	}
	public void setData(List<ArticlTitleId> data) {
		this.data = data;
	}
	

}
