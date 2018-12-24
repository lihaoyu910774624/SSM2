package com.yuanjun.dao;

import com.yuanjun.bean.SsmWxToken;
import com.yuanjun.bean.SsmWxTokenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SsmWxTokenMapper {
    long countByExample(SsmWxTokenExample example);

    int deleteByExample(SsmWxTokenExample example);

    int deleteByPrimaryKey(String id);

    int insert(SsmWxToken record);

    int insertSelective(SsmWxToken record);

    List<SsmWxToken> selectByExampleWithBLOBs(SsmWxTokenExample example);

    List<SsmWxToken> selectByExample(SsmWxTokenExample example);

    SsmWxToken selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SsmWxToken record, @Param("example") SsmWxTokenExample example);

    int updateByExampleWithBLOBs(@Param("record") SsmWxToken record, @Param("example") SsmWxTokenExample example);

    int updateByExample(@Param("record") SsmWxToken record, @Param("example") SsmWxTokenExample example);

    int updateByPrimaryKeySelective(SsmWxToken record);

    int updateByPrimaryKeyWithBLOBs(SsmWxToken record);

    int updateByPrimaryKey(SsmWxToken record);
}