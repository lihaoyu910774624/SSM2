package com.yuanjun.comm;

import java.util.List;

import com.yuanjun.bean.SsmAdmin;

public class AdminListMessage extends Message {
   
	private List<SsmAdmin> data ;

	public List<SsmAdmin> getData() {
		return data;
	}

	public void setData(List<SsmAdmin> data) {
		this.data = data;
	}
	
	
	
}
