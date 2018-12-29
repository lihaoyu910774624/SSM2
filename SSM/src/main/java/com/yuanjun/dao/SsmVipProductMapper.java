package com.yuanjun.dao;

import com.yuanjun.bean.SsmVipProduct;
import com.yuanjun.bean.SsmVipProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SsmVipProductMapper {
    long countByExample(SsmVipProductExample example);

    int deleteByExample(SsmVipProductExample example);

    int deleteByPrimaryKey(Byte id);

    int insert(SsmVipProduct record);

    int insertSelective(SsmVipProduct record);

    List<SsmVipProduct> selectByExample(SsmVipProductExample example);

    SsmVipProduct selectByPrimaryKey(Byte id);

    int updateByExampleSelective(@Param("record") SsmVipProduct record, @Param("example") SsmVipProductExample example);

    int updateByExample(@Param("record") SsmVipProduct record, @Param("example") SsmVipProductExample example);

    int updateByPrimaryKeySelective(SsmVipProduct record);

    int updateByPrimaryKey(SsmVipProduct record);
}