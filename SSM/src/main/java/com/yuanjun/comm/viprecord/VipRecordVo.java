package com.yuanjun.comm.viprecord;

import java.util.Date;

public class VipRecordVo {

	
	private String outTradeNo;
	private String totalFee;
	private String exprietime;
	private Date 	paytime;
	private String  title;
	private String 	phone;
	private String  categoryTitle;
	
	public String getOutTradeNo() {
		return outTradeNo;
	}
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	public String getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}
	public String getExprietime() {
		return exprietime;
	}
	public void setExprietime(String exprietime) {
		this.exprietime = exprietime;
	}
	
	public Date getPaytime() {
		return paytime;
	}
	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCategoryTitle() {
		return categoryTitle;
	}
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}
	
	
}
