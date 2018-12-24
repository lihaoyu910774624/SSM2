package com.yuanjun.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuanjun.bean.SsmQuestionStudy;
import com.yuanjun.bean.SsmQuestionStudyExample;
import com.yuanjun.vo.frontStudy.QuestionStudyModel;
import com.yuanjun.vo.frontStudy.StudyQuestion;
import com.yuanjun.vo.frontStudy.StudyTitleVo;




public interface SsmQuestionStudyMapper {
	int saveStudyAll(@Param("questionStudyModel") QuestionStudyModel questionStudyModel );
	 List<StudyQuestion>  getStudyInfoByUserId(    @Param("category_id") String category_id,			
			  @Param("start") int start, @Param("end") int end ,@Param("userid") String userid);
	List<StudyTitleVo>  getCategoryTitle(  @Param("userid")  String userid);
	
    long countByExample(SsmQuestionStudyExample example);

    int deleteByExample(SsmQuestionStudyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SsmQuestionStudy record);

    int insertSelective(SsmQuestionStudy record);

    List<SsmQuestionStudy> selectByExample(SsmQuestionStudyExample example);

    SsmQuestionStudy selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SsmQuestionStudy record, @Param("example") SsmQuestionStudyExample example);

    int updateByExample(@Param("record") SsmQuestionStudy record, @Param("example") SsmQuestionStudyExample example);

    int updateByPrimaryKeySelective(SsmQuestionStudy record);

    int updateByPrimaryKey(SsmQuestionStudy record);
}