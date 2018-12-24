package com.yuanjun.dao;

import com.yuanjun.bean.SsmVipProduct;
import com.yuanjun.bean.SsmVipProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface SsmVipProductMapper
{
  public abstract long countByExample(SsmVipProductExample paramSsmVipProductExample);

  public abstract int deleteByExample(SsmVipProductExample paramSsmVipProductExample);

  public abstract int deleteByPrimaryKey(Byte paramByte);

  public abstract int insert(SsmVipProduct paramSsmVipProduct);

  public abstract int insertSelective(SsmVipProduct paramSsmVipProduct);

  public abstract List<SsmVipProduct> selectByExample(SsmVipProductExample paramSsmVipProductExample);

  public abstract SsmVipProduct selectByPrimaryKey(Byte paramByte);

  public abstract int updateByExampleSelective(@Param("record") SsmVipProduct paramSsmVipProduct, @Param("example") SsmVipProductExample paramSsmVipProductExample);

  public abstract int updateByExample(@Param("record") SsmVipProduct paramSsmVipProduct, @Param("example") SsmVipProductExample paramSsmVipProductExample);

  public abstract int updateByPrimaryKeySelective(SsmVipProduct paramSsmVipProduct);

  public abstract int updateByPrimaryKey(SsmVipProduct paramSsmVipProduct);
}