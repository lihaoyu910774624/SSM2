package com.yuanjun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanjun.bean.SsmQuestionChapter;
import com.yuanjun.bean.SsmQuestionChapterExample;
import com.yuanjun.dao.SsmQuestionChapterMapper;
import com.yuanjun.vo.Catalog;
import com.yuanjun.vo.ChapterDto;
import com.yuanjun.vo.QuestionInfo;
@Service
public class SsmQuestionChapterServiceImpl implements SsmQuestionChapterService {
	@Autowired
    private SsmQuestionChapterMapper ssmQuestionChapterMapper ;
    
	@Override
	public QuestionInfo getById(String id) {
		
		return ssmQuestionChapterMapper.getById(id);
	}

	@Override
	public long countByExample(SsmQuestionChapterExample example) {
		
		return ssmQuestionChapterMapper.countByExample(example);
	}



	@Override
	public int updateByExampleSelective(SsmQuestionChapter record, SsmQuestionChapterExample example) {
		
		return ssmQuestionChapterMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int insertSelective(SsmQuestionChapter record) {
		
		return ssmQuestionChapterMapper.insertSelective(record);
	}

	@Override
	public List<QuestionInfo> getAll(String categoryId, String categoryPId, String title, Integer start, Integer end) {
		// TODO Auto-generated method stub
		return ssmQuestionChapterMapper.getAll(categoryId, categoryPId, title, start, end);
	}

	@Override
	public List<Catalog> getCatalogByPid(String categoryPId) {
		
		return ssmQuestionChapterMapper.getCatalogByPid(categoryPId);
	}

	@Override
	public List<ChapterDto> getChapterByIdAndPid(String categoryId, String categoryPId) {
		
		return ssmQuestionChapterMapper.getChapterByIdAndPid(categoryId, categoryPId);
	}

	@Override
	public List<SsmQuestionChapter> selectByExample(SsmQuestionChapterExample example) {
		
		return ssmQuestionChapterMapper.selectByExample(example);
	}

	
	

	

	

	
	

	


}
