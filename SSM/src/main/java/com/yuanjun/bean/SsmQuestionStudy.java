package com.yuanjun.bean;

import java.util.Date;

public class SsmQuestionStudy {
    private Integer id;

    private String userid;

    private Byte categorypid;

    private Byte categoryid;

    private String chapterid;

    private String questionid;

    private Byte status;

    private Byte kind;

    private Date addtime;

    private String myanser;

    private Byte flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Byte getCategorypid() {
        return categorypid;
    }

    public void setCategorypid(Byte categorypid) {
        this.categorypid = categorypid;
    }

    public Byte getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Byte categoryid) {
        this.categoryid = categoryid;
    }

    public String getChapterid() {
        return chapterid;
    }

    public void setChapterid(String chapterid) {
        this.chapterid = chapterid == null ? null : chapterid.trim();
    }

    public String getQuestionid() {
        return questionid;
    }

    public void setQuestionid(String questionid) {
        this.questionid = questionid == null ? null : questionid.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getKind() {
        return kind;
    }

    public void setKind(Byte kind) {
        this.kind = kind;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getMyanser() {
        return myanser;
    }

    public void setMyanser(String myanser) {
        this.myanser = myanser == null ? null : myanser.trim();
    }

    public Byte getFlag() {
        return flag;
    }

    public void setFlag(Byte flag) {
        this.flag = flag;
    }
}