package com.yuanjun.dao;

import com.yuanjun.bean.SsmVipBuy;
import com.yuanjun.bean.SsmVipBuyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SsmVipBuyMapper {
	SsmVipBuy findByUseridAndCategory(@Param("user_id") String user_id, @Param("categoryid") String categoryid,
			@Param("categorypid") String categorypid);
    long countByExample(SsmVipBuyExample example);

    int deleteByExample(SsmVipBuyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SsmVipBuy record);

    int insertSelective(SsmVipBuy record);

    List<SsmVipBuy> selectByExample(SsmVipBuyExample example);

    SsmVipBuy selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SsmVipBuy record, @Param("example") SsmVipBuyExample example);

    int updateByExample(@Param("record") SsmVipBuy record, @Param("example") SsmVipBuyExample example);

    int updateByPrimaryKeySelective(SsmVipBuy record);

    int updateByPrimaryKey(SsmVipBuy record);
}