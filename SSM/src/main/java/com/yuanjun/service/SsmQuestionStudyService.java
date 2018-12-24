package com.yuanjun.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuanjun.bean.SsmAdminExample;
import com.yuanjun.bean.SsmQuestionStudy;
import com.yuanjun.bean.SsmQuestionStudyExample;
import com.yuanjun.vo.FrontQuestion.TrainingQuestion;
import com.yuanjun.vo.frontStudy.QuestionStudyModel;
import com.yuanjun.vo.frontStudy.StudyQuestion;
import com.yuanjun.vo.frontStudy.StudyTitleVo;

public interface SsmQuestionStudyService {
	int updateByPrimaryKeySelective(SsmQuestionStudy record);
	int saveStudyAll( QuestionStudyModel questionStudyModel );

	 List<StudyQuestion>   getStudyInfoByUserId(     String category_id,			
			   int start,  int end , String userid);
	 List<StudyTitleVo>  getCategoryTitle(    String userid);
	 int updateByExampleSelective( SsmQuestionStudy record, SsmQuestionStudyExample example);
	 SsmQuestionStudy selectByPrimaryKey(Integer id);
	 long countByExample(SsmQuestionStudyExample example);
	 int insertSelective(SsmQuestionStudy record);
	 
	 List<SsmQuestionStudy> selectByExample(SsmQuestionStudyExample example);
	 
	
	

}
