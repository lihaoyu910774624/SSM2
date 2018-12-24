package com.yuanjun.service;

import java.util.List;

import com.yuanjun.bean.SsmCode;

public interface SsmCodeService {
	
	
	int insertSelective(SsmCode ssmCode);
	SsmCode selectByPhone(String phone);
	SsmCode selectByPhoneAndCodenum(String phone, String codenum);
	int deleteByEexpiretim(Long expiretime);
	int deleteByPrimaryKey(Integer id);
	List<SsmCode> selectByPhoneDesc (String phone);
	

}
