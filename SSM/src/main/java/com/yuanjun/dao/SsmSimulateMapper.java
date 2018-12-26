package com.yuanjun.dao;

import com.yuanjun.bean.SsmSimulate;
import com.yuanjun.bean.SsmSimulateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SsmSimulateMapper {
    long countByExample(SsmSimulateExample example);

    int deleteByExample(SsmSimulateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SsmSimulate record);

    int insertSelective(SsmSimulate record);

    List<SsmSimulate> selectByExample(SsmSimulateExample example);

    SsmSimulate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SsmSimulate record, @Param("example") SsmSimulateExample example);

    int updateByExample(@Param("record") SsmSimulate record, @Param("example") SsmSimulateExample example);

    int updateByPrimaryKeySelective(SsmSimulate record);

    int updateByPrimaryKey(SsmSimulate record);
}