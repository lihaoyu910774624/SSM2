package com.yuanjun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanjun.bean.SsmQuestion;
import com.yuanjun.bean.SsmQuestionExample;
import com.yuanjun.dao.SsmQuestionMapper;
import com.yuanjun.vo.FrontQuestion.TrainingQuestion;
import com.yuanjun.vo.question.QuestionDto;

@Service
public class SsmQuestionServiceImpl implements SsmQuestionService {
	@Autowired
	private SsmQuestionMapper ssmQuestionMapper ;

	@Override
	public long countByExample(SsmQuestionExample example) {
		
		return ssmQuestionMapper.countByExample(example);
	}

	@Override
	public int insertSelective(SsmQuestion record) {
		
		return ssmQuestionMapper.insertSelective(record);
	}

	@Override
	public int updateByExampleSelective(SsmQuestion record, SsmQuestionExample example) {
		
		return ssmQuestionMapper.updateByExampleSelective(record, example);
	}

	@Override
	public List<SsmQuestion> selectByExample(SsmQuestionExample example) {
		
		return ssmQuestionMapper.selectByExample(example);
	}

	@Override
	public SsmQuestion selectByPrimaryKey(Integer id) {
		
		return ssmQuestionMapper.selectByPrimaryKey(id);
	}




	@Override
	public int deleteByExample(SsmQuestionExample example) {
		
		return ssmQuestionMapper.deleteByExample(example);
	}

	@Override
	public List<QuestionDto> getAll(String title, int start, int end, String category_pid, String category_id,
			String chapter_id, String kind) {
		
		return ssmQuestionMapper.getAll(title, start, end, category_pid, category_id, chapter_id, kind);
	}

	

	@Override
	public long countByType(String category_pid, String category_id, String chapter_id, int kind, int type) {
		
		return ssmQuestionMapper.countByType(category_pid, category_id, chapter_id, kind, type);
	}

	@Override
	public long countByChapter(String chapterId) {
		
		return ssmQuestionMapper.countByChapter(chapterId);
	}

	@Override
	public List<TrainingQuestion> findTrainingQuestionFree(String category_pid, String category_id, String chapter_id,
			int start, int end, String userid) {
		
		return ssmQuestionMapper.findTrainingQuestionFree(category_pid, category_id, chapter_id, start, end, userid);
	}

	@Override
	public List<TrainingQuestion> findTrainingQuestion(String category_pid, String category_id, String chapter_id,
			int start, int end, String userid) {
	
		return ssmQuestionMapper.findTrainingQuestion(category_pid, category_id, chapter_id, start, end, userid);
	}

	
	

	
	
	
	

}
