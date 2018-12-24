package com.yuanjun.service;

import com.yuanjun.bean.SsmWxToken;

public interface SsmWxTokenService {
	
	SsmWxToken selectByPrimaryKey(String id);
	int updateByPrimaryKeySelective(SsmWxToken record);

}
