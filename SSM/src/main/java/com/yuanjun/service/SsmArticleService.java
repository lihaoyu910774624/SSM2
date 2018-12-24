package com.yuanjun.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuanjun.bean.SsmArticle;
import com.yuanjun.bean.SsmArticleExample;
import com.yuanjun.vo.ArticlAllInfo;
import com.yuanjun.vo.ArticlInfo;
import com.yuanjun.vo.articlvo.ArticlTitleId;

public interface SsmArticleService {
	int updateByPrimaryKeySelective(SsmArticle record);
	 SsmArticle selectByPrimaryKey(Integer id);
	List<ArticlTitleId>  getTitleAll(String categoryId);
	List<ArticlTitleId>    getFive (String categoryId);
	int insertSelective(SsmArticle record);
	int updateByExampleSelective( SsmArticle record, SsmArticleExample example);
	Integer  getCount();
	List<ArticlAllInfo> getAll ( String title, int start, int end);
	ArticlInfo getById (String id);

}
