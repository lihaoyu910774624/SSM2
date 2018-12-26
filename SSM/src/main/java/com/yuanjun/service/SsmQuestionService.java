package com.yuanjun.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuanjun.bean.SsmQuestion;
import com.yuanjun.bean.SsmQuestionExample;
import com.yuanjun.vo.FrontQuestion.TrainingQuestion;
import com.yuanjun.vo.question.QuestionDto;
import com.yuanjun.vo.simulate.SimulateQuestion;

public interface SsmQuestionService {
	List<SimulateQuestion> getSimulateDanxuan(String userid,String category_id, String category_pid);

	List<SimulateQuestion> getSimulateDuoxuan(String userid,String category_id, String category_pid);

	List<SimulateQuestion> getSimulatePanduan(String userid,String category_id, String category_pid);

	List<SimulateQuestion> getSimulateQuestionFree(String userid, String category_pid, String type);
	
	long countByChapter ( String chapterId);
	long  countByType( String category_pid,  String category_id,String chapter_id , int kind , int type );
	List<TrainingQuestion>  findTrainingQuestionFree( String category_pid,  String category_id,String chapter_id ,
	           			  int start, int end,String userid) ;
	List<TrainingQuestion>  findTrainingQuestion( String category_pid,  String category_id,String chapter_id ,
			  int start, int end,String userid) ;
	 int deleteByExample(SsmQuestionExample example);
	 List<QuestionDto> getAll( String title, int start, int end, String category_pid,String category_id,String chapter_id,String kind);
	 long countByExample(SsmQuestionExample example);
	 int insertSelective(SsmQuestion record);
	 int updateByExampleSelective( SsmQuestion record, SsmQuestionExample example);
	 List<SsmQuestion> selectByExample(SsmQuestionExample example);
	 SsmQuestion selectByPrimaryKey(Integer id);

}
