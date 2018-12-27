package com.yuanjun.bean;

public class SsmSimulate {
    private Integer id;

    private String userid;

    private String simulateid;

    private Integer startTime;

    private Integer endTime;

    private Integer score;

    private Byte flag;

    private Byte categoryPid;

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

    public String getSimulateid() {
        return simulateid;
    }

    public void setSimulateid(String simulateid) {
        this.simulateid = simulateid == null ? null : simulateid.trim();
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Byte getFlag() {
        return flag;
    }

    public void setFlag(Byte flag) {
        this.flag = flag;
    }

    public Byte getCategoryPid() {
        return categoryPid;
    }

    public void setCategoryPid(Byte categoryPid) {
        this.categoryPid = categoryPid;
    }
}