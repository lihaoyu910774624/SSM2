package com.yuanjun.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuanjun.bean.SsmVipProduct;
import com.yuanjun.bean.SsmVipProductExample;

public interface SsmVipProductService {
	int updateByExampleSelective( SsmVipProduct record, SsmVipProductExample example);
	int updateByPrimaryKeySelective(SsmVipProduct record);
	int insertSelective(SsmVipProduct record);
	List<SsmVipProduct> selectByExample(SsmVipProductExample example);

}
