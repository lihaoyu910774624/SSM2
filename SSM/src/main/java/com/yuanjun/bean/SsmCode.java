package com.yuanjun.bean;

import java.util.Date;

public class SsmCode {
    private Integer id;

    private String phone;

    private String codenum;

    private Date addtime;

    private Integer expiretime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getCodenum() {
        return codenum;
    }

    public void setCodenum(String codenum) {
        this.codenum = codenum == null ? null : codenum.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Integer getExpiretime() {
        return expiretime;
    }

    @Override
	public String toString() {
		return "SsmCode [id=" + id + ", phone=" + phone + ", codenum=" + codenum + ", addtime=" + addtime
				+ ", expiretime=" + expiretime + "]";
	}

	public void setExpiretime(Integer expiretime) {
        this.expiretime = expiretime;
    }
}