package com.yuanjun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanjun.bean.SsmWxToken;
import com.yuanjun.dao.SsmWxTokenMapper;
@Service
public class SsmWxTokenServiceImpl implements SsmWxTokenService {
    @Autowired
	private SsmWxTokenMapper ssmWxTokenMapper ;
	@Override
	public SsmWxToken selectByPrimaryKey(String id) {
		
		return ssmWxTokenMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(SsmWxToken record) {
		
		return ssmWxTokenMapper.updateByPrimaryKeySelective(record);
	}
	
	

}
