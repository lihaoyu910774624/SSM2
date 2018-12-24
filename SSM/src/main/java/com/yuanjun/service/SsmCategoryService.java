package com.yuanjun.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuanjun.bean.SsmCategory;
import com.yuanjun.bean.SsmCategoryExample;
import com.yuanjun.vo.CategoryInfo;

public interface SsmCategoryService {
	
	CategoryInfo  selectById (Integer id);
	
	List<CategoryInfo> selectAll (Integer id);

	 int updateByExampleSelective(@Param("record") SsmCategory record, @Param("example") SsmCategoryExample example);

	int insertSelective(SsmCategory record);

	List<SsmCategory> selectByExample(SsmCategoryExample example);

	SsmCategory selectByPrimaryKey(Integer id);

}
