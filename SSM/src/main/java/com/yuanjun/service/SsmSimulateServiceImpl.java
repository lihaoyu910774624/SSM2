package com.yuanjun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanjun.bean.SsmSimulate;
import com.yuanjun.bean.SsmSimulateExample;
import com.yuanjun.dao.SsmSimulateMapper;
@Service
public class SsmSimulateServiceImpl implements SsmSimulateService {
	@Autowired
	private SsmSimulateMapper ssmSimulateMapper ;

	@Override
	public int insertSelective(SsmSimulate record) {
		
		return ssmSimulateMapper.insertSelective(record);
	}

	@Override
	public int updateByExampleSelective(SsmSimulate record, SsmSimulateExample example) {
		
		return ssmSimulateMapper.updateByExampleSelective(record, example);
	}

}
