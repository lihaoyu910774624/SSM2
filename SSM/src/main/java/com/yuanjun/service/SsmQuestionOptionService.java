package com.yuanjun.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuanjun.bean.SsmQuestionOption;
import com.yuanjun.bean.SsmQuestionOptionExample;

public interface SsmQuestionOptionService {
	int deleteByExample(SsmQuestionOptionExample example);
	 int saveOptionAll(List<SsmQuestionOption> list);
	// List<SsmQuestionOption> getAll(String title,String start,String end);
	 long countByExample(SsmQuestionOptionExample example);
	
	 int insertSelective(SsmQuestionOption record);
	 
	 List<SsmQuestionOption> selectByExample(SsmQuestionOptionExample example);
	 
	 int updateByExampleSelective(@Param("record") SsmQuestionOption record, @Param("example") SsmQuestionOptionExample example);

}
