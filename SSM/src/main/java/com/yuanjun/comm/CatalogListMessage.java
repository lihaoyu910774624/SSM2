package com.yuanjun.comm;

import java.util.List;

import com.yuanjun.vo.Catalog;

public class CatalogListMessage  extends Message{
	private List<Catalog> data;

	public List<Catalog> getData() {
		return data;
	}

	public void setData(List<Catalog> data) {
		this.data = data;
	}
	

}
