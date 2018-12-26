package com.yuanjun.bean;

public class SsmSimulateQuestion {
    private Integer id;

    private String questionid;

    private String simulateid;

    private String myanswer;

    private Byte score;

    private Byte flag;

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

    public String getSimulateid() {
        return simulateid;
    }

    public void setSimulateid(String simulateid) {
        this.simulateid = simulateid == null ? null : simulateid.trim();
    }

    public String getMyanswer() {
        return myanswer;
    }

    public void setMyanswer(String myanswer) {
        this.myanswer = myanswer == null ? null : myanswer.trim();
    }

    public Byte getScore() {
        return score;
    }

    public void setScore(Byte score) {
        this.score = score;
    }

    public Byte getFlag() {
        return flag;
    }

    public void setFlag(Byte flag) {
        this.flag = flag;
    }
}