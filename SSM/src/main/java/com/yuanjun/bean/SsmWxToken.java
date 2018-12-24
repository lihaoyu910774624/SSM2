package com.yuanjun.bean;

import java.util.Date;

public class SsmWxToken {
    private String id;

    private Date createtime;

    private Integer expiretime;

    private String accesstoken;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getExpiretime() {
        return expiretime;
    }

    public void setExpiretime(Integer expiretime) {
        this.expiretime = expiretime;
    }

    public String getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken == null ? null : accesstoken.trim();
    }
}