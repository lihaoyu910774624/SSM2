package com.yuanjun.dao;

import com.yuanjun.bean.SsmQuestionChapter;
import com.yuanjun.bean.SsmQuestionChapterExample;
import com.yuanjun.vo.Catalog;
import com.yuanjun.vo.ChapterDto;
import com.yuanjun.vo.QuestionInfo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SsmQuestionChapterMapper {
	 List<ChapterDto>  getChapterByIdAndPid(@Param("categoryId") String categoryId , @Param("categoryPId") String categoryPId );
	 List<Catalog>   getCatalogByPid( String categoryPId );
	 QuestionInfo getById (String id);
     List<QuestionInfo> getAll(@Param("categoryId") String categoryId , @Param("categoryPId") String categoryPId ,
                                      @Param("title") String title,@Param("start")  Integer start,@Param("end") Integer end);
    long countByExample(SsmQuestionChapterExample example);

    int deleteByExample(SsmQuestionChapterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SsmQuestionChapter record);

    int insertSelective(SsmQuestionChapter record);

    List<SsmQuestionChapter> selectByExample(SsmQuestionChapterExample example);

    SsmQuestionChapter selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SsmQuestionChapter record, @Param("example") SsmQuestionChapterExample example);

    int updateByExample(@Param("record") SsmQuestionChapter record, @Param("example") SsmQuestionChapterExample example);

    int updateByPrimaryKeySelective(SsmQuestionChapter record);

    int updateByPrimaryKey(SsmQuestionChapter record);
}