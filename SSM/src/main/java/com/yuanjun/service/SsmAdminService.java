package com.yuanjun.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuanjun.bean.SsmAdmin;
import com.yuanjun.bean.SsmAdminExample;

public interface SsmAdminService {
	
	 int insertSelective(SsmAdmin record);
	 List<SsmAdmin> selectByExample(SsmAdminExample example);
	 int updateByExampleSelective(@Param("record") SsmAdmin record, @Param("example") SsmAdminExample example);

}
