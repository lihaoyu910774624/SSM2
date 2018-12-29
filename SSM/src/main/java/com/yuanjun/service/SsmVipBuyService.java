package com.yuanjun.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuanjun.bean.SsmVipBuy;
import com.yuanjun.bean.SsmVipBuyExample;

public interface SsmVipBuyService {
	 int updateByPrimaryKeySelective(SsmVipBuy record);
	SsmVipBuy findByUseridAndCategory( String user_id,  String categoryid,	 String categorypid);
	 int insertSelective(SsmVipBuy record);
	 int updateByExampleSelective(@Param("record") SsmVipBuy record, @Param("example") SsmVipBuyExample example);
	 List<SsmVipBuy> selectByExample(SsmVipBuyExample example);

}
