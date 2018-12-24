package com.yuanjun.comm;

import java.util.List;

import com.yuanjun.vo.ArticlAllInfo;
import com.yuanjun.vo.ArticlInfo;

public class ArticleListMessage extends Message {
	private Integer currPage ;
	private Integer sumPage;
	private List<ArticlAllInfo> data ;

	
	public List<ArticlAllInfo> getData() {
		return data;
	}

	public void setData(List<ArticlAllInfo> data) {
		this.data = data;
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

	
	

}
