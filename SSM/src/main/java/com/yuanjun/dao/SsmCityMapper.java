package com.yuanjun.dao;

import com.yuanjun.bean.SsmCity;
import com.yuanjun.bean.SsmCityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SsmCityMapper {
    long countByExample(SsmCityExample example);

    int deleteByExample(SsmCityExample example);

    int deleteByPrimaryKey(Short id);

    int insert(SsmCity record);

    int insertSelective(SsmCity record);

    List<SsmCity> selectByExample(SsmCityExample example);

    SsmCity selectByPrimaryKey(Short id);

    int updateByExampleSelective(@Param("record") SsmCity record, @Param("example") SsmCityExample example);

    int updateByExample(@Param("record") SsmCity record, @Param("example") SsmCityExample example);

    int updateByPrimaryKeySelective(SsmCity record);

    int updateByPrimaryKey(SsmCity record);
}