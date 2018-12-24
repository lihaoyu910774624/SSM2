package com.yuanjun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanjun.bean.SsmCode;
import com.yuanjun.dao.SsmCodeMapper;
@Service
public class SsmCodeServiceImpl implements SsmCodeService {
	@Autowired
	private SsmCodeMapper ssmCodeMapper ;
	

	
	public SsmCodeMapper getSsmCodeMapper() {
		return ssmCodeMapper;
	}



	public void setSsmCodeMapper(SsmCodeMapper ssmCodeMapper) {
		this.ssmCodeMapper = ssmCodeMapper;
	}

	@Override
	public int insertSelective(SsmCode ssmCode) {
		
		return ssmCodeMapper.insertSelective(ssmCode);
	}

	@Override
	public SsmCode selectByPhone(String phone) {
		
		return ssmCodeMapper.selectByPhone(phone);
	}



	@Override
	public SsmCode selectByPhoneAndCodenum(String phone, String codenum) {
		
		return ssmCodeMapper.selectByPhoneAndCodenum(phone, codenum);
	}



	@Override
	public int deleteByEexpiretim(Long expiretime) {
		
		return ssmCodeMapper.deleteByEexpiretim(expiretime);
	}



	@Override
	public List<SsmCode> selectByPhoneDesc(String phone) {
		
		return ssmCodeMapper.selectByPhoneDesc(phone);
	}



	@Override
	public int deleteByPrimaryKey(Integer id) {
		
		return ssmCodeMapper.deleteByPrimaryKey(id);
	}



	


   
	
}
