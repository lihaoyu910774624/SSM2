package com.yuanjun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanjun.bean.SsmArticle;
import com.yuanjun.bean.SsmArticleExample;
import com.yuanjun.dao.SsmArticleMapper;
import com.yuanjun.vo.ArticlAllInfo;
import com.yuanjun.vo.ArticlInfo;
import com.yuanjun.vo.articlvo.ArticlTitleId;
@Service
public class SsmArticleServiceImpl implements SsmArticleService {
	
	@Autowired
	private SsmArticleMapper ssmArticleMapper ;

	@Override
	public ArticlInfo getById(String id) {
		
		return ssmArticleMapper.getById(id);
	}

	
	@Override
	public Integer getCount() {
		
		return ssmArticleMapper.getCount();
	}

	@Override
	public int insertSelective(SsmArticle record) {
		
		return ssmArticleMapper.insertSelective(record);
	}

	@Override
	public int updateByExampleSelective(SsmArticle record, SsmArticleExample example) {
		
		return ssmArticleMapper.updateByExampleSelective(record, example);
	}


	@Override
	public List<ArticlAllInfo> getAll(String title, int start, int end) {
		
		return ssmArticleMapper.getAll(title, start, end);
	}


	@Override
	public List<ArticlTitleId> getFive(String categoryId) {
		// TODO Auto-generated method stub
		return ssmArticleMapper.getFive(categoryId);
	}


	@Override
	public List<ArticlTitleId> getTitleAll(String categoryId) {
		
		return ssmArticleMapper.getTitleAll(categoryId);
	}


	@Override
	public SsmArticle selectByPrimaryKey(Integer id) {
		
		return ssmArticleMapper.selectByPrimaryKey(id);
	}


	@Override
	public int updateByPrimaryKeySelective(SsmArticle record) {
		
		return ssmArticleMapper.updateByPrimaryKeySelective(record);
	}

	
	
	

}
