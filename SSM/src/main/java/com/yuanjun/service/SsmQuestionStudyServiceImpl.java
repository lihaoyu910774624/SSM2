package com.yuanjun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanjun.bean.SsmAdminExample;
import com.yuanjun.bean.SsmQuestionStudy;
import com.yuanjun.bean.SsmQuestionStudyExample;
import com.yuanjun.dao.SsmQuestionStudyMapper;
import com.yuanjun.vo.FrontQuestion.TrainingQuestion;
import com.yuanjun.vo.frontStudy.QuestionStudyModel;
import com.yuanjun.vo.frontStudy.StudyQuestion;
import com.yuanjun.vo.frontStudy.StudyTitleVo;

@Service
public class SsmQuestionStudyServiceImpl implements SsmQuestionStudyService {
	@Autowired
	private SsmQuestionStudyMapper ssmQuestionStudyMapper ;

	@Override
	public long countByExample(SsmQuestionStudyExample example) {
		
		return ssmQuestionStudyMapper.countByExample(example);
	}

	@Override
	public int insertSelective(SsmQuestionStudy record) {
		
		return ssmQuestionStudyMapper.insertSelective(record);
	}

	
	@Override
	public List<SsmQuestionStudy> selectByExample(SsmQuestionStudyExample example) {
		
		return ssmQuestionStudyMapper.selectByExample(example);
	}

	@Override
	public SsmQuestionStudy selectByPrimaryKey(Integer id) {
		
		return ssmQuestionStudyMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(SsmQuestionStudy record, SsmQuestionStudyExample example) {
		
		return ssmQuestionStudyMapper.updateByExample(record, example);
	}

	@Override
	public List<StudyTitleVo> getCategoryTitle(String userid) {
		
		return ssmQuestionStudyMapper.getCategoryTitle(userid);
	}

	@Override
	public  List<StudyQuestion> getStudyInfoByUserId( String category_id, int start, int end,
			String userid) {
		
		return ssmQuestionStudyMapper.getStudyInfoByUserId( category_id, start, end, userid);
	}

	@Override
	public int saveStudyAll(QuestionStudyModel questionStudyModel) {
		
		return ssmQuestionStudyMapper.saveStudyAll(questionStudyModel);
	}

	@Override
	public int updateByPrimaryKeySelective(SsmQuestionStudy record) {
		
		return ssmQuestionStudyMapper.updateByPrimaryKeySelective(record);
	}

	

	

	

}
