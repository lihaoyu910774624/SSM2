package com.yuanjun.dao;

import com.yuanjun.bean.SsmQuestion;
import com.yuanjun.bean.SsmQuestionExample;
import com.yuanjun.vo.FrontQuestion.TrainingQuestion;
import com.yuanjun.vo.question.QuestionDto;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SsmQuestionMapper {
	long countByChapter (@Param("chapterId") String chapterId);
	
	long  countByType(@Param("category_pid") String category_pid, @Param("category_id") String category_id,
			@Param("chapter_id") String chapter_id ,@Param("kind") int kind ,@Param("type") int type );
	List<TrainingQuestion>  findTrainingQuestionFree(@Param("category_pid") String category_pid, @Param("category_id") String category_id,
			@Param("chapter_id") String chapter_id,  @Param("start") int start, @Param("end") int end, @Param("userid") String userid) ;
	  List<TrainingQuestion>  findTrainingQuestion(@Param("category_pid") String category_pid, @Param("category_id") String category_id,
			  @Param("chapter_id") String chapter_id,
			  @Param("start") int start, @Param("end") int end ,@Param("userid") String userid) ;
	
	 List<QuestionDto> getAll(@Param("title") String title,
			@Param("start") int start, @Param("end") int end,
			@Param("category_pid") String category_pid, @Param("category_id") String category_id,
			@Param("chapter_id") String chapter_id,@Param("kind") String kind);
    long countByExample(SsmQuestionExample example);

    int deleteByExample(SsmQuestionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SsmQuestion record);

    int insertSelective(SsmQuestion record);

    List<SsmQuestion> selectByExample(SsmQuestionExample example);

    SsmQuestion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SsmQuestion record, @Param("example") SsmQuestionExample example);

    int updateByExample(@Param("record") SsmQuestion record, @Param("example") SsmQuestionExample example);

    int updateByPrimaryKeySelective(SsmQuestion record);

    int updateByPrimaryKey(SsmQuestion record);
}