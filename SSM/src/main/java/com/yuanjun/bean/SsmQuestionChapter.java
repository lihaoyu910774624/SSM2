package com.yuanjun.bean;

import java.util.Date;

public class SsmQuestionChapter {
    private Integer id;

    private String chapterId;

    private Integer categoryId;

    private Byte categoryPid;

    private String title;

    private Byte sortNo;

    private Date addtime;

    private Byte flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChapterId() {
        return chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId == null ? null : chapterId.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Byte getCategoryPid() {
        return categoryPid;
    }

    public void setCategoryPid(Byte categoryPid) {
        this.categoryPid = categoryPid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Byte getSortNo() {
        return sortNo;
    }

    public void setSortNo(Byte sortNo) {
        this.sortNo = sortNo;
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