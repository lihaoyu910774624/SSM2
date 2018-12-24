package com.yuanjun.dao;

import com.yuanjun.bean.SsmQuestionOption;
import com.yuanjun.bean.SsmQuestionOptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SsmQuestionOptionMapper {
	 int saveOptionAll(List<SsmQuestionOption> list);
    long countByExample(SsmQuestionOptionExample example);

    int deleteByExample(SsmQuestionOptionExample example);

    int insert(SsmQuestionOption record);

    int insertSelective(SsmQuestionOption record);

    List<SsmQuestionOption> selectByExample(SsmQuestionOptionExample example);

    int updateByExampleSelective(@Param("record") SsmQuestionOption record, @Param("example") SsmQuestionOptionExample example);

    int updateByExample(@Param("record") SsmQuestionOption record, @Param("example") SsmQuestionOptionExample example);
}