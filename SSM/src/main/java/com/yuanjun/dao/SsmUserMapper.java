package com.yuanjun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuanjun.bean.SsmUser;
import com.yuanjun.bean.SsmUserExample;
import com.yuanjun.vo.UserInfo;

public interface SsmUserMapper {
	UserInfo getUserInfoById(String userid);
	int getCount();
	List<UserInfo>  getUserinfoByPhone(@Param("phone") String phone ,@Param("firstIndex") int firstIndex,@Param("lastIndex") int lastIndex);
	List<SsmUser>       selectByPhoneAndPassword(@Param("phone") String phone,@Param("password") String password);
	SsmUser selectByPhone(String phone);
    long countByExample(SsmUserExample example);

    int deleteByExample(SsmUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SsmUser record);

    int insertSelective(SsmUser record);

    List<SsmUser> selectByExample(SsmUserExample example);

    List<SsmUser>  selectByPrimaryKey(String userid);

    int updateByExampleSelective(@Param("record") SsmUser record, @Param("example") SsmUserExample example);

    int updateByExample(@Param("record") SsmUser record, @Param("example") SsmUserExample example);

    int updateByPrimaryKeySelective(SsmUser record);

    int updateByPrimaryKey(SsmUser record);
}