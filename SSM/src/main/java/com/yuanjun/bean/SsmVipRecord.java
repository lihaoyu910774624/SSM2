package com.yuanjun.bean;

import java.util.Date;

public class SsmVipRecord {
    private Integer id;

    private String outTradeNo;

    private String userId;

    private String openid;

    private String transactionId;

    private String prepayId;

    private Integer categoryid;

    private Integer categorypid;

    private Integer totalFee;

    private String productId;

    private Integer productPrice;

    private Byte ispay;

    private Date addtime;

    private Date paytime;

    private Integer exprietime;

    private Integer payexprietime;

    private Byte flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId == null ? null : transactionId.trim();
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId == null ? null : prepayId.trim();
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public Integer getCategorypid() {
        return categorypid;
    }

    public void setCategorypid(Integer categorypid) {
        this.categorypid = categorypid;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public Byte getIspay() {
        return ispay;
    }

    public void setIspay(Byte ispay) {
        this.ispay = ispay;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public Integer getExprietime() {
        return exprietime;
    }

    public void setExprietime(Integer exprietime) {
        this.exprietime = exprietime;
    }

    public Integer getPayexprietime() {
        return payexprietime;
    }

    public void setPayexprietime(Integer payexprietime) {
        this.payexprietime = payexprietime;
    }

    public Byte getFlag() {
        return flag;
    }

    public void setFlag(Byte flag) {
        this.flag = flag;
    }
}