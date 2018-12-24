package com.yuanjun.dao;

import com.yuanjun.bean.SsmCategory;
import com.yuanjun.bean.SsmCategoryExample;
import com.yuanjun.vo.CategoryInfo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SsmCategoryMapper {
	
	CategoryInfo  selectById (Integer id);
	List<CategoryInfo> selectAll (Integer pid);
    long countByExample(SsmCategoryExample example);

    int deleteByExample(SsmCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SsmCategory record);

    int insertSelective(SsmCategory record);

    List<SsmCategory> selectByExample(SsmCategoryExample example);

    SsmCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SsmCategory record, @Param("example") SsmCategoryExample example);

    int updateByExample(@Param("record") SsmCategory record, @Param("example") SsmCategoryExample example);

    int updateByPrimaryKeySelective(SsmCategory record);

    int updateByPrimaryKey(SsmCategory record);
}