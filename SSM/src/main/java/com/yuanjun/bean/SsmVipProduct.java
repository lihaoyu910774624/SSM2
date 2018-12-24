package com.yuanjun.bean;

import java.util.Date;

public class SsmVipProduct
{
  private Byte id;
  private String productId;
  private String title;
  private Integer price;
  private Integer effectdays;
  private Byte sortNo;
  private Date addtime;
  private Byte flag;

  public Byte getId()
  {
    return this.id;
  }

  public void setId(Byte id) {
    this.id = id;
  }

  public String getProductId() {
    return this.productId;
  }

  public void setProductId(String productId) {
    this.productId = (productId == null ? null : productId.trim());
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = (title == null ? null : title.trim());
  }

  public Integer getPrice() {
    return this.price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Integer getEffectdays() {
    return this.effectdays;
  }

  public void setEffectdays(Integer effectdays) {
    this.effectdays = effectdays;
  }

  public Byte getSortNo() {
    return this.sortNo;
  }

  public void setSortNo(Byte sortNo) {
    this.sortNo = sortNo;
  }

  public Date getAddtime() {
    return this.addtime;
  }

  public void setAddtime(Date addtime) {
    this.addtime = addtime;
  }

  public Byte getFlag() {
    return this.flag;
  }

  public void setFlag(Byte flag) {
    this.flag = flag;
  }
}