package com.yuanjun.dao;

import com.yuanjun.bean.SsmSimulateQuestion;
import com.yuanjun.bean.SsmSimulateQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SsmSimulateQuestionMapper {
    long countByExample(SsmSimulateQuestionExample example);

    int deleteByExample(SsmSimulateQuestionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SsmSimulateQuestion record);

    int insertSelective(SsmSimulateQuestion record);

    List<SsmSimulateQuestion> selectByExample(SsmSimulateQuestionExample example);

    SsmSimulateQuestion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SsmSimulateQuestion record, @Param("example") SsmSimulateQuestionExample example);

    int updateByExample(@Param("record") SsmSimulateQuestion record, @Param("example") SsmSimulateQuestionExample example);

    int updateByPrimaryKeySelective(SsmSimulateQuestion record);

    int updateByPrimaryKey(SsmSimulateQuestion record);
}