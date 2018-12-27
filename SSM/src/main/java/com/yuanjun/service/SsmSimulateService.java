package com.yuanjun.service;

import java.util.List;

import com.yuanjun.bean.SsmSimulate;
import com.yuanjun.bean.SsmSimulateExample;
import com.yuanjun.vo.simulate.SimulateInfo;


public interface SsmSimulateService {
	
	   long countByExample(SsmSimulateExample example);
	  List<SsmSimulate> selectByExample(SsmSimulateExample example);
	   int insertSelective(SsmSimulate record);

	   int updateByExampleSelective(SsmSimulate record,  SsmSimulateExample example);
	   List<SimulateInfo>   getSimulateInfo(String userid);
	
	

}
