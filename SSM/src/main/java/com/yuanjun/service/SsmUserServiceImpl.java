package com.yuanjun.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanjun.bean.SsmUser;
import com.yuanjun.bean.SsmUserExample;
import com.yuanjun.dao.SsmUserMapper;
import com.yuanjun.vo.UserInfo;


@Service
public class SsmUserServiceImpl implements SsmUserService {
	@Autowired
	private SsmUserMapper ssmUserMapper ;

	public SsmUserMapper getSsmUserMapper() {
		return ssmUserMapper;
	}

	public void setSsmUserMapper(SsmUserMapper ssmUserMapper) {
		this.ssmUserMapper = ssmUserMapper;
	}

	@Override
	public int insertSelective(SsmUser ssmUser) {
		
		return ssmUserMapper.insertSelective(ssmUser);
	}

	@Override
	public SsmUser selectByPhone(String phone) {
		
		return ssmUserMapper.selectByPhone(phone);
	}

	@Override
	public List<SsmUser> selectByPhoneAndPassword(String phone, String password) {
		
		return ssmUserMapper.selectByPhoneAndPassword(phone, password);
	}

	@Override
	public List<UserInfo> getUserinfoByPhone(String phone, int firstIndex, int lastIndex) {
		
		return  ssmUserMapper.getUserinfoByPhone(phone, firstIndex, lastIndex);
	}

	@Override
	public int getCount() {
		
		return ssmUserMapper.getCount();
	}

	@Override
	public int updateByPrimaryKeySelective(SsmUser ssmUser) {
		
		return ssmUserMapper.updateByPrimaryKeySelective(ssmUser);
	}

	@Override
	public List<SsmUser> selectByPrimaryKey(String userid) {
		// TODO Auto-generated method stub
		return ssmUserMapper.selectByPrimaryKey(userid);
	}

	@Override
	public UserInfo getUserInfoById(String userid) {
		
		return ssmUserMapper.getUserInfoById(userid);
	}

	@Override
	public List<SsmUser> selectByExample(SsmUserExample example) {
		
		return ssmUserMapper.selectByExample(example);
	}

	
	

}
