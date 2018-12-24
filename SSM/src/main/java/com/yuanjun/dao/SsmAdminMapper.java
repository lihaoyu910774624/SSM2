package com.yuanjun.dao;

import com.yuanjun.bean.SsmAdmin;
import com.yuanjun.bean.SsmAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SsmAdminMapper {
    long countByExample(SsmAdminExample example);

    int deleteByExample(SsmAdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SsmAdmin record);

    int insertSelective(SsmAdmin record);

    List<SsmAdmin> selectByExample(SsmAdminExample example);

    SsmAdmin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SsmAdmin record, @Param("example") SsmAdminExample example);

    int updateByExample(@Param("record") SsmAdmin record, @Param("example") SsmAdminExample example);

    int updateByPrimaryKeySelective(SsmAdmin record);

    int updateByPrimaryKey(SsmAdmin record);
}