package com.yuanjun.service;

import com.yuanjun.bean.SsmSimulate;
import com.yuanjun.bean.SsmSimulateExample;

public interface SsmSimulateService {
	
	   int insertSelective(SsmSimulate record);

	   int updateByExampleSelective(SsmSimulate record,  SsmSimulateExample example);
	
	

}
