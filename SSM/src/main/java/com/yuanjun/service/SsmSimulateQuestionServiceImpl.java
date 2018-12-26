package com.yuanjun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanjun.bean.SsmSimulateQuestion;
import com.yuanjun.dao.SsmSimulateQuestionMapper;
@Service
public class SsmSimulateQuestionServiceImpl implements SsmSimulateQuestionService {
	@Autowired
	private SsmSimulateQuestionMapper ssmSimulateQuestionMapper ;

	@Override
	public int insertSelective(SsmSimulateQuestion record) {
		
		return ssmSimulateQuestionMapper.insertSelective(record);
	}

}
