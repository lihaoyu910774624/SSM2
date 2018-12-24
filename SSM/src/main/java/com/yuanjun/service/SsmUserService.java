package com.yuanjun.service;



import java.util.List;

import com.yuanjun.bean.SsmUser;
import com.yuanjun.bean.SsmUserExample;
import com.yuanjun.vo.UserInfo;



public interface SsmUserService {
	List<SsmUser> selectByExample(SsmUserExample example);
	UserInfo getUserInfoById(String userid);
	List<SsmUser>  selectByPrimaryKey(String userid);
	int updateByPrimaryKeySelective(SsmUser record);
	int getCount();
	List<UserInfo>  getUserinfoByPhone(String phone, int firstIndex, int lastIndex);
	List<SsmUser> selectByPhoneAndPassword(String phone, String password);
	int insertSelective (SsmUser ssmUser);
	SsmUser selectByPhone(String phone);
   
}
