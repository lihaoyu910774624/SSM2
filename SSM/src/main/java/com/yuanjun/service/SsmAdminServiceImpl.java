package com.yuanjun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanjun.bean.SsmAdmin;
import com.yuanjun.bean.SsmAdminExample;
import com.yuanjun.dao.SsmAdminMapper;
@Service
public class SsmAdminServiceImpl implements SsmAdminService {
	@Autowired
	private SsmAdminMapper ssmAdminMapper ;

	@Override
	public int insertSelective(SsmAdmin record) {
		
		return ssmAdminMapper.insertSelective(record);
	}

	@Override
	public List<SsmAdmin> selectByExample(SsmAdminExample example) {
		
		return ssmAdminMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(SsmAdmin record, SsmAdminExample example) {
		
		return ssmAdminMapper.updateByExample(record, example);
	}

}
