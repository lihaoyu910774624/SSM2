package com.yuanjun.service;

import com.yuanjun.bean.SsmQuestionChapter;
import com.yuanjun.bean.SsmQuestionChapterExample;
import com.yuanjun.vo.Catalog;
import com.yuanjun.vo.ChapterDto;
import com.yuanjun.vo.QuestionInfo;
import java.util.List;

public abstract interface SsmQuestionChapterService
{
  public abstract List<SsmQuestionChapter> selectByExample(SsmQuestionChapterExample paramSsmQuestionChapterExample);

  public abstract List<ChapterDto> getChapterByIdAndPid(String paramString1, String paramString2);

  public abstract List<Catalog> getCatalogByPid(String paramString);

  public abstract List<QuestionInfo> getAll(String paramString1, String paramString2, String paramString3, Integer paramInteger1, Integer paramInteger2);

  public abstract int updateByExampleSelective(SsmQuestionChapter paramSsmQuestionChapter, SsmQuestionChapterExample paramSsmQuestionChapterExample);

  public abstract int insertSelective(SsmQuestionChapter paramSsmQuestionChapter);

  public abstract QuestionInfo getById(String paramString);

  public abstract long countByExample(SsmQuestionChapterExample paramSsmQuestionChapterExample);
}