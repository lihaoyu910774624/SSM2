package com.yuanjun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanjun.bean.SsmSimulate;
import com.yuanjun.bean.SsmSimulateExample;
import com.yuanjun.dao.SsmSimulateMapper;
import com.yuanjun.vo.simulate.SimulateInfo;
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

	@Override
	public List<SimulateInfo> getSimulateInfo(String userid) {
		
		return ssmSimulateMapper.getSimulateInfo(userid);
	}

	@Override
	public List<SsmSimulate> selectByExample(SsmSimulateExample example) {
		
		return ssmSimulateMapper.selectByExample(example);
	}

	@Override
	public long countByExample(SsmSimulateExample example) {
		
		return ssmSimulateMapper.countByExample(example);
	}

}
