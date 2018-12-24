package com.yuanjun.comm;

import java.util.List;

import com.yuanjun.bean.SsmVipProduct;
import com.yuanjun.vo.ProductInfo;
import com.yuanjun.vo.UserInfo;

public class ProductListMessage {
	private String code ;
	private String msg ;
	List<ProductInfo> data ;
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
	public List<ProductInfo> getData() {
		return data;
	}
	public void setData(List<ProductInfo> data) {
		this.data = data;
	}
	
	
	
}
