package com.yuanjun.comm;

import java.util.List;

import com.yuanjun.bean.SsmCategory;
import com.yuanjun.vo.CategoryInfo;

public class CategoryListMessage extends Message {
	private List<CategoryInfo> data ;

	public List<CategoryInfo> getData() {
		return data;
	}

	public void setData(List<CategoryInfo> data) {
		this.data = data;
	}

	
	

}
