package com.yuanjun.dao;

import com.yuanjun.bean.SsmCode;
import com.yuanjun.bean.SsmCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SsmCodeMapper {
	int  deleteByEexpiretim(Long expiretime);
	SsmCode    selectByPhoneAndCodenum(@Param("phone") String phone, @Param("codenum") String codenum);
	List<SsmCode> selectByPhoneDesc (String phone);
	SsmCode selectByPhone(String phone);
    long countByExample(SsmCodeExample example);

    int deleteByExample(SsmCodeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SsmCode record);

    int insertSelective(SsmCode record);

    List<SsmCode> selectByExample(SsmCodeExample example);

    SsmCode selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SsmCode record, @Param("example") SsmCodeExample example);

    int updateByExample(@Param("record") SsmCode record, @Param("example") SsmCodeExample example);

    int updateByPrimaryKeySelective(SsmCode record);

    int updateByPrimaryKey(SsmCode record);
}