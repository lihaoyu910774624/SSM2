package com.yuanjun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanjun.bean.SsmVipProduct;
import com.yuanjun.bean.SsmVipProductExample;
import com.yuanjun.dao.SsmVipProductMapper;

@Service
public class SsmVipProductServiceImpl implements SsmVipProductService {
	@Autowired
     private	SsmVipProductMapper ssmVipProductMapper ;

	@Override
	public List<SsmVipProduct> selectByExample(SsmVipProductExample example) {
		
		return ssmVipProductMapper.selectByExample(example);
	}

	@Override
	public int updateByPrimaryKeySelective(SsmVipProduct record) {
		
		return ssmVipProductMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int insertSelective(SsmVipProduct record) {
		
		return ssmVipProductMapper.insertSelective(record);
	}

	@Override
	public int updateByExampleSelective(SsmVipProduct record, SsmVipProductExample example) {
		
		return ssmVipProductMapper.updateByExampleSelective(record, example);
	}
	
	

}
