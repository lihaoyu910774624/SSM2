package com.yuanjun.bean;

import java.util.Date;

public class SsmCategory {
    private Integer id;

    private Integer pid;

    private String title;

    private Date addtime;

    private Byte flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Byte getFlag() {
        return flag;
    }

    public void setFlag(Byte flag) {
        this.flag = flag;
    }
}