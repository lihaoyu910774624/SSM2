package com.yuanjun.vo.simulate;

import java.util.List;

public class SimulateVo {
	// 单选
	List<SimulateQuestion> danxuan ;
	// 多选 
	List<SimulateQuestion> duoxuan ;
	// 判断			    		
	List<SimulateQuestion> panduan ;
	public List<SimulateQuestion> getDanxuan() {
		return danxuan;
	}
	public void setDanxuan(List<SimulateQuestion> danxuan) {
		this.danxuan = danxuan;
	}
	public List<SimulateQuestion> getDuoxuan() {
		return duoxuan;
	}
	public void setDuoxuan(List<SimulateQuestion> duoxuan) {
		this.duoxuan = duoxuan;
	}
	public List<SimulateQuestion> getPanduan() {
		return panduan;
	}
	public void setPanduan(List<SimulateQuestion> panduan) {
		this.panduan = panduan;
	}
	
	
	
	
	

}
