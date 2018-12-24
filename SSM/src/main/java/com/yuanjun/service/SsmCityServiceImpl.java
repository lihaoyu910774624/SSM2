package com.yuanjun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanjun.bean.SsmCity;
import com.yuanjun.dao.SsmCityMapper;
@Service
public class SsmCityServiceImpl implements SsmCityService {
    @Autowired
	private SsmCityMapper ssmCityMapper ;
	 
	public SsmCityMapper getSsmCityMapper() {
		return ssmCityMapper;
	}

	public void setSsmCityMapper(SsmCityMapper ssmCityMapper) {
		this.ssmCityMapper = ssmCityMapper;
	}

	@Override
	public SsmCity selectByPrimaryKey(Short id) {
		
		return ssmCityMapper.selectByPrimaryKey(id);
	}

}
