package com.yuanjun.vo;

import java.util.Date;

public class ProductInfo {
	
  private  String productId ;
  private String title;
  private Integer price ;
  private  Integer  effectdays ;
  private Date addtime ;
public String getProductId() {
	return productId;
}
public void setProductId(String productId) {
	this.productId = productId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public Integer getPrice() {
	return price;
}
public void setPrice(Integer price) {
	this.price = price;
}
public Integer getEffectdays() {
	return effectdays;
}
public void setEffectdays(Integer effectdays) {
	this.effectdays = effectdays;
}
public Date getAddtime() {
	return addtime;
}
public void setAddtime(Date addtime) {
	this.addtime = addtime;
}
  
  

	

}
