package com.yuanjun.bean;

import java.util.Date;

public class SsmQuestion {
    private Integer id;

    private String questionid;

    private String title;

    private Integer fraction;

    private Byte type;

    private String correctanswer;

    private Byte categoryid;

    private Byte subjectid;

    private String chapterid;

    private Byte status;

    private Date addtime;

    private Integer browse;

    private Short sortNo;

    private Byte kind;

    private String analysis;

    private String brief;

    private Byte flag;

    @Override
	public String toString() {
		return "SsmQuestion [id=" + id + ", questionid=" + questionid + ", title=" + title + ", fraction=" + fraction
				+ ", type=" + type + ", correctanswer=" + correctanswer + ", categoryid=" + categoryid + ", subjectid="
				+ subjectid + ", chapterid=" + chapterid + ", status=" + status + ", addtime=" + addtime + ", browse="
				+ browse + ", sortNo=" + sortNo + ", kind=" + kind + ", analysis=" + analysis + ", brief=" + brief
				+ ", flag=" + flag + "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionid() {
        return questionid;
    }

    public void setQuestionid(String questionid) {
        this.questionid = questionid == null ? null : questionid.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getFraction() {
        return fraction;
    }

    public void setFraction(Integer fraction) {
        this.fraction = fraction;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getCorrectanswer() {
        return correctanswer;
    }

    public void setCorrectanswer(String correctanswer) {
        this.correctanswer = correctanswer == null ? null : correctanswer.trim();
    }

    public Byte getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Byte categoryid) {
        this.categoryid = categoryid;
    }

    public Byte getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Byte subjectid) {
        this.subjectid = subjectid;
    }

    public String getChapterid() {
        return chapterid;
    }

    public void setChapterid(String chapterid) {
        this.chapterid = chapterid == null ? null : chapterid.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Integer getBrowse() {
        return browse;
    }

    public void setBrowse(Integer browse) {
        this.browse = browse;
    }

    public Short getSortNo() {
        return sortNo;
    }

    public void setSortNo(Short sortNo) {
        this.sortNo = sortNo;
    }

    public Byte getKind() {
        return kind;
    }

    public void setKind(Byte kind) {
        this.kind = kind;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis == null ? null : analysis.trim();
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    public Byte getFlag() {
        return flag;
    }

    public void setFlag(Byte flag) {
        this.flag = flag;
    }
    
}