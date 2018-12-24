package com.yuanjun.dao;

import com.yuanjun.bean.SsmArticle;
import com.yuanjun.bean.SsmArticleExample;
import com.yuanjun.vo.ArticlAllInfo;
import com.yuanjun.vo.ArticlInfo;
import com.yuanjun.vo.articlvo.ArticlTitleId;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface SsmArticleMapper
{
  public abstract List<ArticlTitleId> getTitleAll(@Param("categoryId") String paramString);

  public abstract List<ArticlTitleId> getFive(@Param("categoryId") String paramString);

  public abstract Integer getCount();

  public abstract List<ArticlAllInfo> getAll(@Param("title") String paramString, @Param("start") int paramInt1, @Param("end") int paramInt2);

  public abstract ArticlInfo getById(String paramString);

  public abstract long countByExample(SsmArticleExample paramSsmArticleExample);

  public abstract int deleteByExample(SsmArticleExample paramSsmArticleExample);

  public abstract int deleteByPrimaryKey(Integer paramInteger);

  public abstract int insert(SsmArticle paramSsmArticle);

  public abstract int insertSelective(SsmArticle paramSsmArticle);

  public abstract List<SsmArticle> selectByExampleWithBLOBs(SsmArticleExample paramSsmArticleExample);

  public abstract List<SsmArticle> selectByExample(SsmArticleExample paramSsmArticleExample);

  public abstract SsmArticle selectByPrimaryKey(Integer paramInteger);

  public abstract int updateByExampleSelective(@Param("record") SsmArticle paramSsmArticle, @Param("example") SsmArticleExample paramSsmArticleExample);

  public abstract int updateByExampleWithBLOBs(@Param("record") SsmArticle paramSsmArticle, @Param("example") SsmArticleExample paramSsmArticleExample);

  public abstract int updateByExample(@Param("record") SsmArticle paramSsmArticle, @Param("example") SsmArticleExample paramSsmArticleExample);

  public abstract int updateByPrimaryKeySelective(SsmArticle paramSsmArticle);

  public abstract int updateByPrimaryKeyWithBLOBs(SsmArticle paramSsmArticle);

  public abstract int updateByPrimaryKey(SsmArticle paramSsmArticle);
}